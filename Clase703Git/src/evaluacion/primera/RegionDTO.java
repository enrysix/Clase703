package evaluacion.primera;

public class RegionDTO {

	private int region_id; //Declaramos un atributo privado de nuestra clase RegionDTO
	private String region_name; //Declaramos un atributo privado de nuestra clase RegionDTO
	
	/**
	 * Instanciamos los atributos con los par�metros que recibimos dentro del constructor de nuesta clase
	 * @param region_id
	 * @param region_name
	 */
	public RegionDTO (int region_id, String region_name) {
		
		this.region_id = region_id;
		this.region_name = region_name;
	}

	/**
	 * Nos devuelve el id de una regi�n
	 * @return
	 */
	public int getRegion_id() {
		return region_id;
	}

	/**
	 * Establecemos el id de regi�n del par�metro que recibimos y lo asignamos al atributo de la clase correspondiente
	 * @param region_id
	 */
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	/**
	 * Nos devuelve el nombre de una regi�n
	 * @return
	 */
	public String getRegion_name() {
		return region_name;
	}

	/**
	 * Establecemos el nombre de regi�n del par�metro que recibimos y lo asignamos al atributo de la clase correspondiente
	 * @param region_id
	 */
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	
	
}
