package com.fabrice.Exoplanetes.vue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fabrice.Exoplanetes.orm.ExoplaneteORM;
import com.fabrice.Exoplanetes.vue.panneau.PanneauOnglets;

public class ControleurFenetrePrincipale 
{
	protected FenetrePricipale fenetrePricipale;
	
	private Session session;
	private List<ExoplaneteORM> listeExoplanete;
	
	private PanneauOnglets panneauOnglets;
	
	public ControleurFenetrePrincipale(FenetrePricipale fenetrePricipale)
	{
		this.fenetrePricipale = fenetrePricipale;
		this.panneauOnglets = this.fenetrePricipale.getPanneauOnglets();
		
		//TODO: a voir, créeer class pour Confiration
		Configuration configuration = new Configuration();
		configuration.addClass(com.fabrice.Exoplanetes.orm.ExoplaneteORM.class);
		SessionFactory sessionControleur = configuration.buildSessionFactory();
		Session session = sessionControleur.openSession();
		
		this.session = session;
		
		construireListeExoplanette();
		//ecrireLogListeExoplanette();
		
		session.close();
		sessionControleur.close();
	}
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void ecrireLogListeExoplanette()
	{
		Iterator listeExoplanete = this.session.createQuery("from ExoplaneteORM").iterate();
		while(listeExoplanete.hasNext())
		{
			ExoplaneteORM exoplanete = (ExoplaneteORM)listeExoplanete.next();
			System.out.println("Exoplanete : " + exoplanete.getPlanete());
		}
	}
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	private void construireListeExoplanette()
	{
		this.listeExoplanete = new ArrayList<ExoplaneteORM>();
		
		Iterator listeExoplaneteIterator = this.session.createQuery("from ExoplaneteORM").iterate();
		while(listeExoplaneteIterator.hasNext())
		{
			ExoplaneteORM exoplanete = new ExoplaneteORM();
			
			exoplanete = (ExoplaneteORM) listeExoplaneteIterator.next();
			this.listeExoplanete.add(exoplanete);
		}
		
		panneauOnglets.construirePanneauxListeExoplanette(this.listeExoplanete);
		panneauOnglets.revalidate();
	}

}
