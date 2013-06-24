package net.geeklythings.fieldmarshal.data;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class Tournament {

	private Date todaysDate;
	private Date startTime;
	private EventFormat tournamentFormat;
	//private int numRounds;
	private HashSet<Entrant> players;
	//Standings
	private Round[] rounds;
		//RoundResults
	
	public Tournament (int numRounds)
	{
		tournamentFormat = new EventFormat(numRounds);
		rounds = new Round[numRounds];		
	}
	
	public Tournament (EventFormat format)
	{
		
		tournamentFormat = format;
		
	}
	
	public void AddEntrant(Entrant newPlayer) {
		players.add(newPlayer);
	}
	
	public void AddEntrant(String firstName, String lastName, Faction faction) {
		Player player = new Player(firstName, lastName);
		players.add( new Entrant(player, faction));
	}
	
}
