package unit8;

public class Profesor extends Persona {

	public Profesor(String nombre, String dni) {
		super(nombre, dni);
	}

	@Override
	public boolean esProfesor() {
		return true;
	}

}
