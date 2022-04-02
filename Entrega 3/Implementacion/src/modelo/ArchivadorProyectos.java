package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class ArchivadorProyectos
{
	// ATRIBUTOS
	private HashMap<String, Proyecto> catalogoProyectos = new HashMap<String, Proyecto>();
	
	
	// CONSTRUCTOR
	public ArchivadorProyectos()
	{
		cargarProyectos();
	}
	
	
	// METODOS
	public Proyecto getProyecto(String nombreProyecto)
	{	
		/*
		 * Retorna un Proyecto a partir de su nombre
		 */
		
		return catalogoProyectos.get(nombreProyecto);
	}
	
	
	public void guardarInfoProyecto(Proyecto proyecto)
	{
		/*
		 * Guarda o actualiza la informacion de un proyecto
		 */
		
		String nombreProyecto = proyecto.getNombre();
		catalogoProyectos.put(nombreProyecto, proyecto);
	}
	
	
	public void cargarProyectos()
	{
		/*
		 * Cargar los proyectos registrados en el sistema
		 * 
		 * HASTA EL MOMENTO GENERA UN PROTOTIPO
		 */
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add("tipo1");
		tipos.add("tipo2");
		
		Participante estudiante1 = new Participante("loginE1", "nombreE1");
		Participante estudiante2 = new Participante("loginE2", "nombreE2");
		
		Proyecto proyecto1 = new GestorActividades("P1", "descripcionP1", tipos, estudiante1);
		proyecto1.agregarParticipante(estudiante2);
		catalogoProyectos.put("P1", proyecto1);
		
		Proyecto proyecto2 = new GestorActividades("P2", "descripcionP2", tipos, estudiante2);
		catalogoProyectos.put("P2", proyecto2);
	}
}
