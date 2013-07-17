package net.geeklythings.fieldmarshal.data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Round {

    private int roundNumber;

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }
    @Transient
    private List<RoundResult> roundResults;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    
    
    public Round(){}
    
    public Round(int number) {
        roundNumber = number;
        roundResults = null;
    }

    public void addResult(RoundResult result) throws Exception {
        int resultRound = result.getRoundNumber();
        if (resultRound == this.roundNumber) {
            roundResults.add(result);
        } else {
            throw new Exception("invalid round number");//check if round numbers match
        }

    }

    public void setPairings() {
    }
}
