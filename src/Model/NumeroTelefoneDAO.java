package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class NumeroTelefoneDAO {

	private static final SessionFactory sessionFactory = buildSessionFactory();
			
	public void inserirTelefoneBanco(NumeroTelefone novoTelefone) {
		
		Session session = getSessionfactory().openSession();
		session.beginTransaction();
		session.save(novoTelefone);
		session.getTransaction().commit();
		session.close();	
	}	

	private static SessionFactory buildSessionFactory() {

		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		return configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}
