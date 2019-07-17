package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import java.text.Format;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class FrameCadastroMedico extends JFrame {

	private JPanel contentPane;
	private FrameGerenciarMedico pai;
	private JTextField tfMatricula;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfDataNasc;
	private JTextField tfFuncao;
	private JButton btnSalvar;
	private JLabel lblSenha;
	private JPasswordField tfSenha;
	private JTextField tfCrm;
	private Medico f = null;
	private boolean editar = false;
	
	public FrameCadastroMedico(FrameGerenciarMedico pai, Medico f)
	{
		this(pai);
		this.f = f;
		this.editar = true;
		setTitle("Editar Medico");
		preencherCampos(f);
	}
	
	public FrameCadastroMedico(FrameGerenciarMedico pai) {
		this.pai = pai;
		
		setResizable(false);
		setTitle("Cadastrar Medico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(520,250);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 180, 234, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 29, 45, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblCrm = new JLabel("CRM");
		GridBagConstraints gbc_lblCrm = new GridBagConstraints();
		gbc_lblCrm.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrm.gridx = 0;
		gbc_lblCrm.gridy = 0;
		contentPane.add(lblCrm, gbc_lblCrm);
		
		tfCrm = new JTextField();
		GridBagConstraints gbc_tfCrm = new GridBagConstraints();
		gbc_tfCrm.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCrm.gridwidth = 3;
		gbc_tfCrm.insets = new Insets(0, 0, 5, 0);
		gbc_tfCrm.gridx = 1;
		gbc_tfCrm.gridy = 0;
		contentPane.add(tfCrm, gbc_tfCrm);
		tfCrm.setColumns(10);
		
		JLabel lblMat = new JLabel("Matricula");
		GridBagConstraints gbc_lblMat = new GridBagConstraints();
		gbc_lblMat.insets = new Insets(0, 0, 5, 5);
		gbc_lblMat.gridx = 0;
		gbc_lblMat.gridy = 1;
		contentPane.add(lblMat, gbc_lblMat);
		
		tfMatricula = new JTextField();
		GridBagConstraints gbc_tfMatricula = new GridBagConstraints();
		gbc_tfMatricula.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMatricula.gridwidth = 3;
		gbc_tfMatricula.insets = new Insets(0, 0, 5, 0);
		gbc_tfMatricula.gridx = 1;
		gbc_tfMatricula.gridy = 1;
		contentPane.add(tfMatricula, gbc_tfMatricula);
		tfMatricula.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Nome");
		GridBagConstraints gbc_lblMatricula = new GridBagConstraints();
		gbc_lblMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatricula.gridx = 0;
		gbc_lblMatricula.gridy = 2;
		contentPane.add(lblMatricula, gbc_lblMatricula);
		
		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.gridwidth = 3;
		gbc_tfNome.insets = new Insets(0, 0, 5, 0);
		gbc_tfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNome.gridx = 1;
		gbc_tfNome.gridy = 2;
		contentPane.add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpf.gridx = 0;
		gbc_lblCpf.gridy = 3;
		contentPane.add(lblCpf, gbc_lblCpf);
		
		try {
			tfCpf =new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {};
		GridBagConstraints gbc_tfCpf = new GridBagConstraints();
		gbc_tfCpf.gridwidth = 3;
		gbc_tfCpf.insets = new Insets(0, 0, 5, 0);
		gbc_tfCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCpf.gridx = 1;
		gbc_tfCpf.gridy = 3;
		contentPane.add(tfCpf, gbc_tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data Nasc.");
		GridBagConstraints gbc_lblDataNasc = new GridBagConstraints();
		gbc_lblDataNasc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataNasc.gridx = 0;
		gbc_lblDataNasc.gridy = 4;
		contentPane.add(lblDataNasc, gbc_lblDataNasc);
		
		try {
		tfDataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		}catch (Exception e) {}
		
		GridBagConstraints gbc_tfDataNasc = new GridBagConstraints();
		gbc_tfDataNasc.gridwidth = 3;
		gbc_tfDataNasc.insets = new Insets(0, 0, 5, 0);
		gbc_tfDataNasc.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDataNasc.gridx = 1;
		gbc_tfDataNasc.gridy = 4;
		contentPane.add(tfDataNasc, gbc_tfDataNasc);
		tfDataNasc.setColumns(10);
		
		JLabel lblFuno = new JLabel("Especialidade");
		GridBagConstraints gbc_lblFuno = new GridBagConstraints();
		gbc_lblFuno.insets = new Insets(0, 0, 5, 5);
		gbc_lblFuno.gridx = 0;
		gbc_lblFuno.gridy = 5;
		contentPane.add(lblFuno, gbc_lblFuno);
		
		tfFuncao = new JTextField();
		GridBagConstraints gbc_tfFuncao = new GridBagConstraints();
		gbc_tfFuncao.gridwidth = 3;
		gbc_tfFuncao.insets = new Insets(0, 0, 5, 0);
		gbc_tfFuncao.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFuncao.gridx = 1;
		gbc_tfFuncao.gridy = 5;
		contentPane.add(tfFuncao, gbc_tfFuncao);
		tfFuncao.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 6;
		contentPane.add(lblSenha, gbc_lblSenha);
		
		tfSenha = new JPasswordField();
		GridBagConstraints gbc_tfSenha = new GridBagConstraints();
		gbc_tfSenha.gridwidth = 3;
		gbc_tfSenha.insets = new Insets(0, 0, 5, 5);
		gbc_tfSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSenha.gridx = 1;
		gbc_tfSenha.gridy = 6;
		contentPane.add(tfSenha, gbc_tfSenha);
		
		btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.anchor = GridBagConstraints.EAST;
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvar.gridx = 2;
		gbc_btnSalvar.gridy = 7;
		contentPane.add(btnSalvar, gbc_btnSalvar);
		
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean erros = false;
				MedicoDao medicoDao = new MedicoDao();
				FuncionarioDao funcDao = new FuncionarioDao();
				
				if(editar) {
					String senha = new String(tfSenha.getPassword());					
					Funcionario funcionario = new Funcionario(f.getId(),tfMatricula.getText(), tfNome.getText(), tfCpf.getText(),
							             (senha.isEmpty() ? f.getSenha() : senha), Funcoes.converterDataEUA(tfDataNasc.getText()),
					                     "Medico", true, 2);
					
					if(!funcDao.update(funcionario))
						Funcoes.mostrarMensagemErro("Erro ao atualizar Funcionario!");
					
					Medico medico = new Medico(f, f.getCrm(), f.getEspecialidade());
					erros = medicoDao.update(medico) ? false : true;
				}else {
					
					Funcionario f = new Funcionario(tfMatricula.getText(), tfNome.getText(), tfCpf.getText(),
							        new String(tfSenha.getPassword()), Funcoes.converterDataEUA(tfDataNasc.getText()),
							        "Medico", true, 2);
					
					if(!funcDao.insert(f))
						Funcoes.mostrarMensagemErro("Falha ao inserir Funcionario");

					f = funcDao.getFuncionario(f.getMatricula());
					Medico medico = new Medico(f, tfCrm.getText(), tfFuncao.getText());
					erros = medicoDao.insert(medico) ? false : true; 				
				}
				
				if(erros)
					Funcoes.mostrarMensagemErro("Erro ao salvar");
				else {
					pai.tbModel.setDados(MedicoDao.getAll());
					Funcoes.mostrarMensagemSucesso("Salvo com sucesso!");
				}
				dispose();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.WEST;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 7;
		contentPane.add(btnCancelar, gbc_btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		setVisible(true);
	}
	
	private void preencherCampos(Medico f) {
		tfCrm.setText(f.getCrm());
		tfMatricula.setText(f.getMatricula());
		tfNome.setText(f.getNome());
		tfCpf.setText(f.getCpf());
		tfDataNasc.setText(Funcoes.converterDataBR(f.getDt_nasc()));
		tfFuncao.setText(f.getFuncao());
	}
}
