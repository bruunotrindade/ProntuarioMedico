package dao;

import java.util.ArrayList;
import java.util.HashMap;

import model.Funcionario;
import model.Paciente;
import sql.Mysql;

public class FuncionarioDao {
private Mysql mysql = new Mysql("localhost", "aluno", "aluno", "prontuario");
	
	public boolean insert(Funcionario p) {
		if(p != null) {
			return mysql.query("INSERT INTO funcionarios VALUES ('"+p.getMatricula()+"','" + p.getNome() + "','"+p.getCpf()+"','"+p.getSenha()+
					"','"+p.getDt_nasc()+"','"+p.getFuncao()+"','"+p.isAtivo()+"',"+p.getPermissao()+")");	
		}
		return false;
	}
	
	public boolean update(Funcionario p) {
		if(p != null) {
			return mysql.query("UPDATE funcionarios SET MATRICULA='"+p.getMatricula() +"', NOME='" + p.getNome() + "', CPF='"+p.getCpf()+
					"', SENHA='"+p.getSenha()+"', DT_NASCIMENTO='"+p.getDt_nasc()+"', FUNCAO='"+p.getFuncao()+
					"', ATIVO='"+p.isAtivo()+"', PERMISSAO="+p.getPermissao()+" WHERE ID=" + p.getId());	
		}
		return false;
	}
	
	public boolean delete(Funcionario p) {
		if(p != null) {
			return mysql.query("DELETE FROM funcionarios WHERE ID = " + p.getId());
		}
		return false;
	}
	
	public ArrayList<Funcionario> getAll(){
		ArrayList<Funcionario> ps = new ArrayList<Funcionario>();
		
		if(mysql.query("SELECT * FROM funcionarios")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
			
			for(HashMap<String,Object> r : resultado) {
				Funcionario p = new Funcionario((int) r.get("ID"), (String) r.get("MATRICULA"),(String) r.get("NOME"),(String) r.get("CPF"),
						(String) r.get("SENHA"), (String)r.get("DT_NASCIMENTO"),(String) r.get("FUNCAO"),(boolean) r.get("ATIVO"),
						(int) r.get("PERMISSAO"));
				ps.add(p);
			}
			
			return ps;
		}
		return null;
	}
	
	public ArrayList<Funcionario> getBy(String filtro, String valor){
		ArrayList<Funcionario> ps = new ArrayList<Funcionario>();
		
		if(mysql.query("SELECT * FROM funcionarios WHERE " + filtro.toUpperCase() + " = '" + valor + "'")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
			
			for(HashMap<String,Object> r : resultado) {
				Funcionario p = new Funcionario((int) r.get("ID"), (String) r.get("MATRICULA"),(String) r.get("NOME"),(String) r.get("CPF"),
						(String) r.get("SENHA"), (String)r.get("DT_NASCIMENTO"),(String) r.get("FUNCAO"),(boolean) r.get("ATIVO"),
						(int) r.get("PERMISSAO"));
				ps.add(p);
			}
			
			return ps;
		}
		return null;
	}
}
