package org.cunoc.analizadorsintactico.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name = "ReportesServlet", urlPatterns = "/servlet/reportes")
public class ReportesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tipoReporte = req.getParameter("filtro");
        if (tipoReporte!=null){
            if (tipoReporte.equals("0")){
                req.setAttribute("tabla",req.getSession().getAttribute("tablaSimbolos"));
            }
        }
        req.getRequestDispatcher("/reportes.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filtro = req.getParameter("filtro");
        resp.sendRedirect("/servlet/reportes?filtro=" + filtro);
    }
}
