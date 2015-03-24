package com.equidad.sisddeq.DAO;

import java.util.List;

import com.equidad.sisddeq.common.GenericDAO;
import com.equidad.sisddeq.entidades.SisddeqTUsuario;

public interface UsuarioSisddeqDAO extends GenericDAO<SisddeqTUsuario, Integer>{

	
	public void insertaUsuarioSisddeq(SisddeqTUsuario sisddeqTUsuario);
	
	public SisddeqTUsuario buscaPorEmailYPassword(String email, String password);
	
	public List<SisddeqTUsuario> obtenerUsuarios();
	
}
