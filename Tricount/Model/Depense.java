package dev.java.tricount.model;

import java.util.ArrayList;

public class Depense {
	private int idPayeur;
	private double montant;
	private int[] profiteurs;
	
	public Depense(int idPayeur, double montant, int[] profiteurs) {
		this.idPayeur= idPayeur;
		this.montant= montant;
		this.profiteurs = profiteurs;
		
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
