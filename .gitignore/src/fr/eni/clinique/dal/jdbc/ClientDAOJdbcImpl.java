//package fr.eni.clinique.dal.jdbc;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.swing.JTextField;
//
//import fr.eni.clinique.bo.Personnel;
//
///**
// * @author Eni Ecole
// * 
// */
//public class ClientDAOJdbcImpl implements PersonnelDAO {	
//
//	private static final String sqlNom = "SELECT CodeClient,NomClient,PrenomClient,Adresse1,Adresse2,CodePostal,Ville,NumTel,Assurance,Email,Remarque,Archive"
//			+ " FROM CliniqueVeterinaire WHERE NomClient =?";
//	private static final String sqlSelectById = "select CodePers, Nom, MotPasse, Role, Archive"
//			+ " from Personnels where CodePers = ?";
//	private static final String sqlSelectAll = "select CodePers,Nom, MotPasse, Role, Archive" + " from Personnels";
//	private static final String sqlUpdate = "update Personnels set Nom=?,MotPasse=?,Role=?,Archive=? "
//			+ "where CodePers=?";
//	private static final String sqlInsert = "insert into Personnels(Nom, MotPasse, Role, Archive)" + " values(?,?,?,?)";
//	private static final String sqlDelete = "delete from Personnels where CodePers=?";
//
//	public String Nom(JTextField login1, JTextField txtMdp) throws DALException, SQLException {
//		String login = null;
//		Connection cnx = null;
//		Statement statement = null;
//		ResultSet rs = null;
//		String ret = null;
//		String password = txtMdp.getText();
//		login = login1.getText();
//		cnx = JdbcConnect.getInstance();
//		statement = cnx.createStatement();
//		
//		PreparedStatement rqt = cnx.prepareStatement(sqlAuthentification);			
//		rqt.setString(1, login);		
//		rs = rqt.executeQuery();		
//
//		try {
//
//			if (rs.next()) {
//				String motDePasse = rs.getString(3);
//				if (motDePasse.equals(password)) {
//
//						ret = rs.getString("Role");						
//					}
//				}
//			
//		} catch (SQLException e) {
//			throw new DALException("selectById failed - Log = " + e);
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (rqt != null) {
//					rqt.close();
//				}
//				if (cnx != null) {
//					cnx.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//		}
//
//		return ret;
//	}
//
//	@Override
//	public Personnel selectById(int a) throws DALException {
//		Connection cnx = null;
//		PreparedStatement rqt = null;
//		ResultSet rs = null;
//		Personnel pers = null;
//		try {
//			cnx = JdbcConnect.getInstance();
//			rqt = cnx.prepareStatement(sqlSelectById);
//			rqt.setInt(1, a);
//
//			rs = rqt.executeQuery();
//			if (rs.next()) {
//
//				pers = new Personnel(rs.getInt("CodePers"), rs.getString("Nom"), rs.getString("MotPasse"),
//						rs.getString("Role"), rs.getBoolean("Archive"));
//			}
//
//		} catch (SQLException e) {
//			throw new DALException("selectById failed - id = " + a, e);
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (rqt != null) {
//					rqt.close();
//				}
//				if (cnx != null) {
//					cnx.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//		}
//		return pers;
//	}
//
//	@Override
//	public List<Personnel> selectAll() throws DALException {
//		Connection cnx = null;
//		Statement rqt = null;
//		ResultSet rs = null;
//		List<Personnel> liste = new ArrayList<Personnel>();
//		try {
//			cnx = JdbcConnect.getInstance();
//			rqt = cnx.createStatement();
//			rs = rqt.executeQuery(sqlSelectAll);
//			Personnel pers = null;
//
//			while (rs.next()) {
//				pers = new Personnel(rs.getInt("CodePers"), rs.getString("Nom"), rs.getString("MotPasse"),
//						rs.getString("Role"), rs.getBoolean("Archive"));
//			}
//			liste.add(pers);
//
//		} catch (SQLException e) {
//			throw new DALException("selectAll failed - ", e);
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (rqt != null) {
//					rqt.close();
//				}
//				if (cnx != null) {
//					cnx.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return liste;
//
//	}
//
//	@Override
//	public void update(Personnel data) throws DALException {
//		Connection cnx = null;
//		PreparedStatement rqt = null;
//		try {
//			cnx = JdbcConnect.getInstance();
//			rqt = cnx.prepareStatement(sqlUpdate);
//			rqt.setInt(5, data.getCodePers());
//
//			rqt.setString(1, data.getNom());
//			rqt.setString(2, data.getMotPasse());
//			rqt.setString(3, data.getRole());
//			rqt.setBoolean(4, data.isArchive());
//
//			rqt.executeUpdate();
//
//		} catch (SQLException e) {
//			throw new DALException("Update article failed - " + data, e);
//		} finally {
//			try {
//				if (rqt != null) {
//					rqt.close();
//				}
//				if (cnx != null) {
//					cnx.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	@Override
//	public void insert(Personnel data) throws DALException {
//		Connection cnx = null;
//		PreparedStatement rqt = null;
//		try {
//			cnx = JdbcConnect.getInstance();
//			rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
//
//			rqt.setString(1, data.getNom());
//			rqt.setString(2, data.getMotPasse());
//			rqt.setString(3, data.getRole());
//			rqt.setBoolean(4, data.isArchive());
//
//			int nbRows = rqt.executeUpdate();
//			if (nbRows == 1) {
//				ResultSet rs = rqt.getGeneratedKeys();
//				if (rs.next()) {
//					data.setCodePers(rs.getInt(1));
//				}
//
//			}
//
//		} catch (SQLException e) {
//			throw new DALException("Insert article failed - " + data, e);
//		} finally {
//			try {
//				if (rqt != null) {
//					rqt.close();
//				}
//				if (cnx != null) {
//					cnx.close();
//				}
//			} catch (SQLException e) {
//				throw new DALException("close failed - ", e);
//			}
//
//		}
//	}
//
//	@Override
//	public void delete(int id) throws DALException {
//		Connection cnx = null;
//		PreparedStatement rqt = null;
//		try {
//			cnx = JdbcConnect.getInstance();
//			// si le client est referencer dans une ligne de commande
//			rqt = cnx.prepareStatement(sqlDelete);
//			rqt.setInt(1, id);
//			rqt.executeUpdate();
//		} catch (SQLException e) {
//			throw new DALException("Delete article failed - id=" + id, e);
//		} finally {
//			try {
//				if (rqt != null) {
//					rqt.close();
//				}
//				if (cnx != null) {
//					cnx.close();
//				}
//			} catch (SQLException e) {
//				throw new DALException("close failed ", e);
//			}
//
//		}
//	}
//
//}
