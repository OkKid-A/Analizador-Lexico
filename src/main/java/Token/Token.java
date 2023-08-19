package main.java.Token;

import java.awt.*;

public class Token {

    private String lexema;
    private String tipo;
    private String patron;
    private Dimension posicion;

    public Token(Dimension posicion, TipoToken tipoToken, String patron, String lexema){

    }

    public String getLexema() {
        return lexema;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPatron() {
        return patron;
    }

    public Dimension getPosicion() {
        return posicion;
    }
}
