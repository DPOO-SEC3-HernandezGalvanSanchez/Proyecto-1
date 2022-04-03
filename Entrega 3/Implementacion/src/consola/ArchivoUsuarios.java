package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Participante;


public class ArchivoUsuarios
{
	// ATRIBUTOS
	private HashMap<String, Participante> infoUsuarios = new HashMap<String, Participante>();
	private HashMap<String, ArrayList<String>> proyectosUsuarios = new HashMap<String, ArrayList<String>>();
	
	
	// CONSTRUCTOR
	public ArchivoUsuarios() 
	{
		try {
			cargarUsuarios();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// METODOS
	public Participante getParticipante(String loginUsuario)
	{				
		return infoUsuarios.get(loginUsuario);
	}
	
	
	public ArrayList<String> getProyectosUsuario(String loginUsuario)
	{	
		/*
		 * Extraer los proyectos de determinado usuario
		 * 
		 * Nota: no se retorna directamente 'proyectos' para mantener el encapsulamiento
		 */
		
		ArrayList<String> proyectosDelUsuario = null;
		ArrayList<String> proyectos = proyectosUsuarios.get(loginUsuario);
		
		if (proyectos != null)
			proyectosDelUsuario = new ArrayList<String>(proyectos);
		
		return proyectosDelUsuario;
	}
	
	
	public void guardarProyecto(String loginUsuario, String nombreProyecto)
	{
		/*
		 * Guardar un nuevo proyecto llamado 'nombreProyecto' para el
		 * usuario 'loginUsuario'
		 */
		
		ArrayList<String> proyectosDelUsuario = getProyectosUsuario(loginUsuario);
		
		if (proyectosDelUsuario != null)
		{
			proyectosDelUsuario.add(nombreProyecto);
			proyectosUsuarios.put(loginUsuario, proyectosDelUsuario);
		}
	
		else
		{
			ArrayList<String> proyectosDelNuevoUsuario = new ArrayList<String>();
			proyectosDelNuevoUsuario.add(nombreProyecto);
			proyectosUsuarios.put(loginUsuario, proyectosDelNuevoUsuario);
		}	
	}
	
	
	private void cargarUsuarios() throws FileNotFoundException, IOException
	{
		/*
		 * Cargar los usuarios del sistema y sus proyectos
		 * 
		 * HASTA EL MOMENTO GENERA UN PROTOTIPO
		 */
		
		BufferedReader br = new BufferedReader(new FileReader("./data/auxiliar.txt", StandardCharsets.UTF_8));
		String linea = br.readLine();
		while (linea != null)
		{
			String[] datos = linea.split(";");
			String login = datos[0];
			String nombre = datos[1];
			
			Participante pn = new Participante(login,nombre);
			ArrayList<String> proyectos = new ArrayList<String>();
			int tamano = datos.length;
			
			infoUsuarios.put(login, pn);
			
			for (int i = 2; i<tamano;i++)
			{
				proyectos.add(datos[i]);
			}
			proyectosUsuarios.put(login, proyectos);
			linea = br.readLine();
		}
		
		br.close();
		
 
		/*Agregar estudiante 1
		Participante e1 = new Participante("loginE1", "nombreE1");
		infoUsuarios.put("loginE1", e1);
		
		ArrayList<String> proyectosEstudiante1 = new ArrayList<String>();
		proyectosEstudiante1.add("ProyectoPrueba1");
		proyectosUsuarios.put("loginE1", proyectosEstudiante1);

		
		//Agregar estudiante 2
		Participante e2 = new Participante("loginE2", "nombreE2");
		infoUsuarios.put("loginE2", e2);
		
		ArrayList<String> proyectosEstudiante2 = new ArrayList<String>();
		proyectosEstudiante2.add("ProyectoPrueba1");
		proyectosEstudiante2.add("ProyectoPrueba2");
		proyectosUsuarios.put("loginE2", proyectosEstudiante2);*/
	}

	/*
	public static void main(String[] args)
	{
		ArchivoUsuarios archivo = new ArchivoUsuarios();
		System.out.println(archivo.getProyectosUsuario("estudiante4"));
	}
	 */
	
}
