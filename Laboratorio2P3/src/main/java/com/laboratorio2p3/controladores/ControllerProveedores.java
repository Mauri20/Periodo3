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
		//String eval= request.getParameter("action");
		/*if(eval.equals("go") && eval=="go") {*/
			//System.out.println("Llegué");
			
			/*ProveedorDao provDao= new ProveedorDao();
			ArrayList<Proveedor> listado = new ArrayList<Proveedor>();
			
			for (var iterar:provDao.mostrarProveedores()) {
				//System.out.println(iterar.getNombre());
				Proveedor prov = new Proveedor();
				prov.setId(iterar.getId());
                prov.setNombre(iterar.getNombre());
                prov.setContacto(iterar.getContacto());
                prov.setDireccion(iterar.getDireccion());
                prov.setTelefono(iterar.getTelefono());
                prov.setNit(iterar.getNit());
                prov.setCorreo(iterar.getCorreo());
                prov.setNrc(iterar.getNrc());
                listado.add(prov);
                
			}
			
			/*request.setAttribute("proveedores", listado);
			getServletContext().getRequestDispatcher("/crudProveedores.jsp").forward(request, response);*/
			
			/*Gson json = new Gson();
			response.getWriter().append(json.toJson(provDao.mostrarProveedores()));
			response.sendRedirect("crudProveedores.jsp");*/
			
			/*if(provDao.mostrarProveedores()!=null) {
				Gson json = new Gson();
				response.getWriter().append(json.toJson(provDao.mostrarProveedores()));
				//response.sendRedirect("crudProveedores.jsp");
			}else {
				System.out.println("Error al llevar los Provs");
			}*/
			
			
		/*}else {
			System.out.println(eval);
			response.sendRedirect("main.jsp");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String dato= request.getParameter("label");
		
		Gson json = new Gson();
		response.getWriter().append(json.toJson(dato));
	}

}
