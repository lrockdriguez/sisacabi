package com.equidad.sisddeq.service;

import java.util.List;

import com.equidad.sisddeq.entidades.SisddeqCTema;

public interface TemaSisddeqService {
	public List<SisddeqCTema> consultaTema();

	public void crearTema(SisddeqCTema sisddeqCTema);

	public void eliminarTema(SisddeqCTema sisddeqCTema);

	public SisddeqCTema consultaTemaPorId(int idTema);
}
