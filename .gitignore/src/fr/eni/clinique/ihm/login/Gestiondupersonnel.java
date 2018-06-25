package fr.eni.clinique.ihm.login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.eni.clinique.bll.LoginMger;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.jdbc.DALException;
import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;

public class Gestiondupersonnel extends JFrame implements ActionListener ,ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private JButton bouton1 = new JButton("Ajouter");
	private JButton bouton2 = new JButton("Supprimer");
	private JButton bouton3 = new JButton("Réinitialiser");
	private PersonnelDAOJdbcImpl d = new PersonnelDAOJdbcImpl();
	private JList<Personnel> list = new JList<Personnel>();
	private int poselect ;		
	DefaultListModel<Personnel> l = new DefaultListModel<Personnel>();
	JPanel pan = new JPanel();
	private NewMDP fen;
	//JPanel pan1 = new JPanel( liste);
	
	//JList list=new JList();
	//FlowLayout experimentLayout = new FlowLayout();

	public Gestiondupersonnel() throws DALException {
		//Gestiondupersonnel p = new Gestiondupersonnel();
		List<Personnel> liste=d.selectAll();

		this.setTitle("Gestion du personnel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 400);
		pan.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setLocationRelativeTo(null);
		list.addListSelectionListener(this);

		// pan.setComponentOrientation(
		// ComponentOrientation.LEFT_TO_RIGHT);

		pan.add(bouton1);
		bouton1.addActionListener(this);

		pan.add(bouton2);
		bouton2.addActionListener(this);

		pan.add(bouton3);
		bouton3.addActionListener(this);
		//pan.addSeparator();
		
		pan.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		for(int i=0; i<liste.size(); i++)
			l.add(i, liste.get(i));
		//JScrollPane scrollPane = new JScrollPane(list);
		list.setModel(l);
		list.getFirstVisibleIndex();
		//list.add(scrollPane, DISPOSE_ON_CLOSE);
		//list.add(nom);
		//ListSelectModel
		//nom=prepareStatement(d.selectAll());
		//pan.add(setNom(list));
		list.getFirstVisibleIndex();
	
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(pan, BorderLayout.NORTH);
		this.getContentPane().add(list, BorderLayout.CENTER);
		this.setVisible(true);	
	}

//	public interface ListSelectionListener
//	extends EventListener{
//	}
//	public void valueChanged(ListSelectionEvent e) {
//	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		//ListSelectionListener selec;
		PersonnelDAOJdbcImpl log = new PersonnelDAOJdbcImpl();
		// Lorsque nous cliquons sur notre bouton, on passe a l'autre fenétre
		if (source == bouton1) {			
		}
			if (source == bouton2) {
				
				
				Personnel a=l.get(poselect);
				if ((a.isArchive())==true) {
				 a.setArchive(false);
				}else if ((a.isArchive())==false) {
				 a.setArchive(true);				
				}		
				
				System.out.println(l.get(poselect));
				try {
					d.update(a);
				} catch (DALException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
				}
				if (source == bouton3) {
					Personnel a=l.get(poselect);
						
					 //fen = new NewMDP();
					 fen = new NewMDP(a);
					fen.setVisible(true);
			    	 
					 System.out.println(a);
					//a.setMotPasse();
					
				}
				}
				//list.getFirstVisibleIndex();
					
				
//	public String getNmdp() {
//		NewMDP ret=null;
//		String r;
//	
//		return r=ret.getTextField().getText();
		

	//}
	@Override
	public void valueChanged(ListSelectionEvent e) {
	poselect = list.getSelectedIndex();
		
	}
	}