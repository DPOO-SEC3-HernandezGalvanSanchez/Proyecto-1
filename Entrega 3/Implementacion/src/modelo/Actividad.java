package modelo;

import modelo.Participante;

public class Actividad
{

	private String idActividad; 
	private String tipoActividad;
	private String titulo;
	private String descripcion;
	private String horaInicio;
	private String horaFin;
	private Participante autor;
	
	
	public Actividad(String tipoActividad, String titulo, String descripcion,
					 String horaInicio, String horaFin, Participante autor)
	{
		this.tipoActividad = tipoActividad;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.autor = autor;
	}
	
	//GETTERS
	public String getTipoActividad()
	{
		return tipoActividad;
	}


	public String getTitulo()
	{
		return titulo;
	}


	public String getDescripcion()
	{
		return descripcion;
	}


	public String getHoraInicio()
	{
		return horaInicio;
	}


	public String getHoraFin()
	{
		return horaFin;
	}


	public Participante getAutor()
	{
		return autor;
	}
	
}
