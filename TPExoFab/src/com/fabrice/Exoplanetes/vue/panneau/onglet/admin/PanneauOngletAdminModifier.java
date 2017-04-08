package com.fabrice.Exoplanetes.vue.panneau.onglet.admin;

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

import com.fabrice.Exoplanetes.orm.ExoplaneteORM;
import com.fabrice.Exoplanetes.vue.FenetreExoplaneteAdminModifier;

@SuppressWarnings("serial")
public class PanneauOngletAdminModifier extends JPanel
{
	private JPanel panneauOngletAdminModier;

	public PanneauOngletAdminModifier()
	{
		super(new GridLayout(1, 1));
		construirePanneau();
	}
	
	private void construirePanneau() 
	{
		panneauOngletAdminModier = new JPanel(new GridLayout(1, 1));
		
		this.add(panneauOngletAdminModier);	
	}

	@SuppressWarnings("rawtypes")
	public void ConstruirePanneauListeExoplanette(List<ExoplaneteORM> listeExoplanette)
	{
		Iterator listeExoplaneteIterator = listeExoplanette.iterator();
		
		JPanel panneauListeExoplanette = new JPanel();
		panneauListeExoplanette.setLayout(new GridLayout(listeExoplanette.size(), 1));	
		
		while(listeExoplaneteIterator.hasNext())
		{
			ExoplaneteORM exoplanete = (ExoplaneteORM)listeExoplaneteIterator.next();
			
			JPanel panel = new JPanel();
			JLabel nomExoplanete = new JLabel(exoplanete.getPlanete());
			JButton buttonModifier = new JButton("Modifier");
			buttonModifier.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					//System.out.println("Modifier : " + exoplanete.getPlanete());
					@SuppressWarnings("unused")
					FenetreExoplaneteAdminModifier fenetreExoplaneteAdminModifier = new FenetreExoplaneteAdminModifier(exoplanete);
				}
			});
			
			panel.add(nomExoplanete);
			panel.add(buttonModifier);
			
			panneauListeExoplanette.add(panel);
		}
		
		JScrollPane scrollPane = new JScrollPane(panneauListeExoplanette);
		
		JPanel panelSroll = new JPanel(new BorderLayout());
		panelSroll.add(scrollPane, BorderLayout.CENTER);
		
		panneauOngletAdminModier.add(panelSroll);
	}
}
