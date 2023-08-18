package main.java.Automata;

import main.java.Estado.Estado;
import main.java.Token.Diccionario;
import main.java.Token.Simbolo;
import main.java.Token.TipoToken;
import main.java.Token.Token;

import java.awt.*;

public class Automata {

    private MatrizTransiciones matriz;
    private Estado estadoActual;
    private Estado[] listaEstados;
    private String estadoInicial;
    private String lexemaActual;
    private Diccionario diccionario;
    private int columnaActual;
    private int filaActual;

    public Automata(int[][] transiciones, Estado[] listaEstados){
        this.matriz = new MatrizTransiciones(transiciones);
        this.diccionario = new Diccionario();
        this.lexemaActual = "";


        int columnaInicio = columnaActual;
        int filaInicio = filaActual;
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

    public void completarToken(int columnaInicio, int filaInicio){
        TipoToken tipoToken = estadoActual.getTipoToken();
        String patron = null;
        Dimension posicion = new Dimension(columnaActual,filaActual);
        if (estadoActual.isFinal()){
            if(tipoToken == TipoToken.BOOLEANO || tipoToken == TipoToken.KEYWORD || tipoToken == TipoToken.LOGICOS){
                try {
                    patron = diccionario.buscar(lexemaActual);
                } catch (NullPointerException e){

                }
            }
        }
    }

}
