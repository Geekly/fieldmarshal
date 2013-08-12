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
    private Date todaysDate;
    @Column(name="LOCATION")
    private String location = "Fort Bourne";
    @Column(name="ORGANIZER")
    private String organizer = "Anastasia deBray";
    @Column(name="NUMROUNDS")
    private int numRounds = 4;
    
    @JoinColumn(name="ID_EVENTFORMAT")
    @OneToOne(cascade=CascadeType.PERSIST)
    private EventFormat format;
    
    //@JoinColumn(name="ID_PLAYER")
    @OneToMany(cascade=CascadeType.PERSIST)
    private List<Entrant> players;
    
    //@JoinColumn(name="ID_ROUND")
    @OneToMany(orphanRemoval=true, cascade=CascadeType.ALL) 
    //no reason to keep the rounds after the tournament has been deleted
    private List<Round> rounds;
    
    @Transient
    private int currentRound = 1;


    public Tournament() {
        todaysDate = new Date();    
        //DateUtils.todaysSQLDate();
        //startTime = todaysDate;
        players = new ArrayList<>();
        rounds = new ArrayList<>(numRounds);
    }
    
    public Tournament(Tournament master)
    {
        todaysDate = master.todaysDate;
        numRounds = master.numRounds;
        location = master.location;
        organizer = master.organizer;
        
        // players = master.players;
        // make copies of these rounds = master.rounds;
        // format = master.format;
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
        this.format = format;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        String oldLocation = this.location;
        this.location = location;
        changeSupport.firePropertyChange("location", oldLocation, location);
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

    }
    
    public int getNumRounds() {
        return numRounds;
    }

    
    public void addPlayer(Entrant player) {
        players.add(player);
    }

    public void addNewRound()
    {
        rounds.add( new Round() );
    }
        
    public void addRound(Round round) {
        rounds.add(round);
        this.numRounds = rounds.size();
    }

    public void removeLastRound()
    {
        rounds.remove( rounds.size() );
    }
    
    @Override
    public Tournament clone()
    // Returns a copy of itself
    {
        Tournament clone = new Tournament(this);
        EventFormat newFormat = new EventFormat(this.format);
        clone.setFormat(newFormat);
        return clone;
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
        return "net.geeklythings.fieldmarshal.data.Tournament[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
