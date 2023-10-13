package main.java.Automata;

import main.java.Estado.Estado;
import main.java.Token.Simbolo;

public class Transicion {

    private int estadoIn;
    private int estadoOut;
    private Simbolo simbolo;

    public Transicion(int estadoIn, int estadoOut){
        this.estadoIn = estadoIn;
        this.estadoOut = estadoOut;
    }

    public int getEstadoOut() {
        return estadoOut;
    }
}
