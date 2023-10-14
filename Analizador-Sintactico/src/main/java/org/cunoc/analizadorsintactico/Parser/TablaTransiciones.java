package org.cunoc.analizadorsintactico.Parser;

import java.util.*;
import org.cunoc.analizadorsintactico.Parser.Parser;

import static org.cunoc.analizadorsintactico.Parser.Parser.EPSILON;

public class TablaTransiciones {


    private HashMap<String,Set<String >> primeros;
    private HashMap<String, Set<String >> siguientes;
    private HashMap<String, HashMap<String,String>> tablaTransiciones;
    private ArrayList<String> terminales;
    private ArrayList<String> noTerminales;
    private String simboloInicio;
    private Map<String, ArrayList<String>> producciones;

    public TablaTransiciones(ArrayList<String> terminales, ArrayList<String> noTerminales, String simboloInicio, Map<String, ArrayList<String>> producciones) {
        this.terminales = terminales;
        this.noTerminales = noTerminales;
        this.simboloInicio = simboloInicio;
        this.producciones = producciones;
        this.primeros = new HashMap<>();
        this.siguientes = new HashMap<>();
        this.tablaTransiciones = new HashMap<>();
        crearPrimeros();
        crearSiguientes();
    }

    private void crearPrimeros() {
        for (String terminal : terminales) {
            primeros.put(terminal, new HashSet<>(Collections.singletonList(terminal)));
        }
        for (String noTerminal : noTerminales) {
            primeros.put(noTerminal, new HashSet<>());
        }
        int i = 0;
        boolean modifico = true;
        while (modifico) {
            modifico = false;
            for (String noTerminal : noTerminales) {
                for (String produccion : producciones.get(noTerminal)) {
                    List<String> simbolos = Arrays.asList(produccion.split(" "));
                    for (String simbolo : simbolos) {
                        Set<String> simbolosPrimeros = primeros.get(simbolo);
                        if (simbolosPrimeros == null) {
                            break;
                        }
                        if (!simbolosPrimeros.contains(EPSILON)) {
                            modifico |= primeros.get(noTerminal).addAll(simbolosPrimeros);
                            break;
                        } else if (simbolos.indexOf(simbolo) == simbolos.size() - 1) {
                            modifico |= primeros.get(noTerminal).addAll(simbolosPrimeros);
                        } else{
                            simbolosPrimeros.remove(EPSILON);
                            modifico |= primeros.get(noTerminal).addAll(simbolosPrimeros);
                        }
                    }
                }
            }
            i++;
        }

    }

    private void crearSiguientes(){
        for (String noTerminal : noTerminales){
            siguientes.put(noTerminal, new HashSet<>());
        }
        siguientes.get(simboloInicio).add("$");
        boolean modificado = true;
        while (modificado){
            modificado = false;
            for (String noTerminal : noTerminales){
                for (String produccion : producciones.get(noTerminal)){
                    List<String> simbolos = Arrays.asList(produccion.split(" "));
                    for (int i = 0; i < simbolos.size(); i++){
                        String simbolo = simbolos.get(i);
                        if (noTerminales.contains(simbolo)){
                            Set<String> simbolosSiguientes = siguientes.get(simbolo);
                            if (simbolosSiguientes != null){
                                if (i == simbolos.size() - 1){
                                    modificado |= simbolosSiguientes.addAll(siguientes.get(noTerminal));
                                } else {
                                    Set<String> simbolosPrimeros = primeros.get(simbolos.get(i+1));
                                    if (simbolosPrimeros!=null){
                                        if (!simbolosPrimeros.contains(EPSILON)){
                                            modificado |= simbolosSiguientes.addAll(simbolosPrimeros);
                                        } else {
                                            simbolosPrimeros.remove(EPSILON);
                                            modificado |= simbolosSiguientes.addAll(simbolosPrimeros);
                                            modificado |= simbolosSiguientes.addAll(siguientes.get(noTerminal));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void crearTablaTransiciones(){
        for (String noTerminal : noTerminales){
            for (String produccion : producciones.get(noTerminal)){
                Set<String> primerosProduccion = primero(produccion);
                for (String terminal: primerosProduccion){
                    tablaTransiciones.get(noTerminal).put(terminal,produccion);
                }
                if (primerosProduccion.contains(EPSILON)){
                    Set<String> siguientesNoTerminal = siguientes.get(noTerminal);
                    for (String terminal : siguientesNoTerminal){
                        tablaTransiciones.get(noTerminal).put(terminal,EPSILON);
                    }
                }
            }
        }
    }

    private Set<String> primero(String simbolo) {
        Set<String> set = new HashSet<>();
        if (terminales.contains(simbolo)){
            set.add(simbolo);
            return set;
        }
        List<String > simbolosDeProduccion = producciones.get(simbolo);
        for (String produccion : simbolosDeProduccion){
            List<String> simbolos = Arrays.asList(produccion.split(" "));
            boolean tieneEpsilon = true;
            for (String string: simbolos){
                Set<String> primerosSet = primeros.get(string);
                if (!primerosSet.contains(EPSILON)){
                    tieneEpsilon = false;
                    set.addAll(primerosSet);
                    break;
                } else {
                    primerosSet.remove(EPSILON);
                    set.addAll(primerosSet);
                }
            }
            if (tieneEpsilon){
                set.add(EPSILON);
            }
        }
        return set;
    }

    public HashMap<String, Set<String>> getPrimeros() {
        return primeros;
    }

    public void setPrimeros(HashMap<String, Set<String>> primeros) {
        this.primeros = primeros;
    }

    public HashMap<String, Set<String>> getSiguientes() {
        return siguientes;
    }

    public void setSiguientes(HashMap<String, Set<String>> siguientes) {
        this.siguientes = siguientes;
    }

    public HashMap<String, HashMap<String, String>> getTablaTransiciones() {
        return tablaTransiciones;
    }

    public void setTablaTransiciones(HashMap<String, HashMap<String, String>> tablaTransiciones) {
        this.tablaTransiciones = tablaTransiciones;
    }
}
