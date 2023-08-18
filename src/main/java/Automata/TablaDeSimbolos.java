package main.java.Automata;

import main.java.Token.Token;

import java.util.ArrayList;
import java.util.HashMap;

public class TablaDeSimbolos {

   private ArrayList<Token> tabla;
   private ArrayList<String> errores;

   public TablaDeSimbolos(){

   }

   public void addToken(){
      tabla.add(new Token());
   }

   public void addError(String error){
      errores.add(error);
   }
}
