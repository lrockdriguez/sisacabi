package com.equidad.sisddeq.service.impl;

import java.util.List;

import com.equidad.sisddeq.DAO.Impl.TipoBitacoraSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCTipoBitacora;
import com.equidad.sisddeq.service.TipoBitacoraSisddeqService;

public class TipoBitacoraSisddeqServiceImpl implements
		TipoBitacoraSisddeqService {

	public static TipoBitacoraSisddeqDAOImpl tipoBitacoraSisddeqDAOImpl = new TipoBitacoraSisddeqDAOImpl();
	@Override
	public List<SisddeqCTipoBitacora> consultaTipoBitacora() {
		// TODO Auto-generated method stub
		return tipoBitacoraSisddeqDAOImpl.consultaTipoBitacora();
	}

	@Override
	public void crearTipoBitacora(SisddeqCTipoBitacora sisddeqCTipoBitacora) {
		// TODO Auto-generated method stub
		tipoBitacoraSisddeqDAOImpl.crear(sisddeqCTipoBitacora);
	}

	@Override
	public void eliminarTipoBitacora(SisddeqCTipoBitacora sisddeqCTipoBitacora) {
		// TODO Auto-generated method stub
		tipoBitacoraSisddeqDAOImpl.borrar(sisddeqCTipoBitacora.getIdBitacora());
	}

	@Override
	public SisddeqCTipoBitacora consultaTipoBitacoraPorId(int idTipoBitacora) {
		// TODO Auto-generated method stub
		return tipoBitacoraSisddeqDAOImpl.buscaPorId(idTipoBitacora);
	}

}
