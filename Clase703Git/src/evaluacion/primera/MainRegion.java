package evaluacion.primera;

import java.sql.SQLException;
import java.util.List;


public class MainRegion {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		try {
			 
			List<RegionDTO> lista_regiones = RegionDAO.obtenerRegiones();
			System.out.println(lista_regiones);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Error al recuperar la lista de empleados de la base de datos");
		}
	}

}
