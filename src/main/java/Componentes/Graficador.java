package main.java.Componentes;

import guru.nidi.graphviz.attribute.Color;
import guru.nidi.graphviz.attribute.Font;
import guru.nidi.graphviz.attribute.Rank;
import guru.nidi.graphviz.attribute.Shape;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.GraphvizProcessor;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.LinkSource;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.Node;

import java.io.File;
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
        Node a = node("a");
        a = node(String.valueOf(caracteres[0]));
        for (int i = 0; i < caracteres.length; i++){
            if (i == 0){
                g=g.with(node(String.valueOf(caracteres[i])));
            } else if (i < caracteres.length-1){
                g=g.with(nodos[i-1].link(nodos[i]));
            } else {
                nodos[i] = nodos[i].with(Shape.CIRCLE);
                g=g.with(nodos[i-1].link(nodos[i]));
            }
        }
        try {
            Graphviz.fromGraph(g).height(100).render(Format.PNG).toFile(new File(nombreGraph+".png"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Node[] crearNodos(char[] caracteres){
        Node[] nodos = new Node[caracteres.length];
        for (int i = 0; i < caracteres.length; i++) {
            nodos[i] = node(String.valueOf(caracteres[i]));
        }
        return nodos;
    }


    private void crearDir(){
        new File("Graficos").mkdirs();
    }
}
