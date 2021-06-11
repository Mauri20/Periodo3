package com.laboratorio2p3.dao;

import java.sql.*;
import java.util.ArrayList;

import com.laboratorio2p3.conexion.Conexion;
import com.laboratorio2p3.entidades.*;

public class UsuarioDao {
	//CONEXION A LA BASE DE DATOS 
    Conexion cn = new Conexion();
    Connection con = cn.RetornarConexion();
    
    
    //CONSULTAS A LA BASE DE DATOS 
    
    
    
    //SP_I_USUARIO--COMPLETADO!
    public boolean agregarUsuario(Usuario usuario){
    	boolean guardar=false;
      try {
            CallableStatement statement = con.prepareCall("call SP_I_Usuario(?,?,?,?,?)");
            
            statement.setInt("pIdusu", usuario.getIdUsuario());
            statement.setString("pUsuario", usuario.getUsuario());
            statement.setString("pPass", usuario.getPassWord());
            statement.setString("pTipo", usuario.getTipoUsuario());
            statement.setInt("pId", usuario.getEmpleado().getIdEmpleado());
            //Empleado
            //statement.setInt("pId", usuario.getId());  
            int res=statement.executeUpdate();
            if(res>=1) {
            	guardar=true;
            }
            con.close();
            
            System.out.println("DATOS REGISTRADOS!");
        } catch (Exception e) {
        	System.out.println("ERROR AL REGISTRAR LOS DATOS"+e);
        }     
      	return guardar;
    }
    //SP_U_USUARIO--COMPLETADO!
    public void actualizarUsuario(Usuario usuario) {
        try {
            CallableStatement statement = con.prepareCall("call SP_U_Usuario(?,?,?,?)");
            
            statement.setInt("pIdusu", usuario.getIdUsuario());  
            statement.setString("pUsuario", usuario.getUsuario());
            statement.setString("pTipo", usuario.getTipoUsuario());
            //Empleado
            //statement.setInt("pId", usuario.getId());  
            //System.out.println(usuario.getIdUsuario()+"-"+usuario.getUsuario()+"-"+usuario.getPass()+"-"+usuario.getTipo()+"-"+usuario.getId());
            int i =statement.executeUpdate();
            if(i==1){
            	System.out.println("USUARIO ACTUALIZADOOOOOOOO!");
            }else{
            	System.out.println("Error al Actualizar");
            }
            con.close();
        } catch (Exception e) {
        	System.out.println("ERROR AL ACTUALIZAR");
        }
    }
    public void actualizarUsuario(Usuario usuario, String passUdate) {
        try {
            CallableStatement statement = con.prepareCall("call SP_U_Usuario2(?,?,?,?,?)");
            
            statement.setInt("pIdusu", usuario.getIdUsuario());  
            statement.setString("pUsuario", usuario.getUsuario());
            statement.setString("pPass", passUdate);
            statement.setString("pTipo", usuario.getTipoUsuario());
            //Empleado
            //statement.setInt("pId", usuario.getId());  
            //System.out.println(usuario.getIdUsuario()+"-"+usuario.getUsuario()+"-"+usuario.getPass()+"-"+usuario.getTipo()+"-"+usuario.getId());
            int i =statement.executeUpdate();
            if(i==1){
            	System.out.println("USUARIO ACTUALIZADO");
            }else{
            	System.out.println("Error al Actualizar");
            }
            con.close();
        } catch (Exception e) {
        	System.out.println("ERROR AL ACTUALIZAR");
        }
    }
       
    //SP_D_USUARIO--COMPLETADO!
    public void eliminarUsuario(Usuario usuario) {
        
         try {
            CallableStatement statement = con.prepareCall("call SP_D_Usuario(?);");
            
            statement.setInt("pIdusu", usuario.getIdUsuario());  
          
            statement.execute();
            con.close();
            
            System.out.println("USUARIO ELIMINADO");                      
        } catch (Exception e) {
        	System.out.println("ERROR AL INTENTAR ELIMINAR LOS DATOS" + e);
        }
    }
    
    //SP_S_USUARIO--COMPLETADO!
     public ArrayList<Usuario> TraerUsuarios() {
        var listado = new ArrayList<Usuario>();
        
        try {
            CallableStatement statement = con.prepareCall("call SP_S_Usuario;");
            ResultSet us = statement.executeQuery();
            
            while (us.next()) {
                
                Usuario usua = new Usuario();
                
                usua.setIdUsuario(us.getInt("idUsuario"));
                usua.setUsuario(us.getString("Usuario"));
                usua.setPassWord(us.getString("Pass"));
                usua.setTipoUsuario(us.getString("Tipo"));
                //Empleado
                //usua.setId(us.getInt("idEmpleado"));
                Empleado emp = new Empleado();
                emp.setIdEmpleado(us.getInt("idEmpleado"));
                emp.setNombre(us.getString("Nombre"));
                usua.setEmpleado(emp);
                listado.add(usua);
            }
            
        } catch (Exception e) {
        	System.out.println("DATOS DE USUARIO NO CARGADOS " + e);
        }

        return listado;
    }
     
     //SP_S_INGRESAR--COMPLETADO!:para el ingreso
     public Usuario Login(Login user) {
        Usuario usu = new Usuario();
        try {
            CallableStatement statement = con.prepareCall("call SP_S_Ingresar(?,?,?);");
            
            statement.setString("pUsuario", user.getUser());
            statement.setString("pPass", user.getPass());
            statement.setString("pTipo", user.getTipo());      
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                usu.setIdUsuario(result.getInt("idUsuario"));
                usu.setUsuario(result.getString("Usuario"));
                usu.setPassWord(result.getString("Pass"));
                usu.setTipoUsuario(result.getString("Tipo"));                        
            }
            
        } catch (Exception e) {
        	System.out.println("Credenciales no válidas" + e);
        }
        return usu;
    }
    
}
