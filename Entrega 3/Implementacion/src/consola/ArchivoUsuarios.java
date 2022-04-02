package consola;

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
		cargarUsuarios();
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
	
	
	private void cargarUsuarios()
	{
		/*
		 * Cargar los usuarios del sistema y sus proyectos
		 * 
		 * HASTA EL MOMENTO GENERA UN PROTOTIPO
		 */
 
		//Agregar estudiante 1
		Participante e1 = new Participante("loginE1", "nombreE1");
		infoUsuarios.put("loginE1", e1);
		
		ArrayList<String> proyectosEstudiante1 = new ArrayList<String>();
		proyectosEstudiante1.add("P1");
		proyectosUsuarios.put("loginE1", proyectosEstudiante1);

		
		//Agregar estudiante 2
		Participante e2 = new Participante("loginE2", "nombreE2");
		infoUsuarios.put("loginE2", e2);
		
		ArrayList<String> proyectosEstudiante2 = new ArrayList<String>();
		proyectosEstudiante2.add("P1");
		proyectosEstudiante2.add("P2");
		proyectosUsuarios.put("loginE2", proyectosEstudiante2);
	}

	/*
	public static void main(String[] args)
	{
		ArchivoUsuarios archivo = new ArchivoUsuarios();
		System.out.println(archivo.getProyectosUsuario("estudiante4"));
	}
	 */
	
}
