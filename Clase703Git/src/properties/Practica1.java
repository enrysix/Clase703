package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

/**
 * Nuestro programa genera un cuento en diferentes idiomas. El idioma elegido
 * por el usuario, viene como parámetro por línea de comandos pudiendo ser IT,
 * ES o EN. Se pide: cargar el fichero apropiado en función de la entrada y
 * generar el cuento en un fichero de salida indicado
 * 
 * @author alumno
 * 
 */
public class Practica1 {

	private Properties propiedades = null;
	private String eleccion = null;
	private String rutaproperties = null;
	private String salida = null;

	public Practica1(String language) {

		this.eleccion = language;
	}

	private enum Idioma {
		IT, ES, EN
	}

	public void elegirIdiomaCuento() {

		switch (this.eleccion) {

		case "IT":
			// lengua = Idioma.IT;
			rutaproperties = "src/FilesProperties/story_it.properties.txt";
			salida = "src/FilesProperties/cuentoIT.txt";
			break;
		case "ES":
			// lengua = Idioma.ES;
			rutaproperties = "src/FilesProperties/story_es.properties.txt";
			salida = "src/FilesProperties/cuentoES.txt";
			break;
		case "EN":
			// lengua = Idioma.EN;
			rutaproperties = "src/FilesProperties/story_en.properties.txt";
			salida = "src/FilesProperties/cuentoEN.txt";
			break;
		default:
			System.out.println("Idioma Inválido");
			break;
		}
	}

	public void loadProperties() throws FileNotFoundException, IOException {

		this.propiedades = new Properties();

		propiedades.load(new FileInputStream(rutaproperties));
	}

	public void escribirFichero() throws IOException {

		String cuento = null;
		FileWriter fw = null;

		cuento = this.propiedades.getProperty("start") + " "
				+ this.propiedades.getProperty("body") + " "
				+ this.propiedades.getProperty("end");

		fw = new FileWriter(new File(salida));
		
		fw.write(cuento);
		
		fw.close();
	}
}
