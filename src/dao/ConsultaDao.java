package dao;

import java.util.ArrayList;
import java.util.HashMap;

import model.Consulta;
import model.Funcionario;
import sql.Mysql;

public class ConsultaDao {
private Mysql mysql = new Mysql("localhost", "aluno", "aluno", "prontuario");
	
	public boolean insert(Consulta p) {
		if(p != null) {
			return mysql.query("INSERT INTO consultas VALUES ('" + p.getSintomas() + "','"+p.getObs()+"','"+p.getData_hora()+
					"',"+p.getPaciente().getId()+","+p.getMedico().getId()+")");	
		}
		return false;
	}
	
	public boolean update(Consulta p) {
		if(p != null) {
			return mysql.query("UPDATE consultas SET SINTOMAS='"+p.getSintomas() +"', OBSERVACOES='" + p.getObs() +
					"', DATA_HORA='"+p.getData_hora()+"', PACIENTE_ID="+p.getPaciente().getId()+", MEDICO_ID='"+p.getMedico().getId()+
					" WHERE ID=" + p.getId());	
		}
		return false;
	}
	
	public boolean delete(Consulta p) {
		if(p != null) {
			return mysql.query("DELETE FROM consultas WHERE ID = " + p.getId());
		}
		return false;
	}
	
	public ArrayList<Consulta> getAll(){
		ArrayList<Consulta> ps = new ArrayList<Consulta>();
		
		if(mysql.query("SELECT * FROM consultas")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
			
			for(HashMap<String,Object> r : resultado) {
				Consulta p = new Consulta((int) r.get("ID"), (String) r.get("SINTOMAS"),(String) r.get("OBSERVACOES"),(String) r.get("DATA_HORA"),
						(int) r.get("PACIENTE_ID"), (int)r.get("MEDICO_ID"));
				ps.add(p);
			}
			
			return ps;
		}
		return null;
	}
	
	public ArrayList<Consulta> getBy(String filtro, String valor){
		ArrayList<Consulta> ps = new ArrayList<Consulta>();
		
		if(mysql.query("SELECT * FROM consultas WHERE " + filtro.toUpperCase() + " = '" + valor + "'")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
			
			for(HashMap<String,Object> r : resultado) {
				Consulta p = new Consulta((int) r.get("ID"), (String) r.get("SINTOMAS"),(String) r.get("OBSERVACOES"),(String) r.get("DATA_HORA"),
						(int) r.get("PACIENTE_ID"), (int)r.get("MEDICO_ID"));
				ps.add(p);
			}
			
			return ps;
		}
		return null;
	}
}
