package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;

import dao.PacienteDao;
import model.Paciente;
import tbmodel.PacienteTableModel;
import utils.Funcoes;

public class FrameGerenciarPaciente extends FrameGerenciar 
{
	public FrameGerenciarPaciente(FramePrincipal pai)
	{
		super(pai);
		
		String radioButtons[] = {"Código", "Nome", "CPF", "Nascimento", "Cidade", "Bairro", "Fone", "Todos"};
		ButtonGroup bg = preencherOpcoesConsulta(radioButtons);
		
		PacienteTableModel tbModel = new PacienteTableModel(PacienteDao.getAll());
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
					tbModel.setDados(PacienteDao.getAll());
				else if(selected.equals("Código"))
					tbModel.setDados(PacienteDao.getBy("ID", busca));
				else if(selected.equals("Nascimento"))
					tbModel.setDados(PacienteDao.getBy("DT_NASC", busca));
				else
					tbModel.setDados(PacienteDao.getBy(selected.toUpperCase(), busca));
			}
		});
		
		btEditar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{	
				new FramePaciente(FrameGerenciarPaciente.this,(Paciente)tbModel.getDados().get(table.getSelectedRow()),1);
			}
		});
		
		btVisualizar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new FramePaciente(FrameGerenciarPaciente.this,(Paciente)tbModel.getDados().get(table.getSelectedRow()),3);
			}
		});
		
		btExcluir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new FramePaciente(FrameGerenciarPaciente.this,(Paciente)tbModel.getDados().get(table.getSelectedRow()),2);
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Gerenciamento de Pacientes");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
}
