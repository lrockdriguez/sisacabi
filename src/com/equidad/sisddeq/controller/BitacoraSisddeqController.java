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

import org.primefaces.model.DualListModel;

import com.equidad.sisddeq.entidades.SisddeqCEstadoActividad;
import com.equidad.sisddeq.entidades.SisddeqCPoblacion;
import com.equidad.sisddeq.entidades.SisddeqCProposito;
import com.equidad.sisddeq.entidades.SisddeqCProyecto;
import com.equidad.sisddeq.entidades.SisddeqCSector;
import com.equidad.sisddeq.entidades.SisddeqCTema;
import com.equidad.sisddeq.entidades.SisddeqTOrigenAsistencia;
import com.equidad.sisddeq.service.BitacoraSisddeqService;
import com.equidad.sisddeq.service.EstadoActividadSisddeqService;
import com.equidad.sisddeq.service.OrigenAsistenciaSisddeqService;
import com.equidad.sisddeq.service.PoblacionSisddeqService;
import com.equidad.sisddeq.service.PropositoSisddeqService;
import com.equidad.sisddeq.service.ProyectosSisddeqService;
import com.equidad.sisddeq.service.SectorSisddeqService;
import com.equidad.sisddeq.service.TemaSisddeqService;
import com.equidad.sisddeq.service.impl.BitacoraSisddeqServiceImpl;
import com.equidad.sisddeq.service.impl.EstadoActividadSisddeqServiceImpl;
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
	
	/** The actividades target. */
	private List<String> actividadesTarget = new ArrayList<String>();
	
	/** The actividades dual model. */
	private DualListModel<String> actividadesDualModel = new DualListModel<String>();
	
	/** The lista sisddeq c estado actividad. */
	private  List<SisddeqCEstadoActividad> listaSisddeqCEstadoActividad = new ArrayList<SisddeqCEstadoActividad>();
	
	/** The lista sisddeq t origen asistencia. */
	private List<SisddeqTOrigenAsistencia> listaSisddeqTOrigenAsistencia = new ArrayList<SisddeqTOrigenAsistencia>();
	
	private SisddeqTOrigenAsistencia origenAsistenciaSelect = new SisddeqTOrigenAsistencia();
	
	private Map<String,String> mapaOrigenes = new HashMap<String, String>();  
	
	private List<SisddeqCProposito> listaSisddeqCProposito = new ArrayList<SisddeqCProposito>(); 
	 
	private SisddeqCProposito sisddeqCPropositoSelect = new SisddeqCProposito();
	
	private Map<String,String> mapaProposito = new HashMap<String, String>();  
	
	private List<SisddeqCTema> listaSisddeqCTema = new ArrayList<SisddeqCTema>(); 
	 
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
			
			
		} catch (Exception e) {
			System.out.println("ERROR MB::" + e);
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

		
	
	
}
