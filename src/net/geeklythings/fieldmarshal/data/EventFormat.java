/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author khooks
 */
@Entity
public class EventFormat implements Serializable {
    private static final long serialVersionUID = 1L;
  
    protected String formatType = "Steamroller 2013"; //Steamroller, etc...
    protected String timeFormat = "Death Clock";
    protected int turnLength = 4;
    protected int clockTime = 37;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EventFormatID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    protected int numRounds = 6;

    public int getNumRounds() {
        return numRounds;
    }

    public void setNumRounds(int numRounds) {
        this.numRounds = numRounds;
    }

    public String getFormatType() {
        return formatType;
    }

    public void setFormatType(String formatType) {
        this.formatType = formatType;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public int getTurnLength() {
        return turnLength;
    }

    public void setTurnLength(int turnLength) {
        this.turnLength = turnLength;
    }

    public int getDeathClockTime() {
        return clockTime;
    }

    public void setDeathClockTime(int deathClockTime) {
        this.clockTime = deathClockTime;
    }
    public String getDescription()
    {
        return String.format("$s, $s, $i rounds, Time: $i minutes", formatType, timeFormat, numRounds, clockTime);
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
        if (!(object instanceof EventFormat)) {
            return false;
        }
        EventFormat other = (EventFormat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.geeklythings.fieldmarshal.data.EventFormat[ id=" + id + " ]";
    }
    
}
