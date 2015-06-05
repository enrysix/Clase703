package evaluacion.primera;

public class InstruccionesRegion {
	
	//Declaramos nuestros atributos constantes los cuales guardan nuestras instrucciones sql
	public static final String CONSULTAR_TODOS = "SELECT * FROM REGIONS";
	public static final String INSERTAR_REGION = "INSERT INTO REGIONS (REGION_ID, REGION_NAME) VALUES(?, '?')";
	public static final String CONSULTA_ID = "SELECT REGIONS FROM REGION_ID";
	
	
}
