package model;

public class Medico extends Funcionario {
	
	private String crm, especialidade;
	private int idMedico;
	
	public Medico(int id, String matricula, int idMedico, String nome, String cpf, String senha, String dt_nasc, String funcao,
			boolean ativo, int permissao, String crm, String especialidade) {
		super(id, matricula, nome, cpf, senha, dt_nasc, funcao, ativo, permissao);
		this.crm = crm;
		this.especialidade = especialidade;
		this.idMedico = idMedico;
		// TODO Auto-generated constructor stub
	}
	
	public Medico(String matricula, int idMedico, String nome, String cpf, String senha, String dt_nasc, String funcao,
			boolean ativo, int permissao, String crm, String especialidade) {
		super(matricula, nome, cpf, senha, dt_nasc, funcao, ativo, permissao);
		this.crm = crm;
		this.especialidade = especialidade;
		this.idMedico = idMedico;
		// TODO Auto-generated constructor stub
	}
	
	public Medico(Funcionario f, int idMedico, String crm, String especialidade) {
		super(f.getId(), f.getMatricula(), f.getNome(), f.getCpf(), f.getSenha(), f.getDt_nasc(), f.getFuncao(), f.isAtivo(), f.getPermissao());
		this.crm = crm;
		this.especialidade = especialidade;
		this.idMedico = idMedico;
		// TODO Auto-generated constructor stub
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
}
