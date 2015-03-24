package com.equidad.sisddeq.service.impl;

import java.util.List;

import javax.inject.Named;

import com.equidad.sisddeq.DAO.MenuSisddeqDAO;
import com.equidad.sisddeq.DAO.Impl.MenuSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCEstadoActividad;
import com.equidad.sisddeq.entidades.SisddeqCMenu;
import com.equidad.sisddeq.service.MenuSisddeqService;

@Named("menuSisddeqService")
public class MenuSisddeqServiceImpl  implements MenuSisddeqService {

	
	public static MenuSisddeqDAO menuSisddeqDAO = new MenuSisddeqDAOImpl();
	

	@Override
	public List<SisddeqCMenu> consultaMenu() {
		return menuSisddeqDAO.consultaMenu();
	}

	@Override
	public void crearMenu(SisddeqCMenu sisddeqCMenu) {
		menuSisddeqDAO.crear(sisddeqCMenu);
		
	}

	@Override
	public void eliminarMenu(SisddeqCMenu sisddeqCMenu) {
		menuSisddeqDAO.borrar(sisddeqCMenu.getIdMenu());
		
	}

	@Override
	public SisddeqCMenu consultaMenuPorId(int idMenu) {
		return menuSisddeqDAO.buscaPorId(idMenu);
	}
	
	
	
	
	
	

}
