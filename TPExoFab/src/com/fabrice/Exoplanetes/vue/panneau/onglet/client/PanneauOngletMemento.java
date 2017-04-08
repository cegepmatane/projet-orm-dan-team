package com.fabrice.Exoplanetes.vue.panneau.onglet.client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.fabrice.Exoplanetes.Exoplanete;
import com.fabrice.Exoplanetes.orm.ExoplaneteORM;

@SuppressWarnings("serial")
public class PanneauOngletMemento extends JPanel
{
	private JPanel panneauOngletMemento;

	public PanneauOngletMemento()
	{
		super(new GridLayout(1, 1));
		
		construirePanneau();
	}
	
	private void construirePanneau() 
	{
		panneauOngletMemento = new JPanel(new GridLayout(1, 1));
		
		this.add(panneauOngletMemento);
	}

	@SuppressWarnings("rawtypes")
	public void construirePanneauListeExoplanette(List<Exoplanete> listeExoplanette)
	{
		
		Iterator listeExoplaneteIterator = listeExoplanette.iterator();
		
		JPanel panneauListeExoplanette = new JPanel();
		panneauListeExoplanette.setLayout(new GridLayout(listeExoplanette.size(), 1));	
		
		while(listeExoplaneteIterator.hasNext())
		{
			ExoplaneteORM exoplanete = (ExoplaneteORM)listeExoplaneteIterator.next();
			
			JPanel panel = new JPanel();
			JLabel nomExoplanete = new JLabel(exoplanete.getPlanete());
			
			panel.add(nomExoplanete);
			
			panneauListeExoplanette.add(panel);
		}
		
		JScrollPane scrollPane = new JScrollPane(panneauListeExoplanette);
		
		JPanel panelSroll = new JPanel(new BorderLayout());
		panelSroll.add(scrollPane, BorderLayout.CENTER);
		
		panneauOngletMemento.add(panelSroll);
	}
}
