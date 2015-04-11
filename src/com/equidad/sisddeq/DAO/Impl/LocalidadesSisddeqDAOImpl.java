package com.equidad.sisddeq.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import com.equidad.sisddeq.DAO.LocalidadesSisddeqDAO;
import com.equidad.sisddeq.common.GenericDAOImpl;
import com.equidad.sisddeq.entidades.Estado;
import com.equidad.sisddeq.entidades.Localidade;
import com.equidad.sisddeq.entidades.Municipio;


public class LocalidadesSisddeqDAOImpl extends
		GenericDAOImpl<Localidade, Integer> implements LocalidadesSisddeqDAO {

	@Override
	public List<Localidade> consultaLocalidadPorMunicipio(int idMunicipio) {
		List<Localidade> listaLocalidade = new ArrayList<Localidade>();

		TypedQuery<Localidade> query = em.createQuery(

				"SELECT l FROM Localidade l where l.municipioId = "+idMunicipio, Localidade.class);

		try {
			listaLocalidade = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error al hacer la consulta::" + e);
			listaLocalidade = null;
		}
		return listaLocalidade;
	}

}
