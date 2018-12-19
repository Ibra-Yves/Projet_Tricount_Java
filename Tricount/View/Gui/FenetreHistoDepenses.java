package dev.java.tricount.view.gui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class FenetreHistoDepenses extends JDialog {
	private JTable table;
	
	public FenetreHistoDepenses( Frame parent, TableModel tableModel) {
		this(parent);
		table.setModel(tableModel);
	}
	
	public FenetreHistoDepenses(Frame parent) {
		super(parent, true);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetreHistoDepenses.this.dispose();
			}
		});
		panel.add(btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
