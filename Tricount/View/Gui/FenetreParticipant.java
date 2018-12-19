package dev.java.tricount.view.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import dev.java.tricount.model.Participant;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreParticipant extends JDialog {
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private GuiController controller;
	private JRadioButton rdbtnEur;
	private JRadioButton rdbtnUsd;
	private JRadioButton rdbtnYen;
	private JRadioButton rdbtnPaypal;
	private JRadioButton rdbtnVirement;
	private JRadioButton rdbtnCash;
	

	
	/**
	 * @wbp.parser.constructor
	 */
	public FenetreParticipant(Frame parent) {
		super(parent, true);
		
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnSauver = new JButton("Sauver");
		btnSauver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.sauverParticipant(getParticipant());
				FenetreParticipant.this.dispose();
			}
		});
		buttonPanel.add(btnSauver);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetreParticipant.this.dispose();

			}
		});
		buttonPanel.add(btnAnnuler);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 50, 50, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNom = new JLabel("Nom :");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 0;
		panel.add(lblNom, gbc_lblNom);
		
		textFieldNom = new JTextField();
		GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
		gbc_textFieldNom.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNom.gridx = 1;
		gbc_textFieldNom.gridy = 0;
		panel.add(textFieldNom, gbc_textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		GridBagConstraints gbc_lblPrnom = new GridBagConstraints();
		gbc_lblPrnom.anchor = GridBagConstraints.EAST;
		gbc_lblPrnom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrnom.gridx = 0;
		gbc_lblPrnom.gridy = 1;
		panel.add(lblPrnom, gbc_lblPrnom);
		
		textFieldPrenom = new JTextField();
		GridBagConstraints gbc_textFieldPrenom = new GridBagConstraints();
		gbc_textFieldPrenom.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrenom.gridx = 1;
		gbc_textFieldPrenom.gridy = 1;
		panel.add(textFieldPrenom, gbc_textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		JLabel lblDevise = new JLabel("Devise :");
		GridBagConstraints gbc_lblDevise = new GridBagConstraints();
		gbc_lblDevise.insets = new Insets(0, 0, 5, 5);
		gbc_lblDevise.gridx = 0;
		gbc_lblDevise.gridy = 2;
		panel.add(lblDevise, gbc_lblDevise);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		
		rdbtnEur = new JRadioButton("EUR");
		rdbtnEur.setSelected(true);
		panel_1.add(rdbtnEur);
		
		
		rdbtnUsd = new JRadioButton("USD");
		panel_1.add(rdbtnUsd);
		
		
		rdbtnYen = new JRadioButton("YEN");
		panel_1.add(rdbtnYen);
		
		
		ButtonGroup devises = new ButtonGroup();
		devises.add(rdbtnEur);
		devises.add(rdbtnUsd);
		devises.add(rdbtnYen);
		
		JLabel lblMoyenDePaiement = new JLabel("Moyen de Paiement :");
		GridBagConstraints gbc_lblMoyenDePaiement = new GridBagConstraints();
		gbc_lblMoyenDePaiement.insets = new Insets(0, 0, 0, 5);
		gbc_lblMoyenDePaiement.gridx = 0;
		gbc_lblMoyenDePaiement.gridy = 3;
		panel.add(lblMoyenDePaiement, gbc_lblMoyenDePaiement);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 3;
		panel.add(panel_2, gbc_panel_2);
		
		rdbtnPaypal = new JRadioButton("Paypal");
		rdbtnPaypal.setSelected(true);
		panel_2.add(rdbtnPaypal);
		
		
		rdbtnVirement = new JRadioButton("Virement");
		panel_2.add(rdbtnVirement);
		
		
		rdbtnCash = new JRadioButton("Cash");
		panel_2.add(rdbtnCash);
		
		
		ButtonGroup boutonsMoyRemb = new ButtonGroup();
	boutonsMoyRemb.add(rdbtnCash);
	boutonsMoyRemb.add(rdbtnVirement);
	boutonsMoyRemb.add(rdbtnPaypal);
	
	
	}
	
	
	
	public Participant getParticipant()
	{
		String nom = textFieldNom.getText();
		String prenom = textFieldPrenom.getText();
		String devise = "";
		if (getRdbtnEur().isSelected())
		{
			devise = "EUR";
		}
		else if (getRdbtnUsd().isSelected()) {
			devise = "USD";
		}
		else if (getRdbtnYen().isSelected()) {
			devise = "YEN";
		}
		String moyRemb = "";
		if(getRdbtnCash().isSelected()) {
			moyRemb = "Cash";
		}
		else if (getRdbtnPaypal().isSelected()) {
			moyRemb = "Paypal";
		}
		else if (getRdbtnVirement().isSelected()) {
			moyRemb = "Virement";
		}
		
				
		return new Participant(-1, nom, prenom, devise, moyRemb,0 );
	}

	





	public FenetreParticipant(JFrame jframe, GuiController controller) {
		this(jframe);
		this.controller = controller;
	}

	public static void main(String[] args) {
		FenetreParticipant dialog = new FenetreParticipant(null);
		dialog.pack();
		dialog.show();

	}

	public JRadioButton getRdbtnEur() {
		return rdbtnEur;
	}
	public JRadioButton getRdbtnUsd() {
		return rdbtnUsd;
	}
	public JRadioButton getRdbtnYen() {
		return rdbtnYen;
	}
	public JRadioButton getRdbtnPaypal() {
		return rdbtnPaypal;
	}
	public JRadioButton getRdbtnVirement() {
		return rdbtnVirement;
	}
	public JRadioButton getRdbtnCash() {
		return rdbtnCash;
	}

}
