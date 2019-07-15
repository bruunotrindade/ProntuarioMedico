package model;

public class Procedimento {
	private int id;
	private String tipo, desc, data_hora;
	private Consulta consulta;
	
	public Procedimento(int id, String tipo, String desc, String data_hora, Consulta consulta) {
		this.id = id;
		this.tipo = tipo;
		this.desc = desc;
		this.data_hora = data_hora;
		this.consulta = consulta;
	}
	
	public Procedimento(String tipo, String desc, String data_hora, Consulta consulta) {
		this.tipo = tipo;
		this.desc = desc;
		this.data_hora = data_hora;
		this.consulta = consulta;
	}

	public Procedimento(int id2, String tipo2, String desc2, String data_hora2, int i) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getData_hora() {
		return data_hora;
	}

	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
	
}
