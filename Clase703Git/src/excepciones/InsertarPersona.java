package excepciones;

import javax.swing.JOptionPane;

import ejemplo.clase.persona.PedirDatos;
import ejemplo.clase.persona.Persona;

public class InsertarPersona {
		
	public static void main(String[] args) throws MessageError {

		Persona p[] = new Persona[4];
		InsertarPersona ip = null;
		String nom = null;
		byte age = 0;
		int longitud = 0;
		
		longitud = p.length+1;
	
		try {
			
			for (int i = 0; i < longitud; i++) {
			
				System.out.println("Persona " + (i+1));
//				nom = PedirDatos.pedirNombre();
//				age = PedirDatos.pedirEdad();
			
				p[i] = new Persona(nom, age);	
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		
			throw new MessageError();
		}
	}
}

