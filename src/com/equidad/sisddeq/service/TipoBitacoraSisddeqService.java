package com.equidad.sisddeq.service;

import java.util.List;

import com.equidad.sisddeq.entidades.SisddeqCTipoBitacora;

public interface TipoBitacoraSisddeqService {
	public List<SisddeqCTipoBitacora> consultaTipoBitacora();

	public void crearTipoBitacora(SisddeqCTipoBitacora sisddeqCTipoBitacora);

	public void eliminarTipoBitacora(SisddeqCTipoBitacora sisddeqCTipoBitacora);

	public SisddeqCTipoBitacora consultaTipoBitacoraPorId(int idTipoBitacora);
}
