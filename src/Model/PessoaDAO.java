package model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class PessoaDAO {
	
	private static Session getSession(){
		AnnotationConfiguration configuration = new AnnotationConfiguration();
	    configuration.configure();	     
	    SessionFactory factory = configuration.buildSessionFactory();
	    Session session = factory.openSession();		
		return session;
	}
	
	public Pessoa inserirPessoaBanco(Pessoa novaPessoa) {
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		
		long id = (Long) session.save(novaPessoa);
		
		tx.commit();
		
		Pessoa idPessoa = new Pessoa();
		
		idPessoa.setId(id);		
		return idPessoa;
	}
	
	public List<Pessoa> carrega(Long id) {
		
		Session session = getSession();
		
		Criteria criteria = session.createCriteria(Pessoa.class);
		criteria.add(Restrictions.eq("deletadoBanco", false));
				
		if(id != null) {
			criteria.add(Restrictions.eq("id", id));
		}
	    //obtem a lista baseada na criteria
	   	List<Pessoa> result = criteria.list();
	   	if (result.size() == 0)
	   		return null;
	   	else 
	   		return result;
	}
	
	public void atualiza(Pessoa pessoa) {
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.update(pessoa);
		tx.commit();	
	}
	
	public void remove(Pessoa pessoa){
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.update(pessoa);
		tx.commit();
	}

	public List<Pessoa> busca(String nome) {

		Session session = getSession();
		
		Criteria criteria = session.createCriteria(Pessoa.class);
				
		criteria.add(Restrictions.eq("nome", nome));
				
		List<Pessoa> result = criteria.list();
	   	if (result.size() == 0)
	   		return null;
	   	else 
	   		return result;
	}	
}
