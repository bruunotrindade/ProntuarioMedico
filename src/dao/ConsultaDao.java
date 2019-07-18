package dao;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import model.Consulta;
import model.Funcionario;
import model.Paciente;
import utils.Mysql;

public class ConsultaDao extends Dao {

	public static boolean insert(Consulta p) {
		if(p != null) {
			boolean query = mysql.query("INSERT INTO consultas VALUES (DEFAULT, '" + p.getSintomas() + "','"+p.getObs()+"',"+(p.getData_hora().length() != 0 ? "'"+p.getData_hora()+"'":"NOW()")+
					","+p.getPaciente().getId()+","+p.getMedico().getIdMedico()+")");
			
			if(query)
			{
				mysql.query("SELECT MAX(ID) AS ID FROM consultas");
				HashMap<String, Object> result = mysql.fetch_assoc();
				int maxId = (int)result.get("ID");
				p.setId(maxId);
			}
			return query;	
		}
		return false;
	}
	
	public static boolean update(Consulta p) {
		if(p != null) {
			return mysql.query("UPDATE consultas SET SINTOMAS='"+p.getSintomas() +"', OBSERVACOES='" + p.getObs() +
					"', PACIENTE_ID="+p.getPaciente().getId()+", MEDICO_ID="+p.getMedico().getIdMedico()+
					" WHERE ID=" + p.getId());	
		}
		return false;
	}
	
	public static boolean delete(Consulta p) {
		if(p != null) {
			return mysql.query("DELETE FROM consultas WHERE ID = " + p.getId());
		}
		return false;
	}
	
	public static ArrayList<Consulta> getAll(){
		return getBy("1", "1");
	}
	
	public static Consulta getConsulta(int id)
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
	
	public static ArrayList<Consulta> getBy(String filtro, String valor){
		ArrayList<Consulta> ps = new ArrayList<Consulta>();
		
		if(mysql.query("SELECT * FROM consultas WHERE " + filtro.toUpperCase() + " = '" + valor + "'")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
			
			for(HashMap<String,Object> r : resultado) {
				Consulta p = new Consulta((int) r.get("ID"), (String) r.get("SINTOMAS"),(String) r.get("OBSERVACOES"),(String) r.get("DATA_HORA").toString(),
						PacienteDao.getPaciente((int)r.get("PACIENTE_ID")), MedicoDao.getMedico((int)r.get("MEDICO_ID")));
				ps.add(p);
			}
			
			return ps;
		}
		return null;
	}
}
