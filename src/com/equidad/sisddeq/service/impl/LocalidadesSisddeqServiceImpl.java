package com.equidad.sisddeq.service.impl;

import java.util.List;

import com.equidad.sisddeq.DAO.Impl.LocalidadesSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.Localidade;
import com.equidad.sisddeq.service.LocalidadesSisddeqService;


public class LocalidadesSisddeqServiceImpl implements LocalidadesSisddeqService {

	public static LocalidadesSisddeqDAOImpl localidadesSisddeqDAO = new LocalidadesSisddeqDAOImpl();
	
	@Override
	public List<Localidade> consultaLocalidadPorMunicipio(int idMunicipio) {
		// TODO Auto-generated method stub
		return null;
	}

}
