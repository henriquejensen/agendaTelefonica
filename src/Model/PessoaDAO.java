package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class PessoaDAO {
	
	public static void inserirPessoaBanco(long id, String nome) {
		/** Cria uma configuração*/
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		
		/** Lê o hibernate.cfg.xml*/
		configuration.configure();
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();		
		
		Transaction transacao = session.beginTransaction();
		session.save(id);
		transacao.commit();
	}
	
	public static void atualizarNomePessoaBanco(Pessoa novaPessoa){
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		
		configuration.configure();
	     
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		 
		// carrega o produto do banco de dados
		Pessoa produto = (Pessoa) session.load(Pessoa.class, 1L);
		
		Transaction transacao = session.beginTransaction();
		produto.setNome(novaPessoa.getNome());
		session.update(produto);
		transacao.commit();
	}
}
