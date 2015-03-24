package com.equidad.sisddeq.service.impl;

import java.util.List;

import com.equidad.sisddeq.DAO.Impl.OrigenAsistenciaSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqTOrigenAsistencia;
import com.equidad.sisddeq.service.OrigenAsistenciaSisddeqService;

public class OrigenAsistenciaSisddeqServiceImpl implements
		OrigenAsistenciaSisddeqService {

	public static OrigenAsistenciaSisddeqDAOImpl origenAsistenciaSisddeqDAOImpl = new OrigenAsistenciaSisddeqDAOImpl();

	@Override
	public List<SisddeqTOrigenAsistencia> consultaOrigenAsistencia() {
		return origenAsistenciaSisddeqDAOImpl.consultaOrigenAsistencia();
	}

	@Override
	public void crearOrigenAsistencia(
			SisddeqTOrigenAsistencia sisddeqTOrigenAsistencia) {
		origenAsistenciaSisddeqDAOImpl.crear(sisddeqTOrigenAsistencia);

	}

	@Override
	public void eliminarOrigenAsistencia(
			SisddeqTOrigenAsistencia sisddeqTOrigenAsistencia) {
		origenAsistenciaSisddeqDAOImpl.borrar(sisddeqTOrigenAsistencia
				.getIdOAsistencia());

	}

	@Override
	public SisddeqTOrigenAsistencia consultaOrigenAsistenciaPorId(int idOrigen) {
		return origenAsistenciaSisddeqDAOImpl.buscaPorId(idOrigen);
	}

}
