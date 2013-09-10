/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.model.entity;

import java.beans.PropertyChangeEvent;
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
import net.geeklythings.fieldmarshal.jpa.TournamentJpaController;
import net.geeklythings.fieldmarshal.model.PlayerStatus;
import net.geeklythings.fieldmarshal.model.Players;
import org.jdesktop.observablecollections.ObservableList;


/**
 *
 * @author khooks
 */
@Entity
@Access(AccessType.FIELD)
@Table(name="TOURNAMENT")
public class Tournament implements Serializable, PropertyChangeListener {
    
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;   
    
    public Long getId() {
        return id;
    }
    
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
    @OneToOne(cascade={CascadeType.ALL})
    private EventFormat format;// = new EventFormat();
        
    @Transient
    private Players players;
    
    @OneToMany(cascade={CascadeType.ALL})
    @MapBy()
    @Access(AccessType.PROPERTY)
    public ArrayList<Player> getPlayers()
    {
        return players.getPlayers();
    }
    public void setPlayers( ArrayList<Player> players)
    {
        this.players.setPlayers(players);
    }
    
    /// The rounds need to be managed better.  orphanremoval has been removed temporarily
    @OneToMany(cascade={CascadeType.ALL}) 
    private List<Round> rounds; 
    
    @Transient
    private int currentRound = 1;
    
    //@Transient
    //private List<Player> activePlayers = new ArrayList<>();  //for tracking dropped players
    
    public Tournament() {
        
        format = new EventFormat();
        format.addPropertyChangeListener(this);
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
        //tournament.addPropertyChangeListener(this);  //the manager that creates it will listen to it
        
        EventFormat ef = new EventFormat();       
        //ef.setNumRounds(numRounds);
        
        //tournament.players = new ArrayList<>();
        tournament.players = new Players();
        
        tournament.setFormat( ef );
        
        tournament.rounds = new ArrayList<>();
        
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
        
        for( Player e : players.getPlayers() )
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


    public void addPlayer(Player player) {
        //List<Player> oldPlayers = new ArrayList<>( this.getPlayers() );
        players.addPlayer(player);
        player.addPropertyChangeListener(this);        
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
        rounds.add( newRound );
        changeSupport.firePropertyChange("rounds", oldRounds, rounds);
    }
        
    public void addRound(Round round) 
    {
        List<Round> oldRounds = this.rounds;
        this.rounds = new ArrayList<>(this.rounds);      
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

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
