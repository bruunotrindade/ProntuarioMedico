package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import view.FramePrincipal;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

public class FrameSobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param framePrincipal 
	 */
	
	public FrameSobre() {
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameSobre.class.getResource("/Imagens/sobre1.jpg")));
		panel.add(lblNewLabel);
		setBackground(new Color(238, 238, 238));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(960,570);
		setTitle("Sobre");
		setLocationRelativeTo(null);
		setVisible(true);
	}

	
}
