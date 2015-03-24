package com.equidad.sisddeq.service;

import java.util.List;

import com.equidad.sisddeq.entidades.SisddeqCProyecto;

public interface ProyectosSisddeqService {
	
	public List<SisddeqCProyecto> consultaProyecto();

	public void crearProyecto(SisddeqCProyecto sisddeqCProyecto);

	public void eliminarProyecto(SisddeqCProyecto sisddeqCProyecto);

	public SisddeqCProyecto consultaProyectoPorId(int idProyecto);
}
