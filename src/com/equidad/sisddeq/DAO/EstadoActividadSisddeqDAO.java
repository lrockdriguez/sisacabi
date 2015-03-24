package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.SisddeqCEstadoActividad;

public interface EstadoActividadSisddeqDAO  extends GenericDAO<SisddeqCEstadoActividad, Integer> {
	
	public List<SisddeqCEstadoActividad> consultaEstadoActividad();
	
	
	

}
