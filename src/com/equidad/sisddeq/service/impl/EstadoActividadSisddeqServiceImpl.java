package com.equidad.sisddeq.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.equidad.sisddeq.DAO.Impl.EstadoActividadSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCEstadoActividad;
import com.equidad.sisddeq.service.EstadoActividadSisddeqService;

@Named("estadoActividadSisddeqService")
public class EstadoActividadSisddeqServiceImpl implements
		EstadoActividadSisddeqService {

	public static EstadoActividadSisddeqDAOImpl estadoActividadSisddeqDAO = new EstadoActividadSisddeqDAOImpl();

	public void insertarActividad(
			SisddeqCEstadoActividad sisddeqcestadoactividad) {
		estadoActividadSisddeqDAO.crear(sisddeqcestadoactividad);
	}

	public List<SisddeqCEstadoActividad> consultaActividad() {
		try {
			List<SisddeqCEstadoActividad> listaActividad = new ArrayList<SisddeqCEstadoActividad>();
			listaActividad = estadoActividadSisddeqDAO
					.consultaEstadoActividad();
			return listaActividad;
		} catch (Exception e) {
			System.out.println("ERROR SE::" + e);
		}

		return null;
	}

	public static EstadoActividadSisddeqDAOImpl getEstadoActividadSisddeqDAO() {
		return estadoActividadSisddeqDAO;
	}

	public static void setEstadoActividadSisddeqDAO(
			EstadoActividadSisddeqDAOImpl estadoActividadSisddeqDAO) {
		EstadoActividadSisddeqServiceImpl.estadoActividadSisddeqDAO = estadoActividadSisddeqDAO;
	}

	@Override
	public void crearActividad(SisddeqCEstadoActividad sisddeqCEstadoActividad) {
		estadoActividadSisddeqDAO.crear(sisddeqCEstadoActividad);

	}

	@Override
	public SisddeqCEstadoActividad consultaActividadPorId(int idActividad) {
		SisddeqCEstadoActividad actividad = new SisddeqCEstadoActividad();
		actividad = estadoActividadSisddeqDAO.buscaPorId(idActividad);
		return actividad;
	}

	@Override
	public void eliminarActividad(
			SisddeqCEstadoActividad sisddeqCEstadoActividad) {
		estadoActividadSisddeqDAO.borrar(sisddeqCEstadoActividad.getIdEstado());

	}

}
