package main.java.Estado;

import main.java.Token.Simbolo;
import main.java.Token.TipoToken;

public class Estado {

    public String lexema;
    public boolean Final;
    public int numeroEstado;

    public TipoToken token;

    public Estado(int numeroEstado){
        this.numeroEstado = numeroEstado;
        Final = false;
    }

    public Estado(int numeroEstado, TipoToken tipoLexema){
        this.numeroEstado = numeroEstado;
        this.token = tipoLexema;
        Final = true;
    }

    public String getLexema() {
        return lexema;
    }

    public int getNumeroEstado() {
        return numeroEstado;
    }

    public TipoToken getTipoToken() {
        return token;
    }

    public boolean isFinal() {
        return Final;
    }
}
