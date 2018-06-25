package fr.eni.clinique.ihm.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.eni.clinique.dal.jdbc.DALException;

public class ADMVET extends JFrame implements ActionListener{
	
	private Gestiondupersonnel fen;
	private VETERINAIRE fen2;
	 private JButton bouton1 = new JButton("ADM");
	 private JButton bouton2 = new JButton("VET");
	 private JPanel pan = new JPanel();
	 
     public ADMVET(){
    	 JFrame frame = new JFrame("Choisir Role"); 
    	 
    	 frame.setContentPane(pan);
    	 pan.add(bouton1);  
    	 bouton1.addActionListener(this);
    	 
    	 frame.setContentPane(pan);
    	 bouton2.addActionListener(this);
    	 pan.add(bouton2);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300, 100);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
     }
     public void actionPerformed(ActionEvent arg0) {
    Object source = arg0.getSource();
    	// Lorsque nous cliquons sur notre bouton, on passe a l'autre fenétre
    if (source == bouton1) 
    	 this.dispose();
    	 try {
			fen = new Gestiondupersonnel();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    if(source == bouton2) {
     	
     	 this.dispose();
     	 fen2 = new VETERINAIRE();
    } 
     }
     }
