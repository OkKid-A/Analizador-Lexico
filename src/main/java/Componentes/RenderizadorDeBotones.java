package main.java.Componentes;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class RenderizadorDeBotones extends JButton implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.setText((value == null) ? "Ver" : value.toString());
        return this;
    }

    public JButton getButton(){
        return this;
    }
}
