package fr.eni.clinique.bll;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.DALException;
import fr.eni.clinique.dal.jdbc.Md5;
import fr.eni.clinique.dal.jdbc.PersonnelDAO;
import fr.eni.clinique.dal.jdbc.JdbcConnect;
import fr.eni.clinique.ihm.login.FramConnexion;

public class LoginMger {

	PersonnelDAO personnelDAO = new PersonnelDAOJdbcImpl();

	public String authentification(JTextField login1, JTextField txtMdp) throws DALException, SQLException {

		return personnelDAO.authentification(login1, txtMdp);

	}
}
// public void validConnex(Personnels a) throws BLLException {
// String nom = "MALALANICH M";
// Md5 var = new Md5("lm89");
//
// Md5 mdpPersonneCrypte = new Md5(a.getMotPasse());
// boolean nomIdentiques = nomIdentiques(a.getNom(), nom);
//
// // daoPersonnel.
// if (!(mdpPersonneCrypte == var && nomIdentiques))
//
// {
// System.out.println(var);
// throw new BLLException("Erreur validation Personnel connexion");
// }
// }

// private boolean nomIdentiques(String nom1, String nom2) {
//
// return nom1.equals(nom2);
// }
// public void authentification(JTextField login1, JTextField txtMdp) throws
// DALException {
// {
// // TODO Auto-generated method stub
// VetoConnect b = new b.getInstance().VetoConnect();
// Connection conn;
// Statement statement = null;
// ResultSet resultat;
// // TODO Auto-generated method stub
// String login =login1.getText();
// try {
// System.out.println("login1="+login);
// } catch (Exception e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// String password = txtMdp.getText();
// b.connect();
// conn = b.connect();
// try{
// statement = conn.createStatement();
// String sql = "SELECT MotPasse FROM Personnels WHERE Nom ='"+login+"'";
// resultat = statement.executeQuery(sql);
// if(resultat.next()){
// String motDePasse = resultat.getString(1);
// if(motDePasse.equals(password)){
// JOptionPane.showMessageDialog(null,"Connexion réussie !
// ","Success",JOptionPane.PLAIN_MESSAGE);
// }else {
// JOptionPane.showMessageDialog(null,"Mot de passe incorrect ! ","Error",1);
// }
// }else {
// JOptionPane.showMessageDialog(null,"Login incorrect ! ","Error",1);
// }
// conn.close();
// }catch (SQLException e4) {
// System.out.println(e4.getMessage());
// }
// }
//
// }

// this.setVisible(true);
// }
// private boolean nomIdentiques(String nom1, String nom2, String nom3 ) {
//
// return nom1.equals(nom2) && nom2.equals(nom3);
// }
