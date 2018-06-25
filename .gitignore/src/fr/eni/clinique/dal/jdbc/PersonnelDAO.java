package fr.eni.clinique.dal.jdbc;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;

import fr.eni.clinique.bo.Personnel;

/**
 * 
 */


/**
 * @author Eni Ecole
 *
 */
public interface PersonnelDAO {
	
	//Sélectionner un personnel par son id
	public Personnel selectById(int a) throws DALException;
	
	//Sélectionner tous les personnel 
	public List<Personnel> selectAll() throws DALException;
	
	//Modifier les attributs d'un personnel connu en BD
	public void update(Personnel data) throws DALException;
	
	//Insérer un nouvel personnel
	public void insert(Personnel data) throws DALException;
	
	//Supprimer un personnel
	public void delete(int id) throws DALException;
	
	
	public String authentification(JTextField login1, JTextField txtMdp)throws DALException, SQLException ;
	
	
}
