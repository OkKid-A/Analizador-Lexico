package main.java.UI;

import main.java.Componentes.Graficador;

import javax.swing.*;
import java.awt.*;

public class VentanaGraficos extends JFrame{
    private JPanel graficoPanel;
    private JLabel graficoLabel;
    private JLabel tipoLabel;
    private JLabel columnaLabel;
    private JLabel filaLabel;
    private ImageIcon grafico;
    private String tipo;
    private Dimension dimension;

    public VentanaGraficos(ImageIcon grafico, String tipoToken, Dimension dimension){
        this.grafico = grafico;
        this.tipo = tipoToken;
        this.dimension = dimension;
        fixComponents(this,graficoPanel);
    }

    private void createUIComponents() {
        this.tipoLabel = new JLabel(tipo);
        this.graficoLabel = new JLabel(grafico);
        this.columnaLabel = new JLabel(String.valueOf(dimension.getWidth()));
        this.filaLabel = new JLabel(String.valueOf(dimension.getWidth()));
    }

    public void fixComponents(JFrame frame, JComponent component) {
        frame.add(component);
        frame.setTitle("Errores");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        this.tipoLabel.setText(tipo);
        this.columnaLabel.setText(String.valueOf(dimension.getWidth()));
        this.filaLabel.setText(String.valueOf(dimension.getHeight()));
    }
}
