package net.geeklythings.fieldmarshal.data;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class Tournament {

	private Date todaysDate;
	private Date startTime;
	private int numRounds;
	private HashSet<Player> players;
	//Standings
	private Round[] rounds;
		//RoundResults
	
	public Tournament (int numRounds)
	{
		
		rounds = new Round[numRounds];
		
	}
	
	public void AddPlayer(Player newPlayer) {		
		players.add(newPlayer);
	}
	
	public void AddPlayer(String playerName, String faction) {
		players.add( new Player(playerName, faction));
	}
	
}
