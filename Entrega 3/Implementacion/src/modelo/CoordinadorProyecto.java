package modelo;

import java.util.ArrayList;

public class CoordinadorProyecto
{

	//ATRIBUTOS
	private Proyecto proyectoEnUso;
	private ArchivadorProyectos archivoProyectos = new ArchivadorProyectos();
	
	
	//METODOS
	public void crearProyecto(String nombreProyecto, String descripcion,
							  ArrayList<String> tiposActividades, Participante autor)
	{	
		/*
		 * Se asigna como 'proyectoEnUso' un proyecto nuevo y lo guarda en el archivo
		 */
		
		proyectoEnUso = new Proyecto(nombreProyecto, descripcion, tiposActividades, autor);
		archivoProyectos.guardarInfoProyecto(proyectoEnUso);
	}
	
	
	public void seleccionarProyecto(String nombreProyecto)
	{
		/*
		 * Se selecciona como 'proyectoEnUso' al proyecto llamado 'nombreProyecto'
		 */
		
		proyectoEnUso = archivoProyectos.getProyecto(nombreProyecto);
	}
	
	
	public void agregarParticipante(Participante nuevoParticipante)
	{
		proyectoEnUso.agregarParticipante(nuevoParticipante);
		archivoProyectos.guardarInfoProyecto(proyectoEnUso);
	}
		
}
