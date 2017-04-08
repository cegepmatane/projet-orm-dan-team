package com.fabrice.Exoplanetes.vue.panneau;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.fabrice.Exoplanetes.Exoplanete;
import com.fabrice.Exoplanetes.orm.ExoplaneteORM;
import com.fabrice.Exoplanetes.vue.panneau.onglet.PanneauOngletAdmin;
import com.fabrice.Exoplanetes.vue.panneau.onglet.PanneauOngletClient;
import com.fabrice.Exoplanetes.vue.panneau.onglet.admin.PanneauOngletAdminEffacer;
import com.fabrice.Exoplanetes.vue.panneau.onglet.admin.PanneauOngletAdminModifier;
import com.fabrice.Exoplanetes.vue.panneau.onglet.client.PanneauOngletExoplanette;
import com.fabrice.Exoplanetes.vue.panneau.onglet.client.PanneauOngletMemento;

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
	
	public void construirePanneauxListeExoplanette(List<ExoplaneteORM> listeExoplanette)
	{
		PanneauOngletExoplanette panneauOngletExoplanette = panneauOngletClient.getPanneauOngletExoplanette();
		PanneauOngletAdminEffacer panneauOngletAdminEffacer = panneauOngletAdmin.getPanneauOngletAdminEffacer();
		PanneauOngletAdminModifier panneauOngletAdminModifier = panneauOngletAdmin.getPanneauOngletAdminModifier();
		
		panneauOngletExoplanette.construirePanneauListeExoplanette(listeExoplanette);
		
		panneauOngletAdminEffacer.ConstruirePanneauListeExoplanette(listeExoplanette);
		panneauOngletAdminModifier.ConstruirePanneauListeExoplanette(listeExoplanette);
	}
	
	public void construitrePanneauOngletMemento(List<Exoplanete> listeExoplanette)
	{
		PanneauOngletMemento panneauOngletMemento = panneauOngletClient.getPanneauOngletMemento();
		
		panneauOngletMemento.construirePanneauListeExoplanette(listeExoplanette);
	}
}
