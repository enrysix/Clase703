package dao.servicios.aumentar.salario;

import org.hibernate.Session;

public class SuperClassDAO {
	
	protected Session sesion = null;
	
	public Session getSession() {
		
		return sesion;
	}
	
	public void setSession(Session sesion) {
		
		this.sesion = sesion;
	}
}
