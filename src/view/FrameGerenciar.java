package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import dao.PacienteDao;
import tbmodel.PacienteTableModel;

import javax.swing.JRadioButton;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.ImageIcon;

public abstract class FrameGerenciar extends JFrame 
{
	private JPanel contentPane;
	protected JTable table;
	protected FramePrincipal pai;
	protected JTextField tfTexto;
	protected JPanel pConsultarPor;
	protected JButton btConsultar, btEditar, btExcluir, btVisualizar;

	public FrameGerenciar(FramePrincipal pai) 
	{
		this.pai = pai;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {250, 300, 100, 0};
		gbl_panel.rowHeights = new int[] {0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0};
		panel.setLayout(gbl_panel);
		
		pConsultarPor = new JPanel();
		pConsultarPor.setBorder(new TitledBorder(null, "Consultar por", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pConsultarPor = new GridBagConstraints();
		gbc_pConsultarPor.fill = GridBagConstraints.BOTH;
		gbc_pConsultarPor.insets = new Insets(0, 0, 5, 5);
		gbc_pConsultarPor.gridx = 0;
		gbc_pConsultarPor.gridy = 0;
		panel.add(pConsultarPor, gbc_pConsultarPor);
		pConsultarPor.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pBuscar = new JPanel();
		GridBagConstraints gbc_pBuscar = new GridBagConstraints();
		gbc_pBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_pBuscar.fill = GridBagConstraints.BOTH;
		gbc_pBuscar.gridx = 1;
		gbc_pBuscar.gridy = 0;
		panel.add(pBuscar, gbc_pBuscar);
		pBuscar.setLayout(new BoxLayout(pBuscar, BoxLayout.Y_AXIS));
		
		JLabel lblTexto = new JLabel("Buscar:");
		lblTexto.setHorizontalAlignment(SwingConstants.LEFT);
		pBuscar.add(lblTexto);
		
		JPanel panel_3 = new JPanel();
		pBuscar.add(panel_3);
		
		tfTexto = new JTextField();
		panel_3.add(tfTexto);
		tfTexto.setHorizontalAlignment(SwingConstants.LEFT);
		tfTexto.setColumns(22);
		
		JPanel pBotoes = new JPanel();
		GridBagConstraints gbc_pBotoes = new GridBagConstraints();
		gbc_pBotoes.insets = new Insets(0, 0, 0, 5);
		gbc_pBotoes.fill = GridBagConstraints.BOTH;
		gbc_pBotoes.gridx = 2;
		gbc_pBotoes.gridy = 0;
		panel.add(pBotoes, gbc_pBotoes);
		pBotoes.setLayout(new GridLayout(0, 1, 0, 3));
		
		btConsultar = new JButton("Consultar");
		btConsultar.setHorizontalAlignment(SwingConstants.LEFT);
		btConsultar.setIcon(new ImageIcon(FrameGerenciar.class.getResource("/Imagens/checked.png")));
		btConsultar.setBackground(Color.WHITE);
		btConsultar.setMnemonic(KeyEvent.VK_C);
		btConsultar.setFocusPainted(false);
		pBotoes.add(btConsultar);
		
		btVisualizar = new JButton("Visualizar");
		btVisualizar.setHorizontalAlignment(SwingConstants.LEFT);
		btVisualizar.setIcon(new ImageIcon(FrameGerenciar.class.getResource("/Imagens/search.png")));
		btVisualizar.setBackground(Color.WHITE);
		btVisualizar.setMnemonic(KeyEvent.VK_V);
		btVisualizar.setFocusPainted(false);
		btVisualizar.setEnabled(false);
		pBotoes.add(btVisualizar);
		
		btEditar = new JButton("Editar");
		btEditar.setHorizontalAlignment(SwingConstants.LEFT);
		btEditar.setIcon(new ImageIcon(FrameGerenciar.class.getResource("/Imagens/edit.png")));
		btEditar.setBackground(Color.WHITE);
		btEditar.setMnemonic(KeyEvent.VK_E);
		btEditar.setFocusPainted(false);
		btEditar.setEnabled(false);
		pBotoes.add(btEditar);
		
		btExcluir = new JButton("Excluir");
		btExcluir.setHorizontalAlignment(SwingConstants.LEFT);
		btExcluir.setIcon(new ImageIcon(FrameGerenciar.class.getResource("/Imagens/delete.png")));
		btExcluir.setBackground(Color.WHITE);
		btExcluir.setMnemonic(KeyEvent.VK_X);
		btExcluir.setFocusPainted(false);
		btExcluir.setEnabled(false);
		pBotoes.add(btExcluir);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		panel_1.add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public ButtonGroup preencherOpcoesConsulta(String opcoes[])
	{
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rb = null;
		for(String rbTexto : opcoes)
		{
			rb = new JRadioButton(rbTexto);
			rb.setFocusPainted(false);
			rb.setActionCommand(rbTexto);
			pConsultarPor.add(rb);
			bg.add(rb);
		}
		if(rb != null)
			rb.setSelected(true);
		return bg;
	}
	
	public void desabilitarButtons() {
		table.clearSelection();
		btEditar.setEnabled(false);
		btExcluir.setEnabled(false);
	}
}
