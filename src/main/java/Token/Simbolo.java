package main.java.Token;

public enum Simbolo {

    LETRA(0),
    GUION(1),
    DIGITO(2),
    ARITMETICO(3),
    COMPARADOR(4),
    EXCLAMACION(5),
    IGUAL(6),
    PUNTO(7),
    CADENA(8),
    COMILLASS(9),
    COMILLASD(10),
    BOOLEANO(11),
    NUMERAL(12),
    SALTO(13),
    OTROS(14);





    private final int tipoTransicion;

    Simbolo(int tipoTransicion){

        this.tipoTransicion = tipoTransicion;
    }

    public int getSimbolo(){
        return this.tipoTransicion;
    }

    public int clasificarSimbolo(char c){
        switch (){

        }
    }

}
