package net.geeklythings.fieldmarshal.data;

import java.util.ArrayList;

public class Round {
	private int roundNumber;
	private ArrayList<RoundResult> roundResults;
	
	public Round(int number){
		roundNumber = number;
		roundResults = null;
	}
	
	public void addResult(RoundResult result) throws Exception
	{
		int resultRound = result.getRoundNumber();
		if (resultRound == this.roundNumber) 
		{
			roundResults.add(result);
		}
		else
		{
			throw new Exception("invalid round number");//check if round numbers match
		}	
			
	}
}
