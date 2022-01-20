package org.andrei.ej10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ej10")
public class ej10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	
			pw.println("<form method=\"post\">");
			pw.println("Nombre:");
			pw.println("<input type=\"text\" name=\"nombre\"> ");
			pw.println("<br>");
			pw.println("Contraseña:");
			pw.println("<input type=\"password\" name=\"pwd\"> ");
			pw.println("<br>");
			pw.println("<input type=\"submit\">");
			pw.println("</form>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		String pwd=request.getParameter("pwd");
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		if((nombre.equals("Andrei")&&pwd.equals("aa"))||(nombre.equals("Juan")&&pwd.equals("aa"))) {
			pw.println("Bienvenido "+nombre);
			pw.println(""
					+"<form action=\"/Ejercicios/ej10logout\">"
					+"<input type=\"submit\" value=\"Logout\"/>"
					+"</form>");
		}else {
			pw.println("Credenciales incorrectas");
		}
	}

}
