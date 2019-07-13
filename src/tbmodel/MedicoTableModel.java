package tbmodel;

import java.util.ArrayList;
import java.util.List;

import model.Funcionario;
import model.Medico;
import model.Paciente;
import utils.Funcoes;

public class MedicoTableModel extends BasicTableModel 
{
	public MedicoTableModel(ArrayList<Medico> dados) 
	{
		super(new ArrayList<Object>(dados));
		this.columns = new String[] {"Código", "CRM", "Matricula", "Nome", "CPF", "Dt Nasc", "Função", "Especialidade", "Ativo"};
	}

	public Object getValueAt(int rowIndex, int colIndex) 
	{
		Medico medico =  (Medico) dados.get(rowIndex);
		switch (colIndex) 
		{
			case 0:
		        return medico.getId();
			case 1:
				return medico.getMatricula();
			case 2:
				return medico.getCrm();
			case 3:
				return medico.getNome();
			case 4:
				return medico.getCpf();
			case 5:
				return Funcoes.converterDataBR(medico.getDt_nasc());
			case 6:
				return medico.getFuncao();
			case 7:
				return medico.getEspecialidade();
			case 8:
				return medico.isAtivo();
		    default:
		        throw new IndexOutOfBoundsException("Coluna inválida!");
		}
	}

	public void setDados(ArrayList<Medico> dados) 
	{
		this.dados = new ArrayList<Object>(dados);
		this.fireTableDataChanged();
	}

}
