/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.managers;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import net.geeklythings.fieldmarshal.entity.Player;
import net.geeklythings.fieldmarshal.entity.Tournament;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author khooks
 */
public class PlayerManager {
    EntityManager em;
    static final private Logger logger = LogManager.getLogger(PlayerManager.class.getName());
    public PlayerManager(EntityManager em)
    {
        this.em = em;
    }
    
    public boolean AddPlayer(Player player, Tournament tournament)
    {
        /*
         * 1.  Check if player exists in Tournament already
         * 2.  If yes, return false
         * 3.  Persist Player
         * 4.  Add Player to Tournament
         * 5.  Return true
         */
        
        logger.debug("PlayerManager: AddPlayer: {}", player);
        
        if( tournament.getPlayers().contains(player) )
            return false;
        
        em.getTransaction().begin();
        logger.debug("Persisting Player {}", player);
        em.persist(player); //persist the new player
            //this.player = player;
        em.getTransaction().commit();
        //em.close();
        tournament.addPlayer(player);
        //propertyChangeSupport.firePropertyChange("person", oldPerson, this.getPerson());
        return true;

    } 

    
}
