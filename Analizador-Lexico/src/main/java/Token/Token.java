package main.java.Token;

import java.awt.*;

public class Token {

    private String lexema;
    private String tipo;
    private String patron;
    private Dimension posicion;
    private TipoToken tipoToken;

    public Token(Dimension posicion, TipoToken tipoToken, String patron, String lexema){
        this.posicion = posicion;
        this.tipoToken = tipoToken;
        this.patron = patron;
        this.lexema = lexema;
    }

    public String getLexema() {
        return lexema;
    }

    public String getTipo() {
        return String.valueOf(tipoToken);
    }

    public String getPatron() {
        return patron;
    }

    public Dimension getPosicion() {
        return posicion;
    }

    public TipoToken getTipoToken() {
        return tipoToken;
    }
}
