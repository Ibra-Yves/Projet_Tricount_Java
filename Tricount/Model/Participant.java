/**
 * 
 */
package dev.java.tricount.model;

import java.util.ArrayList;

/**
 * @author Gilles
 *
 */
public class Participant {
	
	private int id;
	private String nom;
	private String prenom;
	private String devise;
	private String moyRemb;
	private double solde;
	
	
	public Participant(int id ,String nom, String prenom , String devise , String moyRemb, double solde) {
		
		this.id= id;
		this.nom= nom;
		this.prenom = prenom;
		this.devise= devise;
		this.moyRemb= moyRemb;
		this.solde = solde;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getDevise() {
		return devise;
	}

	public String getMoyRemb() {
		return moyRemb;
	}

	public double getSolde() {
		return solde;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", nom:" + nom + ", prenom:" + prenom + ", devise:" + devise + ", moyRemb:" + moyRemb+ ", solde: " +solde+ "}" ;
	}
	
	/**
	 * @param participants : !!! ATTENTION  Le solde des participants dans ce paramètre input est modifié par la méthode 
	 * @return renvoie la liste des remboursements 
	 */
	public static ArrayList<Remboursement> calculerRemboursements(ArrayList<Participant> participants) {
		if(participants == null || participants.size() == 0) {
			throw new IllegalArgumentException();
		}
		
		ArrayList<Remboursement> result = new ArrayList<Remboursement>();
		boolean finished = false;
		do {
			Participant maxCrediteur = null;
			Participant  maxDebiteur = null;

			for (Participant p : participants) {
				if ((maxCrediteur== null) || (p.getSolde()>maxCrediteur.getSolde())) {
					maxCrediteur = p;
				}
				if ((maxDebiteur== null) || (p.getSolde()<maxDebiteur.getSolde())) {
					maxDebiteur = p;
				}
			}
//			if(Math.abs(maxCrediteur.getSolde())-Math.abs(maxDebiteur.getSolde())<0.10 || maxCrediteur == maxDebiteur) {
			if(Math.abs(maxCrediteur.getSolde())<0.20) {
				finished = true;
			}
			else {
				double montantRemb100 = 100*Math.min(Math.abs(maxCrediteur.getSolde()), Math.abs(maxDebiteur.getSolde()));
				double montantRemb = Math.round(montantRemb100)/100.0;
				Remboursement remb = new Remboursement(maxDebiteur.getId(), montantRemb, maxDebiteur.getDevise(), maxCrediteur.getId(), maxCrediteur.getDevise(), maxCrediteur.getMoyRemb());
				maxCrediteur.solde -= montantRemb;
				maxDebiteur.solde += montantRemb;
				result.add(remb);
			}
			
		} while (finished == false);
		
		return result;
		
	}
	
	
}
