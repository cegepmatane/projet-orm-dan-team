import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FenetrePrincipale 
{
	private JFrame fenetrePrincipale;
	
	public FenetrePrincipale()
	{
		this.fenetrePrincipale = new JFrame();

		
		afficherFenetre();
	}
	
	private void afficherFenetre()
	{
		this.fenetrePrincipale.setTitle("Seismes");
		this.fenetrePrincipale.setSize(500, 500); 
		this.fenetrePrincipale.setResizable(false);
		this.fenetrePrincipale.setLocationRelativeTo(null);
		this.fenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.fenetrePrincipale.add(construireOnglet());
		
		this.fenetrePrincipale.setVisible(true);
	}
	
	private JTabbedPane construireOnglet()
	{
		JTabbedPane tableauOnglet = new JTabbedPane();
		
		tableauOnglet.addTab("Onglet 1", getOnglet1());
		tableauOnglet.addTab("Onglet 2", getOnglet2());
		tableauOnglet.addTab("Onglet 3", getOnglet3());
		
		return tableauOnglet;
		
	}

	private JPanel getOnglet1()
	{
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
		//Exoplanete nouvelleExoplanete = new Exoplanete("Test", "Test1");
		//session.save(nouvelleExoplanete);
		
		// Nettoyage final (une seule fois)
		session.close();
		sessionControleur.close();
		
		return null;
		
	}
	
	private JPanel getOnglet2()
	{
		return null;
		
	}
	
	private JPanel getOnglet3()
	{
		return null;
		
	}
	
}

