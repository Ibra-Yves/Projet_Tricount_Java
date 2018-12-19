package dev.java.tricount.view.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dev.java.tricount.model.DBAccess;
import dev.java.tricount.model.Depense;
import dev.java.tricount.model.Participant;
import dev.java.tricount.model.Remboursement;

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

	public void montrerRemboursements() {
		
		ArrayList<Participant> participants;
		try {
			participants = dbaccess.retrouveParticipants();
			
			Vector<String>  colNames = new Vector();
			colNames.add("id débiteur");
			colNames.add("montant à rembourser");
			colNames.add("id Créditeur");
			colNames.add("montant à recevoir");
			colNames.add("moyen de paiement");
			
			ArrayList<Remboursement> rembs = Participant.calculerRemboursements(participants);
			Vector<Vector<String>> contenuTable = new Vector<Vector<String>>();
			
			for (Remboursement r : rembs) {
				Vector<String> ligne = new Vector<String>();
				ligne.add(Integer.toString(r.getIdDeb()));
				ligne.add(r.getMontantDeb()+ " " + r.getDevDeb());
				ligne.add(Integer.toString(r.getIdBenef()));
				ligne.add(r.getMontantBenef()+ " " + r.getDevBenef());
				ligne.add(r.getMoyRemb());
				contenuTable.add(ligne);
			}
			
			TableModel tmRembs = new DefaultTableModel(contenuTable, colNames);
			FenetreRemboursements fenetreR = new FenetreRemboursements(jframe, tmRembs);
			fenetreR.pack();
			fenetreR.show();
		} catch (SQLException e) {
			showSQLException(e);
			e.printStackTrace();
		}

		
		
	}

	public void montrerHistorique() {
		
		ArrayList<Depense> depenses;
		try {
			depenses = dbaccess.retrouveDepenses();
			
			Vector<String>  colNames = new Vector();
			colNames.add("date");
			colNames.add("id Payeur");
			colNames.add("Montant ");
			colNames.add("Id Profiteurs");
			
			
			
			Vector<Vector<String>> contenuTable = new Vector<Vector<String>>();
			
			for (Depense d : depenses) {
				Vector<String> ligne = new Vector<String>();
				ligne.add(d.getDate());
			
				ligne.add(Integer.toString(d.getIdPayeur()));
				ligne.add(Double.toString(d.getMontant()));
				String profs = "";
				for (int i = 0; i < d.getProfiteurs().length; i++) {
					profs += d.getProfiteurs()[i];
					if (i < d.getProfiteurs().length-1) {
						profs += ",";

					}
				}
				ligne.add(profs);
				contenuTable.add(ligne);
			}
			
			TableModel tmRembs = new DefaultTableModel(contenuTable, colNames);
			FenetreHistoDepenses fenetreH = new FenetreHistoDepenses(jframe, tmRembs);
			fenetreH.pack();
			fenetreH.show();
		} catch (SQLException e) {
			showSQLException(e);
			e.printStackTrace();
		}

		
		
	}

}
