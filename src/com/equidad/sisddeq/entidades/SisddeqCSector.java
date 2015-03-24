package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sisddeq_c_sector database table.
 * 
 */
@Entity
@Table(name="sisddeq_c_sector")
@NamedQuery(name="SisddeqCSector.findAll", query="SELECT s FROM SisddeqCSector s")
public class SisddeqCSector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSector;

	@Lob
	private String descripcion;

	private String nombre;

	public SisddeqCSector() {
	}

	public int getIdSector() {
		return this.idSector;
	}

	public void setIdSector(int idSector) {
		this.idSector = idSector;
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