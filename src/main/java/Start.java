package main.java;

import main.java.Automata.Automata;
import main.java.Componentes.Graficador;
import main.java.Estado.Estado;
import main.java.Token.Simbolo;
import main.java.Token.TipoToken;
import main.java.UI.VentanaPrincipal;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Start {

    private Estado[] listaEstados;
    private int[][] transiciones;
    public static void main(String[] args) {

        Start start = new Start();
        start.setTransiciones();
        start.setListaEstados();
        Automata automata = new Automata(start.transiciones, start.listaEstados);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(automata);
            }
        });
    }

    private void setListaEstados(){
        this.listaEstados = new Estado[24];
        listaEstados[0] = new Estado(0);
        listaEstados[1] = new Estado(1,TipoToken.KEYWORD);
        listaEstados[2] = new Estado(2,TipoToken.ENTERO);
        listaEstados[3] = new Estado(3,TipoToken.IDENTIFICADOR);
        listaEstados[4] = new Estado(4,TipoToken.ARITMETICO);
        listaEstados[5] = new Estado(5,TipoToken.ARITMETICO);
        listaEstados[6] = new Estado(6,TipoToken.ARITMETICO);
        listaEstados[7] = new Estado(7,TipoToken.ASIGNADOR);
        listaEstados[8] = new Estado(8);
        listaEstados[9] = new Estado(9);
        listaEstados[10] = new Estado(10);
        listaEstados[11] = new Estado(11,TipoToken.OTROS);
        listaEstados[12] = new Estado(12);
        listaEstados[13] = new Estado(13,TipoToken.CADENA);
        listaEstados[14] = new Estado(14,TipoToken.COMENTARIO);
        listaEstados[15] = new Estado(15,TipoToken.DECIMAL);
        listaEstados[16] = new Estado(16,TipoToken.ARITMETICO);
        listaEstados[17] = new Estado(17,TipoToken.ARITMETICO);
        listaEstados[18] = new Estado(18,TipoToken.COMPARADOR);
        listaEstados[19] = new Estado(19);
        listaEstados[20] = new Estado(20);
        listaEstados[21] = new Estado(21,TipoToken.COMENTARIO);
        listaEstados[22] = new Estado(22,TipoToken.ASIGNADOR);
        listaEstados[23] = new Estado(23,TipoToken.ASIGNADOR);
    }

    public void setTransiciones() {
        this.transiciones = new int[24][16];
        transiciones[0] = new int[]{1,3,2,4,5,6,7,8,23,11,9,10,12,0,11,0};
        transiciones[1][Simbolo.LETRA.getNumeroSimbolo()] = 1;
        transiciones[1][Simbolo.DIGITO.getNumeroSimbolo()] = 3;
        transiciones[1][Simbolo.GUION.getNumeroSimbolo()] = 3;
        transiciones[2][Simbolo.DIGITO.getNumeroSimbolo()] = 2;
        transiciones[2][Simbolo.PUNTO.getNumeroSimbolo()] = 15;
        transiciones[3][Simbolo.GUION.getNumeroSimbolo()]=transiciones[3][Simbolo.LETRA.getNumeroSimbolo()]=
                transiciones[3][Simbolo.DIGITO.getNumeroSimbolo()]= 3;
        transiciones[4][Simbolo.IGUAL.getNumeroSimbolo()] = 22;
        transiciones[5][Simbolo.IGUAL.getNumeroSimbolo()] = 22;
        transiciones[5][Simbolo.ASTERISCO.getNumeroSimbolo()] = 16;
        transiciones[6][Simbolo.IGUAL.getNumeroSimbolo()] = 22;
        transiciones[6][Simbolo.DIAGONAL.getNumeroSimbolo()] = 17;
        transiciones[7][Simbolo.IGUAL.getNumeroSimbolo()]=transiciones[8][Simbolo.IGUAL.getNumeroSimbolo()]=
                transiciones[23][Simbolo.IGUAL.getNumeroSimbolo()] = 18 ;
        transiciones[9] = new int[]{19,19,19,19,19,19,19,19,19,19,0,19,19,19,19,21};
        transiciones[10] = new int[]{20,20,20,20,20,20,20,20,20,20,20,0,20,20,20,21};
        transiciones[12] = new int[]{21,21,21,21,21,21,21,21,21,21,21,21,21,21,0,21};
        transiciones[15][Simbolo.DIGITO.getNumeroSimbolo()] = 15;
        transiciones[19] = new int[]{19,19,19,19,19,19,19,19,19,19,13,19,19,19,19,19};
        transiciones[20] = new int[]{20,20,20,20,20,20,20,20,20,20,20,13,20,20,20,20};
        transiciones[21] = new int[]{21,21,21,21,21,21,21,21,21,21,21,21,21,14,21,21};
        transiciones[23][Simbolo.IGUAL.getNumeroSimbolo()] = 18;
        System.out.println(transiciones[0][15]);
    }
}