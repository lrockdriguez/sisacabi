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
import com.equidad.sisddeq.entidades.SisddeqCSector;
import com.equidad.sisddeq.service.SectorSisddeqService;
import com.equidad.sisddeq.service.impl.SectorSisddeqServiceImpl;

@ManagedBean(name = "sectorSisddeqController")
@ViewScoped
public class SectorSisddeqController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** The población sisddeq. */
	private SectorSisddeqService sectorSisddeqService = new SectorSisddeqServiceImpl();

	/** The lista Sector. */
	public List<SisddeqCSector> listaSector = new ArrayList<SisddeqCSector>();

	/** The Sector. */
	public SisddeqCSector sector = new SisddeqCSector();

	/** The sisddeq c población. */
	public SisddeqCSector sisddeqCSector = new SisddeqCSector();

	/** The dual lista Sector. */
	private DualListModel<String> dualListaSector;

	/** The nombre. */
	public String nombre = "";

	/** The descripcion. */
	public String descripcion = "";

	/** The id Sector. */
	public String idSector = "";

	/** The Sector source. */
	List<String> sectorSource = new ArrayList<String>();

	/** The Sector target. */
	List<String> sectorTarget = new ArrayList<String>();

	/**
	 * Crear Sector. Este metodo crea una Sector y la actualiza. Cuando
	 * detecta que se le esta enviando el id de la Sector entonces es una
	 * Sector, si no viene el id entonces esta creando una Sector. No
	 * recibe ningun parametro y todo lo toma de los getters y setters de las
	 * variables que se llenan al seleccionar una Sector. Se agrega el método
	 * init ya que después de que inserta o actualiza se tiene que actualizar el
	 * grid (El metodo init actualiza los datos del grid).
	 */
	public void crearSector() {
		System.out.println("Entra a crear Sector" + getNombre() + "::"
				+ getDescripcion());
		if (!getIdSector().isEmpty()) {
			sisddeqCSector.setIdSector((Integer
					.valueOf(getIdSector())));
		}
		sisddeqCSector.setNombre(getNombre());
		sisddeqCSector.setDescripcion(getDescripcion());
		try {
			sectorSisddeqService.crearSector(sisddeqCSector);
			init();
		} catch (Exception e) {
			System.out.println("Error:::" + e);
		}

	}

	/**
	 * EliminSectortos.
	 *
	 * @param event
	 *            the event. El metodo eliminar sector funciona como el
	 *            actualizar necesita un id de la sector para saber sector	             
	 *            la sector que va a eliminar. Algunos metodos requieren el
	 *            metodo event para poder trabajar este esun estandar de
	 *            primefaces. (verificar si realmente lo necesita). Algunos
	 *            metodos responden a un evento como: Seleecionar sector,
	 *            clic, es decir que primefaces tiene la capacidad para poder
	 *            identificar cientos elementos de la pantalla.
	 * 
	 */
	public void eliminarSector(ActionEvent event) {
		try {
			System.out.println("Entra a Eliminar sector" + getNombre()
					+ "::" + getDescripcion());

			SisddeqCSector sectorCompleta = new SisddeqCSector();
			idSector = String.valueOf(sector.getIdSector());
			sectorCompleta = sectorSisddeqService.consultaSectorPorId(sector.getIdSector());
			sector.setIdSector(sector.getIdSector());
			sector.setNombre(sectorCompleta.getNombre());
			sector.setDescripcion(sectorCompleta.getDescripcion());

			System.out.println("id::" + sector.getIdSector());
			System.out.println("Nombre::" + sectorCompleta.getNombre());
			System.out.println("Descripcion::"
					+ sectorCompleta.getDescripcion());

			sectorSisddeqService.eliminarSector(sectorCompleta);
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
			listaSector = new ArrayList<SisddeqCSector>();
			listaSector = sectorSisddeqService.consultaSector();

			for (SisddeqCSector sector : listaSector) {
				sectorSource.add(sector.getNombre());

			}

			dualListaSector = new DualListModel<String>(sectorSource,
					sectorTarget);

		} catch (Exception e) {
			System.out.println("ERROR MB::" + e);
		}
	}

	/**
	 * Limpiar campos.
	 *
	 * @param event
	 *            the event
	 *Limpiar campos es un metodo que pone vacio a las variables que se pueden modificar cuando utilizas el crear sector.
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

		SisddeqCSector sectorCompleta = new SisddeqCSector();
		idSector = String.valueOf(sector.getIdSector());
		sectorCompleta = sectorSisddeqService.consultaSectorPorId(sector.getIdSector());
		System.out.println("id::" + sectorCompleta.getIdSector());
		System.out.println("Nombre::" + sectorCompleta.getNombre());
		System.out
				.println("Descripcion::" + sectorCompleta.getDescripcion());

		this.idSector = String.valueOf(sectorCompleta.getIdSector());
		this.nombre = sectorCompleta.getNombre();
		this.descripcion = sectorCompleta.getDescripcion();

		setIdSector(String.valueOf(sectorCompleta.getIdSector()));
		setNombre(sectorCompleta.getNombre());
		setDescripcion(sectorCompleta.getDescripcion());

	}

	public SectorSisddeqService getSectorSisddeqService() {
		return sectorSisddeqService;
	}

	public void setSectorSisddeqService(SectorSisddeqService sectorSisddeqService) {
		this.sectorSisddeqService = sectorSisddeqService;
	}

	public List<SisddeqCSector> getListaSector() {
		return listaSector;
	}

	public void setListaSector(List<SisddeqCSector> listaSector) {
		this.listaSector = listaSector;
	}

	public SisddeqCSector getSector() {
		return sector;
	}

	public void setSector(SisddeqCSector sector) {
		this.sector = sector;
	}

	public SisddeqCSector getSisddeqCSector() {
		return sisddeqCSector;
	}

	public void setSisddeqCSector(SisddeqCSector sisddeqCSector) {
		this.sisddeqCSector = sisddeqCSector;
	}

	public DualListModel<String> getDualListaSector() {
		return dualListaSector;
	}

	public void setDualListaSector(DualListModel<String> dualListaSector) {
		this.dualListaSector = dualListaSector;
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

	public String getIdSector() {
		return idSector;
	}

	public void setIdSector(String idSector) {
		this.idSector = idSector;
	}

	public List<String> getSectorSource() {
		return sectorSource;
	}

	public void setSectorSource(List<String> sectorSource) {
		this.sectorSource = sectorSource;
	}

	public List<String> getSectorTarget() {
		return sectorTarget;
	}

	public void setSectorTarget(List<String> sectorTarget) {
		this.sectorTarget = sectorTarget;
	}

}
