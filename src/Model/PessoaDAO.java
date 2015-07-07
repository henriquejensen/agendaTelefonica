package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class PessoaDAO {
	
	private static Session session;
	
	public PessoaDAO(){
		session = iniciarSessaoBanco();
	}
	
	public static Pessoa inserirPessoaBanco(Pessoa novaPessoa) {
		
		Transaction transacao = session.beginTransaction();		 
		long id = (Long) session.save(novaPessoa);
		transacao.commit();
		
		Pessoa idPessoa = new Pessoa();
		
		idPessoa.setId(id);		
		return idPessoa;
	}
	
	public static void atualizarPessoaBanco(Pessoa novaPessoa){
		 
		/** carrega o produto do banco de dados */
		Pessoa pessoaAtualizar = (Pessoa) session.load(Pessoa.class, 1L);
		
		Transaction transacao = session.beginTransaction();
		long idAtualizar = pessoaAtualizar.getId();
		pessoaAtualizar = novaPessoa;
		pessoaAtualizar.setId(idAtualizar);
		session.update(pessoaAtualizar);
		transacao.commit();
	}
	
	public static void removerPessoaBanco(){
	     
		/** carrega o produto do banco de dados */
	    Pessoa pessoaDelete = (Pessoa) session.load(Pessoa.class, 1L);
	     
	    Transaction tx = session.beginTransaction();
	    session.update(pessoaDelete);
	    tx.commit();
	}
	
	private static Session iniciarSessaoBanco(){
		/** Cria uma configuração*/
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		
		/** Lê o hibernate.cfg.xml*/
		configuration.configure();
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		return session;
	}	
}
