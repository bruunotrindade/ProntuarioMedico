package model;

public class Medico {
	private int id;
	private String crm, nome, cpf, senha, dt_nasc, especialidade;
	
	public Medico(int id, String crm, String nome, String cpf, String senha, String dt_nasc, String especialidade) {
		this.id = id;
		this.crm = crm;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.dt_nasc = dt_nasc;
		this.especialidade = especialidade;
	}
	
	public Medico(String crm, String nome, String cpf, String senha, String dt_nasc, String especialidade) {
		this.crm = crm;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.dt_nasc = dt_nasc;
		this.especialidade = especialidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(String dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	
}
