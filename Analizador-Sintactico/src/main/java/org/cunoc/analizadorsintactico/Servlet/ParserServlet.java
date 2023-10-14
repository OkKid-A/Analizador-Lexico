package org.cunoc.analizadorsintactico.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cunoc.analizadorsintactico.Parser.Parser;
import org.cunoc.analizadorsintactico.Parser.Simbolo;
import org.cunoc.analizadorsintactico.analizadorLexico.Automata.Automata;
import org.cunoc.analizadorsintactico.analizadorLexico.Start;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "PaserServlet", urlPatterns = "/servlet/parser-servlet")

public class ParserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Start start = new Start();
        String textoEntrada = req.getParameter("editor");
        Automata automata = new Automata(start.setTransiciones(),start.setListaEstados());
        Parser parser = new Parser(start.setTerminales(),start.setNoTerminales(),start.setProducciones(),"S''");
        parser.Analizar(automata.analizar(textoEntrada.toCharArray()));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Start start = new Start();
        String textoEntrada = req.getParameter("editor");
        Automata automata = new Automata(start.setTransiciones(),start.setListaEstados());
        Parser parser = new Parser(start.setTerminales(),start.setNoTerminales(),start.setProducciones(),"S''");
        parser.Analizar(automata.analizar(textoEntrada.toCharArray()));
        ArrayList<Simbolo> tabla = parser.getTablaSintactica().getTabla();
        req.getSession().setAttribute("tablaSimbolos",tabla);
        resp.sendRedirect("/servlet/reportes");
    }
}
