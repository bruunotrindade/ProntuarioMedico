package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import dao.FuncionarioDao;
import dao.MedicoDao;
import model.Funcionario;
import model.Medico;
import utils.Funcoes;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.Format;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class FrameMedico extends JFrame 
{
	private JPanel contentPane;
	private FrameGerenciarMedico pai;
	private JTextField tfMatricula;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfDataNasc;
	private JTextField tfEspecialidade;
	private JTextField tfCrm;
	private JPasswordField tfSenha;
	private JButton btnSalvar;
	private JLabel lblSenha;
	private JCheckBox cbAtivo;
	private Medico f = null;
	private int tipo = 0;
	
	public FrameMedico(FrameGerenciarMedico pai, Medico f, int tipo)
	{
		this(pai);
		this.tipo = tipo;
		this.f = f;
		if(tipo == 1)
			setTitle("Edição de Médico");
		else
		{
			setTitle("Exclusão de Médico");
			tfCpf.setEditable(false);
			tfMatricula.setEditable(false);
			tfNome.setEditable(false);
			tfDataNasc.setEditable(false);
			tfEspecialidade.setEditable(false);
			tfSenha.setEditable(false);
			tfSenha.setText("***********");
			cbAtivo.setEnabled(false);
			tfCrm.setEditable(false);
		}
		
		preencherCampos(f);
	}
	
	public FrameMedico(FrameGerenciarMedico pai) 
	{
		this.pai = pai;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel pnPrincipal = new JPanel(new BorderLayout());
		contentPane.add(pnPrincipal, BorderLayout.CENTER);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 180, 234, 0};
		gbl_contentPane.rowHeights = new int[]{29, 29, 29, 29, 29, 29, 29, 29};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnPrincipal.setLayout(gbl_contentPane);
		
		JLabel lblCrm = new JLabel("CRM*:");
		lblCrm.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCrm = new GridBagConstraints();
		gbc_lblCrm.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrm.gridx = 0;
		gbc_lblCrm.gridy = 0;
		pnPrincipal.add(lblCrm, gbc_lblCrm);
		
		tfCrm = new JTextField();
		GridBagConstraints gbc_tfCrm = new GridBagConstraints();
		gbc_tfCrm.fill = GridBagConstraints.BOTH;
		gbc_tfCrm.gridwidth = 3;
		gbc_tfCrm.insets = new Insets(0, 0, 5, 0);
		gbc_tfCrm.gridx = 1;
		gbc_tfCrm.gridy = 0;
		pnPrincipal.add(tfCrm, gbc_tfCrm);
		tfCrm.setColumns(10);
		
		JLabel lblMat = new JLabel("Matrícula*:");
		lblMat.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMat = new GridBagConstraints();
		gbc_lblMat.insets = new Insets(0, 0, 5, 5);
		gbc_lblMat.gridx = 0;
		gbc_lblMat.gridy = 1;
		pnPrincipal.add(lblMat, gbc_lblMat);
		
		tfMatricula = new JTextField();
		GridBagConstraints gbc_tfMatricula = new GridBagConstraints();
		gbc_tfMatricula.fill = GridBagConstraints.BOTH;
		gbc_tfMatricula.gridwidth = 3;
		gbc_tfMatricula.insets = new Insets(0, 0, 5, 0);
		gbc_tfMatricula.gridx = 1;
		gbc_tfMatricula.gridy = 1;
		pnPrincipal.add(tfMatricula, gbc_tfMatricula);
		tfMatricula.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome*:");
		lblNome.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMatricula = new GridBagConstraints();
		gbc_lblMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatricula.gridx = 0;
		gbc_lblMatricula.gridy = 2;
		pnPrincipal.add(lblNome, gbc_lblMatricula);
		
		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.gridwidth = 3;
		gbc_tfNome.insets = new Insets(0, 0, 5, 0);
		gbc_tfNome.fill = GridBagConstraints.BOTH;
		gbc_tfNome.gridx = 1;
		gbc_tfNome.gridy = 2;
		pnPrincipal.add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF*:");
		lblCpf.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpf.gridx = 0;
		gbc_lblCpf.gridy = 3;
		pnPrincipal.add(lblCpf, gbc_lblCpf);
		
		try 
		{
			tfCpf =new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {};
		GridBagConstraints gbc_tfCpf = new GridBagConstraints();
		gbc_tfCpf.gridwidth = 3;
		gbc_tfCpf.insets = new Insets(0, 0, 5, 0);
		gbc_tfCpf.fill = GridBagConstraints.BOTH;
		gbc_tfCpf.gridx = 1;
		gbc_tfCpf.gridy = 3;
		pnPrincipal.add(tfCpf, gbc_tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data Nasc*.");
		lblDataNasc.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDataNasc = new GridBagConstraints();
		gbc_lblDataNasc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataNasc.gridx = 0;
		gbc_lblDataNasc.gridy = 4;
		pnPrincipal.add(lblDataNasc, gbc_lblDataNasc);
		
		try 
		{
			tfDataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		}catch (Exception e) {}
		
		GridBagConstraints gbc_tfDataNasc = new GridBagConstraints();
		gbc_tfDataNasc.gridwidth = 3;
		gbc_tfDataNasc.insets = new Insets(0, 0, 5, 0);
		gbc_tfDataNasc.fill = GridBagConstraints.BOTH;
		gbc_tfDataNasc.gridx = 1;
		gbc_tfDataNasc.gridy = 4;
		pnPrincipal.add(tfDataNasc, gbc_tfDataNasc);
		tfDataNasc.setColumns(10);
		
		JLabel lblFuno = new JLabel("Especialidade*:");
		lblFuno.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFuno = new GridBagConstraints();
		gbc_lblFuno.insets = new Insets(0, 0, 5, 5);
		gbc_lblFuno.gridx = 0;
		gbc_lblFuno.gridy = 5;
		pnPrincipal.add(lblFuno, gbc_lblFuno);
		
		tfEspecialidade = new JTextField();
		GridBagConstraints gbc_tfFuncao = new GridBagConstraints();
		gbc_tfFuncao.gridwidth = 3;
		gbc_tfFuncao.insets = new Insets(0, 0, 5, 0);
		gbc_tfFuncao.fill = GridBagConstraints.BOTH;
		gbc_tfFuncao.gridx = 1;
		gbc_tfFuncao.gridy = 5;
		pnPrincipal.add(tfEspecialidade, gbc_tfFuncao);
		tfEspecialidade.setColumns(10);
		
		lblSenha = new JLabel("Senha*:");
		lblSenha.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 6;
		pnPrincipal.add(lblSenha, gbc_lblSenha);
		
		tfSenha = new JPasswordField();
		GridBagConstraints gbc_tfSenha = new GridBagConstraints();
		gbc_tfSenha.gridwidth = 3;
		gbc_tfSenha.insets = new Insets(0, 0, 5, 5);
		gbc_tfSenha.fill = GridBagConstraints.BOTH;
		gbc_tfSenha.gridx = 1;
		gbc_tfSenha.gridy = 6;
		pnPrincipal.add(tfSenha, gbc_tfSenha);
		
		JLabel lblAtivo = new JLabel("Ativo*:");
		lblAtivo.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblAtivo = new GridBagConstraints();
		gbc_lblAtivo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAtivo.gridx = 0;
		gbc_lblAtivo.gridy = 7;
		pnPrincipal.add(lblAtivo, gbc_lblAtivo);
		
		cbAtivo = new JCheckBox();
		cbAtivo.setSelected(true);
		GridBagConstraints gbc_tfAtivo = new GridBagConstraints();
		gbc_tfAtivo.gridwidth = 3;
		gbc_tfAtivo.insets = new Insets(0, 0, 5, 5);
		gbc_tfAtivo.fill = GridBagConstraints.BOTH;
		gbc_tfAtivo.gridx = 1;
		gbc_tfAtivo.gridy = 7;
		pnPrincipal.add(cbAtivo, gbc_tfAtivo);
		
		JPanel pnBotoes = new JPanel(new FlowLayout());
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(255, 255, 255));
		btnSalvar.setBackground(new Color(60, 179, 113));
		btnSalvar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/check.png")));
		btnSalvar.setFocusPainted(false);
		btnSalvar.setMnemonic(KeyEvent.VK_S);
		
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean erros = false;
				
				if(tipo == 1) {//Edição
					String senha = Funcoes.md5(new String(tfSenha.getPassword()));					
					Funcionario funcionario = new Funcionario(f.getId(),tfMatricula.getText(), tfNome.getText(), tfCpf.getText(),
							             (senha.isEmpty() ? f.getSenha() : senha), Funcoes.converterDataEUA(tfDataNasc.getText()),
					                     "Medico", cbAtivo.isSelected(), 2);
					
					Medico medico = new Medico(funcionario, f.getIdMedico(), tfCrm.getText(), tfEspecialidade.getText());
					if(!FuncionarioDao.update(funcionario))
						Funcoes.mostrarMensagemErro("Erro ao atualizar Funcionario!");
					
					erros = MedicoDao.update(medico) ? false : true;
					
				}else if(tipo == 2){//Exclusão
					erros = MedicoDao.delete(f) ? false : true;				
				}
				else //Inserção
				{
					Funcionario funcionario = new Funcionario(tfMatricula.getText(), tfNome.getText(), tfCpf.getText(),
							Funcoes.md5(new String(tfSenha.getPassword())), Funcoes.converterDataEUA(tfDataNasc.getText()),
					        "Medico", cbAtivo.isSelected(), 2);
			
					if(!FuncionarioDao.insert(f))
						Funcoes.mostrarMensagemErro("Falha ao inserir Funcionario");
		
					funcionario = FuncionarioDao.getFuncionario(f.getMatricula());
					Medico medico = new Medico(funcionario, 0, tfCrm.getText(), tfEspecialidade.getText());
					erros = MedicoDao.insert(medico) ? false : true; 
				}
				
				if(erros)
					Funcoes.mostrarMensagemErro("Erro ao salvar");
				else {
					pai.tbModel.setDados(MedicoDao.getAll());
					String msg = "Médico adicionado com sucesso!";
					if(tipo == 1)
						msg = "Médico alterado com sucesso!";
					else if(tipo == 2)
						msg = "Médico excluído com sucesso!";
					Funcoes.mostrarMensagemSucesso(msg);
				}
				dispose();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(232, 91, 84));
		btnCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/cancel.png")));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setMnemonic(KeyEvent.VK_C);
		btnCancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		pnBotoes.add(btnSalvar);
		pnBotoes.add(btnCancelar);
		contentPane.add(pnBotoes, BorderLayout.SOUTH);
		
		setResizable(false);
		setTitle("Cadastro de Médico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(520,340);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void preencherCampos(Medico f) {
		tfCrm.setText(f.getCrm());
		tfMatricula.setText(f.getMatricula());
		tfNome.setText(f.getNome());
		tfCpf.setText(f.getCpf());
		tfDataNasc.setText(Funcoes.converterDataBR(f.getDataNascimento()));
		tfEspecialidade.setText(f.getEspecialidade());
		cbAtivo.setSelected(f.isAtivo());
	}
}
