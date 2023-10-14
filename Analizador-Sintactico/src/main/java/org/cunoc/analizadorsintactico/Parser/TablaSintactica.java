package org.cunoc.analizadorsintactico.Parser;

import org.cunoc.analizadorsintactico.analizadorLexico.Token.Token;

import java.util.ArrayList;

public class TablaSintactica {

    private ArrayList<Simbolo> tabla;

    public TablaSintactica() {
        this.tabla = new ArrayList<>();
    }

    public void addSimbolo(TipoSintactico tipoSintactico, Token identificador,String valor,int profundidad){
        Simbolo simbolo = new Simbolo(tipoSintactico,identificador.getLexema(),valor,identificador.getPosicion(),profundidad);
    }

    public ArrayList<Simbolo> getTabla() {
        return tabla;
    }
}
