package com.laboratorio2p3.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.laboratorio2p3.entidades.Marca;

/**
 * Servlet implementation class ControllerPruebas
 */
public class ControllerPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerPruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession sesion = request.getSession(true);
		try {
			String marcas[]=request.getParameterValues("marcas.fila");
			ArrayList<Marca> listado= new ArrayList<Marca>();
			for(int i=0;i<marcas.length;i++) {
				
				Marca marca= new Marca();
				marca.setId(Integer.parseInt(marcas[i]));
				//System.out.println(marca.getId());
				listado.add(marca);
			}
			for(var item : listado) {
				System.out.println(item.getId());
				System.out.println("TamañoFor:"+listado.size());
			}
			System.out.println("Tamaño:"+listado.size());
			sesion.setAttribute("listadoMarcas", listado );
			/*String marca=request.getParameter("marc");
			System.out.println(marca);
			ArrayList<Marca> listado= new ArrayList<Marca>();
			Marca obj= new Marca();
			obj.setId(Integer.parseInt(marca));
			listado.add(obj);
			System.out.println(listado.size());*/
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERRORRRRRR!:"+e);
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
