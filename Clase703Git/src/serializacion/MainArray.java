package serializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

//Practica 3
public class MainArray {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Persona [] personarray = null;
		int longarray = 0;
		String name = null;
		byte edad = 0;
		
		personarray = new Persona[3];
		longarray = personarray.length;
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < longarray; i++) {
			
			System.out.print("Introduzca nombre: "); //El 'print' me deja escribir en la misma línea
			name = sc.next(); 
			
			System.out.print("Introduzca edad: ");
			edad = sc.nextByte();
			
			personarray[i] = new Persona(name, edad);
		}
		
// SERIALIZAR un Array de Personas
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("Personas.dat"));
		
		salida.writeObject(personarray);
		
		salida.close();
		
// DESERIALIZAR un Array de Personas
		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Personas.dat"));
		
		personarray = (Persona[])entrada.readObject();
		
		entrada.close();
		
		System.out.println();
		
		//Mostramos el contenido de todas las posiciones de mi array
		for (int i = 0; i < longarray; i++) {
			
			System.out.println(personarray[i]);
			
		}
	}

}
