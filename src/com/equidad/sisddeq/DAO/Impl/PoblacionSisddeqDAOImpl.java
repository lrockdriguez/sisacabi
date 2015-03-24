package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.PoblacionSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCPoblacion;
import com.equidad.sisddeq.entidades.SisddeqTOrigenAsistencia;

@Named
public class PoblacionSisddeqDAOImpl extends
		GenericDAOImpl<SisddeqCPoblacion, Integer> implements
		PoblacionSisddeqDAO {

	@Override
	public List<SisddeqCPoblacion> consultaPoblacion() {
		List<SisddeqCPoblacion> listaPoblacionAsistencia = new ArrayList<SisddeqCPoblacion>();
		TypedQuery<SisddeqCPoblacion> query = em.createQuery(
				"SELECT s FROM SisddeqCPoblacion s",
				SisddeqCPoblacion.class);

		try {
			listaPoblacionAsistencia = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error al hacer la consulta::" + e);
			listaPoblacionAsistencia = null;
		}
		return listaPoblacionAsistencia;
	}



}
