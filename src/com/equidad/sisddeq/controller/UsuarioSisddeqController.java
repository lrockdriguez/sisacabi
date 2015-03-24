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

import com.equidad.sisddeq.entidades.SisddeqTUsuario;
import com.equidad.sisddeq.service.impl.UsuarioSisddeqServiceImpl;


@ManagedBean(name = "usuarioSisddeqController")
@ViewScoped
public class UsuarioSisddeqController implements Serializable {

//	/** The Constant serialVersionUID. */
//	private static final long serialVersionUID = 1L;
//
//	/** The estado actividad sisddeq. */
//	private UsuarioSisddeqServiceImpl usuarioSisddeqService = new UsuarioSisddeqServiceImpl();
//
//	/** The lista actividad. */
//	public List<SisddeqTUsuario> listaUsuario = new ArrayList<SisddeqTUsuario>();
//
//	/** The actividad. */
//	public SisddeqTUsuario actividad = new SisddeqTUsuario();
//
//	/** The sisddeq c estado actividad. */
//	public SisddeqTUsuario sisddeqTUsuario = new SisddeqTUsuario();
//
//	/** The dual lista actividad. */
//	private DualListModel<String> dualUsuario;
//
//	/** The nombre. */
//	public String nombre = "";
//
//	/** The descripcion. */
//	public String descripcion = "";
//
//	/** The id actividad. */
//	public String idUsuario = "";
//
//	/** The actividad source. */
//	List<String> usuarioSource = new ArrayList<String>();
//
//	/** The actividad target. */
//	List<String> usuarioTarget = new ArrayList<String>();
//
//	/**
//	 * Crear actividad. Este metodo crea una actividad y la actualiza. Cuando
//	 * detecta que se le esta enviando el id de la actividad entonces es una
//	 * actividad, si no viene el id entonces esta creando una actividad. No
//	 * recibe ningun parametro y todo lo toma de los getters y setters de las
//	 * variables que se llenan al seleccionar una actividad. Se agrega el método
//	 * init ya que después de que inserta o actualiza se tiene que actualizar el
//	 * grid (El metodo init actualiza los datos del grid).
//	 */
//	public void crearActividad() {
//		System.out.println("Entra a crear actividad" + getNombre() + "::"
//				+ getDescripcion());
//		if (!getIdUsuario().isEmpty()) {
//			sisddeqTUsuario.setIdUsuario(Integer
//					.valueOf(getIdUsuario()));
//		}
//		sisddeqTUsuario.setNombre(getNombre());
//		sisddeqTUsuario.setDescripcion(getDescripcion());
//		try {
//			usuarioSisddeqService.crearActividad(sisddeqTUsuario);
//			init();
//		} catch (Exception e) {
//			System.out.println("Error:::" + e);
//		}
//
//	}
//
//	/**
//	 * Eliminar actividad.
//	 *
//	 * @param event
//	 *            the event. El metodo eliminar actividad funciona como el
//	 *            actualizar necesita un id de la actividad para saber cual es
//	 *            la actividad que va a eliminar. Algunos metodos requieren el
//	 *            metodo event para poder trabajar este esun estandar de
//	 *            primefaces. (verificar si realmente lo necesita). Algunos
//	 *            metodos responden a un evento como: Seleecionar actividad,
//	 *            clic, es decir que primefaces tiene la capacidad para poder
//	 *            identificar cientos elementos de la pantalla.
//	 * 
//	 */
//	public void eliminarActividad(ActionEvent event) {
//		try {
//			System.out.println("Entra a Eliminar actividad" + getNombre()
//					+ "::" + getDescripcion());
//			SisddeqTUsuario actividadCompleta = new SisddeqTUsuario();
//			idUsuario = String.valueOf(actividad.getIdEstado());
//			actividadCompleta = usuarioSisddeqService
//					.consultaActividadPorId(actividad.getIdEstado());
//
//			sisddeqCEstadoActividad
//					.setIdEstado(actividadCompleta.getIdEstado());
//			sisddeqCEstadoActividad.setNombre(actividadCompleta.getNombre());
//			sisddeqCEstadoActividad.setDescripcion(actividadCompleta
//					.getDescripcion());
//
//			System.out.println("id::" + actividadCompleta.getIdEstado());
//			System.out.println("Nombre::" + actividadCompleta.getNombre());
//			System.out.println("Descripcion::"
//					+ actividadCompleta.getDescripcion());
//
//			usuarioSisddeqService.eliminarActividad(sisddeqCEstadoActividad);
//			init();
//		} catch (Exception e) {
//			System.out.println("Error:::" + e);
//		}
//
//	}
//
//	/**
//	 * Inits the. La anotación postConstructor es propia de primfaces. Esta
//	 * anotación le indica que init es el primer metodo que se va a ejecutar.
//	 * Funciona de la misma manera que el constructor de una clase con la
//	 * diferencia que aqui puedes elegir el nombre del metodo que esta inciando
//	 * las operaciones en la clase.
//	 * 
//	 */
//	@PostConstruct
//	public void init() {
//		try {
//			listaUsuario = new ArrayList<SisddeqTUsuario>();
//			listaUsuario = usuarioSisddeqService.consultaActividad();
//
//			for (SisddeqTUsuario activdad : listaUsuario) {
//				actividadSource.add(activdad.getNombre());
//
//			}
//
//			dualListaActividad = new DualListModel<String>(actividadSource,
//					actividadTarget);
//
//		} catch (Exception e) {
//			System.out.println("ERROR MB::" + e);
//		}
//	}
//
//	/**
//	 * Limpiar campos.
//	 *
//	 * @param event
//	 *            the event
//	 *Limpiar campos es un metodo que pone vacio a las variables que se pueden modificar cuando utilizas el crear actividad.
//	 *Este método se manda ejecutar desde la pantalla.
//	 *            
//	 */
//	public void limpiarCampos(ActionEvent event) {
//		setNombre("");
//		setDescripcion("");
//
//	}
//
//	/**
//	 * On row select.
//	 *
//	 * @param event
//	 *            the event. onRowSelect es un metodo propio de primefaces, este
//	 *            metodo responde a un evento de selección en la tabla. Este
//	 *            metodo es estandar es decir que primefaces le pone el
//	 *            onRowSelect responde a la anotación del grid en el
//	 *            .xhtml:selectionMode Cuando tocamos cada uno de los registros
//	 *            de del grid se dispara un evento de selección (SelectEvent)
//	 *            Primefaces automaticamente busca este evento.
//	 * 
//	 */
//	public void onRowSelect(SelectEvent event) {
//
//		SisddeqTUsuario actividadCompleta = new SisddeqTUsuario();
//		idUsuario = String.valueOf(actividad.getIdEstado());
//		actividadCompleta = usuarioSisddeqService
//				.consultaActividadPorId(actividad.getIdEstado());
//		System.out.println("id::" + actividadCompleta.getIdEstado());
//		System.out.println("Nombre::" + actividadCompleta.getNombre());
//		System.out
//				.println("Descripcion::" + actividadCompleta.getDescripcion());
//
//		this.idUsuario = String.valueOf(actividadCompleta.getIdEstado());
//		this.nombre = actividadCompleta.getNombre();
//		this.descripcion = actividadCompleta.getDescripcion();
//
//		setIdActividad(String.valueOf(actividadCompleta.getIdEstado()));
//		setNombre(actividadCompleta.getNombre());
//		setDescripcion(actividadCompleta.getDescripcion());
//
//	}
//
//	
	
}
