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
		
		//Convert java.util.Date to java.sql.Date
			
		Date sqlDate = new java.sql.Date(tournament.getDate().getMillis());
			
		int formatID = tournament.getTournamentFormat().getFormatID();  //key for the format table
		
		String updateString = "INSERT INTO Tournaments "
				+ "(tournamentID, tournamentDate, tournamentLocation, tournamentOrganizer, formatID_FK)"
				+ "VALUES(?, ?, ?, ?, ?)";
		PreparedStatement insert = db.prepareStatement(updateString);
		
		insert.setInt(1, tournament.getID());
		insert.setDate(2, sqlDate);
		insert.setString(3, tournament.getLocation());
		insert.setString(4, tournament.getOrganizer());
		insert.setInt(5,  formatID);

		boolean result = insert.execute();
				
	}
	public void update(Tournament tournament) throws SQLException 
	{		
		int formatID = tournament.getTournamentFormat().getFormatID();  //key for the format table
		Date sqlDate = new java.sql.Date(tournament.getDate().getMillis());
		String updateString = "UPDATE Tournaments "
				+ " SET tournamentID = ?, tournamentDate = ?, tournamentLocation = ?, tournamentOrganizer = ?," 
				+ "formatID_FK = ?"; 

		
		PreparedStatement update = db.prepareStatement(updateString);
		
		update.setInt(1, tournament.getID());
		update.setDate(2, sqlDate);
		update.setString(3, tournament.getLocation());
		update.setString(4, tournament.getOrganizer());
		update.setInt(5,  formatID);
		
		boolean result = update.execute();
		
	}
	
	public void delete(Tournament tournament) throws SQLException 
	{
		int id = tournament.getID();
		
		Statement delete = db.createStatement();
		delete.execute("DELETE FROM Tournaments WHERE tournamentID = " + id );
	}
	
	
}
