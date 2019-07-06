package models;

public class Resposta {
	private int id;
	private String conteudo;
	private Pergunta pergunta;
	private Paciente paciente;
	
	public Resposta() {
		
	}

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
}
