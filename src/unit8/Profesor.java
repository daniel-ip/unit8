package unit8;

public class Profesor extends Persona {

	private double salario;
	
	public Profesor(String nombre, String dni) {
		super(nombre, dni);
	}

	@Override
	public boolean esProfesor() {
		return true;
	}
	
	public void setSalario(double salario){
		this.salario = salario;
	}
	
	public double getSalario(){
		return salario;
	}

}
