package com.equidad.sisddeq.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import com.equidad.sisddeq.entidades.SisddeqCEstadoActividad;
import com.equidad.sisddeq.service.EstadoActividadSisddeqService;
import com.equidad.sisddeq.service.impl.EstadoActividadSisddeqServiceImpl;

/**
 * The Class EstadoActividadController.
 */
@ManagedBean(name = "estadoActividadController")
@ViewScoped
public class EstadoActividadController implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The estado actividad sisddeq. */
	private EstadoActividadSisddeqService estadoActividadSisddeq = new EstadoActividadSisddeqServiceImpl();

	/** The lista actividad. */
	public List<SisddeqCEstadoActividad> listaActividad = new ArrayList<SisddeqCEstadoActividad>();

	/** The actividad. */
	public SisddeqCEstadoActividad actividad = new SisddeqCEstadoActividad();

	/** The sisddeq c estado actividad. */
	public SisddeqCEstadoActividad sisddeqCEstadoActividad = new SisddeqCEstadoActividad();

	/** The dual lista actividad. */
	private DualListModel<String> dualListaActividad;

	/** The nombre. */
	public String nombre = "";

	/** The descripcion. */
	public String descripcion = "";

	/** The id actividad. */
	public String idActividad = "";

	/** The actividad source. */
	List<String> actividadSource = new ArrayList<String>();

	/** The actividad target. */
	List<String> actividadTarget = new ArrayList<String>();

	/**
	 * Crear actividad. Este metodo crea una actividad y la actualiza. Cuando
	 * detecta que se le esta enviando el id de la actividad entonces es una
	 * actividad, si no viene el id entonces esta creando una actividad. No
	 * recibe ningun parametro y todo lo toma de los getters y setters de las
	 * variables que se llenan al seleccionar una actividad. Se agrega el método
	 * init ya que después de que inserta o actualiza se tiene que actualizar el
	 * grid (El metodo init actualiza los datos del grid).
	 */
	public void crearActividad() {
		System.out.println("Entra a crear actividad" + getNombre() + "::"
				+ getDescripcion());
		if (!getIdActividad().isEmpty()) {
			sisddeqCEstadoActividad.setIdEstado(Integer
					.valueOf(getIdActividad()));
		}
		sisddeqCEstadoActividad.setNombre(getNombre());
		sisddeqCEstadoActividad.setDescripcion(getDescripcion());
		try {
			estadoActividadSisddeq.crearActividad(sisddeqCEstadoActividad);
			init();
		} catch (Exception e) {
			System.out.println("Error:::" + e);
		}

	}

	/**
	 * Eliminar actividad.
	 *
	 * @param event
	 *            the event. El metodo eliminar actividad funciona como el
	 *            actualizar necesita un id de la actividad para saber cual es
	 *            la actividad que va a eliminar. Algunos metodos requieren el
	 *            metodo event para poder trabajar este esun estandar de
	 *            primefaces. (verificar si realmente lo necesita). Algunos
	 *            metodos responden a un evento como: Seleecionar actividad,
	 *            clic, es decir que primefaces tiene la capacidad para poder
	 *            identificar cientos elementos de la pantalla.
	 * 
	 */
	public void eliminarActividad(ActionEvent event) {
		try {
			System.out.println("Entra a Eliminar actividad" + getNombre()
					+ "::" + getDescripcion());
			SisddeqCEstadoActividad actividadCompleta = new SisddeqCEstadoActividad();
			idActividad = String.valueOf(actividad.getIdEstado());
			actividadCompleta = estadoActividadSisddeq
					.consultaActividadPorId(actividad.getIdEstado());

			sisddeqCEstadoActividad
					.setIdEstado(actividadCompleta.getIdEstado());
			sisddeqCEstadoActividad.setNombre(actividadCompleta.getNombre());
			sisddeqCEstadoActividad.setDescripcion(actividadCompleta
					.getDescripcion());

			System.out.println("id::" + actividadCompleta.getIdEstado());
			System.out.println("Nombre::" + actividadCompleta.getNombre());
			System.out.println("Descripcion::"
					+ actividadCompleta.getDescripcion());

			estadoActividadSisddeq.eliminarActividad(sisddeqCEstadoActividad);
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
			listaActividad = new ArrayList<SisddeqCEstadoActividad>();
			listaActividad = estadoActividadSisddeq.consultaActividad();

			for (SisddeqCEstadoActividad activdad : listaActividad) {
				actividadSource.add(activdad.getNombre());

			}

			dualListaActividad = new DualListModel<String>(actividadSource,
					actividadTarget);

		} catch (Exception e) {
			System.out.println("ERROR MB::" + e);
		}
	}

	/**
	 * Limpiar campos.
	 *
	 * @param event
	 *            the event
	 *Limpiar campos es un metodo que pone vacio a las variables que se pueden modificar cuando utilizas el crear actividad.
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

		SisddeqCEstadoActividad actividadCompleta = new SisddeqCEstadoActividad();
		idActividad = String.valueOf(actividad.getIdEstado());
		actividadCompleta = estadoActividadSisddeq
				.consultaActividadPorId(actividad.getIdEstado());
		System.out.println("id::" + actividadCompleta.getIdEstado());
		System.out.println("Nombre::" + actividadCompleta.getNombre());
		System.out
				.println("Descripcion::" + actividadCompleta.getDescripcion());

		this.idActividad = String.valueOf(actividadCompleta.getIdEstado());
		this.nombre = actividadCompleta.getNombre();
		this.descripcion = actividadCompleta.getDescripcion();

		setIdActividad(String.valueOf(actividadCompleta.getIdEstado()));
		setNombre(actividadCompleta.getNombre());
		setDescripcion(actividadCompleta.getDescripcion());

	}


	public List<SisddeqCEstadoActividad> getListaActividad() {
		return listaActividad;
	}

	public void setListaActividad(List<SisddeqCEstadoActividad> listaActividad) {
		this.listaActividad = listaActividad;
	}

	public DualListModel<String> getDualListaActividad() {
		return dualListaActividad;
	}

	public void setDualListaActividad(DualListModel<String> dualListaActividad) {
		this.dualListaActividad = dualListaActividad;
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

	public SisddeqCEstadoActividad getActividad() {
		return actividad;
	}

	public void setActividad(SisddeqCEstadoActividad actividad) {
		this.actividad = actividad;
	}

	public String getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(String idActividad) {
		this.idActividad = idActividad;
	}

}
