import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

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
import org.hibernate.cfg.Configuration;

public class FenetrePrincipale implements MouseListener
{
	private JFrame fenetrePrincipale;
	
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
		
		// Nettoyage final (une seule fois)
		session.close();
		sessionControleur.close();
		
		return panel;
		
	}
	
	private void newFormulaire()
	{
		JFrame formulaire = new JFrame();
		
		formulaire.setTitle("Formulaire - Ajouter Exoplanete");
		formulaire.setSize(700, 700); 
		formulaire.setResizable(true);
		formulaire.setLocationRelativeTo(null);
		formulaire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		formulaire.add(constructionFormulaire());
		
		formulaire.setVisible(true);
	}
	
	private JPanel constructionFormulaire()
	{
		JPanel panel = new JPanel();
		
		GridLayout grid = new GridLayout(0,2);
		panel.setLayout(grid);
		
		JLabel myLabel = new JLabel("Planete");
		JTextField field = new JTextField();
		
		JLabel myLabel2 = new JLabel("Etoile");
		JTextField field2 = new JTextField();
		
		JLabel myLabel3 = new JLabel("Type d'Etoile");
		JTextField field3 = new JTextField();
		
		JLabel myLabel4 = new JLabel("Masse");
		JTextField field4 = new JTextField();
		
		JLabel myLabel5 = new JLabel("Rayon");
		JTextField field5 = new JTextField();
		
		JLabel myLabel6 = new JLabel("Flux");
		JTextField field6 = new JTextField();
		
		JLabel myLabel7 = new JLabel("Temperature");
		JTextField field7 = new JTextField();
		
		JLabel myLabel8 = new JLabel("Periode");
		JTextField field8 = new JTextField();
		
		JLabel myLabel9 = new JLabel("Distance");
		JTextField field9 = new JTextField();
		
		JLabel myLabel10 = new JLabel("Zone");
		JTextField field10 = new JTextField();
		
		JLabel myLabel11 = new JLabel("ist");
		JTextField field11 = new JTextField();
		
		JLabel myLabel12 = new JLabel("sph");
		JTextField field12 = new JTextField();
		
		JLabel myLabel13 = new JLabel("hzd");
		JTextField field13 = new JTextField();
		
		JLabel myLabel14 = new JLabel("hzc");
		JTextField field14 = new JTextField();
		
		JLabel myLabel15 = new JLabel("hza");
		JTextField field15 = new JTextField();
		
		JLabel myLabel16 = new JLabel("pClasse");
		JTextField field16 = new JTextField();
		
		JLabel myLabel17 = new JLabel("hClasse");
		JTextField field17 = new JTextField();
		
		JLabel myLabel18 = new JLabel("phi");
		JTextField field18 = new JTextField();
		
		JLabel myLabel19 = new JLabel("Distance 2");
		JTextField field19 = new JTextField();
		
		JLabel myLabel20 = new JLabel("Status");
		JTextField field20 = new JTextField();
		
		JLabel myLabel21 = new JLabel("Decouverte");
		JTextField field21 = new JTextField();
		
		panel.add(myLabel);
		panel.add(field);
		panel.add(myLabel2);
		panel.add(field2);
		panel.add(myLabel3);
		panel.add(field3);
		panel.add(myLabel4);
		panel.add(field4);
		panel.add(myLabel5);
		panel.add(field5);
		panel.add(myLabel6);
		panel.add(field6);
		panel.add(myLabel7);
		panel.add(field7);
		panel.add(myLabel8);
		panel.add(field8);
		panel.add(myLabel9);
		panel.add(field9);
		panel.add(myLabel10);
		panel.add(field10);
		panel.add(myLabel11);
		panel.add(field11);
		panel.add(myLabel12);
		panel.add(field12);
		panel.add(myLabel13);
		panel.add(field13);
		panel.add(myLabel14);
		panel.add(field14);
		panel.add(myLabel15);
		panel.add(field15);
		panel.add(myLabel16);
		panel.add(field16);
		panel.add(myLabel17);
		panel.add(field17);
		panel.add(myLabel18);
		panel.add(field18);
		panel.add(myLabel19);
		panel.add(field19);
		panel.add(myLabel20);
		panel.add(field20);
		panel.add(myLabel21);
		panel.add(field21);
		
		return panel;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		newFormulaire();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

