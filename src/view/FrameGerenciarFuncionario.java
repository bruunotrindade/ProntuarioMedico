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
import dao.PacienteDao;
import model.Funcionario;
import tbmodel.FuncionarioTableModel;
import tbmodel.PacienteTableModel;

public class FrameGerenciarFuncionario extends FrameGerenciar{
	
	protected FuncionarioTableModel tbModel;
	
	public FrameGerenciarFuncionario(FramePrincipal pai) {
		super(pai);
		
		String radioButtons[] = {"Código", "Matrícula", "Nome", "CPF", "Nascimento", "Funcao", "Desativos", "Todos"};
		ButtonGroup bg = preencherOpcoesConsulta(radioButtons);
		
		tbModel = new FuncionarioTableModel(FuncionarioDao.getAll());
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
				String busca = tfTexto.getText(), selected = bg.getSelection().getActionCommand();
				if(selected.equals("Todos"))
					tbModel.setDados(FuncionarioDao.getAll());
				else if(selected.equals("Código"))
					tbModel.setDados(FuncionarioDao.getBy("ID", busca));
				else if(selected.equals("Matrícula"))
					tbModel.setDados(FuncionarioDao.getBy("MATRICULA", busca));
				else if(selected.equals("Desativos"))
					tbModel.setDados(FuncionarioDao.getBy("ATIVO", "0"));
				else if(selected.equals("Nascimento"))
					tbModel.setDados(FuncionarioDao.getBy("DT_NASC", busca));
				else
					tbModel.setDados(FuncionarioDao.getBy(selected.toUpperCase(), busca));
			}
		});
		
		btEditar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int ind = table.getSelectedRow();
				Funcionario f = (Funcionario) tbModel.getValue(ind);
				new FrameCadastroFuncionario(FrameGerenciarFuncionario.this,f);
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
				new FrameCadastroFuncionario(FrameGerenciarFuncionario.this);
			}
		});
		
		btExcluir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int ind = table.getSelectedRow();
				Funcionario funcionario = (Funcionario) tbModel.getValue(ind);
				FuncionarioDao.delete(funcionario);
				tbModel.onRemove(ind);
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Gerenciamento de Funcionarios");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
}
