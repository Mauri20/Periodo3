package com.laboratorio2p3.dao;

import java.sql.*;
import java.util.ArrayList;

import com.laboratorio2p3.conexion.Conexion;
import com.laboratorio2p3.entidades.*;

public class ClienteDao {
	Cliente cl = new Cliente();
	Conexion cn = new Conexion();
    Connection con = cn.RetornarConexion();

    //METODOS DE ACCESO A LA BASE DE DATOS
    public void AgregarCliente(Cliente cliente) {
        try {
            CallableStatement statement = con.prepareCall("call SP_I_Cliente(?,?,?,?,?,?,?,?,?)");
            statement.setString("CNombre", cliente.getNombre());
            statement.setString("CTipo", cliente.getTipo());
            statement.setString("CContacto", cliente.getContacto());
            statement.setString("CTelefono", cliente.getTelefono());
            statement.setString("CDireccion", cliente.getDireccion());
            statement.setString("CCorreo", cliente.getCorreo());
            statement.setString("CDui", cliente.getDui());
            statement.setString("CNit", cliente.getNit());
            statement.setString("CNrc", cliente.getNrc());
            statement.execute();
            con.close();
            System.out.println("Cliente Guardado Correctamente");
        } catch (Exception e) {
        	System.out.println("Error al guardar a cliente");

        }

    }

    public void ActualizarCliente(Cliente cliente) {
        try {
            CallableStatement statement = con.prepareCall("call SP_U_Cliente(?,?,?,?,?,?,?,?,?,?)");
            statement.setString("CNombre", cliente.getNombre());
            statement.setInt("CIdCliente", cliente.getIdCliente());
            statement.setString("CTipo", cliente.getTipo());
            statement.setString("CContacto", cliente.getContacto());
            statement.setString("CTelefono", cliente.getTelefono());
            statement.setString("CDireccion", cliente.getDireccion());
            statement.setString("CCorreo", cliente.getCorreo());
            statement.setString("CDui", cliente.getDui());
            statement.setString("CNit", cliente.getNit());
            statement.setString("CNrc", cliente.getNrc());
            statement.execute();
            con.close();
            System.out.println("Cliente Actualizado Correctamente");
        } catch (Exception e) {
        	System.out.println("Error al Actualizar a Cliente");

        }

    }

    public void EliminarCliente(int cliente) {
         try {
        	 CallableStatement statement = con.prepareCall("delete from cliente where idcliente=" + cliente + ";");
             if (statement.executeUpdate() >= 1) {
                 CallableStatement statement2 = con.prepareCall("call SP_D_Cliente(?);");
                 statement2.setInt("IdCliente", cliente );
            con.close();
             }else {
            	System.out.println("Ocurrio un error eliminando el Cliente!");
             }
             } catch (Exception e) {
        	System.out.println("Ocurrio un error al eliminar a cliente" + e);

        }
         }
    

    public ArrayList<Cliente> MostrarClientes() {
        var listado = new ArrayList<Cliente>();
        try {
            CallableStatement statement = con.prepareCall("call SP_S_Cliente;");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Cliente clientes = new Cliente();
                clientes.setIdCliente(res.getInt("idcliente"));
                clientes.setNombre(res.getString("Nombre"));
                clientes.setTipo(res.getString("Tipo"));
                clientes.setContacto(res.getString("Contacto"));
                clientes.setTelefono(res.getString("Telefono"));
                clientes.setDireccion(res.getString("Direccion"));
                clientes.setCorreo(res.getString("Correo"));
                clientes.setDui(res.getString("Dui"));
                clientes.setNit(res.getString("Nit"));
                clientes.setNrc(res.getString("Nrc"));
                listado.add(clientes);
            }
        } catch (Exception e) {
            System.out.println("No se pueden mostrar los clientes debido a un error en el sistema" + e);
        }

        return listado;
    }

}
