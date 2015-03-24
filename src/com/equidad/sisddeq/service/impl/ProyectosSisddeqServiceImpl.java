package com.equidad.sisddeq.service.impl;

import java.util.List;

import com.equidad.sisddeq.DAO.Impl.ProyectoSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCProyecto;
import com.equidad.sisddeq.service.ProyectosSisddeqService;

public class ProyectosSisddeqServiceImpl implements ProyectosSisddeqService {

	public static ProyectoSisddeqDAOImpl proyectoSisddeqDAOImpl = new ProyectoSisddeqDAOImpl();
	
	@Override
	public List<SisddeqCProyecto> consultaProyecto() {
		// TODO Auto-generated method stub
		return proyectoSisddeqDAOImpl.consultaProyecto();
	}

	@Override
	public void crearProyecto(SisddeqCProyecto sisddeqCProyecto) {
		proyectoSisddeqDAOImpl.crear(sisddeqCProyecto);
		
	}

	@Override
	public void eliminarProyecto(SisddeqCProyecto sisddeqCProyecto) {
		proyectoSisddeqDAOImpl.borrar(sisddeqCProyecto.getIdProyecto());
		
	}

	@Override
	public SisddeqCProyecto consultaProyectoPorId(int idProyecto) {
		// TODO Auto-generated method stub
		return proyectoSisddeqDAOImpl.buscaPorId(idProyecto);
	}

}
