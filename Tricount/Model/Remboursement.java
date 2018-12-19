package dev.java.tricount.model;

public class Remboursement {
	
	
	//  1 eur =  1,13  usd
	//  1 eur =  128,29  yen
	public static final double CONVERSION_FACTOR_TO_USD = 1.13;
	public static final double CONVERSION_FACTOR_TO_YEN = 128.29;
	
	private int idDeb;
	private double montantEur;
	private double montantDeb;
	private String devDeb;
	private int idBenef;
	private double montantBenef;
	private String devBenef;
	private String moyRemb;
	
	
	public Remboursement(int idDeb, double montantEur, String devDeb, int idBenef, String devBenef, String moyRemb) {
		super();
		this.idDeb = idDeb;
		this.montantEur = montantEur;
		this.devDeb = devDeb;
		this.idBenef = idBenef;
		this.devBenef = devBenef;
		this.moyRemb = moyRemb;
		
		
		//this.devDeb = "EUR";
		this.montantDeb = convert(montantEur, this.devDeb);
	//	this.devBenef = "EUR";
		this.montantBenef = convert(montantEur, this.devBenef);
		
	}
	
	/**
	 * @param amountEur
	 * @param devise
	 * @return return the amount converted in the right currency
	 */
	private static double convert(double amountEur, String devise) {
		switch (devise) {
		case "EUR":
			return amountEur;

		case "USD":
			return amountEur*CONVERSION_FACTOR_TO_USD;
		
		case "YEN":
			return amountEur*CONVERSION_FACTOR_TO_YEN;
	
		default:
			throw new IllegalArgumentException("Devise "+ devise+" non supportÈe");
		}
	}


	public int getIdDeb() {
		return idDeb;
	}


	public double getMontantEur() {
		return montantEur;
	}


	public double getMontantDeb() {
		return montantDeb;
	}


	public String getDevDeb() {
		return devDeb;
	}


	public int getIdBenef() {
		return idBenef;
	}


	public double getMontantBenef() {
		return montantBenef;
	}


	public String getDevBenef() {
		return devBenef;
	}


	public String getMoyRemb() {
		return moyRemb;
	}
	
	
	
}
