package com.equidad.sisddeq.common;

public class GenericServiceImpl<T, PK>  implements GenericService<T, PK> {

	public GenericDAOImpl<T, PK> genericDAOImpl = new GenericDAOImpl<T, PK>();
	
	@Override
	public T crear(T entidad) {
		
		return genericDAOImpl.crear(entidad);
	}

	@Override
	public T buscaPorId(PK id) {
		return genericDAOImpl.buscaPorId(id);
	}

	@Override
	public void borrar(PK id) {
		genericDAOImpl.borrar(id);
		
	}

	@Override
	public T actualizar(T entidad) {
		return genericDAOImpl.actualizar(entidad);
	}

	

}
