package Model;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class NumeroTelefoneDAO {

	public static void inserirTelfoneBanco(Pessoa novaPessoa) {
		// TODO Auto-generated method stub
		
	}
	
	private static Session iniciarSessaoBanco(){
		/** Cria uma configura��o*/
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		
		/** L� o hibernate.cfg.xml*/
		configuration.configure();
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		return session;
	}

}
