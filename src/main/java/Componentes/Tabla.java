package main.java.Componentes;

import main.java.Automata.Automata;
import main.java.Token.LexemaError;
import main.java.Token.Token;
import main.java.UI.VentanaErrores;
import main.java.UI.VentanaGraficos;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Tabla {

    private JTable tabla;

    public Tabla(){

    }

    public JTable recrearTabla(JPanel panel, JScrollPane jScrollPane, Automata automata, JTextPane jTextArea,JFrame jFrame){
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
        return  resultadosTable;
    }

    public JTable crearResultadosLexema(ArrayList<Token> resultados) {
        Token[] resultadosToken = listarTokens(resultados);
        String[] header = new String[]{"Tipo de Token","Patron","Lexema", "Fila", "Columna", "Grafico"};
        Object[][] datos = crearListadoResultado(resultadosToken);
        return crearTabla(datos,header,resultados);

    }

    public JTable crearTablaError(ArrayList<LexemaError> errors) {
        LexemaError[] errores = listarErrores(errors);
        String[] header = new String[]{"Lexema","Columna","Fila"};
        Object[][] datos = crearListadoErrores(errores);
        return crearTablaSimple(datos,header);

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

    public Object[][] crearListadoResultado(Token[] tokens){
        Object[][] datosEnteros = new Object[tokens.length][];
        for (int k = 0; k < tokens.length;k++){
            datosEnteros[k] = new Object[]{String.valueOf(tokens[k].getTipo()),String.valueOf(tokens[k].getPatron()),tokens[k].getLexema(), String.valueOf(tokens[k].getPosicion().getWidth()),
                    String.valueOf(tokens[k].getPosicion().getHeight()), "Ver"};
        }
        return datosEnteros;
    }

    public Object[][] crearListadoErrores(LexemaError[] errors){
        Object[][] datosEnteros = new String[errors.length][];
        for (int k = 0; k < errors.length;k++){
            LexemaError error = errors[k];
            String lexema = error.getLexema();
            String columna = String.valueOf(error.getColumna());
            String fila = String.valueOf(error.getFila());
            datosEnteros[k] = new String[]{lexema,columna,fila};
        }
        return datosEnteros;
    }


    public JTable crearTabla(Object[][] datosFilas, String[] datosHeader,ArrayList<Token> tokens) {
        DefaultTableModel tableModel = new DefaultTableModel(datosFilas, datosHeader) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 5){
                    return true;
                }
                return false;
            }

            @Override
            public Object getValueAt(int row, int column) {
                return super.getValueAt(row, column);
            }
        };
        JTable jTable = new JTable(datosFilas, datosHeader);
        jTable.setModel(tableModel);
        ColumnaBotones columnaBotones = new ColumnaBotones(jTable,tokens,5);
        columnaBotones.setMemoria(KeyEvent.VK_D);
        return jTable;
    }

    public JTable crearTablaSimple(Object[][] datosFilas, String[] datosHeader) {
        DefaultTableModel tableModel = new DefaultTableModel(datosFilas, datosHeader) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 5){
                    return true;
                }
                return false;
            }

            @Override
            public Object getValueAt(int row, int column) {
                return super.getValueAt(row, column);
            }
        };
        JTable jTable = new JTable(datosFilas, datosHeader);
        jTable.setModel(tableModel);
        return jTable;
    }

    public void setGraficosListener(JTable tabla, ArrayList<Token> tokens, Graficador graficador){
        for (int i = 0; i < tokens.size(); i++) {
            System.out.println(tabla.getColumn("Grafico"));
            JButton jButton = (JButton) tabla.getValueAt(i,5);

            Token token = tokens.get(i);
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BufferedImage image = null;
                    graficador.crearGraph(token.getLexema(),token.getLexema().toCharArray());
                    try {
                        image = ImageIO.read(new File(token.getLexema() + ".png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    VentanaGraficos ventanaGraficos = new VentanaGraficos(new ImageIcon(image));
                }
            });
        }
    }

}
