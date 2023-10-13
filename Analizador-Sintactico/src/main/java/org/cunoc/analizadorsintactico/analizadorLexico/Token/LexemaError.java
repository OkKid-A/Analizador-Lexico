package org.cunoc.analizadorsintactico.analizadorLexico.Token;

import java.awt.*;

public class LexemaError {

    private String lexema;
    private Dimension posicion;

    public LexemaError(String lexema, Dimension posicion){
        this.lexema = lexema;
        this.posicion = posicion;
    }

    public String getLexema() {
        return lexema;
    }

    public int getColumna() {
        return (int) posicion.getWidth();
    }

    public int getFila(){
        return (int) posicion.getHeight();
    }
}
