package main.java.UI;

import main.java.Automata.Automata;
import main.java.Componentes.ErroresTabla;
import main.java.Componentes.Tabla;
import main.java.Token.LexemaError;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaErrores extends JFrame {

    private JPanel erroresPanel;
    private JScrollPane erroresPane;
    private JTable erroresTable;
    private Tabla tabla;
    private Automata automata;

    public VentanaErrores(Automata automata){
        this.tabla = new Tabla();
        this.automata = automata;
        ArrayList<LexemaError> lexemaErrors = new ArrayList<LexemaError>();
        lexemaErrors.add(new LexemaError(";",new Dimension(1,2)));
        fixComponents(this,erroresPanel);
        erroresPanel.setLayout(new GridLayout());
        JTable erroresTable = tabla.crearTablaError(automata.getTablaDeSimbolos().getErrores() );
        erroresPanel.removeAll();
        erroresPane = new JScrollPane(erroresTable);
        erroresPane.add(erroresTable);
        erroresPane.setVisible(true);
        erroresPane.getViewport().add(erroresTable);
        erroresPane.repaint();
        erroresPanel.add(erroresPane);
        erroresPanel.repaint();
        erroresPanel.revalidate();
        this.repaint();
        this.revalidate();
    }
    public void fixComponents(JFrame frame, JComponent component) {
        frame.add(component);
        frame.setTitle("Errores");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }


}
