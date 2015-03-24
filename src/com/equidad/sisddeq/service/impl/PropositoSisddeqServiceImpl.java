package com.equidad.sisddeq.service.impl;

import java.util.List;

import com.equidad.sisddeq.DAO.Impl.PropositoSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCProposito;
import com.equidad.sisddeq.service.PropositoSisddeqService;

public class PropositoSisddeqServiceImpl implements PropositoSisddeqService {

	public static PropositoSisddeqDAOImpl propositoSisddeqDAOImpl = new PropositoSisddeqDAOImpl();
	
	@Override
	public List<SisddeqCProposito> consultaProposito() {
		return propositoSisddeqDAOImpl.consultaProposito();
	}

	@Override
	public void crearProposito(SisddeqCProposito sisddeqCProposito) {
		propositoSisddeqDAOImpl.crear(sisddeqCProposito);
	}

	@Override
	public void eliminarProposito(SisddeqCProposito sisddeqCProposito) {
		propositoSisddeqDAOImpl.borrar(sisddeqCProposito.getIdProposito());
	}

	@Override
	public SisddeqCProposito consultaPropositoPorId(int idProposito) {
		return propositoSisddeqDAOImpl.buscaPorId(idProposito);
	}

}
