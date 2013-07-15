package net.geeklythings.fieldmarshal.sql;

public class DAOFactory {

	
	public static TournamentDAO getTournamentDAO()
	{
		TournamentDAO dao = new TournamentDAO();
		return dao;
		
	}
	//public static PlayerDAO getPlayerDAO(){}
	//public static RoundDAO getRoundDAO(){}
	
	
}
