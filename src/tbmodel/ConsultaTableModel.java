package tbmodel;

import java.util.ArrayList;
import java.util.List;

import model.Consulta;
import model.Paciente;
import utils.Funcoes;

public class ConsultaTableModel extends BasicTableModel 
{
	public ConsultaTableModel(ArrayList<Consulta> dados) 
	{
		super(new ArrayList<Object>(dados));
		this.columns = new String[] {"Código", "Paciente", "Médico", "Data e Hora", "Sintomas"};
	}

	public Object getValueAt(int rowIndex, int colIndex) 
	{
		Consulta consulta = (Consulta) dados.get(rowIndex);
		switch (colIndex) 
		{
			case 0:
		        return consulta.getId();
			case 1:
				return consulta.getPaciente().getNome();
			case 2:
				return consulta.getMedico().getNome();
			case 3:
				return consulta.getData_hora().substring(0, consulta.getData_hora().length()-2);
			case 4:
				return consulta.getSintomas().replaceAll("\n", ", ");
		    default:
		        throw new IndexOutOfBoundsException("Coluna inválida!");
		}
	}

	public void setDados(ArrayList<Consulta> dados) 
	{
		this.dados = new ArrayList<Object>(dados);
		this.fireTableDataChanged();
	}
}
