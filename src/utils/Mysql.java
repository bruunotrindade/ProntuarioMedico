package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Mysql
{
    private ResultSet rs;   
    private Connection con;
	private Statement smt;
	private PreparedStatement pSmt = null;

    public Mysql(String host, String user, String pass, String db)
    {
    	try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://"+host+"/"+db, user, pass);
			smt = con.createStatement();
		}
		catch(SQLException sqle)
		{
			System.out.println("FDP");
			System.out.printf("Erro: #%d [%s]\n", sqle.getErrorCode(), sqle.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("Falha");
			System.exit(1);
		}
    }
    
    public boolean query(String sql)
    {
    	try
		{
    		smt.execute(sql);
    		rs = smt.getResultSet();
    		return true;
		}
    	catch(SQLException sqle)
		{
			System.out.printf("Erro: #%d [%s]\n", sqle.getErrorCode(), sqle.getMessage());
			return false;
		}
    }
    
    public void prepare(String query) {
    	try {
			pSmt = con.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
    
    public void setPrepare(int id, Object obj) {
    	try {
			pSmt.setObject(id, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public boolean execute() {
    	try {
    		return (pSmt.execute());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    
    public ResultSet getSet() {
    	return rs;
    }
    
    public ResultSetMetaData getMetaData() {
    	try {
			return rs.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    public HashMap<String, Object> fetch_assoc()
    {
        try
        {
        	if(rs.next())
        	{
        		HashMap<String, Object> ob = new HashMap<String, Object>();
            	ResultSetMetaData rmsd = rs.getMetaData();
            	for(int i = 1; i <= rmsd.getColumnCount(); ++i)
            		ob.put(rmsd.getColumnName(i), rs.getObject(i));
            	
            	return ob;
        	}
        	else
        		return null;
		}
    	catch(SQLException sqle)
		{
			System.out.printf("Erro: #%d [%s]\n", sqle.getErrorCode(), sqle.getMessage());
		}
        return null;
    }
    
    public ArrayList<HashMap<String, Object>> fetch_assoc_all()
    {
        try
        {
        	ArrayList<HashMap<String, Object>> vet = new ArrayList<>();
        	while(rs.next())
        	{
        		HashMap<String, Object> ob = new HashMap<String, Object>();
            	ResultSetMetaData rmsd = rs.getMetaData();
            	for(int i = 1; i <= rmsd.getColumnCount(); ++i)
            		ob.put(rmsd.getColumnName(i), rs.getObject(i));
            	
            	vet.add(ob);
        	}
        	return vet;
		}
    	catch(SQLException sqle)
		{
			System.out.printf("Erro: #%d [%s]\n", sqle.getErrorCode(), sqle.getMessage());
		}
        return null;
    }

    public int num_rows()
    {
    	try
		{
    		return smt.getMaxRows();
		}
    	catch(SQLException sqle)
		{
			System.out.printf("Erro: #%d [%s]\n", sqle.getErrorCode(), sqle.getMessage());
			return 0;
		}
    }
    
    public int affected_rows()
    {
    	try
		{
    		return smt.getUpdateCount();
		}
    	catch(SQLException sqle)
		{
			System.out.printf("Erro: #%d [%s]\n", sqle.getErrorCode(), sqle.getMessage());
			return 0;
		}
    }
}