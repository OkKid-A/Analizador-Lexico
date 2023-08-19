package main.java.Automata;

import main.java.Estado.Estado;
import main.java.Token.Simbolo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class MatrizTransiciones {

    private Transicion[][] matriz;
    private int estadoActual;

    public MatrizTransiciones(int[][] transiciones){
        crearMatriz(transiciones);
    }

    public int transicionar(int simbolo){
        this.estadoActual = matriz[estadoActual][simbolo].getEstadoOut();
        return estadoActual;
    }

    public void crearMatriz(int[][] transiciones){
        this.matriz = new Transicion[transiciones.length][12];
        for (int i = 0; i < transiciones.length; i++){
            for (int k = 0; k < 12; k++){
                if (transiciones[i][k] != 0){
                    matriz[i][k] = new Transicion(i,transiciones[i][k]);
                } else {
                    matriz[i][k] = new Transicion(i,-1);
                }
            }
        }
    }
}
