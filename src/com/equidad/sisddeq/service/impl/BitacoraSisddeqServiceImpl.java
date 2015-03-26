package com.equidad.sisddeq.service.impl;

import java.util.List;

import com.equidad.sisddeq.DAO.BitacoraSisddeqDAO;
import com.equidad.sisddeq.entidades.SisddeqTBitacora;
import com.equidad.sisddeq.service.BitacoraSisddeqService;

public class BitacoraSisddeqServiceImpl implements BitacoraSisddeqService {

	public static BitacoraSisddeqDAO bitacoraSisddeqDAOImpl = new com.equidad.sisddeq.DAO.Impl.BitacoraSisddeqDAOImpl();
	

	@Override
	public void crearBitacora(SisddeqTBitacora sisddeqTBitacora) {
		bitacoraSisddeqDAOImpl.crear(sisddeqTBitacora);
	}

	@Override
	public void eliminarBitacora(SisddeqTBitacora sisddeqTBitacora) {
		bitacoraSisddeqDAOImpl.borrar(sisddeqTBitacora.getIdBitacora());
	}

	@Override
	public SisddeqTBitacora consultaBitacoraPorId(int idBitacora) {
		return bitacoraSisddeqDAOImpl.buscaPorId(idBitacora);
	}

	@Override
	public List<SisddeqTBitacora> consultaBitacora() {
		return null;
	}


}
