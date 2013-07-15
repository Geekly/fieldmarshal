package net.geeklythings.fieldmarshal.data;

import java.sql.SQLException;
import org.joda.time.*;

import net.geeklythings.fieldmarshal.sql.TournamentDAO;
import net.geeklythings.fieldmarshal.sql.DAOFactory;
import net.geeklythings.fieldmarshal.util.Hash;

public class TournamentFactory {

	public static Tournament loadTournament(int tournamentID) {
		
			TournamentDAO dao = DAOFactory.getTournamentDAO();
			
		return null;}
	
	public static Tournament createTournament(int numRounds) {
		
		try {
			TournamentDAO dao = DAOFactory.getTournamentDAO();
			Tournament tournament = new Tournament(numRounds);
			int hash = Hash.getIntHash();
			tournament.setID(hash);
			
			DateTime today = new DateTime();
			
			tournament.setDate(today);
			
			dao.insert(tournament);

		
			//TODO: Set up Rounds first
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;}
	
}
