package model;

public class Funcionario {
	private int id, permissao;
	private String matricula, nome, cpf, senha, dt_nasc, funcao;
	private boolean ativo;
	
	/*
	 * Permissão:
	 * 1 = Funcionário comum
	 * 2 = Médico
	 * 3 = Administrador
	 * */
	
	public Funcionario(int id, String matricula, String nome, String cpf, String senha, String dt_nasc, String funcao,
			boolean ativo, int permissao) {
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.dt_nasc = dt_nasc;
		this.funcao = funcao;
		this.ativo = ativo;
		this.permissao = permissao;
	}
	
	public Funcionario(String matricula, String nome, String cpf, String senha, String dt_nasc, String funcao,
			boolean ativo, int permissao) {
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.dt_nasc = dt_nasc;
		this.funcao = funcao;
		this.ativo = ativo;
		this.permissao = permissao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getPermissao() {
		return permissao;
	}

	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}
	
	
}
