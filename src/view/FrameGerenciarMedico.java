package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;

import dao.FuncionarioDao;
import dao.MedicoDao;
import dao.PacienteDao;
import model.Funcionario;
import model.Medico;
import tbmodel.FuncionarioTableModel;
import tbmodel.MedicoTableModel;
import tbmodel.PacienteTableModel;
import utils.Funcoes;

public class FrameGerenciarMedico extends FrameGerenciar{

	MedicoTableModel tbModel;
	
	public FrameGerenciarMedico(FramePrincipal pai) {
		super(pai);
		
		String radioButtons[] = {"Código", "CRM", "Matricula", "Nome", "CPF", "Nascimento", "Função", "Especialidade", "Desativados", "Todos"};
		ButtonGroup bg = preencherOpcoesConsulta(radioButtons);
		
		tbModel = new MedicoTableModel(MedicoDao.getAll());
		table.setModel(tbModel);
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(7).setMaxWidth(50);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e) 
			{
				if(table.getSelectedRow() >= 0) 
				{
					btEditar.setEnabled(true);
					btExcluir.setEnabled(true);
				}
				else 
				{
					btEditar.setEnabled(false);
					btExcluir.setEnabled(false);
				}
			}
		});
		
		btConsultar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				desabilitarButtons();
				String busca = tfTexto.getText(), selected = bg.getSelection().getActionCommand();
				if(selected.equals("Todos"))
					tbModel.setDados(MedicoDao.getAll());
				else if(selected.equals("Código"))
					tbModel.setDados(MedicoDao.getBy("ID", busca));
				else if(selected.equals("Matrícula"))
					tbModel.setDados(MedicoDao.getBy("MATRICULA", busca));
				else if(selected.equals("Desativados"))
					tbModel.setDados(MedicoDao.getBy("ATIVO", "0"));
				else if(selected.equals("Nascimento"))
					tbModel.setDados(MedicoDao.getBy("DT_NASC", Funcoes.converterDataEUA(busca)));
				else if(selected.equals("Função"))
					tbModel.setDados(MedicoDao.getBy("FUNCAO", busca));
				else
					tbModel.setDados(MedicoDao.getBy(selected.toUpperCase(), busca));
			}
		});
		
		btEditar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int ind = table.getSelectedRow();
				Medico f = (Medico) tbModel.getValue(ind);
				new FrameMedico(FrameGerenciarMedico.this, f, 1);
				desabilitarButtons();
			}
		});
		
		btVisualizar.setText("Novo");
		btVisualizar.setMnemonic(KeyEvent.VK_N);
		btVisualizar.setIcon(new ImageIcon(FrameGerenciar.class.getResource("/Imagens/novo.png")));
		btVisualizar.setEnabled(true);
		btVisualizar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new FrameMedico(FrameGerenciarMedico.this);
			}
		});
		
		btExcluir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int ind = table.getSelectedRow();
				Medico medico = (Medico) tbModel.getValue(ind);
				new FrameMedico(FrameGerenciarMedico.this, medico, 2);
				desabilitarButtons();
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Gerenciamento de Médicos");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
}
