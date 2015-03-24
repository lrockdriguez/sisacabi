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

import com.equidad.sisddeq.entidades.SisddeqCProposito;
import com.equidad.sisddeq.service.PropositoSisddeqService;
import com.equidad.sisddeq.service.impl.PropositoSisddeqServiceImpl;

@ManagedBean(name = "propositoController")
@ViewScoped
public class PropositoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/** The Proposito sisddeq. */
	private PropositoSisddeqService propositoSisddeqService = new PropositoSisddeqServiceImpl();

	/** The lista Proposito. */
	public List<SisddeqCProposito> listaProposito = new ArrayList<SisddeqCProposito>();

	/** The Proposito. */
	public SisddeqCProposito proposito = new SisddeqCProposito();

	/** The sisddeq c Proposito. */
	public SisddeqCProposito sisddeqCProposito = new SisddeqCProposito();

	/** The dual lista Proposito. */
	private DualListModel<String> dualListaProposito;

	/** The nombre. */
	public String nombre = "";

	/** The descripcion. */
	public String descripcion = "";

	/** The id Proposito. */
	public String idProposito = "";

	/** The Proposito source. */
	List<String> propositoSource = new ArrayList<String>();

	/** The Proposito target. */
	List<String> propositoTarget = new ArrayList<String>();

	/**
	 * Crear Proposito. Este metodo crea una Proposito y la actualiza. Cuando
	 * detecta que se le esta enviando el id de la Proposito entonces es una
	 * Proposito, si no viene el id entonces esta creando una Proposito. No
	 * recibe ningun parametro y todo lo toma de los getters y setters de las
	 * variables que se llenan al seleccionar una Proposito. Se agrega el método
	 * init ya que después de que inserta o actualiza se tiene que actualizar el
	 * grid (El metodo init actualiza los datos del grid).
	 */
	public void crearProposito() {
		System.out.println("Entra a crear Proposito" + getNombre() + "::"
				+ getDescripcion());
		if (!getIdProposito().isEmpty()) {
			sisddeqCProposito.setIdProposito((Integer
					.valueOf(getIdProposito())));
		}
		sisddeqCProposito.setNombre(getNombre());
		sisddeqCProposito.setDescripcion(getDescripcion());
		try {
			propositoSisddeqService.crearProposito(sisddeqCProposito);
			init();
		} catch (Exception e) {
			System.out.println("Error:::" + e);
		}

	}

	/**
	 * Eliminar Proposito.
	 *
	 * @param event
	 *            the event. El metodo eliminar Proposito funciona como el
	 *            actualizar necesita un id de la Proposito para saber cual es
	 *            la Proposito que va a eliminar. Algunos metodos requieren el
	 *            metodo event para poder trabajar este esun estandar de
	 *            primefaces. (verificar si realmente lo necesita). Algunos
	 *            metodos responden a un evento como: Seleecionar Proposito,
	 *            clic, es decir que primefaces tiene la capacidad para poder
	 *            identificar cientos elementos de la pantalla.
	 * 
	 */
	public void eliminarProposito(ActionEvent event) {
		try {
			System.out.println("Entra a Eliminar Proposito" + getNombre()
					+ "::" + getDescripcion());

			SisddeqCProposito propositoCompleta = new SisddeqCProposito();
			idProposito = String.valueOf(proposito.getIdProposito());
			propositoCompleta = propositoSisddeqService.consultaPropositoPorId(sisddeqCProposito.getIdProposito());

			proposito.setIdProposito((propositoCompleta.getIdProposito()));
			proposito.setNombre(propositoCompleta.getNombre());
			proposito.setDescripcion(propositoCompleta.getDescripcion());

			System.out.println("id::" + propositoCompleta.getIdProposito());
			System.out.println("Nombre::" + propositoCompleta.getNombre());
			System.out.println("Descripcion::"
					+ propositoCompleta.getDescripcion());

			propositoSisddeqService.eliminarProposito(propositoCompleta);
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
			listaProposito = new ArrayList<SisddeqCProposito>();
			listaProposito = propositoSisddeqService.consultaProposito();

			for (SisddeqCProposito Proposito : listaProposito) {
				propositoSource.add(Proposito.getNombre());

			}

			dualListaProposito = new DualListModel<String>(propositoSource,
					propositoTarget);

		} catch (Exception e) {
			System.out.println("ERROR MB::" + e);
		}
	}

	/**
	 * Limpiar campos.
	 *
	 * @param event
	 *            the event
	 *Limpiar campos es un metodo que pone vacio a las variables que se pueden modificar cuando utilizas el crear Proposito.
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

		SisddeqCProposito propositoCompleta = new SisddeqCProposito();
		idProposito = String.valueOf(proposito.getIdProposito());
		propositoCompleta = propositoSisddeqService.consultaPropositoPorId(proposito.getIdProposito());
		System.out.println("id::" + propositoCompleta.getIdProposito());
		System.out.println("Nombre::" + propositoCompleta.getNombre());
		System.out
				.println("Descripcion::" + propositoCompleta.getDescripcion());

		this.idProposito = String.valueOf(propositoCompleta.getIdProposito());
		this.nombre = propositoCompleta.getNombre();
		this.descripcion = propositoCompleta.getDescripcion();

		setIdProposito(String.valueOf(propositoCompleta.getIdProposito()));
		setNombre(propositoCompleta.getNombre());
		setDescripcion(propositoCompleta.getDescripcion());

	}

	public PropositoSisddeqService getPropositoSisddeqService() {
		return propositoSisddeqService;
	}

	public void setPropositoSisddeqService(
			PropositoSisddeqService propositoSisddeqService) {
		this.propositoSisddeqService = propositoSisddeqService;
	}

	public List<SisddeqCProposito> getListaProposito() {
		return listaProposito;
	}

	public void setListaProposito(List<SisddeqCProposito> listaProposito) {
		this.listaProposito = listaProposito;
	}

	public SisddeqCProposito getProposito() {
		return proposito;
	}

	public void setProposito(SisddeqCProposito proposito) {
		this.proposito = proposito;
	}

	public SisddeqCProposito getSisddeqCProposito() {
		return sisddeqCProposito;
	}

	public void setSisddeqCProposito(SisddeqCProposito sisddeqCProposito) {
		this.sisddeqCProposito = sisddeqCProposito;
	}

	public DualListModel<String> getDualListaProposito() {
		return dualListaProposito;
	}

	public void setDualListaProposito(DualListModel<String> dualListaProposito) {
		this.dualListaProposito = dualListaProposito;
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

	public String getIdProposito() {
		return idProposito;
	}

	public void setIdProposito(String idProposito) {
		this.idProposito = idProposito;
	}

	public List<String> getPropositoSource() {
		return propositoSource;
	}

	public void setPropositoSource(List<String> propositoSource) {
		this.propositoSource = propositoSource;
	}

	public List<String> getPropositoTarget() {
		return propositoTarget;
	}

	public void setPropositoTarget(List<String> propositoTarget) {
		this.propositoTarget = propositoTarget;
	}
	
	
}
