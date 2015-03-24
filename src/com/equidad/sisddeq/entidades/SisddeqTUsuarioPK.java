package com.equidad.sisddeq.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sisddeq_t_usuario database table.
 * 
 */
@Embeddable
public class SisddeqTUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuario;

	@Column(insertable=false, updatable=false)
	private int sisddeq_t_bitacora_idBitacora;

	public SisddeqTUsuarioPK() {
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getSisddeq_t_bitacora_idBitacora() {
		return this.sisddeq_t_bitacora_idBitacora;
	}
	public void setSisddeq_t_bitacora_idBitacora(int sisddeq_t_bitacora_idBitacora) {
		this.sisddeq_t_bitacora_idBitacora = sisddeq_t_bitacora_idBitacora;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SisddeqTUsuarioPK)) {
			return false;
		}
		SisddeqTUsuarioPK castOther = (SisddeqTUsuarioPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.sisddeq_t_bitacora_idBitacora == castOther.sisddeq_t_bitacora_idBitacora);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuario;
		hash = hash * prime + this.sisddeq_t_bitacora_idBitacora;
		
		return hash;
	}
}