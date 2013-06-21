package net.geeklythings.fieldmarshal.data;

public class Player {

	private String name;
	private String faction;
	
	public Player()
	{
		
	}
	
	public Player(String playerName, String playerFaction)
	{
		this.setName(playerName);
		this.setFaction(playerFaction);
	}

	public String getName() {
		return name;
	}

	public void setName(String playerName) {
		name = playerName;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String playerFaction) {
		faction = playerFaction;
	}
}
