package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sisddeq_c_organizacion database table.
 * 
 */
@Entity
@Table(name="sisddeq_c_organizacion")
@NamedQuery(name="SisddeqCOrganizacion.findAll", query="SELECT s FROM SisddeqCOrganizacion s")
public class SisddeqCOrganizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idOrganizacion;

	@Lob
	private String descripcion;

	private String nombre;

	@Column(name="sisddeq_c_organizacionescol")
	private String sisddeqCOrganizacionescol;

	public SisddeqCOrganizacion() {
	}

	public int getIdOrganizacion() {
		return this.idOrganizacion;
	}

	public void setIdOrganizacion(int idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSisddeqCOrganizacionescol() {
		return this.sisddeqCOrganizacionescol;
	}

	public void setSisddeqCOrganizacionescol(String sisddeqCOrganizacionescol) {
		this.sisddeqCOrganizacionescol = sisddeqCOrganizacionescol;
	}

}