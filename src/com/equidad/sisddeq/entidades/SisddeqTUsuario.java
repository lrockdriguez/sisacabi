package com.equidad.sisddeq.entidades;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the sisddeq_t_usuario database table.
 * 
 */
@Entity(name = "sisddeqTUsuario")
@Table(name="sisddeq_t_usuario")
public class SisddeqTUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuario;

	private String email;

	private String password;
	
	private String rol;

	public SisddeqTUsuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int id) {
		this.idUsuario = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	

}