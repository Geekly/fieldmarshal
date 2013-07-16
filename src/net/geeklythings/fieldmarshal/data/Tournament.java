package net.geeklythings.fieldmarshal.data;

import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.joda.time.*;


import net.geeklythings.fieldmarshal.sql.TournamentDAO;


public class Tournament {

	private TournamentDAO data;
	private int databaseID;  //database primary key
	private DateTime todaysDate;
	private MutableDateTime startTime;
	private String location="YLGS";
	private String organizer="Joe McDougal";
	private EventFormat format;
	//private int numRounds;
	private HashSet<Entrant> players;
	//Standings
	private ArrayList<Round> rounds;
		//RoundResults
	
        public Tournament()
        {
        
        }
        
	public Tournament (int numRounds)
	{		
		setTournamentFormat(new EventFormat(numRounds));
		this.rounds = new ArrayList<Round>(numRounds);
		for( int idx = 0; idx < this.rounds.size(); idx++)
		{
			this.rounds.add(new Round(idx+1));
		}
	}
	
	
	public void update()
	{
		try {
			data.update(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Round getRound(int roundNumber)
	{
		if( (roundNumber <= rounds.size()) && ( roundNumber >= 1))
		{
			return rounds.get(roundNumber);
		}
		return null;
	}
	
	public Round[] getAllRounds()
	{
		return (Round[]) (this.rounds).toArray();
	}
	
	
	public void AddEntrant(Entrant newPlayer) {
		players.add(newPlayer);
	}
	
	public void AddEntrant(String firstName, String lastName, Faction faction) {
		Player player = new Player(firstName, lastName);
		players.add( new Entrant(player, faction));
	}

	public DateTime getDate() {
		return todaysDate;
	}

	public void setDate(DateTime todaysDate) {
		this.todaysDate = todaysDate;
	}

	public MutableDateTime getStartTime() {
		return startTime;
	}

	public int getID() {
		return databaseID;
	}

	public void setID(int databaseID) {
		this.databaseID = databaseID;
	}

	public void setStartTime(MutableDateTime startTime) {
		this.startTime = startTime;
	}

	public EventFormat getTournamentFormat() {
		return format;
	}

	public void setTournamentFormat(EventFormat tournamentFormat) {
		this.format = tournamentFormat;
	}

	public String getLocation() {
		
		return location;
	}
	public void setLocation(String loc) {
		this.location = loc;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	
	
}
