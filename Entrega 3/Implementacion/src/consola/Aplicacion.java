package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacion
{
	private ArchivoUsuarios archivoUsuarios = new ArchivoUsuarios();
	private String usuarioEnUso;
	private String nombreProyecto;
	
	
	//EJECUCION GENERAL DE LA APLICACION
	public void ejecutarAplicacion() 
	{
		ingresarLogin();

		boolean eleccionProyecto = true;
		
		while (eleccionProyecto)
		{
			try
			{
				mostrarMenuParticipante();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
				if (opcion_seleccionada == 1)
				{
					nombreProyecto = ejecutarCrearProyecto();
					eleccionProyecto = false;
				}
				
				else if (opcion_seleccionada == 2)
				{
					nombreProyecto = ejecutarSeleccionarProyecto();
					
					if (nombreProyecto != "NO_ENCONTRADO")
						eleccionProyecto = false;
				}
				
				else
				{
					System.out.println("Por favor seleccione una opcion valida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los numeros de las opciones.");
			}
		}
	}
	
	
	//INICIO DE SESION
	private void ingresarLogin() {
		this.usuarioEnUso = input("Ingrese su login");
		System.out.println("El correo a usar sera: " + usuarioEnUso + "@uniandes.edu.co");
	}
	
	
	//ELECCION DEL PROYECTO
	private void mostrarMenuParticipante() {
		System.out.println("\n----------------------------------");
		System.out.println("MENU DE ELECCION DEL PROYECTO");
		System.out.println("----------------------------------");
		
		System.out.println("\nUsted puede realizar las siguientes acciones:");
		System.out.println("1. Crear un nuevo proyecto");
		System.out.println("2. Seleccionar un proyecto existente\n");	
	}
	
	
	private String ejecutarCrearProyecto()
	{
		String nombreProyecto = input("\nIngrese el nombre del nuevo proyecto");
		String descripcion = input("Ingrese la descripcion");
		ArrayList<String> tiposActividades = new ArrayList<String>();
		
		int numTipos = Integer.parseInt(input("Ingrese cuantos tipos de actividades desea tener"));
		
		for (int i = 1; i <= numTipos; i++)
		{
			String tipo = input("Ingrese el tipo " + i);
			tiposActividades.add(tipo);
		}
		
		archivoUsuarios.guardarProyecto(usuarioEnUso, nombreProyecto);
		//coordinadorProyecto.crearProyecto(nombreProyecto, descripcion, tiposActividades);
		
		return nombreProyecto;
	}
	
	
	private String ejecutarSeleccionarProyecto()
	{
		String nombreProyecto = "NO_ENCONTRADO";
		ArrayList<String> proyectosDelUsuario = archivoUsuarios.getProyectosUsuario(usuarioEnUso);
		
		if (proyectosDelUsuario == null)
			System.out.println("\nUsted no tiene ningun proyecto registrado en el sistema");
		
		else
		{
			int numProyectos = proyectosDelUsuario.size();
			System.out.println("\nSe encontraron los siguientes proyectos en los que usted participa:");
			
			for (int i=1; i<=numProyectos; i++)
			{
				int index = i-1;
				String opcionProyecto = proyectosDelUsuario.get(index);
				System.out.println(i + ". " + opcionProyecto);
			}
			
			int seleccionProyecto = Integer.parseInt(input("\nIngrese la opcion del proyecto que desea seleccionar"));
			int index = seleccionProyecto - 1;
			nombreProyecto = proyectosDelUsuario.get(index);
			//coordinadorProyecto.seleccionarProyecto(String nombreProyecto);
		}
		
		return nombreProyecto;
	}
	
	
	//METODOS AUXILIARES
	public String input(String mensaje)
	{
		/*
		 * METODO PARA INGRESAR INFORMACION POR CONSOLA
		 */
		
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	
	//INICIO DE LA APLICACION
	public static void main(String[] args)
	{
		System.out.println("Aplicacion");
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}
}
