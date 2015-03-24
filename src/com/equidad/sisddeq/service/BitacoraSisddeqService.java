package com.equidad.sisddeq.service;

import java.util.List;

import com.equidad.sisddeq.entidades.SisddeqTBitacora;

public interface BitacoraSisddeqService {
	
	public List<SisddeqTBitacora> consultaBitacora();
	
	public void crearBitacora(SisddeqTBitacora sisddeqTBitacora);
	
	public void eliminarBitacora(SisddeqTBitacora sisddeqTBitacora);
	
	public SisddeqTBitacora consultaBitacoraPorId(int idBitacora);
}
