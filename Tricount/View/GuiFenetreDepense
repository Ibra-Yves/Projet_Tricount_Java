package dev.java.tricount.view.gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dev.java.tricount.model.Depense;

public class FenetreDepense extends JDialog {
	private JTextField textFieldMontant;
	private JTextField textFieldIdPayeur;
	private JTextField textFieldIdProfs;
	private GuiController controller;
	
	
	public FenetreDepense(JFrame f ,GuiController controller ) {
		this(f);
		this.controller = controller;
	}
	public FenetreDepense(Frame f) {
		super(f, true);
		JPanel Parametres = new JPanel();
		getContentPane().add(Parametres, BorderLayout.CENTER);
		GridBagLayout gbl_Parametres = new GridBagLayout();
		gbl_Parametres.columnWidths = new int[]{0, 0, 0};
		gbl_Parametres.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_Parametres.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_Parametres.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Parametres.setLayout(gbl_Parametres);
		
		JLabel lblMontant = new JLabel("Montant :");
		GridBagConstraints gbc_lblMontant = new GridBagConstraints();
		gbc_lblMontant.insets = new Insets(0, 0, 5, 5);
		gbc_lblMontant.anchor = GridBagConstraints.EAST;
		gbc_lblMontant.gridx = 0;
		gbc_lblMontant.gridy = 0;
		Parametres.add(lblMontant, gbc_lblMontant);
		
		textFieldMontant = new JTextField();
		GridBagConstraints gbc_textFieldMontant = new GridBagConstraints();
		gbc_textFieldMontant.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldMontant.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMontant.gridx = 1;
		gbc_textFieldMontant.gridy = 0;
		Parametres.add(textFieldMontant, gbc_textFieldMontant);
		textFieldMontant.setColumns(10);
		
		JLabel lblIdPayeur = new JLabel("Id Payeur :");
		GridBagConstraints gbc_lblIdPayeur = new GridBagConstraints();
		gbc_lblIdPayeur.anchor = GridBagConstraints.EAST;
		gbc_lblIdPayeur.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdPayeur.gridx = 0;
		gbc_lblIdPayeur.gridy = 1;
		Parametres.add(lblIdPayeur, gbc_lblIdPayeur);
		
		textFieldIdPayeur = new JTextField();
		GridBagConstraints gbc_textFieldIdPayeur = new GridBagConstraints();
		gbc_textFieldIdPayeur.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldIdPayeur.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIdPayeur.gridx = 1;
		gbc_textFieldIdPayeur.gridy = 1;
		Parametres.add(textFieldIdPayeur, gbc_textFieldIdPayeur);
		textFieldIdPayeur.setColumns(10);
		
		JLabel lblIdsProfiteurs = new JLabel("Ids profiteurs : ");
		GridBagConstraints gbc_lblIdsProfiteurs = new GridBagConstraints();
		gbc_lblIdsProfiteurs.anchor = GridBagConstraints.EAST;
		gbc_lblIdsProfiteurs.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdsProfiteurs.gridx = 0;
		gbc_lblIdsProfiteurs.gridy = 2;
		Parametres.add(lblIdsProfiteurs, gbc_lblIdsProfiteurs);
		
		textFieldIdProfs = new JTextField();
		GridBagConstraints gbc_textFieldIdProfs = new GridBagConstraints();
		gbc_textFieldIdProfs.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldIdProfs.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIdProfs.gridx = 1;
		gbc_textFieldIdProfs.gridy = 2;
		Parametres.add(textFieldIdProfs, gbc_textFieldIdProfs);
		textFieldIdProfs.setColumns(10);
		
		JLabel lblDiffrentsIdsSpars = new JLabel("(diff\u00E9rents Ids s\u00E9par\u00E9s par une virgule)");
		GridBagConstraints gbc_lblDiffrentsIdsSpars = new GridBagConstraints();
		gbc_lblDiffrentsIdsSpars.gridx = 1;
		gbc_lblDiffrentsIdsSpars.gridy = 3;
		Parametres.add(lblDiffrentsIdsSpars, gbc_lblDiffrentsIdsSpars);
		
		JPanel Boutons = new JPanel();
		getContentPane().add(Boutons, BorderLayout.SOUTH);
		
		JButton btnSauver = new JButton("Sauver");
		btnSauver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ajouterDepense(getDepense());
				FenetreDepense.this.dispose();
			}
		});
		Boutons.add(btnSauver);
	
		JButton btnQuitter = new JButton("Quitter");
		Boutons.add(btnQuitter);
	}
	public Depense getDepense() {
		
		int idPayeur = Integer.parseInt(textFieldIdPayeur.getText());
		double montant = Double.parseDouble(textFieldMontant.getText());
		String profStr = textFieldIdProfs.getText();
		String[] split = profStr.split(",");
		
		int[] profiteurs = new int[split.length];
		for (int i = 0; i < profiteurs.length; i++) {
			profiteurs[i] = Integer.parseInt(split[i]);
		}
	
		
		return new Depense(idPayeur, montant , profiteurs);
	}
	
}
