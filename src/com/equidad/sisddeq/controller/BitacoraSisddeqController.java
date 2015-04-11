/*
 * 
 */
package com.equidad.sisddeq.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;


import org.primefaces.model.DualListModel;

import com.equidad.sisddeq.entidades.Estado;
import com.equidad.sisddeq.entidades.Localidade;
import com.equidad.sisddeq.entidades.Municipio;
import com.equidad.sisddeq.entidades.SisddeqCEstadoActividad;
import com.equidad.sisddeq.entidades.SisddeqCPoblacion;
import com.equidad.sisddeq.entidades.SisddeqCProposito;
import com.equidad.sisddeq.entidades.SisddeqCProyecto;
import com.equidad.sisddeq.entidades.SisddeqCSector;
import com.equidad.sisddeq.entidades.SisddeqCTema;
import com.equidad.sisddeq.entidades.SisddeqTOrigenAsistencia;
import com.equidad.sisddeq.service.BitacoraSisddeqService;
import com.equidad.sisddeq.service.EstadoActividadSisddeqService;
import com.equidad.sisddeq.service.EstadosSisddeqService;
import com.equidad.sisddeq.service.LocalidadesSisddeqService;
import com.equidad.sisddeq.service.MunicipioSisddeqService;
import com.equidad.sisddeq.service.OrigenAsistenciaSisddeqService;
import com.equidad.sisddeq.service.PoblacionSisddeqService;
import com.equidad.sisddeq.service.PropositoSisddeqService;
import com.equidad.sisddeq.service.ProyectosSisddeqService;
import com.equidad.sisddeq.service.SectorSisddeqService;
import com.equidad.sisddeq.service.TemaSisddeqService;
import com.equidad.sisddeq.service.impl.BitacoraSisddeqServiceImpl;
import com.equidad.sisddeq.service.impl.EstadoActividadSisddeqServiceImpl;
import com.equidad.sisddeq.service.impl.EstadosSisddeqServiceImpl;
import com.equidad.sisddeq.service.impl.LocalidadesSisddeqServiceImpl;
import com.equidad.sisddeq.service.impl.MunicipioSisddeqServiceImpl;
import com.equidad.sisddeq.service.impl.OrigenAsistenciaSisddeqServiceImpl;
import com.equidad.sisddeq.service.impl.PoblacionSisddeqServiceImpl;
import com.equidad.sisddeq.service.impl.PropositoSisddeqServiceImpl;
import com.equidad.sisddeq.service.impl.ProyectosSisddeqServiceImpl;
import com.equidad.sisddeq.service.impl.SectorSisddeqServiceImpl;
import com.equidad.sisddeq.service.impl.TemaSisddeqServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class BitacoraSisddeqController.
 */
@ManagedBean(name = "bitacoraSisddeqController")
@ViewScoped
public class BitacoraSisddeqController implements Serializable {

	/** The fecha bitacora. */
	public Date fechaBitacora = new Date();
	
	/** The estado actividad sisddeq service. */
	private EstadoActividadSisddeqService estadoActividadSisddeqService = new EstadoActividadSisddeqServiceImpl();
	
	/** The origen asistencia sisddeq service. */
	private OrigenAsistenciaSisddeqService origenAsistenciaSisddeqService = new OrigenAsistenciaSisddeqServiceImpl();
	
	/** The proposito sisddeq service. */
	private PropositoSisddeqService propositoSisddeqService = new PropositoSisddeqServiceImpl();
	
	/** The tema sisddeq service. */
	private TemaSisddeqService temaSisddeqService = new TemaSisddeqServiceImpl();
	
	/** The instituciones. */
	private String instituciones = "";
	
	/** The horas. */
	private int horas=0;
	
	/** The asistentes. */
	private int asistentes=0;
	
	/** The bitacora sisddeq service. */
	private BitacoraSisddeqService bitacoraSisddeqService = new BitacoraSisddeqServiceImpl();
	
	/** The sector sisddeq service. */
	private SectorSisddeqService sectorSisddeqService = new SectorSisddeqServiceImpl();
	
