package com.fabrice.Exoplanetes.vue;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.fabrice.Exoplanetes.vue.panneau.PanneauOnglets;

@SuppressWarnings("serial")
public class FenetrePricipale extends JFrame
{
	private JPanel panneauPrincipale;
	private PanneauOnglets panneauOnglets;
	
	public FenetrePricipale()
	{
		super();
		
		afficherFenetre();
	}

	private void afficherFenetre() 
	{
		setTitle("Exoplanetes");
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(construireFenetre());
		
		setVisible(true);
	}

	private JPanel construireFenetre() 
	{
		gererPanneaux();
		
		return panneauPrincipale;
	}

	private void gererPanneaux() 
	{
		panneauPrincipale = new JPanel(new GridLayout(1, 1));
		
		panneauOnglets = new PanneauOnglets();
		
		panneauPrincipale.add(panneauOnglets);
	}
	
	public PanneauOnglets getPanneauOnglets()
	{
		return panneauOnglets;
	}
}
