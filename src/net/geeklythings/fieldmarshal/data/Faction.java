package net.geeklythings.fieldmarshal.data;

public enum Faction {
	
	CRYX ("Cryx"),
	CYGNAR ("Cygnar"),
	KHADOR ("Khador"),
	MENOTH ("Protectorate of Menoth"),
	RETRIBUTION ("Retribution of Scyrah"),
	CONVERGENCE ("Convergence of Cyriss"),
	MERCS ("Mercenaries"),
	CIRCLE ("Circle of Orboros"),
	LEGION ("Legion of Everblight"),
	SKORNE ("Skorne"),
	TROLLS ("Trollbloods"),
	MINIONS ("Minions");
	
	private final String name;
	
	private Faction(String s) {
		name = s;
	}
	
	public String toString()
	{
		return name;
	}
	
	public static String[] enumsToStringArray() {
		
		String result[] = new String[Faction.values().length];
	
		int count = 0;
		for ( Faction each : Faction.values()) {
			result[count] = each.toString();
			count++;
		}
	
		return result;
	}
}
