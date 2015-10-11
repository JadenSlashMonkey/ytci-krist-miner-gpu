package com.ytci.kristminer.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Random;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.Box;
import java.awt.Component;

@SuppressWarnings("serial")
public class KristMinerGUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField tfAddress;
	private JTextField tfPrefix;
	private JButton btnStart;
	private JPanel statusPanel;
	private Box controlBox;
	private JButton btnStop;
	private Component horizontalStrut;
	private JLabel lblBalance;
	private JTextField tfBalance;
	private JLabel lblHashrate;
	private JTextField tfHashrate;
	private JLabel lblBlocksMined;
	private JTextField tfBlocksMined;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KristMinerGUI frame = new KristMinerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public KristMinerGUI() {
		setMinimumSize(new Dimension(300, 250));
		setTitle("Krist Miner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 250);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel configPanel = new JPanel();
		configPanel.setBorder(new TitledBorder(null, "Settings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(configPanel, BorderLayout.NORTH);
		GridBagLayout gbl_configPanel = new GridBagLayout();
		gbl_configPanel.columnWidths = new int[]{75, 150, 0};
		gbl_configPanel.rowHeights = new int[]{20, 20, 0, 0};
		gbl_configPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_configPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		configPanel.setLayout(gbl_configPanel);
		
		String addressTooltip = "The address to mine Krist for";
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setToolTipText(addressTooltip);
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 0;
		configPanel.add(lblAddress, gbc_lblAddress);
		
		tfAddress = new JTextField();
		tfAddress.setToolTipText(addressTooltip);
		lblAddress.setLabelFor(tfAddress);
		GridBagConstraints gbc_tfAddress = new GridBagConstraints();
		gbc_tfAddress.fill = GridBagConstraints.BOTH;
		gbc_tfAddress.insets = new Insets(0, 0, 5, 0);
		gbc_tfAddress.gridx = 1;
		gbc_tfAddress.gridy = 0;
		configPanel.add(tfAddress, gbc_tfAddress);
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
		configPanel.add(lblPrefix, gbc_lblPrefix);
		
		// Randomly generate a prefix on launch
		tfPrefix = new JTextField(Integer.toString(new Random().nextInt(5000),36));
		tfPrefix.setToolTipText(prefixTooltip);
		lblPrefix.setLabelFor(tfPrefix);
		GridBagConstraints gbc_tfPrefix = new GridBagConstraints();
		gbc_tfPrefix.insets = new Insets(0, 0, 5, 0);
		gbc_tfPrefix.fill = GridBagConstraints.BOTH;
		gbc_tfPrefix.gridx = 1;
		gbc_tfPrefix.gridy = 1;
		configPanel.add(tfPrefix, gbc_tfPrefix);
		tfPrefix.setColumns(10);
		
		controlBox = Box.createHorizontalBox();
		GridBagConstraints gbc_controlBox = new GridBagConstraints();
		gbc_controlBox.gridwidth = 2;
		gbc_controlBox.gridx = 0;
		gbc_controlBox.gridy = 2;
		configPanel.add(controlBox, gbc_controlBox);
		
		btnStart = new JButton("Start Mining");
		controlBox.add(btnStart);
		
		horizontalStrut = Box.createHorizontalStrut(10);
		controlBox.add(horizontalStrut);
		
		btnStop = new JButton("Stop Mining");
		btnStop.setEnabled(false);
		controlBox.add(btnStop);
		
		statusPanel = new JPanel();
		statusPanel.setBorder(new TitledBorder(null, "Miner Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(statusPanel, BorderLayout.CENTER);
		GridBagLayout gbl_statusPanel = new GridBagLayout();
		gbl_statusPanel.columnWidths = new int[]{75, 150, 0};
		gbl_statusPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_statusPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_statusPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		statusPanel.setLayout(gbl_statusPanel);
		
		lblBalance = new JLabel("Balance");
		GridBagConstraints gbc_lblBalance = new GridBagConstraints();
		gbc_lblBalance.insets = new Insets(0, 0, 5, 5);
		gbc_lblBalance.anchor = GridBagConstraints.EAST;
		gbc_lblBalance.gridx = 0;
		gbc_lblBalance.gridy = 0;
		statusPanel.add(lblBalance, gbc_lblBalance);
		
		tfBalance = new JTextField();
		tfBalance.setEditable(false);
		GridBagConstraints gbc_tfBalance = new GridBagConstraints();
		gbc_tfBalance.insets = new Insets(0, 0, 5, 0);
		gbc_tfBalance.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBalance.gridx = 1;
		gbc_tfBalance.gridy = 0;
		statusPanel.add(tfBalance, gbc_tfBalance);
		tfBalance.setColumns(10);
		
		lblHashrate = new JLabel("Hashrate");
		GridBagConstraints gbc_lblHashrate = new GridBagConstraints();
		gbc_lblHashrate.anchor = GridBagConstraints.EAST;
		gbc_lblHashrate.insets = new Insets(0, 0, 5, 5);
		gbc_lblHashrate.gridx = 0;
		gbc_lblHashrate.gridy = 1;
		statusPanel.add(lblHashrate, gbc_lblHashrate);
		
		tfHashrate = new JTextField();
		tfHashrate.setEditable(false);
		GridBagConstraints gbc_tfHashrate = new GridBagConstraints();
		gbc_tfHashrate.insets = new Insets(0, 0, 5, 0);
		gbc_tfHashrate.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfHashrate.gridx = 1;
		gbc_tfHashrate.gridy = 1;
		statusPanel.add(tfHashrate, gbc_tfHashrate);
		tfHashrate.setColumns(10);
		
		lblBlocksMined = new JLabel("Blocks Mined");
		GridBagConstraints gbc_lblBlocksMined = new GridBagConstraints();
		gbc_lblBlocksMined.anchor = GridBagConstraints.EAST;
		gbc_lblBlocksMined.insets = new Insets(0, 0, 0, 5);
		gbc_lblBlocksMined.gridx = 0;
		gbc_lblBlocksMined.gridy = 2;
		statusPanel.add(lblBlocksMined, gbc_lblBlocksMined);
		
		tfBlocksMined = new JTextField();
		tfBlocksMined.setEditable(false);
		GridBagConstraints gbc_tfBlocksMined = new GridBagConstraints();
		gbc_tfBlocksMined.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBlocksMined.gridx = 1;
		gbc_tfBlocksMined.gridy = 2;
		statusPanel.add(tfBlocksMined, gbc_tfBlocksMined);
		tfBlocksMined.setColumns(10);
	}

}
