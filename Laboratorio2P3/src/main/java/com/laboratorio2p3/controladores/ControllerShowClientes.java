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
		String Nombre = request.getParameter("Nombre");
		String Tipo = request.getParameter("Tipo");
		String Contacto = request.getParameter("Contacto");
		String Telefono = request.getParameter("Telefono");
		String Direccion = request.getParameter("Direccion");
		String Correo = request.getParameter("Correo");
		String Dui = request.getParameter("Dui");
		String Nit = request.getParameter("Nit");
		String Nrc = request.getParameter("Nrc");
 System.out.println(request.getParameter("Guardar"));

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
			
			if (agregar != null) {
				if (agregar.equals("GUARDAR")) {
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
					
					response.sendRedirect("crudClientes.jsp");
					
					
				} else 
				{
					System.out.println("ERROR AL INGRESAR CLIENTE");
				}
			}
			
			if (agregar != null) {
				if (agregar.equals("ACTUALIZAR")) {
					Cl.setNombre(Nombre);
					Cl.setTipo(Tipo);
					Cl.setContacto(Contacto);
					Cl.setTelefono(Telefono);
					Cl.setDireccion(Direccion);
					Cl.setCorreo(Correo);
					Cl.setDui(Dui);
					Cl.setNit(Nit);
					Cl.setNrc(Nrc);
					
					Cl.setIdCliente(Integer.parseInt(IdCliente));
					ClDao.ActualizarCliente(Cl);
					
					response.sendRedirect("crudClientes.jsp");
					System.out.println(IdCliente);	
					
					
				} else 
				{
					System.out.println("ERROR AL ACTUALIZAR CLIENTE");
				}
			}
			
		}
			
				
			
			
		
		


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		Gson json = new Gson();
		ClienteDao cliendao = new ClienteDao();
		
		response.setCharacterEncoding("UTF8");
		response.getWriter().append(json.toJson(cliendao.MostrarClientes()));
	}
	
}
