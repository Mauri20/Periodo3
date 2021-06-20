package com.laboratorio2p3.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.laboratorio2p3.dao.EmpleadoDao;
import com.laboratorio2p3.dao.UsuarioDao;
import com.laboratorio2p3.entidades.Empleado;
import com.laboratorio2p3.entidades.Usuario;

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
		EmpleadoDao EmpleDao = new EmpleadoDao();
		Empleado emple = new Empleado();
		//ELIMINAR
		try {
			String evaluar = request.getParameter("Eliminar");
			if (evaluar != null) {
				if (evaluar.equals("btne")) {
					int idEmple = Integer.parseInt(request.getParameter("Id"));
					emple.setIdEmpleado(idEmple);
					EmpleDao.EliminarEmpleado(emple);
					response.sendRedirect("crudEmpleados.jsp");
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
		//GUARDAR Y ACTUALIZAR
		try {
			String IdEmple= request.getParameter("IdEmpleado");
			if(IdEmple!=null || IdEmple!="") {
				//System.out.println(request.getParameter("Pass")+"-"+request.getParameter("Usuario"));
				int idEmplea=Integer.parseInt(IdEmple);
				String Nombre = request.getParameter("Nombre");
				String Apellido = request.getParameter("Apellido");
				String Sexo = request.getParameter("Sexo");
				String Direccion = request.getParameter("Direccion");
				String Telefono = request.getParameter("Telefono");
				String Dui = request.getParameter("Dui");
				String Nit = request.getParameter("Nit");
				String Cargo = request.getParameter("Cargo");
				String Departamento = request.getParameter("Departamento");
				
				Gson json= new Gson();
				String resultado="0";
				emple.setIdEmpleado(idEmplea);
				emple.setNombre(Nombre);
				emple.setApellido(Apellido);
				emple.setSexo(Sexo);
				emple.setDireccion(Direccion);
				emple.setTelefono(Telefono);
				emple.setDui(Dui);
				emple.setNit(Nit);
				emple.setCargo(Cargo);
				emple.setDepartamento(Departamento);
				
				if(idEmplea==0) {
					if(EmpleDao.AgregarEmpleado(emple)) {
						resultado="1";
					}else {
						resultado="2";
					}
				}else if(idEmplea>0) {
					if(EmpleDao.ActualizarEmpleado(emple)) {
						resultado="3";
					}else {
						resultado="4";
					}
				}else {
					System.out.println("IdEmplea invalido");
				}
				response.getWriter().append(json.toJson(resultado));
			}else {
				System.out.println("IdEmplea=null");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al recibir datos: "+e);
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
