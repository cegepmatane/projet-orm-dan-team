package com.fabrice.Exoplanetes.vue.panneau.onglet.admin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fabrice.Exoplanetes.orm.ExoplaneteORM;

@SuppressWarnings("serial")
public class PanneauOngletAdminAjouter extends JPanel
{
	private JPanel panneauOngletAdminAjouter;
	private JPanel panneauAjouterExoplanete;
	
	private JLabel labelPlanete;
	private JLabel labelEtoile;
	private JLabel labelMasse;
	private JLabel labelRayon;
	private JLabel labelFlux;
	private JLabel labelTemperature;
	private JLabel labelPeriode;
	private JLabel labelDistance;
	private JLabel labelZone;
	private JLabel labelsph;
	private JLabel labelhzd;
	private JLabel labelhza;
	private JLabel labelist;
	private JLabel labelhzc;
	private JLabel labelpClasse;
	private JLabel labelhClasse;
	private JLabel labelphi;
	private JLabel labelStatus;
	private JLabel labelDecouverte;
	private JButton boutonEnregistrer;

	private JTextField textPlanet;
	private JTextField textEtoile;
	private JTextField textMasse;
	private JTextField textRayon;
	private JTextField textFlux;
	private JTextField textTemperature;
	private JTextField textPeriode;
	private JTextField textDistance;
	private JTextField textZone;
	private JTextField Textist;
	private JTextField Textsph;
	private JTextField Texthzd;
	private JTextField Texthzc;
	private JTextField Texthza;
	private JTextField TextpClasse;
	private JTextField TexthClasse;
	private JTextField Textphi;
	private JTextField TextStatus;
	private JTextField TextDecouverte;
	
	public PanneauOngletAdminAjouter()
	{
		super(new GridLayout(1, 1));
		
		construirePanneau();
	}

	private void construirePanneau() 
	{
		panneauOngletAdminAjouter = new JPanel(new GridLayout(1, 1));
		
		construirePanneauAjouter();
		
		this.add(panneauOngletAdminAjouter);
	}

	private void construirePanneauAjouter() 
	{
		panneauAjouterExoplanete = new JPanel();
		panneauAjouterExoplanete.setLayout(new GridLayout(37, 1));
		
		labelPlanete  = new JLabel("Planete : ");
		textPlanet = new JTextField();
		
		labelEtoile  = new JLabel("Etoile : ");
		textEtoile = new JTextField();
		
		labelMasse  = new JLabel("Masse : ");
		textMasse = new JTextField();
		
		labelRayon  = new JLabel("Rayon : ");
		textRayon = new JTextField();
		
		labelFlux = new JLabel("Flux : ");
		textFlux= new JTextField();
		
		labelTemperature = new JLabel("Temperature : ");
		textTemperature= new JTextField();
		
		labelPeriode = new JLabel("Periode : ");
		textPeriode = new JTextField();
		
		labelDistance = new JLabel("Distance : ");
		textDistance = new JTextField();
		
		labelZone = new JLabel("Zone : ");
		textZone = new JTextField();
		
		labelist = new JLabel("ist : ");
		Textist = new JTextField();
		
		labelsph = new JLabel("sph : ");
		Textsph = new JTextField();
		
		labelhzd = new JLabel("hzd : ");
		Texthzd = new JTextField();
		
		labelhzc = new JLabel("hzc : ");
		Texthzc = new JTextField();
		
		labelhza = new JLabel("hza : ");
		Texthza = new JTextField();
		
		labelpClasse = new JLabel("pClasse : ");
		TextpClasse = new JTextField();
		
		labelhClasse = new JLabel("hClasse : ");
		TexthClasse = new JTextField();
		
		labelphi = new JLabel("phi : ");
		Textphi = new JTextField();
		
		labelStatus = new JLabel("Status : ");
		TextStatus = new JTextField();
		
		labelDecouverte = new JLabel("Decouverte : ");
		TextDecouverte = new JTextField();
		
		boutonEnregistrer = new JButton("Enregistrer");
		boutonEnregistrer.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Configuration configuration = new Configuration();
				configuration.addClass(com.fabrice.Exoplanetes.orm.ExoplaneteORM.class);
				SessionFactory sessionControleur = configuration.buildSessionFactory();
				Session session = sessionControleur.openSession();
				
				ExoplaneteORM exoplanete = new ExoplaneteORM();
				exoplanete.setPlanete(textPlanet.getText());
				exoplanete.setEtoile(textEtoile.getText());
				exoplanete.setMasse(textMasse.getText());
				exoplanete.setRayon(textRayon.getText());
				
				session.save(exoplanete);
				
				session.close();
				sessionControleur.close();
			}
		});
		
		panneauAjouterExoplanete.add(labelPlanete);
		panneauAjouterExoplanete.add(textPlanet);
		
		panneauAjouterExoplanete.add(labelEtoile);
		panneauAjouterExoplanete.add(textEtoile);
		
		panneauAjouterExoplanete.add(labelMasse);
		panneauAjouterExoplanete.add(textMasse);
		
		panneauAjouterExoplanete.add(labelRayon);
		panneauAjouterExoplanete.add(textRayon);
		
		panneauAjouterExoplanete.add(labelFlux);
		panneauAjouterExoplanete.add(textFlux);
		
		panneauAjouterExoplanete.add(labelTemperature);
		panneauAjouterExoplanete.add(textTemperature);
		
		panneauAjouterExoplanete.add(labelPeriode);
		panneauAjouterExoplanete.add(textPeriode);
		
		panneauAjouterExoplanete.add(labelDistance);
		panneauAjouterExoplanete.add(textDistance);
		
		panneauAjouterExoplanete.add(labelZone);
		panneauAjouterExoplanete.add(textZone);
		
		panneauAjouterExoplanete.add(labelist);
		panneauAjouterExoplanete.add(Textist);
		
		panneauAjouterExoplanete.add(labelsph);
		panneauAjouterExoplanete.add(Textsph);
		
		panneauAjouterExoplanete.add(labelhzd);
		panneauAjouterExoplanete.add(Texthzd);
		
		panneauAjouterExoplanete.add(labelhzc);
		panneauAjouterExoplanete.add(Texthzc);
		
		panneauAjouterExoplanete.add(labelhza);
		panneauAjouterExoplanete.add(Texthza);
		
		panneauAjouterExoplanete.add(labelpClasse);
		panneauAjouterExoplanete.add(TextpClasse);
		
		panneauAjouterExoplanete.add(labelhClasse);
		panneauAjouterExoplanete.add(TexthClasse);
		
		panneauAjouterExoplanete.add(labelphi);
		panneauAjouterExoplanete.add(Textphi);
		
		panneauAjouterExoplanete.add(labelStatus);
		panneauAjouterExoplanete.add(TextStatus);
		
		panneauAjouterExoplanete.add(labelDecouverte);
		panneauAjouterExoplanete.add(TextDecouverte);
		
		panneauAjouterExoplanete.add(boutonEnregistrer);
		
		JScrollPane scrollPane = new JScrollPane(panneauAjouterExoplanete);
		panneauOngletAdminAjouter.add(scrollPane);
	}
	
	
}
