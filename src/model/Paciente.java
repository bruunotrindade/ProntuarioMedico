package model;

public class Paciente {
	private int id;
	private String nome, cpf, dt_nasc, est_civil, endereco, bairro, cidade, cep, uf, fone, email, profissao, obs;
	private char sexo;
	private boolean obito;
	
	public Paciente(int id, String nome, String cpf,char sexo, String dt_nasc, String est_civil, String endereco,
			String bairro, String cidade, String cep, String uf, String fone, String email, String profissao,
			boolean obito, String obs) 
	{
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dt_nasc = dt_nasc;
		this.est_civil = est_civil;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.uf = uf;
		this.fone = fone;
		this.email = email;
		this.profissao = profissao;
		this.obs = obs;
		this.obito = obito;
		this.sexo=sexo;
	}

	public Paciente(String nome, String cpf,char sexo, String dt_nasc, String est_civil, String endereco,
			String bairro, String cidade, String cep, String uf, String fone, String email, String profissao,
			String obs, boolean obito) 
	{
		this.nome = nome;
		this.cpf = cpf;
		this.dt_nasc = dt_nasc;
		this.est_civil = est_civil;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.uf = uf;
		this.fone = fone;
		this.email = email;
		this.profissao = profissao;
		this.obs = obs;
		this.obito = obito;
		this.sexo=sexo;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDataNascimento() {
		return dt_nasc;
	}

	public void setDataNascimento(String dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public String getEstadoCivil() {
		return est_civil;
	}

	public void setEstadoCivil(String est_civil) {
		this.est_civil = est_civil;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public boolean isObito() {
		return obito;
	}

	public void setObito(boolean obito) {
		this.obito = obito;
	}


	
}
