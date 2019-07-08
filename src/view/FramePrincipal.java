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

import model.Funcionario;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FramePrincipal extends JFrame 
{
	private JMenu mPaciente, mConsulta, mGerencia, mConta, mOutros;
	private JMenuItem miNovoPaciente, miGerenciarPacientes, miGerenciarConsultas, miAlterarAnamnese, miAlterarHistorico, miGerenciarMedicos, miGerenciarFuncionarios, miNovaConsulta, miAlterarDados, miAlterarSenha, miAjuda, miSobre;
	private JMenuBar mbMenu;
	private Funcionario usuario;
	
	public static void main(String[] args) 
	{
		new FramePrincipal();
	}
	
	public FramePrincipal() 
	{		
		//Configurações do JMenuBar
		mbMenu = new JMenuBar();
		mbMenu.setBackground(Color.WHITE);
		mbMenu.setBorder(BorderFactory.createRaisedBevelBorder());
		mbMenu.setBorderPainted(true);
		mbMenu.setVisible(false);
		
		//=============// Configurações do JFrame //=============//
		//Configuração do Background
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)screenSize.getHeight();
		
		String urlBG = String.format("Imagens/bg%dp.jpg", height);
		System.out.println(urlBG);
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
		new DialogLogin(this);
	}
	
	public void setJMenuConfig(JMenu m, String nome, int tecla, ImageIcon img)
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
		action.putValue(Action.SMALL_ICON, img);
		m.setAction(action);
	}
	
	public void setJMenuItemConfig(JMenuItem m, String nome, ImageIcon img)
	{
		AbstractAction action = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				
			}
		};
		action.putValue(Action.NAME, nome);
		action.putValue(Action.SMALL_ICON, img);
		m.setAction(action);
	}
	
	public Funcionario getUsuario() 
	{
		return usuario;
	}

	public void setUsuario(Funcionario usuario) 
	{
		this.usuario = usuario;
	}
	
	public void configurarJMenuBar()
	{
		mbMenu.setVisible(true);
		
		//Configurações dos JMenu
		if(usuario.getPermissao() != 2)
		{
			mbMenu.add(mPaciente = new JMenu("Paciente"));
			//==============// JMenu Paciente e seus itens //==============//
			setJMenuConfig(mPaciente, "Paciente", KeyEvent.VK_P, new ImageIcon(getClass().getClassLoader().getResource("Imagens/paciente.png")));
			
			//Configuração do JMenuItem de gerenciar consultas
			mPaciente.add(miNovoPaciente = new JMenuItem());
			setJMenuItemConfig(miNovoPaciente, "Novo paciente", new ImageIcon(getClass().getClassLoader().getResource("Imagens/novo_paciente.png")));
			
			//Configuração do JMenuItem de gerenciar consultas
			mPaciente.add(miGerenciarPacientes = new JMenuItem());
			setJMenuItemConfig(miGerenciarPacientes, "Gerenciar pacientes", new ImageIcon(getClass().getClassLoader().getResource("Imagens/gerenciar_paciente.png")));
		}
		
		//==============// JMenu Consulta e seus itens //==============//
		if(usuario.getPermissao() != 1)
		{
			mbMenu.add(mConsulta = new JMenu("Consulta"));
			setJMenuConfig(mConsulta, "Consulta", KeyEvent.VK_C, new ImageIcon(getClass().getClassLoader().getResource("Imagens/consulta.png")));
			
			//Configuração do JMenuItem de gerenciar consultas
			mConsulta.add(miNovaConsulta = new JMenuItem());
			setJMenuItemConfig(miNovaConsulta, "Nova consulta", new ImageIcon(getClass().getClassLoader().getResource("Imagens/nova_consulta.png")));
			
			//Configuração do JMenuItem de gerenciar consultas
			mConsulta.add(miGerenciarConsultas = new JMenuItem());
			setJMenuItemConfig(miGerenciarConsultas, "Gerenciar consultas", new ImageIcon(getClass().getClassLoader().getResource("Imagens/gerenciar_consulta.png")));
		}
		
		//==============// JMenu Gerência e seus itens //==============//
		if(usuario.getPermissao() == 3)
		{
			mbMenu.add(mGerencia = new JMenu("Gerência"));
			setJMenuConfig(mGerencia, "Gerência", KeyEvent.VK_G, new ImageIcon(getClass().getClassLoader().getResource("Imagens/gerencia.png")));	
	
			//Configuração do JMenuItem de gerenciar funcionários
			mGerencia.add(miGerenciarFuncionarios = new JMenuItem());
			setJMenuItemConfig(miGerenciarFuncionarios, "Gerenciar funcionários", new ImageIcon(getClass().getClassLoader().getResource("Imagens/gerenciar_funcionarios.png")));
			
			//Configuração do JMenuItem de gerenciar médicos
			mGerencia.add(miGerenciarMedicos = new JMenuItem());
			setJMenuItemConfig(miGerenciarMedicos, "Gerenciar médicos", new ImageIcon(getClass().getClassLoader().getResource("Imagens/gerencia_medico.png")));
			
	
			//Configuração do JMenuItem de alterar anamnese
			mGerencia.add(miAlterarAnamnese = new JMenuItem());
			setJMenuItemConfig(miAlterarAnamnese, "Alterar questões do anamnese", new ImageIcon(getClass().getClassLoader().getResource("Imagens/alterar_anamnese.png")));
			
			//Configuração do JMenuItem de alterar histórico familiar
			mGerencia.add(miAlterarHistorico = new JMenuItem());
			setJMenuItemConfig(miAlterarHistorico, "Alterar questões do histórico familiar", new ImageIcon(getClass().getClassLoader().getResource("Imagens/alterar_historico.png")));
		}
		
		//==============// JMenu Conta e seus itens //==============//
		mbMenu.add(mConta = new JMenu("Conta"));
		setJMenuConfig(mConta, "Conta", KeyEvent.VK_O, new ImageIcon(getClass().getClassLoader().getResource("Imagens/conta.png")));
		
		//Configuração do JMenuItem de alterar dados da conta
		mConta.add(miAlterarDados = new JMenuItem());
		setJMenuItemConfig(miAlterarDados, "Alterar dados", new ImageIcon(getClass().getClassLoader().getResource("Imagens/alterar_dados.png")));
		
		//Configuração do JMenuItem de alterar senha
		mConta.add(miAlterarSenha = new JMenuItem());
		setJMenuItemConfig(miAlterarSenha, "Alterar senha", new ImageIcon(getClass().getClassLoader().getResource("Imagens/alterar_senha.png")));
		
		//==============// JMenu Outros e seus itens //==============//
		mbMenu.add(mOutros = new JMenu("Outros"));
		setJMenuConfig(mOutros, "Outros", 0, new ImageIcon(getClass().getClassLoader().getResource("Imagens/outros.png")));
		
		//Configuração do JMenuItem de ajuda
		mOutros.add(miAjuda = new JMenuItem());
		setJMenuItemConfig(miAjuda, "Ajuda", new ImageIcon(getClass().getClassLoader().getResource("Imagens/ajuda.png")));
		
		//Configuração do JMenuItem de alterar senha
		mOutros.add(miSobre = new JMenuItem());
		setJMenuItemConfig(miSobre, "Sobre", new ImageIcon(getClass().getClassLoader().getResource("Imagens/sobre.png")));
	}
}
