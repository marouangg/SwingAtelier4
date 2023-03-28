package ma.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import ma.entitie.Produit;




public class HibernateUtile {

	private static final SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static {
	
	try {
		
		Configuration conf = new Configuration();
		
		conf.configure("hibernate.cfg.xml");
		conf.addAnnotatedClass(Produit.class);
		
		//conf.addAnnotatedClass(Perssone.class);
		//conf.addAnnotatedClass(Voiture.class);
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		sessionFactory=conf.buildSessionFactory(serviceRegistry);
	}
	catch(Throwable th) {
		System.err.println("Enitial SessionFactory creation failed"+th);
		throw new ExceptionInInitializerError(th);
	}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
