package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sisddeq_c_estado_actividad database table.
 * 
 */
@Entity
@Table(name="sisddeq_c_estado_actividad")
@NamedQuery(name="SisddeqCEstadoActividad.findAll", query="SELECT s FROM SisddeqCEstadoActividad s")
public class SisddeqCEstadoActividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEstado;

	@Lob
	private String descripcion;

	private String nombre;

	public SisddeqCEstadoActividad() {
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
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