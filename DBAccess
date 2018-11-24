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

	}

	public ArrayList<Participant> retrouveParticipants() throws SQLException {
		ArrayList<Participant> result = new ArrayList<Participant>();
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * from participants");
		while (rs.next()) {

			Participant p = new Participant(rs.getString("nom"), rs.getString("prenom"), "eur", "Paypal"); // rs.getString("devise"),rs.getString("moyRemb"));

			result.add(p);

		}

		return result;
	}

}
