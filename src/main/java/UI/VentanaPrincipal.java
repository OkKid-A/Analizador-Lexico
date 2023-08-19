package main.java.UI;

import main.java.Automata.Automata;
import main.java.Componentes.Componente;
import main.java.Componentes.Tabla;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame{
    private JButton Aceptar;
    public JPanel panel1;
    private JButton procesarTextoButton;
    private JButton cargarArchivoButton;
    private JTextArea editorTexto;
    private JTextArea numeroLinea;
    private JTable lexemasTabla;
    private JPanel editorPanel;
    private JScrollPane editorScrollPane;
    private Componente componente;
    private Tabla tabla;
    private  Automata automata;

    public VentanaPrincipal(Automata automata){
        this.componente = new Componente();
        this.tabla = new Tabla();
        this.automata = automata;
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
                tabla.recrearTabla(editorPanel,editorScrollPane,automata,editorTexto,redundar());
            }
        });
    }

    private void fixComponents(){
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(this.panel1);
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
