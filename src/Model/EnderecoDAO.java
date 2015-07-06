package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class EnderecoDAO {
	
	private static Session session;
	
	public EnderecoDAO(){
		session = iniciarSessaoBanco();
	}

	public static Endereco inserirEnderecoBanco(Endereco novoEndereco) {
		Transaction transacao = session.beginTransaction();		 
		long id = (Long) session.save(novoEndereco);
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(id);
		transacao.commit();
		return endereco;
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
