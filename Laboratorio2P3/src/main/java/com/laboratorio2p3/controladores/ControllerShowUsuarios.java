package com.laboratorio2p3.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.laboratorio2p3.dao.UsuarioDao;
import com.laboratorio2p3.entidades.Usuario;

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
			UsuarioDao usuari = new UsuarioDao();
			Usuario usua = new Usuario();
			
			
			if (evaluar != null) {
				
				
				if (evaluar.equals("btne")) {
					
					

					int idusu = Integer.parseInt(request.getParameter("idUsuario"));
					response.sendRedirect("crudUsuarios.jsp");
				}else {
					System.out.println("No viene BTNE");
				}
				
			}else {
				System.out.println("No viene Eliminar");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error 1= " + e);
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
