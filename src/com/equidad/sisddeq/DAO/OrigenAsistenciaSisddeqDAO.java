package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.SisddeqCEstadoActividad;
import com.equidad.sisddeq.entidades.SisddeqTOrigenAsistencia;

public interface OrigenAsistenciaSisddeqDAO extends GenericDAO<SisddeqTOrigenAsistencia, Integer>{

	
	public List<SisddeqTOrigenAsistencia> consultaOrigenAsistencia();
}
