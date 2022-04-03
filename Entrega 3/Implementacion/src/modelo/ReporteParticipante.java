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
 
public void tiempoTotal(ArrayList<Actividad> actividadesPorMiembro) {
	 
 }

public void tiempoPorActividad() {
	 
}

}
