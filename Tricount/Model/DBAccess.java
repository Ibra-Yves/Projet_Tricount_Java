package dev.java.tricount.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBAccess {
	private Connection dbConnection;

	public DBAccess() throws SQLException {

		dbConnection = null;
		String strUrl = "jdbc:sybase:Tds:localhost:2638";

		// "sybase.jdbc.sqlanywhere.IDriver"
		// "com.sybase.jdbcx.SybDriver"
		// DriverManager.registerDriver((Driver)Class.forName("sybase.jdbc4.sqlanywhere.IDriver").newInstance());
		dbConnection = DriverManager.getConnection(strUrl, "DBA", "sql");
		dbConnection.setAutoCommit(false);

	}

	/**
	 * @return return the list of participants
	 * @throws SQLException
	 */
	public ArrayList<Participant> retrouveParticipants() throws SQLException {
		ArrayList<Participant> result = new ArrayList<Participant>();
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * from participants");
		while (rs.next()) {

			Participant p = new Participant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("devise"), rs.getString("moyRemb"), rs.getDouble("solde")); 

			result.add(p);

		}

		return result;
	}
	
	/**
	 * @param d
	 * @throws SQLException
	 */
	public void enregistreDepense(Depense d) throws SQLException
	{
		double  montant = d.getMontant();
		int  idPayeur = d.getIdPayeur();
		
		//  stocke  dans table  Dépense
		Statement sDep = dbConnection.createStatement();
		String sDepSQL = "INSERT INTO depenses (payeur, montant) "+
		"VALUES("+idPayeur+","+montant+")";
		int depId = -1;
		String[] columnNames = {"id"};
		sDep.executeUpdate(sDepSQL, columnNames);
		
		
		ResultSet rs= sDep.getGeneratedKeys();
		if(rs.next()) {
			depId = rs.getInt(1);
		}
		sDep.close();
		// stocke dans table lien
		int[] idProfiteurs = d.getProfiteurs();
		for (int i = 0; i < idProfiteurs.length; i++) {
			Statement sDepP = dbConnection.createStatement();
			String sDepPSQL = "INSERT INTO depensesPart (idProfiteur, idDepense) "+
			"VALUES("+idProfiteurs[i]+","+depId+")";
			
			
			sDepP.executeUpdate(sDepPSQL);
			sDepP.close();
		}
		
		ArrayList<ModificationSolde>  modifsSolde = d.getModifsSolde();
		// modifie  dans table Participant
		for (ModificationSolde modificationSolde : modifsSolde) {
			Statement sPart = dbConnection.createStatement();
			String sPartSQL = "UPDATE participants SET solde = solde + "+ modificationSolde.modifSolde+
			"WHERE id = "+ modificationSolde.participant;
			
			
			sPart.executeUpdate(sPartSQL);
			sPart.close();
		}
		
		
		dbConnection.commit();
	}

	/**
	 * @param p
	 * @throws SQLException
	 */
	public void creerParticipant(Participant p) throws SQLException {
		Statement sPart = dbConnection.createStatement();
		String sPartPSQL = "INSERT INTO participants (nom , prenom , devise , solde , moyRemb) "+
		"VALUES('"+p.getNom()+"','"+p.getPrenom()+"','"+p.getDevise()+"',0,'"+p.getMoyRemb()+"')";
		
		
		sPart.executeUpdate(sPartPSQL);
		sPart.close();
		
		dbConnection.commit();

		
	}
	/**
	 * @return return the list of depenses
	 * @throws SQLException
	 */
	public ArrayList<Depense> retrouveDepenses()  throws SQLException {
		ArrayList<Depense> result = new ArrayList<Depense>();
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * from depenses order by dateDep asc");
		while (rs.next()) {
			int depId = rs.getInt("id");
			Statement stmt2 = dbConnection.createStatement();
			ResultSet rs2 = stmt2.executeQuery("SELECT * from depensesPart where idDepense = '"+ depId + "'");
			ArrayList<Integer> benefs = new ArrayList<Integer>();
			while (rs2.next()) {
				benefs.add(rs2.getInt("idProfiteur"));
				
			}
			int[] benefsArray = new int[benefs.size()];
			for (int i = 0; i < benefsArray.length; i++) {
				benefsArray[i] = benefs.get(i);
			}
			
			Depense d = new Depense(rs.getInt("payeur"), rs.getDouble("montant"), benefsArray, rs.getString("dateDep"));
			
			
			result.add(d);

		}

		return result;
	}

}
