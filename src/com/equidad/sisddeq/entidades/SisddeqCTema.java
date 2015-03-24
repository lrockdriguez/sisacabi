package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sisddeq_c_tema database table.
 * 
 */
@Entity
@Table(name="sisddeq_c_tema")
//@NamedQuery(name="SisddeqCTema.findAll", query="SELECT s FROM SisddeqCTema s")
public class SisddeqCTema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTema;

	@Lob
	private String descripcion;

	private String nombre;

	public SisddeqCTema() {
	}

	public int getIdTema() {
		return this.idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
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