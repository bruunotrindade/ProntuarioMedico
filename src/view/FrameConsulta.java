package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.border.TitledBorder;

import dao.ConsultaDao;
import dao.PacienteDao;
import dao.ProcedimentoDao;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import model.Procedimento;
import model.Consulta;
import model.Medico;
import model.Paciente;

public class FrameConsulta {

	private JFrame frmConsulta;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfNascimento;
	private JTextField tfDescricao;
	private FramePrincipal pai;

	class ProcedimentoGUI
	{
		JTextField tfNovo = new JTextField();
		JComboBox cbNovo = new JComboBox();
	}
	
	public FrameConsulta(FramePrincipal pai) {
		this.pai = pai;
		frmConsulta = new JFrame();
		frmConsulta.setTitle("Consulta");
		frmConsulta.setBounds(100, 100, 450, 300);
		frmConsulta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsulta.getContentPane().setLayout(new BoxLayout(frmConsulta.getContentPane(), BoxLayout.PAGE_AXIS));
		frmConsulta.setSize(500, 500);
		
		JPanel pnDados = new JPanel();
		pnDados.setBorder(new TitledBorder(null, "Dados pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmConsulta.getContentPane().add(pnDados);
		pnDados.setLayout(new BoxLayout(pnDados, BoxLayout.PAGE_AXIS));
		
		JPanel pn1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pn1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnDados.add(pn1);
		
		JLabel lblPaciente = new JLabel("Paciente:");
		pn1.add(lblPaciente);
		
		tfNome = new JTextField();
		pn1.add(tfNome);
		tfNome.setColumns(31);
		
		JPanel pn2 = new JPanel();
		FlowLayout fl_pn2 = (FlowLayout) pn2.getLayout();
		fl_pn2.setAlignment(FlowLayout.LEFT);
		pnDados.add(pn2);
		
		JPanel pn2_1 = new JPanel();
		FlowLayout fl_pn2_1 = (FlowLayout) pn2_1.getLayout();
		fl_pn2_1.setAlignment(FlowLayout.LEFT);
		pn2.add(pn2_1);
		
		JLabel lbCpf = new JLabel("CPF:");
		pn2_1.add(lbCpf);
		
		tfCpf = new JTextField();
		pn2_1.add(tfCpf);
		tfCpf.setColumns(10);
		
		JPanel pn2_2 = new JPanel();
		FlowLayout fl_pn2_2 = (FlowLayout) pn2_2.getLayout();
		fl_pn2_2.setAlignment(FlowLayout.LEFT);
		pn2.add(pn2_2);
		
		JLabel lbNascimento = new JLabel("Data Nascimento:");
		pn2_2.add(lbNascimento);
		
		tfNascimento = new JTextField();
		pn2_2.add(tfNascimento);
		tfNascimento.setColumns(10);
		
		JPanel pn3 = new JPanel();
		FlowLayout fl_pn3 = (FlowLayout) pn3.getLayout();
		fl_pn3.setAlignment(FlowLayout.LEFT);
		pnDados.add(pn3);
		
		JLabel lbSintomas = new JLabel("Sintomas:");
		pn3.add(lbSintomas);
		
		JTextArea taSintomas = new JTextArea();
		taSintomas.setRows(4);
		taSintomas.setColumns(30);
		pn3.add(taSintomas);
		
		JPanel pn4 = new JPanel();
		FlowLayout fl_pn4 = (FlowLayout) pn4.getLayout();
		fl_pn4.setAlignment(FlowLayout.LEFT);
		pnDados.add(pn4);
		
		JLabel lblObs = new JLabel("Obs.:");
		pn4.add(lblObs);
		
		JTextArea taObs = new JTextArea();
		taObs.setRows(4);
		taObs.setColumns(33);
		pn4.add(taObs);	
		
		
		JPanel pnProcedimentos = new JPanel();
		pnProcedimentos.setBorder(new TitledBorder(null, "Procedimentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//frmConsulta.getContentPane().add(pnProcedimentos);
		pnProcedimentos.setLayout(new BoxLayout(pnProcedimentos, BoxLayout.PAGE_AXIS));
		
		JScrollPane scpProced = new JScrollPane(pnProcedimentos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		pnDados.add(scpProced);

		JPanel pnProceds = new JPanel();
		pnProcedimentos.add(pnProceds);
		
		JLabel lbDescrio = new JLabel("Descrição:");
		pnProceds.add(lbDescrio);
		
		tfDescricao = new JTextField();

		pnProceds.add(tfDescricao);
		tfDescricao.setColumns(15);
		
		JLabel lbTipo = new JLabel("Tipo:");
		pnProceds.add(lbTipo);
		
		JComboBox cbTipo = new JComboBox();
		pnProceds.add(cbTipo);
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Remédio", "Exame"}));
		
		JLabel lbX = new JLabel("X");
		lbX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbX.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				//System.out.println(pnProcedimentos.getComponentCount());
				pnProcedimentos.remove(pnProcedimentos.getComponentCount()-1);
				//System.out.println(pnProcedimentos.getComponentCount());
				frmConsulta.validate();
				frmConsulta.repaint();
			}
		});
		pnProceds.add(lbX);
		
		JPanel pnButoes = new JPanel();
		pnDados.add(pnButoes);
		
		JButton btnSalvar = new JButton("Salvar");
		pnButoes.add(btnSalvar);
		
		JButton btNovo = new JButton("Novo Procedimento");
		pnButoes.add(btNovo);
		
		ArrayList<ProcedimentoGUI> procs = new ArrayList<ProcedimentoGUI>();
		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				//Criando a consulta
				Paciente paciente = PacienteDao.getBy("NOME", tfNome.getText()).get(0);
				Consulta consu = new Consulta(taSintomas.getText(), taObs.getText(), "", paciente, (Medico)pai.getUsuario());
				ConsultaDao.insert(consu);
				
				//Percorrendo os procedimentos
				for(ProcedimentoGUI p : procs)
				{
					Procedimento proced = new Procedimento(p.cbNovo.getSelectedItem().toString(), p.tfNovo.getText(), "", consu);
					ProcedimentoDao.insert(proced);
				}
			}
		});
		
		btNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel pnovo = new JPanel();
				JLabel lbNovo = new JLabel("Descrição:");

				ProcedimentoGUI p = new ProcedimentoGUI();
				pnovo.add(lbNovo);
	
				JTextField tfNovo = new JTextField();
				pnovo.add(tfNovo);
				p.tfNovo.setColumns(15);
				
				JLabel lbTipoNovo = new JLabel("Tipo:");
				pnovo.add(lbTipoNovo);
				
				JComboBox cbNovo = new JComboBox();
				pnovo.add(cbNovo);
				cbNovo.setModel(new DefaultComboBoxModel(new String[] {"Remédio", "Exame"}));
				
				JLabel lbXNovo = new JLabel("X");
				lbXNovo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lbXNovo.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						//System.out.println(pnProcedimentos.getComponentCount());
						pnProcedimentos.remove(pnProcedimentos.getComponentCount()-1);
						//System.out.println(pnProcedimentos.getComponentCount());
						frmConsulta.validate();
						frmConsulta.repaint();
					}
				});
				pnovo.add(lbXNovo);
				
				p.cbNovo = cbNovo;
				p.tfNovo = tfNovo;
				procs.add(p);
				
				pnProcedimentos.add(pnovo);
				frmConsulta.revalidate();
				frmConsulta.repaint();
			}
		});
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmConsulta.dispose();
				
			}
		});
		pnButoes.add(btSair);
		
		frmConsulta.setVisible(true);
	}

}
