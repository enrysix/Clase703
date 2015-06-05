package evaluacion.primera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegionDAO {

	/**
	 * Método que me instancia la región en un objeto de RegionDTO pasándole como parámetro su id y nombre
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private static RegionDTO establecerRegion (ResultSet rs) throws SQLException {
		
		RegionDTO region = null;
		
		int region_id = rs.getInt(1);
		String region_name = rs.getString(2);
		
		region = new RegionDTO(region_id, region_name);
		
		return region;
	}
	/**
	 * Método que devuelve la lista de regiones de la BBDD
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static List<RegionDTO> obtenerRegiones () throws SQLException, ClassNotFoundException {
		
		List<RegionDTO> lista_regiones = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		RegionDTO region = null;
		
		try {
			conn = ConexionRegion.obtenerConexion();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(InstruccionesRegion.CONSULTAR_TODOS);
			lista_regiones = new ArrayList<RegionDTO>();
			
			while (rset.next()) {
				
				region = establecerRegion(rset);
				lista_regiones.add(region);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			lista_regiones = null;
		} finally {
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		}
		return lista_regiones;
	}
	/**
	 * Método que inserta una registro en la BBDD
	 */
	public static void insertarRegion (RegionDTO region) {
		
		Connection conn = null;
		Statement stmt = null;
		int id_region = 0;
		String name_region = null;
		ResultSet rset = null;
	
		try {
			conn = ConexionRegion.obtenerConexion();
			PreparedStatement pstmt = conn.prepareStatement(InstruccionesRegion.INSERTAR_REGION);     
			pstmt.setInt(1, id_region);	
			pstmt.setString(2, name_region);
			
			rset = pstmt.executeQuery();
			
			System.out.println("Datos ingresados correctamente");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		}
	}
	
	/**
	 * Método que me devuelve un campo RegionDAO de la BBDD pasándole por parámetro la region_id
	 * @param region_id
	 * @return
	 */
	public static RegionDAO recuperarId (int region_id) {
		
		RegionDAO region = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
	
		
		try {
			conn = ConexionRegion.obtenerConexion();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(InstruccionesRegion.CONSULTA_ID);
			
			while (rset.next()) {
				
				if (rset.getInt(1) == region_id) {
					
					System.out.println(rset.getInt(1) + rset.getString(2));
				}

			}
		} catch (Exception e) {
		
			e.printStackTrace();
			
		} finally {
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		}
		
		
		return region;
	}
}
