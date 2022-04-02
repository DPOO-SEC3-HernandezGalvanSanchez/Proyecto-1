package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class CoordinadorProyecto
{

	//ATRIBUTOS
	private Proyecto proyectoEnUso;
	private ArchivadorProyectos archivoProyectos = new ArchivadorProyectos();
	
	
	//METODOS DEL COORDINADOR
	public void crearProyecto(String nombreProyecto, String descripcion,
							  ArrayList<String> tiposActividades, Participante autor)
	{	
		/*
		 * Se asigna como 'proyectoEnUso' un proyecto nuevo y lo guarda en el archivo
		 */
		
		proyectoEnUso = new GestorActividades(nombreProyecto, descripcion, tiposActividades, autor);
		archivoProyectos.guardarInfoProyecto(proyectoEnUso);
	}
	
	
	public void seleccionarProyecto(String nombreProyecto)
	{
		/*
		 * Se selecciona como 'proyectoEnUso' al proyecto llamado 'nombreProyecto'
		 */
		
		proyectoEnUso = archivoProyectos.getProyecto(nombreProyecto);
	}
	
	
	//METODOS DEL PROYECTO
	public String getNombreProyecto()
	{
		return proyectoEnUso.getNombre();
	}
	
	
	public String getDescripcionProyecto()
	{
		return proyectoEnUso.getDescripcion();
	}
	
	
	public ArrayList<String> getTiposActividades()
	{
		return proyectoEnUso.getTiposActividades();
	}
	
	
	public HashMap<String, Participante> getParticipantes()
	{
		return proyectoEnUso.getParticipantes();
	}
	
	
	public void agregarParticipante(Participante nuevoParticipante)
	{
		proyectoEnUso.agregarParticipante(nuevoParticipante);
		archivoProyectos.guardarInfoProyecto(proyectoEnUso);
	}
	
	
	public void registrarActividad(String tipoActividad, String titulo, String descripcion,
								   String horaInicio, String horaFin, Participante participante)
	{
		Actividad nuevaActividad = new Actividad(tipoActividad, titulo, descripcion,
												 horaInicio, horaFin, participante);
		
		proyectoEnUso.agregarActividad(nuevaActividad);
	}


}
