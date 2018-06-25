package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.DALException;
import fr.eni.clinique.dal.jdbc.Md5;
import fr.eni.clinique.dal.jdbc.PersonnelDAO;

public class PersonnelManager {

	private static PersonnelManager instance;
	private PersonnelDAO daoPersonnel = new PersonnelDAOJdbcImpl();
	private static List<Personnel> catalogue = new ArrayList<Personnel>();
	

	// constructor
	private PersonnelManager() throws BLLException {

		try {
			catalogue = daoPersonnel.selectAll();
		} catch (DALException e) {
			throw new BLLException("BLL Failed in constructor", e);
		}
	}

	// get/set
	public PersonnelDAO getManager() {
		return daoPersonnel;
	}

	public PersonnelDAO getDaoPersonnel() {
		return daoPersonnel;
	}

	public void setDaoPersonnel(PersonnelDAO daoArticle) {
		this.daoPersonnel = daoArticle;
	}

	public List<Personnel> getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(List<Personnel> catalogue) {
		catalogue = catalogue;
	}

	// method add
	public void addPersonnel(Personnel a) throws BLLException {

		try {
			getInstance().validerPersonnels(a);
			daoPersonnel.insert(a);
		} catch (DALException e) {
			throw new BLLException("Failed for insert", e);
		}
		catalogue.add(a);
	}

	// method uptdate

	public void updatePersonnel(Personnel a) throws BLLException {
		try {
			
			
			getInstance().validerPersonnels(a);
			//auth.validConnex(a);
			daoPersonnel.update(a);
		} catch (DALException e) {
			throw new BLLException("Failed for update", e);
		}
	}

	public void validerPersonnels(Personnel a) throws BLLException {

		if (a.getNom().length() == 0 || (a.getMotPasse()).length() == 0 || a.getRole().length() == 0) {

			throw new BLLException("Erreur validation client");
		}
	}

	public void selectById(int a) throws BLLException {
		try {
			daoPersonnel.selectById(a);
		} catch (DALException e) {
			throw new BLLException("Failed for update", e);
		}
	}
	public void selectall() throws BLLException {
		try {
			catalogue = daoPersonnel.selectAll();
		} catch (DALException e) {
			throw new BLLException("Failed for all", e);
		}
	}
	// method instance
	public static PersonnelManager getInstance() throws BLLException {
		if (instance == null) {
			instance = new PersonnelManager();
		}
		return instance;
	}

}
