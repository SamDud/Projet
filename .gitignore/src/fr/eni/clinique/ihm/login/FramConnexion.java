package fr.eni.clinique.ihm.login;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import fr.eni.clinique.bll.LoginMger;

import fr.eni.clinique.dal.jdbc.DALException;


public class FramConnexion extends JFrame implements ActionListener {

	
	private JLabel lblid, lblNo, lblnom, lblMdp;
	private static JTextField txtnom, txtMdp;
	private JButton btnValider;
	protected Window frame;
	JButton minimize = new JButton("_");
	JButton maximize = new JButton("[]");
	private ADMVET fenadm;
	private FramConnexion fen;
	private VETERINAIRE fenvet;
	String r ="adm";
	String s= "sec";
	String v= "vet";
	private Secretaire fensec;
	private Erreur fenerr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramConnexion frame = new FramConnexion();					
					//Gestiondupersonnel frame = new Gestiondupersonnel();
					//PersonnelAjout frame = new PersonnelAjout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			
			
		});
	}

	// ImageIcon img = new ImageIcon("");
	/**
	 * Create the frame.
	 * 
	 * @throws DALException
	 */
	public FramConnexion() throws DALException {

		setTitle("Connexion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(300, 250));
		initIHM();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public FramConnexion(FramConnexion f) throws HeadlessException {
		super();
		this.fen = f;
	}

	// Classe interne
	private class EcouteurAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LoginMger log = new LoginMger();
			String ret = null;
			Object sourceDeLEvenement = e.getSource();

			if (sourceDeLEvenement == btnValider) {
				try {
					ret = log.authentification(txtnom, txtMdp);
					//System.out.println(ret);
				} catch (DALException e1) {
					// System.out.println("erreur 1");
					e1.printStackTrace();
				} catch (SQLException e1) {
					// System.out.println("erreur 2");
					e1.printStackTrace();
				}
			if(ret!=null) {
				if(ret.equals(r))  {
					dispose();	
					setLocationRelativeTo(null);
					fenadm = new ADMVET();
					
					}
				if (ret.equals(v)) {
					dispose();
					setLocationRelativeTo(null);
					fenvet = new VETERINAIRE();
					}
			
				if (ret.equals(s)) {
						dispose();
						setLocationRelativeTo(null);
						fensec = new Secretaire();
						}
			} else {
				setLocationRelativeTo(null);
				fenerr = new Erreur();
				}	
		}
			
		
				}
			}
		

	

	// Classe interne
	// private class EcouteurAction implements ActionListener {
	//
	// @Override
	// public void actionPerformed(ActionEvent e) {
	//
	// Object sourceDeLEvenement = e.getSource();
	//
	// // si le composant qui a emis l'evenemtn est btnUn
	// if (sourceDeLEvenement == btnValider) {
	// // modifier l'état de btnUn
	//
	// }
	//
	// }
	// }
	private void initIHM() throws DALException {

		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Ligne 1
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.add(getLbid(), gbc);

		gbc.gridy = 0;
		gbc.gridx = 1;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.add(getLblNo(), gbc);

		// Ligne 2
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.add(getLblnom(), gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.add(getTxtnom(), gbc);

		// Ligne 3
		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.add(getLblMdp(), gbc);

		gbc.gridy = 2;
		gbc.gridx = 1;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.add(getTxtMdp(), gbc);

		// Ligne 4
		gbc.gridy = 3;
		gbc.gridx = 1;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(getBtnValider(), gbc);
		this.setContentPane(panel);

	}

	public JLabel getLbid() {
		if (lblid == null) {
			lblid = new JLabel("Identifiant");
		}
		return lblid;
	}

	public JLabel getLblnom() {
		if (lblnom == null) {
			lblnom = new JLabel("Nom: ");
		}

		return lblnom;
	}

	public JLabel getLblMdp() {
		if (lblMdp == null) {
			lblMdp = new JLabel("Mot de passe: ");
		}
		return lblMdp;
	}

	public JTextField getTxtnom() {
		if (txtnom == null) {
			txtnom = new JTextField(30);
		}
		return txtnom;
	}

	public JTextField getTxtMdp() {
		if (txtMdp == null) {
			txtMdp = new JTextField(30);
		}

		return txtMdp;
	}

	public JLabel getLblNo() {
		if (lblNo == null) {
			lblNo = new JLabel("");
		}
		return lblNo;
	}

	public JButton getBtnValider() {

		if (btnValider == null) {

			btnValider = new JButton("Valider");
			getContentPane().add(btnValider);
			EcouteurAction ea = new EcouteurAction();
			btnValider.addActionListener(ea);
			// EcouteurAction2 ea2 = new EcouteurAction2();
			// btnValider.addActionListener(ea2);
			// btnValider.addActionListener(this);
			//
		}
		return btnValider;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LoginMger log = new LoginMger();
		String ret = null;
		Object sourceDeLEvenement = e.getSource();					
	}
}