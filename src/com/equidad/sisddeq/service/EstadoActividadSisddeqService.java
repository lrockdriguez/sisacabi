package com.equidad.sisddeq.service;

import java.util.List;

import com.equidad.sisddeq.entidades.SisddeqCEstadoActividad;

public interface EstadoActividadSisddeqService {
	

	
	public List<SisddeqCEstadoActividad> consultaActividad();
	
	public void crearActividad(SisddeqCEstadoActividad sisddeqCEstadoActividad);
	
	public void eliminarActividad(SisddeqCEstadoActividad sisddeqCEstadoActividad);
	
	public SisddeqCEstadoActividad consultaActividadPorId(int idActividad);

}
