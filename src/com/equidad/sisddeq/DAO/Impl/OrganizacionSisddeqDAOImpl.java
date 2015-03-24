package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.OrganizacionSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCEstadoActividad;
import com.equidad.sisddeq.entidades.SisddeqCOrganizacion;

@Named
public class OrganizacionSisddeqDAOImpl extends GenericDAOImpl<SisddeqCOrganizacion, Integer> implements OrganizacionSisddeqDAO {

	
	public List<SisddeqCOrganizacion> consultaOrganizacion() {
		List<SisddeqCOrganizacion> listaOrganizacion = new ArrayList<SisddeqCOrganizacion>();
		TypedQuery<SisddeqCOrganizacion> query = em.createQuery(
				"SELECT s FROM SisddeqCOrganizacion s",
				SisddeqCOrganizacion.class);

		try {
			listaOrganizacion = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error al hacer la consulta::" + e);
			listaOrganizacion = null;
		}

		return listaOrganizacion;

	}
	
}
