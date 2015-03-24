package com.equidad.sisddeq.service.impl;

import java.util.List;

import javax.inject.Named;

import com.equidad.sisddeq.DAO.Impl.OrganizacionSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCOrganizacion;
import com.equidad.sisddeq.service.OrganizacionService;

@Named("organizacionServiceImpl")
public class OrganizacionServiceImpl implements OrganizacionService {
	
	public static OrganizacionSisddeqDAOImpl organizacionSisddeqDAO = new OrganizacionSisddeqDAOImpl();

	@Override
	public List<SisddeqCOrganizacion> consultaOrganizacion() {
		return organizacionSisddeqDAO.consultaOrganizacion();
	}

	@Override
	public void crearOrganizacion(SisddeqCOrganizacion sisddeqCOrganizacion) {
		organizacionSisddeqDAO.crear(sisddeqCOrganizacion);
	}

	@Override
	public void eliminarOrganizacion(SisddeqCOrganizacion sisddeqCOrganizacion) {
		organizacionSisddeqDAO.borrar(sisddeqCOrganizacion.getIdOrganizacion());
		
	}

	@Override
	public SisddeqCOrganizacion consultaOrganizacionPorId(int idOrganizacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
