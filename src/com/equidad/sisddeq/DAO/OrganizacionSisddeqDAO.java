package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.SisddeqCOrganizacion;

public interface OrganizacionSisddeqDAO extends
		GenericDAO<SisddeqCOrganizacion, Integer> {

	public List<SisddeqCOrganizacion> consultaOrganizacion();

}
