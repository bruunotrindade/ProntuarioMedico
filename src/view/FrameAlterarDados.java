package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import dao.FuncionarioDao;
import model.Funcionario;
import utils.Funcoes;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class FrameAlterarDados extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeCompleto;
	private JTextField tfCPF;
	private JTextField tfDtNasc;
	private JTextField tfMatricula;
	private JTextField tfFuncao;
	private JPasswordField pfSenha;
	private FramePrincipal pai;
	
	public FrameAlterarDados(FramePrincipal pai) 
	{
		this.pai = pai;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel pDadosPessoais = new JPanel();
		pDadosPessoais.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel.add(pDadosPessoais);
		pDadosPessoais.setLayout(new GridLayout(0, 1, 0, 7));
		
		JPanel panel_1 = new JPanel();
		pDadosPessoais.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {120, 432, 0};
		gbl_panel_1.rowHeights = new int[] {25, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lbNomeCompleto = new JLabel("Nome Completo *:");
		lbNomeCompleto.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbNomeCompleto = new GridBagConstraints();
		gbc_lbNomeCompleto.fill = GridBagConstraints.BOTH;
		gbc_lbNomeCompleto.insets = new Insets(0, 0, 0, 5);
		gbc_lbNomeCompleto.gridx = 0;
		gbc_lbNomeCompleto.gridy = 0;
		panel_1.add(lbNomeCompleto, gbc_lbNomeCompleto);
		
		tfNomeCompleto = new JTextField();
		GridBagConstraints gbc_tfNomeCompleto = new GridBagConstraints();
		gbc_tfNomeCompleto.fill = GridBagConstraints.BOTH;
		gbc_tfNomeCompleto.gridx = 1;
		gbc_tfNomeCompleto.gridy = 0;
		panel_1.add(tfNomeCompleto, gbc_tfNomeCompleto);
		tfNomeCompleto.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		pDadosPessoais.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {40, 220, 145, 145, 0};
		gbl_panel_2.rowHeights = new int[] {25, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lbCPF = new JLabel("CPF *:");
		lbCPF.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbCPF = new GridBagConstraints();
		gbc_lbCPF.fill = GridBagConstraints.BOTH;
		gbc_lbCPF.insets = new Insets(0, 0, 0, 5);
		gbc_lbCPF.gridx = 0;
		gbc_lbCPF.gridy = 0;
		panel_2.add(lbCPF, gbc_lbCPF);
		
		try
		{
			tfCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		}
		catch(Exception e)
		{
		}
		GridBagConstraints gbc_tfCPF = new GridBagConstraints();
		gbc_tfCPF.fill = GridBagConstraints.BOTH;
		gbc_tfCPF.insets = new Insets(0, 0, 0, 5);
		gbc_tfCPF.gridx = 1;
		gbc_tfCPF.gridy = 0;
		panel_2.add(tfCPF, gbc_tfCPF);
		tfCPF.setColumns(10);
		
		JLabel lbDtNasc = new JLabel("Data de Nascimento:");
		lbDtNasc.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbDtNasc = new GridBagConstraints();
		gbc_lbDtNasc.fill = GridBagConstraints.BOTH;
		gbc_lbDtNasc.insets = new Insets(0, 0, 0, 5);
		gbc_lbDtNasc.gridx = 2;
		gbc_lbDtNasc.gridy = 0;
		panel_2.add(lbDtNasc, gbc_lbDtNasc);
		
		try
		{
			tfDtNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		}
		catch(Exception e)
		{
		}
		tfDtNasc.setText("");
		GridBagConstraints gbc_tfDtNasc = new GridBagConstraints();
		gbc_tfDtNasc.fill = GridBagConstraints.BOTH;
		gbc_tfDtNasc.gridx = 3;
		gbc_tfDtNasc.gridy = 0;
		panel_2.add(tfDtNasc, gbc_tfDtNasc);
		tfDtNasc.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		pDadosPessoais.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] {80, 190, 65, 217, 0};
		gbl_panel_3.rowHeights = new int[] {25, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lbMatricula = new JLabel("Matrícula *:");
		lbMatricula.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbMatricula = new GridBagConstraints();
		gbc_lbMatricula.fill = GridBagConstraints.BOTH;
		gbc_lbMatricula.insets = new Insets(0, 0, 0, 5);
		gbc_lbMatricula.gridx = 0;
		gbc_lbMatricula.gridy = 0;
		panel_3.add(lbMatricula, gbc_lbMatricula);
		
		tfMatricula = new JTextField();
		GridBagConstraints gbc_tfMatricula = new GridBagConstraints();
		gbc_tfMatricula.fill = GridBagConstraints.BOTH;
		gbc_tfMatricula.insets = new Insets(0, 0, 0, 5);
		gbc_tfMatricula.gridx = 1;
		gbc_tfMatricula.gridy = 0;
		panel_3.add(tfMatricula, gbc_tfMatricula);
		tfMatricula.setColumns(10);
		
		JLabel lbFuncao = new JLabel("Função:");
		lbFuncao.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbFuncao = new GridBagConstraints();
		gbc_lbFuncao.fill = GridBagConstraints.BOTH;
		gbc_lbFuncao.insets = new Insets(0, 0, 0, 5);
		gbc_lbFuncao.gridx = 2;
		gbc_lbFuncao.gridy = 0;
		panel_3.add(lbFuncao, gbc_lbFuncao);
		
		tfFuncao = new JTextField();
		GridBagConstraints gbc_tfFuncao = new GridBagConstraints();
		gbc_tfFuncao.fill = GridBagConstraints.BOTH;
		gbc_tfFuncao.gridx = 3;
		gbc_tfFuncao.gridy = 0;
		panel_3.add(tfFuncao, gbc_tfFuncao);
		tfFuncao.setColumns(10);
		
		JPanel pSeguranca = new JPanel();
		pSeguranca.setBorder(new TitledBorder(null, "Confirma\u00E7\u00E3o de Seguran\u00E7a", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(pSeguranca);
		pSeguranca.setLayout(new GridLayout(1, 0, 0, 7));
		
		JPanel panel_4 = new JPanel();
		pSeguranca.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] {60, 496, 0};
		gbl_panel_4.rowHeights = new int[] {25, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lbSenha = new JLabel("Senha *:");
		lbSenha.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbSenha = new GridBagConstraints();
		gbc_lbSenha.fill = GridBagConstraints.BOTH;
		gbc_lbSenha.insets = new Insets(0, 0, 0, 5);
		gbc_lbSenha.gridx = 0;
		gbc_lbSenha.gridy = 0;
		panel_4.add(lbSenha, gbc_lbSenha);
		
		pfSenha = new JPasswordField();
		GridBagConstraints gbc_pfSenha = new GridBagConstraints();
		gbc_pfSenha.fill = GridBagConstraints.BOTH;
		gbc_pfSenha.gridx = 1;
		gbc_pfSenha.gridy = 0;
		panel_4.add(pfSenha, gbc_pfSenha);
		
		JPanel pBotoes = new JPanel();
		panel.add(pBotoes);
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.setIcon(new ImageIcon(FrameAlterarDados.class.getResource("/Imagens/check.png")));
		btSalvar.setBackground(Color.WHITE);
		btSalvar.setMnemonic(KeyEvent.VK_S);
		btSalvar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String nomeCompleto = tfNomeCompleto.getText(), cpf = tfCPF.getText(), dtNasc = Funcoes.converterDataEUA(tfDtNasc.getText()), matricula = tfMatricula.getText(), funcao = tfFuncao.getText(), senha = new String(pfSenha.getPassword());
			
				if(nomeCompleto.length() == 0 || cpf.contains(" ") || matricula.length() == 0 || senha.length() == 0)
					Funcoes.mostrarMensagemErro("Preencha todos os campos obrigatórios (*)!");
				else
				{
					Funcionario f;
					if((f = FuncionarioDao.getFuncionarioByLogin(cpf, senha)) == null)
						Funcoes.mostrarMensagemErro("Senha inválida!");
					else
					{
						f.setNome(nomeCompleto);
						f.setCpf(cpf);
						f.setDataNascimento(dtNasc);
						f.setMatricula(matricula);
						f.setFuncao(funcao);
						
						if(FuncionarioDao.update(f))
						{
							Funcoes.mostrarMensagemSucesso("Dados atualizados com sucesso!");
							pai.setUsuario(f);
							FrameAlterarDados.this.dispose();
						}
					}
				}
			}
		});
		pBotoes.add(btSalvar);
		
		pfSenha.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				btSalvar.getActionListeners()[0].actionPerformed(null);
			}
		});
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setIcon(new ImageIcon(FrameAlterarDados.class.getResource("/Imagens/cancel.png")));
		btCancelar.setBackground(Color.WHITE);
		btCancelar.setMnemonic(KeyEvent.VK_C);
		btCancelar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				FrameAlterarDados.this.dispose();
			}
		});
		pBotoes.add(btCancelar);
		
		Funcionario f = pai.getUsuario();
		tfNomeCompleto.setText(f.getNome());
		tfCPF.setText(f.getCpf());
		tfCPF.setEnabled(false);
		tfDtNasc.setText(Funcoes.converterDataBR(f.getDataNascimento()));
		tfMatricula.setText(f.getMatricula());
		tfMatricula.setEnabled(false);
		tfFuncao.setText(f.getFuncao());
		tfFuncao.setEnabled(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setTitle("Alteração de Dados");
		setResizable(false);
		setVisible(true);
	}
}
