package com.fabrice.Exoplanetes.vue;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.fabrice.Exoplanetes.orm.ExoplaneteORM;

@SuppressWarnings("serial")
public class FenetreExoplaneteAdminModifier extends JDialog
{
	private ExoplaneteORM exoplaneteORM;
	private JPanel panneauPrincipaleAdminModier;
	private JPanel panneauExoplaneteDetail;
	private JLabel labelPlanete;
	private JTextField textPlanet;
	private JLabel labelEtoile;
	private JTextField textEtoile;
	private JTextField textMasse;
	private JLabel labelMasse;
	private JLabel labelRayon;
	private JTextField textRayon;
	private JLabel labelFlux;
	private JTextField textFlux;
	private JLabel labelTemperature;
	private JTextField textTemperature;
	private JTextField textPeriode;
	private JLabel labelPeriode;
	private JLabel labelDistance;
	private JTextField textDistance;
	private JLabel labelZone;
	private JTextField textZone;
	private JLabel labelist;
	private JTextField Textist;
	private JLabel labelsph;
	private JTextField Textsph;
	private JLabel labelhzd;
	private JTextField Texthzd;
	private JLabel labelhzc;
	private JTextField Texthzc;
	private JTextField Texthza;
	private JLabel labelhza;
	private JTextField TextpClasse;
	private JLabel labelpClasse;
	private JLabel labelhClasse;
	private JTextField TexthClasse;
	private JLabel labelphi;
	private JTextField Textphi;
	private JLabel labelStatus;
	private JTextField TextStatus;
	private JTextField TextDecouverte;
	private JLabel labelDecouverte;
	private JButton boutonEnregistrer;
	
	public FenetreExoplaneteAdminModifier(ExoplaneteORM exoplanete) 
	{
		super();
		this.exoplaneteORM = exoplanete;
		
		afficherFenetre();
	}

