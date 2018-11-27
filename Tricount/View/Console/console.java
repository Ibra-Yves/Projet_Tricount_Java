/**
 * 
 */
package dev.java.tricount.view.console;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import dev.java.tricount.model.DBAccess;
import dev.java.tricount.model.Depense;
import dev.java.tricount.model.Participant;

/**
 * @author Gilles
 *
 */
public class TricountConsole {

	private Scanner scan ;
	private DBAccess dbaccess;

	
	
	public TricountConsole() throws SQLException {
		super();
		dbaccess = new DBAccess();
		scan = new Scanner(System.in);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		try {
			TricountConsole console = new TricountConsole();
			console.showMainMenu();
		} catch (SQLException e) {
			displayError(e);
		}
		// console.showParticipants();
	}

	private void showParticipants() {
		try {

			ArrayList<Participant> liste = dbaccess.retrouveParticipants();
			// System.out.println(liste);
			// noms colonne
//			System.out.println("id"+SEP_COL+"nom"+SEP_COL+"prenom");
			System.out.format("%s\t\t%-8s\t\t%-10s%-8s%8s%-8s\n", "id", "nom", "prenom", "solde", "devise", "moyenRemb");
			for (Participant p : liste) {
				System.out.format("%s\t\t%-8s\t\t%-10s%4.2f%8s%-8s\n", p.getId(), p.getNom(), p.getPrenom(), p.getSolde(),
						p.getDevise(), p.getMoyRemb());
			}

		} catch (SQLException e) {
			displayError(e);
		}

	}

	private static void displayError(SQLException e) {
		System.err.println("Problem with DB");
		e.printStackTrace();
	}

	private void showMainMenu() {
		while (true) {
			showParticipants();
			System.out.println("Entrez votre choix [d/r/q]  (dépense/remboursement/quitter)");

			String command = scan.nextLine();
			if (command.equalsIgnoreCase("d")) {
				entrezNouvelleDepense();
			} else if (command.equalsIgnoreCase("r")) {

			} else if (command.equalsIgnoreCase("q")) {
				System.exit(0);
			}
		}
	}

	private void entrezNouvelleDepense() {
		System.out.println("nouvelle dépense : Entrez le montant ");
		double m = scan.nextDouble();
		System.out.println("Entrez l'id du payeur");
		int id = scan.nextInt();
		System.out.println("Combien de profiteurs ? ");
		int nbProf = scan.nextInt();
		int[] profiteurs = new int[nbProf];
		for (int i = 0; i < profiteurs.length; i++) {
			System.out.println("Id du profiteur ?");
			int idProf = scan.nextInt();
			profiteurs[i]= idProf;
		}
		//  souci pour scanner après un int ??
		//scan.reset();
		String  blabla = scan.nextLine();
		
		System.out.println("confirmez o/n");
		String confirm = scan.nextLine();
		if (confirm.equalsIgnoreCase("o"))
		{

			Depense d = new Depense(id, m, profiteurs);

			try {
				dbaccess.enregistreDepense(d);

				System.out.println("dépense enregistrée");

			} catch (SQLException e) {
				displayError(e);
			}

		}
	}

}

