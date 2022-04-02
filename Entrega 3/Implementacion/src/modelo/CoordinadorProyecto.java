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
	
	
	public HashMap<String, ArrayList<Actividad>> getActividades()
	{
		return proyectoEnUso.getActividades();
	}
	
	
	public void agregarParticipante(Participante nuevoParticipante)
	{
		proyectoEnUso.agregarParticipante(nuevoParticipante);
		archivoProyectos.guardarInfoProyecto(proyectoEnUso);
	}
	
	
	// METODOS DE LAS ACTIVIDADES
	public void registrarActividad(String tipoActividad, String titulo, String descripcion, String fecha,
								   String horaInicio, String horaFin, Participante participante)
	{
		Actividad nuevaActividad = new Actividad(tipoActividad, titulo, descripcion, fecha,
												 horaInicio, horaFin, participante);
		
		proyectoEnUso.registrarActividad(nuevaActividad);
		archivoProyectos.guardarInfoProyecto(proyectoEnUso);
	}

	
	public void modificarFechaActividad(String titulo, int index,
							   			String nuevaFecha)
	{
		proyectoEnUso.modificarFechaActividad(titulo, index,
											  nuevaFecha);
		archivoProyectos.guardarInfoProyecto(proyectoEnUso);
	}
	
	
	public void modificarHoraInicio(String titulo, int index,
   									String nuevaHoraInicio)
	{
		proyectoEnUso.modificarHoraInicio(titulo, index,
										  nuevaHoraInicio);
		archivoProyectos.guardarInfoProyecto(proyectoEnUso);
	}
	
	
	public void modificarHoraFin(String titulo, int index,
								 String nuevaHoraFin)
	{
		proyectoEnUso.modificarHoraFin(titulo, index,
				  					   nuevaHoraFin);
		archivoProyectos.guardarInfoProyecto(proyectoEnUso);
	}

	
}
