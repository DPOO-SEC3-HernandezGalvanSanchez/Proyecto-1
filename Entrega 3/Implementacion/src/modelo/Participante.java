package modelo;

public class Participante
{

	private String loginCorreo;
	private String nombre;
	
	public Participante(String loginCorreo, String nombre)
	{
		this.loginCorreo = loginCorreo;
		this.nombre = nombre;
	}

	public String getNombre()
	{
		return nombre;
	}

	public String getLogin()
	{
		return loginCorreo;
	}
	
}
