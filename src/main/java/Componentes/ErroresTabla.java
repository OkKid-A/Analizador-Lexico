package main.java.Componentes;

import main.java.Automata.Automata;

import javax.swing.*;

public class ErroresTabla extends JTable {

    private Tabla tabla;
    private Automata automata;
    public ErroresTabla(Automata automata){
        super();
        this.tabla= new Tabla();
        this.automata = automata;
        crearTabla();
    }

    public JTable crearTabla(){
        return tabla.crearTablaError(automata.getTablaDeSimbolos().getErrores());
    }
}
