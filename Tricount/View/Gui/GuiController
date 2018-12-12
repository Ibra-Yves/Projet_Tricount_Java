package dev.java.tricount.view.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dev.java.tricount.model.DBAccess;
import dev.java.tricount.model.Depense;
import dev.java.tricount.model.Participant;

public class GuiController {
	
	private FenetrePrincipale fenetrePrincipale;
	private JFrame jframe;
	private DBAccess dbaccess;

	public GuiController()
	{
		jframe = new JFrame("test");
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fenetrePrincipale = new FenetrePrincipale(this);
		try {
			initDBConn();
			initFenetrePrincipaleTable();
		} catch (SQLException e) {
			showSQLException(e);
			e.printStackTrace();
		}
		
		jframe.setContentPane(fenetrePrincipale);
		


	}
	
	private void showSQLException(SQLException e) {
		JOptionPane.showMessageDialog(jframe, e.getMessage(), "Problème DB", JOptionPane.ERROR_MESSAGE);
		
	}

	private void initDBConn() throws SQLException {
		
		dbaccess = new DBAccess();
	}

	private void initFenetrePrincipaleTable() throws SQLException {
		//JTable(Vector rowData, Vector columnNames);
		JTable table = fenetrePrincipale.getTable();
		Vector<String>  colNames = new Vector();
		colNames.add("Id");
		colNames.add("Nom");
		colNames.add("Prénom");
		colNames.add("Solde");
		colNames.add("Dev");
		
		
		ArrayList<Participant> participants = dbaccess.retrouveParticipants();

		
		Vector<Vector<String>> contenuTable = new Vector<Vector<String>>();
		for (Participant p : participants) {
			Vector<String> ligne = new Vector<String>();
			ligne.add(Integer.toString(p.getId()));
			ligne.add(p.getNom());
			ligne.add(p.getPrenom());
			ligne.add(Double.toString(p.getSolde()));
			ligne.add("EUR");
			contenuTable.add(ligne);
		}
		
		table.setModel(new DefaultTableModel(contenuTable, colNames));
		
	}

	public void start()
	{
		jframe.pack();
		jframe.setVisible(true);
	}

	public static void main(String[] args) {
		
		GuiController controller = new GuiController();
		controller.start();

	}

	public void montrerFenetreAjouterParticipant() {
		FenetreParticipant fenetreP = new FenetreParticipant(jframe,this );
		fenetreP.pack();
		fenetreP.show();
		
	}
	public void montrerFenetreAjouterDepense() {
		FenetreDepense fenetreD = new FenetreDepense(jframe,this );
		fenetreD.pack();
		fenetreD.show();
		
	}

	public void sauverParticipant(Participant participant) {
		try {
			dbaccess.creerParticipant(participant);
			initFenetrePrincipaleTable();
		} catch (SQLException e) {
			showSQLException(e);
			e.printStackTrace();
		}
		
	}

	public void ajouterDepense(Depense depense) {
		try {
			dbaccess.enregistreDepense(depense);
			initFenetrePrincipaleTable();
		} catch (SQLException e) {
			showSQLException(e);
			e.printStackTrace();
		}
	}

}
