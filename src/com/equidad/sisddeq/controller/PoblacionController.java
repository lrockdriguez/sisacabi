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

import com.equidad.sisddeq.entidades.SisddeqCPoblacion;
import com.equidad.sisddeq.service.PoblacionSisddeqService;
import com.equidad.sisddeq.service.impl.PoblacionSisddeqServiceImpl;


@ManagedBean(name = "poblacionController")
@ViewScoped
public class PoblacionController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The población sisddeq. */
	private PoblacionSisddeqService poblacionSisddeqService = new PoblacionSisddeqServiceImpl();

	/** The lista Poblacion. */
	public List<SisddeqCPoblacion> listaPoblacion = new ArrayList<SisddeqCPoblacion>();

	/** The Poblacion. */
	public SisddeqCPoblacion poblacion = new SisddeqCPoblacion();

	/** The sisddeq c población. */
	public SisddeqCPoblacion sisddeqCPoblacion = new SisddeqCPoblacion();

	/** The dual lista Poblacion. */
	private DualListModel<String> dualListaPoblacion;

	/** The nombre. */
	public String nombre = "";

	/** The descripcion. */
	public String descripcion = "";

	/** The id Poblacion. */
	public String idPoblacion = "";

	/** The Poblacion source. */
	List<String> poblacionSource = new ArrayList<String>();

	/** The Poblacion target. */
	List<String> poblacionTarget = new ArrayList<String>();

	/**
	 * Crear Poblacion. Este metodo crea una Poblacion y la actualiza. Cuando
	 * detecta que se le esta enviando el id de la Poblacion entonces es una
	 * Poblacion, si no viene el id entonces esta creando una Poblacion. No
	 * recibe ningun parametro y todo lo toma de los getters y setters de las
	 * variables que se llenan al seleccionar una Poblacion. Se agrega el método
	 * init ya que después de que inserta o actualiza se tiene que actualizar el
	 * grid (El metodo init actualiza los datos del grid).
	 */
	public void crearPoblacion() {
		System.out.println("Entra a crear Poblacion" + getNombre() + "::"
				+ getDescripcion());
		if (!getIdPoblacion().isEmpty()) {
			sisddeqCPoblacion.setIdsisddeqCPoblacion((Integer
					.valueOf(getIdPoblacion())));
		}
		sisddeqCPoblacion.setNombre(getNombre());
		sisddeqCPoblacion.setDescripcion(getDescripcion());
		try {
			poblacionSisddeqService.crearPoblacion(sisddeqCPoblacion);
			init();
		} catch (Exception e) {
			System.out.println("Error:::" + e);
		}

	}

	/**
	 * Eliminar Poblacion.
	 *
	 * @param event
	 *            the event. El metodo eliminar Poblacion funciona como el
	 *            actualizar necesita un id de la Poblacion para saber cual es
	 *            la Poblacion que va a eliminar. Algunos metodos requieren el
	 *            metodo event para poder trabajar este esun estandar de
	 *            primefaces. (verificar si realmente lo necesita). Algunos
	 *            metodos responden a un evento como: Seleecionar Poblacion,
	 *            clic, es decir que primefaces tiene la capacidad para poder
	 *            identificar cientos elementos de la pantalla.
	 * 
	 */
	public void eliminarPoblacion(ActionEvent event) {
		try {
			System.out.println("Entra a Eliminar Poblacion" + getNombre()
					+ "::" + getDescripcion());

			SisddeqCPoblacion poblacionCompleta = new SisddeqCPoblacion();
			idPoblacion = String.valueOf(poblacion.getIdsisddeqCPoblacion());
			poblacionCompleta = poblacionSisddeqService.consultaPoblacionPorId(sisddeqCPoblacion.getIdsisddeqCPoblacion());

			poblacion.setIdsisddeqCPoblacion((poblacionCompleta.getIdsisddeqCPoblacion()));
			poblacion.setNombre(poblacionCompleta.getNombre());
			poblacion.setDescripcion(poblacionCompleta.getDescripcion());

			System.out.println("id::" + poblacionCompleta.getIdsisddeqCPoblacion());
			System.out.println("Nombre::" + poblacionCompleta.getNombre());
			System.out.println("Descripcion::"
					+ poblacionCompleta.getDescripcion());

			poblacionSisddeqService.eliminarPoblacion(poblacionCompleta);
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
			listaPoblacion = new ArrayList<SisddeqCPoblacion>();
			listaPoblacion = poblacionSisddeqService.consultaOrganizacion();

			for (SisddeqCPoblacion poblacion : listaPoblacion) {
				poblacionSource.add(poblacion.getNombre());

			}

			dualListaPoblacion = new DualListModel<String>(poblacionSource,
					poblacionTarget);

		} catch (Exception e) {
			System.out.println("ERROR MB::" + e);
		}
	}

	/**
	 * Limpiar campos.
	 *
	 * @param event
	 *            the event
	 *Limpiar campos es un metodo que pone vacio a las variables que se pueden modificar cuando utilizas el crear Poblacion.
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

		SisddeqCPoblacion poblacionCompleta = new SisddeqCPoblacion();
		idPoblacion = String.valueOf(poblacion.getIdsisddeqCPoblacion());
		poblacionCompleta = poblacionSisddeqService.consultaPoblacionPorId(poblacion.getIdsisddeqCPoblacion());
		System.out.println("id::" + poblacionCompleta.getIdsisddeqCPoblacion());
		System.out.println("Nombre::" + poblacionCompleta.getNombre());
		System.out
				.println("Descripcion::" + poblacionCompleta.getDescripcion());

		this.idPoblacion = String.valueOf(poblacionCompleta.getIdsisddeqCPoblacion());
		this.nombre = poblacionCompleta.getNombre();
		this.descripcion = poblacionCompleta.getDescripcion();

		setIdPoblacion(String.valueOf(poblacionCompleta.getIdsisddeqCPoblacion()));
		setNombre(poblacionCompleta.getNombre());
		setDescripcion(poblacionCompleta.getDescripcion());

	}

	public PoblacionSisddeqService getPoblacionSisddeqService() {
		return poblacionSisddeqService;
	}

	public void setPoblacionSisddeqService(
			PoblacionSisddeqService poblacionSisddeqService) {
		this.poblacionSisddeqService = poblacionSisddeqService;
	}

	public List<SisddeqCPoblacion> getListaPoblacion() {
		return listaPoblacion;
	}

	public void setListaPoblacion(List<SisddeqCPoblacion> listaPoblacion) {
		this.listaPoblacion = listaPoblacion;
	}

	public SisddeqCPoblacion getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(SisddeqCPoblacion poblacion) {
		this.poblacion = poblacion;
	}

	public SisddeqCPoblacion getSisddeqCPoblacion() {
		return sisddeqCPoblacion;
	}

	public void setSisddeqCPoblacion(SisddeqCPoblacion sisddeqCPoblacion) {
		this.sisddeqCPoblacion = sisddeqCPoblacion;
	}

	public DualListModel<String> getDualListaPoblacion() {
		return dualListaPoblacion;
	}

	public void setDualListaPoblacion(DualListModel<String> dualListaPoblacion) {
		this.dualListaPoblacion = dualListaPoblacion;
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

	public String getIdPoblacion() {
		return idPoblacion;
	}

	public void setIdPoblacion(String idPoblacion) {
		this.idPoblacion = idPoblacion;
	}

	public List<String> getPoblacionSource() {
		return poblacionSource;
	}

	public void setPoblacionSource(List<String> poblacionSource) {
		this.poblacionSource = poblacionSource;
	}

	public List<String> getPoblacionTarget() {
		return poblacionTarget;
	}

	public void setPoblacionTarget(List<String> poblacionTarget) {
		this.poblacionTarget = poblacionTarget;
	}
	
	
}
