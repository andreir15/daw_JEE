package org.andrei.pap.controller.pais;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andrei.pap.model.PaisModel;


@WebServlet("/pais/c")
public class PaisCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getRequestDispatcher("/views/pais/c.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombrePais=request.getParameter("nombre");
		PaisModel pm=new PaisModel();
		pm.savePais(nombrePais);
		response.sendRedirect("/views/pais/cOk.jsp");
	}

}
