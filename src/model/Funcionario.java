package model;

public class Funcionario {
	private int id, permissao;
	private String matricula, nome, cpf, senha, dataNascimento, funcao;
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
		this.setFuncao(funcao);
		this.cpf = cpf;
		this.senha = senha;
		this.dataNascimento = dt_nasc;
		this.ativo = ativo;
		this.permissao = permissao;
	}
	
	public Funcionario(String matricula, String nome, String cpf, String senha, String dt_nasc, String funcao,
			boolean ativo, int permissao) {
		this.matricula = matricula;
		this.setFuncao(funcao);
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.dataNascimento = dt_nasc;
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dt_nasc) {
		this.dataNascimento = dt_nasc;
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
}
