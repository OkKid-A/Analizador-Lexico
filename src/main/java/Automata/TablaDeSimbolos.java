package main.java.Automata;

import main.java.Token.LexemaError;
import main.java.Token.TipoToken;
import main.java.Token.Token;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.ToLongBiFunction;

public class TablaDeSimbolos {

   private ArrayList<Token> tabla;
   private ArrayList<LexemaError> errores;

   public TablaDeSimbolos(){
      this.tabla = new ArrayList<Token>();
      this.errores = new ArrayList<LexemaError>();
   }

   public void addToken(Dimension dimension, TipoToken tipoToken,String patron, String lexema){
      Token nuevo = new Token(dimension,tipoToken,patron,lexema);
      this.tabla.add(nuevo);
   }

   public void addError(Dimension dimension,String error){
      if (!error.equals(" ")) {
         errores.add(new LexemaError(error, dimension));
      }
   }

   public ArrayList<Token> getTabla() {
      return tabla;
   }
}
