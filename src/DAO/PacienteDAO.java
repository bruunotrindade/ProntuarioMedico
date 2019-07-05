package DAO;

import models.Paciente;
import sql.Mysql;

public class PacienteDAO {
	private Mysql mysql = new Mysql("localhost", "aluno", "aluno", "prontuario");
	
	public void insert(Paciente paciente) {
		if(paciente != null) {
			if(mysql.query("INSERT INTO pacientes() VALUES(")")) {
				
			}
		}
	}
}
