package com.equidad.sisddeq.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.equidad.sisddeq.DAO.Impl.RolSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCRol;
import com.equidad.sisddeq.service.RolSisddeqService;


@Named("rolSisddeqService")
public class RolSisddeqServiceImpl implements RolSisddeqService {

	
	public static RolSisddeqDAOImpl rolSisddeqDAO = new RolSisddeqDAOImpl();
	
	public void insertarRol(SisddeqCRol sisddeqcrol ){
		rolSisddeqDAO.crear(sisddeqcrol);
	}

	
	public List<SisddeqCRol> consultaRol() {
		try {
			List<SisddeqCRol> listaRoles = new ArrayList<SisddeqCRol>();	
			listaRoles = rolSisddeqDAO.consultaRol();	
			return listaRoles;
		} catch (Exception e) {
			System.out.println("ERROR SE::"+e);
		}
		
		return null;
	}


	public static RolSisddeqDAOImpl getRolSisddeqDAO() {
		return rolSisddeqDAO;
	}


	public static void setRolSisddeqDAO(RolSisddeqDAOImpl rolSisddeqDAO) {
		RolSisddeqServiceImpl.rolSisddeqDAO = rolSisddeqDAO;
	}
	
	
	
}
