package unit8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.System.out;

public abstract class Persona {

	protected String nombre;
	protected String dni;
	protected ArrayList<Asignatura> asignaturas;
	
	public Persona(String nombre, String dni){
		this.nombre = nombre;
		this.dni = dni;
		asignaturas = new ArrayList<Asignatura>();
	}
	
	public void anyadirAsignatura(Asignatura a){
		asignaturas.add(a);
	}
	
	
	public abstract boolean esProfesor();
	
	
	/***
	 * método que te muestra el nombre de la persona, las
	 * asignaturas que cursa, y la nota de esas asignaturas.
	 */
	public void mostrarListadoAsignaturasNota(){
		
		out.println("------------ "+nombre+" ------------");
		
		for(int i=0; i<asignaturas.size(); i++)
			out.println(asignaturas.get(i).getNombre()+" - "+
						asignaturas.get(i).getNota());
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getDni(){
		return dni;
	}
	
	public void setDni(String dni){
		this.dni = dni;
	}
	
	public ArrayList<Asignatura> getAsignaturas(){
		return asignaturas;
	}
	
	/***
	 * Ordena las asignaturas por nombre
	 */
	public void ordenarPorAsignaturas(){
		
		Collections.sort(asignaturas, new Comparator<Asignatura>() {
			public int compare(Asignatura a1, Asignatura a2) {
				return new Integer(a1.getNombre()).compareTo(new Integer(a2.getNombre()));
			}
		});
		
	}
	
	/***
	 * Ordena las asignaturas por nombre
	 */
	public void ordenarPorNota(){
		
		Collections.sort(asignaturas, new Comparator<Asignatura>() {
			public int compare(Asignatura a1, Asignatura a2) {
				return new Integer((int) a1.getNota()).compareTo(new Integer((int) a2.getNota()));
			}
		});
	}
	
	
}
