package model;

public class Resposta {
	private int id;
	private String conteudo;
	private Pergunta pergunta;
	private Paciente paciente;
	
	public Resposta(int id, String conteudo, Pergunta pergunta, Paciente paciente) {
		this.id = id;
		this.conteudo = conteudo;
		this.pergunta = pergunta;
		this.paciente = paciente;
	}
	
	public Resposta(String conteudo, Pergunta pergunta, Paciente paciente) {
		this.conteudo = conteudo;
		this.pergunta = pergunta;
		this.paciente = paciente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
