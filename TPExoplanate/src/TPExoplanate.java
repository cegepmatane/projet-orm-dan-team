import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TPExoplanate {

	public static void main(String[] args) {

		// Préparation (une seule fois)
		Configuration configuration = new Configuration();
		configuration.addClass(Exoplanete.class);
		SessionFactory sessionControleur = configuration.buildSessionFactory();
		Session session = sessionControleur.openSession();
		
		// Lecture
		@SuppressWarnings("deprecation")
		Iterator listeExoplanete = session.createQuery("from Exoplanete ").iterate();
		while(listeExoplanete.hasNext())
		{
			Exoplanete exoplanete = (Exoplanete)listeExoplanete.next(); // ca prend le constructeur vide
			System.out.println("Exoplanete : " + exoplanete.getPlanete());
		}
		
		// Ecriture
		Exoplanete nouvelleExoplanete = new Exoplanete("Test", "Test1");
		session.save(nouvelleExoplanete);
		
		// Nettoyage final (une seule fois)
		session.close();
		sessionControleur.close();
	}

}
