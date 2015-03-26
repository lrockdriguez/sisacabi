package com.equidad.sisddeq.service.impl;

import java.util.List;

import javax.inject.Named;

import com.equidad.sisddeq.DAO.Impl.LocalidadesSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.Localidade;
import com.equidad.sisddeq.service.LocalidadesSisddeqService;

@Named("localidadesSisddeqService")
public class LocalidadesSisddeqServiceImpl implements LocalidadesSisddeqService {

	public static LocalidadesSisddeqDAOImpl localidadesSisddeqDAO = new LocalidadesSisddeqDAOImpl();
	
	@Override
	public List<Localidade> consultaLocalidadPorMunicipio(int idMunicipio) {
		
		return localidadesSisddeqDAO.consultaLocalidadPorMunicipio(idMunicipio);
	}

}
