package main.java.Token;

public enum TipoToken {

    IDENTIFICADOR(0),
    ARITMETICO(1),
    COMPARADOR(2),
    ASIGNADOR(3),
    ENTERO(4),
    DECIMAL(5),
    CADENA(6),
    BOOLEANO(7),
    COMENTARIO(8),
    OTROS(9),
    LOGICOS(10),
    KEYWORD(11),
    ERROR(-1);


    public final int numerotipo;

    TipoToken(int numeroTipo){
        this.numerotipo = numeroTipo;
    }

    public int getNumerotipo() {
        return numerotipo;
    }
}
