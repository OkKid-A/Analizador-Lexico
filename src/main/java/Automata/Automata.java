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
    private String estadoInicial;
    private String lexemaActual;
    private Diccionario diccionario;
    private int columnaActual;
    private int filaActual;
    private TablaDeSimbolos tablaDeSimbolos;

    public Automata(int[][] transiciones, Estado[] listaEstados){
        this.matriz = new MatrizTransiciones(transiciones);
        this.diccionario = new Diccionario();
        this.lexemaActual = "";
        this.tablaDeSimbolos = new TablaDeSimbolos();
        this.listaEstados = listaEstados;
        this.estadoActual = listaEstados[0];
    }

    public ArrayList<Token> analizar(char[] texto){
        int columnaInicio = 1;
        int filaInicio = 1;
        for (int i = 0; i < texto.length;i++) {
            char actual = texto[i];
            avanzarChar(actual);
            try {
                avanzarEstado(actual);
            } catch (IndexOutOfBoundsException e){
                completarToken(columnaInicio,filaInicio);
                columnaInicio = columnaActual;
                filaInicio = filaActual;
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
        }
    }

    public void avanzarEstado(char c){
        Simbolo simbolo = Simbolo.SALTO.clasificarSimbolo(c);
        int nuevoEstado = matriz.transicionar(simbolo.getNumeroSimbolo());
        if (nuevoEstado != -1) {
            lexemaActual = lexemaActual + c;
            estadoActual = listaEstados[nuevoEstado];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void clasificarToken(){

    }

    public void completarToken(int columnaInicio, int filaInicio){
        TipoToken tipoToken = estadoActual.getTipoToken();
        String patron = null;
        Dimension posicion = new Dimension(columnaInicio,filaInicio);
        if (estadoActual.isFinal()){
            if(tipoToken == TipoToken.BOOLEANO || tipoToken == TipoToken.KEYWORD || tipoToken == TipoToken.LOGICOS){
                try {
                    patron = diccionario.buscar(lexemaActual);
                } catch (NullPointerException e){
                    patron = "Identificador";
                }
            } else {
                patron = String.valueOf(estadoActual.getTipoToken());
            }
            tablaDeSimbolos.addToken(posicion,estadoActual.getTipoToken(),patron,lexemaActual);
        } else {
            tablaDeSimbolos.addError(posicion,lexemaActual);
        }
    }

    public void limpiar(){

    }

}
