package com.ytci.kristminer.gui.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Status panel for KristMinerGUI
 * @author apemanzilla
 *
 */
@SuppressWarnings("serial")
public class StatusPanel extends JPanel {

	private JTextField tfBalance, tfHashrate, tfBlocksMined;
	
	/**
	 * Create the panel.
	 */
	public StatusPanel() {
		setBorder(new TitledBorder(null, "Miner Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_statusPanel = new GridBagLayout();
		gbl_statusPanel.columnWidths = new int[]{75, 150, 0};
		gbl_statusPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_statusPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_statusPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_statusPanel);
		
		JLabel lblBalance = new JLabel("Balance");
		GridBagConstraints gbc_lblBalance = new GridBagConstraints();
		gbc_lblBalance.insets = new Insets(0, 0, 5, 5);
		gbc_lblBalance.anchor = GridBagConstraints.EAST;
		gbc_lblBalance.gridx = 0;
		gbc_lblBalance.gridy = 0;
		add(lblBalance, gbc_lblBalance);
		
		tfBalance = new JTextField();
		tfBalance.setEditable(false);
		GridBagConstraints gbc_tfBalance = new GridBagConstraints();
		gbc_tfBalance.insets = new Insets(0, 0, 5, 0);
		gbc_tfBalance.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBalance.gridx = 1;
		gbc_tfBalance.gridy = 0;
		add(tfBalance, gbc_tfBalance);
		tfBalance.setColumns(10);
		
		JLabel lblHashrate = new JLabel("Hashrate");
		GridBagConstraints gbc_lblHashrate = new GridBagConstraints();
		gbc_lblHashrate.anchor = GridBagConstraints.EAST;
		gbc_lblHashrate.insets = new Insets(0, 0, 5, 5);
		gbc_lblHashrate.gridx = 0;
		gbc_lblHashrate.gridy = 1;
		add(lblHashrate, gbc_lblHashrate);
		
		tfHashrate = new JTextField();
		tfHashrate.setEditable(false);
		GridBagConstraints gbc_tfHashrate = new GridBagConstraints();
		gbc_tfHashrate.insets = new Insets(0, 0, 5, 0);
		gbc_tfHashrate.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfHashrate.gridx = 1;
		gbc_tfHashrate.gridy = 1;
		add(tfHashrate, gbc_tfHashrate);
		tfHashrate.setColumns(10);
		
		JLabel lblBlocksMined = new JLabel("Blocks Mined");
		GridBagConstraints gbc_lblBlocksMined = new GridBagConstraints();
		gbc_lblBlocksMined.anchor = GridBagConstraints.EAST;
		gbc_lblBlocksMined.insets = new Insets(0, 0, 0, 5);
		gbc_lblBlocksMined.gridx = 0;
		gbc_lblBlocksMined.gridy = 2;
		add(lblBlocksMined, gbc_lblBlocksMined);
		
		tfBlocksMined = new JTextField();
		tfBlocksMined.setEditable(false);
		GridBagConstraints gbc_tfBlocksMined = new GridBagConstraints();
		gbc_tfBlocksMined.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBlocksMined.gridx = 1;
		gbc_tfBlocksMined.gridy = 2;
		add(tfBlocksMined, gbc_tfBlocksMined);
		tfBlocksMined.setColumns(10);
	}

}
