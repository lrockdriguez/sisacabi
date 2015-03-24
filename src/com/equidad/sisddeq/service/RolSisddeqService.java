package com.equidad.sisddeq.service;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.equidad.sisddeq.entidades.SisddeqCRol;


public interface RolSisddeqService {
	
	public void insertarRol(SisddeqCRol sisddeqcrol );
	
	public List<SisddeqCRol> consultaRol();

}
