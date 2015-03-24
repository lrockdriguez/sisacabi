package com.equidad.sisddeq.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.equidad.sisddeq.entidades.SisddeqCRol;
import com.equidad.sisddeq.service.RolSisddeqService;
import com.equidad.sisddeq.service.impl.RolSisddeqServiceImpl;

@ManagedBean(name="rolSisddeqController")
@ViewScoped
public class RolSisddeqController  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RolSisddeqService rolSisddeqService = new RolSisddeqServiceImpl();
	
	public  List<SisddeqCRol> listaRoles = new ArrayList<SisddeqCRol>();
	
	public  String usuario = "Luis";

	public void insertarRol() {

	}

	@PostConstruct
	public void init() {
		try {
			listaRoles = new ArrayList<SisddeqCRol>();
			listaRoles  =  rolSisddeqService.consultaRol();
		} catch (Exception e) {
			System.out.println("ERROR MB::"+e);
		}
		
	}
	
	public void consultarRoles() {
		try {
			listaRoles = new ArrayList<SisddeqCRol>();
			listaRoles  =  rolSisddeqService.consultaRol();
		} catch (Exception e) {
			System.out.println("ERROR MB::"+e);
		}
		
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<SisddeqCRol> getListaRoles() {
		return listaRoles;
	}

	public  void setListaRoles(List<SisddeqCRol> listaRoles) {
		this.listaRoles = listaRoles;
	}

	
	
	
}
