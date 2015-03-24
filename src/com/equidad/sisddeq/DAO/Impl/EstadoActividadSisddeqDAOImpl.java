package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.EstadoActividadSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCEstadoActividad;
import com.equidad.sisddeq.entidades.SisddeqCRol;

@Named
public class EstadoActividadSisddeqDAOImpl extends
		GenericDAOImpl<SisddeqCEstadoActividad, Integer> implements
		EstadoActividadSisddeqDAO {

	public List<SisddeqCEstadoActividad> consultaActividades() {
		return null;
	}

	public List<SisddeqCEstadoActividad> consultaEstadoActividad() {
		List<SisddeqCEstadoActividad> listaActividad = new ArrayList<SisddeqCEstadoActividad>();
		TypedQuery<SisddeqCEstadoActividad> query = em.createQuery(
				"SELECT s FROM SisddeqCEstadoActividad s",
				SisddeqCEstadoActividad.class);

		try {
			listaActividad = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error al hacer la consulta::" + e);
			listaActividad = null;
		}

		return listaActividad;

	}
	
}
