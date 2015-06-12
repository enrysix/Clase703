package dao.servicios.aumentar.salario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionManager {

	static {//el bloque de c�digo encerrado en esta llaves static s�lo se ejecutar� una vez; la primera que es invocada esta clase SessionManager!!!
			
		//CREAMOS LA CONFIGURACI�N Y EL SESI�N FACTORY
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

