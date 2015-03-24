package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.PropositoSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCPoblacion;
import com.equidad.sisddeq.entidades.SisddeqCProposito;

@Named
public class PropositoSisddeqDAOImpl extends
		GenericDAOImpl<SisddeqCProposito, Integer> implements
		PropositoSisddeqDAO {

	@Override
	public List<SisddeqCProposito> consultaProposito() {
		List<SisddeqCProposito> listaProposito = new ArrayList<SisddeqCProposito>();
		TypedQuery<SisddeqCProposito> query = em.createQuery(
				"SELECT s FROM SisddeqCProposito s",
				SisddeqCProposito.class);

		try {
			listaProposito = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error al hacer la consulta::" + e);
			listaProposito = null;
		}
		return listaProposito;
	}


}
