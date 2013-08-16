package net.geeklythings.fieldmarshal.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Access(AccessType.FIELD)
@Table(name="ROUND")
public class Round {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @Column(name="ROUNDNUMBER")
    private int roundNumber;
    
    @Transient
    private List<RoundResult> roundResults = new ArrayList<>();
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public String toString() {
        return "Round{" + "roundNumber=" + roundNumber + ", roundResults=" + roundResults + ", id=" + id + '}';
    }
    

    
    public Round()
    {

    }
    
    public Round(int number) {
        roundNumber = number;
        roundResults = new ArrayList<>();
    }
    
    public Round(Round rnd)
    {
        id = rnd.getId();
        roundNumber = rnd.getRoundNumber();
        roundResults = new ArrayList<>(rnd.getRoundResults());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }    
    
    public List<RoundResult> getRoundResults()
    {
        return roundResults;
    }
        
    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        int oldRoundNumber = this.roundNumber;
        this.roundNumber = roundNumber;
        changeSupport.firePropertyChange("roundNumber", oldRoundNumber, roundNumber);
    }

    public void addRoundResult(RoundResult result) throws Exception {
        int resultRound = result.getRoundNumber();
        if (resultRound == this.roundNumber) {
            roundResults.add(result);
        } else {
            throw new Exception("invalid round number");//check if round numbers match
        }
    }

    public void createPairings() {
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
