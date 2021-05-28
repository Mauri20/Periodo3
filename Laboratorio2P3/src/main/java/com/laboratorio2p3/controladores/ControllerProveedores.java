package com.laboratorio2p3.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.laboratorio2p3.dao.ProveedorDao;
import com.laboratorio2p3.entidades.*;


/**
 * Servlet implementation class ControllerProveedores
 */
public class ControllerProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerProveedores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String evaluar= request.getParameter("action");
		
		if(evaluar!=null) {
			if(evaluar.equals("go")) {
				response.sendRedirect("crudProveedores.jsp");
			}else {
				System.out.println("No es 'go'");
				response.sendRedirect("main.jsp");
			}
		}else {
			System.out.println("Es null");
			response.sendRedirect("main.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
