package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.Estado;

public interface EstadosSisddeqDAO extends GenericDAO<Estado, Integer>{

	public List<Estado> consultaEstados();
}
