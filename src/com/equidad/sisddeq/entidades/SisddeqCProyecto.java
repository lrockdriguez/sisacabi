package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sisddeq_c_proyectos database table.
 * 
 */
@Entity
@Table(name="sisddeq_c_proyectos")
@NamedQuery(name="SisddeqCProyecto.findAll", query="SELECT s FROM SisddeqCProyecto s")
public class SisddeqCProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProyecto;

	@Lob
	private String descripcion;

	private String nombre;

	public SisddeqCProyecto() {
	}

	public int getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
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

}