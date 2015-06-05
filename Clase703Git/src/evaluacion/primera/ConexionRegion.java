package evaluacion.primera;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;

public class ConexionRegion {

	public static Connection obtenerConexion() throws ClassNotFoundException, SQLException {
		
		Connection conn = null;
		Savepoint salvar = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
//			DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// método equivalente al anterior
			//Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa clase!>>
			
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "six0six0");
			
			//Metodos que se ejecutan en una Transaccion
			conn.setAutoCommit(false); //Primero de nada se establece el AutoCommit
			salvar = conn.setSavepoint(); //Creamos un punto de salvación - Se realiza antes de hacer la TRANSACCIÓN
			conn.commit(); //Se valida las operaciones de verdad
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			conn.rollback(salvar); // Se deshace todo lo que se ha hecho hasta el punto de salvación 'salvar' o sino lo pones es hasta donde se ha creado la conexión
		} finally {
			conn.close();
		}
		return conn;
	}
	
}
