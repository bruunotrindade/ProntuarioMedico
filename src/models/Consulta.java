package models;

public class Consulta {
	private int id;
	private String sintomas, obs, data_hora;
	private Paciente paciente;
	private Medico medico;
	
	public Consulta() {
		
	}

	public Consulta(int id, String sintomas, String obs, String data_hora, Paciente paciente, Medico medico) {
		this.id = id;
		this.sintomas = sintomas;
		this.obs = obs;
		this.data_hora = data_hora;
		this.paciente = paciente;
		this.medico = medico;
	}
	
	public Consulta(String sintomas, String obs, String data_hora, Paciente paciente, Medico medico) {
		this.sintomas = sintomas;
		this.obs = obs;
		this.data_hora = data_hora;
		this.paciente = paciente;
		this.medico = medico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getData_hora() {
		return data_hora;
	}

	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
}
