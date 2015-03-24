package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sisddeq_c_tipo_bitacora database table.
 * 
 */
@Entity
@Table(name="sisddeq_c_tipo_bitacora")
@NamedQuery(name="SisddeqCTipoBitacora.findAll", query="SELECT s FROM SisddeqCTipoBitacora s")
public class SisddeqCTipoBitacora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idBitacora;

	@Lob
	private String descripcion;

	private String nombre;

	public SisddeqCTipoBitacora() {
	}

	public int getIdBitacora() {
		return this.idBitacora;
	}

	public void setIdBitacora(int idBitacora) {
		this.idBitacora = idBitacora;
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