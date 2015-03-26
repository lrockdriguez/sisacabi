package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.Localidade;

public interface LocalidadesSisddeqDAO extends GenericDAO<Localidade, Integer>{
	
	public List<Localidade> consultaLocalidadPorMunicipio(int idMunicipio);

}
