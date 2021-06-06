package com.laboratorio2p3.entidades;

public class Cliente {
	public int IdCliente;
    private String Nombre;
    private String Tipo;
    private String Contacto;
    private String Telefono;
    private String Direccion;
    private String Correo;
    private String Dui;
    private String Nit;
    private String Nrc;
    
	public int getIdCliente() {
		return IdCliente;
	}
	public void setIdCliente(int idCliente) {
		this.IdCliente = idCliente;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		this.Tipo = tipo;
	}
	public String getContacto() {
		return Contacto;
	}
	public void setContacto(String contacto) {
		this.Contacto = contacto;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		this.Telefono = telefono;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		this.Direccion = direccion;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		this.Correo = correo;
	}
	public String getDui() {
		return Dui;
	}
	public void setDui(String dui) {
		this.Dui = dui;
	}
	public String getNit() {
		return Nit;
	}
	public void setNit(String nit) {
		this.Nit = nit;
	}
	public String getNrc() {
		return Nrc;
	}
	public void setNrc(String nrc) {
		this.Nrc = nrc;
	}
}
