package dev.java.tricount.model;

import java.util.ArrayList;

public class Depense {
	private int idPayeur;
	private double montant;
	private int[] profiteurs;
	private String date;
	
	public Depense(int idPayeur, double montant, int[] profiteurs) {
		this.idPayeur= idPayeur;
		this.montant= montant;
		this.profiteurs = profiteurs;
		for (int i = 0; i < profiteurs.length; i++) {
			if(profiteurs[i] == idPayeur) {
				throw new IllegalArgumentException("Le payeur ne peut pas Ítre dans les profiteurs");
			}
		}
	}
	
	public Depense(int idPayeur, double montant, int[] profiteurs,String date) {
		this(idPayeur, montant, profiteurs);
		this.date = date;
	}
	
	
	public String getDate() {
		return date;
	}

	public int getIdPayeur() {
		return idPayeur;
	}


	public double getMontant() {
		return montant;
	}


	public int[] getProfiteurs() {
		return profiteurs;
	}


	/**
	 * @return renvoie la liste des modifications de solde aprËs une dÈpense
	 */
	public ArrayList<ModificationSolde> getModifsSolde()
	{
		double partieMontant = montant/(profiteurs.length+1);
		ArrayList<ModificationSolde>  result = new ArrayList<ModificationSolde>();
		result.add(new ModificationSolde(idPayeur, montant-partieMontant));
		for (int i = 0; i < profiteurs.length; i++) {
			result.add(new ModificationSolde(profiteurs[i], -partieMontant));
		}
		return result;
	}
	
public static void main(String[] args) {
		

	}
}
