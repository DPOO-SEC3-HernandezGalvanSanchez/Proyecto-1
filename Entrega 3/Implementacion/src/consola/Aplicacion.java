package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

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
		ingresarLogin();
		ejecutarEleccionProyecto();
		ejecutarManipularProyecto();
	}
	
	
	public void ejecutarEleccionProyecto() 
	{
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
				
				else if (opcion_seleccionada == 3)
				{
					System.exit(0);
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
					ejecutarRegistrarActividad();
				}
				
				else if (opcion_seleccionada == 3)
				{
					continuar = false;
				}
				
				else if (opcion_seleccionada == 4)
				{
					continuar = false;
				}
				
				else if (opcion_seleccionada == 5)
				{
					ejecutarEleccionProyecto();
				}
							
				else if (opcion_seleccionada == 6)
				{
					System.exit(0);
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
		this.loginEnUso = input("Ingrese su login uniandes");
		usuarioEnUso = archivoUsuarios.getParticipante(loginEnUso);
		
		if (usuarioEnUso == null)
		{
			System.out.println("\nUsted no se encuentra registrado en el sistema\n");
			String nombreUsuario = input("Por favor ingrese su nombre");
			System.out.println("\nEl correo a usar sera: " + loginEnUso + "@uniandes.edu.co");
			usuarioEnUso = new Participante(loginEnUso, nombreUsuario);
		}
		
		else
		{
			System.out.println("\nSu informacion de sesion es la siguiente");
			System.out.println("Nombre: " + usuarioEnUso.getNombre());
			System.out.println("Correo: " + usuarioEnUso.getCorreo());
		}
	}
	
	
	//ELECCION DEL PROYECTO
	private void mostrarMenuParticipante() {
		System.out.println("\n----------------------------------");
		System.out.println("MENU DE ELECCION DEL PROYECTO");
		System.out.println("----------------------------------");
		
		System.out.println("\nUsted puede realizar las siguientes acciones:");
		System.out.println("1. Crear un nuevo proyecto");
		System.out.println("2. Seleccionar un proyecto existente");
		System.out.println("3. Cerrar la aplicacion\n");
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
		System.out.println("Nombre: " + coordinadorProyecto.getNombreProyecto());
		System.out.println("Descripcion: " + coordinadorProyecto.getDescripcionProyecto());
		System.out.println("Participantes: ");
		
		
		System.out.println("\n----------------------------------");
		System.out.println("MENU DEL PROYECTO");
		System.out.println("----------------------------------");
		
		System.out.println("\nUsted puede realizar las siguientes acciones:");
		System.out.println("1. Agregar un participante");
		System.out.println("2. Registrar una actividad");
		System.out.println("3. Modificar el registro de actividades");
		System.out.println("4. Mostrar el reporte de un participante");
		System.out.println("5. Volver al menu anterior");
		System.out.println("6. Cerrar la aplicacion\n");
	}
	
	
	private void ejecutarAgregarParticipante()
	{
		String nombreParticipante = input("\nIngrese el nombre del participante a agregar");
		String loginParticipante = input("Ingrese el login del participante a agregar");
		
		Participante nuevoParticipante = new Participante(loginParticipante, nombreParticipante);
		coordinadorProyecto.agregarParticipante(nuevoParticipante);
		
		System.out.println("\n" + nombreParticipante + " fue agregado con exito al proyecto");
	}
	
	
	private void ejecutarRegistrarActividad()
	{
		//Autor de la actividad
		Participante autor = usuarioEnUso;
		int preguntaParticipante = Integer.parseInt(input("\nSi el autor de la actividad es usted, digite 0. De lo contrario, digite 1"));
		
		if (preguntaParticipante != 0)
		{
			HashMap<String, Participante> participantesProyecto = coordinadorProyecto.getParticipantes();
			ArrayList<String> nombres = new ArrayList<String>(participantesProyecto.keySet());
			int numParticipantes = nombres.size();
				
			System.out.println("\nEl proyecto cuenta con los siguientes participantes:");
				
			for (int i = 1; i <= numParticipantes; i++)
			{
				int index = i - 1;
				String nombreParticipante = nombres.get(index);
				System.out.println(i + ". " + nombreParticipante);
			}
				
			int opcionParticipante = Integer.parseInt(input("\nSeleccione el autor de la actividad")) - 1;
			String nombreParticipante = nombres.get(opcionParticipante);
			autor = participantesProyecto.get(nombreParticipante);
		}		
				
		
		//Tipo de actividad
		ArrayList<String> tiposActividades = coordinadorProyecto.getTiposActividades();
		int numTipos = tiposActividades.size();
		
		System.out.println("\nEl proyecto cuenta con los siguientes tipos de actividades:");
		
		for (int i = 1; i <= numTipos; i++)
		{
			int index = i - 1;
			String tipo = tiposActividades.get(index);
			System.out.println(i + ". " + tipo);
		}
		
		int opcionTipo = Integer.parseInt(input("\nSeleccione el tipo es la actividad a registrar")) - 1;
		String tipoActividad = tiposActividades.get(opcionTipo);
		
		
		//Informacion de la actividad
		String titulo = input("\nIngrese el titulo de la actividad");
		String descripcion = input("Ingrese una descripcion");
		
		coordinadorProyecto.registrarActividad(tipoActividad, titulo, descripcion,
											   "00:00", "08:00", autor);
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
