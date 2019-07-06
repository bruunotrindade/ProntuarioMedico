package models;

public class Funcionario {
	private int id;
	private String matricula, nome, cpf, senha, dt_nasc, funcao;
	private boolean ativo, permissao;
	
	public Funcionario() {
		
	}

	public Funcionario(int id, String matricula, String nome, String cpf, String senha, String dt_nasc, String funcao,
			boolean ativo, boolean permissao) {
		super();
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
			boolean ativo, boolean permissao) {
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

	public boolean isPermissao() {
		return permissao;
	}

	public void setPermissao(boolean permissao) {
		this.permissao = permissao;
	}
	
	
}
