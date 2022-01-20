package org.andrei;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ej6
 */
@WebServlet("/ej6")
public class ej6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	
			pw.println("<form method=\"post\">");
			pw.println("Nombre");
			pw.println("<input type=\"text\" name=\"nombre\"> ");
			pw.println("<br>");
			pw.println("<h2>AFICIONES</h2>");
			pw.println("Bailar<input type=\"checkbox\" value=\"bailar\" name=\"aficiones[]\">");
			pw.println("<br>");
			pw.println("Cantar<input type=\"checkbox\" value=\"cantar\" name=\"aficiones[]\">");
			pw.println("<br>");
			pw.println("<input type=\"submit\">");
			pw.println("</form>");
		

				
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre=req.getParameter("nombre");
		String aficiones[]=req.getParameterValues("aficiones[]");
	   resp.setContentType("text/html");
	   PrintWriter pw=resp.getWriter();
	   if(nombre=="") {
	   pw.println("<h1>Debes introducir un nombre</h1>");
	   }else {
		   if(aficiones==null) {
			   pw.println("<h1>A "+nombre+" no le gusta nada</h1>");
		   }
		   else{
			   
			   pw.println("<h1>A "+nombre+" le gusta ");
			   for(String aficion:aficiones){   
		   pw.println(aficion);
			   }
		   }
		   
	   }
	}
}
