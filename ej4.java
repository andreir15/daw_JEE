package org.andrei;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ej4")
public class ej4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		response.setContentType("text/html");
		
		if(nombre==null) {
	
			response.getWriter().println("<form>");
		response.getWriter().println("Nombre");
		response.getWriter().println("<input type=\"text\" nsme=\"nombre\"> ");
		response.getWriter().println("<br>");
		response.getWriter().println("<input type=\"submit\">");
		response.getWriter().println("</form>");
		}else {
		response.getWriter().println("Hola "+nombre);
	}
	}

}
