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
public class EnderecoDAO {
	
	private static Session getSession() {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
	    configuration.configure();	     
	    SessionFactory factory = configuration.buildSessionFactory();
	    Session session = factory.openSession();		
		return session;
	}
	
	public Endereco inserirEnderecoBanco(Endereco novoEndereco) {
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		
		long id = (Long) session.save(novoEndereco);

		tx.commit();
						
		Endereco endereco = new Endereco();
		
		endereco.setIdEndereco(id);		
		return endereco;
	}

	public List<Endereco> carrega(Endereco endereco) {
		
		Session session = getSession();
		
		Criteria criteria = session.createCriteria(Endereco.class);
		
		if(endereco.getIdEndereco() != null) {
			criteria.add(Restrictions.eq("id", endereco.getIdEndereco()));
		}
	    //obtem a lista baseada na criteria
	   	List<Endereco> result = criteria.list();
	   	if (result.size() == 0)
	   		return null;
	   	else 
	   		return result;
	}

	public void atualiza(Endereco endereco) {

		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.update(endereco);
		tx.commit();		
	}
}
