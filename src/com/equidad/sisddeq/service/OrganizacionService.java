package com.equidad.sisddeq.service;

import java.util.List;

import com.equidad.sisddeq.entidades.SisddeqCOrganizacion;

public interface OrganizacionService {
	
	public List<SisddeqCOrganizacion> consultaOrganizacion();

	public void crearOrganizacion(SisddeqCOrganizacion sisddeqCOrganizacion);

	public void eliminarOrganizacion(SisddeqCOrganizacion sisddeqCOrganizacion);

	public SisddeqCOrganizacion consultaOrganizacionPorId(int idOrganizacion);
}
