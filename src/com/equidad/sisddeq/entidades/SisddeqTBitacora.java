package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the sisddeq_t_bitacora database table.
 * 
 */
@Entity
@Table(name="sisddeq_t_bitacora")
public class SisddeqTBitacora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idBitacora;

//	//bi-directional many-to-one association to SisddeqTUsuario
//	@OneToMany(mappedBy="sisddeqTBitacora")
//	private List<SisddeqTUsuario> sisddeqTUsuarios;

	public SisddeqTBitacora() {
	}

	public int getIdBitacora() {
		return this.idBitacora;
	}

	public void setIdBitacora(int idBitacora) {
		this.idBitacora = idBitacora;
	}

//	public List<SisddeqTUsuario> getSisddeqTUsuarios() {
//		return this.sisddeqTUsuarios;
//	}
//
//	public void setSisddeqTUsuarios(List<SisddeqTUsuario> sisddeqTUsuarios) {
//		this.sisddeqTUsuarios = sisddeqTUsuarios;
//	}
//
//	public SisddeqTUsuario addSisddeqTUsuario(SisddeqTUsuario sisddeqTUsuario) {
//		getSisddeqTUsuarios().add(sisddeqTUsuario);
//		sisddeqTUsuario.setSisddeqTBitacora(this);

//		return sisddeqTUsuario;
//	}
//
//	public SisddeqTUsuario removeSisddeqTUsuario(SisddeqTUsuario sisddeqTUsuario) {
//		getSisddeqTUsuarios().remove(sisddeqTUsuario);
//		sisddeqTUsuario.setSisddeqTBitacora(null);
//
//		return sisddeqTUsuario;
//	}

}