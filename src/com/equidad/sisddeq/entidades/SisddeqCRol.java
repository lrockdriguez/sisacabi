package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sisddeq_c_rol database table.
 * 
 */
@Entity
@Table(name="sisddeq_c_rol")
@NamedQuery(name="SisddeqCRol.findAll", query="SELECT s FROM SisddeqCRol s")
public class SisddeqCRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRol;

	@Lob
	private String descripcion;

	private String rol;

	//bi-directional many-to-many association to SisddeqCMenu
	@ManyToMany
	@JoinTable(
		name="sisddeq_c_rol_has_sisddeq_c_menu"
		, joinColumns={
			@JoinColumn(name="sisddeq_c_rol_idRol")
			}
		, inverseJoinColumns={
			@JoinColumn(name="sisddeq_c_menu_idMenu")
			}
		)
	private List<SisddeqCMenu> sisddeqCMenus;

	public SisddeqCRol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<SisddeqCMenu> getSisddeqCMenus() {
		return this.sisddeqCMenus;
	}

	public void setSisddeqCMenus(List<SisddeqCMenu> sisddeqCMenus) {
		this.sisddeqCMenus = sisddeqCMenus;
	}

}