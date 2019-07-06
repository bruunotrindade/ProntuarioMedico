package dao;

import java.util.ArrayList;
import java.util.HashMap;

import model.Medico;
import model.Pergunta;
import sql.Mysql;

public class PerguntaDao {
private Mysql mysql = new Mysql("localhost", "aluno", "aluno", "prontuario");
	
	public boolean insert(Pergunta p) {
		if(p != null) {
			return mysql.query("INSERT INTO perguntas VALUES ('"+p.getDesc()+"'," + p.getTipo()+ ",'"+p.getQuestionario()+"')");	
		}
		return false;
	}
	
	public boolean update(Pergunta p) {
		if(p != null) {
			return mysql.query("UPDATE perguntas SET DESCRICAO='"+p.getDesc() +"', TIPO=" + p.getTipo() + 
					", QUESTIONARIO='"+p.getQuestionario()+"' WHERE ID=" + p.getId());	
		}
		return false;
	}
	
	public boolean delete(Pergunta p) {
		if(p != null) {
			return mysql.query("DELETE FROM perguntas WHERE ID = " + p.getId());
		}
		return false;
	}
	
	public ArrayList<Pergunta> getAll(){
		ArrayList<Pergunta> ps = new ArrayList<Pergunta>();
		
		if(mysql.query("SELECT * FROM perguntas")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
			
			for(HashMap<String,Object> r : resultado) {
				Pergunta p = new Pergunta((int) r.get("ID"), (String) r.get("DESCRICAO"),(int) r.get("TIPO"),(String) r.get("QUESTIONARIO"));
				ps.add(p);
			}
			
			return ps;
		}
		return null;
	}
	
	public ArrayList<Pergunta> getBy(String filtro, String valor){
		ArrayList<Pergunta> ps = new ArrayList<Pergunta>();
		
		if(mysql.query("SELECT * FROM perguntas WHERE " + filtro.toUpperCase() + " = '" + valor + "'")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
			
			for(HashMap<String,Object> r : resultado) {
				Pergunta p = new Pergunta((int) r.get("ID"), (String) r.get("DESCRICAO"),(int) r.get("TIPO"),(String) r.get("QUESTIONARIO"));
				ps.add(p);
			}
			
			return ps;
		}
		return null;
	}
}
