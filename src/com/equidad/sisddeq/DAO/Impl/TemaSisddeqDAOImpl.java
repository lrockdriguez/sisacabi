package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.TemaSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCSector;
import com.equidad.sisddeq.entidades.SisddeqCTema;

@Named
public class TemaSisddeqDAOImpl extends GenericDAOImpl<SisddeqCTema, Integer>
		implements TemaSisddeqDAO {

	@Override
	public List<SisddeqCTema> consultaTema() {
		List<SisddeqCTema> listaSisddeqCTema= new ArrayList<SisddeqCTema>();
		TypedQuery<SisddeqCTema> query = em.createQuery(
				"SELECT s FROM SisddeqCTema s",
				SisddeqCTema.class);

		try {
			listaSisddeqCTema = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error al hacer la consulta::" + e);
			listaSisddeqCTema = null;
		}
		return listaSisddeqCTema;
	}

	

}
