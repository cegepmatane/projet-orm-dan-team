package com.fabrice.Exoplanetes.vue.panneau.onglet;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.fabrice.Exoplanetes.vue.panneau.onglet.admin.PanneauOngletAdminAjouter;
import com.fabrice.Exoplanetes.vue.panneau.onglet.admin.PanneauOngletAdminEffacer;

@SuppressWarnings("serial")
public class PanneauOngletAdmin extends JPanel
{
	private JPanel panneauOngletAdmin;
	private JTabbedPane onglets;
	private PanneauOngletAdminAjouter panneauOngletAdminAjouter;
	private PanneauOngletAdminEffacer panneauOngletAdminEffacer;
	
	public PanneauOngletAdmin()
	{
		super(new GridLayout(1, 1));
		
		construirePanneau();
	}
	
	private void construirePanneau() 
	{
		panneauOngletAdmin = new JPanel(new GridLayout(1, 1));
		
		construireOnglets();
		
		panneauOngletAdmin.add(onglets);
		
		this.add(panneauOngletAdmin);
	}

	private void construireOnglets() 
	{
		onglets = new JTabbedPane();
		
		panneauOngletAdminAjouter = new PanneauOngletAdminAjouter();
		panneauOngletAdminEffacer = new PanneauOngletAdminEffacer();
		
		onglets.add("Ajouter", panneauOngletAdminAjouter);
		onglets.add("Effacer", panneauOngletAdminEffacer);
	}
}
