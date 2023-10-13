package org.cunoc.analizadorsintactico.analizadorLexico.Token;

public enum Simbolo {

    LETRA(0),
    GUION(1),
    DIGITO(2),
    ARITMETICO(3),
    ASTERISCO(4),
    DIAGONAL(5),
    COMPARADOR(6),
    EXCLAMACION(7),
    IGUAL(8),
    PUNTO(9),
    COMILLASS(10),
    COMILLASD(11),
    NUMERAL(12),
    SALTO(13),
    OTROS(14),
    SPACE(15),
    ERROR(-1);





    private final int tipoTransicion;

    Simbolo(int tipoTransicion){

        this.tipoTransicion = tipoTransicion;
    }

    public int getNumeroSimbolo(){
        return this.tipoTransicion;
    }

    public Simbolo clasificarSimbolo(char c){
        if(Character.isLetter(c)){
            return LETRA;
        } else if (c == '_'){
            return GUION;
        } else if (Character.isDigit(c)){
            return DIGITO;
        } else if (c == '+'|| c == '-'|| c == '%'){
            return ARITMETICO;
        } else if(c == '*'){
            return ASTERISCO;
        } else if (c == '/'){
            return DIAGONAL;
        } else if (c == '<' || c == '>'){
            return COMPARADOR;
        } else if (c == '!'){
            return EXCLAMACION;
        } else if (c == '='){
            return IGUAL;
        } else if (c == '.'){
            return PUNTO;
        } else if (c == '\''){
            return COMILLASS;
        } else if (c == '"'){
            return COMILLASD;
        } else if (c == '#'){
            return NUMERAL;
        } else if (c == '\n'){
            return SALTO;
        } else if (c == '('|| c == ')'|| c == '['|| c == ']'|| c == '{'|| c == '}'|| c == ','|| c == ';'|| c == ':'){
            return OTROS;
        } else if (c == ' '){
            return SPACE;
        }else {
            return ERROR;
        }
    }

}
