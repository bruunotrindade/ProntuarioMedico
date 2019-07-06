package dao;

import java.util.ArrayList;
import java.util.HashMap;

import model.Funcionario;
import model.Medico;
import sql.Mysql;

public class MedicoDao {
private Mysql mysql = new Mysql("localhost", "aluno", "aluno", "prontuario");
	
	public boolean insert(Medico p) {
		if(p != null) {
			return mysql.query("INSERT INTO medicos VALUES ('"+p.getCrm()+"','" + p.getNome() + "','"+p.getCpf()+"','"+p.getSenha()+
					"','"+p.getDt_nasc()+"','"+p.getEspecialidade()+"')");	
		}
		return false;
	}
	
	public boolean update(Medico p) {
		if(p != null) {
			return mysql.query("UPDATE medicos SET CRM='"+p.getCrm() +"', NOME='" + p.getNome() + "', CPF='"+p.getCpf()+
					"', SENHA='"+p.getSenha()+"', DT_NASCIMENTO='"+p.getDt_nasc()+"', ESPECIALIDADE='"+p.getEspecialidade()+
					"' WHERE ID=" + p.getId());	
		}
		return false;
	}
	
	public boolean delete(Medico p) {
		if(p != null) {
			return mysql.query("DELETE FROM medicos WHERE ID = " + p.getId());
		}
		return false;
	}
	
	public ArrayList<Medico> getAll(){
		ArrayList<Medico> ps = new ArrayList<Medico>();
		
		if(mysql.query("SELECT * FROM medicos")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
			
			for(HashMap<String,Object> r : resultado) {
				Medico p = new Medico((int) r.get("ID"), (String) r.get("CRM"),(String) r.get("NOME"),(String) r.get("CPF"),
						(String) r.get("SENHA"), (String)r.get("DT_NASCIMENTO"),(String) r.get("ESPECIALIDADE"));
				ps.add(p);
			}
			
			return ps;
		}
		return null;
	}
	
	public ArrayList<Medico> getBy(String filtro, String valor){
		ArrayList<Medico> ps = new ArrayList<Medico>();
		
		if(mysql.query("SELECT * FROM medicos WHERE " + filtro.toUpperCase() + " = '" + valor + "'")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
			
			for(HashMap<String,Object> r : resultado) {
				Medico p = new Medico((int) r.get("ID"), (String) r.get("CRM"),(String) r.get("NOME"),(String) r.get("CPF"),
						(String) r.get("SENHA"), (String)r.get("DT_NASCIMENTO"),(String) r.get("ESPECIALIDADE"));
				ps.add(p);
			}
			
			return ps;
		}
		return null;
	}
}
