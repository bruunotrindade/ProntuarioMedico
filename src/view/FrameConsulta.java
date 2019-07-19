package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import dao.ConsultaDao;
import dao.FuncionarioDao;
import dao.PacienteDao;
import dao.ProcedimentoDao;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import model.Procedimento;
import utils.Funcoes;
import view.FrameQuestoesAnamnese.PerguntaGUI;
import model.Consulta;
import model.Funcionario;
import model.Medico;
import model.Paciente;

public class FrameConsulta extends JFrame
{
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfNascimento;
	private JTextField tfDescricao;
	private FrameGerenciarConsulta pai;
	private Consulta c;
	private int tipo = 0;
	private JScrollPane scpProced;
	private JTextArea taSintomas, taObs;
	private JPanel pnPrincipal;
	private ArrayList<ProcedimentoGUI> procs = new ArrayList<ProcedimentoGUI>();
	
	class ProcedimentoGUI
	{
		JTextField tfNovo = new JTextField();
		JComboBox cbNovo = new JComboBox();
		JLabel lbXNovo = new JLabel("X");
		
		public ProcedimentoGUI()
		{
			tfNovo.setEnabled(false);
			cbNovo.setEnabled(false);
			cbNovo.setModel(new DefaultComboBoxModel(new String[] {"Remédio", "Exame"}));
			lbXNovo.setEnabled(false);
		}
	}
	
	public FrameConsulta(FrameGerenciarConsulta pai, Consulta c, int tipo) 
    {
		this();
		this.c = c;
		this.tipo = tipo;
		boolean erros = false;
		tfCpf.setText(c.getPaciente().getCpf());
		tfNome.setText(c.getPaciente().getNome());
		tfNascimento.setText(Funcoes.converterDataBR(c.getPaciente().getDataNascimento()));
		taSintomas.setText(c.getSintomas());
		taObs.setText(c.getObs());
		tfCpf.setEditable(false);
		tfCpf.setFocusable(false);
		taObs.setEditable(true);
		taSintomas.setEditable(true);
		
		ArrayList<Procedimento> procedimentos = ProcedimentoDao.getBy("CONSULTA_ID", c.getId()+"");
		procs.clear();
		for(Procedimento p : procedimentos)
		{
			ProcedimentoGUI pgui = new ProcedimentoGUI();
			pgui.cbNovo.setSelectedItem(p.getTipo());
			pgui.cbNovo.setEnabled(true);
			pgui.tfNovo.setText(p.getDesc());
			pgui.tfNovo.setEnabled(true);
			pgui.lbXNovo.setEnabled(true);
			procs.add(pgui);
		}
		gerarPanelProcedimentos();
	}
	
