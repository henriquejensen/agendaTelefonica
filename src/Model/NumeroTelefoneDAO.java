package model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class NumeroTelefoneDAO {

	private static Session getSession() {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
	    configuration.configure();	     
	    SessionFactory factory = configuration.buildSessionFactory();
	    Session session = factory.openSession();		
		return session;
	}
			
	public void inserirTelefoneBanco(NumeroTelefone novoTelefone) {
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();

		session.save(novoTelefone);

		tx.commit();
	}
	
	public void atualizarTelefoneBanco(NumeroTelefone novoTelefone) {
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();

		session.update(novoTelefone);

		tx.commit();
	}

	public List<NumeroTelefone> carrega(Long id) {

		Session session = getSession();
		
		Criteria criteria = session.createCriteria(NumeroTelefone.class);
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setId(id);
		
		if(id != null) {
			criteria.add(Restrictions.eq("pessoa", pessoa));
		}
	    //obtem a lista baseada na criteria
	   	List<NumeroTelefone> result = criteria.list();
	   	if (result.size() == 0)
	   		return null;
	   	else 
	   		return result;		
	}	

}
