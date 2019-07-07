package dao;

import java.util.ArrayList;
import java.util.HashMap;

import model.Paciente;
import model.Pergunta;
import model.Resposta;
import utils.Mysql;

public class RespostaDao extends Dao {
	
	public static boolean insert(Resposta p) {
		if(p != null) {
			return mysql.query("INSERT INTO respostas VALUES (DEFAULT, '"+p.getConteudo()+"'," + p.getPergunta().getId()+ ","+p.getPaciente().getId()+")");	
		}
		return false;
	}
	
	public static boolean update(Resposta p) {
		if(p != null) {
			return mysql.query("UPDATE respostas SET CONTEUDO='"+p.getConteudo() +"', PERGUNTA_ID=" + p.getPergunta().getId() + 
					", PACIENTE_ID="+p.getPaciente().getId()+" WHERE ID=" + p.getId());	
		}
		return false;
	}
	
	public static boolean delete(Resposta p) {
		if(p != null) {
			return mysql.query("DELETE FROM respostas WHERE ID = " + p.getId());
		}
		return false;
	}
	
	public static ArrayList<Resposta> getAll(){
		return getBy("1", "1");
	}
	
	public static Resposta getResposta(int id)
	{
		try
		{
			return getBy("ID", Integer.toString(id)).get(0);
		}
		catch(NullPointerException npe)
		{
			return null;
		}
	}
	
	public static ArrayList<Resposta> getBy(String filtro, String valor){
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
