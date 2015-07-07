package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class NumeroTelefoneDAO {

	private static Session session;
	
	public NumeroTelefoneDAO(){
		this.session = iniciarSessaoBanco();
	}
		
	public static void inserirTelefoneBanco(NumeroTelefone novoTelefone) {
		
		System.out.println(novoTelefone.getNumero());
		
		Transaction transacao = session.beginTransaction();
		session.save(novoTelefone);
		transacao.commit();		
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
