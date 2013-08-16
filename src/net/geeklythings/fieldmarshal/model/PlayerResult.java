package net.geeklythings.fieldmarshal.model;

import java.beans.PropertyChangeSupport;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Access(AccessType.FIELD)
@Table(name="PLAYERRESULT")
public class PlayerResult {


    public static final String PROP_PLAYER = "PROP_PLAYER";
    public static final String PROP_OPPONENT = "PROP_OPPONENT";
    public static final String PROP_LISTPLAYED = "PROP_LISTPLAYED";
    public static final String PROP_RESULT = "PROP_RESULT";
    public static final String PROP_CONTROLPOINTS = "PROP_CONTROLPOINTS";
    public static final String PROP_ARMYPOINTSDESTROYED = "PROP_ARMYPOINTSDESTROYED";
    
    @JoinColumn(name="ID_PLAYER")
    @ManyToOne(cascade= { CascadeType.MERGE })
    private Entrant player;
    
    @JoinColumn(name="ID_OPPONENT")
    @ManyToOne(cascade= { CascadeType.MERGE })
    private Entrant opponent;
    
    @Column(name="LISTPLAYED")
    private int listPlayed;
    @Column(name="CONTROLPOINTS")
    private int controlPoints;
    @Column(name="ARMYPOINTSDESTROYED")
    private int armyPointsDestroyed; 
    
    @Enumerated(EnumType.STRING)
    private ResultType resultType;
    

    //private int roundNumber;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Transient
    private final PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "PlayerResult{" + "player=" + player + ", opponent=" + opponent + ", listPlayed=" + listPlayed + ", result=" + resultType + ", controlPoints=" + controlPoints + ", armyPointsDestroyed=" + armyPointsDestroyed + '}';
    }
   
    /**
     * @return the player
     */
    public Entrant getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Entrant player) {
        
        try {
            if( player.getId() == null) {
                throw new Exception("Player must be persisted before setting");
            }
            else
            {
                Entrant oldEntrant = this.player;
                this.player = player;
                propertyChangeSupport.firePropertyChange(PROP_PLAYER, oldEntrant, player);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @return the opponent
     */
    public Entrant getOpponent() {
        return opponent;
    }

    /**
     * @param player the opponent to set
     */
    public void setOpponent(Entrant player) {
        try {
            if( player.getId() == null) 
            {
                throw new Exception("Entrant must be persisted before setting");
            }
            else
            {
                net.geeklythings.fieldmarshal.model.Entrant oldOpponent = this.opponent;
                this.opponent = player;
                propertyChangeSupport.firePropertyChange(PROP_OPPONENT, oldOpponent, player);
            }
        } catch(Exception e ){
            e.printStackTrace();
        } 
    }

    /**
     * @return the listPlayed
     */
    public int getListPlayed() {
        return listPlayed;
    }

    /**
     * @param listPlayed the listPlayed to set
     */
    public void setListPlayed(int listPlayed) {
        int oldListPlayed = this.listPlayed;
        this.listPlayed = listPlayed;
        propertyChangeSupport.firePropertyChange(PROP_LISTPLAYED, oldListPlayed, listPlayed);
    }

    /**
     * @return the result
     */
    public ResultType getResult() {
        return resultType;
    }

    /**
     * @param resultType the result to set
     */
    public void setResult(ResultType resultType) {
        //TODO: would be nice to check against the opponent's result as well
        net.geeklythings.fieldmarshal.model.ResultType oldResult = this.resultType;
        this.resultType = resultType;
        propertyChangeSupport.firePropertyChange(PROP_RESULT, oldResult, resultType);
    }

    /**
     * @return the controlPoints
     */
    public int getControlPoints() {
        return controlPoints;
    }

    /**
     * @param controlPoints the controlPoints to set
     */
    public void setControlPoints(int controlPoints) {
        int oldControlPoints = this.controlPoints;
        this.controlPoints = controlPoints;
        propertyChangeSupport.firePropertyChange(PROP_CONTROLPOINTS, oldControlPoints, controlPoints);
    }

    /**
     * @return the armyPointsDestroyed
     */
    public int getArmyPointsDestroyed() {
        return armyPointsDestroyed;
    }

    /**
     * @param armyPointsDestroyed the armyPointsDestroyed to set
     */
    public void setArmyPointsDestroyed(int armyPointsDestroyed) {
        int oldArmyPointsDestroyed = this.armyPointsDestroyed;
        this.armyPointsDestroyed = armyPointsDestroyed;
        propertyChangeSupport.firePropertyChange(PROP_ARMYPOINTSDESTROYED, oldArmyPointsDestroyed, armyPointsDestroyed);
    }
}
