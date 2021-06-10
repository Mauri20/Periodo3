package com.laboratorio2p3.entidades;

public class Usuario{
	private int idUsuario;
	private String Usuario;
    private String PassWord;
    private String tipoUsuario;
    private Empleado Empleado;
    
    
    public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public Empleado getEmpleado() {
		return Empleado;
	}
	public void setEmpleado(Empleado empleado) {
		Empleado = empleado;
	}
}
