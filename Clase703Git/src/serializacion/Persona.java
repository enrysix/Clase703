package serializacion;

import java.io.Serializable;

public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	byte edad;
	final static int MAYOR_EDAD = 18; //Si el valor es constante se ulitiza el 
									//modificador 'final' junto con static para que no guarde memoria para cada objeto
	/**
	 * constructor de la clase que recibe dos paramatros
	 * 
	 * @param nombre
	 *            : par�metro de entrada de tipo string
	 * @param edad
	 *            : par�metro de entrada de tipo byte
	 */
	public Persona(String nombre, byte edad) { // Constructor de la clase perso

		this.nombre = nombre; // Est� haciendo referencia al mismo atributo de
								// la clase persona
		this.edad = edad;
	}
	public void mostrarPersona() {

		System.out.println(this.nombre); // Mostrar nombre
		System.out.println(this.edad); // Mostrar edad
	}
	public boolean esMayorEdad () {
		
		boolean esmayor = true;
		
		if (this.edad >= Persona.MAYOR_EDAD) {
			esmayor = true;
		}	
		else {
			esmayor = false;
		}
		return esmayor;
	}
	/**
	 * @Override
	 */
	public boolean equals(Object o) { //Object 'o' recibe person3
		// TODO Auto-generated method stub
		boolean soniguales = false;
		Persona person = null;
		
//		if (person == this) { //Si person apunta a la misma direcci�n del objeto 
				
			if (o instanceof Persona) {//Comprueba si el objeto o es una instancia u objeto de la clase Persona
				
			person = (Persona)o; //Es el Casting es la conversi�n de un tipo de dato a otro equivalente y para objetos que guardan una relaci�n de jerarqu�a
			
			}
			if (person.nombre.equals(nombre) && person.edad == this.edad) { //El String es un objeto con lo cual a punta a una direcci�n de memoria por eso utilizamos equals. El tipo byte al ser un tipo primitivo no hereda ni atributos ni metodos.
				soniguales = true;
			}
			else {
				soniguales = false;
			}
//		}
		return soniguales; //Estar�a llamando al padre de clase Persona que es la clase Object
		
	}

	public String toString() {
		String nom = null;
		
		nom = "El nombre es " + this.nombre + " y la edad es " + this.edad;
		
		return nom;
	}
}

