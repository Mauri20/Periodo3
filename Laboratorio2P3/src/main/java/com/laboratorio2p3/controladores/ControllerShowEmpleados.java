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
		
		String evaluar = request.getParameter("Eliminar");
		String evaluar2 = request.getParameter("Guardar");
		
		EmpleadoDao EmpleDao = new EmpleadoDao();
		Empleado emple = new Empleado();
		
		String IdEmpeado = request.getParameter("Id");
		String Nombre = request.getParameter("Nombre");
		String Apellido = request.getParameter("Apellido");
		String Sexo = request.getParameter("Sexo");
		String Direccion = request.getParameter("Direccion");
		String Telefono = request.getParameter("Telefono");
		String Dui = request.getParameter("Dui");
		String Nit = request.getParameter("Nit");
		String Cargo = request.getParameter("Cargo");
		String Departamento = request.getParameter("Departamento");
		
		
		
		
		// OPCION ELIMINAR 
		if (evaluar != null) 
		{
			if (evaluar.equals("btne"))
			{
				
				emple.setIdEmpleado(Integer.parseInt(IdEmpeado));
				EmpleDao.EliminarEmpleado(emple);
				response.sendRedirect("crudEmpleados.jsp");
				
				
			}
		}else 
		{
			System.out.println("ERROR");
		}
		
		
		
		
		
		
		//GUARDAR
		if (evaluar2 != null) 
		{
			if (evaluar2.equals("GUARDAR")) 
			{
				emple.setNombre(Nombre);
				emple.setApellido(Apellido);
				emple.setSexo(Sexo);
				emple.setDireccion(Direccion);
				emple.setTelefono(Telefono);
				emple.setDui(Dui);
				emple.setNit(Nit);
				emple.setCargo(Cargo);
				emple.setDepartamento(Departamento);
				
				
				System.out.println(IdEmpeado);
				EmpleDao.AgregarEmpleado(emple);
			    response.sendRedirect("crudEmpleados.jsp");
				
			}else 
			{
				System.out.println("ERROR AL INGRESAR EMPLEADO");
			}
		}
		
		
		
		
		
		//ACTUALIZAR
		if (evaluar2 != null ) 
		{
			if (evaluar2.equals("Actualizar")) 
			{
				emple.setNombre(Nombre);
				emple.setApellido(Apellido);
				emple.setSexo(Sexo);
				emple.setDireccion(Direccion);
				emple.setTelefono(Telefono);
				emple.setDui(Dui);
				emple.setNit(Nit);
				emple.setCargo(Cargo);
				emple.setDepartamento(Departamento);
				
				emple.setIdEmpleado(Integer.parseInt(IdEmpeado));
				EmpleDao.ActualizarEmpleado(emple);
				
				response.sendRedirect("crudEmpleados.jsp");
				System.out.println(IdEmpeado);
				
			}else 
			{
				System.out.println("ERROR AL ACTUALIZAR EMPLEADO");
			}
			
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

		Gson json = new Gson();
		EmpleadoDao empleadodao = new EmpleadoDao();
		
		response.setCharacterEncoding("UTF8");
		response.getWriter().append(json.toJson(empleadodao.MostrarEmpleados()));
		

	}

}
