package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.RolSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCRol;

public class RolSisddeqDAOImpl extends GenericDAOImpl<SisddeqCRol, Integer>
		implements RolSisddeqDAO {


	public List<SisddeqCRol> consultaRol() {
		List<SisddeqCRol> listaRoles = new ArrayList<SisddeqCRol>();
		TypedQuery<SisddeqCRol> query = em.createQuery(
				"SELECT s FROM SisddeqCRol s", SisddeqCRol.class);

		try {
			listaRoles = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error al hacer la consulta::"+e);
			listaRoles = null;
		}

		return listaRoles;
	}

}
