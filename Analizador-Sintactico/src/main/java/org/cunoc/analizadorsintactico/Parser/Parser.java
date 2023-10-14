package org.cunoc.analizadorsintactico.Parser;

import org.cunoc.analizadorsintactico.analizadorLexico.Token.TipoToken;
import org.cunoc.analizadorsintactico.analizadorLexico.Token.Token;

import java.util.*;

public class Parser {

    private ArrayList<String> terminales;
    private ArrayList<String> noTerminales;
    private String simboloInicio;
    private Map<String, ArrayList<String>> producciones;
    private TablaTransiciones tablaTransiciones;

    private TablaSintactica tablaSintactica;
    public final static String EPSILON = "";

    public Parser(ArrayList<String> terminales, ArrayList<String> noTerminales, Map<String, ArrayList<String>> producciones, String simboloInicio) {
        this.terminales = terminales;
        this.noTerminales = noTerminales;
        this.producciones = producciones;
        this.simboloInicio = simboloInicio;
        tablaTransiciones = new TablaTransiciones(terminales,noTerminales,simboloInicio,producciones);
    }

    public boolean Analizar(ArrayList<Token> tokensLexicos){
        this.tablaSintactica = new TablaSintactica();
        Stack<String> pila = new Stack<>();
        pila.push("$");
        pila.push(simboloInicio);
        int indexToken = 0;
        int profundidad = 0;
        while (!pila.isEmpty()){
            String top =  pila.pop();
            Token tokenActual = tokensLexicos.get(indexToken);
            if (terminales.contains(top)){
                if (compararTerminales(top,tokenActual)){
                    if (tokenActual.getTipoToken()== TipoToken.IDENTIFICADOR){
                        if(pila.peek().equals("(")){
                            tablaSintactica.addSimbolo(TipoSintactico.FUNCION,tokenActual,"-",profundidad);
                        } else {
                            tablaSintactica.addSimbolo(TipoSintactico.UNDEFINED,tokenActual,"undefined",profundidad);
                        }
                    }
                    indexToken++;
                } else {
                    System.out.println("Error de sintaxis, se esperaba:" + top + " cerca de " + tokenActual.getLexema());
                    while (!pila.isEmpty() && !tablaTransiciones.getSiguientes().get(top).contains(seleccionarTipo(top,tokenActual))){
                        top = pila.pop();
                    }
                    if (pila.isEmpty()){
                        System.out.println("Se finalizo el texto sin completar la produccion.");
                        return false;
                    }
                }
            } else {
                if (top.equals("S'")){
                    profundidad--;
                }
                String produccion  = tablaTransiciones.getTablaTransiciones().get(top).get(seleccionarSegunToken(tokenActual));
                if (produccion == null){
                    System.out.println("Error de sintasix: no hay produccion para " + top + ", " + seleccionarSegunToken(tokenActual));
                    while (!pila.isEmpty() && !tablaTransiciones.getSiguientes().get(top).contains(seleccionarTipo(top,tokenActual))){
                        top = pila.pop();
                    }
                    if (pila.isEmpty()){
                        System.out.println("Se finalizo el texto sin completar la produccion.");
                        return false;
                    }
                }
                if (!produccion.equals(EPSILON)){
                    List<String> derechaProduccion = Arrays.asList(produccion.split(" "));
                    Collections.reverse(derechaProduccion);
                    for (String simbolo : derechaProduccion){
                        pila.push(simbolo);
                        if (simbolo.equals("B")){
                            profundidad++;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean compararTerminales(String lexema, Token token){
        Set<String> tipos = diferenciarTokens();
        if (tipos.contains(lexema)){
            return lexema.equals(token.getTipoToken().toString());
        } else {
            return lexema.equals(token.getLexema());
        }
    }

    private String seleccionarTipo(String lexema, Token token){
        Set<String> tipos = diferenciarTokens();
        if (tipos.contains(lexema)){
            return token.getTipo();
        } else {
            return token.getLexema();
        }
    }

    private String seleccionarSegunToken(Token token){
        Set<String> tipos = diferenciarTokens();
        if (tipos.contains(token.getTipo())){
            return token.getTipo();
        } else {
            return token.getLexema();
        }
    }

    private Set<String> diferenciarTokens() {
        Set<String> tipos = new HashSet<>();
        tipos.add("IDENTIFICADOR");
        tipos.add("ENTERO");
        tipos.add("DECIMAL");
        tipos.add("CADENA");
        tipos.add("COMENTARIO");
        tipos.add("ERROR");
        return tipos;
    }

    public TablaSintactica getTablaSintactica() {
        return tablaSintactica;
    }
}
