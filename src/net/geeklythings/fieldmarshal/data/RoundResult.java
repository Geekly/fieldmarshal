package net.geeklythings.fieldmarshal.data;


public class RoundResult {
	
	private int roundNumber;
	//private Player player1;  //two players
	//private Player player2;  //arbitrary 
	private PlayerResult player1Result;
	private PlayerResult player2Result;
	// result
	//player 1 results
	//player 2 results
	public Player getWinner(){
		return null;
	}
	public int getRoundNumber() {
		return roundNumber;
	}
	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}
}
