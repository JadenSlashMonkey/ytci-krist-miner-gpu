package com.ytci.kristminer.gui.views;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Random;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Configuration panel for KristMinerGUI
 * @author apemanzilla
 *
 */
@SuppressWarnings("serial")
public class ConfigPanel extends JPanel {

	private JTextField tfAddress, tfPrefix;
	private JButton btnStart, btnStop;
	
	/**
	 * Create the panel.
	 */
	public ConfigPanel() {
		setBorder(new TitledBorder(null, "Settings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_configPanel = new GridBagLayout();
		gbl_configPanel.columnWidths = new int[]{75, 150, 0};
		gbl_configPanel.rowHeights = new int[]{20, 20, 0, 0};
		gbl_configPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_configPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_configPanel);
		
		String addressTooltip = "The address to mine Krist for";
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setToolTipText(addressTooltip);
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 0;
		add(lblAddress, gbc_lblAddress);
		
		tfAddress = new JTextField();
		tfAddress.setToolTipText(addressTooltip);
		lblAddress.setLabelFor(tfAddress);
		GridBagConstraints gbc_tfAddress = new GridBagConstraints();
		gbc_tfAddress.fill = GridBagConstraints.BOTH;
		gbc_tfAddress.insets = new Insets(0, 0, 5, 0);
		gbc_tfAddress.gridx = 1;
		gbc_tfAddress.gridy = 0;
		add(tfAddress, gbc_tfAddress);
		tfAddress.setColumns(10);
		
		String prefixTooltip = "Prefix for submitted nonces - if you use multiple machines, make sure each one has a different prefix!";
		
		JLabel lblPrefix = new JLabel("Prefix");
		lblPrefix.setToolTipText(prefixTooltip);
		GridBagConstraints gbc_lblPrefix = new GridBagConstraints();
		gbc_lblPrefix.anchor = GridBagConstraints.EAST;
		gbc_lblPrefix.fill = GridBagConstraints.VERTICAL;
		gbc_lblPrefix.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrefix.gridx = 0;
		gbc_lblPrefix.gridy = 1;
		add(lblPrefix, gbc_lblPrefix);
		
		// Randomly generate a prefix on launch
		tfPrefix = new JTextField(Integer.toString(new Random().nextInt(46655),36));
		tfPrefix.setToolTipText(prefixTooltip);
		lblPrefix.setLabelFor(tfPrefix);
		GridBagConstraints gbc_tfPrefix = new GridBagConstraints();
		gbc_tfPrefix.insets = new Insets(0, 0, 5, 0);
		gbc_tfPrefix.fill = GridBagConstraints.BOTH;
		gbc_tfPrefix.gridx = 1;
		gbc_tfPrefix.gridy = 1;
		add(tfPrefix, gbc_tfPrefix);
		tfPrefix.setColumns(10);
		
		Box controlBox = Box.createHorizontalBox();
		GridBagConstraints gbc_controlBox = new GridBagConstraints();
		gbc_controlBox.gridwidth = 2;
		gbc_controlBox.gridx = 0;
		gbc_controlBox.gridy = 2;
		add(controlBox, gbc_controlBox);
		
		btnStart = new JButton("Start Mining");
		controlBox.add(btnStart);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		controlBox.add(horizontalStrut);
		
		btnStop = new JButton("Stop Mining");
		btnStop.setEnabled(false);
		controlBox.add(btnStop);
		
	}

}
