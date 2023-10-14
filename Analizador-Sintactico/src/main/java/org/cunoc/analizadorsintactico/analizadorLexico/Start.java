package org.cunoc.analizadorsintactico.analizadorLexico;

import org.cunoc.analizadorsintactico.analizadorLexico.Automata.Automata;
import org.cunoc.analizadorsintactico.analizadorLexico.Estado.Estado;
import org.cunoc.analizadorsintactico.analizadorLexico.Token.Simbolo;
import org.cunoc.analizadorsintactico.analizadorLexico.Token.TipoToken;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Start {

    private Estado[] listaEstados;
    private int[][] transiciones;
    public static void main(String[] args) {

        Start start = new Start();
        start.setTransiciones();
        start.setListaEstados();
        Automata automata = new Automata(start.transiciones, start.listaEstados);

    }

    public Estado[] setListaEstados(){
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
        return listaEstados;
    }

    public int[][] setTransiciones() {
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
        transiciones[9] = new int[]{19,19,19,19,19,19,19,19,19,19,0,19,19,19,19,19};
        transiciones[10] = new int[]{20,20,20,20,20,20,20,20,20,20,20,0,20,20,20,20};
        transiciones[12] = new int[]{21,21,21,21,21,21,21,21,21,21,21,21,21,21,0,21};
        transiciones[15][Simbolo.DIGITO.getNumeroSimbolo()] = 15;
        transiciones[19] = new int[]{19,19,19,19,19,19,19,19,19,19,13,19,19,19,19,19};
        transiciones[20] = new int[]{20,20,20,20,20,20,20,20,20,20,20,13,20,20,20,20};
        transiciones[21] = new int[]{21,21,21,21,21,21,21,21,21,21,21,21,21,14,21,21};
        transiciones[23][Simbolo.IGUAL.getNumeroSimbolo()] = 18;
        System.out.println(transiciones[0][15]);
        return transiciones;
    }

    public ArrayList<String> setTerminales(){
        ArrayList<String> terminales = new ArrayList<>();
        terminales.add("\n");
        terminales.add("break");
        terminales.add("COMENTARIO");
        terminales.add("=");
        terminales.add(",");
        terminales.add("if");
        terminales.add("elif");
        terminales.add("else");
        terminales.add("while");
        terminales.add("or");
        terminales.add("not");
        terminales.add("==");
        terminales.add("!=");
        terminales.add("<=");
        terminales.add("<");
        terminales.add(">=");
        terminales.add(">");
        terminales.add("+");
        terminales.add("-");
        terminales.add("*");
        terminales.add("**");
        terminales.add("%");
        terminales.add("/");
        terminales.add(".");
        terminales.add("(");
        terminales.add(")");
        terminales.add("{");
        terminales.add("}");
        terminales.add("[");
        terminales.add("]");
        terminales.add("IDENTIFICADOR");
        terminales.add("");
        terminales.add("ENTERO");
        terminales.add("DECIMAL");
        terminales.add("True");
        terminales.add("False");
        terminales.add("CADENA");
        terminales.add("+=");
        terminales.add("-=");
        terminales.add("*=");
        terminales.add("%=");
        terminales.add("**=");
        terminales.add("//=");
        terminales.add("for");
        terminales.add("def");
        terminales.add(":");
        terminales.add("return");
        terminales.add("$");
        terminales.add("|");
        terminales.add("&");
        terminales.add("in");
        return terminales;
    }

    public ArrayList<String> setNoTerminales() {
        ArrayList<String> noTerminales = new ArrayList<>();
        noTerminales.add("S''");
        noTerminales.add("S'");
        noTerminales.add("S");
        noTerminales.add("B");
        noTerminales.add("E'");
        noTerminales.add("E");
        noTerminales.add("A");
        noTerminales.add("A'");
        noTerminales.add("O");
        noTerminales.add("T");
        noTerminales.add("T'");
        noTerminales.add("D");
        noTerminales.add("EXP");
        noTerminales.add("D'");
        noTerminales.add("C");
        noTerminales.add("I");
        noTerminales.add("C'");
        noTerminales.add("G");
        noTerminales.add("G'");
        noTerminales.add("BO");
        noTerminales.add("CO");
        noTerminales.add("BOR");
        noTerminales.add("BO'");
        noTerminales.add("BOR'");
        noTerminales.add("SUMA");
        noTerminales.add("SUMA'");
        noTerminales.add("F");
        noTerminales.add("P");
        noTerminales.add("P'");
        noTerminales.add("E''");
        noTerminales.add("Z");
        noTerminales.add("Z''");
        noTerminales.add("M'");
        noTerminales.add("Z'''");
        noTerminales.add("B");
        noTerminales.add("IF");
        noTerminales.add("FOR");
        noTerminales.add("WHILE");
        noTerminales.add("DEF");
        noTerminales.add("ELIF");
        noTerminales.add("W'");
        noTerminales.add("JSON");
        noTerminales.add("J");
        noTerminales.add("J'");
        noTerminales.add("ARRAY");
        noTerminales.add("ARRAY'");
        noTerminales.add("M''");
        noTerminales.add("M");
        noTerminales.add("M'''");
        noTerminales.add("X");
        noTerminales.add("X'");
        return noTerminales;
    }

    public Map<String, ArrayList<String>> setProducciones(){
        Map<String,ArrayList<String>> producciones = new HashMap<>();
        String[] ladoDerecho = new String[]{"S S' $"};        ;
        producciones.put("S''",convertir(ladoDerecho));
        ladoDerecho = new String[]{"S S'",""};
        producciones.put("S'",convertir(ladoDerecho));
        ladoDerecho = new String[]{"B","EXP"};
        producciones.put("S",convertir(ladoDerecho));
        ladoDerecho = new String[]{"A'","break","COMENTARIO"};
        producciones.put("EXP",convertir(ladoDerecho));
        ladoDerecho = new String[]{", A' , T","= T", "O T"};
        producciones.put("A",convertir(ladoDerecho));
        ladoDerecho = new String[]{"IDENTIFICADOR A"};
        producciones.put("A'",convertir(ladoDerecho));
        ladoDerecho = new String[]{"D T'"};
        producciones.put("T",convertir(ladoDerecho));
        ladoDerecho = new String[]{"if D else EXP",""};
        producciones.put("T'",convertir(ladoDerecho));
        ladoDerecho = new String[]{"C D'"};
        producciones.put("D",convertir(ladoDerecho));
        ladoDerecho = new String[]{"or D",""};
        producciones.put("D'",convertir(ladoDerecho));
        ladoDerecho = new String[]{"I C'"};
        producciones.put("C",convertir(ladoDerecho));
        ladoDerecho = new String[]{"and C",""};
        producciones.put("C'",convertir(ladoDerecho));
        ladoDerecho = new String[]{"not I", "G"};
        producciones.put("I",convertir(ladoDerecho));
        ladoDerecho = new String[]{"BO G'"};
        producciones.put("G",convertir(ladoDerecho));
        ladoDerecho = new String[]{"CO",""};
        producciones.put("G'",convertir(ladoDerecho));
        ladoDerecho = new String[]{"== BO", "!= BO", "<= BO", "< BO", ">= BO", "> BO"};
        producciones.put("CO",convertir(ladoDerecho));
        ladoDerecho = new String[]{"BOR BO'"};
        producciones.put("BO",convertir(ladoDerecho));
        ladoDerecho = new String[]{"| BOR BO'", ""};
        producciones.put("BO'",convertir(ladoDerecho));
        ladoDerecho = new String[]{"SUMA BOR'"};
        producciones.put("BOR",convertir(ladoDerecho));
        ladoDerecho = new String[]{"& SUMA BOR'", ""};
        producciones.put("BOR'",convertir(ladoDerecho));
        ladoDerecho = new  String[] {"F SUMA'"};
        producciones.put("SUMA",convertir(ladoDerecho));
        ladoDerecho = new String[]{"+ F SUMA'","- E SUMA'",""};
        producciones.put("SUMA'",convertir(ladoDerecho));
        ladoDerecho = new String[]{"CADENA","E"};
        producciones.put("F",convertir(ladoDerecho));
        ladoDerecho = new String[]{"P E'"};
        producciones.put("E",convertir(ladoDerecho));
        ladoDerecho = new String[]{"* P E'", "% P E'","E'' / P E'",""};
        producciones.put("E'",convertir(ladoDerecho));
        ladoDerecho = new String[]{"/",""};
        producciones.put("E''",convertir(ladoDerecho));
        ladoDerecho = new String[]{"Z P'"};
        producciones.put("P",convertir(ladoDerecho));
        ladoDerecho = new String[]{"** F P'",""};
        producciones.put("P'",convertir(ladoDerecho));
        ladoDerecho = new String[]{"Z'' Z'''"};
        producciones.put("Z",convertir(ladoDerecho));
        ladoDerecho = new String[]{". IDENTIFICADOR Z'''", "( M ) Z'''", ""};
        producciones.put("Z'''",convertir(ladoDerecho));
        ladoDerecho = new String[]{"ENTERO","DECIMAL","True","False","( SUMA )","X","JSON","ARRAY"};
        producciones.put("Z''",convertir(ladoDerecho));
        ladoDerecho = new String[]{"+=","-=","*=","/=","%=","**=","//="};
        producciones.put("O",convertir(ladoDerecho));
        ladoDerecho = new String[]{"IF","FOR","WHILE","DEF"};
        producciones.put("B",convertir(ladoDerecho));
        ladoDerecho = new String[]{"if D : S' ELIF"};
        producciones.put("IF",convertir(ladoDerecho));
        ladoDerecho = new String[]{"elif D : S' ELIF", "else : S'",""};
        producciones.put("ELIF",convertir(ladoDerecho));
        ladoDerecho = new String[]{"while D : S' W'"};
        producciones.put("WHILE",convertir(ladoDerecho));
        ladoDerecho = new String[]{"else : S'",""};
        producciones.put("W'",convertir(ladoDerecho));
        ladoDerecho = new String[]{"for IDENTIFICADOR in T : S' W'"};
        producciones.put("FOR",convertir(ladoDerecho));
        ladoDerecho = new String[]{"def IDENTIFICADOR ( M' ) : S'"};
        producciones.put("DEF",convertir(ladoDerecho));
        ladoDerecho = new String[]{"{ J' }"};
        producciones.put("JSON",convertir(ladoDerecho));
        ladoDerecho = new String[]{"J J'",""};
        producciones.put("J'",convertir(ladoDerecho));
        ladoDerecho = new String[]{"T : T"};
        producciones.put("J",convertir(ladoDerecho));
        ladoDerecho = new String[]{"[ ARRAY'' ]"};
        producciones.put("ARRAY",convertir(ladoDerecho));
        ladoDerecho = new String[]{"T ARRAY'",""};
        producciones.put("ARRAY''",convertir(ladoDerecho));
        ladoDerecho = new String[]{", T ARRAY'",""};
        producciones.put("ARRAY'",convertir(ladoDerecho));
        ladoDerecho = new String[]{"IDENTIFICADOR M''"};
        producciones.put("M'",convertir(ladoDerecho));
        ladoDerecho = new String[]{", IDENTIFICADOR M''",""};
        producciones.put("M''",convertir(ladoDerecho));
        ladoDerecho = new String[]{"T M'''"};
        producciones.put("M",convertir(ladoDerecho));
        ladoDerecho = new String[]{", T M'''",""};
        producciones.put("M'''",convertir(ladoDerecho));
        ladoDerecho = new String[]{"IDENTIFICADOR X'"};
        producciones.put("X",convertir(ladoDerecho));
        ladoDerecho = new String[]{"( M )",""};
        producciones.put("X'",convertir(ladoDerecho));
        return producciones;
    }

    public ArrayList<String> convertir(String[] strings){
        return new ArrayList<String>(Arrays.asList(strings));
    }
}