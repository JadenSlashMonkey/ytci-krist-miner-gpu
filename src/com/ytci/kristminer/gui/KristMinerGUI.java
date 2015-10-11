package com.ytci.kristminer.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ytci.kristminer.KristConfig;
import com.ytci.kristminer.KristMiner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Random;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class KristMinerGUI extends JFrame {

	private KristMiner miner;
	
	private JPanel contentPane;
	private JTextField tfAddress;
	private JTextField tfPrefix;
	private JButton btnStart;

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
		setMinimumSize(new Dimension(300, 200));
		setTitle("Krist Miner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel configPanel = new JPanel();
		contentPane.add(configPanel, BorderLayout.NORTH);
		GridBagLayout gbl_configPanel = new GridBagLayout();
		gbl_configPanel.columnWidths = new int[]{50, 212, 0};
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
		
		btnStart = new JButton("Start mining");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validateSettings()) {
					miner = new KristMiner(new KristConfig(tfAddress.getText(), tfPrefix.getText()));
				} else {
					
				}
			}
		});
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.gridwidth = 2;
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 2;
		configPanel.add(btnStart, gbc_btnStart);
	}
	
	private boolean validateSettings() {
		if (!(tfAddress.getText().length() == 10 && tfAddress.getText().charAt(0) == 'k')) {
			JOptionPane.showMessageDialog(null,"Address should be 10 characters long and start with 'k'.\nv1 addresses are insecure and not supported.","Invalid Address!",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

}
