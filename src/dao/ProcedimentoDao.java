package dao;

import java.util.ArrayList;
import java.util.HashMap;

import model.Consulta;
import model.Procedimento;
import utils.Mysql;

public class ProcedimentoDao extends Dao {
	
	public static boolean insert(Procedimento p) {
		if(p != null) {
			return mysql.query("INSERT INTO procedimentos VALUES (DEFAULT, '" + p.getTipo() + "','"+p.getDesc()+"','"+p.getData_hora()+
					"',"+p.getConsulta().getId()+")");	
		}
		return false;
	}
	
	public static boolean update(Procedimento p) {
		if(p != null) {
			return mysql.query("UPDATE procedimentos SET TIPO='"+p.getTipo() +"', DESCRICAO='" + p.getDesc() +
					"', DATA_HORA='"+p.getData_hora()+"', CONSULTA_ID="+p.getConsulta().getId()+" WHERE ID=" + p.getId());	
		}
		return false;
	}
	
	public static boolean delete(Procedimento p) {
		if(p != null) {
			return mysql.query("DELETE FROM prodecimentos WHERE ID = " + p.getId());
		}
		return false;
	}
	
	public static ArrayList<Procedimento> getAll(){
		return getBy("1", "1");
	}
	
	public static Procedimento getProcedimento(int id)
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
	
	public static ArrayList<Procedimento> getBy(String filtro, String valor){
		ArrayList<Procedimento> ps = new ArrayList<Procedimento>();
		
		if(mysql.query("SELECT * FROM procedimentos WHERE " + filtro.toUpperCase() + " = '" + valor + "'")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
			
			for(HashMap<String,Object> r : resultado) {
				Procedimento p = new Procedimento((int) r.get("ID"), (String) r.get("TIPO"),(String) r.get("DESCRICAO"),
						(String) r.get("DATA_HORA"),(int) r.get("CONSULTA_ID"));
				ps.add(p);
			}
			
			return ps;
		}
		return null;
	}
}
