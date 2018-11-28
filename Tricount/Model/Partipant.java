/**
 * 
 */
package dev.java.tricount.model;

/**
 * @author Rémy
 *
 */
public class Participant {

	private String nom;
	private String prenom;
	private String devise;
	private String moyRemb;
	
	public Participant(String nom, String prenom , String devise , String moyRemb) {
		this.nom= nom;
		this.prenom = prenom;
		this.devise= devise;
		this.moyRemb= moyRemb;
	}

	@Override
	public String toString() {
		return "{nom:" + nom + ", prenom:" + prenom + ", devise:" + devise + ", moyRemb:" + moyRemb+ "}" ;
	}
	

	
	
}


