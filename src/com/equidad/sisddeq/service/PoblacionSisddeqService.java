package com.equidad.sisddeq.service;

import java.util.List;

import com.equidad.sisddeq.entidades.SisddeqCPoblacion;

public interface PoblacionSisddeqService {

	public List<SisddeqCPoblacion> consultaOrganizacion();

	public void crearPoblacion(SisddeqCPoblacion sisddeqCPoblacion);

	public void eliminarPoblacion(SisddeqCPoblacion sisddeqCPoblacion);

	public SisddeqCPoblacion consultaPoblacionPorId(int sisddeqCPoblacion);
}
