package com.equidad.sisddeq.service.impl;

import java.util.List;

import com.equidad.sisddeq.DAO.Impl.UsuarioSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqTUsuario;
import com.equidad.sisddeq.service.UsuarioSisddeqService;

public class UsuarioSisddeqServiceImpl implements UsuarioSisddeqService {

	public static UsuarioSisddeqDAOImpl usuarioSisddeqDAOImpl = new UsuarioSisddeqDAOImpl(); 
	
	@Override
	public List<SisddeqTUsuario> consultaUsuario() {
		// TODO Auto-generated method stub
		return usuarioSisddeqDAOImpl.obtenerUsuarios();
	}

	@Override
	public void crearUsuario(SisddeqTUsuario sisddeqCUsuario) {
		// TODO Auto-generated method stub
		usuarioSisddeqDAOImpl.crear(sisddeqCUsuario);
	}

	@Override
	public void eliminarUsuario(SisddeqTUsuario sisddeqCUsuario) {
		// TODO Auto-generated method stub
		usuarioSisddeqDAOImpl.borrar(sisddeqCUsuario.getIdUsuario());
	}

	@Override
	public SisddeqTUsuario consultaUsuarioPorId(int idUsuario) {
		// TODO Auto-generated method stub
		return usuarioSisddeqDAOImpl.buscaPorId(idUsuario);
	}

}
