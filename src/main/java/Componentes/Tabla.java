package main.java.Componentes;

import main.java.Automata.Automata;
import main.java.Token.LexemaError;
import main.java.Token.Token;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Tabla {

    private JTable tabla;

    public Tabla(){

    }

    public void recrearTabla(JPanel panel, JScrollPane jScrollPane, Automata automata, JTextPane jTextArea,JFrame jFrame){
        panel.removeAll();
        panel.setLayout(new GridLayout());
        JTable resultadosTable = crearResultadosLexema(automata.analizar(jTextArea.getText().toCharArray()));
        jScrollPane = new JScrollPane(resultadosTable);
        jScrollPane.add(resultadosTable);
        jScrollPane.setVisible(true);
        jScrollPane.getViewport().add(resultadosTable);
        jScrollPane.repaint();
        panel.add(jScrollPane);
        panel.revalidate();
    }

    public JTable crearResultadosLexema(ArrayList<Token> resultados) {
        Token[] resultadosToken = listarTokens(resultados);
        String[] header = new String[]{"Tipo de Token","Patron","Lexema", "Fila", "Columna"};
        String[][] datos = crearListadoResultado(resultadosToken);
        return crearTabla(datos,header);

    }

    public JTable crearTablaError(ArrayList<LexemaError> errors) {
        LexemaError[] errores = listarErrores(errors);
        String[] header = new String[]{"Lexema","Columna","Fila"};
        String[][] datos = crearListadoErrores(errores);
        return crearTabla(datos,header);

    }

    public LexemaError[] listarErrores(ArrayList<LexemaError> errors){
        LexemaError[] tokens1 = new LexemaError[errors.size()];
        for (int k = 0; k < errors.size();k++){
            tokens1[k] = errors.get(k);
        }
        return tokens1;
    }

    public Token[] listarTokens(ArrayList<Token> tokens){
        Token[] tokens1 = new Token[tokens.size()];
        for (int k = 0; k < tokens.size();k++){
            tokens1[k] = tokens.get(k);
        }
        return tokens1;
    }

    public String[][] crearListadoResultado(Token[] tokens){
        String[][] datosEnteros = new String[tokens.length][];
        for (int k = 0; k < tokens.length;k++){
            datosEnteros[k] = new String[]{String.valueOf(tokens[k].getTipo()),String.valueOf(tokens[k].getPatron()),tokens[k].getLexema(), String.valueOf(tokens[k].getPosicion().getWidth()),
                    String.valueOf(tokens[k].getPosicion().getHeight())};
        }
        return datosEnteros;
    }

    public String[][] crearListadoErrores(LexemaError[] errors){
        String[][] datosEnteros = new String[errors.length][];
        for (int k = 0; k < errors.length;k++){
            LexemaError error = errors[k];
            String lexema = error.getLexema();
            String columna = String.valueOf(error.getColumna());
            String fila = String.valueOf(error.getFila());
            datosEnteros[k] = new String[]{lexema,columna,fila};
        }
        return datosEnteros;
    }


    public JTable crearTabla(String[][] datosFilas, String[] datosHeader) {
        DefaultTableModel tableModel = new DefaultTableModel(datosFilas, datosHeader) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable jTable = new JTable(datosFilas, datosHeader);
        jTable.setModel(tableModel);
        return jTable;
    }

}
