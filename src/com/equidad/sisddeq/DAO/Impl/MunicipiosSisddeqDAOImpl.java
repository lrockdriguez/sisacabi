package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.MunicipiosSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.Estado;
import com.equidad.sisddeq.entidades.Municipio;

public class MunicipiosSisddeqDAOImpl extends
		GenericDAOImpl<Municipio, Integer> implements MunicipiosSisddeqDAO {

	@Override
	public List<Municipio> consultaMunicipioPorEstado(int idEstado) {
		List<Municipio> listaMunicipio = new ArrayList<Municipio>();

		TypedQuery<Municipio> query = em.createQuery(
				"SELECT m FROM Municipio m where m.estadoId = "+idEstado, Municipio.class);
		try {
			listaMunicipio = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error al hacer la consulta::" + e);
			listaMunicipio = null;
		}
		return listaMunicipio;
	}

}
