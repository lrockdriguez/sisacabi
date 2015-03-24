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

import com.equidad.sisddeq.entidades.SisddeqCTipoBitacora;
import com.equidad.sisddeq.service.TipoBitacoraSisddeqService;
import com.equidad.sisddeq.service.impl.TipoBitacoraSisddeqServiceImpl;

@ManagedBean(name="tipoBitacoraController")
@ViewScoped
public class TipoBitacoraController implements Serializable{

	//** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The estado actividad sisddeq. */
	private TipoBitacoraSisddeqService tipoBitacoraSisddeqService = new TipoBitacoraSisddeqServiceImpl();

	/** The lista actividad. */
	public List<SisddeqCTipoBitacora> listaTipoBitacora = new ArrayList<SisddeqCTipoBitacora>();

	/** The actividad. */
	public SisddeqCTipoBitacora tipoBitacora = new SisddeqCTipoBitacora();

	/** The sisddeq c estado actividad. */
	public SisddeqCTipoBitacora sisddeqCTipoBitacora = new SisddeqCTipoBitacora();

	/** The dual lista actividad. */
	private DualListModel<String> dualTipoBitacora;

	/** The nombre. */
	public String nombre = "";

	/** The descripcion. */
	public String descripcion = "";

	/** The id actividad. */
	public String idTipoBitacora = "";

	/** The actividad source. */
	List<String> tipoBitacoraSource = new ArrayList<String>();

	/** The actividad target. */
	List<String> tipoBitacoraTarget = new ArrayList<String>();

	/**
	 * Crear actividad. Este metodo crea una actividad y la actualiza. Cuando
	 * detecta que se le esta enviando el id de la actividad entonces es una
	 * actividad, si no viene el id entonces esta creando una actividad. No
	 * recibe ningun parametro y todo lo toma de los getters y setters de las
	 * variables que se llenan al seleccionar una actividad. Se agrega el método
	 * init ya que después de que inserta o actualiza se tiene que actualizar el
	 * grid (El metodo init actualiza los datos del grid).
	 */
	public void crearTipoBitacora() {
		System.out.println("Entra a crear actividad" + getNombre() + "::"
				+ getDescripcion());
		if (!getIdTipoBitacora().isEmpty()) {
			sisddeqCTipoBitacora.setIdBitacora(Integer
					.valueOf(getIdTipoBitacora()));
		}
		sisddeqCTipoBitacora.setNombre(getNombre());
		sisddeqCTipoBitacora.setDescripcion(getDescripcion());
		try {
			tipoBitacoraSisddeqService.crearTipoBitacora(sisddeqCTipoBitacora);
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
	public void eliminarTipoBitacora(ActionEvent event) {
		try {
			System.out.println("Entra a Eliminar actividad" + getNombre()
					+ "::" + getDescripcion());
			SisddeqCTipoBitacora tipoBitacoraCompleta = new SisddeqCTipoBitacora();
			idTipoBitacora = String.valueOf(tipoBitacoraCompleta.getIdBitacora());
			tipoBitacoraCompleta = tipoBitacoraSisddeqService
					.consultaTipoBitacoraPorId(tipoBitacoraCompleta.getIdBitacora());

			sisddeqCTipoBitacora.setIdBitacora(tipoBitacoraCompleta.getIdBitacora());
			sisddeqCTipoBitacora.setNombre(tipoBitacoraCompleta.getNombre());
			sisddeqCTipoBitacora.setDescripcion(tipoBitacoraCompleta
					.getDescripcion());

			System.out.println("id::" + tipoBitacoraCompleta.getIdBitacora());
			System.out.println("Nombre::" + tipoBitacoraCompleta.getNombre());
			System.out.println("Descripcion::"
					+ tipoBitacoraCompleta.getDescripcion());

			tipoBitacoraSisddeqService.eliminarTipoBitacora(sisddeqCTipoBitacora);
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
			listaTipoBitacora = new ArrayList<SisddeqCTipoBitacora>();
			listaTipoBitacora = tipoBitacoraSisddeqService.consultaTipoBitacora();

			for (SisddeqCTipoBitacora tipoBitacora : listaTipoBitacora) {
				tipoBitacoraSource.add(tipoBitacora.getNombre());

			}

			dualTipoBitacora = new DualListModel<String>(tipoBitacoraSource,
					tipoBitacoraTarget);

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

		SisddeqCTipoBitacora tipoBitacoraCompleta = new SisddeqCTipoBitacora();
		idTipoBitacora = String.valueOf(tipoBitacora.getIdBitacora());
		tipoBitacoraCompleta = tipoBitacoraSisddeqService
				.consultaTipoBitacoraPorId(tipoBitacora.getIdBitacora());
		System.out.println("id::" + tipoBitacoraCompleta.getIdBitacora());
		System.out.println("Nombre::" + tipoBitacoraCompleta.getNombre());
		System.out
				.println("Descripcion::" + tipoBitacoraCompleta.getDescripcion());

		this.idTipoBitacora = String.valueOf(tipoBitacoraCompleta.getIdBitacora());
		this.nombre = tipoBitacoraCompleta.getNombre();
		this.descripcion = tipoBitacoraCompleta.getDescripcion();

		setIdTipoBitacora(String.valueOf(tipoBitacoraCompleta.getIdBitacora()));
		setNombre(tipoBitacoraCompleta.getNombre());
		setDescripcion(tipoBitacoraCompleta.getDescripcion());

	}

	public TipoBitacoraSisddeqService getTipoBitacoraSisddeqService() {
		return tipoBitacoraSisddeqService;
	}

	public void setTipoBitacoraSisddeqService(
			TipoBitacoraSisddeqService tipoBitacoraSisddeqService) {
		this.tipoBitacoraSisddeqService = tipoBitacoraSisddeqService;
	}

	public List<SisddeqCTipoBitacora> getListaTipoBitacora() {
		return listaTipoBitacora;
	}

	public void setListaTipoBitacora(List<SisddeqCTipoBitacora> listaTipoBitacora) {
		this.listaTipoBitacora = listaTipoBitacora;
	}

	public SisddeqCTipoBitacora getTipoBitacora() {
		return tipoBitacora;
	}

	public void setTipoBitacora(SisddeqCTipoBitacora tipoBitacora) {
		this.tipoBitacora = tipoBitacora;
	}

	public SisddeqCTipoBitacora getSisddeqCTipoBitacora() {
		return sisddeqCTipoBitacora;
	}

	public void setSisddeqCTipoBitacora(SisddeqCTipoBitacora sisddeqCTipoBitacora) {
		this.sisddeqCTipoBitacora = sisddeqCTipoBitacora;
	}

	public DualListModel<String> getDualTipoBitacora() {
		return dualTipoBitacora;
	}

	public void setDualTipoBitacora(DualListModel<String> dualTipoBitacora) {
		this.dualTipoBitacora = dualTipoBitacora;
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

	public String getIdTipoBitacora() {
		return idTipoBitacora;
	}

	public void setIdTipoBitacora(String idTipoBitacora) {
		this.idTipoBitacora = idTipoBitacora;
	}

	public List<String> getTipoBitacoraSource() {
		return tipoBitacoraSource;
	}

	public void setTipoBitacoraSource(List<String> tipoBitacoraSource) {
		this.tipoBitacoraSource = tipoBitacoraSource;
	}

	public List<String> getTipoBitacoraTarget() {
		return tipoBitacoraTarget;
	}

	public void setTipoBitacoraTarget(List<String> tipoBitacoraTarget) {
		this.tipoBitacoraTarget = tipoBitacoraTarget;
	}

	
	
}
