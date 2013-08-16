package net.geeklythings.fieldmarshal.model;

import java.util.List;
import java.util.ArrayList;


public class RoundResult {
	
    private int roundNumber;

    @Override
    public String toString() {
        return "RoundResult{" + "roundNumber=" + roundNumber + ", player1Result=" + player1Result + ", player2Result=" + player2Result + '}';
    }
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
    
    public List<PlayerResult> getPlayerResults()
    {
        List<PlayerResult> results = new ArrayList<>();
        results.add(player1Result);
        results.add(player2Result);
        return results;
    }
    
}
