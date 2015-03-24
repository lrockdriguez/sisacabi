package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.UsuarioSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqTUsuario;

@Named
public class UsuarioSisddeqDAOImpl extends
		GenericDAOImpl<SisddeqTUsuario, Integer> implements UsuarioSisddeqDAO {

	@Override
	public void insertaUsuarioSisddeq(SisddeqTUsuario sisddeqTUsuario) {
		this.crear(sisddeqTUsuario);

	}

	public SisddeqTUsuario buscaPorEmailYPassword(String email, String password) {
		SisddeqTUsuario sisddeqTUsuario = new SisddeqTUsuario();

		TypedQuery<SisddeqTUsuario> query = em
				.createQuery(
						"SELECT e FROM sisddeqTUsuario e WHERE e.email=:email AND e.password=:password",
						SisddeqTUsuario.class);
		query.setParameter("email", email);
		query.setParameter("password", password);

		try {
			sisddeqTUsuario = query.getSingleResult();
		} catch (Exception e) {
			sisddeqTUsuario = null;
		}

		return sisddeqTUsuario;
	}

	@Override
	public List<SisddeqTUsuario> obtenerUsuarios() {
		List<SisddeqTUsuario> listaAisddeqTUsuario = new ArrayList<SisddeqTUsuario>();

		TypedQuery<SisddeqTUsuario> query = em.createQuery(
				"SELECT e FROM sisddeqTUsuario e ", SisddeqTUsuario.class);

		try {
			listaAisddeqTUsuario = query.getResultList();
		} catch (Exception e) {
			listaAisddeqTUsuario = null;
		}

		return listaAisddeqTUsuario;
	}
	

}
