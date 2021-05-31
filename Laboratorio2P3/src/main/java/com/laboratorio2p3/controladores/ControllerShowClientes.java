package com.laboratorio2p3.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.laboratorio2p3.dao.ClienteDao;
import com.laboratorio2p3.dao.EmpleadoDao;
import com.laboratorio2p3.entidades.Cliente;

public class ControllerShowClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ControllerShowClientes() {
		super();
		
		
	}

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		resp.getWriter().append("Served at: ").append(req.getContextPath());
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		ClienteDao cliente = new ClienteDao();
		Gson json = new Gson();

		var client = cliente.MostrarClientes();

		if (client != null) {
			for (var iterar : client) {
				System.out.println(iterar.getNombre());
			}
			resp.setCharacterEncoding("UTF8");
			resp.getWriter().append(json.toJson(client));
		} else {
			System.out.println("Clientes null");
			resp.sendRedirect("crudClientes.jsp");
		}

			}
	
}
