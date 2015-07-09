package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class PessoaDAO {
	
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
	
	public Pessoa inserirPessoaBanco(Pessoa novaPessoa) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		long id = (Long) session.save(novaPessoa);
		session.getTransaction().commit();
		session.close();
		
		Pessoa idPessoa = new Pessoa();
		
		idPessoa.setId(id);		
		return idPessoa;
	}
	
	/*public static void atualizarPessoaBanco(Pessoa novaPessoa){	
		 
		*//** carrega o produto do banco de dados *//*
		Pessoa pessoaAtualizar = (Pessoa) session.load(Pessoa.class, 1L);
		
		Transaction transacao = session.beginTransaction();
		long idAtualizar = pessoaAtualizar.getId();
		pessoaAtualizar = novaPessoa;
		pessoaAtualizar.setId(idAtualizar);
		session.update(pessoaAtualizar);
		transacao.commit();
	}
	
	public static void removerPessoaBanco(Pessoa removerPessoa){
	     
		*//** carrega o produto do banco de dados *//*
	    Pessoa pessoaDelete = (Pessoa) session.load(Pessoa.class, 1L);
	    
	    //pessoaDelete.setDeletadoBanco(true);
	    
	    //System.out.println(pessoaDelete.getNome());
	    
	    Transaction tx = session.beginTransaction();
	    session.update(pessoaDelete);
	    tx.commit();
	}*/	

	public List<Pessoa> listaPessoaBanco() {
		
		Session session = sessionFactory.openSession();
		return session.createCriteria(Pessoa.class).list();
		
	}	
}
