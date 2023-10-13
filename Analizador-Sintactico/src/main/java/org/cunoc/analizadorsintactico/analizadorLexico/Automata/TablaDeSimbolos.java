package org.cunoc.analizadorsintactico.analizadorLexico.Automata;

import org.cunoc.analizadorsintactico.analizadorLexico.Estado.Estado;
import org.cunoc.analizadorsintactico.analizadorLexico.Token.Diccionario;
import org.cunoc.analizadorsintactico.analizadorLexico.Token.LexemaError;
import org.cunoc.analizadorsintactico.analizadorLexico.Token.TipoToken;
import org.cunoc.analizadorsintactico.analizadorLexico.Token.Token;

import java.awt.*;
import java.util.ArrayList;

public class TablaDeSimbolos {

   private ArrayList<Token> tabla;
   private ArrayList<LexemaError> errores;
   private ArrayList<Token> lexemas;
   private Diccionario diccionario;

   public TablaDeSimbolos(Diccionario diccionario){
      this.diccionario = new Diccionario();
      this.tabla = new ArrayList<Token>();
      this.errores = new ArrayList<LexemaError>();
      this.lexemas = new ArrayList<Token>();
   }

   public void addToken(Dimension dimension, TipoToken tipoToken, String patron, String lexema, Estado estadoActual){
      if (tipoToken == TipoToken.BOOLEANO || tipoToken == TipoToken.KEYWORD || tipoToken == TipoToken.LOGICOS) {
         try {
            patron = diccionario.buscar(lexema);
         } catch (NullPointerException e) {
            tipoToken = TipoToken.IDENTIFICADOR;
            patron = "IDENTIFICADOR";
         }
      } else {
         patron = String.valueOf(estadoActual.getTipoToken().getExpresionRegular());
      }
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
