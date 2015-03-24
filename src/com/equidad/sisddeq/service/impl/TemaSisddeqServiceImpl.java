package com.equidad.sisddeq.service.impl;

import java.util.List;

import com.equidad.sisddeq.DAO.Impl.TemaSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCTema;
import com.equidad.sisddeq.service.TemaSisddeqService;

public class TemaSisddeqServiceImpl implements TemaSisddeqService {

	public static TemaSisddeqDAOImpl temaSisddeqDAOImpl = new TemaSisddeqDAOImpl();
	
	@Override
	public List<SisddeqCTema> consultaTema() {
		// TODO Auto-generated method stub
		return temaSisddeqDAOImpl.consultaTema();
	}

	@Override
	public void crearTema(SisddeqCTema sisddeqCTema) {
		// TODO Auto-generated method stub
		temaSisddeqDAOImpl.crear(sisddeqCTema);
	}

	@Override
	public void eliminarTema(SisddeqCTema sisddeqCTema) {
		// TODO Auto-generated method stub
		temaSisddeqDAOImpl.borrar(sisddeqCTema.getIdTema());
	}

	@Override
	public SisddeqCTema consultaTemaPorId(int idTema) {
		// TODO Auto-generated method stub
		return temaSisddeqDAOImpl.buscaPorId(idTema);
	}

}
