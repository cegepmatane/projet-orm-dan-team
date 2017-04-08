package com.fabrice.Exoplanetes.vue.panneau.onglet.client;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.fabrice.Exoplanetes.vue.panneau.onglet.client.recherche.PanneauOngletRechercheEquipe;

@SuppressWarnings("serial")
public class PanneauOngletRecherche extends JPanel
{
	private JPanel panneauOngletClientRecherche;
	
	private JTabbedPane ongletsClientRecherche;

	private PanneauOngletRechercheEquipe panneauRechercheVadeboncoeur;
	private PanneauOngletRechercheEquipe panneauRechercheTournesol;

	public PanneauOngletRecherche()
	{
		super(new GridLayout(1, 1));
		
		construirePanneau();
	}

	private void construirePanneau() 
	{
		panneauOngletClientRecherche = new JPanel(new GridLayout(1, 1));
		
		construireOnglets();
		
		panneauOngletClientRecherche.add(ongletsClientRecherche);
		
		this.add(panneauOngletClientRecherche);
	}

	private void construireOnglets() 
	{
		ongletsClientRecherche = new JTabbedPane();
		
		panneauRechercheVadeboncoeur = new PanneauOngletRechercheEquipe("Vadeboncoeur");
		panneauRechercheTournesol = new PanneauOngletRechercheEquipe("Tournesol");
		
		ongletsClientRecherche.addTab(panneauRechercheVadeboncoeur.getNomEquipe(), panneauRechercheVadeboncoeur);
		ongletsClientRecherche.addTab(panneauRechercheTournesol.getNomEquipe(), panneauRechercheTournesol);
	}
}
