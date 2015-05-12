package properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MainProperties {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		
		if (args[0] != null) {
			
		Practica1 id = new Practica1(args[0]);
		
		id.elegirIdiomaCuento();
		id.loadProperties();
		
		id.escribirFichero();
		
		}
	}
}	
