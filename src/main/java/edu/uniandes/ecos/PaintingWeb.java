package edu.uniandes.ecos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

/**
 * ***************************************************************
 */
/* Program Assignment:2                                                        
 /* Name: Angela Edith Suárez Torres                                                                                  
 /* Date: 31/05/15                  
 /* Description: Presenta via web los resultados del conteo ejecutado al tamaño del programa, sus clases y métodos
 /******************************************************************/
public class PaintingWeb {

    public static void presentarOpcion(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h1>PSP0.1 Conteo LOCS!</h1>");

        pw.write("<form action=\"calc\" method=\"post\"> \n"
                + "    <input type=\"submit\" value=\"Calcular LOCS\">\n"
                + "</form> ");
        pw.write("</html>");

    }

    public static void showResults(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("<b>LINEA:</b> " + "<br>");
        
    }
}
