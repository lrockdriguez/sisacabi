package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.ProyectosSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCProposito;
import com.equidad.sisddeq.entidades.SisddeqCProyecto;

@Named
public class ProyectoSisddeqDAOImpl extends
		GenericDAOImpl<SisddeqCProyecto, Integer> implements
		ProyectosSisddeqDAO {

	@Override
	public List<SisddeqCProyecto> consultaProyecto() {
		List<SisddeqCProyecto> listaSisddeqCProyecto = new ArrayList<SisddeqCProyecto>();
		TypedQuery<SisddeqCProyecto> query = em.createQuery(
				"SELECT s FROM SisddeqCProyecto s",
				SisddeqCProyecto.class);

		try {
			listaSisddeqCProyecto = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error al hacer la consulta::" + e);
			listaSisddeqCProyecto = null;
		}
		return listaSisddeqCProyecto;
	}
	}

	


