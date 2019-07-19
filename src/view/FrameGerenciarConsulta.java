package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;

import dao.ConsultaDao;
import dao.PacienteDao;
import model.Consulta;
import tbmodel.ConsultaTableModel;
import tbmodel.PacienteTableModel;
import utils.Funcoes;

public class FrameGerenciarConsulta extends FrameGerenciar 
{
	public FrameGerenciarConsulta(FramePrincipal pai)
	{
		super(pai);
		
		String radioButtons[] = {"Código", "Paciente", "Médico", "Data", "Sintomas", "Todos"};
		ButtonGroup bg = preencherOpcoesConsulta(radioButtons);
		
		ConsultaTableModel tbModel = new ConsultaTableModel(ConsultaDao.getAll());
		table.setModel(tbModel);
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e) 
			{
				if(table.getSelectedRow() >= 0) 
				{
					btEditar.setEnabled(true);
					btExcluir.setEnabled(true);
					btVisualizar.setEnabled(true);
				}
				else 
				{
					btEditar.setEnabled(false);
					btExcluir.setEnabled(false);
					btVisualizar.setEnabled(false);
				}
			}
		});
		
		btConsultar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String busca = tfTexto.getText(), selected = bg.getSelection().getActionCommand();
				if(selected.equals("Todos"))
					tbModel.setDados(ConsultaDao.getAll());
				else if(selected.equals("Código"))
					tbModel.setDados(ConsultaDao.getBy("ID", busca));
				else if(selected.equals("Paciente"))
					tbModel.setDados(ConsultaDao.getBy("PACIENTE_ID", busca));
				else if(selected.equals("Data"))
					tbModel.setDados(ConsultaDao.getBy("DATA_HORA", busca));
				else
					tbModel.setDados(ConsultaDao.getBy(selected.toUpperCase(), busca));
			}
		});
		
		btEditar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new FrameConsulta(FrameGerenciarConsulta.this, (Consulta)(tbModel.getDados().get(table.getSelectedRow())), 1);
			}
		});
		
		btVisualizar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new FrameConsulta(FrameGerenciarConsulta.this, (Consulta)(tbModel.getDados().get(table.getSelectedRow())), 0);
			}
		});
		
		btExcluir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new FrameConsulta(FrameGerenciarConsulta.this, (Consulta)(tbModel.getDados().get(table.getSelectedRow())), 2);
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Gerenciamento de Consultas");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args)
	{
		new FrameGerenciarConsulta(null);
	}
}
