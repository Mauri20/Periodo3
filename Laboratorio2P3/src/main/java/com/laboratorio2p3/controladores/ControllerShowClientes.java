package com.laboratorio2p3.controladores;

import java.io.IOException;
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

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String Evaluar = req.getParameter("btn btn-danger");
		String Agregar = req.getParameter("btn btn-success");
		String IdCliente = req.getParameter("IdCliente");
		String Cliente = req.getParameter("Cliente");
	

		ClienteDao client = new ClienteDao();
		Cliente clien = new Cliente();

		if (Evaluar != null) {
			if (Evaluar.equals("btn btn-danger")) {
				clien.setIdCliente(Integer.parseInt(req.getParameter("IdCliente")));
				client.EliminarCliente(clien);
				resp.sendRedirect("crudClientes.jsp");
			}
		}else if(Agregar.equals("btn btn-success")) {
			clien.setNombre(Cliente);
			clien.setTipo(Cliente);
			clien.setContacto(Cliente);
			clien.setTelefono(Cliente);
			clien.setDireccion(Cliente);
			clien.setCorreo(Cliente);
			clien.setDui(Cliente);
			clien.setNit(Cliente);
			clien.setNrc(Cliente);
			System.out.println(IdCliente);
			
			if(IdCliente==null||IdCliente=="") {
				
				client.AgregarCliente(clien);
				resp.sendRedirect("crudClientes.jsp");
			}else {
				clien.setIdCliente(Integer.parseInt(IdCliente));
				client.ActualizarCliente(clien);
				resp.sendRedirect("crudClientes.jsp");
			}
		}

	
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		Gson json = new Gson();

		ClienteDao clie = new ClienteDao();
		resp.getWriter().append(json.toJson(clie.MostrarClientes()));
			}
	
}
