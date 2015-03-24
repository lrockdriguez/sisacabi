package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.SisddeqCRol;

public interface RolSisddeqDAO  extends GenericDAO<SisddeqCRol, Integer>{
	
	public List<SisddeqCRol> consultaRol();

}
