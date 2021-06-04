package com.laboratorio2p3.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.laboratorio2p3.dao.UsuarioDao;

/**
 * Servlet implementation class ControllerUsuarios
 */
public class ControllerUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	
		
		//codigo nuevo
			String evaluar = request.getParameter("action");

			if (evaluar != null) {

				if (evaluar.equals("go")) {

					response.sendRedirect("crudUsuarios.jsp");

				} else {
					System.out.println("Error1 go");
					response.sendRedirect("main.jsp");
				}
			} else {
				System.out.println("Error2");
				response.sendRedirect("main.jsp");
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
