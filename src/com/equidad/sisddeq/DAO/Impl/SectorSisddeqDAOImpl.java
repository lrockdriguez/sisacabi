package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.SectorSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCProyecto;
import com.equidad.sisddeq.entidades.SisddeqCSector;

@Named
public class SectorSisddeqDAOImpl extends
		GenericDAOImpl<SisddeqCSector, Integer> implements SectorSisddeqDAO {

	@Override
	public List<SisddeqCSector> consultaSector() {
		List<SisddeqCSector> listaSisddeqCSector = new ArrayList<SisddeqCSector>();
		TypedQuery<SisddeqCSector> query = em.createQuery(
				"SELECT s FROM SisddeqCSector s",
				SisddeqCSector.class);

		try {
			listaSisddeqCSector = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error al hacer la consulta::" + e);
			listaSisddeqCSector = null;
		}
		return listaSisddeqCSector;
	}

}
