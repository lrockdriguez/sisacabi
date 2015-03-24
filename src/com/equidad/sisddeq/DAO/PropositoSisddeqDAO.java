package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.SisddeqCPoblacion;
import com.equidad.sisddeq.entidades.SisddeqCProposito;

public interface PropositoSisddeqDAO  extends GenericDAO<SisddeqCProposito, Integer> {

	public List<SisddeqCProposito> consultaProposito();
}
