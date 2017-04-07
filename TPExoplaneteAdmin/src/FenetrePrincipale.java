import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FenetrePrincipale implements MouseListener, ActionListener
{
	private JFrame fenetrePrincipale;
	private JFrame formulaire;
	private JFrame deleteFormulaire;
	protected JTextField deleteId;
	private JPanel panelForm;
	private JTextField[] tabTextField;
	private JButton buttonDelete;
	
	public FenetrePrincipale()
	{
		this.fenetrePrincipale = new JFrame();

		
		afficherFenetre();
	}
	
	private void afficherFenetre()
	{
		this.fenetrePrincipale.setTitle("Admin Exoplanete");
		this.fenetrePrincipale.setSize(700, 700); 
		this.fenetrePrincipale.setResizable(true);
		this.fenetrePrincipale.setLocationRelativeTo(null);
		this.fenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.fenetrePrincipale.add(construireListeExoplanete());
		
		this.fenetrePrincipale.setVisible(true);
	}
	
	private JPanel construireListeExoplanete()
	{
		JPanel panel = new JPanel();
		
		GridLayout grid = new GridLayout(0,1);
		//JTextField field = new JTextField();
		panel.setLayout(grid);
		
		// Préparation (une seule fois)
		Configuration configuration = new Configuration();
		configuration.addClass(Exoplanete.class);
		SessionFactory sessionControleur = configuration.buildSessionFactory();
		Session session = sessionControleur.openSession();
		
		// Lecture
		@SuppressWarnings("deprecation")
		Iterator listeExoplanete = session.createQuery("from Exoplanete ").iterate();
		while(listeExoplanete.hasNext())
		{
			JTextField field = new JTextField();
			Exoplanete exoplanete = (Exoplanete)listeExoplanete.next(); // ca prend le constructeur vide
			//System.out.println("Exoplanete : " + exoplanete.getPlanete());
			field.setText("Exoplanete : " + exoplanete.getPlanete());
			
			field.addMouseListener(this);
			//field.setPreferredSize(new Dimension( 200, 200 ));
			
			panel.add(field);
		}
		
		this.buttonDelete = new JButton("Supprimer Une Exoplanete");
		this.buttonDelete.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				   contruireDeleteFrame();
			   }
			});
		// Nettoyage final (une seule fois)
		session.close();
		sessionControleur.close();
		
		panel.add(this.buttonDelete);
		
		return panel;
		
	}
	
	private void newFormulaire()
	{
		this.formulaire = null;
		this.formulaire = new JFrame();
		
		this.formulaire.setTitle("Formulaire - Ajouter Exoplanete");
		this.formulaire.setSize(700, 700); 
		this.formulaire.setResizable(true);
		this.formulaire.setLocationRelativeTo(null);
		this.formulaire.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.panelForm = this.constructionFormulaire();
		
		this.formulaire.add(this.panelForm);
		
		this.formulaire.setVisible(true);
	}
	
	private JPanel constructionFormulaire()
	{
		JPanel panel = new JPanel();
		JLabel[] tabLabel = new JLabel[Exoplanete.NBR_DE_VAR];
		this.tabTextField = new JTextField[Exoplanete.NBR_DE_VAR];
		String[] nomLabel = new String[Exoplanete.NBR_DE_VAR];
		
		for(int compteur = 0; compteur < Exoplanete.NBR_DE_VAR; compteur++)
		{
			nomLabel[compteur] = Exoplanete.getNomVar(compteur);
		}
		
		GridLayout grid = new GridLayout(0,2);
		panel.setLayout(grid);
		
		for(int compteur2 = 0; compteur2 < Exoplanete.NBR_DE_VAR; compteur2++)
		{
			tabLabel[compteur2] = new JLabel(Exoplanete.getNomVar(compteur2));
			tabTextField[compteur2] = new JTextField();
			tabTextField[compteur2].addActionListener(this);
			
			panel.add(tabLabel[compteur2]);
			panel.add(tabTextField[compteur2]);
		}
		
		JButton bouton = new JButton("Ajouter L'Exoplanete");
		bouton.addActionListener(this);
		panel.add(bouton);
				
		return panel;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		newFormulaire();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// Préparation (une seule fois)
		Configuration configuration = new Configuration();
		configuration.addClass(Exoplanete.class);
		SessionFactory sessionControleur = configuration.buildSessionFactory();
		Session session = sessionControleur.openSession();
		
		// Ecriture
		Exoplanete newPlanete = new Exoplanete(this.tabTextField[0].getText(), this.tabTextField[1].getText(), this.tabTextField[2].getText(), this.tabTextField[3].getText(), this.tabTextField[4].getText(), this.tabTextField[5].getText(),
				this.tabTextField[6].getText(), this.tabTextField[7].getText(), this.tabTextField[8].getText(), this.tabTextField[9].getText(), this.tabTextField[10].getText(), this.tabTextField[11].getText(), this.tabTextField[12].getText(),
				this.tabTextField[13].getText(), this.tabTextField[14].getText(), this.tabTextField[15].getText(), this.tabTextField[16].getText(), this.tabTextField[17].getText(), this.tabTextField[18].getText(), this.tabTextField[19].getText(),
				this.tabTextField[20].getText());
		session.save(newPlanete);
		
		
		// Nettoyage final (une seule fois)
		session.close();
		sessionControleur.close();
		
		for(int element = 0; element < this.tabTextField.length; element++)
		{
			this.tabTextField[element].setText("");
		}
	}
	
	
	/*
	public List<JTextField> getJTextField(Component[] components)
	{
		List<JTextField> text = new ArrayList<JTextField>();
		
		for(int element = 0; element < components.length; element++)
		{
			if(components[element].getClass().equals(JTextField.class))
			{
				text.add( (JTextField)components[element] );
			}
		}
		return text;
	}
*/
	
	
	private void contruireDeleteFrame()
	{
		this.deleteFormulaire = null;
		this.deleteFormulaire = new JFrame();
		
		this.deleteFormulaire.setTitle("Formulaire - Supprimer Exoplanete");
		this.deleteFormulaire.setSize(700, 700); 
		this.deleteFormulaire.setResizable(true);
		this.deleteFormulaire.setLocationRelativeTo(null);
		this.deleteFormulaire.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.deleteFormulaire.setVisible(true);
		
		JPanel panel = new JPanel();
		
		GridLayout grid = new GridLayout(0,1);
		//JTextField field = new JTextField();
		panel.setLayout(grid);
		
		// Préparation (une seule fois)
		Configuration configuration = new Configuration();
		configuration.addClass(Exoplanete.class);
		SessionFactory sessionControleur = configuration.buildSessionFactory();
		Session session = sessionControleur.openSession();
		
		// Lecture
		@SuppressWarnings("deprecation")
		Iterator listeExoplanete = session.createQuery("from Exoplanete ").iterate();
		while(listeExoplanete.hasNext())
		{
			JTextField field = new JTextField();
			Exoplanete exoplanete = (Exoplanete)listeExoplanete.next(); // ca prend le constructeur vide
			//System.out.println("Exoplanete : " + exoplanete.getPlanete());
			field.setText("id" + exoplanete.getId() + "Exoplanete : " + exoplanete.getPlanete());
			
			//field.addMouseListener(this);
			//field.setPreferredSize(new Dimension( 200, 200 ));
			
			panel.add(field);
		}
		
		// Nettoyage final (une seule fois)
		session.close();
		sessionControleur.close();
		
		JButton button = new JButton("Supprimer");
		this.deleteId = null;
		this.deleteId = new JTextField();
		
		button.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				   
					Configuration configuration = new Configuration();
					configuration.addClass(Exoplanete.class);
					SessionFactory sessionControleur = configuration.buildSessionFactory();
					Session session = sessionControleur.openSession();
					Transaction transaction = session.beginTransaction();
					
					// Lecture
					@SuppressWarnings("deprecation")
					Iterator listeExoplanete = session.createQuery("from Exoplanete ").iterate();
					int idPlanete = Integer.parseInt(FenetrePrincipale.this.deleteId.getText());
					while(listeExoplanete.hasNext())
					{
						//JTextField field = new JTextField();
						Exoplanete exoplanete = (Exoplanete)listeExoplanete.next(); // ca prend le constructeur vide
						
						int id = exoplanete.getId();
						
						
						
						if(exoplanete.getId() == idPlanete)
						{
							/*
							Exoplanete newPlanete = new Exoplanete(exoplanete.getId(), exoplanete.getPlanete(), exoplanete.getEtoile(), exoplanete.getTypeEtoile(), exoplanete.getMasse(), exoplanete.getRayon(),
									exoplanete.getFlux(), exoplanete.getTemperature(), exoplanete.getPeriode(), exoplanete.getDistance(), exoplanete.getZone(), exoplanete.getIst(), exoplanete.getSph(),
									exoplanete.getHzd(), exoplanete.getHzc(), exoplanete.getHza(), exoplanete.getpClasse(), exoplanete.gethClasse(), exoplanete.getPhi(), exoplanete.getDistance2(),
									exoplanete.getStatus(),exoplanete.getDecouverte());
							*/
							
							Exoplanete p = session.load(Exoplanete.class, idPlanete);
							session.delete(p);
							transaction.commit();
						}
						
						
						
					}
					
					
					
					session.close();
					sessionControleur.close();
					FenetrePrincipale.this.deleteId.setText("");
					FenetrePrincipale.this.deleteFormulaire.dispose();
			   }});
		
		panel.add(button);
		panel.add(this.deleteId);
		
		this.deleteFormulaire.add(panel);
	}
	
	
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		//  Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		//  Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//  Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//  Auto-generated method stub
		
	}


}

