package com.fabrice.Exoplanetes.vue.panneau.onglet.client.recherche;

import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanneauOngletRechercheEquipe extends JPanel
{
	private JPanel panneauOngletClientRechercheEquipe;
	private String nomEquipe;

	public PanneauOngletRechercheEquipe(String nomEquipe)
	{
		super(new GridLayout(1, 1));
		
		this.nomEquipe = nomEquipe;
		
		construirePanneau();
	}

	private void construirePanneau() 
	{
		panneauOngletClientRechercheEquipe = new JPanel(new GridLayout(1, 1));
		
		
		
		this.add(panneauOngletClientRechercheEquipe);
	}
	
	public String getNomEquipe() 
	{
		return nomEquipe;
	}
}
