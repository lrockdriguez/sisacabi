package com.equidad.sisddeq.service;

import java.util.List;

import com.equidad.sisddeq.entidades.SisddeqCProposito;

public interface PropositoSisddeqService {
	
	public List<SisddeqCProposito> consultaProposito();
	
	public void crearProposito(SisddeqCProposito sisddeqCProposito);
	
	public void eliminarProposito(SisddeqCProposito sisddeqCProposito);
	
	public SisddeqCProposito consultaPropositoPorId(int idProposito);
}
