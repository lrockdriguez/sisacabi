package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.TipoBitacoraSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCTema;
import com.equidad.sisddeq.entidades.SisddeqCTipoBitacora;

public class TipoBitacoraSisddeqDAOImpl extends
		GenericDAOImpl<SisddeqCTipoBitacora, Integer> implements
		TipoBitacoraSisddeqDAO {

	@Override
	public List<SisddeqCTipoBitacora> consultaTipoBitacora() {
		List<SisddeqCTipoBitacora> listaSisddeqCTipoBitacora= new ArrayList<SisddeqCTipoBitacora>();
		TypedQuery<SisddeqCTipoBitacora> query = em.createQuery(
				"SELECT s FROM SisddeqCTipoBitacora s",
				SisddeqCTipoBitacora.class);

		try {
			listaSisddeqCTipoBitacora = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error al hacer la consulta::" + e);
			listaSisddeqCTipoBitacora = null;
		}
		return listaSisddeqCTipoBitacora;
	}

}
