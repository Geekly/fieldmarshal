/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import net.geeklythings.fieldmarshal.model.PlayerStatus;


/**
 *
 * @author khooks
 */
@Entity
@Access(AccessType.FIELD)
@Table(name="TOURNAMENT")
public class Tournament extends Observable implements Serializable {
    
    
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
       
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="TODAYSDATE")
    private Date todaysDate = new Date();
    @Column(name="LOCATION")
    private String store = "Fort Bourne";
    @Column(name="ORGANIZER")
    private String organizer = "Anastasia deBray";
    @Column(name="NUMROUNDS")
    private int numRounds = 3;
    
    @JoinColumn(name="ID_EVENTFORMAT")
    @OneToOne(cascade={CascadeType.PERSIST})
    private EventFormat format = new EventFormat();
      
    @OneToMany(cascade={CascadeType.MERGE})
    private List<Player> players = new ArrayList<>();
    
    /// The rounds need to be managed better.  orphanremoval has been removed temporarily
    @OneToMany(cascade={CascadeType.MERGE}) 
    private List<Round> rounds = new ArrayList<>();
    
    @Transient
    private int currentRound = 1;
    
    //@Transient
    //private List<Player> activePlayers = new ArrayList<>();  //for tracking dropped players
    
    public Tournament() {
        //todaysDate = new Date();    
        //startTime = todaysDate;
        //format = new EventFormat();
        //players = new ArrayList<>();
        //rounds = new ArrayList<>(numRounds);
    }
    
    public Tournament copy()
    {
        //id = master.id;
        
        Tournament copy = new Tournament();
        
        copy.format = new EventFormat(format);  //assign to a copy
        
        copy.todaysDate = todaysDate;
        copy.numRounds = numRounds;
        copy.store = store;
        copy.organizer = organizer;
        
        copy.players = players;  //don't change this anywhere
        copy.rounds = rounds;    //don't change this anywhere
        
        return copy;
        // persist(format);
    }
    
    public static Tournament createTournament(int numRounds) 
    {

        Tournament tournament = new Tournament();
        
        EventFormat ef = new EventFormat();       
        //ef.setNumRounds(numRounds);
        
        tournament.setFormat( ef );
        for( int i=1; i<=numRounds; i++)
        {
            tournament.addRound(new Round(i));
        }

        Date today = new Date();
        tournament.setTodaysDate(today);
        tournament.setOrganizer("Coleman Stryker");
        tournament.setStore("Corvis Convention Center");
       
        //TODO: Set up Rounds first

        return tournament;
    }
    
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
    
    public int getCurrentRound() {
        return currentRound;
    }
    
    public EventFormat getFormat() {
        return format;
    }

    public void setFormat(EventFormat format) {
        EventFormat oldformat = this.format;
        this.format = format;
        changeSupport.firePropertyChange("format", oldformat, format);
        
    }

    public List<Player> getActivePlayers()
    {
        List<Player> activePlayers = new ArrayList<>();
        
        for( Player e : players )
        {
            if( e.getActiveStatus() == PlayerStatus.ACTIVE)
            {
                activePlayers.add(e);
            }
        }
        return activePlayers;
    }
    
    public Date getTodaysDate() {
        return todaysDate;
    }

    public void setTodaysDate(Date todaysDate) {
        Date oldTodaysDate = this.todaysDate;
        this.todaysDate = todaysDate;
        changeSupport.firePropertyChange("todaysDate", oldTodaysDate, todaysDate);
    }
    
    /*public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        Date oldStartTime = this.startTime;
        this.startTime = startTime;
        changeSupport.firePropertyChange("startTime", oldStartTime, startTime);
    }*/

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        String oldLocation = this.store;
        this.store = store;
        changeSupport.firePropertyChange("store", oldLocation, store);
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        String oldOrganizer = this.organizer;
        this.organizer = organizer;
        changeSupport.firePropertyChange("organizer", oldOrganizer, organizer);
    }

    public void setNumRounds(int targetRounds) {
        
        int oldRounds = this.numRounds;
        // Empty and recreate
        while (targetRounds < rounds.size())
        {
            removeLastRound();

        }
        while ( targetRounds > rounds.size())
        {
            addNewRound();
        }
        numRounds = rounds.size();
        //this.persist(this);
        changeSupport.firePropertyChange("numRounds", oldRounds, numRounds);
    }
    
    public int getNumRounds() {
        return numRounds;
    }

        /**
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        //List<Player> oldPlayers = new ArrayList<>( this.getPlayers() );
        players.add(player);
        
        changeSupport.firePropertyChange("players", null, this.getPlayers());
    }

    public List<Round> getRounds()
    {
        return rounds;
    }
    
    public void addNewRound()
    {
        List<Round> oldRounds = this.rounds;
        this.rounds = new ArrayList<>(this.rounds);
        Round newRound = new Round();
        persist(newRound);
        rounds.add( newRound );
        changeSupport.firePropertyChange("rounds", oldRounds, rounds);
    }
        
    public void addRound(Round round) {
        List<Round> oldRounds = this.rounds;
        this.rounds = new ArrayList<>(this.rounds);      
        if( round.getId() == null ) { persist(round); }
        this.rounds.add(round);
        this.numRounds = rounds.size();
        changeSupport.firePropertyChange("rounds", oldRounds, rounds);
    }

    public void removeLastRound()
    {
        List<Round> oldRounds = this.rounds;
        this.rounds = new ArrayList<>(this.rounds);
        this.rounds.remove( rounds.size()-1 );
        this.numRounds = rounds.size();
        System.out.println("");
        changeSupport.firePropertyChange("rounds", oldRounds, rounds);
    }
    
    public void copyProperties(Tournament master)
    /* Don't create new objects in here */
    {
        //setId(master.id);  //don't ever copy the id, or chaos will ensue
        setTodaysDate(master.todaysDate);
        //setNumRounds (master.numRounds);  //we won't set this in the dialog any more
        setStore(master.store);   
        setOrganizer(master.organizer);
        //setPlayers( master.players);  //don't change this anywhere
        //rounds = master.rounds; //don't change this anywhere
        getFormat().setClockTime(master.getFormat().getClockTime());
        getFormat().setClockType(master.getFormat().getClockType());
        getFormat().setFormatType(master.getFormat().getFormatType());

    }
    
    
    public void dropPlayer(Player dropped)
    {
        //keep the player in the tournament, but eliminate from pairings
        dropped.setActiveStatus(PlayerStatus.INACTIVE);
    }
    
   /* @Override
    public Tournament clone()
    // Returns a copy of itself
    {
        Tournament clone = new Tournament(this);
        EventFormat newFormat = new EventFormat(this.format);
        clone.setFormat(newFormat);
        return clone;
    }*/
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tournament)) {
            return false;
        }
        Tournament other = (Tournament) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tournament{" + "changeSupport=" + changeSupport + ", todaysDate=" + todaysDate + ", store=" + store + ", organizer=" + organizer + ", numRounds=" + numRounds + ", format=" + format + ", players=" + players + ", rounds=" + rounds + ", currentRound=" + currentRound + ", id=" + id + '}';
    }



    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalPU2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
