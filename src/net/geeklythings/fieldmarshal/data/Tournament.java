/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import net.geeklythings.fieldmarshal.util.DateUtils;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;
//import org.joda.time.DateTime;
//import org.joda.time.MutableDateTime;

/**
 *
 * @author khooks
 */
@Entity
@Access(AccessType.FIELD)
@Table(name="TOURNAMENT")
public class Tournament implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    
    
    //@Converter(name = "jodaDateConverter", converterClass = net.geeklythings.fieldmarshal.util.JodaDateTimeConverter.class)
    //@Convert("jodaDateConverter")
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="TODAYSDATE")
    private Date todaysDate = new Date();
    @Column(name="LOCATION")
    private String store = "Fort Bourne";
    @Column(name="ORGANIZER")
    private String organizer = "Anastasia deBray";
    @Column(name="NUMROUNDS")
    private int numRounds = 4;
    
    @JoinColumn(name="ID_EVENTFORMAT")
    @OneToOne(cascade={CascadeType.ALL})
    private EventFormat format = new EventFormat();
      
    @OneToMany(cascade={CascadeType.ALL})
    private List<Entrant> players = new ArrayList<>();
    
    @OneToMany(orphanRemoval=true, cascade=CascadeType.ALL) 
    //no reason to keep the rounds after the tournament has been deleted
    private List<Round> rounds = new ArrayList<>();
    
    @Transient
    private int currentRound = 1;
    
    public Tournament() {
        todaysDate = new Date();    
        //startTime = todaysDate;
        //format = new EventFormat();
        //players = new ArrayList<>();
        //rounds = new ArrayList<>(numRounds);
    }
    
    public Tournament(Tournament master)
    {
        id = master.id;
        todaysDate = master.todaysDate;
        numRounds = master.numRounds;
        store = master.store;
        organizer = master.organizer;
        
        players = master.players;  //don't change this anywhere
        rounds = master.rounds; //don't change this anywhere
        
        format = new EventFormat(master.format);  //assign to a copy

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
        changeSupport.firePropertyChange("location", oldLocation, store);
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
        changeSupport.firePropertyChange("numRounds", oldRounds, numRounds);
    }
    
    public int getNumRounds() {
        return numRounds;
    }

        /**
     * @return the players
     */
    public List<Entrant> getPlayers() {
        return players;
    }

    public void addPlayer(Entrant player) {
        List<Entrant> oldEntrants = new ArrayList<>( this.getPlayers() );
        players.add(player);
        changeSupport.firePropertyChange("player", oldEntrants, getPlayers());
    }

    public List<Round> getRounds()
    {
        return rounds;
    }
    
    public void addNewRound()
    {
        List<Round> oldRounds = new ArrayList<>(this.rounds);
        rounds.add( new Round() );
        changeSupport.firePropertyChange("rounds", oldRounds, rounds);
    }
        
    public void addRound(Round round) {
        List<Round> oldRounds = new ArrayList<>(this.rounds);
        rounds.add(round);
        this.numRounds = rounds.size();
        changeSupport.firePropertyChange("rounds", oldRounds, rounds);
    }

    public void removeLastRound()
    {
        List<Round> oldRounds = new ArrayList<>(this.rounds);
        rounds.remove( rounds.size()-1 );
        this.numRounds = rounds.size();
        changeSupport.firePropertyChange("rounds", oldRounds, rounds);
    }
    
    public void copyProperties(Tournament master)
    {
        setId(master.id);
        setTodaysDate(master.todaysDate);
        setNumRounds (master.numRounds);
        setStore(master.store);
        setOrganizer(master.organizer);
        
        //players = master.players;  //don't change this anywhere
        //rounds = master.rounds; //don't change this anywhere
        setFormat( new EventFormat(master.format) );  //assign to a copy
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
        return "net.geeklythings.fieldmarshal.data.Tournament[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