	public FrameConsulta() 
	{
		setTitle("Consulta");
		setSize(465, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		
		pnPrincipal = new JPanel(new BorderLayout());
		
		JPanel pnDados = new JPanel();
		pnDados.setBorder(new TitledBorder(null, "Dados pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(pnPrincipal);
		pnDados.setLayout(new BoxLayout(pnDados, BoxLayout.PAGE_AXIS));
		
		JPanel pn1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pn1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnDados.add(pn1);
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("Dialog", Font.PLAIN, 12));
		pn1.add(lblPaciente);
		
		tfNome = new JTextField();
		pn1.add(tfNome);
		tfNome.setColumns(31);
		tfNome.setEditable(false);
		
		JPanel pn2 = new JPanel();
		FlowLayout fl_pn2 = (FlowLayout) pn2.getLayout();
		fl_pn2.setAlignment(FlowLayout.LEFT);
		pnDados.add(pn2);
		
		JPanel pn2_1 = new JPanel();
		FlowLayout fl_pn2_1 = (FlowLayout) pn2_1.getLayout();
		fl_pn2_1.setAlignment(FlowLayout.LEFT);
		pn2.add(pn2_1);
		
		JLabel lbCpf = new JLabel("CPF:");
		lbCpf.setFont(new Font("Dialog", Font.PLAIN, 12));
		pn2_1.add(lbCpf);
		
		tfCpf = new JTextField();
		try
		{
			tfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		}
		catch(Exception e){}
		pn2_1.add(tfCpf);
		tfCpf.setColumns(10);
		
		
		JPanel pn2_2 = new JPanel();
		FlowLayout fl_pn2_2 = (FlowLayout) pn2_2.getLayout();
		fl_pn2_2.setAlignment(FlowLayout.LEFT);
		pn2.add(pn2_2);
		
		JLabel lbNascimento = new JLabel("Data de Nascimento:");
		lbNascimento.setFont(new Font("Dialog", Font.PLAIN, 12));
		pn2_2.add(lbNascimento);
		
		tfNascimento = new JTextField();
		try 
		{
			tfNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
			tfNascimento.setEditable(false);
		}
		catch (Exception e) {}
		pn2_2.add(tfNascimento);
		tfNascimento.setColumns(10);
		
		
		JPanel pn3 = new JPanel();
		FlowLayout fl_pn3 = (FlowLayout) pn3.getLayout();
		fl_pn3.setAlignment(FlowLayout.LEFT);
		pnDados.add(pn3);
		
		JLabel lbSintomas = new JLabel("Sintomas:");
		lbSintomas.setFont(new Font("Dialog", Font.PLAIN, 12));
		pn3.add(lbSintomas);
		
		taSintomas = new JTextArea();
		taSintomas.setRows(6);
		taSintomas.setColumns(31);
		taSintomas.setEditable(false);
		pn3.add(new JScrollPane(taSintomas));
		
		JPanel pn4 = new JPanel();
		FlowLayout fl_pn4 = (FlowLayout) pn4.getLayout();
		fl_pn4.setAlignment(FlowLayout.LEFT);
		pnDados.add(pn4);
		
		JLabel lblObs = new JLabel("Obs.:");
		lblObs.setFont(new Font("Dialog", Font.PLAIN, 12));
		pn4.add(lblObs);
		
		taObs = new JTextArea();
		taObs.setRows(6);
		taObs.setColumns(34);
		taObs.setEditable(false);
		pn4.add(new JScrollPane(taObs));	
		
		pnPrincipal.add(pnDados, BorderLayout.NORTH);
		
		JPanel pnButoes = new JPanel();
		//pnDados.add(pnButoes);
		pnPrincipal.add(pnButoes, BorderLayout.SOUTH);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(255, 255, 255));
		btnSalvar.setBackground(new Color(60, 179, 113));
		btnSalvar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/check.png")));
		btnSalvar.setFocusPainted(false);
		btnSalvar.setMnemonic(KeyEvent.VK_S);
		pnButoes.add(btnSalvar);
		
		JButton btNovo = new JButton("Novo Procedimento");
		pnButoes.add(btNovo);
		
		btnSalvar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				boolean erro = false;
				if(tipo == 0)
				{
					//Criando a consulta
					Paciente paciente = c.getPaciente();
					c = new Consulta(taSintomas.getText(), taObs.getText(), "", paciente, (Medico)pai.pai.getUsuario());
					erro = !ConsultaDao.insert(c);
					
					//Percorrendo os procedimentos
					for(ProcedimentoGUI p : procs)
					{
						if(p.tfNovo.getText().length() == 0)
							continue;
						
						Procedimento proced = new Procedimento(p.cbNovo.getSelectedItem().toString(), p.tfNovo.getText(), "", c);
						if(!ProcedimentoDao.insert(proced))
							erro = false;
					}
					
					if(erro)
						Funcoes.mostrarMensagemErro("Falha ao salvar!");
					else
					{
						Funcoes.mostrarMensagemSucesso("Consulta realizada com sucesso!");
						FrameConsulta.this.dispose();
					}
				}
				else if(tipo == 1)//Edição
				{
					Paciente paciente = PacienteDao.getBy("NOME", tfNome.getText()).get(0);
					c.setSintomas(taSintomas.getText());
					c.setObs(taObs.getText());
					erro = ConsultaDao.update(c) ? false : true;
					
					ProcedimentoDao.delete(c.getId());
					
					//Percorrendo os procedimentos
					for(ProcedimentoGUI p : procs)
					{
						if(p.tfNovo.getText().length() == 0)
							continue;
						
						Procedimento proced = new Procedimento(p.cbNovo.getSelectedItem().toString(), p.tfNovo.getText(), "", c);
						if(!ProcedimentoDao.insert(proced))
							erro = false;
					}
					
					if(erro)
						Funcoes.mostrarMensagemErro("Falha ao salvar!");
					else if(ConsultaDao.delete(c))
					{
						Funcoes.mostrarMensagemSucesso("Consulta alterada com sucesso!");
						FrameConsulta.this.dispose();
					}
				}
				else if(tipo == 2)//Exclusão
				{
					Paciente paciente = PacienteDao.getBy("NOME", tfNome.getText()).get(0);
					
					erro = ProcedimentoDao.delete(c.getId()) ? false : true;
					if(erro)
						Funcoes.mostrarMensagemErro("Falha ao salvar!");
					else if(ConsultaDao.delete(c))
					{
						Funcoes.mostrarMensagemSucesso("Consulta excluída com sucesso!");
						FrameConsulta.this.dispose();
					}
				}
			}
		});
		
		btNovo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				procs.add(new ProcedimentoGUI());
				gerarPanelProcedimentos();
			}
		});
		btNovo.setForeground(new Color(255, 255, 255));
		btNovo.setBackground(new Color(55, 140, 65));
		btNovo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/plus.png")));
		btNovo.setFocusPainted(false);
		btNovo.setMnemonic(KeyEvent.VK_N);
		if(procs.size() == 0)
			btNovo.getActionListeners()[0].actionPerformed(null);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setForeground(new Color(255, 255, 255));
		btCancelar.setBackground(new Color(232, 91, 84));
		btCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/cancel.png")));
		btCancelar.setFocusPainted(false);
		btCancelar.setMnemonic(KeyEvent.VK_C);
		btCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				FrameConsulta.this.dispose();
			}
		});
		
		pnButoes.add(btCancelar);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		tfCpf.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String CPF = tfCpf.getText();
				if(CPF.contains(" "))
					Funcoes.mostrarMensagemErro("Preencha o CPF corretamente!");
				else
				{
					try
					{
						Paciente p = PacienteDao.getBy("CPF", CPF).get(0);
						c = new Consulta("", "", "", p, (Medico)pai.pai.getUsuario());
						tfCpf.setEditable(false);
						tfCpf.setFocusable(false);
						tfNome.setText(p.getNome());
						tfNascimento.setText(Funcoes.converterDataBR(p.getDataNascimento()));
						taObs.setEditable(true);
						taSintomas.setEditable(true);
						procs.get(0).cbNovo.setEnabled(true);
						procs.get(0).lbXNovo.setEnabled(true);
						procs.get(0).tfNovo.setEnabled(true);
					}
					catch(NullPointerException | IndexOutOfBoundsException npe )
					{
						Funcoes.mostrarMensagemErro("CPF não encontrado. Verifique-o!");
					}
				}
			}
		});
		tfCpf.requestFocus();
	}
	
	public void gerarPanelProcedimentos()
	{
		JPanel pnProcedimentos = new JPanel();
		pnProcedimentos.setBorder(new TitledBorder(null, "Procedimentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnProcedimentos.setLayout(new GridLayout(0, 1, 0, 0));
		for(ProcedimentoGUI p : procs)
		{
			JPanel pnovo = new JPanel();
			JLabel lbNovo = new JLabel("Descrição:");
			lbNovo.setFont(new Font("Dialog", Font.PLAIN, 12));
			
			pnovo.add(lbNovo);
			
			p.tfNovo.setColumns(17);
			p.tfNovo.setEnabled(true);
			pnovo.add(p.tfNovo);
			
			JLabel lbTipoNovo = new JLabel("Tipo:");
			lbTipoNovo.setFont(new Font("Dialog", Font.PLAIN, 12));
			pnovo.add(lbTipoNovo);
			
			pnovo.add(p.cbNovo);
			p.cbNovo.setEnabled(true);
			
			p.lbXNovo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			p.lbXNovo.setFont(new Font("Dialog", Font.BOLD, 18));
			p.lbXNovo.setForeground(Color.RED);
			p.lbXNovo.setEnabled(true);
			p.lbXNovo.addMouseListener(new MouseAdapter() 
			{
				public void mousePressed(MouseEvent e) 
				{
					for(ProcedimentoGUI p : procs)
					{
						if(e.getSource() == p.lbXNovo && p.lbXNovo.isEnabled())
						{
							procs.remove(p);
							gerarPanelProcedimentos();
							break;
						}
					}
				}
			});
			pnovo.add(p.lbXNovo);
			
			JPanel pLine = new JPanel();
			pLine.add(pnovo);
			
			pnProcedimentos.add(pLine);
			try 
			{
				pnPrincipal.remove(scpProced);
			}
			catch(NullPointerException npe) {}
			scpProced = new JScrollPane(pnProcedimentos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			pnPrincipal.add(scpProced, BorderLayout.CENTER);
		}
		FrameConsulta.this.revalidate();
		FrameConsulta.this.repaint();
	}
}
