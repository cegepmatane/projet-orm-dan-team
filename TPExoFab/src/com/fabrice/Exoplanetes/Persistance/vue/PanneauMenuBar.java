package com.fabrice.Exoplanetes.Persistance.vue;

import java.awt.GridLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanneauMenuBar extends JPanel
{
	private JPanel panneauMenuBar;
	
	private JMenuBar menuBar;
	
	public PanneauMenuBar()
	{
		super(new GridLayout(1, 1));
		
		construirePanneau();
	}

	private void construirePanneau() 
	{
		panneauMenuBar = new JPanel(new GridLayout(1, 1));
		
		construireMeneBar();
		
		panneauMenuBar.add(menuBar);
		
		this.add(panneauMenuBar);
	}

	private void construireMeneBar() 
	{
		menuBar = new JMenuBar();
		
		JMenuItem itemNouveau= new JMenuItem("Nouveau");
		JMenuItem itemSauvegarde= new JMenuItem("Sauvegarde");
		JMenuItem itemFermeture= new JMenuItem("Fermeture");
		
		menuBar.add(itemNouveau);
		menuBar.add(itemSauvegarde);
		menuBar.add(itemFermeture);
	}
}
