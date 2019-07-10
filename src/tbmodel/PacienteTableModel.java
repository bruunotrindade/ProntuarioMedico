package tbmodel;

import java.util.ArrayList;
import java.util.List;

import model.Paciente;
import utils.Funcoes;

public class PacienteTableModel extends BasicTableModel 
{
	public PacienteTableModel(ArrayList<Paciente> dados) 
	{
		super(new ArrayList<Object>(dados));
		this.columns = new String[] {"Código", "Nome", "CPF", "Endereço", "Bairro", "Cidade", "Dt Nasc", "Profissão"};
	}

	public Object getValueAt(int rowIndex, int colIndex) 
	{
		Paciente paciente =  (Paciente) dados.get(rowIndex);
		switch (colIndex) 
		{
			case 0:
		        return paciente.getId();
			case 1:
				return paciente.getNome();
			case 2:
				return paciente.getCpf();
			case 3:
				return paciente.getEndereco();
			case 4:
				return paciente.getBairro();
			case 5:
				return paciente.getCidade();
			case 6:
				return Funcoes.converterDataBR(paciente.getDt_nasc());
			case 7:
				return paciente.getProfissao();
		    default:
		        throw new IndexOutOfBoundsException("Coluna inválida!");
		}
	}

	public void setDados(ArrayList<Paciente> dados) 
	{
		this.dados = new ArrayList<Object>(dados);
		this.fireTableDataChanged();
	}

}
