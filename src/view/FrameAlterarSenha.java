package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.DateFormatter;
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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;

public class FrameAlterarSenha extends JFrame 
{
	private JPanel contentPane;
	private JTextField tfNomeCompleto;
	private JTextField tfCPF;
	private JTextField tfDtNasc;
	private JTextField tfMatricula;
	private JTextField tfFuncao;
	private JPasswordField pfSenha, pfNovaSenha, pfConfirmarSenha;
	private FramePrincipal pai;
	
	public FrameAlterarSenha(FramePrincipal pai) 
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
		gbl_panel_1.columnWidths = new int[] {60, 383, 0};
		gbl_panel_1.rowHeights = new int[] {25, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lbNovaSenha = new JLabel("Nova senha *:");
		lbNovaSenha.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbNovaSenha = new GridBagConstraints();
		gbc_lbNovaSenha.fill = GridBagConstraints.BOTH;
		gbc_lbNovaSenha.insets = new Insets(0, 0, 0, 5);
		gbc_lbNovaSenha.gridx = 0;
		gbc_lbNovaSenha.gridy = 0;
		panel_1.add(lbNovaSenha, gbc_lbNovaSenha);
		
		pfNovaSenha = new JPasswordField();
		GridBagConstraints gbc_pfNovaSenha = new GridBagConstraints();
		gbc_pfNovaSenha.fill = GridBagConstraints.BOTH;
		gbc_pfNovaSenha.gridx = 1;
		gbc_pfNovaSenha.gridy = 0;
		panel_1.add(pfNovaSenha, gbc_pfNovaSenha);
		
		JPanel panel_2 = new JPanel();
		pDadosPessoais.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {60, 378, 0};
		gbl_panel_2.rowHeights = new int[] {25, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lbConfirmarSenha = new JLabel("Confirmação *:");
		lbConfirmarSenha.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lbConfirmarSenha = new GridBagConstraints();
		gbc_lbConfirmarSenha.fill = GridBagConstraints.BOTH;
		gbc_lbConfirmarSenha.insets = new Insets(0, 0, 0, 5);
		gbc_lbConfirmarSenha.gridx = 0;
		gbc_lbConfirmarSenha.gridy = 0;
		panel_2.add(lbConfirmarSenha, gbc_lbConfirmarSenha);
		
		pfConfirmarSenha = new JPasswordField();
		GridBagConstraints gbc_pfConfirmarSenha = new GridBagConstraints();
		gbc_pfConfirmarSenha.fill = GridBagConstraints.BOTH;
		gbc_pfConfirmarSenha.gridx = 1;
		gbc_pfConfirmarSenha.gridy = 0;
		panel_2.add(pfConfirmarSenha, gbc_pfConfirmarSenha);
		
		JPanel pSeguranca = new JPanel();
		pSeguranca.setBorder(new TitledBorder(null, "Confirma\u00E7\u00E3o de Seguran\u00E7a", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(pSeguranca);
		pSeguranca.setLayout(new GridLayout(1, 0, 0, 7));
		
		JPanel panel_4 = new JPanel();
		pSeguranca.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] {60, 380, 0};
		gbl_panel_4.rowHeights = new int[] {25, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lbSenha = new JLabel("Senha atual *:");
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
		btSalvar.setIcon(new ImageIcon(FrameAlterarSenha.class.getResource("/Imagens/check.png")));
		btSalvar.setBackground(Color.WHITE);
		btSalvar.setMnemonic(KeyEvent.VK_S);
		btSalvar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String novaSenha = new String(pfNovaSenha.getPassword()), confirmarSenha = new String(pfConfirmarSenha.getPassword()), senha = new String(pfSenha.getPassword());
			
				if(novaSenha.length() == 0 || confirmarSenha.length() == 0 || senha.length() == 0)
					Funcoes.mostrarMensagemErro("Preencha todos os campos obrigatórios (*)!");
				else if(novaSenha.equals(confirmarSenha) == false)
					Funcoes.mostrarMensagemErro("As senhas digitas não coincidem. Verifique-as!");
				else if(novaSenha.equals(confirmarSenha) == false)
					Funcoes.mostrarMensagemErro("A nova senha não pode ser igual à atual!");
				else
				{
					Funcionario f;
					if((f = FuncionarioDao.getFuncionarioByLogin(pai.getUsuario().getCpf(), senha)) == null)
					{
						JOptionPane.showMessageDialog(null, "Senha inválida!", "Falha", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					f.setSenha(Funcoes.md5(novaSenha));
					
					if(FuncionarioDao.update(f))
					{
						Funcoes.mostrarMensagemSucesso("Senha atualizada com sucesso!");
						pai.setUsuario(f);
						FrameAlterarSenha.this.dispose();
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
		btCancelar.setIcon(new ImageIcon(FrameAlterarSenha.class.getResource("/Imagens/cancel.png")));
		btCancelar.setBackground(Color.WHITE);
		btCancelar.setMnemonic(KeyEvent.VK_C);
		btCancelar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				FrameAlterarSenha.this.dispose();
			}
		});
		pBotoes.add(btCancelar);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setTitle("Alteração de Dados");
		setResizable(false);
		setVisible(true);
	}
}
