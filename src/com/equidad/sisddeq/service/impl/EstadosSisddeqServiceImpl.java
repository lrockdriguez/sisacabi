package com.equidad.sisddeq.service.impl;

import java.util.List;

import javax.inject.Named;

import com.equidad.sisddeq.DAO.Impl.EstadosSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.Estado;
import com.equidad.sisddeq.service.EstadosSisddeqService;

@Named("estadosSisddeqService")
public class EstadosSisddeqServiceImpl implements EstadosSisddeqService {

	public static EstadosSisddeqDAOImpl estadosSisddeqDAOImpl = new EstadosSisddeqDAOImpl();
	
	@Override
	public List<Estado> consultaEstados() {
		return estadosSisddeqDAOImpl.consultaEstados();
	}

}
