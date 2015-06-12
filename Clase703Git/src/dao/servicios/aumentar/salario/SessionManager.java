package dao.servicios.aumentar.salario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionManager {

	static {//el bloque de código encerrado en esta llaves static sólo se ejecutará una vez; la primera que es invocada esta clase SessionManager!!!
			
		//CREAMOS LA CONFIGURACIÓN Y EL SESIÓN FACTORY
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build()); 
	}
	
	private static SessionFactory factory;
	
	private SessionManager (){}
	
	public static SessionFactory getSessionFactory () {
		
		return factory;
	}
	
	public static Session getNewSession () {
		
		return factory.openSession();
	}
	
	public static  void closeSession (Session sesion) {
		
		sesion.close();
	}
}

