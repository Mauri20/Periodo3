package com.laboratorio2p3.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.laboratorio2p3.dao.EmpleadoDao;
import com.laboratorio2p3.entidades.Empleado;

/**
 * Servlet implementation class ControllerShowEmpleados
 */
public class ControllerShowEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerShowEmpleados() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		// OPCION ELIMINAR (TIENE ERRORES)
		try {
			String evaluar = request.getParameter("Eliminar");
			EmpleadoDao EmpleDao = new EmpleadoDao();
			Empleado emple = new Empleado();
			
			
			if (evaluar != null) 
			{
				
				if (evaluar.equals("btne")) 
				{
					
					int idEmple = Integer.parseInt(request.getParameter("Id"));
	                //emple.setIdEmpleado(Integer.parseInt(request.getParameter("emple")));
					//EmpleDao.EliminarEmpleado(idEmple);
					response.sendRedirect("crudEmpleados.jsp");
					
					
				} else 
				{
					System.out.println("No viene BTNE");
				}
				
			} else 
			{
				System.out.println("No viene Eliminar");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error 1= " + e);
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

		
		
		
		
		EmpleadoDao empledao = new EmpleadoDao();
		Gson json = new Gson();

		var empleadooos = empledao.MostrarEmpleados();

		if (empleadooos != null) {
			for (var iterar : empleadooos) {
				System.out.println(iterar.getNombre());
			}
			response.setCharacterEncoding("UTF8");
			response.getWriter().append(json.toJson(empleadooos));
		} else {
			System.out.println("Empleados null");
			response.sendRedirect("crudEmpleados.jsp");
		}

		
		
		
		
		
		
	}

}
