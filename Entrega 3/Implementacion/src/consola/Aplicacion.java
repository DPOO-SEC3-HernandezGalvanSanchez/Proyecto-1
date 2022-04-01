package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.CoordinadorProyecto;
import modelo.Participante;


public class Aplicacion
{
	private ArchivoUsuarios archivoUsuarios = new ArchivoUsuarios();
	private CoordinadorProyecto coordinadorProyecto = new CoordinadorProyecto();
	
	private String loginEnUso;
	private Participante usuarioEnUso;  //REVISAR
	
	
	//EJECUCION GENERAL DE LA APLICACION
	private void ejecutarAplicacion()
	{
		ejecutarEleccionProyecto();
		ejecutarManipularProyecto();
	}
	
	
	public void ejecutarEleccionProyecto() 
	{
		ingresarLogin();

		boolean continuar = true;
		
		while (continuar)
		{
			try
			{
				mostrarMenuParticipante();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
				if (opcion_seleccionada == 1)
				{
					ejecutarCrearProyecto();
					continuar = false;
				}
				
				else if (opcion_seleccionada == 2)
				{
					continuar = ejecutarSeleccionarProyecto();
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
	
	
	public void ejecutarManipularProyecto() 
	{
		boolean continuar = true;
		
		while (continuar)
		{
			try
			{
				mostrarMenuProyecto();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
				if (opcion_seleccionada == 1)
				{
					ejecutarAgregarParticipante();
				}
				
				else if (opcion_seleccionada == 2)
				{
					continuar = false;
				}
				
				else if (opcion_seleccionada == 3)
				{
					continuar = false;
				}
				
				else if (opcion_seleccionada == 4)
				{
					continuar = false;
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
		this.loginEnUso = input("Ingrese su login");
		String nombreUsuario = input("Ingrese su nombre");
		System.out.println("\nEl correo a usar sera: " + loginEnUso + "@uniandes.edu.co");
		
		usuarioEnUso = new Participante(loginEnUso, nombreUsuario); //REVISAR
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
	
	
	private void ejecutarCrearProyecto()
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
		
		archivoUsuarios.guardarProyecto(loginEnUso, nombreProyecto);
		coordinadorProyecto.crearProyecto(nombreProyecto, descripcion, tiposActividades, usuarioEnUso);
		
		System.out.println("\nEl proyecto fue creado con exito");
		
	}
	
	
	private boolean ejecutarSeleccionarProyecto()
	{
		boolean continuar = true;
		ArrayList<String> proyectosDelUsuario = archivoUsuarios.getProyectosUsuario(loginEnUso);
		
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
			String nombreProyecto = proyectosDelUsuario.get(index);
			coordinadorProyecto.seleccionarProyecto(nombreProyecto);
			continuar = false;
		}
		
		return continuar;
	}
	
	
	// MANIPULACION DEL PROYECTO
	private void mostrarMenuProyecto() {
		
		System.out.println("\n----------------------------------");
		System.out.println("INFORMACION DEL PROYECTO\n");
		System.out.println("Nombre: ");
		System.out.println("Descripcion: ");
		System.out.println("Participantes: ");
		
		
		System.out.println("\n----------------------------------");
		System.out.println("MENU DEL PROYECTO");
		System.out.println("----------------------------------");
		
		System.out.println("\nUsted puede realizar las siguientes acciones:");
		System.out.println("1. Agregar un participante");
		System.out.println("2. Registrar una actividad");
		System.out.println("3. Modificar el registro de actividades");
		System.out.println("4. Mostrar el reporte de un participante");
	}
	
	
	private void ejecutarAgregarParticipante()
	{
		String nombreParticipante = input("Ingrese el nombre del participante a agregar");
		String loginParticipante = input("Ingrese el login del participante a agregar");
		
		Participante nuevoParticipante = new Participante(loginParticipante, nombreParticipante);
		coordinadorProyecto.agregarParticipante(nuevoParticipante);
		
		System.out.println(nombreParticipante + " fue agregado con exito al proyecto");
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
