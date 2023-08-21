package main.java.Token;

import java.awt.*;

public enum TipoToken {

    IDENTIFICADOR(0,"[a-zA-z|-].[a-zA-z,0-9,_]*",Color.BLACK),
    ARITMETICO(1,"[(+,-,%) | (*|*.*) | (/|/./)]",Color.CYAN),
    COMPARADOR(2,"[<,>] | [(<,>,!,=).=]",Color.CYAN),
    ASIGNADOR(3,"[([<,>] | [*|*.*] | [/|/./]).=] | [=]",Color.CYAN),
    ENTERO(4,"[0-9]*",Color.RED),
    DECIMAL(5,"[(0-9)*.(.).(0-9)*]",Color.RED),
    CADENA(6,"[(\"|').(a-zA-Z,0-9,<,>,!,=,*,/,=,#,+,-)*.(\"|')]",Color.RED),
    BOOLEANO(7,"",new Color(102,0,153)),
    COMENTARIO(8,"[(#).(a-zA-Z,0-9,<,>,!,=,*,/,=,#,+,-)*.(LF)]",Color.GRAY),
    OTROS(9,"[[,],(,),{,},,,.]",Color.GREEN),
    LOGICOS(10,"",Color.CYAN),
    KEYWORD(11,"",new Color(102,0,153)),
    ERROR(-1,"",Color.YELLOW);


    public final int numerotipo;
    public final String expresionRegular;
    public final Color color;

    TipoToken(int numeroTipo,String expresionRegular,Color color){
        this.numerotipo = numeroTipo;
        this.expresionRegular = expresionRegular;
        this.color = color;
    }

    public int getNumerotipo() {
        return numerotipo;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }
}
