package com.fabrice.Exoplanetes.vue.panneau.onglet.client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.fabrice.Exoplanetes.Exoplanete;
import com.fabrice.Exoplanetes.orm.ExoplaneteORM;

@SuppressWarnings("serial")
public class PanneauOngletExoplanette extends JPanel
{
	private JPanel panneauOngletExoplanette;
	
	public PanneauOngletExoplanette()
	{
		super(new GridLayout(1, 1));
		
		construirePanneau();
	}

	private void construirePanneau() 
	{
		panneauOngletExoplanette = new JPanel(new GridLayout(1, 1));
		
		this.add(panneauOngletExoplanette);
	}
	
	@SuppressWarnings("rawtypes")
	public void construirePanneauListeExoplanette(List<ExoplaneteORM> listeExoplanette)
	{
		Iterator listeExoplaneteIterator = listeExoplanette.iterator();
		
		JPanel panneauListeExoplanette = new JPanel();
		panneauListeExoplanette.setLayout(new GridLayout(listeExoplanette.size(), 1));	
		
		while(listeExoplaneteIterator.hasNext())
		{
			Exoplanete exoplanete = (Exoplanete)listeExoplaneteIterator.next();
			
			JPanel panel = new JPanel();
			JLabel nomExoplanete = new JLabel(exoplanete.getPlanete());
			JButton buttonSauvegarder = new JButton("Save");
			
			panel.add(nomExoplanete);
			panel.add(buttonSauvegarder);
			
			panneauListeExoplanette.add(panel);
		}
		
		JScrollPane scrollPane = new JScrollPane(panneauListeExoplanette);
		
		JPanel panelSroll = new JPanel(new BorderLayout());
		panelSroll.add(scrollPane, BorderLayout.CENTER);
		
		panneauOngletExoplanette.add(panelSroll);
	}
}
