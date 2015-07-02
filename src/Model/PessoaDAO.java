package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class PessoaDAO {
	
	public static void inserirBanco(PessoaModel novaPessoa) {
		/** Cria uma configuração*/
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		
		/** Lê o hibernate.cfg.xml*/
		configuration.configure();
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();		
		
		Transaction transacao = session.beginTransaction();
		session.save(novaPessoa);
		transacao.commit();
	}
	
	public static void atualizarBanco(PessoaModel novaPessoa){
		/** Cria uma configuração*/
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		
		/** Lê o hibernate.cfg.xml*/
		configuration.configure();
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction transacao = session.beginTransaction();
		session.update(novaPessoa);
		transacao.commit();
	}
}
