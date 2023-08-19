package main.java.Token;

import java.awt.*;

public class LexemaError {

    private String lexema;
    private Dimension posicion;

    public LexemaError(String lexema, Dimension posicion){
        this.lexema = lexema;
        this.posicion = posicion;
    }
}
