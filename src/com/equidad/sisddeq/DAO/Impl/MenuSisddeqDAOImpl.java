package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.MenuSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCEstadoActividad;
import com.equidad.sisddeq.entidades.SisddeqCMenu;

@Named
public class MenuSisddeqDAOImpl extends GenericDAOImpl<SisddeqCMenu, Integer> implements MenuSisddeqDAO{

	@Override
	public List<SisddeqCMenu> consultaMenu() {
		List<SisddeqCMenu> listaSisddeqCMenu = new ArrayList<SisddeqCMenu>();
		TypedQuery<SisddeqCMenu> query = em.createQuery(
				"SELECT s FROM SisddeqCMenu s",
				SisddeqCMenu.class);

		try {
			listaSisddeqCMenu = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error al hacer la consulta::" + e);
			listaSisddeqCMenu = null;
		}

		return listaSisddeqCMenu;
	}

	
	
	

}
