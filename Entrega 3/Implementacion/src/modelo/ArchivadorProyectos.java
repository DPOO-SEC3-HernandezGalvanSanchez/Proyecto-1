package modelo;

import java.util.HashMap;

public class ArchivadorProyectos
{
	// ATRIBUTOS
	private HashMap<String, Proyecto> catalogoProyectos;
	
	
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
	}
}
