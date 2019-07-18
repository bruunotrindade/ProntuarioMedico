package dao;

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

public class FrameSobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSobre frame = new FrameSobre(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param framePrincipal 
	 */
	public FrameSobre(FramePrincipal framePrincipal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {100, 200, 0};
		gbl_panel_1.rowHeights = new int[]{75, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/andrielle/Downloads/ProntuarioMedico-dev/src/Imagens/ufac.png"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UNIVERSIDADE FEDERAL DO ACRE");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(UIManager.getColor("Button.select"));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(8, 2, 0, 0));
		
		JLabel label = new JLabel("Sistema produzido para a disciplina de TESI no curso de Sistemas de Informação ");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("pela Universidade Federal do Acre.");
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Acadêmicos:");
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("André Gomes Nogueira de Oliveira");
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Andrielle de Lima Bezerra ");
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Bruno Ricardo da Silva Trindade");
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Itálo Ney Moreira de Oliveira");
		panel_2.add(label_6);
	}

	
}
