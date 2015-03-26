package com.equidad.sisddeq.service.impl;

import java.util.List;

import javax.inject.Named;

import com.equidad.sisddeq.DAO.Impl.MunicipiosSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.Municipio;
import com.equidad.sisddeq.service.MunicipioSisddeqService;

@Named("municipioSisddeqService")
public class MunicipioSisddeqServiceImpl implements MunicipioSisddeqService {

	public static MunicipiosSisddeqDAOImpl municipiosSisddeqDAO = new MunicipiosSisddeqDAOImpl();

	@Override
	public List<Municipio> consultaMunicipioPorEstado(int idEstado) {
		return municipiosSisddeqDAO.consultaMunicipioPorEstado(idEstado);
	}
	

}
