package com.fabrice.Exoplanetes.vue.panneau.onglet;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.fabrice.Exoplanetes.vue.panneau.onglet.admin.PanneauOngletAdminAjouter;
import com.fabrice.Exoplanetes.vue.panneau.onglet.admin.PanneauOngletAdminEffacer;
import com.fabrice.Exoplanetes.vue.panneau.onglet.admin.PanneauOngletAdminModifier;

@SuppressWarnings("serial")
public class PanneauOngletAdmin extends JPanel
{
	private JPanel panneauOngletAdmin;
	private JTabbedPane onglets;
	private PanneauOngletAdminAjouter panneauOngletAdminAjouter;
	private PanneauOngletAdminEffacer panneauOngletAdminEffacer;
	private PanneauOngletAdminModifier panneauOngletAdminModifier;

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
		panneauOngletAdminModifier = new PanneauOngletAdminModifier();
		
		onglets.add("Ajouter", panneauOngletAdminAjouter);
		onglets.add("Modifier", panneauOngletAdminModifier);
		onglets.add("Effacer", panneauOngletAdminEffacer);
	}
	
	public PanneauOngletAdminAjouter getPanneauOngletAdminAjouter() 
	{
		return panneauOngletAdminAjouter;
	}

	public PanneauOngletAdminEffacer getPanneauOngletAdminEffacer() 
	{
		return panneauOngletAdminEffacer;
	}

	public PanneauOngletAdminModifier getPanneauOngletAdminModifier() 
	{
		return panneauOngletAdminModifier;
	}
}
