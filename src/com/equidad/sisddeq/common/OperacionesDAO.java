package com.equidad.sisddeq.common;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OperacionesDAO  extends RSA{

    public Session sesion;
    public Transaction tx;

    public void iniciaOperacion() throws HibernateException
{
    sesion = HibernateUtil.getSessionFactory().openSession();
    tx = sesion.beginTransaction();
}

    private void manejaExcepcion(HibernateException he) throws HibernateException
{
    tx.rollback();
    throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
}

public long guardar(Object objeto)
{
    long id = 0;

    try
    {
        iniciaOperacion();
        id = (Integer)sesion.save(objeto);
        tx.commit();
    }catch(HibernateException he)
    {
        manejaExcepcion(he);
        throw he;
    }finally
    {
        sesion.close();
    }
    return id;
}

public void actualiza(Object objeto) throws HibernateException
{
    try
    {
        iniciaOperacion();
        sesion.update(objeto);
        tx.commit();
    }catch (HibernateException he)
    {
        manejaExcepcion(he);
        throw he;
    }finally
    {
        sesion.close();
    }
}

public void elimina(Object objeto) throws HibernateException
{
    try
    {
        iniciaOperacion();
        sesion.delete(objeto);
        tx.commit();
    } catch (HibernateException he)
    {
        manejaExcepcion(he);
        throw he;
    }finally
    {
        sesion.close();
    }
}

public Object obtener(Integer id) throws HibernateException
{
    Object objeto = null;

    try
    {
        iniciaOperacion();
        objeto = (Object) sesion.get(Object.class, id);
    } finally
    {
        sesion.close();
    }
    return objeto;
}


public Object obtenerPorParametro(String tabla,String campo, String buscar) throws HibernateException
{
    Object objeto = new Object();

    try
    {
        iniciaOperacion();
        Query q = sesion.createQuery("from "+tabla+" tab where tab."+campo+"= :buscar");
        q.setString("buscar", buscar);
        objeto = q.uniqueResult();
    } finally
    {
        sesion.close();
    }
    return objeto;
}

public List<Object> obtenerTodosPorParametro(String tabla,String campo, String buscar) throws HibernateException
{
    List<Object> objetos = new ArrayList<Object>();

    try
    {
        iniciaOperacion();
        Query q = sesion.createQuery("from "+tabla+" tab where tab."+campo+"= :buscar");
        q.setString("buscar", buscar);
        objetos = q.list();
    } finally
    {
        sesion.close();
    }
    return objetos;
}

public List<Object> obtenerTodos(String tabla, String orderBy) throws HibernateException
{
    List<Object> lista = new ArrayList<Object>();

    try
    {
        iniciaOperacion();
        lista = sesion.createQuery("from " + tabla +" order by " + orderBy).list();
    }finally
    {
        sesion.close();
    }

    return lista;
}
}


