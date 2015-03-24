package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.SisddeqCProyecto;
import com.equidad.sisddeq.entidades.SisddeqCSector;

public interface SectorSisddeqDAO extends GenericDAO<SisddeqCSector, Integer> {

	public List<SisddeqCSector> consultaSector();
}
