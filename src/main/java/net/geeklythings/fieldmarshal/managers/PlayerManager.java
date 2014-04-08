/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.managers;

import javax.persistence.EntityManagerFactory;
import net.geeklythings.fieldmarshal.model.entity.Player;
import net.geeklythings.fieldmarshal.model.entity.Tournament;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author khooks
 */
public class PlayerManager {
    //private PlayerJpaController pjc;
    static final private Logger logger = LogManager.getLogger(PlayerManager.class.getName());
    public PlayerManager(EntityManagerFactory emf)
    {
        //pjc = new PlayerJpaController( emf );
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
        {
            return false;
        }       
        
        //pjc.create(player);
        tournament.addPlayer(player);
        //propertyChangeSupport.firePropertyChange("person", oldPerson, this.getPerson());
        return true;

    } 

    
}
