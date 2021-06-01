package com.laboratorio2p3.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.laboratorio2p3.dao.ClienteDao;
import com.laboratorio2p3.entidades.Cliente;


public class ControllerShowClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ControllerShowClientes() {
		super();
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		//Eliminar
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		ClienteDao client = new ClienteDao();
		Gson json = new Gson();

		var clientes = client.MostrarClientes();

		if (clientes != null) {
			for (var iterar : clientes) {
				System.out.println(iterar.getNombre());
			}
			response.setCharacterEncoding("UTF8");
			response.getWriter().append(json.toJson(clientes));
		} else {
			System.out.println("Clientes null");
			response.sendRedirect("crudClientes.jsp");
		}

	}
	
}
