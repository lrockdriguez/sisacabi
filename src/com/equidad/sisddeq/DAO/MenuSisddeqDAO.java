package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.SisddeqCEstadoActividad;
import com.equidad.sisddeq.entidades.SisddeqCMenu;


public interface MenuSisddeqDAO extends GenericDAO<SisddeqCMenu, Integer> {

	public List<SisddeqCMenu> consultaMenu();
	
}
