/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import net.geeklythings.fieldmarshal.model.entity.Player;

/**
 *
 * @author khooks
 */
public class Players {
    
    private ArrayList<Player> players;

    /**
     * Get the value of players
     *
     * @return the value of players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }  
    
    /**
     * Set the value of players
     *
     * @param players new value of players
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    
    public void addPlayer(Player player)
    {
        players.add(player);
    }
    
    public void removePlayer(Player player)
    {
        // TODO: if exists
        players.remove(player);
    }
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
