package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import dao.PerguntaDao;
import model.Pergunta;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class FrameQuestoesAnamnese extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<Pergunta> perguntas;

	class PerguntaGUI
	{
		JTextField tfDescricao = new JTextField();
		JComboBox cbTipo = new JComboBox(new String[]{"Escrita", "Sim/Não"});
	}
	
	public FrameQuestoesAnamnese() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblPerguntasExistentesNa = new JLabel("Perguntas da Anamnese");
		panel_1.add(lblPerguntasExistentesNa);
		lblPerguntasExistentesNa.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel.add(new JScrollPane(panel_2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
		
		ArrayList<PerguntaGUI> perguntasGUI = new ArrayList<PerguntaGUI>();
		
		ArrayList<Integer> rowHeights = new ArrayList<Integer>();
		rowHeights.add(24);
		perguntas = (ArrayList<Pergunta>) PerguntaDao.getBy("QUESTIONARIO", "ANAMNESE");
		for(int i = 0; i < perguntas.size(); i++)
		{
			rowHeights.add(24);
			perguntasGUI.add(new PerguntaGUI());
		}
		
		if(perguntas.size() == 0)
		{
			rowHeights.add(24);
			perguntasGUI.add(new PerguntaGUI());
		}
		
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {350, 120, 0};
		gbl_panel_2.rowHeights = buildIntArray(rowHeights);
		
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
		
		gerarPanelPerguntas();
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JButton btSalvar = new JButton("Salvar");
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
						novas.add(new Pergunta(descricao, tipo, "ANAMNESE"));
				}
				
				//Excluindo as perguntas antigas
				for(Pergunta pergunta : perguntas)
					PerguntaDao.delete(pergunta);
				
				//Inserindo as novas perguntas
				for(Pergunta pergunta : novas)
					PerguntaDao.insert(pergunta);
			}
		});
		panel_3.add(btSalvar);
		
		JButton btNovaPergunta = new JButton("Nova Pergunta");
		btNovaPergunta.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				PerguntaGUI p = new PerguntaGUI();
				perguntasGUI.add(p);
				
			}
		});
		panel_3.add(btNovaPergunta);
		
		setVisible(true);
	}

	private int[] buildIntArray(ArrayList<Integer> integers) 
	{
	    int[] ints = new int[integers.size()];
	    int i = 0;
	    for (Integer n : integers) {
	        ints[i++] = n;
	    }
	    return ints;
	}
	
	public void gerarPanelPerguntas()
	{
		for(PerguntaGUI p : perguntasGUI)
		{
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.BOTH;
			gbc_textField.insets = new Insets(0, 0, 0, 5);
			gbc_textField.gridx = 0;
			gbc_textField.gridy = 1;
			panel_2.add(p.tfDescricao, gbc_textField);
			p.tfDescricao.setColumns(10);
			
			JPanel panel_4 = new JPanel();
			GridBagConstraints gbc_panel_4 = new GridBagConstraints();
			gbc_panel_4.fill = GridBagConstraints.BOTH;
			gbc_panel_4.gridx = 1;
			gbc_panel_4.gridy = 1;
			panel_2.add(panel_4, gbc_panel_4);
			panel_4.setLayout(new BorderLayout(5, 0));
			
			panel_4.add(p.cbTipo, BorderLayout.CENTER);
			
			JLabel lblX = new JLabel("X");
			lblX.setFont(new Font("Dialog", Font.BOLD, 18));
			lblX.setForeground(Color.RED);
			panel_4.add(lblX, BorderLayout.EAST);
			
			lblX.addMouseListener(new MouseListener() 
			{
				public void mouseReleased(MouseEvent arg0) {}
				public void mousePressed(MouseEvent arg0) {}
				public void mouseExited(MouseEvent arg0) {}
				public void mouseEntered(MouseEvent arg0) {}
				public void mouseClicked(MouseEvent arg0) 
				{
					perguntasGUI.remove(p);
				}
			});
		}
	}
}