	private void afficherFenetre() 
	{
		setTitle("Modifier : " + exoplaneteORM.getPlanete());
		setSize(500, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setContentPane(construireFenetre());
		
		setVisible(true);
	}

	private JPanel construireFenetre() 
	{
		panneauPrincipaleAdminModier = new JPanel(new GridLayout(1, 1));
		
		gererPanneaux();
		
		return panneauPrincipaleAdminModier;
	}

	private void gererPanneaux() 
	{
		panneauPrincipaleAdminModier = new JPanel(new GridLayout(1, 1));
		
		panneauExoplaneteDetail = new JPanel();
		panneauExoplaneteDetail.setLayout(new GridLayout(37, 1));
		
		labelPlanete  = new JLabel("Planete : ");
		textPlanet = new JTextField(exoplaneteORM.getPlanete());
		
		labelEtoile  = new JLabel("Etoile : ");
		textEtoile = new JTextField(exoplaneteORM.getEtoile());
		
		labelMasse  = new JLabel("Masse : ");
		textMasse = new JTextField(exoplaneteORM.getMasse());
		
		labelRayon  = new JLabel("Rayon : ");
		textRayon = new JTextField(exoplaneteORM.getRayon());
		
		labelFlux = new JLabel("Flux : ");
		textFlux= new JTextField(exoplaneteORM.getFlux());
		
		labelTemperature = new JLabel("Temperature : ");
		textTemperature= new JTextField(exoplaneteORM.getTemperature());
		
		labelPeriode = new JLabel("Periode : ");
		textPeriode = new JTextField(exoplaneteORM.getPeriode());
		
		labelDistance = new JLabel("Distance : ");
		textDistance = new JTextField(exoplaneteORM.getDistance());
		
		labelZone = new JLabel("Zone : ");
		textZone = new JTextField(exoplaneteORM.getZone());
		
		labelist = new JLabel("ist : ");
		Textist = new JTextField(exoplaneteORM.getIst());
		
		labelsph = new JLabel("sph : ");
		Textsph = new JTextField(exoplaneteORM.getSph());
		
		labelhzd = new JLabel("hzd : ");
		Texthzd = new JTextField(exoplaneteORM.getHzd());
		
		labelhzc = new JLabel("hzc : ");
		Texthzc = new JTextField(exoplaneteORM.getHzc());
		
		labelhza = new JLabel("hza : ");
		Texthza = new JTextField(exoplaneteORM.getHza());
		
		labelpClasse = new JLabel("pClasse : ");
		TextpClasse = new JTextField(exoplaneteORM.getpClasse());
		
		labelhClasse = new JLabel("hClasse : ");
		TexthClasse = new JTextField(exoplaneteORM.gethClasse());
		
		labelphi = new JLabel("phi : ");
		Textphi = new JTextField(exoplaneteORM.getPhi());
		
		labelStatus = new JLabel("Status : ");
		TextStatus = new JTextField(exoplaneteORM.getStatus());
		
		labelDecouverte = new JLabel("Decouverte : ");
		TextDecouverte = new JTextField(exoplaneteORM.getDecouverte());
		
		boutonEnregistrer = new JButton("Modifier");
		/*boutonEnregistrer.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Configuration configuration = new Configuration();
				configuration.addClass(com.fabrice.Exoplanetes.orm.ExoplaneteORM.class);
				SessionFactory sessionControleur = configuration.buildSessionFactory();
				Session session = sessionControleur.openSession();
				
				
			}
		});*/
		
		panneauExoplaneteDetail.add(labelPlanete);
		panneauExoplaneteDetail.add(textPlanet);
		
		panneauExoplaneteDetail.add(labelEtoile);
		panneauExoplaneteDetail.add(textEtoile);
		
		panneauExoplaneteDetail.add(labelMasse);
		panneauExoplaneteDetail.add(textMasse);
		
		panneauExoplaneteDetail.add(labelRayon);
		panneauExoplaneteDetail.add(textRayon);
		
		panneauExoplaneteDetail.add(labelFlux);
		panneauExoplaneteDetail.add(textFlux);
		
		panneauExoplaneteDetail.add(labelTemperature);
		panneauExoplaneteDetail.add(textTemperature);
		
		panneauExoplaneteDetail.add(labelPeriode);
		panneauExoplaneteDetail.add(textPeriode);
		
		panneauExoplaneteDetail.add(labelDistance);
		panneauExoplaneteDetail.add(textDistance);
		
		panneauExoplaneteDetail.add(labelZone);
		panneauExoplaneteDetail.add(textZone);
		
		panneauExoplaneteDetail.add(labelist);
		panneauExoplaneteDetail.add(Textist);
		
		panneauExoplaneteDetail.add(labelsph);
		panneauExoplaneteDetail.add(Textsph);
		
		panneauExoplaneteDetail.add(labelhzd);
		panneauExoplaneteDetail.add(Texthzd);
		
		panneauExoplaneteDetail.add(labelhzc);
		panneauExoplaneteDetail.add(Texthzc);
		
		panneauExoplaneteDetail.add(labelhza);
		panneauExoplaneteDetail.add(Texthza);
		
		panneauExoplaneteDetail.add(labelpClasse);
		panneauExoplaneteDetail.add(TextpClasse);
		
		panneauExoplaneteDetail.add(labelhClasse);
		panneauExoplaneteDetail.add(TexthClasse);
		
		panneauExoplaneteDetail.add(labelphi);
		panneauExoplaneteDetail.add(Textphi);
		
		panneauExoplaneteDetail.add(labelStatus);
		panneauExoplaneteDetail.add(TextStatus);
		
		panneauExoplaneteDetail.add(labelDecouverte);
		panneauExoplaneteDetail.add(TextDecouverte);
		
		panneauExoplaneteDetail.add(boutonEnregistrer);
		
		JScrollPane scrollPane = new JScrollPane(panneauExoplaneteDetail);
		panneauPrincipaleAdminModier.add(scrollPane);
	}

}
