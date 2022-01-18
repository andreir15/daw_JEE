package org.andrei;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HolaMundo")
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
      	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		response.setContentType("text/html");
		
		PrintWriter salida= response.getWriter();
		salida.println("<h1>Hola mundo</h1>");
		
		response.getWriter().println("<h1>Hola "+nombre+"</h1>");
	}
}
