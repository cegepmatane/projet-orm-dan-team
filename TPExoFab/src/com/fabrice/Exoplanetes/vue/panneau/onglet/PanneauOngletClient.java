package com.fabrice.Exoplanetes.vue.panneau.onglet;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.fabrice.Exoplanetes.vue.panneau.onglet.client.PanneauOngletExoplanette;
import com.fabrice.Exoplanetes.vue.panneau.onglet.client.PanneauOngletMemento;
import com.fabrice.Exoplanetes.vue.panneau.onglet.client.PanneauOngletRecherche;

@SuppressWarnings("serial")
public class PanneauOngletClient extends JPanel
{
	private JPanel panneauOngletClient;
	
	private JTabbedPane ongletsClient;

	private PanneauOngletExoplanette panneauOngletExoplanette;
	private PanneauOngletMemento panneauOngletMemento;
	private PanneauOngletRecherche panneauOngletRecherche;

	public PanneauOngletClient()
	{
		super(new GridLayout(1, 1));
		
		construirePanneau();
	}

	private void construirePanneau() 
	{
		panneauOngletClient = new JPanel(new GridLayout(1, 1));
		
		construireOnglets();
		
		panneauOngletClient.add(ongletsClient);
		
		this.add(panneauOngletClient);
	}

	private void construireOnglets() 
	{
		ongletsClient = new JTabbedPane();
		
		panneauOngletExoplanette = new PanneauOngletExoplanette();
		panneauOngletMemento = new PanneauOngletMemento();
		panneauOngletRecherche = new PanneauOngletRecherche();
		
		ongletsClient.addTab("Exoplanete", panneauOngletExoplanette);
		ongletsClient.addTab("Mémento", panneauOngletMemento);
		ongletsClient.addTab("Recherche", panneauOngletRecherche);
	}
	
	public PanneauOngletExoplanette getPanneauOngletExoplanette() 
	{
		return panneauOngletExoplanette;
	}

	public PanneauOngletMemento getPanneauOngletMemento() 
	{
		return panneauOngletMemento;
	}

	public PanneauOngletRecherche getPanneauOngletRecherche() 
	{
		return panneauOngletRecherche;
	}
}
