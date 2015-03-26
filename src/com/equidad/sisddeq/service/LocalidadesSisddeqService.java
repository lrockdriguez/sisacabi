package com.equidad.sisddeq.service;

import java.util.List;

import com.equidad.sisddeq.entidades.Localidade;

public interface LocalidadesSisddeqService {
	
	public List<Localidade> consultaLocalidadPorMunicipio(int idMunicipio);

}
