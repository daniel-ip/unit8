package unit8;

public class Alumno extends Persona {
	
	public Alumno(String nombre, String dni){
		super(nombre, dni);
	}

	@Override
	public boolean esProfesor() {
		return false;
	}

}
