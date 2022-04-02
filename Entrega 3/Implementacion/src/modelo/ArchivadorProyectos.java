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
		
		//Tipos de actividades
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add("tipo1");
		tipos.add("tipo2");
		
		
		//Usuarios
		Participante estudiante1 = new Participante("loginE1", "nombreE1");
		Participante estudiante2 = new Participante("loginE2", "nombreE2");
		
		
		//Proyectos
		Proyecto proyecto1 = new GestorActividades("P1", "descripcionP1", tipos, estudiante1);
		proyecto1.agregarParticipante(estudiante2);
		catalogoProyectos.put("P1", proyecto1);
		
		Proyecto proyecto2 = new GestorActividades("P2", "descripcionP2", tipos, estudiante2);
		catalogoProyectos.put("P2", proyecto2);
		
		
		//Actividades
		Actividad r1p1 = new Actividad("tipo1", "A1P1", "descripcionA1P1A",
									   "01/01/2022", "12:30", "13:30",
									   estudiante1);
		Actividad r2p1 = new Actividad("tipo1", "A1P1", "descripcionA1P1B",
				   					   "05/01/2022", "15:30", "18:00",
				   					   estudiante2);
		Actividad r3p1 = new Actividad("tipo1", "A1P1", "descripcionA1P1C",
				   					   "15/02/2022", "08:00", "08:30",
				   					   estudiante1);
		Actividad r4p1 = new Actividad("tipo2", "A2P1", "descripcionA2P1",
				   					   "01/01/2022", "20:00", "21:00",
				   					   estudiante2);
		proyecto1.registrarActividad(r1p1);
		proyecto1.registrarActividad(r2p1);
		proyecto1.registrarActividad(r3p1);
		proyecto1.registrarActividad(r4p1);
		
		
		Actividad r1p2 = new Actividad("tipo1", "A1P2", "descripcionA1P2",
				   					   "01/04/2022", "16:30", "17:30",
				   					   estudiante2);
		proyecto2.registrarActividad(r1p2);
	}


}
