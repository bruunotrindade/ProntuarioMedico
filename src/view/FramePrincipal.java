package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.*;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FramePrincipal extends JFrame 
{
	private JPanel contentPane;
	private JMenu mPaciente, mConsulta, mGerencia, mConta, mOutros;
	private JMenuItem miNovoPaciente, miGerenciarPacientes, miGerenciarConsultas, miAlterarAnamnese, miAlterarHistorico, miGerenciarMedicos, miGerenciarFuncionarios, miNovaConsulta, miAlterarDados, miAlterarSenha, miAjuda, miSobre;
	private boolean acessoAutorizado = false;//Alterar para quando tiver o model Funcionario
	
	public static void main(String[] args) 
	{
		new FramePrincipal();
		
	}
	
	public FramePrincipal() 
	{		
		AbstractAction action;
		//Configurações do JMenuBar
		JMenuBar mbMenu = new JMenuBar();
		mbMenu.setBackground(Color.WHITE);
		mbMenu.setBorder(BorderFactory.createRaisedBevelBorder());
		mbMenu.setBorderPainted(true);
		mbMenu.add(mPaciente = new JMenu("Paciente"));
		mbMenu.add(mConsulta = new JMenu("Consulta"));
		mbMenu.add(mGerencia = new JMenu("Gerência"));
		mbMenu.add(mConta = new JMenu("Conta"));
		mbMenu.add(mOutros = new JMenu("Outros"));
		
		//Configurações dos JMenu
		//==============// JMenu Paciente e seus itens //==============//
		setJMenuAction(mPaciente, "Paciente", KeyEvent.VK_P, "Recursos referentes a pacientes.");
		//Configuração do JMenuItem de gerenciar consultas
		action = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				
			}
		};
		action.putValue(Action.NAME, "Novo paciente");
		mPaciente.add(miNovoPaciente = new JMenuItem(action));
		mPaciente.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/cancel.png")));
		
		//Configuração do JMenuItem de gerenciar consultas
		action = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				
			}
		};
		action.putValue(Action.NAME, "Gerenciar pacientes");
		mPaciente.add(miGerenciarPacientes = new JMenuItem(action));
		
		//==============// JMenu Consulta e seus itens //==============//
		setJMenuAction(mConsulta, "Consulta", KeyEvent.VK_C, "Recursos referentes a consulta de pacientes.");
		mConsulta.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/cancel.png")));
		
		//Configuração do JMenuItem de gerenciar consultas
		action = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				
			}
		};
		action.putValue(Action.NAME, "Nova consulta");
		mConsulta.add(miNovaConsulta = new JMenuItem(action));
		
		//Configuração do JMenuItem de gerenciar consultas
		action = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				
			}
		};
		action.putValue(Action.NAME, "Gerenciar consultas");
		mConsulta.add(miGerenciarConsultas = new JMenuItem(action));
		
		//==============// JMenu Gerência e seus itens //==============//
		setJMenuAction(mGerencia, "Gerência", KeyEvent.VK_G, "Não definido ainda.");	
		mGerencia.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/cancel.png")));

		//Configuração do JMenuItem de gerenciar funcionários
		action = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				
			}
		};
		action.putValue(Action.NAME, "Gerenciar funcionários");
		mGerencia.add(miGerenciarFuncionarios = new JMenuItem(action));
		
		//Configuração do JMenuItem de gerenciar médicos
		action = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				
			}
		};
		action.putValue(Action.NAME, "Gerenciar médicos");
		mGerencia.add(miGerenciarMedicos = new JMenuItem(action));
				
		//Configuração do JMenuItem de alterar anamnese
		action = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				
			}
		};
		action.putValue(Action.NAME, "Alterar questões da anamnese");
		mGerencia.add(miAlterarAnamnese = new JMenuItem(action));
		
		//Configuração do JMenuItem de alterar histórico familiar
		action = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				
			}
		};
		action.putValue(Action.NAME, "Alterar questões do histórico familiar");
		mGerencia.add(miAlterarHistorico = new JMenuItem(action));
		
		//==============// JMenu Conta e seus itens //==============//
		setJMenuAction(mConta, "Conta", KeyEvent.VK_O, "Não definido.");
		mConta.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/cancel.png")));
		
		//Configuração do JMenuItem de alterar dados da conta
		action = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				
			}
		};
		action.putValue(Action.NAME, "Alterar dados");
		mConta.add(miAlterarDados = new JMenuItem(action));
		
		//Configuração do JMenuItem de alterar senha
		action = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				
			}
		};
		action.putValue(Action.NAME, "Alterar senha");
		mConta.add(miAlterarSenha = new JMenuItem(action));
		
		//==============// JMenu Outros e seus itens //==============//
		setJMenuAction(mOutros, "Outros", 0, "Não definido.");
		mOutros.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/cancel.png")));
		
		//Configuração do JMenuItem de alterar dados da conta
		action = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				
			}
		};
		action.putValue(Action.NAME, "Ajuda");
		mOutros.add(miAjuda = new JMenuItem(action));
		miAjuda.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/teste.png")));
		
		//Configuração do JMenuItem de alterar senha
		action = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				
			}
		};
		action.putValue(Action.NAME, "Sobre");
		mOutros.add(miSobre = new JMenuItem(action));
		
		
		//Configuração do Background
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)screenSize.getHeight();
		
		String urlBG = String.format("Imagens/bg%dp.png", height);
		
		//Configurações do JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLayout(new BorderLayout());
		add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(urlBG))));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setVisible(true);
		setJMenuBar(mbMenu);
		setTitle("Prontuário Médico");
		//new DialogLogin(this);
	}
	
	public void setJMenuAction(JMenu m, String nome, int tecla, String descricao)
	{
		AbstractAction action = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				m.setArmed(!m.isArmed());
			}
		};
		action.putValue(Action.NAME, nome);
		action.putValue(Action.MNEMONIC_KEY, tecla);
		action.putValue(Action.SHORT_DESCRIPTION, descricao);
		m.setAction(action);
	}
	
	public boolean isAcessoAutorizado()
	{
		return acessoAutorizado;
	}

	public void setAcessoAutorizado(boolean acessoAutorizado) 
	{
		this.acessoAutorizado = acessoAutorizado;
	}
}
