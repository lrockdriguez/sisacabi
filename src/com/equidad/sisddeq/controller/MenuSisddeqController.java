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

import com.equidad.sisddeq.entidades.SisddeqCMenu;
import com.equidad.sisddeq.service.MenuSisddeqService;
import com.equidad.sisddeq.service.impl.MenuSisddeqServiceImpl;
 
@ManagedBean(name = "menuSisddeqController")
@ViewScoped
public class MenuSisddeqController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String idMenu = "";
	public String padre = "";
	public String hijo = "";
	public String descripcion = "";
	public MenuSisddeqService menuSisddeqService = new MenuSisddeqServiceImpl();
	public List<SisddeqCMenu> listaSisddeqCMenu = new ArrayList<SisddeqCMenu>();
	private DualListModel<String> dualListaMenu;
	public SisddeqCMenu sisddeqCMenu = new SisddeqCMenu();
	List<String> menuSource = new ArrayList<String>();
	List<String> menuTarget = new ArrayList<String>();
	
	
	
	/**
	 * Crear Menu. Este metodo crea un Menu y la actualiza. Cuando
	 * detecta que se le esta enviando el id de la Menu entonces es un
	 * Menu, si no viene el id entonces esta creando un Menu. No
	 * recibe ningun parametro y todo lo toma de los getters y setters de las
	 * variables que se llenan al seleccionar un Menu. Se agrega el método
	 * init ya que después de que inserta o actualiza se tiene que actualizar el
	 * grid (El metodo init actualiza los datos del grid).
	 */
	public void crearMenu() {
		System.out.println("Entra a crear Menu" + getPadre() + "::"
				+ getHijo());
		if (!getIdMenu().isEmpty()) {
			sisddeqCMenu.setIdMenu(Integer
					.valueOf(getIdMenu()));
		}
		sisddeqCMenu.setPadre(getPadre());
		sisddeqCMenu.setHijo(getHijo());
		try {
			menuSisddeqService.crearMenu(sisddeqCMenu);
			init();
		} catch (Exception e) {
			System.out.println("Error:::" + e);
		}

	}

	/**
	 * Eliminar Menu.
	 *
	 * @param event
	 *            the event. El metodo eliminar Menu funciona como el
	 *            actualizar necesita un id de la Menu para saber cual es
	 *            la Menu que va a eliminar. Algunos metodos requieren el
	 *            metodo event para poder trabajar este esun estandar de
	 *            primefaces. (verificar si realmente lo necesita). Algunos
	 *            metodos responden a un evento como: Seleecionar Menu,
	 *            clic, es decir que primefaces tiene la capacidad para poder
	 *            identificar cientos elementos de la pantalla.
	 * 
	 */
	public void eliminarMenu(ActionEvent event) {
		try {
			System.out.println("Entra a Eliminar Menu" + getPadre()
					+ "::" + getHijo());
			SisddeqCMenu sisddeqCMenuCompleto = new SisddeqCMenu();
			idMenu = String.valueOf(sisddeqCMenu.getIdMenu());
			sisddeqCMenuCompleto = menuSisddeqService
					.consultaMenuPorId(sisddeqCMenu.getIdMenu());

			sisddeqCMenu
					.setIdMenu(sisddeqCMenuCompleto.getIdMenu());
			sisddeqCMenu.setPadre(sisddeqCMenuCompleto.getPadre());
			sisddeqCMenu.setHijo(sisddeqCMenuCompleto
					.getHijo());

			System.out.println("id::" + sisddeqCMenuCompleto.getIdMenu());
			System.out.println("Padre::" + sisddeqCMenuCompleto.getPadre());
			System.out.println("Hijo::"
					+ sisddeqCMenuCompleto.getHijo());

			menuSisddeqService.eliminarMenu(sisddeqCMenu);
			init();
		} catch (Exception e) {
			System.out.println("Error:::" + e);
		}

	}

	/**
	 * Inits the. La anotación postConstructor es propia de primfaces. Esta
	 * anotación le indica que init es el primer metodo que se va a ejecutar.
	 * Funciona de la misma manera que el constructor de un clase con la
	 * diferencia que aqui puedes elegir el nombre del metodo que esta inciando
	 * las operaciones en la clase.
	 * 
	 */
	@PostConstruct
	public void init() {
		try {
			listaSisddeqCMenu = new ArrayList<SisddeqCMenu>();
			listaSisddeqCMenu = menuSisddeqService
					.consultaMenu();

			for (SisddeqCMenu sisddeqCMenu : listaSisddeqCMenu) {
				menuSource.add(sisddeqCMenu.getPadre());

			}

			dualListaMenu = new DualListModel<String>(menuSource,
					menuTarget);

		} catch (Exception e) {
			System.out.println("ERROR MB::" + e);
		}
	}

	/**
	 * Limpiar campos.
	 *
	 * @param event
	 *            the event
	 *Limpiar campos es un metodo que pone vacio a las variables que se pueden modificar cuando utilizas el crear Menu.
	 *Este método se manda ejecutar desde la pantalla.
	 *            
	 */
	public void limpiarCampos(ActionEvent event) {
		setPadre("");
		setHijo("");

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

		SisddeqCMenu menuCompleto = new SisddeqCMenu();
		idMenu = String.valueOf(sisddeqCMenu.getIdMenu());
		menuCompleto = menuSisddeqService
				.consultaMenuPorId(sisddeqCMenu.getIdMenu());
		System.out.println("id::" + menuCompleto.getIdMenu());
		System.out.println("Nombre::" + menuCompleto.getPadre());
		System.out
				.println("Descripcion::" + menuCompleto.getDescripcion());

		this.idMenu = String.valueOf(menuCompleto.getIdMenu());
		this.padre = menuCompleto.getPadre();
		this.hijo= menuCompleto.getHijo();
		this.descripcion = menuCompleto.getDescripcion();

		setIdMenu(String.valueOf(menuCompleto.getIdMenu()));
		setPadre(menuCompleto.getPadre());
		setHijo(menuCompleto.getHijo());
		setDescripcion(menuCompleto.getDescripcion());

	}

	public String getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}

	public String getPadre() {
		return padre;
	}

	public void setPadre(String padre) {
		this.padre = padre;
	}

	public String getHijo() {
		return hijo;
	}

	public void setHijo(String hijo) {
		this.hijo = hijo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public MenuSisddeqService getMenuSisddeqService() {
		return menuSisddeqService;
	}

	public void setMenuSisddeqService(MenuSisddeqService menuSisddeqService) {
		this.menuSisddeqService = menuSisddeqService;
	}

	public List<SisddeqCMenu> getListaSisddeqCMenu() {
		return listaSisddeqCMenu;
	}

	public void setListaSisddeqCMenu(List<SisddeqCMenu> listaSisddeqCMenu) {
		this.listaSisddeqCMenu = listaSisddeqCMenu;
	}

	public DualListModel<String> getDualListaMenu() {
		return dualListaMenu;
	}

	public void setDualListaMenu(DualListModel<String> dualListaMenu) {
		this.dualListaMenu = dualListaMenu;
	}

	public SisddeqCMenu getSisddeqCMenu() {
		return sisddeqCMenu;
	}

	public void setSisddeqCMenu(SisddeqCMenu sisddeqCMenu) {
		this.sisddeqCMenu = sisddeqCMenu;
	}

	public List<String> getMenuSource() {
		return menuSource;
	}

	public void setMenuSource(List<String> menuSource) {
		this.menuSource = menuSource;
	}

	public List<String> getMenuTarget() {
		return menuTarget;
	}

	public void setMenuTarget(List<String> menuTarget) {
		this.menuTarget = menuTarget;
	}
	
	
	
}


