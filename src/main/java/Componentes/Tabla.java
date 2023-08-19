package main.java.Componentes;

import main.java.Automata.Automata;
import main.java.Token.Token;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Tabla {

    private JTable tabla;

    public Tabla(){

    }

    public void recrearTabla(JPanel panel, JScrollPane jScrollPane, Automata automata, JTextArea jTextArea,JFrame jFrame){
        panel.removeAll();
        panel.setLayout(new GridLayout());
            JTable resultadosTable = crearResultadosLexema(automata.analizar(jTextArea.getText().toCharArray()));
            jScrollPane.removeAll();
            jScrollPane = new JScrollPane(resultadosTable);
            jScrollPane.add(resultadosTable);
            jScrollPane.setVisible(true);
            jScrollPane.getViewport().add(resultadosTable);
            panel.add(jScrollPane);
            panel.repaint();
            jFrame.repaint();
            jFrame.revalidate();
    }

    public JTable crearResultadosLexema(ArrayList<Token> resultados) {
        Token[] resultadosToken = listarTokens(resultados);
        System.out.println(resultados.size());
        String[] header = new String[]{"Tipo de Token","Lexema", "Fila", "Columna"};
        String[][] datos = crearListadoResultado(resultadosToken);
        return crearTabla(datos,header);

    }

    public Token[] listarTokens(ArrayList<Token> tokens){
        Token[] tokens1 = new Token[tokens.size()];
        for (int k = 0; k < tokens.size();k++){
            tokens1[k] = tokens.get(k);
        }
        return tokens1;
    }

    public static String[][] crearListadoResultado(Token[] tokens){
        String[][] datosEnteros = new String[tokens.length][];
        for (int k = 0; k < tokens.length;k++){
            datosEnteros[k] = new String[]{String.valueOf(tokens[k].getTipo()),tokens[k].getLexema(), String.valueOf(tokens[k].getPosicion().getWidth()),
                    String.valueOf(tokens[k].getPosicion().getHeight())};
        }
        return datosEnteros;
    }
    public static JTable crearTabla(String[][] datosFilas, String[] datosHeader) {
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
