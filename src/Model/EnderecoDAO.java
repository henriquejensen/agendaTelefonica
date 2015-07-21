package model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class EnderecoDAO {
	
	public Endereco inserirEnderecoBanco(Endereco novoEndereco) {
		
		Session session = getSessionfactory().openSession();
		session.beginTransaction();
		long id = (Long) session.save(novoEndereco);
		session.getTransaction().commit();
		session.close();
						
		Endereco endereco = new Endereco();
		
		endereco.setIdEndereco(id);		
		return endereco;
	}
		
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
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

	public List<Endereco> carrega(Endereco endereco) {
		
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Endereco.class);
		
		if(endereco.getIdEndereco() != null) {
			criteria.add(Restrictions.eq("id",endereco.getIdEndereco()));
		}
	    //obtem a lista baseada na criteria
	   	List<Endereco> result = criteria.list();
	   	if (result.size() == 0)
	   		return null;
	   	else 
	   		return result;
	}
}
