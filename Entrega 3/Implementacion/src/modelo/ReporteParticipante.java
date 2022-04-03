package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class ReporteParticipante
{
	private HashMap<String, ArrayList<Actividad>> actividades;
	
	
 public ReporteParticipante( HashMap<String, ArrayList<Actividad>> actividades)
 {
	 this.actividades = actividades;
 }
 
 public ArrayList<Actividad> actividadesMiembro(Participante participante) {
	 ArrayList<Actividad> actividadesPorMiembro = new ArrayList<Actividad>() ;
	 
	 for(String nombre: actividades.keySet()){
		 ArrayList<Actividad> listaActividades = actividades.get(nombre); 
		 for (Actividad actividad: listaActividades) {
			 if (participante == actividad.getAutor()) {
				 actividadesPorMiembro.add(actividad);
			 }
		 }		 
	 }
	 return actividadesPorMiembro;
 }
 
public int tiempoTotal(ArrayList<Actividad> actividadesPorMiembro) {
	int total = 0;
	 for(Actividad actividad: actividadesPorMiembro) {
		total += actividad.getTiempo(); 
	 }
	 return total;
 }

public HashMap<String, Float> tiempoPorActividad(ArrayList<Actividad> actividadesPorMiembro, ArrayList<String> tiposDeActividades) {
	HashMap<String, Float> promedios = new HashMap<String, Float>();
	for (String tipo:  tiposDeActividades) {
		float promedio = 0;
		int cantidad = 0;
		int acumulado = 0;
		for(Actividad actividad: actividadesPorMiembro){
			if(tipo.equals(actividad.getTipoActividad())) {
				cantidad++;
				acumulado += actividad.getTiempo(); 
			}
		}
		promedio = acumulado/cantidad;
		promedios.put(tipo, promedio);
	}
	return promedios;
}

}
