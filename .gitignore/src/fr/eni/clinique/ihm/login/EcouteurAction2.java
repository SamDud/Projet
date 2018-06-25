package fr.eni.clinique.ihm.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurAction2 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		Object sourceDeLEvenement = e.getSource();

		System.out.println("tutu "+sourceDeLEvenement);
	}
}
