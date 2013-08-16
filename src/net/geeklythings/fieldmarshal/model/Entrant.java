package net.geeklythings.fieldmarshal.model;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Access(AccessType.FIELD)
@Table(name="ENTRANT")
public class Entrant implements Serializable {

    @Override
    public String toString() {
        return "Entrant{" + "id=" + id + ", player=" + player + ", faction=" + faction + ", activeStatus=" + activeStatus + '}';
    }
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @JoinColumn(name = "ID_PLAYER")
    @ManyToOne(cascade= { CascadeType.MERGE })
    private Player player;
    
    @Enumerated(EnumType.STRING)
    protected Faction faction;
    
    @Column(name="LASTROUNDPLAYED")
    private int lastRoundPlayed = 1;

    @OneToMany(cascade = {CascadeType.MERGE}) 
    private List<PlayerResult> results = new ArrayList<>();

    /**
     * Get the value of results
     *
     * @return the value of results
     */
    public List<PlayerResult> getResults() {
        return results;
    }

    /**
     * Set the value of results
     *
     * @param results new value of results
     */
    public void setResults(List<PlayerResult> results) {
        this.results = results;
    }
    
    public int getLastRoundPlayed() {
        return lastRoundPlayed;
    }

    public void setLastRoundPlayed(int lastRoundPlayed) {
        this.lastRoundPlayed = lastRoundPlayed;
    }
       
    @Transient
    private final PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    @Transient
    private EntrantStatus activeStatus = EntrantStatus.ACTIVE;
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entrant(){}
    
    public Entrant(Player addPlayer, Faction addfaction) {
        //When creating a new Entrant, we don't want to use an existing player if possible

        this.setPlayer(addPlayer);
        this.faction = addfaction;   
    }

    public int getWins(){return 0;}
    
    public int getLosses() {return 0;}
    
    public int getStandings(){return 0;
    }
    
    public Player getPlayer() {
        return player;
    }

    public final void setPlayer(Player player) {
        // add an un-persisted player 
        try {
            
            Player oldPlayer = this.getPlayer();
        
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalPU2");
            EntityManager em = emf.createEntityManager();

            Query query = em.createQuery("SELECT P FROM Player P WHERE P.firstName=?1 AND P.lastName=?2 ");
            query.setParameter(1, player.getFirstName());
            query.setParameter(2, player.getLastName());

            Player tempPlayer = null; 
            //check if this player already exists in the database
            try {
                tempPlayer = (Player)query.getSingleResult();
            } catch (NoResultException e) {
                //no result found
            } 

            em.getTransaction().begin();
            if( tempPlayer == null) //no records found, doesn't exist
            {   
                em.persist(player); //persist the new player
            }
            else // player exists in the database
            {
                player = em.merge(tempPlayer);
            }
            this.player = player;
            em.getTransaction().commit();
            emf.close();
            propertyChangeSupport.firePropertyChange("player", oldPlayer, this.getPlayer());

            } 
        catch( Exception e) { 
            e.printStackTrace(); 
        }
            
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        Faction oldFaction = this.faction;
        this.faction = faction;
        propertyChangeSupport.firePropertyChange("faction", oldFaction, this.faction);
    }

    public EntrantStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(EntrantStatus activeStatus) {
        this.activeStatus = activeStatus;
    }
  
    
}