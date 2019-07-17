package dao;

import java.util.ArrayList;
import java.util.HashMap;

import model.Funcionario;
import model.Paciente;
import utils.Mysql;

public class FuncionarioDao extends Dao {
	
	public static boolean insert(Funcionario p) {
		if(p != null) {
			return mysql.query("INSERT INTO funcionarios VALUES (DEFAULT, '"+p.getMatricula()+"','" + p.getNome() + "','"+p.getCpf()+"','"+p.getSenha()+
					"','"+p.getDt_nasc()+"','"+p.getFuncao()+"','"+(p.isAtivo() ? 'S':'N')+"',"+p.getPermissao()+")");	
		}
		return false;
	}
	
	public static boolean update(Funcionario p) {
		if(p != null) {
			return mysql.query("UPDATE funcionarios SET MATRICULA='"+p.getMatricula() +"', NOME='" + p.getNome() + "', CPF='"+p.getCpf()+
					"', SENHA='"+p.getSenha()+"', DT_NASCIMENTO='"+p.getDt_nasc()+"', FUNCAO='"+p.getFuncao()+
					"', ATIVO='"+ (p.isAtivo() ? "S" : "N") + "', PERMISSAO="+p.getPermissao()+" WHERE ID=" + p.getId());	
		}
		return false;
	}
	
	public static boolean delete(Funcionario p) {
		if(p != null) {
			return mysql.query("DELETE FROM funcionarios WHERE ID = " + p.getId());
		}
		return false;
	}
	
	public static ArrayList<Funcionario> getAll(){
		return getBy("1", "1");
	}
	
	public static Funcionario getFuncionario(int id)
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
	
	public static Funcionario getFuncionario(String matricula)
	{
		try
		{
			return getBy("MATRICULA", matricula).get(0);
		}
		catch(NullPointerException npe)
		{
			return null;
		}
	}
	
	public static Funcionario getFuncionarioByLogin(String cpf, String senha)
	{
		try
		{
			if(mysql.query("SELECT * FROM funcionarios WHERE CPF = '" + cpf + "' AND SENHA = MD5('" + senha + "')")) {
				HashMap<String, Object> r = mysql.fetch_assoc();
				
				return new Funcionario((int) r.get("ID"), (String) r.get("MATRICULA"),(String) r.get("NOME"),(String) r.get("CPF"),
							(String) r.get("SENHA"), r.get("DT_NASCIMENTO").toString(),(String) r.get("FUNCAO"), r.get("ATIVO").equals("S"),
							(int) r.get("PERMISSAO"));
			}
			return null;
		}
		catch(NullPointerException npe)
		{
			return null;
		}
	}
	
	public static ArrayList<Funcionario> getBy(String filtro, String valor){
		ArrayList<Funcionario> ps = new ArrayList<Funcionario>();
		
		if(mysql.query("SELECT * FROM funcionarios WHERE " + filtro.toUpperCase() + " = '" + valor + "'")) {
			ArrayList<HashMap<String, Object>> resultado = mysql.fetch_assoc_all();
			
			for(HashMap<String,Object> r : resultado) {
				Funcionario p = new Funcionario((int) r.get("ID"), (String) r.get("MATRICULA"),(String) r.get("NOME"),(String) r.get("CPF"),
						(String) r.get("SENHA"), (String)r.get("DT_NASCIMENTO").toString(),(String) r.get("FUNCAO"),r.get("ATIVO").equals("S"),
						(int) r.get("PERMISSAO"));
				System.out.println(p.getNome() + p.getId());
				ps.add(p);
			}
			
			return ps;
		}
		return null;
	}
}
