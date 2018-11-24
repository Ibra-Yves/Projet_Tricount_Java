package dev.java.tricount.view;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class FenetrePartic extends JFrame {
	
	private JLabel nom;
	private JTextField nomField;
	private JLabel prenom;
	private JTextField prenomField;
	private JButton reinitButton;
	private JButton envoiButton;
	private JButton exitButton;
	private JRadioButton dollar; 
	private JRadioButton euro; 
	private JRadioButton yen; 
	private JRadioButton espece; 
	private JRadioButton paypal; 
	private JRadioButton bancontact; 
	private JLabel devise;
	private JLabel moyPay;
	
	public void init(){
		this.setSize(900,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.nom = new JLabel("Nom : ");
		this.nomField = new JTextField(20);
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(nom);
		this.getContentPane().add(nomField);
		this.pack();
		
		this.prenom = new JLabel("Prénom : ");
		this.prenomField = new JTextField(20);
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(prenom);
		this.getContentPane().add(prenomField);
		this.pack();
		
		this.devise = new JLabel("Devise : ");
		this.getContentPane().add(devise);
		this.dollar = new JRadioButton("Dollar");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(dollar);
		this.pack();
		
		this.euro = new JRadioButton("Euro");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(euro);
		this.pack();
		
		this.yen = new JRadioButton("Yen");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(yen);
		this.pack();
		
		this.moyPay = new JLabel("Moyen de paiement : ");
		this.getContentPane().add(moyPay);
		this.espece = new JRadioButton("Espece");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(espece);
		this.pack();
		
		this.paypal = new JRadioButton("Paypal");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(paypal);
		this.pack();
		
		this.bancontact = new JRadioButton("Bancontact");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(bancontact);
		this.pack();
		
		this.reinitButton = new JButton("Réinitialiser");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(reinitButton);
		//reinitButton.addActionListener(this);
		this.pack();
		
		this.envoiButton = new JButton("Envoi");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(envoiButton);
		//envoiButton.addActionListener(this);
		this.pack();
		
		this.exitButton = new JButton("Quitter");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(exitButton);
		//exitButton.addActionListener(this);
		this.pack();
		
	}
	
	
	
	public FenetrePartic(){
		init();
	}
	public static void main(String [] args){
		FenetrePartic fenetre = new FenetrePartic();
		
	}
}
