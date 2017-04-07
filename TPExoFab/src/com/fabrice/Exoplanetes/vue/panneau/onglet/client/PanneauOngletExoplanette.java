package com.fabrice.Exoplanetes.vue.panneau.onglet.client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.fabrice.Exoplanetes.orm.Exoplanete;

@SuppressWarnings("serial")
public class PanneauOngletExoplanette extends JPanel
{
	private JPanel panneauOngletExoplanette;
	private JTable table;
	
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
	public void construirePanneauListeExoplanette(List<Exoplanete> listeExoplanette)
	{
		Iterator listeExoplaneteIterator = listeExoplanette.iterator();
		
		Object nomDeCologne[] = {
				"Planete",
				"Étoile"
		};
		Object[][]  donnees= new Object[listeExoplanette.size()][3];
		
		int compteur = 0;
		while(listeExoplaneteIterator.hasNext())
		{
			Exoplanete exoplanete = (Exoplanete)listeExoplaneteIterator.next();
			donnees[compteur][0] = exoplanete.getPlanete();
			donnees[compteur][1] = exoplanete.getEtoile();
			compteur++;
		}
		
		//TODO: faire une class panneauListeExoplanette
		JPanel panneauListeExoplanette = new JPanel(new BorderLayout());
		
		table = new JTable(donnees, nomDeCologne);
		
		table.addMouseListener(new Click());
		//table.isCellEditable(row, column)
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		panneauListeExoplanette.add(scrollPane, BorderLayout.CENTER);
		
		panneauOngletExoplanette.setLayout(new BorderLayout());
		panneauOngletExoplanette.add(panneauListeExoplanette, BorderLayout.CENTER);
	}
	
	class Click extends MouseAdapter
	{
        public void mouseClicked(MouseEvent e) 
        {
            if(e.getClickCount()==1)
            {
            	System.out.println(table.getSelectedRow());
            }
        }
    }
}
