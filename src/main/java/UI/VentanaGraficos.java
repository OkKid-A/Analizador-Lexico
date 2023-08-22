package main.java.UI;

import main.java.Componentes.Graficador;

import javax.swing.*;

public class VentanaGraficos extends JFrame{
    private JPanel graficoPanel;
    private JLabel graficoLabel;
    private ImageIcon grafico;

    public VentanaGraficos(ImageIcon grafico){
        this.grafico = grafico;
        fixComponents(this,graficoPanel);
    }

    private void createUIComponents() {
        this.graficoLabel = new JLabel(grafico);
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