	/** The poblacion sisddeq service. */
	private PoblacionSisddeqService poblacionSisddeqService = new PoblacionSisddeqServiceImpl();
	
	/** The presencia medios. */
	private boolean presenciaMedios = Boolean.FALSE;
	
	/** The comentarios. */
	private String comentarios ="";
	
	/** The proyectos sisddeq service. */
	private ProyectosSisddeqService proyectosSisddeqService = new ProyectosSisddeqServiceImpl();
	
	/** The accion fecha conmemorativa. */
	private boolean accionFechaConmemorativa= Boolean.FALSE;
	
	private String accionFechaConmemorativas= "";
	
	private String accionPrescenciaMedios= "";
	
	/** The actividades duel list. */
	private  DualListModel<String> actividadesDuelList = new DualListModel<String>();
	
	/** The actividades source. */
	private List<String> actividadesSource = new ArrayList<String>();
	
	//private List<String> temaSource = new ArrayList<String>();
	
	private List<String> listaTemaSource = new ArrayList<String>();
	
	/** The actividades target. */
	private List<String> actividadesTarget = new ArrayList<String>();
	
	//picklist
	private List<String> listaTemaTarget = new ArrayList<String>();
	
	//pickList
	private List<String> temaTarget = new ArrayList<String>();
	
	
	private DualListModel<String> temaDuelList = new DualListModel<String>();
	
	/** The actividades dual model. */
	private DualListModel<String> actividadesDualModel = new DualListModel<String>();
	
	//Añadido para el pickList
	//private DualListModel<String> temaDualModel = new DualListModel<String>();
	
	private DualListModel<String> listaTema = new DualListModel<String>(); 
	
	/** The lista sisddeq c estado actividad. */
	private  List<SisddeqCEstadoActividad> listaSisddeqCEstadoActividad = new ArrayList<SisddeqCEstadoActividad>();
	
	/** The lista sisddeq t origen asistencia. */
	private List<SisddeqTOrigenAsistencia> listaSisddeqTOrigenAsistencia = new ArrayList<SisddeqTOrigenAsistencia>();
	
	private SisddeqTOrigenAsistencia origenAsistenciaSelect = new SisddeqTOrigenAsistencia();
	
	private Map<String,String> mapaOrigenes = new HashMap<String, String>();  
	
	private List<SisddeqCProposito> listaSisddeqCProposito = new ArrayList<SisddeqCProposito>(); 
	 
	private SisddeqCProposito sisddeqCPropositoSelect = new SisddeqCProposito();
	
	private Map<String,String> mapaProposito = new HashMap<String, String>();  
	
	private List<SisddeqCTema> listaSisddeqCTema =	 new ArrayList<SisddeqCTema>(); 
	 
	private SisddeqCTema SisddeqCTemaSelect = new SisddeqCTema();
	
	private Map<String,String> mapaTema = new HashMap<String, String>();  
	
	private List<SisddeqCSector> listaSisddeqCSector = new ArrayList<SisddeqCSector>(); 
	 
	private SisddeqCSector SisddeqCSectorSelect = new SisddeqCSector();
	
	private Map<String,String> mapaSector= new HashMap<String, String>();  

	private List<SisddeqCPoblacion> listaSisddeqCPoblacion = new ArrayList<SisddeqCPoblacion>(); 
	 
	private SisddeqCPoblacion sisddeqCPoblacionSelect = new SisddeqCPoblacion();
	
	private Map<String,String> mapaPoblacion= new HashMap<String, String>();  

	private List<SisddeqCProyecto> listaSisddeqCProyecto = new ArrayList<SisddeqCProyecto>(); 
	
	private SisddeqCPoblacion sisddeqCProyectoSelect = new SisddeqCPoblacion();
	
	private Map<String,String> mapaProyecto= new HashMap<String, String>(); 
	
	private SisddeqCEstadoActividad sisddeqCEstadoActividadSelect = new SisddeqCEstadoActividad();
	
	private Map<String,String> mapaActividad= new HashMap<String, String>(); 
	

	private String estado="--Selecciona Estados--";
	
	private SelectItem selectItemEstado = new SelectItem();

	
	private int idEstado = 0;
	
