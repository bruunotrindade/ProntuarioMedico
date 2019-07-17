package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import dao.PerguntaDao;
import model.Pergunta;
import utils.Funcoes;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

public class FrameQuestoesAnamnese extends JFrame 
{
	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<Pergunta> perguntas;
	private JPanel panel = new JPanel();
	private JScrollPane scPerguntas;
	private ArrayList<PerguntaGUI> perguntasGUI = new ArrayList<PerguntaGUI>();
	private FramePrincipal pai;
	
	class PerguntaGUI
	{
		JTextField tfDescricao = new JTextField();
		JComboBox cbTipo = new JComboBox(new String[]{"Escrita", "Sim/Não"});
		JLabel lbX = new JLabel("X");
	}
	
	public FrameQuestoesAnamnese(FramePrincipal pai) 
	{
		this.pai = pai;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 532, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		JLabel lblPerguntasExistentesNa = new JLabel("Perguntas da Anamnese");
		panel_1.add(lblPerguntasExistentesNa);
		panel.add(panel_1, BorderLayout.NORTH);
		
		lblPerguntasExistentesNa.setHorizontalAlignment(SwingConstants.CENTER);

		//Criando as perguntas que já existem
		perguntas = (ArrayList<Pergunta>) PerguntaDao.getBy("QUESTIONARIO", "A");
		for(Pergunta p : perguntas)
		{
			PerguntaGUI pGUI = new PerguntaGUI();
			pGUI.cbTipo.setSelectedIndex(p.getTipo());
			pGUI.tfDescricao.setText(p.getDesc());
			perguntasGUI.add(pGUI);
		}
		
		gerarPanelPerguntas();
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.setForeground(new Color(255, 255, 255));
		btSalvar.setBackground(new Color(60, 179, 113));
		btSalvar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/check.png")));
		btSalvar.setFocusPainted(false);
		btSalvar.setMnemonic(KeyEvent.VK_S);
		btSalvar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				ArrayList<Pergunta> novas = new ArrayList<Pergunta>();
				for(PerguntaGUI p : perguntasGUI)
				{
					String descricao = p.tfDescricao.getText();
					int tipo = p.cbTipo.getSelectedIndex();
					if(descricao.length() > 0)
						novas.add(new Pergunta(descricao, tipo, "A"));
				}
				
				//Excluindo as perguntas antigas
				for(Pergunta pergunta : perguntas)
					PerguntaDao.delete(pergunta);
				
				//Inserindo as novas perguntas
				for(Pergunta pergunta : novas)
					PerguntaDao.insert(pergunta);
				
				Funcoes.mostrarMensagemSucesso("Perguntas de Anamnese atualizadas com sucesso!");
				FrameQuestoesAnamnese.this.dispose();
			}
		});
		panel_3.add(btSalvar);
		
		JButton btNovaPergunta = new JButton("Nova Pergunta");
		btNovaPergunta.setForeground(new Color(255, 255, 255));
		btNovaPergunta.setBackground(new Color(55, 140, 65));
		btNovaPergunta.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagens/plus.png")));
		btNovaPergunta.setFocusPainted(false);
		btNovaPergunta.setMnemonic(KeyEvent.VK_N);
		btNovaPergunta.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				PerguntaGUI p = new PerguntaGUI();
				perguntasGUI.add(p);
				gerarPanelPerguntas();
			}
		});
		panel_3.add(btNovaPergunta);
		
		setTitle("Questões da Anamnese");
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void gerarPanelPerguntas()
	{
		if(perguntasGUI.size() == 0)
			perguntasGUI.add(new PerguntaGUI());
		
		JPanel panel_2 = new JPanel();
		
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {350, 120, 0};
		gbl_panel_2.rowHeights = new int[] {26};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.fill = GridBagConstraints.BOTH;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 0;
		gbc_lblDescrio.gridy = 0;
		panel_2.add(lblDescrio, gbc_lblDescrio);
		
		JLabel lbTipo = new JLabel("Tipo");
		lbTipo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lbTipo = new GridBagConstraints();
		gbc_lbTipo.fill = GridBagConstraints.BOTH;
		gbc_lbTipo.insets = new Insets(0, 0, 5, 0);
		gbc_lbTipo.gridx = 1;
		gbc_lbTipo.gridy = 0;
		panel_2.add(lbTipo, gbc_lbTipo);
		
		int index = 1;
		for(PerguntaGUI p : perguntasGUI)
		{
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.BOTH;
			gbc_textField.insets = new Insets(0, 0, 0, 5);
			gbc_textField.gridx = 0;
			gbc_textField.gridy = index;
			panel_2.add(p.tfDescricao, gbc_textField);
			p.tfDescricao.setColumns(10);
			
			JPanel panel_4 = new JPanel();
			GridBagConstraints gbc_panel_4 = new GridBagConstraints();
			gbc_panel_4.fill = GridBagConstraints.BOTH;
			gbc_panel_4.gridx = 1;
			gbc_panel_4.gridy = index;
			panel_2.add(panel_4, gbc_panel_4);
			panel_4.setLayout(new BorderLayout(5, 0));
			
			panel_4.add(p.cbTipo, BorderLayout.CENTER);
			
			p.lbX.setFont(new Font("Dialog", Font.BOLD, 18));
			p.lbX.setForeground(Color.RED);
			p.lbX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			panel_4.add(p.lbX, BorderLayout.EAST);
			
			p.lbX.addMouseListener(new MouseListener() 
			{
				public void mouseReleased(MouseEvent arg0) {}
				public void mousePressed(MouseEvent arg0) {}
				public void mouseExited(MouseEvent arg0) {}
				public void mouseEntered(MouseEvent arg0) {}
				public void mouseClicked(MouseEvent arg0) 
				{
					for(PerguntaGUI pg : perguntasGUI)
					{
						if(arg0.getSource() == pg.lbX)
						{
							perguntasGUI.remove(pg);
							gerarPanelPerguntas();
							break;
						}
					}
				}
			});
			index += 1;
		}
		try 
		{
			contentPane.remove(scPerguntas);
		}
		catch(NullPointerException npe) {}
		JPanel panelSC = new JPanel();
		panelSC.add(panel_2);
		scPerguntas = new JScrollPane(panelSC, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		contentPane.add(scPerguntas, BorderLayout.CENTER);
		FrameQuestoesAnamnese.this.revalidate();
		FrameQuestoesAnamnese.this.repaint();
	}

}
