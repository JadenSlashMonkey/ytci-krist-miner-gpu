package com.ytci.kristminer.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import com.ytci.kristminer.gui.views.ConfigPanel;
import com.ytci.kristminer.gui.views.StatusPanel;

/**
 * GUI launcher for KristMiner
 * @author apemanzilla
 *
 */
@SuppressWarnings("serial")
public class KristMinerGUI extends JFrame {

	private JPanel contentPane, configPanel, statusPanel;
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
		// Format main window
		setMinimumSize(new Dimension(300, 250));
		setTitle("Krist Miner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 250);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// Add config panel
		configPanel = new ConfigPanel();
		contentPane.add(configPanel, BorderLayout.NORTH);
		
		// Add status panel
		statusPanel = new StatusPanel();
		contentPane.add(statusPanel, BorderLayout.CENTER);
	}

}
