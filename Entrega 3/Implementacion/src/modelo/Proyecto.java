package modelo;

import java.util.ArrayList;
import java.util.HashMap;


public class Proyecto
{
	// ATRIBUTOS
	private String nombreProyecto;
	private String descripcion;
	private ArrayList<String> tiposActividades;
	
	private HashMap<String, Participante> participantes = new HashMap<String, Participante>();
	private ArrayList<Actividad> actividades = new ArrayList<Actividad>();
	
	
	// CONSTRUCTOR
	public Proyecto(String nombreProyecto, String descripcion, ArrayList<String> tiposActividades,
					Participante autor)
	{
		this.nombreProyecto = nombreProyecto;
		this.descripcion = descripcion;
		this.tiposActividades = tiposActividades;
		
		agregarParticipante(autor);
	}
	
	
	// METODOS
	public String getNombre()
	{
		return nombreProyecto;
	}


	public String getDescripcion()
	{
		return descripcion;
	}


	public ArrayList<String> getTiposActividades()     //REVISAR ENCAPSULAMIENTO
	{
		return tiposActividades;
	}


	public HashMap<String, Participante> getParticipantes()  //REVISAR ENCAPSULAMIENTO
	{
		return participantes;
	}


	public ArrayList<Actividad> getActividades()       //REVISAR ENCAPSULAMIENTO
	{
		return actividades;
	}
	
	
	public void agregarParticipante(Participante nuevoParticipante)
	{
		String login = nuevoParticipante.getLogin();
		participantes.put(login, nuevoParticipante);
	}
	
	
}
