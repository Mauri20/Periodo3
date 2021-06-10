package com.laboratorio2p3.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.laboratorio2p3.dao.EmpleadoDao;

/**
 * Servlet implementation class ControllerCargarEmpleados
 */
public class ControllerCargarEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerCargarEmpleados() {
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
		try {
			EmpleadoDao empleadoDao= new EmpleadoDao();
			var listado=empleadoDao.MostrarEmpleados();
			if (listado.size()>0) {
				Gson json= new Gson();
				response.setCharacterEncoding("UTF8");
				response.getWriter().append(json.toJson(listado));
			}else {
				System.out.println("No hay Usuarios");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error try CCE:"+e);
		}
	}

}
