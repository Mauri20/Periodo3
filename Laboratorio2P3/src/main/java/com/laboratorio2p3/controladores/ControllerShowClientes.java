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
		
		String IdCliente = request.getParameter("Id");
		String Nombre = request.getParameter("Cliente");
		String Tipo = request.getParameter("Tipo");
		String Contacto = request.getParameter("Contacto");
		String Telefono = request.getParameter("Telefono");
		String Direccion = request.getParameter("Direccion");
		String Correo = request.getParameter("Correo");
		String Dui = request.getParameter("Dui");
		String Nit = request.getParameter("Nit");
		String Nrc = request.getParameter("Nrc");
		          //Eliminar

			String evaluar = request.getParameter("Eliminar");
			String agregar = request.getParameter("Guardar");
			ClienteDao ClDao = new ClienteDao();
			Cliente Cl = new Cliente();
			
			
			if (evaluar != null) {
				if (evaluar.equals("btne")) {
					Cl.setIdCliente(Integer.parseInt(IdCliente));
					ClDao.EliminarCliente(Cl);
					response.sendRedirect("crudClientes.jsp");
				}
			} else {
				System.out.println("ERROR");
				
			}
			
			
			if (evaluar != null) {
				if (evaluar.equals("btna")) {
					
					Cl.setNombre(Nombre);
					Cl.setTipo(Tipo);
					Cl.setContacto(Contacto);
					Cl.setTelefono(Telefono);
					Cl.setDireccion(Direccion);
					Cl.setCorreo(Correo);
					Cl.setDui(Dui);
					Cl.setNit(Nit);
					Cl.setNrc(Nrc);
					System.out.println(IdCliente);
					ClDao.AgregarCliente(Cl);
;
					response.sendRedirect("crudClientes.jsp");
					
			} else {
				System.out.println("ERROR AL INGRESAR CLIENTE");
				
			}
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
