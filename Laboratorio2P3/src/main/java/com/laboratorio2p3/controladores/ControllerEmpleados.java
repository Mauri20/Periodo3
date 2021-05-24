package com.laboratorio2p3.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.laboratorio2p3.dao.EmpleadoDao;

/**
 * Servlet implementation class ControllerEmpleados
 */
public class ControllerEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerEmpleados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String eval= request.getParameter("action");
		if(eval.equals("go")) {
			
			
			
			
			Gson json = new Gson();
			EmpleadoDao clsUser = new EmpleadoDao();
			response.sendRedirect("crudEmpleados.jsp");
			response.getWriter().append(json.toJson(clsUser.MostrarEmpleados()));
			
			
			
			
		}else {
			System.out.println(eval);
			response.sendRedirect("main.jsp");
		}
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
