package com.equidad.sisddeq.service.impl;

import java.util.List;

import com.equidad.sisddeq.DAO.Impl.PoblacionSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCPoblacion;
import com.equidad.sisddeq.service.PoblacionSisddeqService;

public class PoblacionSisddeqServiceImpl implements PoblacionSisddeqService {

	public static PoblacionSisddeqDAOImpl poblacionSisddeqDAOImpl = new PoblacionSisddeqDAOImpl();

	@Override
	public List<SisddeqCPoblacion> consultaOrganizacion() {
		return poblacionSisddeqDAOImpl.consultaPoblacion();
	}

	@Override
	public void crearPoblacion(SisddeqCPoblacion sisddeqCPoblacion) {
		poblacionSisddeqDAOImpl.crear(sisddeqCPoblacion);

	}

	@Override
	public void eliminarPoblacion(SisddeqCPoblacion sisddeqCPoblacion) {
		poblacionSisddeqDAOImpl.borrar(sisddeqCPoblacion
				.getIdsisddeqCPoblacion());
	}

	@Override
	public SisddeqCPoblacion consultaPoblacionPorId(int sisddeqCPoblacion) {

		return poblacionSisddeqDAOImpl.buscaPorId(sisddeqCPoblacion);
	}

}
