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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.fabrice.Exoplanetes.Exoplanete;
import com.fabrice.Exoplanetes.orm.ExoplaneteORM;

@SuppressWarnings("serial")
public class PanneauOngletAdminEffacer extends JPanel
{
	private JPanel panneauOngletAdminEffacer;

	public PanneauOngletAdminEffacer()
	{
		super(new GridLayout(1, 1));
		
		construirePanneau();
	}

	private void construirePanneau() 
	{
		panneauOngletAdminEffacer = new JPanel(new GridLayout(1, 1));
		
		this.add(panneauOngletAdminEffacer);	
	}
	
	@SuppressWarnings("rawtypes")
	public void ConstruirePanneauListeExoplanette(List<ExoplaneteORM> listeExoplanette)
	{
		Iterator listeExoplaneteIterator = listeExoplanette.iterator();
		
		JPanel panneauListeExoplanette = new JPanel();
		panneauListeExoplanette.setLayout(new GridLayout(listeExoplanette.size(), 1));	
		
		while(listeExoplaneteIterator.hasNext())
		{
			Exoplanete exoplanete = (Exoplanete)listeExoplaneteIterator.next();
			
			JPanel panel = new JPanel();
			JLabel nomExoplanete = new JLabel(exoplanete.getPlanete());
			JButton buttonEffacer = new JButton("Effacer");
			buttonEffacer.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					Configuration configuration = new Configuration();
					configuration.addClass(com.fabrice.Exoplanetes.orm.ExoplaneteORM.class);
					SessionFactory sessionControleur = configuration.buildSessionFactory();
					Session session = sessionControleur.openSession();
					
					Transaction transaction = session.beginTransaction();
					session.delete(exoplanete);
					transaction.commit();
					
					/*List<ExoplaneteORM> listeExoplanete = new ArrayList<ExoplaneteORM>();
					
					Iterator listeExoplaneteIterator = session.createQuery("from ExoplaneteORM").iterate();
					while(listeExoplaneteIterator.hasNext())
					{
						ExoplaneteORM exoplanete = new ExoplaneteORM();
						
						exoplanete = (ExoplaneteORM) listeExoplaneteIterator.next();
						listeExoplanete.add(exoplanete);
						construirePanneau();
						ConstruirePanneauListeExoplanette(listeExoplanette);
						
					}*/
					
					session.close();
					sessionControleur.close();
				}
			});
			
			panel.add(nomExoplanete);
			panel.add(buttonEffacer);
			
			panneauListeExoplanette.add(panel);
		}
		
		JScrollPane scrollPane = new JScrollPane(panneauListeExoplanette);
		
		JPanel panelSroll = new JPanel(new BorderLayout());
		panelSroll.add(scrollPane, BorderLayout.CENTER);
		
		panneauOngletAdminEffacer.add(panelSroll);
	}
}
