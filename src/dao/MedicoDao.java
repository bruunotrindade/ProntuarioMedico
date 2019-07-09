package dao;

import java.util.ArrayList;
import java.util.HashMap;

import model.Funcionario;
import model.Medico;
import model.Paciente;
import utils.Mysql;

public class MedicoDao extends Dao {

	public static boolean insert(Medico p) {
		if (p != null) {
			return mysql.query("INSERT INTO medicos VALUES (DEFAULT, '" + p.getCrm() + "','" + p.getEspecialidade() + "', '"
					+ p.getId() + "')");
		}
		return false;
	}

	public static boolean update(Medico p) {
		if (p != null) {

			return mysql.query("UPDATE medicos SET CRM='" + p.getCrm() + "', ESPECIALIDADE='" + p.getEspecialidade()
					+ "' WHERE ID=" + p.getId());
		}
		return false;
	}

	public static boolean delete(Medico p) {
		if (p != null) {
			return mysql.query("DELETE FROM medicos WHERE ID = " + p.getId());
		}
		return false;
	}

	public static ArrayList<Medico> getAll() {
		return getBy("1", "1");
	}
	
	public static Medico getMedico(int id)
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
	
	public static Medico getMedicoByFuncionario(Funcionario f)
	{
		if (mysql.query("SELECT * FROM medicos WHERE FUNCIONARIO_ID = '" + f.getId() + "'")) {
			HashMap<String, Object> r = mysql.fetch_assoc();
				
			return new Medico(f, (String) r.get("CRM"), (String) r.get("ESPECIALIDADE"));
		}
		return null;
	}

	public static ArrayList<Medico> getBy(String filtro, String valor) {
		ArrayList<Medico> ps = new ArrayList<Medico>();
		if (mysql.query("SELECT * FROM medicos WHERE " + filtro.toUpperCase() + " = '" + valor + "'")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();

			for (HashMap<String, Object> r : resultado) {
				
				Medico p = new Medico(FuncionarioDao.getFuncionario((int)r.get("FUNCIONARIO_ID")), (String) r.get("CRM"), (String) r.get("ESPECIALIDADE"));
				ps.add(p);
			}

			return ps;
		}
		return null;
	}
}
