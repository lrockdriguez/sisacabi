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

import com.equidad.sisddeq.entidades.SisddeqTOrigenAsistencia;
import com.equidad.sisddeq.service.OrigenAsistenciaSisddeqService;
import com.equidad.sisddeq.service.impl.OrigenAsistenciaSisddeqServiceImpl;

@ManagedBean(name = "origenAsistenciaSisddeqController")
@ViewScoped
public class OrigenAsistenciaSisddeqController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** The organización sisddeq. */
	private OrigenAsistenciaSisddeqService origenAsistenciaSisddeqService = new OrigenAsistenciaSisddeqServiceImpl();

	/** The lista Origen. */
	public List<SisddeqTOrigenAsistencia> listaOrigen = new ArrayList<SisddeqTOrigenAsistencia>();

	/** The Origen. */
	public SisddeqTOrigenAsistencia origen = new SisddeqTOrigenAsistencia();

	/** The sisddeq c organización. */
	public SisddeqTOrigenAsistencia sisddeqTOrigenAsistencia = new SisddeqTOrigenAsistencia();

	/** The dual lista Origen. */
	private DualListModel<String> dualListaOrigen;

	/** The nombre. */
	public String nombre = "";

	/** The descripcion. */
	public String descripcion = "";

	/** The id Origen. */
	public String idOrigen = "";

	/** The Origen source. */
	List<String> origenSource = new ArrayList<String>();

	/** The Origen target. */
	List<String> origenTarget = new ArrayList<String>();

	/**
	 * Crear Origen. Este metodo crea una Origen y la actualiza. Cuando
	 * detecta que se le esta enviando el id de la Origen entonces es una
	 * Origen, si no viene el id entonces esta creando una Origen. No
	 * recibe ningun parametro y todo lo toma de los getters y setters de las
	 * variables que se llenan al seleccionar una Origen. Se agrega el método
	 * init ya que después de que inserta o actualiza se tiene que actualizar el
	 * grid (El metodo init actualiza los datos del grid).
	 */
	public void crearOrigen() {
		System.out.println("Entra a crear Origen" + getNombre() + "::"
				+ getDescripcion());
		if (!getIdOrigen().isEmpty()) {
			sisddeqTOrigenAsistencia.setIdOAsistencia((Integer
					.valueOf(getIdOrigen())));
		}
		sisddeqTOrigenAsistencia.setNombre(getNombre());
		sisddeqTOrigenAsistencia.setDescripcion(getDescripcion());
		try {
			origenAsistenciaSisddeqService.crearOrigenAsistencia(sisddeqTOrigenAsistencia);
			init();
		} catch (Exception e) {
			System.out.println("Error:::" + e);
		}

	}

	/**
	 * Eliminar Origen.
	 *
	 * @param event
	 *            the event. El metodo eliminar Origen funciona como el
	 *            actualizar necesita un id de la Origen para saber cual es
	 *            la Origen que va a eliminar. Algunos metodos requieren el
	 *            metodo event para poder trabajar este esun estandar de
	 *            primefaces. (verificar si realmente lo necesita). Algunos
	 *            metodos responden a un evento como: Seleecionar Origen,
	 *            clic, es decir que primefaces tiene la capacidad para poder
	 *            identificar cientos elementos de la pantalla.
	 * 
	 */
	public void eliminarOrigen(ActionEvent event) {
		try {
			System.out.println("Entra a Eliminar Origen" + getNombre()
					+ "::" + getDescripcion());

			SisddeqTOrigenAsistencia origenCompleta = new SisddeqTOrigenAsistencia();
			idOrigen = String.valueOf(origen.getIdOAsistencia());
			origenCompleta = origenAsistenciaSisddeqService.consultaOrigenAsistenciaPorId(origen.getIdOAsistencia());

			origen.setIdOAsistencia((origenCompleta.getIdOAsistencia()));
			origen.setNombre(origenCompleta.getNombre());
			origen.setDescripcion(origenCompleta.getDescripcion());

			System.out.println("id::" + origenCompleta.getIdOAsistencia());
			System.out.println("Nombre::" + origenCompleta.getNombre());
			System.out.println("Descripcion::"
					+ origenCompleta.getDescripcion());

			origenAsistenciaSisddeqService.eliminarOrigenAsistencia(origenCompleta);
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
			listaOrigen = new ArrayList<SisddeqTOrigenAsistencia>();
			listaOrigen = origenAsistenciaSisddeqService.consultaOrigenAsistencia();

			for (SisddeqTOrigenAsistencia origen : listaOrigen) {
				origenSource.add(origen.getNombre());

			}

			dualListaOrigen = new DualListModel<String>(origenSource,
					origenTarget);

		} catch (Exception e) {
			System.out.println("ERROR MB::" + e);
		}
	}

	/**
	 * Limpiar campos.
	 *
	 * @param event
	 *            the event
	 *Limpiar campos es un metodo que pone vacio a las variables que se pueden modificar cuando utilizas el crear Origen.
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

		SisddeqTOrigenAsistencia origenCompleta = new SisddeqTOrigenAsistencia();
		idOrigen = String.valueOf(origen.getIdOAsistencia());
		origenCompleta = origenAsistenciaSisddeqService.consultaOrigenAsistenciaPorId(origen.getIdOAsistencia());
		System.out.println("id::" + origenCompleta.getIdOAsistencia());
		System.out.println("Nombre::" + origenCompleta.getNombre());
		System.out
				.println("Descripcion::" + origenCompleta.getDescripcion());

		this.idOrigen = String.valueOf(origenCompleta.getIdOAsistencia());
		this.nombre = origenCompleta.getNombre();
		this.descripcion = origenCompleta.getDescripcion();

		setIdOrigen(String.valueOf(origenCompleta.getIdOAsistencia()));
		setNombre(origenCompleta.getNombre());
		setDescripcion(origenCompleta.getDescripcion());

	}

	public OrigenAsistenciaSisddeqService getOrigenAsistenciaSisddeqService() {
		return origenAsistenciaSisddeqService;
	}

	public void setOrigenAsistenciaSisddeqService(
			OrigenAsistenciaSisddeqService origenAsistenciaSisddeqService) {
		this.origenAsistenciaSisddeqService = origenAsistenciaSisddeqService;
	}

	public List<SisddeqTOrigenAsistencia> getListaOrigen() {
		return listaOrigen;
	}

	public void setListaOrigen(List<SisddeqTOrigenAsistencia> listaOrigen) {
		this.listaOrigen = listaOrigen;
	}

	public SisddeqTOrigenAsistencia getOrigen() {
		return origen;
	}

	public void setOrigen(SisddeqTOrigenAsistencia origen) {
		this.origen = origen;
	}

	public SisddeqTOrigenAsistencia getSisddeqTOrigenAsistencia() {
		return sisddeqTOrigenAsistencia;
	}

	public void setSisddeqTOrigenAsistencia(
			SisddeqTOrigenAsistencia sisddeqTOrigenAsistencia) {
		this.sisddeqTOrigenAsistencia = sisddeqTOrigenAsistencia;
	}

	public DualListModel<String> getDualListaOrigen() {
		return dualListaOrigen;
	}

	public void setDualListaOrigen(DualListModel<String> dualListaOrigen) {
		this.dualListaOrigen = dualListaOrigen;
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

	public String getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(String idOrigen) {
		this.idOrigen = idOrigen;
	}

	public List<String> getOrigenSource() {
		return origenSource;
	}

	public void setOrigenSource(List<String> origenSource) {
		this.origenSource = origenSource;
	}

	public List<String> getOrigenTarget() {
		return origenTarget;
	}

	public void setOrigenTarget(List<String> origenTarget) {
		this.origenTarget = origenTarget;
	}
	
	
}