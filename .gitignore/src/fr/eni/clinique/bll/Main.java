package fr.eni.clinique.bll;


import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.jdbc.Md5;

public class Main {
	public static void main(String[] args) throws BLLException {
		
	//	string motDePasseEncode = MD5(Personnels.);
	PersonnelManager instance1 = PersonnelManager.getInstance();
	Personnel p1= new Personnel(3,"MALALANICH melanie","lm789","vet",true);
	  
	//instance1.updatePersonnel(p1);
	//System.out.println(p1.getMotPasse());
	//System.out.println(p1);
	
	
}
}
