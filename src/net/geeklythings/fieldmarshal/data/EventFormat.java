package net.geeklythings.fieldmarshal.data;

public class EventFormat {
	
	protected int numRounds;
	protected String tournamentFormat;
	protected String timeFormat;
	
	public EventFormat(int rounds)
	{
		numRounds = rounds;
	}
	
	public EventFormat(int rounds, String format, String time)
	{
		numRounds = rounds;
		tournamentFormat = format;
		timeFormat = time;
		
	}

	public int getNumRounds() {
		return numRounds;
	}

	public void setNumRounds(int numRounds) {
		this.numRounds = numRounds;
	}

	public String getTournamentFormat() {
		return tournamentFormat;
	}

	public void setTournamentFormat(String tournamentFormat) {
		this.tournamentFormat = tournamentFormat;
	}

	public String getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}

}
