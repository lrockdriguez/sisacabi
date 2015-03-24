package com.equidad.sisddeq.service;

import java.util.List;

import com.equidad.sisddeq.entidades.SisddeqCSector;

public interface SectorSisddeqService {
	public List<SisddeqCSector> consultaSector();

	public void crearSector(SisddeqCSector sisddeqCSector);

	public void eliminarSector(SisddeqCSector sisddeqCSector);

	public SisddeqCSector consultaSectorPorId(int idSector);
}
