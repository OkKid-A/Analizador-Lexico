package main.java.Token;

public enum TipoToken {

    IDENTIFICADOR(0,"[a-zA-z|-].[a-zA-z,0-9,_]*"),
    ARITMETICO(1,"[(+,-,%) | (*|*.*) | (/|/./)]"),
    COMPARADOR(2,"[<,>] | [(<,>,!,=).=]"),
    ASIGNADOR(3,"[([<,>] | [*|*.*] | [/|/./]).=] | [=]"),
    ENTERO(4,"[0-9]*"),
    DECIMAL(5,"[(0-9)*.(.).(0-9)*]"),
    CADENA(6,"[(\"|').(a-zA-Z,0-9,<,>,!,=,*,/,=,#,+,-)*.(\"|')]"),
    BOOLEANO(7,""),
    COMENTARIO(8,"[(#).(a-zA-Z,0-9,<,>,!,=,*,/,=,#,+,-)*.(LF)]"),
    OTROS(9,"[[,],(,),{,},,,.]"),
    LOGICOS(10,""),
    KEYWORD(11,""),
    ERROR(-1,"");


    public final int numerotipo;
    public final String expresionRegular;

    TipoToken(int numeroTipo,String expresionRegular){
        this.numerotipo = numeroTipo;
        this.expresionRegular = expresionRegular;
    }

    public int getNumerotipo() {
        return numerotipo;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }
}
