package com.equidad.sisddeq.service;

import java.util.List;


import com.equidad.sisddeq.entidades.SisddeqTUsuario;

public interface UsuarioSisddeqService {
	public List<SisddeqTUsuario> consultaUsuario();

	public void crearUsuario(SisddeqTUsuario sisddeqCUsuario);

	public void eliminarUsuario(SisddeqTUsuario sisddeqCUsuario);

	public SisddeqTUsuario consultaUsuarioPorId(int idUsuario);
}
