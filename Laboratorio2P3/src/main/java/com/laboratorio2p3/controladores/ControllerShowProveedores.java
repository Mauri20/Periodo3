package com.laboratorio2p3.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.laboratorio2p3.dao.ProveedorDao;
import com.laboratorio2p3.entidades.Proveedor;

/**
 * Servlet implementation class ControllerShowProveedores
 */
public class ControllerShowProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerShowProveedores() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// ELIMINAR
		try {
			String evaluar = request.getParameter("Eliminar");

			ProveedorDao provDao = new ProveedorDao();
			if (evaluar != null) {
				if (evaluar.equals("btne")) {
					int idProv = Integer.parseInt(request.getParameter("Id"));
					provDao.elimiarProveedor(idProv);
					response.sendRedirect("crudProveedores.jsp");
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
		ProveedorDao provDa = new ProveedorDao();
		Proveedor prov = new Proveedor();
		// Recuperar los datos de la vista y asignandolos dentro del objeto prov
		String idP = request.getParameter("Id");
		if (idP == null || idP.equals("0")) {
			prov.setId(Integer.parseInt(idP));
			prov.setNombre(request.getParameter("Nombre"));
			prov.setContacto(request.getParameter("Contacto"));
			prov.setTelefono(request.getParameter("Telefono"));
			prov.setCorreo(request.getParameter("Email"));
			prov.setNit(request.getParameter("Nit"));
			prov.setNrc(request.getParameter("Nrc"));
			prov.setDireccion(request.getParameter("Direccion"));

			if (prov.getNombre()!=null) {
				try {

					response.getWriter().append(jsonResultado.toJson(prov));

				} catch (Exception e) {
					// TODO: handle exception
					resultado = "Error al registrar " + e;
					response.getWriter().append(jsonResultado.toJson(resultado));
				}
			} else {
				System.out.println("Error al guardar!");
			}
		} else {
			System.out.println("Id trae datos"+idP);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		ProveedorDao provDao = new ProveedorDao();
		Gson json = new Gson();

		var proveedores = provDao.mostrarProveedores();
		ArrayList<Proveedor> listado = new ArrayList<Proveedor>();
		if (proveedores != null) {
			for (var iterar : proveedores) {
				Proveedor prov = new Proveedor();
				prov.setId(iterar.getId());
				prov.setNombre(iterar.getNombre());
				prov.setContacto(iterar.getContacto());
				prov.setDireccion(iterar.getDireccion());
				prov.setTelefono(iterar.getTelefono());
				prov.setNit(iterar.getNit());
				prov.setCorreo(iterar.getCorreo());
				prov.setNrc(iterar.getNrc());

				var marcas = provDao.Marcas(iterar.getId());
				if (marcas != null) {
					prov.setMarcas(marcas);
				} else {
					System.out.println("Marcas null");
				}
				listado.add(prov);
			}
			response.setCharacterEncoding("UTF8");
			response.getWriter().append(json.toJson(listado));
		} else {
			System.out.println("Proveedores Null");
			response.sendRedirect("crudProveedores.jsp");
		}

	}

}
