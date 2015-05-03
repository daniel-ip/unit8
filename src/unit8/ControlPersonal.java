package unit8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.lang.System.out;

public class ControlPersonal {

	private static ArrayList<Persona> personas;
	
	public ControlPersonal(){
		personas = new ArrayList<Persona>();
	}
	
	public void anyadirPersona(Persona p){
		personas.add(p);
	}
	
	public void ordenarPorDni(){
		
		Collections.sort(personas, new Comparator<Persona>() {
			public int compare(Persona p1, Persona p2) {
				return new Integer(p1.getDni()).compareTo(new Integer(p2.getDni()));
			}
		});
		
	}
	
	public void ordenarPorOrdenAlfabetico(){
		
		Collections.sort(personas, new Comparator<Persona>() {
			public int compare(Persona p1, Persona p2) {
				return new String(p1.getNombre()).compareTo(new String(p2.getNombre()));
			}
		});
	}
	
	public void mostrarListado(){
		
	}
	
	public static void main(String[] args) {
		
		Asignatura a1 = new Asignatura("Entornos");
		Asignatura a2 = new Asignatura("Programaci�n");
		Asignatura a3 = new Asignatura("Sistemas");
		Asignatura a4 = new Asignatura("Lenguaje de marcas");
		Asignatura a5 = new Asignatura("Bases de datos");
				
		
		//Profesor 1
		Profesor p1 = new Profesor("Pepe","11111");
		p1.anyadirAsignatura(a1); p1.getAsignaturas().get(0).setNota(5);
		p1.anyadirAsignatura(a3); p1.getAsignaturas().get(1).setNota(8);	

		//Profesor 2
		Profesor p2 = new Profesor("Julio","22222");
		p2.anyadirAsignatura(a2); p2.getAsignaturas().get(0).setNota(6);
		p2.anyadirAsignatura(a4); p2.getAsignaturas().get(1).setNota(8);
		
		//Profesor 3
		Profesor p3 = new Profesor("Luisa","333333");
		p3.anyadirAsignatura(a2); p3.getAsignaturas().get(0).setNota(9);
		
		//Alumno 1
		Alumno al1 = new Alumno("José","0000001");
		al1.anyadirAsignatura(a1); al1.getAsignaturas().get(0).setNota(9);
		al1.anyadirAsignatura(a2); al1.getAsignaturas().get(1).setNota(2);
		al1.anyadirAsignatura(a3); al1.getAsignaturas().get(2).setNota(7);
		
		//Alumno 2
		Alumno al2 = new Alumno("María","0000002");
		al2.anyadirAsignatura(a1); al2.getAsignaturas().get(0).setNota(9);
		al2.anyadirAsignatura(a2); al2.getAsignaturas().get(1).setNota(8);
		al2.anyadirAsignatura(a3); al2.getAsignaturas().get(2).setNota(9);
		
		//Alumno 3
		Alumno al3 = new Alumno("Romualda","0000003");
		al3.anyadirAsignatura(a2); al3.getAsignaturas().get(0).setNota(4);
		al3.anyadirAsignatura(a3); al3.getAsignaturas().get(1).setNota(6);
		al3.anyadirAsignatura(a4); al3.getAsignaturas().get(2).setNota(8);
		
		ControlPersonal cp = new ControlPersonal();
		
		cp.anyadirPersona(p1);
		cp.anyadirPersona(p2);
		cp.anyadirPersona(p3);
		
		cp.anyadirPersona(al1);
		cp.anyadirPersona(al2);
		cp.anyadirPersona(al3);
		
		
		cp.ordenarPorOrdenAlfabetico();
		out.println("------ Alumnos ordenados por nombre ------");
		out.println();
		for(int i=0; i<personas.size(); i++){
			if(!personas.get(i).esProfesor()){
				out.println(personas.get(i).getNombre()+" - "+personas.get(i).getDni());
			}
		}
		out.println("----------------------------");
		out.println();
		out.println();
		
		
	/****************************************************/
		
		
		out.println("------ Alumnos por asignatura------");
		out.println();
		//Recorre las 3 asignaturas
		for(int i=0; i<3; i++){

			if(i==0)
				out.println("Entornos:");
			else if(i==1)
				out.println("Programación: ");
			else
				out.println("Sistemas: ");
			
			out.println();
			
			//Recorre cada persona
			for(int j=0; j<personas.size(); j++){
				
				//Cada alumno
				if(!personas.get(j).esProfesor()){
					
					//Cada asignatura de cada alumno
					for(int h=0; h<personas.get(j).getAsignaturas().size(); h++){
						
						//Si es entornos
						if(i==0 && personas.get(j).getAsignaturas().get(h).getNombre().equals("Entornos"))
							out.println(personas.get(j).getNombre());
						//Si es programación
						else if(i==1 && personas.get(j).getAsignaturas().get(h).getNombre().equals("Programación"))
							out.println(personas.get(j).getNombre());
						//Si es Sistemas
						else if(i==2 && personas.get(j).getAsignaturas().get(h).getNombre().equals("Sistemas"))
							out.println(personas.get(j).getNombre());		
						
					} //Fin for H
				} //Fin if
					
			} //Fin for J
			
			out.println();
			
		} //Fin for I
		out.println("----------------------------");
		out.println();
		out.println();
		
	/****************************************************/
		
		cp.ordenarPorDni();
		out.println("------ Profesores ordenados por DNI ------");
		out.println();
		for(int i=0; i<personas.size(); i++){
			if(personas.get(i).esProfesor()){
				out.println(personas.get(i).getNombre()+" - "+personas.get(i).getDni());
			}
		}
		out.println("----------------------------");
		out.println();
		out.println();
		
		
	/****************************************************/
		
		double temNotaMedia;
		int[] temMedia = new int[2];
		int[][] notaMediaAlumnos = new int[personas.size()][2];
		
		out.println("------ Alumnos ordenados por nota media ------");
		out.println();
		for(int i=0; i<personas.size(); i++){
			if(!personas.get(i).esProfesor()){
				
				temNotaMedia = 0;
				
				for(int j=0; j<personas.get(i).getAsignaturas().size(); j++)
					temNotaMedia += personas.get(i).getAsignaturas().get(j).getNota();
				
				notaMediaAlumnos[i][0] = i;
				notaMediaAlumnos[i][1] = (int) (temNotaMedia/(personas.get(i).getAsignaturas().size()));
					
			}
		}
		
		//Ordenar
		for(int i=0; i<personas.size()-1; i++){
			for(int j=i+1; j<personas.size(); j++){
				
				if(notaMediaAlumnos[i][1]<notaMediaAlumnos[j][1]){
					temMedia[0] = notaMediaAlumnos[i][0];
					temMedia[1] = notaMediaAlumnos[i][1];
					
					notaMediaAlumnos[i][0] = notaMediaAlumnos[j][0];
					notaMediaAlumnos[i][1] = notaMediaAlumnos[j][1];
					
					notaMediaAlumnos[j][0] = temMedia[0];
					notaMediaAlumnos[j][1] = temMedia[1];
				}
			}
		}
		
		//Mostrar
		for(int i=0; i<personas.size(); i++){			
				
			if(notaMediaAlumnos[i][1]>0)
				out.println(personas.get(notaMediaAlumnos[i][0]).getNombre()+" - "+notaMediaAlumnos[i][1]);
				
		}
		out.println("----------------------------");
		out.println();
		out.println();
		
		
		
	/****************************************************/
			
		double temNotaMediaP;
		int[] temMediaP = new int[2];
		int[][] notaMediaProfesores = new int[personas.size()][2];
		out.println("------ Profesores ordenados por nota media ------");
		out.println();
		for(int i=0; i<personas.size(); i++){
			if(personas.get(i).esProfesor()){
				
				temNotaMediaP = 0;
				
				for(int j=0; j<personas.get(i).getAsignaturas().size(); j++)
					temNotaMediaP += personas.get(i).getAsignaturas().get(j).getNota();
				
				notaMediaProfesores[i][0] = i;
				notaMediaProfesores[i][1] = (int) (temNotaMediaP/(personas.get(i).getAsignaturas().size()));
					
			}
		}
		
		//Ordenar
		for(int i=0; i<personas.size()-1; i++){
			for(int j=i+1; j<personas.size(); j++){
				
				if(notaMediaProfesores[i][1]<notaMediaProfesores[j][1]){
					temMediaP[0] = notaMediaProfesores[i][0];
					temMediaP[1] = notaMediaProfesores[i][1];
					
					notaMediaProfesores[i][0] = notaMediaProfesores[j][0];
					notaMediaProfesores[i][1] = notaMediaProfesores[j][1];
					
					notaMediaProfesores[j][0] = temMedia[0];
					notaMediaProfesores[j][1] = temMedia[1];
				}
			}
		}
		
		//Mostrar
		for(int i=0; i<personas.size(); i++){			
				
			if(notaMediaProfesores[i][1]>0)
				out.println(personas.get(notaMediaProfesores[i][0]).getNombre()+" - "+notaMediaProfesores[i][1]);
				
		}
		out.println("----------------------------");
		out.println();
		out.println();
		
		
		
		
		
		
		

	}

}
