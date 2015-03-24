package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sisddeq_c_poblacion database table.
 * 
 */
@Entity
@Table(name="sisddeq_c_poblacion")
@NamedQuery(name="SisddeqCPoblacion.findAll", query="SELECT s FROM SisddeqCPoblacion s")
public class SisddeqCPoblacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idsisddeq_c_poblacion")
	private int idsisddeqCPoblacion;

	@Lob
	private String descripcion;

	private String nombre;

	public SisddeqCPoblacion() {
	}

	public int getIdsisddeqCPoblacion() {
		return this.idsisddeqCPoblacion;
	}

	public void setIdsisddeqCPoblacion(int idsisddeqCPoblacion) {
		this.idsisddeqCPoblacion = idsisddeqCPoblacion;
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