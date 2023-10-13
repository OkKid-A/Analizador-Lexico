package org.cunoc.analizadorsintactico.analizadorLexico.Automata;

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

    public void setEstadoActual(int estadoActual) {
        this.estadoActual = estadoActual;
    }

    public void crearMatriz(int[][] transiciones){
        this.matriz = new Transicion[transiciones.length][16];
        for (int i = 0; i < transiciones.length; i++){
            for (int k = 0; k < 16; k++){
                if (transiciones[i][k] != 0){
                    matriz[i][k] = new Transicion(i,transiciones[i][k]);
                } else {
                    matriz[i][k] = new Transicion(i,-1);
                }
            }
        }
    }

    public Transicion getTransicion(int estado, int simbolo) {
        return matriz[estado][simbolo];
    }
}
