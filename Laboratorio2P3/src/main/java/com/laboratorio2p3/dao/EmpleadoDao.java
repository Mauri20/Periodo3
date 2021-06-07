package com.laboratorio2p3.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.laboratorio2p3.conexion.Conexion;
import com.laboratorio2p3.entidades.Empleado;

public class EmpleadoDao {
	Conexion cn = new Conexion();
    Connection con = cn.RetornarConexion();

    
    
    
    public void AgregarEmpleado(Empleado empleado) {
        try {
            CallableStatement statement = con.prepareCall("call sp_i_Empleado(?,?,?,?,?,?,?,?,?)");
            statement.setString("pNombre", empleado.getNombre());
            statement.setString("pApellido", empleado.getApellido());
            statement.setString("pSexo", empleado.getSexo());
            statement.setString("pDireccion", empleado.getDireccion());
            statement.setString("pTelefono", empleado.getTelefono());
            statement.setString("pDui", empleado.getDui());
            statement.setString("pNit", empleado.getNit());
            statement.setString("pCargo", empleado.getCargo());
            statement.setString("pDepartamento", empleado.getDepartamento());
            statement.execute();
            
            con.close();
            System.out.println("El Empleado ha sido guardado exitosamente");
        } catch (Exception e) {
        	System.out.println("UPS! algo ha ido mal al intentar guardar (verifique)" + e);

        }

    }
    
    
    public void ActualizarEmpleado(Empleado empleado) {
        try {
            CallableStatement statement = con.prepareCall("call sp_u_Empleado(?,?,?,?,?,?,?,?,?,?)");
            statement.setInt("pId", empleado.getIdEmpleado());
            statement.setString("pNombre", empleado.getNombre());
            statement.setString("pApellido", empleado.getApellido());
            statement.setString("pSexo", empleado.getSexo());
            statement.setString("pDireccion", empleado.getDireccion());
            statement.setString("pTelefono", empleado.getTelefono());
            statement.setString("pDui", empleado.getDui());
            statement.setString("pNit", empleado.getNit());
            statement.setString("pCargo", empleado.getCargo());
            statement.setString("pDepartamento", empleado.getDepartamento());
            statement.execute();
            
            con.close();
            System.out.println("El Empleado ha sido actualizado exitosamente");
        } catch (Exception e) {
        	System.out.println("UPS! algo ha ido mal al intentar actualizado (verifique)" + e);

        }

    }
    
    
    
    
    public void EliminarEmpleado(Empleado empleado) {
        
    	try {
           CallableStatement statement = con.prepareCall("call sp_d_Empleado(?);");
           statement.setInt("pIdEmpleado", empleado.getIdEmpleado());
           statement.execute();
                    
           System.out.println("El Empleado ha sido eliminado exitosamente");
           con.close();
       } catch (Exception e) {
       	System.out.println("UPS! algo ha ido mal al intentar eliminar (verifique)" + e);

       }
   }
    
    
    
    
    public ArrayList<Empleado> MostrarEmpleados() {
        var listing = new ArrayList<Empleado>();
        
        try {
            CallableStatement statement = con.prepareCall("call sp_s_Empleado;");
            ResultSet res = statement.executeQuery();
            while (res.next())
            	
            
            {
                Empleado empleados = new Empleado();
                empleados.setIdEmpleado(res.getInt("idEmpleado"));
                empleados.setNombre(res.getString("Nombre"));
                empleados.setApellido(res.getString("Apellido"));
                empleados.setSexo(res.getString("Sexo"));
                empleados.setDireccion(res.getString("Direccion"));
                empleados.setTelefono(res.getString("Telefono"));
                empleados.setDui(res.getString("Dui"));
                empleados.setNit(res.getString("Nit"));
                empleados.setCargo(res.getString("Cargo"));
                empleados.setDepartamento(res.getString("Departamento"));
                listing.add(empleados);                
            }
            
            
            
        } catch (Exception e) {
            System.out.println("UPS! algo ha ido mal al intentar mostrar los datos (verifique)" + e);
        }

        return listing;
    }
    
    
    
    
}
