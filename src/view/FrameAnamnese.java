package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;

public class FrameAnamnese extends JFrame {

	private JPanel ContentPane;
	private JTextField textField;
	private JTextField tfOutros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAnamnese frame = new FrameAnamnese();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameAnamnese() {
		setTitle("Anamnese");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		ContentPane = new JPanel();
		ContentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(ContentPane);
		ContentPane.setLayout(new BoxLayout(ContentPane, BoxLayout.PAGE_AXIS));
		
		JPanel pnDoencas = new JPanel();
		pnDoencas.setBorder(new EmptyBorder(0, 0, 0, 0));
		ContentPane.add(pnDoencas);
		pnDoencas.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel pnLbs = new JPanel();
		pnLbs.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnDoencas.add(pnLbs);
		pnLbs.setLayout(new GridLayout(4, 0, 0, 0));
		
		JLabel lbDoenca = new JLabel("DOENÇA");
		pnLbs.add(lbDoenca);
		
		JLabel lbAsma = new JLabel("ASMA");
		pnLbs.add(lbAsma);
		
		JLabel lbInfarto = new JLabel("INFARTO");
		pnLbs.add(lbInfarto);
		
		JLabel lbAlergia = new JLabel("ALERGIA");
		pnLbs.add(lbAlergia);
		
		JPanel pnSim = new JPanel();
		pnSim.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnDoencas.add(pnSim);
		pnSim.setLayout(new GridLayout(4, 0, 0, 0));
		
		JLabel lbSIM = new JLabel("SIM");
		pnSim.add(lbSIM);
		
		JRadioButton rbtnS1 = new JRadioButton("");
		pnSim.add(rbtnS1);
		
		JRadioButton rbtS2 = new JRadioButton("");
		pnSim.add(rbtS2);
		
		JRadioButton rbtS3 = new JRadioButton("");
		pnSim.add(rbtS3);
		
		JPanel pnNao = new JPanel();
		pnNao.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnDoencas.add(pnNao);
		pnNao.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lbNao = new JLabel("NÃO");
		pnNao.add(lbNao);
		
		JRadioButton rbtN1 = new JRadioButton("");
		pnNao.add(rbtN1);
		
		JRadioButton rbtN2 = new JRadioButton("");
		pnNao.add(rbtN2);
		
		JRadioButton rbtN3 = new JRadioButton("");
		pnNao.add(rbtN3);
		
		JPanel pnObs = new JPanel();
		pnObs.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Extras", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		ContentPane.add(pnObs);
		pnObs.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pnAux1 = new JPanel();
		pnAux1.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnObs.add(pnAux1);
		pnAux1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pnAlergias = new JPanel();
		pnAux1.add(pnAlergias);
		pnAlergias.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnAlergias.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbQuais = new JLabel("QUAL ALERGIA?");
		pnAlergias.add(lbQuais);
		
		textField = new JTextField();
		pnAlergias.add(textField);
		textField.setColumns(26);
		
		JPanel pnOutros = new JPanel();
		pnAux1.add(pnOutros);
		pnOutros.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnOutros.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbOutros = new JLabel("OUTRA DOENÇA?");
		pnOutros.add(lbOutros);
		
		tfOutros = new JTextField();
		pnOutros.add(tfOutros);
		tfOutros.setColumns(25);
		
		JPanel pnAux2 = new JPanel();
		ContentPane.add(pnAux2);
		pnAux2.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JButton btnCancelar = new JButton("Cancelar");
		pnAux2.add(btnCancelar);
	}

}
