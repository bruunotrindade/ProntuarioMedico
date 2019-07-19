package tbmodel;

import java.util.ArrayList;
import java.util.List;

import model.Funcionario;
import model.Paciente;
import utils.Funcoes;

public class FuncionarioTableModel extends BasicTableModel 
{
	public FuncionarioTableModel(ArrayList<Funcionario> dados) 
	{
		super(new ArrayList<Object>(dados));
		this.columns = new String[] {"Código", "Matrícula", "Nome", "CPF", "Dt Nasc", "Função", "Ativo"};
	}

	public Object getValueAt(int rowIndex, int colIndex) 
	{
		Funcionario funcionario =  (Funcionario) dados.get(rowIndex);
		switch (colIndex) 
		{
			case 0:
		        return funcionario.getId();
			case 1:
				return funcionario.getMatricula();
			case 2:
				return funcionario.getNome();
			case 3:
				return funcionario.getCpf();
			case 4:
				return Funcoes.converterDataBR(funcionario.getDataNascimento());
			case 5:
				return funcionario.getFuncao();
			case 6:
				return funcionario.isAtivo();
		    default:
		        throw new IndexOutOfBoundsException("Coluna inválida!");
		}
	}

	public void setDados(ArrayList<Funcionario> dados) 
	{
		this.dados = new ArrayList<Object>(dados);
		this.fireTableDataChanged();
	}

}
