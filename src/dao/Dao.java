package dao;

import utils.Mysql;

public abstract class Dao {
	protected static Mysql mysql = new Mysql("localhost", "admin", "password", "prontuario");
	//protected static Mysql mysql = new Mysql("localhost", "aluno", "aluno", "prontuario");
}