	private String municipio=""; 
	
	private int idMunicipio = 0;
	
	private String localidad=""; 
	
	private Map<String,String> mapaEstados = new HashMap<String, String>();  
	
	private Map<String,String> mapaMunicipios= new HashMap<String, String>();
	
	private Map<String,String> mapaLocalidades= new HashMap<String, String>();
	
	private EstadosSisddeqService estadosSisddeqService = new EstadosSisddeqServiceImpl();
	
	private MunicipioSisddeqService municipioSisddeqService = new MunicipioSisddeqServiceImpl();
	
	private LocalidadesSisddeqService localidadesSisddeqService = new LocalidadesSisddeqServiceImpl();
	
	private  List<Estado> listaEstados= new ArrayList<Estado>();
	
	private  List<Municipio> listaMunicipios = new ArrayList<Municipio>();
	
	private  List<Localidade> listaLocalidades = new ArrayList<Localidade>();
	
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init() {
		try {
			//Carga de actividades en un pickList
			
			listaSisddeqCEstadoActividad.addAll(estadoActividadSisddeqService.consultaActividad());
			for(SisddeqCEstadoActividad actividadSingular:listaSisddeqCEstadoActividad){
				actividadesSource.add(actividadSingular.getNombre());
			}
			actividadesDualModel = new DualListModel<String>(actividadesSource, actividadesTarget);
			
			
			
			listaSisddeqCTema.addAll(temaSisddeqService.consultaTema());
			for(SisddeqCTema temaSingular:listaSisddeqCTema){
				listaTemaSource.add(temaSingular.getNombre());
			}
			
			listaTema = new DualListModel<String> (listaTemaSource, listaTemaTarget);
			
			//Combo origen asistencia
			listaSisddeqTOrigenAsistencia.addAll(origenAsistenciaSisddeqService.consultaOrigenAsistencia());
			
			for(SisddeqTOrigenAsistencia sisddeqTOrigenAsistencia:listaSisddeqTOrigenAsistencia){
				mapaOrigenes.put(
						sisddeqTOrigenAsistencia.getNombre(),String.valueOf(sisddeqTOrigenAsistencia.getIdOAsistencia()));
			}
			
			//Combo proposito
			listaSisddeqCProposito.addAll(propositoSisddeqService.consultaProposito());
			for(SisddeqCProposito sisddeqCProposito:listaSisddeqCProposito){
				mapaProposito.put(
						sisddeqCProposito.getNombre(),String.valueOf(sisddeqCProposito.getIdProposito()));
			}
			
			
			for(SisddeqCEstadoActividad aisddeqCEstadoActividad :listaSisddeqCEstadoActividad){
				mapaActividad.put(
						aisddeqCEstadoActividad .getNombre(),String.valueOf(aisddeqCEstadoActividad .getIdEstado()));
			}
			
			listaSisddeqCTema.addAll(temaSisddeqService.consultaTema());
			for(SisddeqCTema sisddeqCTema:listaSisddeqCTema){
				mapaTema.put(
						sisddeqCTema.getNombre(),String.valueOf(sisddeqCTema.getIdTema()));
			}
			
					
			listaSisddeqCSector.addAll(sectorSisddeqService.consultaSector());
			for(SisddeqCSector sisddeqCSector:listaSisddeqCSector){
				mapaSector.put(
						sisddeqCSector.getNombre(),String.valueOf(sisddeqCSector.getIdSector()));
			}
			
			listaSisddeqCPoblacion.addAll(poblacionSisddeqService.consultaOrganizacion());
			for(SisddeqCPoblacion sisddeqCPoblacion:listaSisddeqCPoblacion){
				mapaPoblacion.put(
						sisddeqCPoblacion.getNombre(),String.valueOf(sisddeqCPoblacion.getIdsisddeqCPoblacion()));
			}
			
			listaSisddeqCProyecto.addAll(proyectosSisddeqService.consultaProyecto());
			for(SisddeqCProyecto sisddeqCProyecto:listaSisddeqCProyecto){
				mapaProyecto.put(
						sisddeqCProyecto.getNombre(),String.valueOf(sisddeqCProyecto.getIdProyecto()));
			}
			
			listaEstados.addAll(estadosSisddeqService.consultaEstados());
			for(Estado estadoInd : listaEstados){
				System.out.println("ESTADOS::" + estadoInd.getId());
				mapaEstados.put(estadoInd.getNombre(), String.valueOf(estadoInd.getId()));
			}
			
					
		} catch (Exception e) {
			System.out.println("ERROR MB::" + e);
		}
	}
	
