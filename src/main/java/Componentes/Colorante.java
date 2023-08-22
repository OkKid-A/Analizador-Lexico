package main.java.Componentes;

import main.java.Automata.TablaDeSimbolos;
import main.java.Token.Token;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.ArrayList;

public class Colorante {

    private JTextPane editorTexto;
    private TablaDeSimbolos tablaDeSimbolos;

    public Colorante(){

    }

    public void colorearTexto(JTextPane editorTexto, ArrayList<Token> lexemas){
        editorTexto.setText("");
        lexemas.forEach((i) -> anadirToken(editorTexto,i.getLexema(),i.getTipoToken().color));
        anadirToken(editorTexto,"",Color.BLACK);
    }

    public void anadirToken(JTextPane editorTexto, String token, Color color){
        StyleContext style = StyleContext.getDefaultStyleContext();
        AttributeSet set = style.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,color);
        set = style.addAttribute(set,StyleConstants.FontFamily,"SansSerif");
        int textoLength = editorTexto.getDocument().getLength();
        editorTexto.setCaretPosition(textoLength);
        editorTexto.setCharacterAttributes(set,false);
        editorTexto.replaceSelection(token);
    }

}
