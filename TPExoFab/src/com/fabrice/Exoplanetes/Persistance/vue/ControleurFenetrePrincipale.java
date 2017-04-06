package com.fabrice.Exoplanetes.Persistance.vue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fabrice.Exoplanetes.Persistance.Exoplanete;

public class ControleurFenetrePrincipale 
{
	protected FenetrePricipale fenetrePricipale;
	
	private Session session;
	private List<Exoplanete> listeExoplanete;
	
	private PanneauOnglets panneauOnglets;
	
	public ControleurFenetrePrincipale(FenetrePricipale fenetrePricipale)
	{
		this.fenetrePricipale = fenetrePricipale;
		this.panneauOnglets = this.fenetrePricipale.getPanneauOnglets();
		
		Configuration configuration = new Configuration();
		configuration.addClass(com.fabrice.Exoplanetes.Persistance.Exoplanete.class);
		SessionFactory sessionControleur = configuration.buildSessionFactory();
		Session session = sessionControleur.openSession();
		
		this.session = session;
		
		construireListeExoplanette();
	}
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void ecrireLogListeExoplanette()
	{
		Iterator listeExoplanete = this.session.createQuery("from Exoplanete").iterate();
		while(listeExoplanete.hasNext())
		{
			Exoplanete exoplanete = (Exoplanete)listeExoplanete.next();
			System.out.println("Exoplanete : " + exoplanete.getPlanete());
		}
	}
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	private void construireListeExoplanette()
	{
		this.listeExoplanete = new ArrayList<Exoplanete>();
		
		Iterator listeExoplaneteIterator = this.session.createQuery("from Exoplanete").iterate();
		while(listeExoplaneteIterator.hasNext())
		{
			Exoplanete exoplanete = new Exoplanete();
			exoplanete = (Exoplanete)listeExoplaneteIterator.next();
			this.listeExoplanete.add(exoplanete);
		}
		
		panneauOnglets.construirePanneauListeExoplanette(this.listeExoplanete);
		panneauOnglets.revalidate();
	}

}
