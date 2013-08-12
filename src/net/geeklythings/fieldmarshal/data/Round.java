package net.geeklythings.fieldmarshal.data;

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

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        int oldRoundNumber = this.roundNumber;
        this.roundNumber = roundNumber;
        changeSupport.firePropertyChange("roundNumber", oldRoundNumber, roundNumber);
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
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }    
    
    public Round()
    {
        roundResults = new ArrayList<>();
    }
    
    public Round(int number) {
        roundNumber = number;
        roundResults = new ArrayList<>();
    }
    
    public Round(Round rnd)
    {
        roundNumber = rnd.roundNumber;
        roundResults = rnd.roundResults;
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
