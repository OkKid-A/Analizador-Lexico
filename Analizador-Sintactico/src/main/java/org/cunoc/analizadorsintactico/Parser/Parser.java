package org.cunoc.analizadorsintactico.Parser;

import java.util.*;

public class Parser {

    private ArrayList<String> terminales;
    private ArrayList<String> noTerminales;
    private String simboloInicio;
    private Map<String, ArrayList<String>> producciones;
    private TablaTransiciones tablaTransiciones;
    public final static String EPSILON = "";

    public Parser(ArrayList<String> terminales, ArrayList<String> noTerminales, Map<String, ArrayList<String>> producciones, String simboloInicio) {
        this.terminales = terminales;
        this.noTerminales = noTerminales;
        this.producciones = producciones;
        this.simboloInicio = simboloInicio;
        tablaTransiciones = new TablaTransiciones(terminales,noTerminales,simboloInicio,producciones);
    }

    public void Analizar(){

    }
}
