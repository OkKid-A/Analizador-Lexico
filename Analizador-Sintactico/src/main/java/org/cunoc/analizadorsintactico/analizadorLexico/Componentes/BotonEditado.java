package org.cunoc.analizadorsintactico.analizadorLexico.Componentes;

import javax.swing.*;
import java.awt.*;

public class BotonEditado extends DefaultCellEditor  {

    private String textoBoton;
    public BotonEditado(JCheckBox checkBox) {
        super(checkBox);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column){
        if (value != null){
            textoBoton = value.toString();
        } else {
            textoBoton = "Ver";
        }
        JButton boton = new JButton();
        boton.setText(textoBoton);
        return boton;
    }

    public String getTextoBoton() {
        return new String(textoBoton);
    }
}
