package com.equidad.sisddeq.common;

public interface GenericDAO<T,PK> {
	//definimos las operacionES CRUD
	
	public T crear(T entidad);
	
	public T buscaPorId(PK id);
	
	public void borrar(PK id);
	
	public T actualizar(T entidad);
	
}
