package consola;

import java.util.ArrayList;
import java.util.HashMap;


public class ArchivoUsuarios
{
	// ATRIBUTOS
	private HashMap<String, ArrayList<String>> proyectosUsuarios = new HashMap<String, ArrayList<String>>();
	
	
	// CONSTRUCTOR
	public ArchivoUsuarios()
	{
		cargarUsuarios();
	}
	
	
	// METODOS
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
		 * Cargar los usuarios y sus proyectos del archivo
		 * 
		 * HASTA EL MOMENTO GENERA UN PROTOTIPO
		 */
 
		ArrayList<String> proyectosEstudiante1 = new ArrayList<String>();
		proyectosEstudiante1.add("P1");
		proyectosUsuarios.put("estudiante1", proyectosEstudiante1);
		
		ArrayList<String> proyectosEstudiante2 = new ArrayList<String>();
		proyectosEstudiante2.add("P1");
		proyectosEstudiante2.add("P2");
		proyectosUsuarios.put("estudiante2", proyectosEstudiante2);

	}

	/*
	public static void main(String[] args)
	{
		ArchivoUsuarios archivo = new ArchivoUsuarios();
		System.out.println(archivo.getProyectosUsuario("estudiante4"));
	}
	 */
	
}
