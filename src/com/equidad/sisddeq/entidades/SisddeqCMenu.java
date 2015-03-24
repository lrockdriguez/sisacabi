package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sisddeq_c_menu database table.
 * 
 */
@Entity
@Table(name="sisddeq_c_menu")
@NamedQuery(name="SisddeqCMenu.findAll", query="SELECT s FROM SisddeqCMenu s")
public class SisddeqCMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMenu;

	@Lob
	private String descripcion;

	private String hijo;

	private String padre;

	//bi-directional many-to-many association to SisddeqCRol
	@ManyToMany(mappedBy="sisddeqCMenus")
	private List<SisddeqCRol> sisddeqCRols;

	public SisddeqCMenu() {
	}

	public int getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHijo() {
		return this.hijo;
	}

	public void setHijo(String hijo) {
		this.hijo = hijo;
	}

	public String getPadre() {
		return this.padre;
	}

	public void setPadre(String padre) {
		this.padre = padre;
	}

	public List<SisddeqCRol> getSisddeqCRols() {
		return this.sisddeqCRols;
	}

	public void setSisddeqCRols(List<SisddeqCRol> sisddeqCRols) {
		this.sisddeqCRols = sisddeqCRols;
	}

}