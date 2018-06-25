package fr.eni.clinique.ihm.login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.eni.clinique.dal.jdbc.DALException;

public class PersonnelAjout extends JFrame {

	private JPanel container = new JPanel();
	private JTextField nom = new JTextField("");
	private JLabel nom1 = new JLabel("Nom");
	private JLabel mdp = new JLabel("Mot de Passe");
	private JTextField mdp1 = new JTextField("");
	private JLabel role = new JLabel("Role");
	private JTextField role1 = new JTextField("");
	private JLabel archi = new JLabel("Archivage");
	private JTextField archi1 = new JTextField("");
	private JButton b = new JButton("VALIDATION");
	private JButton b2 = new JButton("ENREGISTRER");
	private JTextField jtf4 = new JTextField("");
	

	public PersonnelAjout(JPanel container, JTextField nom, JLabel nom1, JLabel mdp, JTextField mdp1, JLabel role,
			JTextField role1, JLabel archi, JTextField archi1, JButton b, JButton b2, JTextField jtf4)
			throws HeadlessException {
		super();
		this.container = container;
		this.nom = nom;
		this.nom1 = nom1;
		this.mdp = mdp;
		this.mdp1 = mdp1;
		this.role = role;
		this.role1 = role1;
		this.archi = archi;
		this.archi1 = archi1;
		this.b = b;
		this.b2 = b2;
		this.jtf4 = jtf4;
	}

	public JPanel getContainer() {
		return container;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}

	public JTextField getNom() {
		return nom;
	}

	public void setNom(JTextField nom) {
		this.nom = nom;
	}

	public JLabel getNom1() {
		return nom1;
	}

	public void setNom1(JLabel nom1) {
		this.nom1 = nom1;
	}

	public JLabel getMdp() {
		return mdp;
	}

	public void setMdp(JLabel mdp) {
		this.mdp = mdp;
	}

	public JTextField getMdp1() {
		return mdp1;
	}

	public void setMdp1(JTextField mdp1) {
		this.mdp1 = mdp1;
	}

	public JLabel getRole() {
		return role;
	}

	public void setRole(JLabel role) {
		this.role = role;
	}

	public JTextField getRole1() {
		return role1;
	}

	public void setRole1(JTextField role1) {
		this.role1 = role1;
	}

	public JLabel getArchi() {
		return archi;
	}

	public void setArchi(JLabel archi) {
		this.archi = archi;
	}

	public JTextField getArchi1() {
		return archi1;
	}

	public void setArchi1(JTextField archi1) {
		this.archi1 = archi1;
	}

	public JButton getB() {
		return b;
	}

	public void setB(JButton b) {
		this.b = b;
	}

	public JButton getB2() {
		return b2;
	}

	public void setB2(JButton b2) {
		this.b2 = b2;
	}

	public JTextField getJtf4() {
		return jtf4;
	}

	public void setJtf4(JTextField jtf4) {
		this.jtf4 = jtf4;
	}

	public PersonnelAjout() {

		this.setTitle("AJOUT D'UN PERSONNEL");
		this.setSize(700, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel top = new JPanel();
		top.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Ligne 1
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		top.add(getNom(), gbc);

		gbc.gridy = 0;
		gbc.gridx = 1;
		gbc.insets = new Insets(5, 5, 5, 5);
		top.add(getNom1(), gbc);

		// Ligne 2
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.insets = new Insets(5, 5, 5, 5);		
		top.add(getMdp(), gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.insets = new Insets(5, 5, 5, 5);
		top.add(getMdp1(), gbc);
		
		// Ligne 2
				gbc.gridy = 2;
				gbc.gridx = 0;
				gbc.insets = new Insets(5, 5, 5, 5);		
				top.add(getRole(), gbc);

				gbc.gridy = 2;
				gbc.gridx = 1;
				gbc.insets = new Insets(5, 5, 5, 5);
				top.add(getRole1(), gbc);
				
		// Font police = new Font("Arial", Font.BOLD, 14);
		// jtf.setFont(police);

		
		nom.setForeground(Color.BLUE);
		

//		b.addActionListener(new BoutonListener());
//		b2.addActionListener(new Bouton2Listener());

		top.add(nom);
		top.add(mdp);
		top.add(role);
		top.add(archi);

		top.add(nom1);
		top.add(mdp1);
		top.add(role1);
		top.add(archi1);
		
		top.add(jtf4);

		top.add(b);
top.add(b2);
		mdp1.setEditable(false);
		
		
		this.setLocationRelativeTo(null);
		this.setContentPane(top);
		this.setVisible(true);
	}

	private Component getmdp() {
		// TODO Auto-generated method stub
		return null;
	}

	private JLabel getnom1() {
		// TODO Auto-generated method stub
		if (nom1 == null) {
			nom1 = new JLabel("Nom: ");	
	}return nom1;
	}
	


	class BoutonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.out.println("TEXT : jtf " + nom.getText());
			jtf4.setText(nom.getText());
//			setJTF4(jtf4.getText());
//			System.out.println("RECUPERE jtf2:     " + getJTF4());

		}
	}

	class Bouton2Listener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				Gestiondupersonnel fen2 = new Gestiondupersonnel();
			} catch (DALException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	


	}
