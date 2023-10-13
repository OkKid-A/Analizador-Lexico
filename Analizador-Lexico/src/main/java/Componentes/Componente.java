package main.java.Componentes;

import main.java.Automata.Automata;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

public class Componente {

    public Componente(){

    }

    public void escribirNumeroLinea(JEditorPane textArea1,JTextArea numeroLinea) {
        textArea1.getDocument().addDocumentListener(new DocumentListener() {
            public String enumerarLineas() {
                int ultimaLinea = textArea1.getDocument().getLength();
                Element raiz = textArea1.getDocument().getDefaultRootElement();
                String linea = "1" + System.getProperty("line.separator");
                for (int i = 2; i < raiz.getElementIndex(ultimaLinea) + 2; i++) {
                    linea += i + System.getProperty("line.separator");

                }
                return linea;
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                numeroLinea.setText(enumerarLineas());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                numeroLinea.setText(enumerarLineas());

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                numeroLinea.setText(enumerarLineas());

            }
        });
    }

    public void escribirNumeroColumna(JTextArea textArea1,JTextArea numeroColumna) {
        textArea1.getDocument().addDocumentListener(new DocumentListener() {
            public String enumerarLineas() {
                int ultimaLinea = textArea1.getDocument().getLength();
                Element raiz = textArea1.getDocument().getDefaultRootElement();
                String linea = "1";
                for (int i = 2; i < raiz.getElementIndex(ultimaLinea) + 2; i++) {
                    linea += i;

                }
                return linea;
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                numeroColumna.setText(enumerarLineas());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                numeroColumna.setText(enumerarLineas());

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                numeroColumna.setText(enumerarLineas());

            }
        });
    }
}
