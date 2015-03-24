package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.SisddeqCTema;
import com.equidad.sisddeq.entidades.SisddeqCTipoBitacora;

public interface TipoBitacoraSisddeqDAO  extends GenericDAO<SisddeqCTipoBitacora, Integer>{
	
	public List<SisddeqCTipoBitacora> consultaTipoBitacora();
}
