package com.fabrice.Exoplanetes.vue.panneau;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.fabrice.Exoplanetes.orm.Exoplanete;
import com.fabrice.Exoplanetes.vue.panneau.onglet.PanneauOngletAdmin;
import com.fabrice.Exoplanetes.vue.panneau.onglet.PanneauOngletClient;
import com.fabrice.Exoplanetes.vue.panneau.onglet.client.PanneauOngletExoplanette;

@SuppressWarnings("serial")
public class PanneauOnglets extends JPanel
{
	private JPanel panneauOnglets;
	private JTabbedPane onglets;
	private PanneauOngletClient panneauOngletClient;
	private PanneauOngletAdmin panneauOngletAdmin;
	
	public PanneauOnglets()
	{
		super(new GridLayout(1, 1));
		
		construirePanneau();
	}
	
	private void construirePanneau() 
	{
		panneauOnglets = new JPanel(new GridLayout(1, 1));
		
		construireOnglets();
		
		panneauOnglets.add(onglets);
		
		this.add(panneauOnglets);
	}

	private void construireOnglets() 
	{
		onglets = new JTabbedPane();
		
		panneauOngletClient = new PanneauOngletClient();
		panneauOngletAdmin = new PanneauOngletAdmin();
		
		onglets.add("Client", panneauOngletClient);
		onglets.add("Admin", panneauOngletAdmin);
	}
	
	public void construirePanneauListeExoplanette(List<Exoplanete> listeExoplanette)
	{
		PanneauOngletExoplanette panneauOngletExoplanette = panneauOngletClient.getPanneauOngletExoplanette();
		
		panneauOngletExoplanette.construirePanneauListeExoplanette(listeExoplanette);
	}
}
