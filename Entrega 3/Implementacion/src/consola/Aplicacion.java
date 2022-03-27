package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Aplicacion
{
	private String usuarioEnUso;
	
	
	public void ejecutarAplicacion() 
	{
		ingresarLogin();
		System.out.println("\nAplicacion\n");

		boolean continuar = true;
		
		while (continuar)
		{
			try
			{
				mostrarMenuParticipante();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
				if (opcion_seleccionada == 1)
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
	
	
	private void ingresarLogin() {
		this.usuarioEnUso = input("Ingrese su login");
		System.out.println("El correo a usar sera: " + usuarioEnUso + "@uniandes.edu.co");
	}
	
	
	private void mostrarMenuParticipante() {
		System.out.println("Menu");
	}
		
	
	/*
	 * METODO PARA INGRESAR INFORMACION POR CONSOLA
	 */
	public String input(String mensaje)
	{
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
	
	/*
	 * INICIO DE LA APLICACION
	 */
	public static void main(String[] args)
	{
		System.out.println("Aplicacion");
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}
}
