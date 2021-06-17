package com.laboratorio2p3.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.laboratorio2p3.dao.UsuarioDao;
import com.laboratorio2p3.entidades.*;

/**
 * Servlet implementation class ControllerShowUsuarios
 */
public class ControllerShowUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerShowUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//codigo nuevo que agregue
		
		try {
			String evaluar = request.getParameter("Eliminar");

			UsuarioDao usuDao= new UsuarioDao();
			if (evaluar != null) {
				if (evaluar.equals("btne")) {
					int idUsu = Integer.parseInt(request.getParameter("IdUsuario"));
					Usuario usu= new Usuario();
					usu.setIdUsuario(idUsu);
					usuDao.eliminarUsuario(usu);
					response.sendRedirect("crudUsuarios.jsp");
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
		
		
		try {
			String IdUsu= request.getParameter("IdUsuario");
			if(IdUsu!=null || IdUsu!="") {
				//System.out.println(request.getParameter("Pass")+"-"+request.getParameter("Usuario"));
				int idUsuario=Integer.parseInt(IdUsu);
				int idEmpleado=Integer.parseInt(request.getParameter("IdEmpleado"));
				String usuario= request.getParameter("Usuario");	
				String pass = request.getParameter("Pass");
				String pass2=request.getParameter("Pass2");
				String tipo = request.getParameter("Tipo");
				
				Usuario usu= new Usuario();
				Empleado emp= new Empleado();
				UsuarioDao usuDao= new UsuarioDao();
				Gson json= new Gson();
				String resultado="0";
				usu.setIdUsuario(idUsuario);
				usu.setUsuario(usuario);
				usu.setPassWord(pass);
				usu.setTipoUsuario(tipo);
				emp.setIdEmpleado(idEmpleado);
				usu.setEmpleado(emp);
				
				if(idUsuario==0) {
					if(usuDao.agregarUsuario(usu)) {
						resultado="1";
					}else {
						resultado="2";
					}
					
				}else if(idUsuario>0) {
					if(pass2.equals(usu.getPassWord())) {
						if(usuDao.actualizarUsuario(usu)==1) {
							resultado="3";
						}else {
							resultado="4";
						}
					}else {
						if(usuDao.actualizarUsuario(usu, pass2)==1) {
							resultado="3";
						}else {
							resultado="4";
						}
					}
				}else {
					System.out.println("IdUsu invalido");
				}
				response.getWriter().append(json.toJson(resultado));
			}else {
				System.out.println("IdUsu=null");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al recibir datos: "+e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		UsuarioDao usuadao = new UsuarioDao();
		Gson json = new Gson();
		
		var Usuarioss = usuadao.TraerUsuarios();
		
		if (Usuarioss != null) {
			for (var iterar : Usuarioss) {
				
				System.out.println(iterar.getIdUsuario());
			}
			response.setCharacterEncoding("UTF8");
			response.getWriter().append(json.toJson(Usuarioss));
			
			
		}else {
			System.out.println("Usuarios null");
			response.sendRedirect("crudUsuarios.jsp");
		}
	}

}
