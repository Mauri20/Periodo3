package com.laboratorio2p3.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.laboratorio2p3.dao.*;

/**
 * Servlet implementation class ControllerMarcas
 */
public class ControllerMarcas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerMarcas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		MarcaDao marcaDao = new MarcaDao();
		var marcas = marcaDao.MostrarMarcas();
		if(marcas!=null) {
			Gson json2= new Gson();
			response.setCharacterEncoding("UTF8");
			response.getWriter().append(json2.toJson(marcaDao.MostrarMarcas()));
		}else {
			System.out.println("Marcas null");
			response.sendRedirect("crudProveedores.jsp");
		}
		
	}

}
