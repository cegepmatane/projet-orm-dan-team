package com.fabrice.Exoplanetes.Persistance.vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import com.fabrice.Exoplanetes.Persistance.Exoplanete;

@SuppressWarnings("serial")
public class PanneauOnglets extends JPanel
{
	private JPanel panneauOnglets;
	
	private JTabbedPane onglets;
	
	private JPanel ongletExoplanette;
	private JPanel ongletSauvegarde;
	private JPanel ongletRecherche;
	
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
		
		ongletExoplanette = new JPanel();
		ongletSauvegarde = new JPanel();
		ongletRecherche = new JPanel();
		
		onglets.addTab("Exoplanete", ongletExoplanette);
		onglets.addTab("Sauvegarde", ongletSauvegarde);
		onglets.addTab("Recherche", ongletRecherche);
	}
	
	@SuppressWarnings("rawtypes")
	public void construirePanneauListeExoplanette(List<Exoplanete> listeExoplanette)
	{Iterator listeExoplaneteIterator = listeExoplanette.iterator();
		
		Object nomDeCologne[] = {
				"Planete",
				"Étoile"
		};
		Object[][]  donnees= new Object[listeExoplanette.size()][2];
		
		int conpteur = 0;
		while(listeExoplaneteIterator.hasNext())
		{
			Exoplanete exoplanete = (Exoplanete)listeExoplaneteIterator.next();
			donnees[conpteur][0] = exoplanete.getPlanete();
			donnees[conpteur][1] = exoplanete.getEtoile();
			conpteur++;
		}
		
		//TODO: faire une class panneauListeExoplanette
		JPanel panneauListeExoplanette = new JPanel(new BorderLayout());
		
		JTable table = new JTable(donnees, nomDeCologne);
		JScrollPane scrollPane = new JScrollPane(table);
		
		panneauListeExoplanette.add(scrollPane, BorderLayout.CENTER);
		
		ongletExoplanette.setLayout(new BorderLayout());
		ongletExoplanette.add(panneauListeExoplanette, BorderLayout.CENTER);
	}
}
