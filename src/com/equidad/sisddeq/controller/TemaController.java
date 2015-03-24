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

import com.equidad.sisddeq.entidades.SisddeqCEstadoActividad;
import com.equidad.sisddeq.entidades.SisddeqCTema;
import com.equidad.sisddeq.service.TemaSisddeqService;
import com.equidad.sisddeq.service.impl.TemaSisddeqServiceImpl;

@ManagedBean(name="temaController")
@ViewScoped
public class TemaController implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The estado actividad sisddeq. */
	private TemaSisddeqService temaSisddeqService = new TemaSisddeqServiceImpl();

	/** The lista actividad. */
	public List<SisddeqCTema> listaTema = new ArrayList<SisddeqCTema>();

	/** The actividad. */
	public SisddeqCTema tema = new SisddeqCTema();

	/** The sisddeq c estado actividad. */
	public SisddeqCTema sisddeqCTema = new SisddeqCTema();

	/** The dual lista actividad. */
	private DualListModel<String> dualListaTema;

	/** The nombre. */
	public String nombre = "";

	/** The descripcion. */
	public String descripcion = "";

	/** The id actividad. */
	public String idTema = "";

	/** The actividad source. */
	List<String> temaSource = new ArrayList<String>();

	/** The actividad target. */
	List<String> temaTarget = new ArrayList<String>();

	/**
	 * Crear actividad. Este metodo crea una actividad y la actualiza. Cuando
	 * detecta que se le esta enviando el id de la actividad entonces es una
	 * actividad, si no viene el id entonces esta creando una actividad. No
	 * recibe ningun parametro y todo lo toma de los getters y setters de las
	 * variables que se llenan al seleccionar una actividad. Se agrega el método
	 * init ya que después de que inserta o actualiza se tiene que actualizar el
	 * grid (El metodo init actualiza los datos del grid).
	 */
	public void crearTema() {
		System.out.println("Entra a crear actividad" + getNombre() + "::"+ getDescripcion());
		if (!getIdTema().isEmpty()) {
			sisddeqCTema.setIdTema(Integer.valueOf(getIdTema()));
		}
		sisddeqCTema.setNombre(getNombre());
		sisddeqCTema.setDescripcion(getDescripcion());
		try {
			temaSisddeqService.crearTema(sisddeqCTema);
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
	public void eliminarTema(ActionEvent event) {
		try {
			System.out.println("Entra a Eliminar actividad" + getNombre()
					+ "::" + getDescripcion());
			SisddeqCTema temaCompleto = new SisddeqCTema();
			idTema = String.valueOf(sisddeqCTema.getIdTema());
			temaCompleto = temaSisddeqService.consultaTemaPorId(sisddeqCTema.getIdTema());

			sisddeqCTema.setIdTema(temaCompleto.getIdTema());
			sisddeqCTema.setNombre(temaCompleto.getNombre());
			sisddeqCTema.setDescripcion(temaCompleto
					.getDescripcion());

			System.out.println("id::" + sisddeqCTema.getIdTema());
			System.out.println("Nombre::" + sisddeqCTema.getNombre());
			System.out.println("Descripcion::"
					+ sisddeqCTema.getDescripcion());

			temaSisddeqService.eliminarTema(temaCompleto);
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
			listaTema = new ArrayList<SisddeqCTema>();
			listaTema = temaSisddeqService.consultaTema();

			for (SisddeqCTema activdad : listaTema) {
				temaSource.add(activdad.getNombre());

			}

			dualListaTema = new DualListModel<String>(temaSource,
					temaTarget);

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

		SisddeqCTema temaCompleto = new SisddeqCTema();
		idTema = String.valueOf(tema.getIdTema());
		temaCompleto = temaSisddeqService.consultaTemaPorId(tema.getIdTema());
				
		System.out.println("id::" + temaCompleto.getIdTema());
		System.out.println("Nombre::" + temaCompleto.getNombre());
		System.out
				.println("Descripcion::" + temaCompleto.getDescripcion());

		this.idTema = String.valueOf(temaCompleto.getIdTema());
		this.nombre = temaCompleto.getNombre();
		this.descripcion = temaCompleto.getDescripcion();

		setIdTema(String.valueOf(temaCompleto.getIdTema()));
		setNombre(temaCompleto.getNombre());
		setDescripcion(temaCompleto.getDescripcion());

	}

	public TemaSisddeqService getTemaSisddeqService() {
		return temaSisddeqService;
	}

	public void setTemaSisddeqService(TemaSisddeqService temaSisddeqService) {
		this.temaSisddeqService = temaSisddeqService;
	}

	public List<SisddeqCTema> getListaTema() {
		return listaTema;
	}

	public void setListaTema(List<SisddeqCTema> listaTema) {
		this.listaTema = listaTema;
	}

	public SisddeqCTema getTema() {
		return tema;
	}

	public void setTema(SisddeqCTema tema) {
		this.tema = tema;
	}

	public SisddeqCTema getSisddeqCTema() {
		return sisddeqCTema;
	}

	public void setSisddeqCTema(SisddeqCTema sisddeqCTema) {
		this.sisddeqCTema = sisddeqCTema;
	}

	public DualListModel<String> getDualListaTema() {
		return dualListaTema;
	}

	public void setDualListaTema(DualListModel<String> dualListaTema) {
		this.dualListaTema = dualListaTema;
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

	public String getIdTema() {
		return idTema;
	}

	public void setIdTema(String idTema) {
		this.idTema = idTema;
	}

	public List<String> getTemaSource() {
		return temaSource;
	}

	public void setTemaSource(List<String> temaSource) {
		this.temaSource = temaSource;
	}

	public List<String> getTemaTarget() {
		return temaTarget;
	}

	public void setTemaTarget(List<String> temaTarget) {
		this.temaTarget = temaTarget;
	}

	
	
}
