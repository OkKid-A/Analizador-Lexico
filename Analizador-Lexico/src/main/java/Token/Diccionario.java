package main.java.Token;

import java.util.HashMap;

public class Diccionario {

    private HashMap<String,String> diccionario;

    public Diccionario(){
        this.diccionario = new HashMap<String, String>();
        crearDiccionario();
    }

    public String buscar(String lexema){
            String resultado = diccionario.get(lexema);
            if (resultado != null){
                return resultado;
            } else {
                throw new NullPointerException();
            }
    }

    private void definirTipoToken(String token){

    }

    private void crearDiccionario() {
        String[] keywords = new String[]{"as", "assert", "break", "class", "continue", "def", "del", "elif", "else", "except",
                "finally", "for", "from", "global", "if", "import", "in", "is", "lambda", "None", "nonlocal", "pass", "raise", "return", "try",
                "while", "with", "yield"};
        String[] logicos = new String[]{"and", "or", "not"};
        String[] booleanos = new String[]{"True", "False"};
        addPalabras(logicos,"Logico");
        addPalabras(booleanos,"Booleano");
        addPalabras(keywords,"Palabra Reservada");
    }

    public void addPalabras(String[] coleccion, String tipo){
        for (String i:
             coleccion) {
            diccionario.put(i,tipo);
        }
    }
}
