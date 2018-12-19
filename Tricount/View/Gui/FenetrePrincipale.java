package dev.java.tricount.view.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class FenetrePrincipale extends JPanel {
	private GuiController controller;
	private JTable  table;
	private JScrollPane  scrollPane;
	
	public JTable getTable() {
		return table;
	}
	public FenetrePrincipale(GuiController controller) {
		this();
		this.controller = controller;
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	public FenetrePrincipale() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{139, 139, 0};
		gbl_panel.rowHeights = new int[]{50, 50, 50, 50, 50, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnAjouterDpense = new JButton("Ajouter D\u00E9pense");
		btnAjouterDpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.montrerFenetreAjouterDepense();
			}
		});
		GridBagConstraints gbc_btnAjouterDpense = new GridBagConstraints();
		gbc_btnAjouterDpense.insets = new Insets(10, 10, 10, 10);
		gbc_btnAjouterDpense.gridx = 0;
		gbc_btnAjouterDpense.gridy = 0;
		panel.add(btnAjouterDpense, gbc_btnAjouterDpense);
		
		JButton btnCalculerRemboursement = new JButton("Calculer Remboursement");
		btnCalculerRemboursement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.montrerRemboursements();
				
			}
		});
		GridBagConstraints gbc_btnCalculerRemboursement = new GridBagConstraints();
		gbc_btnCalculerRemboursement.insets = new Insets(10, 10, 10, 10);
		gbc_btnCalculerRemboursement.gridx = 0;
		gbc_btnCalculerRemboursement.gridy = 3;
		panel.add(btnCalculerRemboursement, gbc_btnCalculerRemboursement);
		
		JButton btnAfficherHistorique = new JButton("Afficher historique des dépenses");
		btnAfficherHistorique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.montrerHistorique();
				
			}
		});
		GridBagConstraints gbc_btnAfficherHistorique = new GridBagConstraints();
		gbc_btnAfficherHistorique.insets = new Insets(10, 10, 10, 10);
		gbc_btnAfficherHistorique.gridx = 0;
		gbc_btnAfficherHistorique.gridy = 2;
		panel.add(btnAfficherHistorique, gbc_btnAfficherHistorique);
		
		JButton btnAjouterParticipant = new JButton("Ajouter Participant");
		btnAjouterParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.montrerFenetreAjouterParticipant();
			}
		});
		GridBagConstraints gbc_btnAjouterParticipant = new GridBagConstraints();
		gbc_btnAjouterParticipant.insets = new Insets(10, 10, 10, 10);
		gbc_btnAjouterParticipant.fill = GridBagConstraints.BOTH;
		gbc_btnAjouterParticipant.gridx = 0;
		gbc_btnAjouterParticipant.gridy = 1;
		panel.add(btnAjouterParticipant, gbc_btnAjouterParticipant);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, BorderLayout.CENTER);
		
		this.scrollPane = scrollPane;
	}

	public static void main(String[] args) {
		JFrame jframe = new JFrame("test");
	
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jframe.setContentPane(new FenetrePrincipale());
		jframe.pack();
		jframe.show();
	}

}

