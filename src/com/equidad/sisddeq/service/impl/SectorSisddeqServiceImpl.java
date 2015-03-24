package com.equidad.sisddeq.service.impl;

import java.util.List;

import com.equidad.sisddeq.DAO.Impl.SectorSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCSector;
import com.equidad.sisddeq.service.SectorSisddeqService;

public class SectorSisddeqServiceImpl implements SectorSisddeqService {

	public static SectorSisddeqDAOImpl sectorSisddeqDAOImpl = new SectorSisddeqDAOImpl();
	
	@Override
	public List<SisddeqCSector> consultaSector() {
		// TODO Auto-generated method stub
		return sectorSisddeqDAOImpl.consultaSector();
	}

	@Override
	public void crearSector(SisddeqCSector sisddeqCSector) {
		// TODO Auto-generated method stub
		sectorSisddeqDAOImpl.crear(sisddeqCSector);
	}

	@Override
	public void eliminarSector(SisddeqCSector sisddeqCSector) {
		// TODO Auto-generated method stub
		sectorSisddeqDAOImpl.borrar(sisddeqCSector.getIdSector());
	}

	@Override
	public SisddeqCSector consultaSectorPorId(int idSector) {
		// TODO Auto-generated method stub
		return sectorSisddeqDAOImpl.buscaPorId(idSector);
	}

}
