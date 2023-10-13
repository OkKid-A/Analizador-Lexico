package main.java.Componentes;

import guru.nidi.graphviz.attribute.*;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.GraphvizProcessor;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.LinkSource;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.Node;
import org.w3c.dom.Text;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.List;
import java.util.Random;

import static guru.nidi.graphviz.attribute.Rank.RankDir.LEFT_TO_RIGHT;
import static guru.nidi.graphviz.model.Factory.*;

public class Graficador {

    private Graphviz graphviz;

    public Graficador(){
        crearDir();
    }

    public void crearGraph(String nombreGraph, char[] caracteres){
        Node[] nodos = crearNodos(caracteres);
        Graph g =  graph(nombreGraph).directed().graphAttr().with(Rank.dir(LEFT_TO_RIGHT))
                .nodeAttr().with(Font.name("Times-Roman")).linkAttr().with("class","link-class");
        for (int i = 0; i < caracteres.length; i++){
            Node vacio = node(" ");
            vacio = vacio.with(Shape.CIRCLE);
            g=g.with(vacio);

            if(i == 0 && caracteres.length == 1){
                nodos[i] = nodos[i].with(Shape.DOUBLE_CIRCLE);
                g=g.with(vacio.link(nodos[i]));
            } else if (i == 0){
                g=g.with(vacio.link(nodos[i]));
            }else if (i < caracteres.length-1){
                g=g.with(nodos[i-1].link(nodos[i]));
            } else {
                nodos[i] = nodos[i].with(Shape.DOUBLE_CIRCLE);
                g=g.with(nodos[i-1].link(nodos[i]));
            }
        }
        try {
            Graphviz.fromGraph(g).height(100).render(Format.PNG).toFile(new File("Graficos"+ FileSystems.getDefault().getSeparator()+nombreGraph+".png"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Node[] crearNodos(char[] caracteres){
        Node[] nodos = new Node[caracteres.length];
        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] == '\n'){
                nodos[i] = node(String.valueOf(i));
                nodos[i] = nodos[i].with("label", "LF");
                nodos[i] = nodos[i].with(Shape.CIRCLE);
            } else {
                nodos[i] = node(String.valueOf(i));
                nodos[i] = nodos[i].with("label", caracteres[i]);
                nodos[i] = nodos[i].with(Shape.CIRCLE);
            }
        }
        return nodos;
    }


    private void crearDir(){
        new File("Graficos").mkdirs();
    }
}
