/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;

/**
 *
 * @author khooks
 */
@Entity
public class Tournament implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    private DateTime todaysDate = new DateTime();
    private MutableDateTime startTime = new MutableDateTime();
    private String location = "Fort Bourne";
    private String organizer = "Anastasia deBray";
    private int numRounds;
    
    @JoinColumn(name="ID_EventFormat")
    @OneToOne(cascade=CascadeType.PERSIST)
    private EventFormat format;
    
    @OneToMany(cascade=CascadeType.PERSIST)
    private List<Entrant> players;
    
    @OneToMany(orphanRemoval=true, cascade=CascadeType.ALL) //no reason to keep the rounds after the tournament has been deleted
    private List<Round> rounds;
    @Transient
    private int currentRound = 1;


    public Tournament() {
        players = new ArrayList<>();
        rounds = new ArrayList<>();
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

    public DateTime getTodaysDate() {
        return todaysDate;
    }

    public void setTodaysDate(DateTime todaysDate) {
        DateTime oldTodaysDate = this.todaysDate;
        this.todaysDate = todaysDate;
        changeSupport.firePropertyChange("todaysDate", oldTodaysDate, todaysDate);
    }

    public MutableDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(MutableDateTime startTime) {
        MutableDateTime oldStartTime = this.startTime;
        this.startTime = startTime;
        changeSupport.firePropertyChange("startTime", oldStartTime, startTime);
    }

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

    public int getNumRounds() {
        return format.getNumRounds();
    }

    public void addPlayer(Entrant player) {
        players.add(player);
    }

    public void addRound(Round round) {
        rounds.add(round);
        this.numRounds = rounds.size();
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
