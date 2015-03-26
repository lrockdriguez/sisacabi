package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the municipios database table.
 * 
 */
@Entity
@Table(name = "municipios")
@NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String clave;

	@Column(name="estado_id")
	private int estadoId;

	private String nombre;

	private String sigla;

	public Municipio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getEstadoId() {
		return this.estadoId;
	}

	public void setEstadoId(int estadoId) {
		this.estadoId = estadoId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}