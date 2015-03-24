package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sisddeq_c_proposito database table.
 * 
 */
@Entity
@Table(name="sisddeq_c_proposito")
public class SisddeqCProposito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProposito;

	@Lob
	private String descripcion;

	private String nombre;

	public SisddeqCProposito() {
	}

	public int getIdProposito() {
		return this.idProposito;
	}

	public void setIdProposito(int idProposito) {
		this.idProposito = idProposito;
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