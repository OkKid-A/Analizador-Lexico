package org.cunoc.analizadorsintactico.Parser;

import java.awt.*;

public class Simbolo {

    private TipoSintactico tipoSintactico;
    private String lexema;
    private Object valor;
    private Dimension posicion;
    private int bloque;

    public Simbolo(TipoSintactico tipoSintactico, String lexema, Object valor, Dimension posicion, int bloque) {
        this.tipoSintactico = tipoSintactico;
        this.lexema = lexema;
        this.valor = valor;
        this.posicion = posicion;
        this.bloque = bloque;
    }

    public Simbolo() {
    }

    public TipoSintactico getTipoSintactico() {
        return tipoSintactico;
    }

    public String getTipo(){
        return tipoSintactico.toString();
    }

    public void setTipoSintactico(TipoSintactico tipoSintactico) {
        this.tipoSintactico = tipoSintactico;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Dimension getPosicion() {
        return posicion;
    }

    public void setPosicion(Dimension posicion) {
        this.posicion = posicion;
    }

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    public double getLinea(){
       return this.posicion.getHeight();
    }

    public double getColumna(){
        return posicion.getWidth();
    }
}
