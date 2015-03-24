package com.equidad.sisddeq.service;

import java.util.List;

import com.equidad.sisddeq.entidades.SisddeqCMenu;

public interface MenuSisddeqService {

	public List<SisddeqCMenu> consultaMenu();

	public void crearMenu(SisddeqCMenu sisddeqCMenu);

	public void eliminarMenu(SisddeqCMenu sisddeqCMenu);

	public SisddeqCMenu consultaMenuPorId(int idMenu);

}
