package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the localidades database table.
 * 
 */
@Entity
@Table(name="localidades")
@NamedQuery(name="Localidade.findAll", query="SELECT l FROM Localidade l")
public class Localidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String altitud;

	private String clave;

	private String latitud;

	private String longitud;

	//@Column(name="municipio_id")
	//private int municipioId;

	private String nombre;

	public Localidade() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAltitud() {
		return this.altitud;
	}

	public void setAltitud(String altitud) {
		this.altitud = altitud;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

//	public int getMunicipioId() {
//		return this.municipioId;
//	}
//
//	public void setMunicipioId(int municipioId) {
//		this.municipioId = municipioId;
//	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}