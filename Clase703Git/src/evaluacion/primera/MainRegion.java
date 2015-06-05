package evaluacion.primera;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class MainRegion {
	
	
	public static void main(String[] args) throws ClassNotFoundException {
	
		RegionDTO region = null;
		int id_region = 0;
		String name_region = null;
		
		try {	
			//Solicitamos los datos para insertar una nueva regi�n
			System.out.println("Crear nueva Regi�n: \n");
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduzca ID de Regi�n: \n"); //El 'print' me deja escribir en la misma l�nea
			id_region = sc.nextInt();
			Scanner sc2 = new Scanner(System.in);
			System.out.println("Introduzca nombre de la Regi�n: \n"); //El 'print' me deja escribir en la misma l�nea
			name_region = sc2.nextLine();
			
			region = new RegionDTO(id_region, name_region);
			//Llamamos al m�todo insertar una region
			RegionDAO.insertarRegion(region);
			
			 
			List<RegionDTO> lista_regiones = RegionDAO.obtenerRegiones();
			System.out.println(lista_regiones);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Error al recuperar la lista de empleados de la base de datos");
		}
	}

}
