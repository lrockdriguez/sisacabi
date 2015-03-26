package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.EstadosSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.Estado;
import com.equidad.sisddeq.entidades.SisddeqCOrganizacion;

@Named
public class EstadosSisddeqDAOImpl extends GenericDAOImpl<Estado, Integer>
		implements EstadosSisddeqDAO {

	@Override
	public List<Estado> consultaEstados() {
		List<Estado> listaEstados = new ArrayList<Estado>();
		
		TypedQuery<Estado> query = em.createQuery(
				"SELECT s FROM Estado s ORDER BY s.id ASC",
				Estado.class);
		try {
			listaEstados = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error al hacer la consulta::" + e);
			listaEstados = null;
		}
		return listaEstados;
	}

}
