package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.Municipio;

public interface MunicipiosSisddeqDAO extends GenericDAO<Municipio, Integer>{

	public List<Municipio> consultaMunicipioPorEstado(int idEstado);
}
