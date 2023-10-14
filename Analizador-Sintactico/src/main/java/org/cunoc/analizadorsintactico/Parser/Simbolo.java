package org.cunoc.analizadorsintactico.Parser;

import java.awt.*;

public class Simbolo {

    private TipoSintactico tipoSintactico;
    private String lexema;
    private Object valor;
    private Dimension posicion;

    public Simbolo(TipoSintactico tipoSintactico, String lexema, Object valor, Dimension posicion) {
        this.tipoSintactico = tipoSintactico;
        this.lexema = lexema;
        this.valor = valor;
        this.posicion = posicion;
    }

    public Simbolo() {
    }

    public TipoSintactico getTipoSintactico() {
        return tipoSintactico;
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
}
