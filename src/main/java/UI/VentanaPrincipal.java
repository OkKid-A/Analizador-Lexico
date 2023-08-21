package main.java.UI;

import main.java.Automata.Automata;
import main.java.Componentes.Colorante;
import main.java.Componentes.Componente;
import main.java.Componentes.Tabla;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class VentanaPrincipal extends JFrame {
    private JButton Aceptar;
    public JPanel globalPanel;
    private JButton procesarTextoButton;
    private JButton cargarArchivoButton;
    private JTextPane editorTexto;
    private JTextArea numeroLinea;
    private JPanel editorPanel;
    private JScrollPane editorScrollPane;
    private JScrollPane resultadosScrollPane;
    private JPanel resultadosPanel;
    private JTable resultadosTable;
    private JButton reporteErroresButton;
    private Componente componente;
    private Tabla tabla;
    private  Automata automata;
    private Colorante colorante;

    public VentanaPrincipal(Automata automata){
        this.componente = new Componente();
        this.tabla = new Tabla();
        this.automata = automata;
        this.colorante = new Colorante();
        fixComponents();
    }

    public void setButtons(){
        cargarArchivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(null);
                System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });

        procesarTextoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabla.recrearTabla(resultadosPanel,resultadosScrollPane,automata,editorTexto,redundar());
                colorante.colorearTexto(editorTexto,automata.getTablaDeSimbolos().getLexemas());
            }
        });

        reporteErroresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaErrores ventanaErrores = new VentanaErrores(automata);
            }
        });
    }

    public void fixComponents(){
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(globalPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        setButtons();
        componente.escribirNumeroLinea(editorTexto,numeroLinea);

    }

    private JFrame redundar(){
        return this;
    }
}
