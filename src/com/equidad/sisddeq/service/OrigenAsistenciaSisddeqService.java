package com.equidad.sisddeq.service;

import java.util.List;

import com.equidad.sisddeq.entidades.SisddeqTOrigenAsistencia;

public interface OrigenAsistenciaSisddeqService {

	
	public List<SisddeqTOrigenAsistencia> consultaOrigenAsistencia();
	
	public void crearOrigenAsistencia(SisddeqTOrigenAsistencia sisddeqTOrigenAsistencia);
	
	public void eliminarOrigenAsistencia(SisddeqTOrigenAsistencia sisddeqTOrigenAsistencia);
	
	public SisddeqTOrigenAsistencia consultaOrigenAsistenciaPorId(int idOrigen);

}
