package models;

public class Paciente {
	private int id;
	private String nome, cpf, dt_nasc, est_civil, conjuge, endereco, bairro, cidade, cep, uf, fone, email, profissao, obs;
	private boolean obito;
	
	public Paciente() {
		
	}
	
	public Paciente(int id, String nome, String cpf, String dt_nasc, String est_civil, String conjuge, String endereco,
			String bairro, String cidade, String cep, String uf, String fone, String email, String profissao,
			String obs, boolean obito) 
	{
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dt_nasc = dt_nasc;
		this.est_civil = est_civil;
		this.conjuge = conjuge;
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
	}

	public Paciente(String nome, String cpf, String dt_nasc, String est_civil, String conjuge, String endereco,
			String bairro, String cidade, String cep, String uf, String fone, String email, String profissao,
			String obs, boolean obito) 
	{
		this.nome = nome;
		this.cpf = cpf;
		this.dt_nasc = dt_nasc;
		this.est_civil = est_civil;
		this.conjuge = conjuge;
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

	public String getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(String dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public String getEst_civil() {
		return est_civil;
	}

	public void setEst_civil(String est_civil) {
		this.est_civil = est_civil;
	}

	public String getConjuge() {
		return conjuge;
	}

	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
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
