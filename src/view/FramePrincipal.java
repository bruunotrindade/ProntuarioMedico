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
	private JMenu mArquivo, mCadastro, mConsulta, mUtilitario;
	private boolean acessoAutorizado = false;
	
	public static void main(String[] args) 
	{
		new FramePrincipal();
		
	}
	
	public FramePrincipal() 
	{		
		//Configurações do JMenuBar
		JMenuBar mbMenu = new JMenuBar();
		mbMenu.setBackground(Color.WHITE);
		mbMenu.setBorder(BorderFactory.createRaisedBevelBorder());
		mbMenu.setBorderPainted(true);
		mbMenu.add(mArquivo = new JMenu("Arquivo"));
		mbMenu.add(mCadastro = new JMenu("Cadastro"));
		mbMenu.add(mConsulta = new JMenu("Consulta"));
		mbMenu.add(mUtilitario = new JMenu("Utilitário"));
		
		//Configurações dos JMenu
		setJMenuAction(mArquivo, "Arquivo", KeyEvent.VK_A, "Não definido.");
		setJMenuAction(mCadastro, "Cadastro", KeyEvent.VK_C, "Recursos referentes a cadastro de pacientes.");
		setJMenuAction(mConsulta, "Consulta", KeyEvent.VK_O, "Recursos referentes a consulta de pacientes.");
		setJMenuAction(mUtilitario, "Utilitário", KeyEvent.VK_U, "Não definido ainda.");
		
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
		new DialogLogin(this);
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
