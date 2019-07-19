package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import model.Paciente;
import model.Pergunta;
import model.Resposta;
import tbmodel.PacienteTableModel;
import utils.Funcoes;
import dao.*;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class FramePaciente extends JFrame {

	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfDataNasc;
	private JTextField tfProfissao;
	private JTextField tfLogradouro;
	private JTextField tfBairro;
	private JTextField tfCep;
	private JTextField tfCidade;
	private JTextField tfEmail;
	private JTextField tfFone;
	private int tipo = 0;
	private FrameGerenciarPaciente pai;
	private Paciente paciente;
	private JComboBox cbEstadoCivil;
	private JComboBox cbUF;
	private JTextArea tfObs;
	private JRadioButton rbFeminino;
	private JRadioButton rbMasculino;
	private ArrayList<PerguntaGUI> perguntasAnamnese, perguntasHistorico;
	private ArrayList<Pergunta> perguntasBDA, perguntasBDH;
	
	class PerguntaGUI
	{
		JTextField tfPergunta = new JTextField();
		JRadioButton rbSim = new JRadioButton();
		JRadioButton rbNao = new JRadioButton();
		JTextField tfParentesco = new JTextField();
		Pergunta p;
	}

	public FramePaciente() 
	{
		//Aba Anamnese
	
		JPanel abaDados = new JPanel();
		abaDados.setBorder(new EmptyBorder(5, 5, 5, 5));
		abaDados.setLayout(new BorderLayout(0, 0));
		
		JPanel abaAnamnese = new JPanel();
		abaAnamnese.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel abaHistorico = new JPanel();
		abaHistorico.setBorder(new EmptyBorder(5, 5, 5, 5));
		abaHistorico.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane jtb = new JTabbedPane();
		jtb.add("Dados", abaDados);
		jtb.add("Anamnese", abaAnamnese);
		abaAnamnese.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		abaAnamnese.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		
		JPanel panel_10 = new JPanel(new BorderLayout());
		panel_7.add(panel_10);
		
		JLabel lblNewLabel_5 = new JLabel("ANAMNESE – sofreu ou sofre das doenças abaixo relacionadas? (marque Sim ou Não)");
		panel_10.add(lblNewLabel_5);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel pnSCAnam = new JPanel(), pnPerguntasAnamnese = new JPanel();
		pnSCAnam.add(pnPerguntasAnamnese);
		abaAnamnese.add(new JScrollPane(pnSCAnam, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[] {570, 50, 50, 0};
		gbl_panel_11.rowHeights = new int[] {15};
		gbl_panel_11.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_11.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnPerguntasAnamnese.setLayout(gbl_panel_11);
		
		JLabel lblNewLabel_6 = new JLabel("Doença");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 0;
		pnPerguntasAnamnese.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Sim");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 0;
		pnPerguntasAnamnese.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Não");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_8.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 0;
		pnPerguntasAnamnese.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		perguntasBDA = PerguntaDao.getBy("QUESTIONARIO", "A");
		perguntasAnamnese = new ArrayList<PerguntaGUI>();
		int index = 1;
		
		for(Pergunta p : perguntasBDA)
		{
			PerguntaGUI pg = new PerguntaGUI();
			pg.p = p;
			
			GridBagConstraints gbc_textField_4 = new GridBagConstraints();
			gbc_textField_4.insets = new Insets(0, 0, 5, 5);
			gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_4.gridx = 0;
			gbc_textField_4.gridy = index;
			pnPerguntasAnamnese.add(pg.tfPergunta, gbc_textField_4);
			pg.tfPergunta.setColumns(10);
			pg.tfPergunta.setText(p.getDesc());
			pg.tfPergunta.setEditable(false);
			pg.tfPergunta.setFocusable(false);
			
			GridBagConstraints gbc_radioButton_1 = new GridBagConstraints();
			gbc_radioButton_1.insets = new Insets(0, 0, 5, 5);
			gbc_radioButton_1.gridx = 1;
			gbc_radioButton_1.gridy = index;
			pnPerguntasAnamnese.add(pg.rbSim, gbc_radioButton_1);
			
			GridBagConstraints gbc_radioButton_2 = new GridBagConstraints();
			gbc_radioButton_2.insets = new Insets(0, 0, 5, 0);
			gbc_radioButton_2.gridx = 2;
			gbc_radioButton_2.gridy = index;
			pnPerguntasAnamnese.add(pg.rbNao, gbc_radioButton_2);
			
			ButtonGroup bg = new ButtonGroup();
			bg.add(pg.rbNao);
			bg.add(pg.rbSim);
			
			index += 1;
			perguntasAnamnese.add(pg);
		}
		
		jtb.add("Histórico Familiar", abaHistorico);
		
		JPanel panel = new JPanel();
		abaHistorico.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//Aba Histórico
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JLabel lblNewLabel = new JLabel("ANTECEDENTES FAMILIARES - Seus familiares diretos (pai, mãe, irmãos e avós),");
		panel_5.add(lblNewLabel);
		
		JPanel pnSCHist = new JPanel(), pnPerguntasHistorico = new JPanel();
		pnSCHist.add(pnPerguntasHistorico);
		abaHistorico.add(new JScrollPane(pnSCHist, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
		
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[] {350, 50, 50, 220, 0};
		gbl_panel_6.rowHeights = new int[] {15};
		gbl_panel_6.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnPerguntasHistorico.setLayout(gbl_panel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Doença");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		pnPerguntasHistorico.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sim");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		pnPerguntasHistorico.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Não");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 0;
		pnPerguntasHistorico.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Parentesco");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 0;
		pnPerguntasHistorico.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		
		perguntasBDH = PerguntaDao.getBy("QUESTIONARIO", "H");
		perguntasHistorico = new ArrayList<PerguntaGUI>();
		index = 1;
		
		for(Pergunta p : perguntasBDH)
		{
			PerguntaGUI pg = new PerguntaGUI();
			pg.p = p;
			
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 0;
			gbc_textField.gridy = index;
			pnPerguntasHistorico.add(pg.tfPergunta, gbc_textField);
			pg.tfPergunta.setColumns(10);
			pg.tfPergunta.setText(p.getDesc());
			pg.tfPergunta.setEditable(false);
			pg.tfPergunta.setFocusable(false);
			
			GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
			gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnNewRadioButton.gridx = 1;
			gbc_rdbtnNewRadioButton.gridy = index;
			pnPerguntasHistorico.add(pg.rbSim, gbc_rdbtnNewRadioButton);
			
			GridBagConstraints gbc_radioButton = new GridBagConstraints();
			gbc_radioButton.insets = new Insets(0, 0, 5, 5);
			gbc_radioButton.gridx = 2;
			gbc_radioButton.gridy = index;
			pnPerguntasHistorico.add(pg.rbNao, gbc_radioButton);
			
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 3;
			gbc_textField_1.gridy = index;
			pnPerguntasHistorico.add(pg.tfParentesco, gbc_textField_1);
			pg.tfParentesco.setColumns(10);
			
			ButtonGroup bg = new ButtonGroup();
			bg.add(pg.rbNao);
			bg.add(pg.rbSim);
			
			pg.rbNao.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					pg.tfParentesco.setEditable(false);
				}
			});
			
			pg.rbSim.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					pg.tfParentesco.setEditable(true);
				}
			});

			index += 1;
			perguntasHistorico.add(pg);
		}
		
		getContentPane().add(jtb);

		//Aba Dados
		JPanel panel_Geral = new JPanel();
		abaDados.add(panel_Geral, BorderLayout.NORTH);
		panel_Geral.setLayout(new BoxLayout(panel_Geral, BoxLayout.Y_AXIS));
		
		JPanel panel_DadosPessoais = new JPanel();
		panel_Geral.add(panel_DadosPessoais);
		panel_DadosPessoais.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_DadosPessoais.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panel_1 = new JPanel();
		panel_DadosPessoais.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {40, 480, 0};
		gbl_panel_1.rowHeights = new int[] {24};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNome = new JLabel("Nome*:");
		lblNome.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.fill = GridBagConstraints.VERTICAL;
		gbc_lblNome.insets = new Insets(0, 0, 0, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		panel_1.add(lblNome, gbc_lblNome);
		
		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.fill = GridBagConstraints.BOTH;
		gbc_tfNome.gridx = 1;
		gbc_tfNome.gridy = 0;
		panel_1.add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_DadosPessoais.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {40, 60, 100, 50, 50, 30, 90, 0};
		gbl_panel_2.rowHeights = new int[] {24, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
	
		JLabel lblCPF = new JLabel("CPF*:");
		lblCPF.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCPF = new GridBagConstraints();
		gbc_lblCPF.fill = GridBagConstraints.BOTH;
		gbc_lblCPF.insets = new Insets(0, 0, 0, 5);
		gbc_lblCPF.gridx = 0;
		gbc_lblCPF.gridy = 0;
		panel_2.add(lblCPF, gbc_lblCPF);
		try {
			tfCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GridBagConstraints gbc_tfCPF = new GridBagConstraints();
		gbc_tfCPF.fill = GridBagConstraints.BOTH;
		gbc_tfCPF.insets = new Insets(0, 0, 0, 5);
		gbc_tfCPF.gridx = 1;
		gbc_tfCPF.gridy = 0;
		panel_2.add(tfCPF, gbc_tfCPF);
		tfCPF.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento*:");
		lblDataNascimento.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDataNascimento = new GridBagConstraints();
		gbc_lblDataNascimento.fill = GridBagConstraints.BOTH;
		gbc_lblDataNascimento.insets = new Insets(0, 0, 0, 5);
		gbc_lblDataNascimento.gridx = 2;
		gbc_lblDataNascimento.gridy = 0;
		panel_2.add(lblDataNascimento, gbc_lblDataNascimento);
		try {
			tfDataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tfDataNasc.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_tfDataNasc = new GridBagConstraints();
		gbc_tfDataNasc.fill = GridBagConstraints.BOTH;
		gbc_tfDataNasc.insets = new Insets(0, 0, 0, 5);
		gbc_tfDataNasc.gridx = 3;
		gbc_tfDataNasc.gridy = 0;
		panel_2.add(tfDataNasc, gbc_tfDataNasc);
		tfDataNasc.setColumns(10);
		
		JLabel lbSexo = new JLabel("Sexo*:");
		GridBagConstraints gbc_lbSexo = new GridBagConstraints();
		gbc_lbSexo.fill = GridBagConstraints.BOTH;
		gbc_lbSexo.insets = new Insets(0, 0, 0, 5);
		gbc_lbSexo.gridx = 4;
		gbc_lbSexo.gridy = 0;
		panel_2.add(lbSexo, gbc_lbSexo);
		lbSexo.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		rbFeminino = new JRadioButton("Feminino");
		GridBagConstraints gbc_rbFeminino = new GridBagConstraints();
		gbc_rbFeminino.fill = GridBagConstraints.BOTH;
		gbc_rbFeminino.insets = new Insets(0, 0, 0, 5);
		gbc_rbFeminino.gridx = 5;
		gbc_rbFeminino.gridy = 0;
		panel_2.add(rbFeminino, gbc_rbFeminino);
		rbFeminino.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		rbMasculino = new JRadioButton("Masculino");
		GridBagConstraints gbc_rbMasculino = new GridBagConstraints();
		gbc_rbMasculino.fill = GridBagConstraints.BOTH;
		gbc_rbMasculino.gridx = 6;
		gbc_rbMasculino.gridy = 0;
		panel_2.add(rbMasculino, gbc_rbMasculino);
		rbMasculino.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbMasculino);
		bg.add(rbFeminino);
		
		JPanel panel_3 = new JPanel();
		panel_DadosPessoais.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] {70, 350, 80, 165, 0};
		gbl_panel_3.rowHeights = new int[] {24, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lbProfissao = new JLabel("Profissão:");
		lbProfissao.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbProfissao = new GridBagConstraints();
		gbc_lbProfissao.fill = GridBagConstraints.BOTH;
		gbc_lbProfissao.insets = new Insets(0, 0, 0, 5);
		gbc_lbProfissao.gridx = 0;
		gbc_lbProfissao.gridy = 0;
		panel_3.add(lbProfissao, gbc_lbProfissao);
		
		tfProfissao = new JTextField();
		GridBagConstraints gbc_tfProfissao = new GridBagConstraints();
		gbc_tfProfissao.fill = GridBagConstraints.BOTH;
		gbc_tfProfissao.insets = new Insets(0, 0, 0, 5);
		gbc_tfProfissao.gridx = 1;
		gbc_tfProfissao.gridy = 0;
		panel_3.add(tfProfissao, gbc_tfProfissao);
		tfProfissao.setColumns(10);
		
		JLabel lbEstadoCivil = new JLabel("Estado Civil:");
		GridBagConstraints gbc_lbEstadoCivil = new GridBagConstraints();
		gbc_lbEstadoCivil.fill = GridBagConstraints.BOTH;
		gbc_lbEstadoCivil.insets = new Insets(0, 0, 0, 5);
		gbc_lbEstadoCivil.gridx = 2;
		gbc_lbEstadoCivil.gridy = 0;
		panel_3.add(lbEstadoCivil, gbc_lbEstadoCivil);
		lbEstadoCivil.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		cbEstadoCivil = new JComboBox();
		GridBagConstraints gbc_cbEstadoCivil = new GridBagConstraints();
		gbc_cbEstadoCivil.fill = GridBagConstraints.BOTH;
		gbc_cbEstadoCivil.gridx = 3;
		gbc_cbEstadoCivil.gridy = 0;
		panel_3.add(cbEstadoCivil, gbc_cbEstadoCivil);
		cbEstadoCivil.setFont(new Font("Dialog", Font.PLAIN, 12));
		cbEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"Solteiro", "Casado", "Separado", "Divorciado", "Viúvo"}));
		
		JPanel panel_4 = new JPanel();
		panel_DadosPessoais.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] {70, 350, 60, 185, 0};
		gbl_panel_4.rowHeights = new int[] {24, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbEmail = new GridBagConstraints();
		gbc_lbEmail.fill = GridBagConstraints.BOTH;
		gbc_lbEmail.insets = new Insets(0, 0, 0, 5);
		gbc_lbEmail.gridx = 0;
		gbc_lbEmail.gridy = 0;
		panel_4.add(lbEmail, gbc_lbEmail);
		
		tfEmail = new JTextField();
		GridBagConstraints gbc_tfEmail = new GridBagConstraints();
		gbc_tfEmail.fill = GridBagConstraints.BOTH;
		gbc_tfEmail.insets = new Insets(0, 0, 0, 5);
		gbc_tfEmail.gridx = 1;
		gbc_tfEmail.gridy = 0;
		panel_4.add(tfEmail, gbc_tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lbFone = new JLabel("Fone:");
		lbFone.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbFone = new GridBagConstraints();
		gbc_lbFone.fill = GridBagConstraints.BOTH;
		gbc_lbFone.insets = new Insets(0, 0, 0, 5);
		gbc_lbFone.gridx = 2;
		gbc_lbFone.gridy = 0;
		panel_4.add(lbFone, gbc_lbFone);
		
		
		
		try {
			tfFone = new JFormattedTextField(new MaskFormatter("#####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagConstraints gbc_tfFone = new GridBagConstraints();
		gbc_tfFone.fill = GridBagConstraints.BOTH;
		gbc_tfFone.gridx = 3;
		gbc_tfFone.gridy = 0;
		panel_4.add(tfFone, gbc_tfFone);
		tfFone.setColumns(10);
		
		JPanel panel_Endereco = new JPanel();
		panel_Geral.add(panel_Endereco);
		panel_Endereco.setBorder(new TitledBorder(null, "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Endereco.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_9.setToolTipText("");
		panel_Endereco.add(panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{100, 170, 30, 100, 40, 70, 0};
		gbl_panel_9.rowHeights = new int[] {24, 0};
		gbl_panel_9.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		JLabel lbLogradouro = new JLabel("Logradouro:");
		lbLogradouro.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbLogradouro = new GridBagConstraints();
		gbc_lbLogradouro.fill = GridBagConstraints.BOTH;
		gbc_lbLogradouro.insets = new Insets(0, 0, 0, 5);
		gbc_lbLogradouro.gridx = 0;
		gbc_lbLogradouro.gridy = 0;
		panel_9.add(lbLogradouro, gbc_lbLogradouro);
		
		tfLogradouro = new JTextField();
		tfLogradouro.setColumns(10);
		GridBagConstraints gbc_tfLogradouro = new GridBagConstraints();
		gbc_tfLogradouro.fill = GridBagConstraints.BOTH;
		gbc_tfLogradouro.insets = new Insets(0, 0, 0, 5);
		gbc_tfLogradouro.gridx = 1;
		gbc_tfLogradouro.gridy = 0;
		panel_9.add(tfLogradouro, gbc_tfLogradouro);
		
		JLabel lbBairro = new JLabel("Bairro:");
		lbBairro.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbBairro = new GridBagConstraints();
		gbc_lbBairro.fill = GridBagConstraints.BOTH;
		gbc_lbBairro.insets = new Insets(0, 0, 0, 5);
		gbc_lbBairro.gridx = 2;
		gbc_lbBairro.gridy = 0;
		panel_9.add(lbBairro, gbc_lbBairro);
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		GridBagConstraints gbc_tfBairro = new GridBagConstraints();
		gbc_tfBairro.fill = GridBagConstraints.BOTH;
		gbc_tfBairro.insets = new Insets(0, 0, 0, 5);
		gbc_tfBairro.gridx = 3;
		gbc_tfBairro.gridy = 0;
		panel_9.add(tfBairro, gbc_tfBairro);
		
		JLabel lbCEP = new JLabel("CEP:");
		lbCEP.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbCEP = new GridBagConstraints();
		gbc_lbCEP.fill = GridBagConstraints.BOTH;
		gbc_lbCEP.insets = new Insets(0, 0, 0, 5);
		gbc_lbCEP.gridx = 4;
		gbc_lbCEP.gridy = 0;
		panel_9.add(lbCEP, gbc_lbCEP);
		
		try {
			tfCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tfCep.setColumns(10);
		GridBagConstraints gbc_tfCep = new GridBagConstraints();
		gbc_tfCep.fill = GridBagConstraints.BOTH;
		gbc_tfCep.gridx = 5;
		gbc_tfCep.gridy = 0;
		panel_9.add(tfCep, gbc_tfCep);
		
		JPanel panel_8 = new JPanel();
		panel_Endereco.add(panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{60, 135, 30, 50, 0};
		gbl_panel_8.rowHeights = new int[] {24};
		gbl_panel_8.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{0.0};
		panel_8.setLayout(gbl_panel_8);
		
		JLabel lbCidade = new JLabel("Cidade:");
		lbCidade.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbCidade = new GridBagConstraints();
		gbc_lbCidade.fill = GridBagConstraints.BOTH;
		gbc_lbCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lbCidade.gridx = 0;
		gbc_lbCidade.gridy = 0;
		panel_8.add(lbCidade, gbc_lbCidade);
		
		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		GridBagConstraints gbc_tfCidade = new GridBagConstraints();
		gbc_tfCidade.fill = GridBagConstraints.BOTH;
		gbc_tfCidade.insets = new Insets(0, 0, 5, 5);
		gbc_tfCidade.gridx = 1;
		gbc_tfCidade.gridy = 0;
		panel_8.add(tfCidade, gbc_tfCidade);
		
		JLabel lbUF = new JLabel("UF:");
		lbUF.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbUF = new GridBagConstraints();
		gbc_lbUF.fill = GridBagConstraints.BOTH;
		gbc_lbUF.insets = new Insets(0, 0, 5, 5);
		gbc_lbUF.gridx = 2;
		gbc_lbUF.gridy = 0;
		panel_8.add(lbUF, gbc_lbUF);
		
		cbUF = new JComboBox();
		cbUF.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
		cbUF.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_cbUF = new GridBagConstraints();
		gbc_cbUF.fill = GridBagConstraints.BOTH;
		gbc_cbUF.insets = new Insets(0, 0, 5, 0);
		gbc_cbUF.gridx = 3;
		gbc_cbUF.gridy = 0;
		panel_8.add(cbUF, gbc_cbUF);
		
		JPanel panel_Obs = new JPanel();
		panel_Geral.add(panel_Obs);
		panel_Obs.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Observa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Obs.setLayout(new BorderLayout(0, 0));
		
		tfObs = new JTextArea();
		tfObs.setRows(5);
		panel_Obs.add(new JScrollPane(tfObs), BorderLayout.NORTH);
		
		JPanel panel_Botoes = new JPanel();
		abaDados.add(panel_Botoes, BorderLayout.SOUTH);
		panel_Botoes.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(255, 255, 255));
		btnSalvar.setBackground(new Color(60, 179, 113));
		btnSalvar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/check.png")));
		btnSalvar.setFocusPainted(false);
		btnSalvar.setMnemonic(KeyEvent.VK_S);
		panel_Botoes.add(btnSalvar);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Paciente p = paciente;
				String nomeCompleto = tfNome.getText(), cpf = tfCPF.getText(), dtNasc = Funcoes.converterDataEUA(tfDataNasc.getText()),
						profissao=tfProfissao.getText();
				char sexo=' ';
				if(rbFeminino.isSelected())
				{
					sexo='F';
				}
				else
					sexo='M';
				
				String uf =(String) cbUF.getSelectedItem(), estadoCivil = (String) cbEstadoCivil.getSelectedItem();
				String logradouro = tfLogradouro.getText(), bairro = tfBairro.getText(), cep = tfCep.getText(),cidade=tfCidade.getText(),observacoes = tfObs.getText(),email=tfEmail.getText(),fone=tfFone.getText();
				p = new Paciente(nomeCompleto, cpf,sexo, dtNasc, estadoCivil,logradouro, bairro, cidade, cep, uf, fone, email, profissao, observacoes,false);
				
				if(paciente != null)
					p.setId(paciente.getId());
				
				if(nomeCompleto.length() == 0 || cpf.contains(" ") || dtNasc.length() == 0 || sexo == ' ')
					Funcoes.mostrarMensagemErro("Preencha todos os campos obrigatórios (*)!");
				else if(tipo == 0)
				{
					if(PacienteDao.insert(p))
					{
						paciente = PacienteDao.getBy("CPF", p.getCpf()).get(0);
						for(PerguntaGUI pg : perguntasAnamnese)
						{
							String conteudo = "Sim";
							if(pg.rbNao.isSelected())
								conteudo = "Não";
							
							Resposta r = new Resposta(conteudo, pg.p, paciente);
							RespostaDao.insert(r);
						}
						
						for(PerguntaGUI pg : perguntasHistorico)
						{
							String conteudo = pg.tfParentesco.getText();
							if(pg.rbNao.isSelected())
								conteudo = "Não";
							
							Resposta r = new Resposta(conteudo, pg.p, paciente);
							RespostaDao.insert(r);
						}
						
						Funcoes.mostrarMensagemSucesso("Paciente cadastrado com sucesso!");
						FramePaciente.this.dispose();
					}
				}
				else if(tipo == 1)//Edição
				{
					//Não editavel
					tfCPF.setEnabled(false);
					tfDataNasc.setEnabled(false);
					
					if(PacienteDao.update(p))
					{
						RespostaDao.delete(paciente.getId());
						for(PerguntaGUI pg : perguntasAnamnese)
						{
							String conteudo = "Sim";
							if(pg.rbNao.isSelected())
								conteudo = "Não";
							
							Resposta r = new Resposta(conteudo, pg.p, paciente);
							RespostaDao.insert(r);
						}
						
						for(PerguntaGUI pg : perguntasHistorico)
						{
							String conteudo = pg.tfParentesco.getText();
							if(pg.rbNao.isSelected())
								conteudo = "Não";
							
							Resposta r = new Resposta(conteudo, pg.p, paciente);
							RespostaDao.insert(r);
						}
						
						Funcoes.mostrarMensagemSucesso("Paciente atualizado com sucesso!");
						FramePaciente.this.dispose();
						pai.table.setModel(new PacienteTableModel(PacienteDao.getAll()));
					}
				}
				else if(tipo == 2)//Exclusão
				{
					if(RespostaDao.delete(paciente.getId()) && PacienteDao.delete(p))
					{
						Funcoes.mostrarMensagemSucesso("Paciente excluido com sucesso!");
						FramePaciente.this.dispose();
						pai.table.setModel(new PacienteTableModel(PacienteDao.getAll()));
					}
				}
				else if(tipo ==3) {
					if(PacienteDao.getPaciente(p.getId()) != null) {
						FramePaciente.this.dispose();
					}
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(232, 91, 84));
		btnCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/cancel.png")));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setMnemonic(KeyEvent.VK_C);
		btnCancelar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				FramePaciente.this.dispose();
			}
		});
		panel_Botoes.add(btnCancelar);
		
		setTitle("Cadastro de Paciente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(700, 450);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);	
	}
	
	public FramePaciente(FrameGerenciarPaciente pai, Paciente p, int tipo)
	{
		this();
		this.pai = pai;
		this.paciente = p;
		this.tipo = tipo;
		
		tfNome.setText(p.getNome());
		tfCPF.setText(p.getCpf());
		tfCPF.setEditable(false);
		tfDataNasc.setText(Funcoes.converterDataBR(p.getDataNascimento()));
		tfDataNasc.setEditable(false);
		//sexo
		if(paciente.getSexo() == 'M')
			rbMasculino.setSelected(true);
		else
			rbFeminino.setSelected(true);
		tfProfissao.setText(p.getProfissao());
		cbEstadoCivil.getModel().setSelectedItem(p.getEstadoCivil());
		tfEmail.setText(p.getEmail());
		tfFone.setText(p.getFone());
		tfLogradouro.setText(p.getEndereco());
		tfBairro.setText(p.getBairro());
		tfCidade.setText(p.getCidade());
		tfCep.setText(p.getCep());
		tfObs.setText(p.getObs());
		
		ArrayList<Resposta> respostasA = RespostaDao.getByPaciente(paciente, "A");
		int ind = 0;
		for(Resposta r : respostasA)
		{
			PerguntaGUI pg = perguntasAnamnese.get(ind);
			if(r.getConteudo().equals("Sim"))
				pg.rbSim.setSelected(true);
			else
				pg.rbNao.setSelected(true);
			
			ind++;
		}
		
		ArrayList<Resposta> respostasH = RespostaDao.getByPaciente(paciente, "H");
		ind = 0;
		for(Resposta r : respostasH)
		{
			PerguntaGUI pg = perguntasHistorico.get(ind);
			if(r.getConteudo().equals("Não"))
			{
				pg.rbNao.setSelected(true);
				pg.tfParentesco.setEditable(false);
			}
			else 
			{
				pg.rbSim.setSelected(true);
				pg.tfParentesco.setText(r.getConteudo());
			}
			
			ind++;
		}
		
		if(tipo == 1)
			setTitle("Edição de Paciente");
		else if(tipo == 2)
			setTitle("Exclusão de Paciente");
		else if(tipo == 3)
			setTitle("Visualização de Paciente");
			
		
		if(tipo >= 2)//Deletar
		{
			tfNome.setEditable(false);
			tfProfissao.setEditable(false);
			cbEstadoCivil.setEnabled(false);
			cbUF.setEnabled(false);
			tfBairro.setEditable(false);
			tfLogradouro.setEditable(false);
			tfCep.setEditable(false);
			tfCidade.setEditable(false);
			tfEmail.setEditable(false);
			tfFone.setEditable(false);
			tfObs.setEditable(false);
			tfObs.setEnabled(false);
			rbFeminino.setEnabled(false);
			rbMasculino.setEnabled(false);
			
			for(PerguntaGUI pg : perguntasAnamnese)
			{
				pg.tfPergunta.setEditable(false);
				pg.rbNao.setEnabled(false);
				pg.rbSim.setEnabled(false);
			}
			
			for(PerguntaGUI pg : perguntasHistorico)
			{
				pg.tfPergunta.setEditable(false);
				pg.tfParentesco.setEditable(false);
				pg.rbNao.setEnabled(false);
				pg.rbSim.setEnabled(false);
			}
		}
	}
}
