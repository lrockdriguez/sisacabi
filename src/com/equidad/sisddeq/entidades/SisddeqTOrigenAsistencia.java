package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sisddeq_t_origen_asistencia database table.
 * 
 */
@Entity
@Table(name="sisddeq_t_origen_asistencia")
@NamedQuery(name="SisddeqTOrigenAsistencia.findAll", query="SELECT s FROM SisddeqTOrigenAsistencia s")
public class SisddeqTOrigenAsistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idOAsistencia;

	@Lob
	private String descripcion;

	private String nombre;

	public SisddeqTOrigenAsistencia() {
	}

	public int getIdOAsistencia() {
		return this.idOAsistencia;
	}

	public void setIdOAsistencia(int idOAsistencia) {
		this.idOAsistencia = idOAsistencia;
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