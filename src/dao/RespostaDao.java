package dao;

import java.util.ArrayList;
import java.util.HashMap;

import model.Pergunta;
import model.Resposta;
import sql.Mysql;

public class RespostaDao {
private Mysql mysql = new Mysql("localhost", "aluno", "aluno", "prontuario");
	
	public boolean insert(Resposta p) {
		if(p != null) {
			return mysql.query("INSERT INTO respostas VALUES ('"+p.getConteudo()+"'," + p.getPergunta().getId()+ ","+p.getPaciente().getId()+")");	
		}
		return false;
	}
	
	public boolean update(Resposta p) {
		if(p != null) {
			return mysql.query("UPDATE respostas SET CONTEUDO='"+p.getConteudo() +"', PERGUNTA_ID=" + p.getPergunta().getId() + 
					", PACIENTE_ID="+p.getPaciente().getId()+" WHERE ID=" + p.getId());	
		}
		return false;
	}
	
	public boolean delete(Resposta p) {
		if(p != null) {
			return mysql.query("DELETE FROM respostas WHERE ID = " + p.getId());
		}
		return false;
	}
	
	public ArrayList<Resposta> getAll(){
		ArrayList<Resposta> ps = new ArrayList<Resposta>();
		
		if(mysql.query("SELECT * FROM respostas")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
			
			for(HashMap<String,Object> r : resultado) {
				Resposta p = new Resposta((int) r.get("ID"), (String) r.get("CONTEUDO"),(int) r.get("PERGUNTA_ID"),(int) r.get("PACIENTE_ID"));
				ps.add(p);
			}
			
			return ps;
		}
		return null;
	}
	
	public ArrayList<Resposta> getBy(String filtro, String valor){
		ArrayList<Resposta> ps = new ArrayList<Resposta>();
		
		if(mysql.query("SELECT * FROM respostas WHERE " + filtro.toUpperCase() + " = '" + valor + "'")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
			
			for(HashMap<String,Object> r : resultado) {
				Resposta p = new Resposta((int) r.get("ID"), (String) r.get("CONTEUDO"),(int) r.get("PERGUNTA_ID"),(int) r.get("PACIENTE_ID"));
				ps.add(p);
			}
			
			return ps;
		}
		return null;
	}
}
