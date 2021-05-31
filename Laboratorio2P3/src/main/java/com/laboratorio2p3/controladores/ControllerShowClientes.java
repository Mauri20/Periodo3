package com.laboratorio2p3.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.laboratorio2p3.dao.ClienteDao;
import com.laboratorio2p3.dao.EmpleadoDao;
import com.laboratorio2p3.dao.ProveedorDao;
import com.laboratorio2p3.entidades.Cliente;
import com.laboratorio2p3.entidades.Proveedor;

public class ControllerShowClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ControllerShowClientes() {
		super();
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		//Eliminar
		try {
			String evaluar = request.getParameter("Eliminar");

			ClienteDao client = new ClienteDao();
			Cliente clien = new Cliente();
			if (evaluar != null) {
				if (evaluar.equals("btne")) {
					clien.setIdCliente(Integer.parseInt(request.getParameter("IdCliente")));
					client.EliminarCliente(clien);
					response.sendRedirect("crudClientes.jsp");
				} else {
					System.out.println("No viene BTNE");
				}
			} else {
				System.out.println("No viene Eliminar");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error 1= " + e);
		}
		
		//GUARDAR/ACTUALIZAR
		String resultado = "";
		Gson jsonResultado = new Gson();
		ClienteDao clien = new ClienteDao();
		Cliente clientes = new Cliente();
		// Recuperar los datos de la vista y asignandolos dentro del objeto prov
		String idclien = request.getParameter("Id");
		if (idclien == null || idclien.equals("0")) {
			clientes.setIdCliente(Integer.parseInt(idclien));
			clientes.setNombre(request.getParameter("Nombre"));
			clientes.setContacto(request.getParameter("Tipo"));
			clientes.setTelefono(request.getParameter("Contacto"));
			clientes.setCorreo(request.getParameter("Telefono"));
			clientes.setCorreo(request.getParameter("Direccion"));
			clientes.setCorreo(request.getParameter("Correo"));
			clientes.setNit(request.getParameter("Dui"));
			clientes.setNrc(request.getParameter("Nit"));
			clientes.setDireccion(request.getParameter("Nrc"));

			if (clientes.getNombre()!=null) {
				try {

					response.getWriter().append(jsonResultado.toJson(clientes));

				} catch (Exception e) {
					// TODO: handle exception
					resultado = "Error al registrar " + e;
					response.getWriter().append(jsonResultado.toJson(resultado));
				}
			} else {
				System.out.println("Error al guardar!");
			}
		} else {
			System.out.println("Id trae datos"+idclien);
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		ClienteDao client = new ClienteDao();
		Gson json = new Gson();

		var clientes = client.MostrarClientes();
		ArrayList<Cliente> listado = new ArrayList<Cliente>();
		if (clientes != null) {
			for (var iterar : clientes) {
				Cliente cls = new Cliente();
				cls.setIdCliente(iterar.getIdCliente());
				cls.setNombre(iterar.getNombre());
				cls.setContacto(iterar.getTipo());
				cls.setDireccion(iterar.getContacto());
				cls.setTelefono(iterar.getTelefono());
				cls.setNit(iterar.getDireccion());
				cls.setCorreo(iterar.getCorreo());
				cls.setNrc(iterar.getDui());
				cls.setNrc(iterar.getNit());
				cls.setNrc(iterar.getNrc());

				
				listado.add(cls);
			}
			response.setCharacterEncoding("UTF8");
			response.getWriter().append(json.toJson(listado));
		} else {
			System.out.println("Clientes Null");
			response.sendRedirect("crudClientes.jsp");
		}

	}
	
}
