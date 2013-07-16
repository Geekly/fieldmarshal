package net.geeklythings.fieldmarshal.sql;

public class DAOFactory {

	
	public static TournamentDAO getTournamentDAO()
	{
		TournamentDAO dao = new TournamentDAO();
		return dao;
		
	}
	
	public static PlayerDAO getPlayerDAO(){
		return null;}
	public static RoundDAO getRoundDAO(){
            return null;
}
	
	
}
