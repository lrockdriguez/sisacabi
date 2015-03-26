package com.equidad.sisddeq.service;

import java.util.List;

import com.equidad.sisddeq.entidades.Municipio;

public interface MunicipioSisddeqService {
	
	public List<Municipio> consultaMunicipioPorEstado(int idEstado);

}
