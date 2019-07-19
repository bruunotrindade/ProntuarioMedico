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
	
	public static boolean delete(int paciente) {
		return mysql.query("DELETE FROM respostas WHERE PACIENTE_ID = " + paciente);
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
				Resposta p = new Resposta((int) r.get("ID"), (String) r.get("CONTEUDO"), PerguntaDao.getPergunta((int) r.get("PERGUNTA_ID")), PacienteDao.getPaciente((int) r.get("PACIENTE_ID")));
				ps.add(p);
			}
			
			return ps;
		}
		return null;
	}
	
	public static ArrayList<Resposta> getByPaciente(Paciente p, String tipo){
		if(p != null)
		{
			ArrayList<Resposta> ps = new ArrayList<Resposta>();
			
			if(mysql.query("SELECT r.ID R_ID, r.CONTEUDO R_CONTEUDO, p.ID P_ID, p.DESCRICAO P_DESCRICAO, p.TIPO P_TIPO FROM respostas r, perguntas p WHERE r.PERGUNTA_ID = p.ID AND p.QUESTIONARIO='"+tipo+"' AND r.PACIENTE_ID="+p.getId()+" ORDER BY r.PERGUNTA_ID ASC")) {
				ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
				for(HashMap<String,Object> r : resultado) {
					
					Resposta res = new Resposta((int) r.get("R_ID"), (String) r.get("R_CONTEUDO"), new Pergunta((int)r.get("P_ID"), (String)r.get("P_DESCRICAO"), (int)r.get("P_TIPO"), tipo), p);
					ps.add(res);
				}
				
				return ps;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		Paciente p = PacienteDao.getPaciente(3);
		getByPaciente(p, "H");
	}
}

