package fr.eni.clinique.ihm.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Erreur extends JFrame {

	private JLabel label = new JLabel("ERREUR DE CONNEXION");
	private JPanel container = new JPanel();

	public Erreur() {

		JFrame frame = new JFrame("Erreur de connexion");
		frame.setContentPane(container);

		setTitle("Erreur connexion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 400);

		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());

		// police d'écriture
		Font police = new Font("Tahoma", Font.BOLD, 16);
		// application de la police au JLabel
		label.setFont(police);
		// couleur de la police
		label.setForeground(Color.red);
		// allignement du texte
		label.setHorizontalAlignment(JLabel.CENTER);

		container.add(label, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}
