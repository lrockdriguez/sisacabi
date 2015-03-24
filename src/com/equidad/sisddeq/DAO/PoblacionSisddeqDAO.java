package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.SisddeqCPoblacion;
 
public interface PoblacionSisddeqDAO extends GenericDAO<SisddeqCPoblacion, Integer> {
	
	public List<SisddeqCPoblacion> consultaPoblacion();

}
