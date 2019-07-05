package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class DialogLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfCPF;
	private JPasswordField pfSenha;
	private FramePrincipal pai;

	public DialogLogin(FramePrincipal pai) 
	{
		this.pai = pai;
		
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(20);
		contentPanel.add(panel_1);
		
		JLabel lbLogin = new JLabel("Acesso ao Sistema");
		lbLogin.setFont(new Font("Dialog", Font.BOLD, 18));
		panel_1.add(lbLogin);
		
		JPanel panel = new JPanel();
		contentPanel.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{244, 0};
		gbl_panel.rowHeights = new int[] {25, 35, 25, 30, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lbCPF = new JLabel("CPF:");
		GridBagConstraints gbc_lbCPF = new GridBagConstraints();
		gbc_lbCPF.fill = GridBagConstraints.BOTH;
		gbc_lbCPF.insets = new Insets(0, 0, 5, 0);
		gbc_lbCPF.gridx = 0;
		gbc_lbCPF.gridy = 0;
		panel.add(lbCPF, gbc_lbCPF);
		
		try
		{
			tfCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		}
		catch(Exception e)
		{
		}
		GridBagConstraints gbc_tfCPF = new GridBagConstraints();
		gbc_tfCPF.fill = GridBagConstraints.BOTH;
		gbc_tfCPF.insets = new Insets(0, 0, 5, 0);
		gbc_tfCPF.gridx = 0;
		gbc_tfCPF.gridy = 1;
		panel.add(tfCPF, gbc_tfCPF);
		tfCPF.setColumns(20);
		
		JLabel lbSenha = new JLabel("Senha:");
		GridBagConstraints gbc_lbSenha = new GridBagConstraints();
		gbc_lbSenha.fill = GridBagConstraints.BOTH;
		gbc_lbSenha.insets = new Insets(0, 0, 5, 0);
		gbc_lbSenha.gridx = 0;
		gbc_lbSenha.gridy = 2;
		panel.add(lbSenha, gbc_lbSenha);
		
		pfSenha = new JPasswordField();
		GridBagConstraints gbc_pfSenha = new GridBagConstraints();
		gbc_pfSenha.fill = GridBagConstraints.BOTH;
		gbc_pfSenha.gridx = 0;
		gbc_pfSenha.gridy = 3;
		panel.add(pfSenha, gbc_pfSenha);
		
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setVgap(30);
		contentPanel.add(panel_2);
		
		//Evento para evitar que burlem o JDialog
		addWindowListener(new WindowAdapter()
		{
		   public void windowClosing(WindowEvent evt)
		   {
			   System.exit(1);
		   }
		});
		
		//Configuração do JButton de entrar
		JButton btEntrar = new JButton("Entrar");
		panel_2.add(btEntrar);
		
		AbstractAction actionEntrar = new AbstractAction() 
		{	
			public void actionPerformed(ActionEvent ae) 
			{
				DialogLogin dl = DialogLogin.this;
				String cpf = dl.tfCPF.getText(), senha = new String(dl.pfSenha.getPassword());
				if(cpf.contains(" ") || senha.length() == 0)
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Falha", JOptionPane.ERROR_MESSAGE);
				else
				{
					//Validação com o banco
					dl.dispose();
					pai.setAcessoAutorizado(true);
				}
			}
		};
		actionEntrar.putValue(Action.NAME, "Entrar");
		actionEntrar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
		actionEntrar.putValue(Action.SHORT_DESCRIPTION, "Entra no sistema com as credenciais inseridas.");
		actionEntrar.putValue(Action.SMALL_ICON, new ImageIcon(getClass().getClassLoader().getResource("Imagens/check.png")));
		btEntrar.setBackground(Color.WHITE);
		btEntrar.setAction(actionEntrar);
		
		//Configuração do JButton de cancelar
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/cancel.png")));
		btCancelar.setBackground(Color.WHITE);
		btCancelar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(1);
			}
		});
		
		panel_2.add(btCancelar);
		
		setModal(true);
		setUndecorated(true);
		setSize(400, 290);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Login");
	}
}
