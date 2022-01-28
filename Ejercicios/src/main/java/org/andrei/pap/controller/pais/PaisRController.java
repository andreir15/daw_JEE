package org.andrei.pap.controller.pais;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andrei.pap.entities.Pais;
import org.andrei.pap.model.PaisModel;


@WebServlet("/pais/r")
public class PaisRController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaisModel pm=new PaisModel();
		List<Pais> paises=pm.getPaises();
		request.setAttribute("paises", paises);
		request.getRequestDispatcher("/views/pais/r.jsp").forward(request, response);
	}

	
}
