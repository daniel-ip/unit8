package unit8;

/***
 * Asignaturas
 * @author Daniel Íñigo Pérez
 * @version 03/05/2015
 */
public class Asignatura {

	private String nombre;
	private double nota;
	
	public Asignatura(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	
	public double getNota(){
		return nota;
	}
	
	public void setNota(double nota){
		this.nota = nota;
	}
}
