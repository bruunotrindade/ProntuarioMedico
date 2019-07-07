package dao;

import java.util.ArrayList;
import java.util.HashMap;

import model.Medico;
import model.Paciente;
import model.Pergunta;
import utils.Mysql;

public class PerguntaDao extends Dao {
	
	public static boolean insert(Pergunta p) {
		if(p != null) {
			return mysql.query("INSERT INTO perguntas VALUES (DEFAULT, '"+p.getDesc()+"'," + p.getTipo()+ ",'"+p.getQuestionario()+"')");	
		}
		return false;
	}
	
	public static boolean update(Pergunta p) {
		if(p != null) {
			return mysql.query("UPDATE perguntas SET DESCRICAO='"+p.getDesc() +"', TIPO=" + p.getTipo() + 
					", QUESTIONARIO='"+p.getQuestionario()+"' WHERE ID=" + p.getId());	
		}
		return false;
	}
	
	public static boolean delete(Pergunta p) {
		if(p != null) {
			return mysql.query("DELETE FROM perguntas WHERE ID = " + p.getId());
		}
		return false;
	}
	
	public static ArrayList<Pergunta> getAll(){
		return getBy("1", "1");
	}
	
	public static Pergunta getPergunta(int id)
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
	
	public static ArrayList<Pergunta> getBy(String filtro, String valor){
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
