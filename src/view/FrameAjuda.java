package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FrameAjuda extends JFrame {

	private JPanel contentPane;

	public FrameAjuda() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FrameSobre.class.getResource("/Imagens/ajuda.jpg")));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(960,570);
		setTitle("Ajuda");
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
