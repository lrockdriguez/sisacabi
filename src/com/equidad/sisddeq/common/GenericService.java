package com.equidad.sisddeq.common;

public interface GenericService<T,PK> {
	
	public T crear(T entidad);
	
	public T buscaPorId(PK id);
	
	public void borrar(PK id);
	
	public T actualizar(T entidad);

}