	public void onEstadoChange() {

		//Este valor de estados viene del value de p:selectOneMenu, lo que necesitamos es este valor para poder hacer la busqueda por municipio para
		//El siguiente combo. Una vez que tenemos el ID vamos a hacer la busqueda.
		mapaMunicipios = new HashMap<String, String>();
		System.out.println("Cambio de estado::"+estado );
		if (estado != null && !estado.equals("")) {
			listaMunicipios = municipioSisddeqService
					.consultaMunicipioPorEstado(Integer.valueOf(estado));
			for (Municipio municipioIndividual : listaMunicipios) {
				System.out.println("Municipios::"+municipioIndividual.getNombre() );

				mapaMunicipios.put(municipioIndividual.getNombre(),
						String.valueOf(municipioIndividual.getId()));
			}
		} else {
			mapaMunicipios = new HashMap<String, String>();
		}
	}
	
	public void onMunicipioChange() {

		mapaLocalidades = new HashMap<String, String>();
		System.out.println("Cambio de Localidad::"+municipio );
		if (municipio!= null && !municipio.equals("")) {
			listaLocalidades= localidadesSisddeqService.consultaLocalidadPorMunicipio(Integer.valueOf(municipio));
			for (Localidade localidadIndividual : listaLocalidades) {
				System.out.println("Localidades::"+localidadIndividual.getNombre() );

				mapaLocalidades.put(localidadIndividual.getNombre(),
						String.valueOf(localidadIndividual.getId()));
			}
		} else {
			mapaLocalidades = new HashMap<String, String>();
		}
	}

	public List<SisddeqCEstadoActividad> getListaSisddeqCEstadoActividad() {
		return listaSisddeqCEstadoActividad;
	}

	public void setListaSisddeqCEstadoActividad(
			List<SisddeqCEstadoActividad> listaSisddeqCEstadoActividad) {
		this.listaSisddeqCEstadoActividad = listaSisddeqCEstadoActividad;
	}

	public List<String> getActividadesSource() {
		return actividadesSource;
	}

	public void setActividadesSource(List<String> actividadesSource) {
		this.actividadesSource = actividadesSource;
	}

	public List<String> getActividadesTarget() {
		return actividadesTarget;
	}

	public void setActividadesTarget(List<String> actividadesTarget) {
		this.actividadesTarget = actividadesTarget;
	}

	public DualListModel<String> getActividadesDualModel() {
		return actividadesDualModel;
	}

	public void setActividadesDualModel(DualListModel<String> actividadesDualModel) {
		this.actividadesDualModel = actividadesDualModel;
	}

	public Date getFechaBitacora() {
		return fechaBitacora;
	}

	public void setFechaBitacora(Date fechaBitacora) {
		this.fechaBitacora = fechaBitacora;
	}

	public List<SisddeqTOrigenAsistencia> getListaSisddeqTOrigenAsistencia() {
		return listaSisddeqTOrigenAsistencia;
	}

	public void setListaSisddeqTOrigenAsistencia(
			List<SisddeqTOrigenAsistencia> listaSisddeqTOrigenAsistencia) {
		this.listaSisddeqTOrigenAsistencia = listaSisddeqTOrigenAsistencia;
	}

	public SisddeqTOrigenAsistencia getOrigenAsistenciaSelect() {
		return origenAsistenciaSelect;
	}

	public void setOrigenAsistenciaSelect(
			SisddeqTOrigenAsistencia origenAsistenciaSelect) {
		this.origenAsistenciaSelect = origenAsistenciaSelect;
	}

	public Map<String, String> getMapaOrigenes() {
		return mapaOrigenes;
	}

