package com.laboratorio2p3.dao;

import java.sql.*;
import java.util.ArrayList;

import com.laboratorio2p3.conexion.Conexion;
import com.laboratorio2p3.entidades.Cliente;

public class ClienteDao {

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
        	System.out.println("Error al guardar a cliente" + e);

        }

    }

    public void ActualizarCliente(Cliente cliente) {
        try {
            CallableStatement statement = con.prepareCall("call SP_U_Cliente(?,?,?,?,?,?,?,?,?,?)");
            statement.setInt("CIdCliente", cliente.getIdCliente());
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
            System.out.println("Cliente Actualizado Correctamente");
        } catch (Exception e) {
        	System.out.println("Error al Actualizar a Cliente" + e);

        }

    }

    public void EliminarCliente(Cliente cliente) {
    	try {
            CallableStatement statement = con.prepareCall("call SP_D_Cliente(?);");
            statement.setInt("CIdCliente", cliente.getIdCliente());
            statement.execute();
                     
            System.out.println("El Cliente ha sido eliminado exitosamente");
            con.close();
        } catch (Exception e) {
        	System.out.println("UPS! algo ha ido mal al intentar eliminar (verifique)" + e);

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
