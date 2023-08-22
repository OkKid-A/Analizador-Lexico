package main.java.Componentes;

import main.java.Token.Token;
import main.java.UI.VentanaGraficos;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ColumnaBotones extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener, MouseListener {

    private JTable table;
    private Action accion;
    private int memoria;
    private JButton botonRenderizado;
    private JButton botonEditado;
    private Object editorValue;
    private Border bordeInicial;
    private Border bordeEnfocado;
    private Boolean esEditorDeBotones;
    private ArrayList<Token> tokens;
    public ColumnaBotones(JTable table, ArrayList<Token> tokens, int columna)
    {
        this.table = table;
        this.tokens = tokens;
        botonRenderizado = new JButton();
        botonEditado = new JButton();
        botonEditado.setFocusPainted( false );
        botonEditado.addActionListener( this );
        bordeInicial = botonEditado.getBorder();
        //bordeEnfocado( new LineBorder(Color.BLUE) );

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(columna).setCellRenderer( this );
        columnModel.getColumn(columna).setCellEditor( this );
        table.addMouseListener( this );
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int fila = table.convertRowIndexToModel(table.getEditingRow());
        fireEditingStopped();
        accion = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Graficador graficador = new Graficador();
                BufferedImage image = null;
                graficador.crearGraph(tokens.get(fila).getLexema(),tokens.get(fila).getLexema().toCharArray());
                try {
                    image = ImageIO.read(new File(tokens.get(fila).getLexema() + ".png"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
               VentanaGraficos ventanaGraficos = new VentanaGraficos(new ImageIcon(image));
            }
        };
        ActionEvent evento = new ActionEvent(
                table,
                ActionEvent.ACTION_PERFORMED,
                ""+fila);
        accion.actionPerformed(evento);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (table.isEditing() && table.getCellEditor() == this){
            esEditorDeBotones = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
            if (esEditorDeBotones && table.isEditing()) {
                table.getCellEditor().stopCellEditing();
                esEditorDeBotones = false;
            }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value == null){
            botonEditado.setText("");
        } else{
            botonEditado.setText(value.toString());
        }
        this.editorValue = value;
        return botonEditado;
    }

    @Override
    public Object getCellEditorValue() {
        return editorValue;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (hasFocus){
            botonRenderizado.setBorder(bordeEnfocado);
        } else {
            botonRenderizado.setBorder(bordeInicial);
        }
        if (value == null){
            botonRenderizado.setText("");
        } else  {
            botonRenderizado.setText(value.toString());
        }
        return botonRenderizado;
    }

    public void setBordeEnfocado(Border bordeEnfocado) {
        this.bordeEnfocado = bordeEnfocado;
        botonEditado.setBorder(bordeEnfocado);
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
        botonEditado.setMnemonic(memoria);
        botonRenderizado.setMnemonic(memoria);
    }


}
