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
   private ArrayList<Token> lexemas;

   public TablaDeSimbolos(){
      this.tabla = new ArrayList<Token>();
      this.errores = new ArrayList<LexemaError>();
      this.lexemas = new ArrayList<Token>();
   }

   public void addToken(Dimension dimension, TipoToken tipoToken,String patron, String lexema){
      Token nuevo = new Token(dimension,tipoToken,patron,lexema);
      this.lexemas.add(nuevo);
      this.tabla.add(nuevo);
   }

   public void addLexema(Dimension dimension, TipoToken tipoToken,String patron, String lexema){
      Token nuevo = new Token(dimension,tipoToken,patron,lexema);
      this.lexemas.add(nuevo);
   }

   public void addError(Dimension dimension,String error){
      if (!error.equals(" ") && !error.equals("") && !error.equals("\n")) {
         errores.add(new LexemaError(error, dimension));
      }
         Token nuevo = new Token(dimension,TipoToken.ERROR,TipoToken.ERROR.getExpresionRegular(),error);
         this.lexemas.add(nuevo);
   }

   public ArrayList<Token> getTabla() {
      return tabla;
   }

   public ArrayList<LexemaError> getErrores() {
      return errores;
   }

   public ArrayList<Token> getLexemas() {
      return lexemas;
   }
}
