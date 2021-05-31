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
import com.laboratorio2p3.dao.ProveedorDao;
import com.laboratorio2p3.dao.UsuarioDao;
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
		String evaluar = request.getParameter("action");

		if (evaluar != null) {

			if (evaluar.equals("go")) {

				response.sendRedirect("crudClientes.jsp");

			} else {
				System.out.println("Error1 go");
				response.sendRedirect("main.jsp");
			}
		} else {
			System.out.println("Error2");
			response.sendRedirect("main.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		
	}
	
	//<td class="align-middle"> ${item.Nombre} </td>
	//<td class="align-middle"> ${item.Tipo} </td>
	//<td class="align-middle"> ${item.Contacto} </td>
	//<td class="align-middle"> ${item.Telefono} </td>
	//<td class="align-middle"> ${item.Direccion} </td>
	//<td class="align-middle"> ${item.Correo} </td>
	//<td class="align-middle"> ${item.Dui} </td>
	//<td class="align-middle"> ${item.Nit} </td>
	//<td class="align-middle"> ${item.Nrc} </td>
	
}
