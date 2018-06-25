package fr.eni.clinique.ihm.login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.jdbc.DALException;
import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;

public class NewMDP extends JFrame implements ActionListener {

	private JButton bouton1 = new JButton("ENREGISTRER");
	private JPanel pan = new JPanel();
	private JTextField textField = new JTextField("              ");
	private PersonnelDAOJdbcImpl d = new PersonnelDAOJdbcImpl();
	private Personnel a;
	//private NewMDP c= new NewMDP();

	public Personnel getA() {
		return a;
	}

	public void setA(Personnel a) {
		this.a = a;
	}

	public JButton getBouton1() {
		return bouton1;
	}

	public void setBouton1(JButton bouton1) {
		this.bouton1 = bouton1;
	}

	public JPanel getPan() {
		return pan;
	}

	public void setPan(JPanel pan) {
		this.pan = pan;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public NewMDP(Personnel a) throws HeadlessException {
		super();
		this.a = a;

		JFrame frame = new JFrame("Nouveau MDP");

		frame.setContentPane(pan);
		pan.add(bouton1);
		bouton1.addActionListener(this);

		frame.setContentPane(pan);
		//textField.setBounds(2,2, 1, 1);
		pan.add(textField);
		textField.addActionListener(this);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 100);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	

	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		// Lorsque nous cliquons sur notre bouton, on passe a l'autre fenétre
		if (source == bouton1) {
			
			String b = getTextField().getText();//textField.getText();
			//c.getA().setMotPasse(b);
			System.out.println(a);
			System.out.println(b);
			a.setMotPasse(b);
			
			try {
				
				d.update(a);
			} catch (DALException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
}
