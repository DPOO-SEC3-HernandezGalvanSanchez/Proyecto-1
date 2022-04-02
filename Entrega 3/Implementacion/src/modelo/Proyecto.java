package modelo;

import java.util.ArrayList;
import java.util.HashMap;


public abstract class Proyecto
{
	// ATRIBUTOS
	private String nombreProyecto;
	private String descripcion;
	private ArrayList<String> tiposActividades;
	
	private HashMap<String, Participante> participantes = new HashMap<String, Participante>();
	protected HashMap<String, ArrayList<Actividad>> actividades = new HashMap<String, ArrayList<Actividad>>();
	
	
	// CONSTRUCTOR
	public Proyecto(String nombreProyecto, String descripcion, ArrayList<String> tiposActividades,
					Participante autor)
	{
		this.nombreProyecto = nombreProyecto;
		this.descripcion = descripcion;
		this.tiposActividades = tiposActividades;
		
		agregarParticipante(autor);
	}
	
	
	// METODOS DEL PROYECTO
	public String getNombre()
	{
		return nombreProyecto;
	}


	public String getDescripcion()
	{
		return descripcion;
	}


	public ArrayList<String> getTiposActividades()
	{
		ArrayList<String> tiposCopia = new ArrayList<String>(tiposActividades);
		return tiposCopia;
	}


	public HashMap<String, Participante> getParticipantes()
	{
		HashMap<String, Participante> participantesCopia = new HashMap<String, Participante>(participantes);
		return participantesCopia;
	}


	public HashMap<String, ArrayList<Actividad>> getActividades() 
	{
		HashMap<String, ArrayList<Actividad>> actividadesCopia = new HashMap<String, ArrayList<Actividad>>(actividades);
		return actividadesCopia;
	}
	
	
	public void agregarParticipante(Participante nuevoParticipante)
	{
		String nombre = nuevoParticipante.getNombre();
		participantes.put(nombre, nuevoParticipante);
	}
	
	
	// METODOS PARA GESTIONAR ACTIVIDADES
	public abstract void agregarActividad(Actividad nuevaActividad);
	
}