	public void setMapaOrigenes(Map<String, String> mapaOrigenes) {
		this.mapaOrigenes = mapaOrigenes;
	}

	public List<SisddeqCProposito> getListaSisddeqCProposito() {
		return listaSisddeqCProposito;
	}

	public void setListaSisddeqCProposito(
			List<SisddeqCProposito> listaSisddeqCProposito) {
		this.listaSisddeqCProposito = listaSisddeqCProposito;
	}

	public Map<String, String> getMapaProposito() {
		return mapaProposito;
	}

	public void setMapaProposito(Map<String, String> mapaProposito) {
		this.mapaProposito = mapaProposito;
	}

	public SisddeqCProposito getSisddeqCPropositoSelect() {
		return sisddeqCPropositoSelect;
	}

	public void setSisddeqCPropositoSelect(SisddeqCProposito sisddeqCPropositoSelect) {
		this.sisddeqCPropositoSelect = sisddeqCPropositoSelect;
	}

	public SisddeqCTema getSisddeqCTemaSelect() {
		return SisddeqCTemaSelect;
	}

	public void setSisddeqCTemaSelect(SisddeqCTema sisddeqCTemaSelect) {
		SisddeqCTemaSelect = sisddeqCTemaSelect;
	}

	public Map<String, String> getMapaTema() {
		return mapaTema;
	}

