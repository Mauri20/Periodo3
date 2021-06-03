package com.laboratorio2p3.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.laboratorio2p3.dao.ClienteDao;
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
			ClienteDao clien = new ClienteDao();
			
			if (evaluar != null) {
				if (evaluar.equals("btne")) {
					int idclien = Integer.parseInt(request.getParameter("idcliente"));
					clien.EliminarCliente(idclien);
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
		// GUARDAR/ACTUALIZAR

		// Variable que llevara el resultado
		String resultado = "";
		
		Gson jsonResultado = new Gson();
		ClienteDao provDa = new ClienteDao();
		Cliente client = new Cliente();
		
		// Recuperar los datos de la vista y asignandolos dentro del objeto prov
		String ipC = request.getParameter("IdCliente");
		
		if (ipC == null || ipC.equals("0")) {
			client.setIdCliente(Integer.parseInt(ipC));
            client.setNombre(request.getParameter("Nombre"));
            client.setTipo(request.getParameter("Tipo"));
            client.setContacto(request.getParameter("Contacto"));
            client.setTelefono(request.getParameter("Telefono"));
            client.setDireccion(request.getParameter("Direccion"));
            client.setCorreo(request.getParameter("Correo"));
            client.setDui(request.getParameter("Dui"));
            client.setNit(request.getParameter("Nit"));
            client.setNrc(request.getParameter("Nrc"));

			if (client.getNombre()!=null) {
				try {

					response.getWriter().append(jsonResultado.toJson(client));

				} catch (Exception e) {
					// TODO: handle exception
					resultado = "Error al registrar " + e;
					response.getWriter().append(jsonResultado.toJson(resultado));
				}
			} else {
				System.out.println("Error al guardar!");
			}
		} else {
			System.out.println("Id trae datos"+ipC);
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		ClienteDao cliendao = new ClienteDao();
		Gson json = new Gson();

		var cliente = cliendao.MostrarClientes();
		ArrayList<Cliente> listado = new ArrayList<Cliente>();
		if (cliente != null) {
			for (var iterar : cliente) {
				Cliente clie = new Cliente();
				clie.setIdCliente(iterar.getIdCliente());
				clie.setNombre(iterar.getNombre());
				clie.setTipo(iterar.getTipo());
				clie.setContacto(iterar.getContacto());
				clie.setTelefono(iterar.getTelefono());
				clie.setDireccion(iterar.getDireccion());
				clie.setCorreo(iterar.getCorreo());
				clie.setDui(iterar.getDui());
				clie.setNit(iterar.getNit());
				clie.setNrc(iterar.getNrc());

				listado.add(clie);
			}
			response.setCharacterEncoding("UTF8");
			response.getWriter().append(json.toJson(listado));
		} else {
			System.out.println("Clientes Null");
			response.sendRedirect("crudClientes.jsp");
		}

	}
	
}
