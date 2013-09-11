/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.model.entity;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import net.geeklythings.fieldmarshal.model.PlayerStatus;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;


/**
 *
 * @author khooks
 */
@Entity
@Access(AccessType.FIELD)
@Table(name="TOURNAMENT")
public class Tournament extends AbstractEntityModel implements Serializable, PropertyChangeListener, ListChangeListener {
    
    public static final String PLAYER_CHANGE = "playerChange";
    public static final String ROUND_CHANGE = "roundChange";
    private static final long serialVersionUID = 1L;
    
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TOURNAMENT_ID")
    private Long id;   
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange("id", oldId, id);
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
    
    @Embedded  // don't create a seperate table for it
    private EventFormat format;// = new EventFormat();
        
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="OWNER_ID", referencedColumnName="TOURNAMENT_ID")
    private List<Player> players;
    
    @OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true)
    @JoinColumn(name="OWNER_ID", referencedColumnName="TOURNAMENT_ID")
    private List<Round> rounds;   
        
    public List<Player> getPlayers()
    {
        return players;
    }
    public void setPlayers( List<Player> players)
    {
        //this.players = (ObservableList<Player>) FXCollections.observableList(players);
    }
    
    @Transient
    private int currentRound = 1;
     
    public Tournament() {
        
        format = new EventFormat();
        format.addPropertyChangeListener(this);
        //todaysDate = new Date();    
        //startTime = todaysDate;
        //format = new EventFormat();
        //players = new ArrayList<>();
        //rounds = new ArrayList<>(numRounds);
    }
    
    public static Tournament createTournament(int numRounds) 
    {

        Tournament tournament = new Tournament();      
        //tournament.addPropertyChangeListener(this);  //the manager that creates it will listen to it
        
        EventFormat ef = new EventFormat();       
        //ef.setNumRounds(numRounds);
        List<Player> players = new ArrayList<>();
        tournament.players = FXCollections.observableList(players);
        
        //tournament.players = new Players();
        
        tournament.setFormat( ef );
        
        List<Round> rounds = new ArrayList<>();
        tournament.rounds = FXCollections.observableList(rounds);
        
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
         
    public int getCurrentRound() {
        return currentRound;
    }
    
    public EventFormat getFormat() {
        return format;
    }

    public void setFormat(EventFormat format) {
        EventFormat oldformat = this.format;
        this.format = format;
        propertyChangeSupport.firePropertyChange("format", oldformat, format);
        
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
        propertyChangeSupport.firePropertyChange("todaysDate", oldTodaysDate, todaysDate);
    }
    
    /*public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        Date oldStartTime = this.startTime;
        this.startTime = startTime;
        propertyChangeSupport.firePropertyChange("startTime", oldStartTime, startTime);
    }*/

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        String oldLocation = this.store;
        this.store = store;
        propertyChangeSupport.firePropertyChange("store", oldLocation, store);
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        String oldOrganizer = this.organizer;
        this.organizer = organizer;
        propertyChangeSupport.firePropertyChange("organizer", oldOrganizer, organizer);
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
        propertyChangeSupport.firePropertyChange("numRounds", oldRounds, numRounds);
    }
    
    public int getNumRounds() {
        return numRounds;
    }


    public void addPlayer(Player player) {
        //List<Player> oldPlayers = new ArrayList<>( this.getPlayers() );
        players.add(player);
        player.addPropertyChangeListener(this);        
        propertyChangeSupport.firePropertyChange(PLAYER_CHANGE, null, this.getPlayers());
    }

    public List<Round> getRounds()
    {
        return rounds;
    }
    
    public void addNewRound()
    {
        List<Round> oldRounds = this.rounds;
        this.rounds = FXCollections.observableList( new ArrayList<>(this.rounds) );
        Round newRound = new Round();
        rounds.add( newRound );
        propertyChangeSupport.firePropertyChange("rounds", oldRounds, rounds);
    }
        
    public void addRound(Round round) 
    {
        List<Round> oldRounds = this.rounds;
        this.rounds = FXCollections.observableList( new ArrayList<>(this.rounds) );      
        this.rounds.add(round);
        this.numRounds = rounds.size();
        propertyChangeSupport.firePropertyChange("rounds", oldRounds, rounds);
    }

    public void removeLastRound()
    {
        // TODO: change this to utilize the observable list properties
        List<Round> oldRounds = this.rounds;
        this.rounds = FXCollections.observableList( new ArrayList<>(this.rounds) );
        this.rounds.remove( rounds.size()-1 );
        this.numRounds = rounds.size();
        System.out.println("");
        propertyChangeSupport.firePropertyChange("rounds", oldRounds, rounds);
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
        return "Tournament{ todaysDate=" + todaysDate + ", store=" + store + ", organizer=" + organizer + ", numRounds=" + numRounds + ", format=" + format + ", players=" + players + ", rounds=" + rounds + ", currentRound=" + currentRound + ", id=" + id + '}';
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void onChanged(Change change) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
    
}
