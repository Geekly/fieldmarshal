package net.geeklythings.fieldmarshal.data;

public class Entrant {
	
	protected Player player;
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Faction getFaction() {
		return faction;
	}

	public void setFaction(Faction faction) {
		this.faction = faction;
	}

	protected Faction faction;
	
	public Entrant(Player addplayer, Faction addfaction)
	{
		player = addplayer;
		faction = addfaction;
	}

}
