package dao;

import model.Paciente;
import sql.Mysql;

public class PacienteDao {
	private Mysql mysql = new Mysql("localhost", "aluno", "aluno", "prontuario");
	
	public void insert(Paciente paciente) {
		if(paciente != null) {
			if(mysql.query("INSERT INTO pacientes() VALUES()")) {
				
			}
		}
	}
}
