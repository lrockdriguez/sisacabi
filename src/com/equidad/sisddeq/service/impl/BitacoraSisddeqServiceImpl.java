package com.equidad.sisddeq.service.impl;

import java.util.List;

import com.equidad.sisddeq.entidades.SisddeqTBitacora;
import com.equidad.sisddeq.service.BitacoraSisddeqService;

public class BitacoraSisddeqServiceImpl implements BitacoraSisddeqService {

	public static BitacoraSisddeqServiceImpl bitacoraSisddeqServiceImpl = new BitacoraSisddeqServiceImpl();
	
	@Override
	public List<SisddeqTBitacora> consultaBitacora() {
		return bitacoraSisddeqServiceImpl.consultaBitacora();
	}

	@Override
	public void crearBitacora(SisddeqTBitacora sisddeqTBitacora) {
		bitacoraSisddeqServiceImpl.crearBitacora(sisddeqTBitacora);
		
	}

	@Override
	public void eliminarBitacora(SisddeqTBitacora sisddeqTBitacora) {
		bitacoraSisddeqServiceImpl.eliminarBitacora(sisddeqTBitacora);
	}

	@Override
	public SisddeqTBitacora consultaBitacoraPorId(int idBitacora) {
		return bitacoraSisddeqServiceImpl.consultaBitacoraPorId(idBitacora);
	}


}
