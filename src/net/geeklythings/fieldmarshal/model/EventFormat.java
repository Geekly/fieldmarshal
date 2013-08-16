/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.model;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 *
 * @author khooks
 */
@Entity
@Access(AccessType.FIELD)
@Table(name="EVENTFORMAT")
public class EventFormat implements Serializable {
    private static final long serialVersionUID = 1L;
  
    @Column(name="FORMATTYPE")
    protected String formatType = "Steamroller 2013"; //Steamroller, etc..
    @Column(name="FORMATDESCRIPTION")
    protected String formatDescription = "Format Description"; 
    @Column(name="CLOCKTYPE")
    protected String clockType = "Death Clock";
    @Column(name="CLOCKTIME")
    protected int clockTime = 37;  //either turn time or death clock time depending on type
    //@Column(name="NUMROUNDS")
    //protected int numRounds = 6;
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="ID")
    private Long id;

    public EventFormat()
    {
    }
    
    public EventFormat(EventFormat ef)
    {
        formatType = ef.formatType;
        formatDescription = ef.formatDescription;
        clockType = ef.clockType;
        clockTime = ef.clockTime;
        
    }
    //TODO: make this work and make the field transient
    //@Access(AccessType.PROPERTY)
    private String getDescription()
    {
        return String.format("%s, %s,  Time: %d min", formatType, clockType, clockTime);
    }

    @PrePersist
    protected void updateDescription()
    {
        this.formatDescription = this.getDescription();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    
    public String getFormatDescription()
    {
        this.formatDescription = this.getDescription();
        return this.formatDescription;
    }
 
    /*public int getNumRounds() {
        return numRounds;
    }

    public void setNumRounds(int numRounds) {
        this.numRounds = numRounds;
    }
    */
     
    public String getFormatType() {
        return this.formatType;
    }

    public void setFormatType(String formatType) {
        this.formatType = formatType;
    }

    public String getClockType() {
        return this.clockType;
    }

    public void setClockType(String clockType) {
        this.clockType = clockType;
    }

    public int getClockTime() {
        return this.clockTime;
    }

    public void setClockTime(int turnLength) {
        this.clockTime = turnLength;
    }

    public int getDeathClockTime() {
        return this.clockTime;
    }

    public void setDeathClockTime(int deathClockTime) {
        this.clockTime = deathClockTime;
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
