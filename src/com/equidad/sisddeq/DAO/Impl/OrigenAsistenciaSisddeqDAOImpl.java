package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.OrigenAsistenciaSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqTOrigenAsistencia;

@Named
public class OrigenAsistenciaSisddeqDAOImpl extends
		GenericDAOImpl<SisddeqTOrigenAsistencia, Integer> implements
		OrigenAsistenciaSisddeqDAO {

	@Override
	public List<SisddeqTOrigenAsistencia> consultaOrigenAsistencia() {
		List<SisddeqTOrigenAsistencia> listaOrigenAsistencia= new ArrayList<SisddeqTOrigenAsistencia>();
		TypedQuery<SisddeqTOrigenAsistencia> query = em.createQuery(
				"SELECT s FROM SisddeqTOrigenAsistencia s",
				SisddeqTOrigenAsistencia.class);

		try {
			listaOrigenAsistencia = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error al hacer la consulta::" + e);
			listaOrigenAsistencia = null;
		}
		return listaOrigenAsistencia;
	}

}