	public void setMapaTema(Map<String, String> mapaTema) {
		this.mapaTema = mapaTema;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(int asistentes) {
		this.asistentes = asistentes;
	}

	public boolean isAccionFechaConmemorativa() {
		return accionFechaConmemorativa;
	}

	public void setAccionFechaConmemorativa(boolean accionFechaConmemorativa) {
		this.accionFechaConmemorativa = accionFechaConmemorativa;
	}

	public String getAccionFechaConmemorativas() {
		return accionFechaConmemorativas;
	}

	public void setAccionFechaConmemorativas(String accionFechaConmemorativas) {
		this.accionFechaConmemorativas = accionFechaConmemorativas;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getInstituciones() {
		return instituciones;
	}

	public void setInstituciones(String instituciones) {
		this.instituciones = instituciones;
	}

	public SectorSisddeqService getSectorSisddeqService() {
		return sectorSisddeqService;
	}

	public void setSectorSisddeqService(SectorSisddeqService sectorSisddeqService) {
		this.sectorSisddeqService = sectorSisddeqService;
	}

	public List<SisddeqCSector> getListaSisddeqCSector() {
		return listaSisddeqCSector;
	}

	public void setListaSisddeqCSector(List<SisddeqCSector> listaSisddeqCSector) {
		this.listaSisddeqCSector = listaSisddeqCSector;
	}

	public SisddeqCSector getSisddeqCSectorSelect() {
		return SisddeqCSectorSelect;
	}

	public void setSisddeqCSectorSelect(SisddeqCSector sisddeqCSectorSelect) {
		SisddeqCSectorSelect = sisddeqCSectorSelect;
	}

	public Map<String, String> getMapaSector() {
		return mapaSector;
	}

	public void setMapaSector(Map<String, String> mapaSector) {
		this.mapaSector = mapaSector;
	}

	public boolean isPresenciaMedios() {
		return presenciaMedios;
	}

	public void setPresenciaMedios(boolean presenciaMedios) {
		this.presenciaMedios = presenciaMedios;
	}

	public String getAccionPrescenciaMedios() {
		return accionPrescenciaMedios;
	}

	public void setAccionPrescenciaMedios(String accionPrescenciaMedios) {
		this.accionPrescenciaMedios = accionPrescenciaMedios;
	}

	public List<SisddeqCPoblacion> getListaSisddeqCPoblacion() {
		return listaSisddeqCPoblacion;
	}

	public void setListaSisddeqCPoblacion(
			List<SisddeqCPoblacion> listaSisddeqCPoblacion) {
		this.listaSisddeqCPoblacion = listaSisddeqCPoblacion;
	}

	public SisddeqCPoblacion getSisddeqCPoblacionSelect() {
		return sisddeqCPoblacionSelect;
	}

	public void setSisddeqCPoblacionSelect(SisddeqCPoblacion sisddeqCPoblacionSelect) {
		sisddeqCPoblacionSelect = sisddeqCPoblacionSelect;
	}

	public Map<String, String> getMapaPoblacion() {
		return mapaPoblacion;
	}

	public void setMapaPoblacion(Map<String, String> mapaPoblacion) {
		this.mapaPoblacion = mapaPoblacion;
	}

	public ProyectosSisddeqService getProyectosSisddeqService() {
		return proyectosSisddeqService;
	}

	public void setProyectosSisddeqService(
			ProyectosSisddeqService proyectosSisddeqService) {
		this.proyectosSisddeqService = proyectosSisddeqService;
	}

	public List<SisddeqCProyecto> getListaSisddeqCProyecto() {
		return listaSisddeqCProyecto;
	}

	public void setListaSisddeqCProyecto(
			List<SisddeqCProyecto> listaSisddeqCProyecto) {
		this.listaSisddeqCProyecto = listaSisddeqCProyecto;
	}

	public SisddeqCPoblacion getSisddeqCProyectoSelect() {
		return sisddeqCProyectoSelect;
	}

	public void setSisddeqCProyectoSelect(SisddeqCPoblacion sisddeqCProyectoSelect) {
		this.sisddeqCProyectoSelect = sisddeqCProyectoSelect;
	}

	public Map<String, String> getMapaProyecto() {
		return mapaProyecto;
	}

	public void setMapaProyecto(Map<String, String> mapaProyecto) {
		this.mapaProyecto = mapaProyecto;
	}

	public EstadoActividadSisddeqService getEstadoActividadSisddeqService() {
		return estadoActividadSisddeqService;
	}

	public void setEstadoActividadSisddeqService(
			EstadoActividadSisddeqService estadoActividadSisddeqService) {
		this.estadoActividadSisddeqService = estadoActividadSisddeqService;
	}

	public SisddeqCEstadoActividad getSisddeqCEstadoActividadSelect() {
		return sisddeqCEstadoActividadSelect;
	}

	public void setSisddeqCEstadoActividadSelect(
			SisddeqCEstadoActividad sisddeqCEstadoActividadSelect) {
		this.sisddeqCEstadoActividadSelect = sisddeqCEstadoActividadSelect;
	}

	public Map<String, String> getMapaActividad() {
		return mapaActividad;
	}

	public void setMapaActividad(Map<String, String> mapaActividad) {
		this.mapaActividad = mapaActividad;
	}

	
	public List<String> getTemaTarget() {
		return temaTarget;
	}

	public void setTemaTarget(List<String> temaTarget) {
		this.temaTarget = temaTarget;
	}

	public DualListModel<String> getListaTema() {
		return listaTema;
	}

	public void setListaTema(DualListModel<String> listaTema) {
		this.listaTema = listaTema;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Map<String, String> getMapaEstados() {
		return mapaEstados;
	}

	public void setMapaEstados(Map<String, String> mapaEstados) {
		this.mapaEstados = mapaEstados;
	}

	public Map<String, String> getMapaMunicipios() {
		return mapaMunicipios;
	}

	public void setMapaMunicipios(Map<String, String> mapaMunicipios) {
		this.mapaMunicipios = mapaMunicipios;
	}

	public Map<String, String> getMapaLocalidades() {
		return mapaLocalidades;
	}

	public void setMapaLocalidades(Map<String, String> mapaLocalidades) {
		this.mapaLocalidades = mapaLocalidades;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public List<Municipio> getListaMunicipios() {
		return listaMunicipios;
	}

	public void setListaMunicipios(List<Municipio> listaMunicipios) {
		this.listaMunicipios = listaMunicipios;
	}

	public List<Localidade> getListaLocalidades() {
		return listaLocalidades;
	}

	public void setListaLocalidades(List<Localidade> listaLocalidades) {
		this.listaLocalidades = listaLocalidades;
	}


	public void setSelectItemEstado(SelectItem selectItemEstado) {
		this.selectItemEstado = selectItemEstado;
	}

		
	
	
}
