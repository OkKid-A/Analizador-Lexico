package org.cunoc.analizadorsintactico.analizadorLexico.Token;

import java.awt.*;

public enum TipoToken {

    IDENTIFICADOR(0,"[a-zA-z|-].[a-zA-z,0-9,_]*",Color.BLACK),
    ARITMETICO(1,"[(+,-,%) | (*|*.*) | (/|/./)]",new Color(0x6AC6E8)),
    COMPARADOR(2,"[<,>] | [(<,>,!,=).=]",new Color(0x6AC6E8)),
    ASIGNADOR(3,"[([<,>] | [*|*.*] | [/|/./]).=] | [=]",new Color(0x6AC6E8)),
    ENTERO(4,"[0-9]*",Color.RED),
    DECIMAL(5,"[(0-9)*.(.).(0-9)*]",Color.RED),
    CADENA(6,"[(\"|').(a-zA-Z,0-9,<,>,!,=,*,/,=,#,+,-)*.(\"|')]",Color.RED),
    BOOLEANO(7,"",new Color(102,0,153)),
    COMENTARIO(8,"[(#).(a-zA-Z,0-9,<,>,!,=,*,/,=,#,+,-)*.(LF)]",Color.GRAY),
    OTROS(9,"[[,],(,),{,},,,.]",new Color(76, 168, 87)),
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
