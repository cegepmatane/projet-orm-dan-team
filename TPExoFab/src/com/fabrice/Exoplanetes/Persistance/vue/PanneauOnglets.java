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
	
	private JPanel panneauOngletClient;
	private JPanel panneauOngletAdmin;
	
	private JPanel panneauOngletExoplanette;
	private JPanel panneauOngletMemento;
	private JPanel panneauOngletRecherche;

	private JTabbedPane ongletsClient;
	
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
		
		panneauOngletClient = new JPanel(new GridLayout(1, 1));
		panneauOngletAdmin = new JPanel(new GridLayout(1, 1));
		
		panneauOngletExoplanette = new JPanel();
		panneauOngletMemento = new JPanel();
		panneauOngletRecherche = new JPanel();
		
		ongletsClient = new JTabbedPane();
		ongletsClient.addTab("Exoplanete", panneauOngletExoplanette);
		ongletsClient.addTab("Mémento", panneauOngletMemento);
		ongletsClient.addTab("Recherche", panneauOngletRecherche);
		panneauOngletClient.add(ongletsClient);
		
		onglets.add("Client", panneauOngletClient);
		onglets.add("Admin", panneauOngletAdmin);
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
		
		panneauOngletExoplanette.setLayout(new BorderLayout());
		panneauOngletExoplanette.add(panneauListeExoplanette, BorderLayout.CENTER);
	}
}
