package net.geeklythings.fieldmarshal.sql;

import org.joda.time.DateTime;
import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


import net.geeklythings.fieldmarshal.data.*;

@SuppressWarnings("unused")
public class TournamentDAO implements IDataAccessObject<Tournament>
{

	private Connection db; 
	
	public TournamentDAO()
	{
		try {
			db = ConnectionFactory.createDBConnection();
		}
		catch( ClassNotFoundException e){}
		
	}
	
	public Tournament[] findAll(){ return null;}
	@Override
	public Tournament find(String name) throws SQLException
	{
		Tournament tournament = null;
		//find the tournament in the database and initialize the object
		Statement statement = db.createStatement();
		if( statement.execute("") )
		{
			ResultSet results = statement.getResultSet();
		}
		return tournament;
	}
	public void insert(Tournament tournament) throws SQLException 
	{
	
		PreparedStatement insert = null;
		
		//Convert java.util.Date to java.sql.Date
	
		
		Date sqlDate = new java.sql.Date(tournament.getDate().getMillis());
		
		
		int formatID = tournament.getTournamentFormat().getFormatID();  //key for the format table
		
		String updateString = "INSERT INTO Tournaments "
				+ "(tournamentID, tournamentDate, tournamentLocation, tournamentOrganizer, formatID)"
				+ "VALUES(?, ?, ?, ?, ?)";
		insert = db.prepareStatement(updateString);
		
		insert.setInt(1, tournament.getID());
		insert.setDate(2, sqlDate);
		insert.setString(3, tournament.getLocation());
		insert.setString(4, tournament.getOrganizer());
		insert.setInt(5,  formatID);
		
		
		/*String query = "INSERT INTO Tournaments "
				+ "(tournamentID, tournamentDate, tournamentLocation, tournamentOrganizer, formatID)"
				+ "VALUES(" + tournamentID + "," + tournamentDate + "," + tournamentLocation + "," 
				+ tournamentOrganizer + "," + formatID + ")";*/
			
		//Statement statement = db.createStatement();
		//statement.executeQuery(query);
		boolean result = insert.execute();
				
	}
	public void update(Tournament tournament) throws SQLException {}
	public void delete(Tournament tournament) throws SQLException {}
	
	
}
