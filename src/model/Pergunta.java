package models;

public class Pergunta {
	private int id, tipo;
	private String desc, questionario;
	
	public Pergunta() {
		
	}

	public Pergunta(int id, String desc, int tipo,  String questionario) {
		this.id = id;
		this.tipo = tipo;
		this.desc = desc;
		this.questionario = questionario;
	}
	
	public Pergunta(String desc, int tipo,  String questionario) {
		this.tipo = tipo;
		this.desc = desc;
		this.questionario = questionario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getQuestionario() {
		return questionario;
	}

	public void setQuestionario(String questionario) {
		this.questionario = questionario;
	}
	
	
}
