package com.fabrice.Exoplanetes.vue;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fabrice.Exoplanetes.Exoplanete;
import com.fabrice.Exoplanetes.orm.ExoplaneteORM;
import com.fabrice.Exoplanetes.persistance.ExoplaneteMemento;
import com.fabrice.Exoplanetes.persistance.ExoplanetePersistance;
import com.fabrice.Exoplanetes.vue.panneau.PanneauOnglets;

public class ControleurFenetrePrincipale 
{
	protected FenetrePricipale fenetrePricipale;
	
	private Session session;
	private List<ExoplaneteORM> listeExoplaneteORM;
	private List<Exoplanete> listeExoplanete;
	
	private PanneauOnglets panneauOnglets;
	
	public ControleurFenetrePrincipale(FenetrePricipale fenetrePricipale) throws Exception
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
		initialiserListeMemento();
		
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
	private void construireListeExoplanette() throws Exception
	{
		this.listeExoplaneteORM = new ArrayList<ExoplaneteORM>();
		
		Iterator listeExoplaneteIterator = this.session.createQuery("from ExoplaneteORM").iterate();
		while(listeExoplaneteIterator.hasNext())
		{
			ExoplaneteORM exoplanete = new ExoplaneteORM();
			
			exoplanete = (ExoplaneteORM) listeExoplaneteIterator.next();
			this.listeExoplaneteORM.add(exoplanete);
		}
		
		panneauOnglets.construirePanneauxListeExoplanette(this.listeExoplaneteORM);
		panneauOnglets.revalidate();
	}
	
	private void initialiserListeMemento() throws Exception
	{
		listeExoplanete = new ArrayList<Exoplanete>();
		
		File dossier = new File("src/sauvegardes/");
		File[] dossierListe = dossier.listFiles();
		for (File fichier : dossierListe) 
		{
			try
			{
				Exoplanete fileExoplanete = ExoplanetePersistance.read(fichier.getName());
				ExoplaneteMemento exoplaneteMemento = new ExoplaneteMemento(fileExoplanete);
				//memorisation.ajouterMemento(new Date().getTime(), exoplanetePersistance);
				System.out.println(" Exo : " + exoplaneteMemento.getExoplanete().getEtoile());
				listeExoplanete.add(exoplaneteMemento.getExoplanete());
			}
			catch (Exception e) 
			{
				// TODO: handle exception
			}
			
		}
		
		construitreOngletMemento(listeExoplanete);
	}
	
	private void construitreOngletMemento(List<Exoplanete> listeExoplanete)
	{
		panneauOnglets.construitrePanneauOngletMemento(listeExoplanete);
	}

}
