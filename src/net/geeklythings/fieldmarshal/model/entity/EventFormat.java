/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.model.entity;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

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

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

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
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }
    

    
    public String getFormatDescription()
    {
        this.formatDescription = this.getDescription();
        return this.formatDescription;
    }
 
     
    public String getFormatType() {
        return this.formatType;
    }

    public void setFormatType(String formatType) {
        String oldValue = this.formatType;
        this.formatType = formatType;      
        changeSupport.firePropertyChange("formatType", oldValue, formatType);
    }

    public String getClockType() {
        return this.clockType;
    }

    public void setClockType(String clockType) {
        String oldValue = this.clockType;
        this.clockType = clockType;
        changeSupport.firePropertyChange("clockType", oldValue, clockType);
    }

    public int getClockTime() {
        return this.clockTime;
    }

    public void setClockTime(int turnLength) {
        int oldValue = this.clockTime;
        this.clockTime = turnLength;
        changeSupport.firePropertyChange("clockTime", oldValue, clockTime);
    }

    public int getDeathClockTime() {
        return this.clockTime;
    }

    public void setDeathClockTime(int deathClockTime) {
        int oldValue = this.clockTime;
        this.clockTime = deathClockTime;
        changeSupport.firePropertyChange("clockTime", oldValue, clockTime);
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
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
