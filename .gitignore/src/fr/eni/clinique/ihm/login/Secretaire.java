
package fr.eni.clinique.ihm.login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Secretaire extends JFrame{
	
	public Secretaire() {
		this.setTitle("Prise de rendez-vous");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//On définit le layout en lui indiquant qu'il travaillera en ligne
		JPanel b1 = new JPanel();
		b1.add(new JButton("Supprimer"));
		b1.add(new JButton("Valider"));
		
		this.getContentPane().add(b1);
		this.setVisible(true);
	}

}
