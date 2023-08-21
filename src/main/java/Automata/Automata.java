package main.java.Automata;

import main.java.Estado.Estado;
import main.java.Token.Diccionario;
import main.java.Token.Simbolo;
import main.java.Token.TipoToken;
import main.java.Token.Token;

import java.awt.*;
import java.util.ArrayList;

public class Automata {

    private MatrizTransiciones matriz;
    private Estado estadoActual;
    private Estado[] listaEstados;
    private Estado estadoInicial;
    private String lexemaActual;
    private Diccionario diccionario;
    private int columnaActual;
    private int filaActual;
    private TablaDeSimbolos tablaDeSimbolos;
    private char[] textoAnalizar;
    private boolean completo;

    public Automata(int[][] transiciones, Estado[] listaEstados){
        this.matriz = new MatrizTransiciones(transiciones);
        this.diccionario = new Diccionario();
        this.lexemaActual = "";
        this.tablaDeSimbolos = new TablaDeSimbolos();
        this.listaEstados = listaEstados;
        this.estadoInicial = listaEstados[0];
        this.estadoActual = listaEstados[0];
    }

    public ArrayList<Token> analizar(char[] texto){
        this.lexemaActual = "";
        textoAnalizar = texto;
        this.tablaDeSimbolos = new TablaDeSimbolos();
        int columnaInicio = 1;
        int filaInicio = 1;
        columnaActual = columnaInicio;
        filaActual = filaInicio;
        estadoActual = estadoInicial;
        matriz.setEstadoActual(estadoActual.getNumeroEstado());
        for (int i = 0; i < texto.length;i++) {
            char actual = texto[i];
            avanzarChar(actual);
            try {
                avanzarEstado(actual,i);
            } catch (IndexOutOfBoundsException e){
                completarToken(columnaInicio,filaInicio,actual, i);
                columnaInicio = columnaActual;
                filaInicio = filaActual;
            }
            if (i == texto.length-1){
            }
        }
        return tablaDeSimbolos.getTabla();
    }

    public void avanzarChar(char c){
        char next = c;
        if (next == ' '){
            filaActual++;
        } else if (next == '\n'){
            filaActual = 1;
            columnaActual++;
        } else {
            filaActual++;
        }
    }

    public void avanzarEstado(char c, int posicion){
        Simbolo simbolo = Simbolo.SALTO.clasificarSimbolo(c);
        int nuevoEstado = matriz.transicionar(simbolo.getNumeroSimbolo());
        if (posicion == textoAnalizar.length-1 && nuevoEstado != -1){
            lexemaActual = lexemaActual + c;
            estadoActual = listaEstados[nuevoEstado];
            completo = true;
            throw new IndexOutOfBoundsException();
        } else if (nuevoEstado != -1) {
            lexemaActual = lexemaActual + c;
            estadoActual = listaEstados[nuevoEstado];
        } else {
            completo = false;
            throw new IndexOutOfBoundsException();

        }
    }

    public void clasificarToken(){

    }

    public void completarToken(int columnaInicio, int filaInicio, char actual, int posicionTexto){
        TipoToken tipoToken = estadoActual.getTipoToken();
        String patron = null;
        Dimension posicion = new Dimension(columnaInicio,filaInicio);
        if (estadoActual.isFinal()){
            if(tipoToken == TipoToken.BOOLEANO || tipoToken == TipoToken.KEYWORD || tipoToken == TipoToken.LOGICOS){
                try {
                    patron = diccionario.buscar(lexemaActual);
                } catch (NullPointerException e){
                    tipoToken = TipoToken.IDENTIFICADOR;
                    patron = "IDENTIFICADOR";
                }
            } else {
                patron = String.valueOf(estadoActual.getTipoToken().getExpresionRegular());
            }
            tablaDeSimbolos.addToken(posicion,tipoToken,patron,lexemaActual);
        } else if (!lexemaActual.equals(" ")){
            tablaDeSimbolos.addError(posicion,lexemaActual);
            System.out.println(lexemaActual);
        }
        limpiarLexema(actual,posicionTexto);
    }

    public void limpiarLexema(char actual, int siguiente){
        matriz.setEstadoActual(0);
        estadoActual = estadoInicial;
        analizarPosibleToken(actual, siguiente);
    }


    public void analizarPosibleToken(char c, int posicionActual){
        Simbolo simbolo = Simbolo.SALTO.clasificarSimbolo(c);
        Estado estadoProvicional = null;
        try {
            estadoProvicional = listaEstados[matriz.getTransicion(0, simbolo.getNumeroSimbolo()).getEstadoOut()];
            try {
                if (!completo) {
                    Simbolo siguiente = simbolo.clasificarSimbolo(textoAnalizar[posicionActual + 1]);
                    Estado estadoSiguiente = listaEstados[matriz.getTransicion(estadoProvicional.getNumeroEstado(), siguiente.getNumeroSimbolo()).getEstadoOut()];
                    estadoActual = estadoProvicional;
                    matriz.setEstadoActual(estadoActual.getNumeroEstado());
                    lexemaActual = String.valueOf(c);
                }
            } catch (IndexOutOfBoundsException e){
                tablaDeSimbolos.addToken(new Dimension(columnaActual,filaActual),estadoProvicional.getTipoToken(),
                        String.valueOf(estadoProvicional.getTipoToken().getExpresionRegular()),String.valueOf(c));
                lexemaActual = "";

            }
        } catch (IndexOutOfBoundsException e){
            tablaDeSimbolos.addError(new Dimension(columnaActual,filaActual),String.valueOf(c));
            lexemaActual = "";
        }



    }

    public void limpiar(){

    }

}
