package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.SisddeqCSector;
import com.equidad.sisddeq.entidades.SisddeqCTema;

public interface TemaSisddeqDAO  extends GenericDAO<SisddeqCTema, Integer> {

	public List<SisddeqCTema> consultaTema();
}
