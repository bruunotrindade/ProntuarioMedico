package dao;

import java.util.ArrayList;
import java.util.HashMap;

import model.Paciente;
import utils.Mysql;

public class PacienteDao extends Dao {
	
	public static boolean insert(Paciente p) {
		if(p != null) {
			return mysql.query("INSERT INTO pacientes VALUES (DEFAULT, '" + p.getNome() + "','"+p.getCpf()+ "','"+p.getSexo()+"','"+p.getDt_nasc()+
					"','"+p.getEst_civil()+"','"+p.getEndereco()+"','"+p.getBairro()+"','"+p.getCidade()+
					"','"+p.getCep()+"','"+p.getUf()+"','"+p.getFone()+"','"+p.getEmail()+"','"+p.getProfissao()+"','"+(p.isObito()?'S':'N')+
					"','"+p.getObs()+"')");	
		}
		return false;
	}
	
	public static boolean update(Paciente p) {
		if(p != null) {
			return mysql.query("UPDATE pacientes SET NOME='" + p.getNome() + "', CPF='"+p.getCpf()+"', SEXO='"+p.getSexo()+"', DT_NASCIMENTO='"+p.getDt_nasc()+
					"', ESTADO_CIVIL='"+p.getEst_civil()+"', ENDERECO='"+p.getEndereco()+"', BAIRRO='"+p.getBairro()+
					"', CIDADE='"+p.getCidade()+"', CEP='"+p.getCep()+"', UF='"+p.getUf()+"', FONE='"+p.getFone()+"', EMAIL='"+p.getEmail()+
					"', PROFISSAO='"+p.getProfissao()+"', OBITO='"+ (p.isObito() ? 'S' : 'N') +"', OBS='"+p.getObs()+"' WHERE ID=" + p.getId());	
		}
		return false;
	}
	
	public static boolean delete(Paciente p) {
		if(p != null) {
			return mysql.query("DELETE FROM pacientes WHERE ID = " + p.getId());
		}
		return false;
	}
	
	public static ArrayList<Paciente> getAll(){
		return getBy("1", "1");
	}
	
	public static Paciente getPaciente(int id)
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
	
	public static ArrayList<Paciente> getBy(String filtro, String valor){
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		
		if(mysql.query("SELECT * FROM pacientes WHERE " + filtro.toUpperCase() + " = '" + valor + "'")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
			
			for(HashMap<String,Object> r : resultado) {
				char sexo = ((String) r.get("SEXO")).charAt(0);
				Paciente paciente = new Paciente((int) r.get("ID"), (String) r.get("NOME"), (String) r.get("CPF"),sexo, (String) r.get("DT_NASCIMENTO").toString(),
						(String) r.get("ESTADO_CIVIL"), (String) r.get("ENDERECO"), (String) r.get("BAIRRO"),
						(String) r.get("CIDADE"), (String) r.get("CEP"), (String) r.get("UF"), (String) r.get("FONE"), (String) r.get("EMAIL"),
						(String) r.get("PROFISSAO"), (boolean) r.get("OBITO").equals("S"), (String) r.get("OBS"));
				pacientes.add(paciente);
			}
			
			return pacientes;
		}
		return null;
	}
}
