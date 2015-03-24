package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.SisddeqCProyecto;

public interface ProyectosSisddeqDAO extends GenericDAO<SisddeqCProyecto, Integer> {

	public List<SisddeqCProyecto> consultaProyecto();
}
