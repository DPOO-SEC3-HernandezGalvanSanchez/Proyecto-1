package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class ArchivadorProyectos
{
	// ATRIBUTOS
	private HashMap<String, Proyecto> catalogoProyectos = new HashMap<String, Proyecto>();
	private HashMap<String,ArrayList<String>> usuariosProyectos = new HashMap<String,ArrayList<String>>();
	
	// CONSTRUCTOR
	public ArchivadorProyectos()
	{
		try
		{
			cargarProyectos();
		}
		catch (FileNotFoundException e)
		{
			System.err.println("ERROR: el archivo indicado no se encontro.");
		}
		catch (IOException e)
		{
			System.err.println("ERROR: hubo un problema leyendo el archivo.");
			System.err.println(e.getMessage());
		}
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
	

	public Proyecto cargarUnProyecto(String[] partes)
	{
		String titulo = partes[1];
		String descripcion = partes[2];
		ArrayList<String> tipos = new ArrayList<String>(Arrays.asList(partes[3].split(";")));
		String[] datosCreador = partes[4].split(";");
		Participante creador = new Participante(datosCreador[0], datosCreador[1]);
		registrarParticipante(datosCreador,titulo);
		
		Proyecto proyectoActual = new GestorActividades(titulo, descripcion, tipos, creador);
		
		if (partes.length > 5)
		{
			for (int i=5; i<partes.length; i++)
			{
				String[] datosParticipante = partes[i].split(";");
				Participante participante = new Participante(datosParticipante[0], datosParticipante[1]);
				registrarParticipante(datosParticipante, titulo);
				proyectoActual.agregarParticipante(participante);
			}
		}
		catalogoProyectos.put(titulo, proyectoActual);
		
		return proyectoActual;
	}
	
	
	public void cargarProyectos() throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("./data/proyectos.csv", StandardCharsets.UTF_8));
		String linea = br.readLine();
		String[] partes1 = linea.split(",");
		Proyecto proyectoActual = cargarUnProyecto(partes1);
		linea = br.readLine();
		
		while (linea != null)
		{
			String[] partes = linea.split(",");
			
			if (partes[0].equals("PROY"))
			{
				proyectoActual = cargarUnProyecto(partes);
			}
			
			else if (partes[0].equals("ACT"))
			{
				String tipoActividad = partes[1];
				String titulo = partes[2];
				String descripcion = partes[3];
				String fecha = partes[4];
				String horaInicio = partes[5];
				String horaFin = partes[6];
				String[] datosAutor = partes[7].split(";");
				Participante autor = new Participante(datosAutor[0], datosAutor[1]);
				
				Actividad nuevaActividad = new Actividad(tipoActividad, titulo, descripcion,
						 								 fecha, horaInicio, horaFin, autor);
				
				proyectoActual.registrarActividad(nuevaActividad);
				
			}
			linea = br.readLine();
		}
		br.close();
		generarAuxiliar();
	}

	
	/*
	 * public void cargarProyectos()
	{		
		//Tipos de actividades
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add("Documentacion");
		tipos.add("Implementacion");
		tipos.add("Pruebas");
		
		
		//Usuarios
		Participante estudiante1 = new Participante("loginE1", "nombreE1");
		Participante estudiante2 = new Participante("loginE2", "nombreE2");
		
		
		//Proyectos
		Proyecto proyecto1 = new GestorActividades("ProyectoPrueba1", "descripcionP1", tipos, estudiante1);
		proyecto1.agregarParticipante(estudiante2);
		catalogoProyectos.put("P1", proyecto1);
		
		Proyecto proyecto2 = new GestorActividades("ProyectoPrueba2", "descripcionP2", tipos, estudiante2);
		catalogoProyectos.put("P2", proyecto2);
		
		
		//Actividades
		Actividad r1p1 = new Actividad("Documentacion", "A1P1", "descripcionA1P1A",
									   "01/01/2022", "12:30", "13:30",
									   estudiante1);
		Actividad r2p1 = new Actividad("Implementacion", "A1P1", "descripcionA1P1B",
				   					   "05/01/2022", "15:30", "18:00",
				   					   estudiante2);
		Actividad r3p1 = new Actividad("Implementacion", "A1P1", "descripcionA1P1C",
				   					   "15/02/2022", "08:00", "08:30",
				   					   estudiante1);
		Actividad r4p1 = new Actividad("Pruebas", "A2P1", "descripcionA2P1",
				   					   "01/04/2022", "20:00", "21:00",
				   					   estudiante2);
		proyecto1.registrarActividad(r1p1);
		proyecto1.registrarActividad(r2p1);
		proyecto1.registrarActividad(r3p1);
		proyecto1.registrarActividad(r4p1);
		
		
		Actividad r1p2 = new Actividad("Documentacion", "A1P2", "descripcionA1P2",
				   					   "01/03/2022", "16:30", "17:30",
				   					   estudiante2);
		proyecto2.registrarActividad(r1p2);
	}
	 */
	
	private void registrarParticipante(String[] datosParticipante, String tituloProyecto)
	{
		String login = datosParticipante[0];
		String nombre = datosParticipante[1];
		
		if (this.usuariosProyectos.containsKey(login))
		{
			usuariosProyectos.get(login).add(tituloProyecto);
		}
		else
		{
			ArrayList<String> newList = new ArrayList<String>();
			newList.add(nombre);
			newList.add(tituloProyecto);
			usuariosProyectos.put(login, newList);
		}
	}
	
	
	private void generarAuxiliar()
	{
		try
		{
		BufferedWriter fw = new BufferedWriter(new FileWriter("data/auxiliar.txt"));
		Iterator<String> i = usuariosProyectos.keySet().iterator();
		
		while(i.hasNext())
		{
			String login = i.next();
			ArrayList<String> datos = usuariosProyectos.get(login);
			String nombre = datos.get(0);
			String linea = (login + ";" +  nombre);
			for (int j= 1; j<datos.size(); j++)
			{
				linea = linea + ";" + datos.get(j);
			}
			
			fw.write(linea);
			fw.newLine();
		}
		fw.close();
		
		
		}
		catch (IOException e)
		{
			System.err.println("ERROR: hubo un problema generando archivo auxiliar.");
		}
				
	}
	
}
