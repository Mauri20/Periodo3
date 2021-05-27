package com.laboratorio2p3.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.laboratorio2p3.dao.ClienteDao;
import com.laboratorio2p3.dao.EmpleadoDao;
import com.laboratorio2p3.entidades.Cliente;

/**
 * Servlet implementation class ControllerClientes
 */
public class ControllerClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerClientes() {	
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ClienteDao clsUser = new ClienteDao();
		Gson json = new Gson();
		response.sendRedirect("crudCliente.jsp");
		response.getWriter().append(json.toJson(clsUser.MostrarClientes()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doGet(request, response);

	}
	
	
	
}
