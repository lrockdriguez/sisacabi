package com.equidad.sisddeq.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;
import com.equidad.sisddeq.entidades.SisddeqCProyecto;

import com.equidad.sisddeq.service.ProyectosSisddeqService;
import com.equidad.sisddeq.service.impl.ProyectosSisddeqServiceImpl;

@ManagedBean(name = "proyectoController")
@ViewScoped
public class ProyectoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The población sisddeq. */
	private ProyectosSisddeqService proyectosSisddeqService = new ProyectosSisddeqServiceImpl();

	/** The lista Proyectos. */
	public List<SisddeqCProyecto> listaProyectos = new ArrayList<SisddeqCProyecto>();

	/** The Proyectos. */
	public SisddeqCProyecto proyectos = new SisddeqCProyecto();

	/** The sisddeq c población. */
	public SisddeqCProyecto sisddeqCProyecto = new SisddeqCProyecto();

	/** The dual lista Proyectos. */
	private DualListModel<String> dualListaProyectos;

	/** The nombre. */
	public String nombre = "";

	/** The descripcion. */
	public String descripcion = "";

	/** The id Proyectos. */
	public String idProyectos = "";

	/** The Proyectos source. */
	List<String> proyectosSource = new ArrayList<String>();

	/** The Proyectos target. */
	List<String> proyectosTarget = new ArrayList<String>();

	/**
	 * Crear Proyectos. Este metodo crea una Proyectos y la actualiza. Cuando
	 * detecta que se le esta enviando el id de la Proyectos entonces es una
	 * Proyectos, si no viene el id entonces esta creando una Proyectos. No
	 * recibe ningun parametro y todo lo toma de los getters y setters de las
	 * variables que se llenan al seleccionar una Proyectos. Se agrega el método
	 * init ya que después de que inserta o actualiza se tiene que actualizar el
	 * grid (El metodo init actualiza los datos del grid).
	 */
	public void crearProyectos() {
		System.out.println("Entra a crear Proyectos" + getNombre() + "::"
				+ getDescripcion());
		if (!getIdProyectos().isEmpty()) {
			sisddeqCProyecto.setIdProyecto((Integer
					.valueOf(getIdProyectos())));
		}
		sisddeqCProyecto.setNombre(getNombre());
		sisddeqCProyecto.setDescripcion(getDescripcion());
		try {
			proyectosSisddeqService.crearProyecto(sisddeqCProyecto);
			init();
		} catch (Exception e) {
			System.out.println("Error:::" + e);
		}

	}

	/**
	 * Eliminar Proyectos.
	 *
	 * @param event
	 *            the event. El metodo eliminar Proyectos funciona como el
	 *            actualizar necesita un id de la Proyectos para saber cual es
	 *            la Proyectos que va a eliminar. Algunos metodos requieren el
	 *            metodo event para poder trabajar este esun estandar de
	 *            primefaces. (verificar si realmente lo necesita). Algunos
	 *            metodos responden a un evento como: Seleecionar Proyectos,
	 *            clic, es decir que primefaces tiene la capacidad para poder
	 *            identificar cientos elementos de la pantalla.
	 * 
	 */
	public void eliminarProyectos(ActionEvent event) {
		try {
			System.out.println("Entra a Eliminar Proyectos" + getNombre()
					+ "::" + getDescripcion());

			SisddeqCProyecto proyectosCompleta = new SisddeqCProyecto();
			idProyectos = String.valueOf(proyectos.getIdProyecto());
			proyectosCompleta = proyectosSisddeqService.consultaProyectoPorId((sisddeqCProyecto.getIdProyecto()));

			proyectos.setIdProyecto((proyectosCompleta.getIdProyecto()));
			proyectos.setNombre(proyectosCompleta.getNombre());
			proyectos.setDescripcion(proyectosCompleta.getDescripcion());

			System.out.println("id::" + proyectosCompleta.getIdProyecto());
			System.out.println("Nombre::" + proyectosCompleta.getNombre());
			System.out.println("Descripcion::"
					+ proyectosCompleta.getDescripcion());

			proyectosSisddeqService.eliminarProyecto(proyectosCompleta);
			init();
		} catch (Exception e) {
			System.out.println("Error:::" + e);
		}

	}

	/**
	 * Inits the. La anotación postConstructor es propia de primfaces. Esta
	 * anotación le indica que init es el primer metodo que se va a ejecutar.
	 * Funciona de la misma manera que el constructor de una clase con la
	 * diferencia que aqui puedes elegir el nombre del metodo que esta inciando
	 * las operaciones en la clase.
	 * 
	 */
	@PostConstruct
	public void init() {
		try {
			listaProyectos = new ArrayList<SisddeqCProyecto>();
			listaProyectos = proyectosSisddeqService.consultaProyecto();

			for (SisddeqCProyecto Proyectos : listaProyectos) {
				proyectosSource.add(Proyectos.getNombre());

			}

			dualListaProyectos = new DualListModel<String>(proyectosSource,
					proyectosTarget);

		} catch (Exception e) {
			System.out.println("ERROR MB::" + e);
		}
	}

	/**
	 * Limpiar campos.
	 *
	 * @param event
	 *            the event
	 *Limpiar campos es un metodo que pone vacio a las variables que se pueden modificar cuando utilizas el crear Proyectos.
	 *Este método se manda ejecutar desde la pantalla.
	 *            
	 */
	public void limpiarCampos(ActionEvent event) {
		setNombre("");
		setDescripcion("");

	}

	/**
	 * On row select.
	 *
	 * @param event
	 *            the event. onRowSelect es un metodo propio de primefaces, este
	 *            metodo responde a un evento de selección en la tabla. Este
	 *            metodo es estandar es decir que primefaces le pone el
	 *            onRowSelect responde a la anotación del grid en el
	 *            .xhtml:selectionMode Cuando tocamos cada uno de los registros
	 *            de del grid se dispara un evento de selección (SelectEvent)
	 *            Primefaces automaticamente busca este evento.
	 * 
	 */
	public void onRowSelect(SelectEvent event) {

		SisddeqCProyecto proyectosCompleta = new SisddeqCProyecto();
		idProyectos = String.valueOf(proyectos.getIdProyecto());
		proyectosCompleta = proyectosSisddeqService.consultaProyectoPorId(proyectos.getIdProyecto());
		System.out.println("id::" + proyectosCompleta.getIdProyecto());
		System.out.println("Nombre::" + proyectosCompleta.getNombre());
		System.out
				.println("Descripcion::" + proyectosCompleta.getDescripcion());

		this.idProyectos = String.valueOf(proyectosCompleta.getIdProyecto());
		this.nombre = proyectosCompleta.getNombre();
		this.descripcion = proyectosCompleta.getDescripcion();

		setIdProyectos(String.valueOf(proyectosCompleta.getIdProyecto()));
		setNombre(proyectosCompleta.getNombre());
		setDescripcion(proyectosCompleta.getDescripcion());

	}

	public ProyectosSisddeqService getProyectosSisddeqService() {
		return proyectosSisddeqService;
	}

	public void setProyectosSisddeqService(
			ProyectosSisddeqService proyectosSisddeqService) {
		this.proyectosSisddeqService = proyectosSisddeqService;
	}

	public List<SisddeqCProyecto> getListaProyectos() {
		return listaProyectos;
	}

	public void setListaProyectos(List<SisddeqCProyecto> listaProyectos) {
		this.listaProyectos = listaProyectos;
	}

	public SisddeqCProyecto getProyectos() {
		return proyectos;
	}

	public void setProyectos(SisddeqCProyecto proyectos) {
		this.proyectos = proyectos;
	}

	public SisddeqCProyecto getSisddeqCProyecto() {
		return sisddeqCProyecto;
	}

	public void setSisddeqCProyecto(SisddeqCProyecto sisddeqCProyecto) {
		this.sisddeqCProyecto = sisddeqCProyecto;
	}

	public DualListModel<String> getDualListaProyectos() {
		return dualListaProyectos;
	}

	public void setDualListaProyectos(DualListModel<String> dualListaProyectos) {
		this.dualListaProyectos = dualListaProyectos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdProyectos() {
		return idProyectos;
	}

	public void setIdProyectos(String idProyectos) {
		this.idProyectos = idProyectos;
	}

	public List<String> getProyectosSource() {
		return proyectosSource;
	}

	public void setProyectosSource(List<String> proyectosSource) {
		this.proyectosSource = proyectosSource;
	}

	public List<String> getProyectosTarget() {
		return proyectosTarget;
	}

	public void setProyectosTarget(List<String> proyectosTarget) {
		this.proyectosTarget = proyectosTarget;
	}

	
	
}
