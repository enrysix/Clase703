package serializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
// SERIALIZACIÓN --> Escribimos en el fichero
		Persona p1 = new Persona("Enry", (byte)28);
		Persona p2 = new Persona("Alex", (byte)25);
		Persona p3 = new Persona("JJ", (byte)22);
		
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("Serializar.dat"));
		
		salida.writeObject(p1);
		salida.writeObject(p2);
		salida.writeObject(p3);
		
		salida.close();
//------------------------------------------------------------------------------------------------

// DESERIALIZACIÓN --> Leemos del fichero
		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Serializar.dat"));
		
		p1 = (Persona)entrada.readObject();
		p2 = (Persona)entrada.readObject();
		p3 = (Persona)entrada.readObject();
		
		entrada.close();
		
		System.out.println(p1);
	}
}
