package net.geeklythings.fieldmarshal.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

	public static Connection createDBConnection() throws ClassNotFoundException
	{
		
		Class.forName("org.sqlite.JDBC");
		
		Connection connection = null;
		
		try
		{
			
			connection = DriverManager.getConnection("jdbc:sqlite:database/fieldmarshal.db");			
			
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
		finally
	    {
	      try
	      {
	        if(connection != null)
	          connection.close();
	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
	    }
		
		return null;		
	}

}
