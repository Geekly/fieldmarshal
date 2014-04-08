/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.managers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManagerFactory;
import net.geeklythings.fieldmarshal.jpa.exceptions.NonexistentEntityException;
import net.geeklythings.fieldmarshal.jpa.TournamentJpaController;
import net.geeklythings.fieldmarshal.model.entity.Tournament;
import net.geeklythings.fieldmarshal.ui.LoadView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ToournamentManager keeps the active Tournament and manages interaction with it.  It 
 * also notifies observers to changes and is notified by the Tournament object when it changes.
 * @author khooks
 */
public class TournamentManager implements PropertyChangeListener {

    // tournament notifies the manager of a change, and the manager persists it
    
    private static final Logger logger = LogManager.getLogger(TournamentManager.class.getName());
    private final PropertyChangeSupport changeSupport = new java.beans.PropertyChangeSupport(this);
    
    //public static final String LOAD_TOURNAMENT_ID = "LoadTournamentId";
    public TournamentJpaController jpaController; 
    private Tournament tournament;
    
    public TournamentManager( EntityManagerFactory emf )
    {
        jpaController = new TournamentJpaController( emf );
            
    }
    public Tournament getTournament()
    {
        return tournament;
    }
    
    public List<Tournament> getAllTournaments()
    {
        return jpaController.findTournamentEntities();
    }
    
    public void setTournament(Tournament t)
    /* Assumes that t does not exist in the database yet
     */
    {      
        if( this.tournament != null )
        {
            this.tournament.removePropertyChangeListener(this);
        }
        
        this.tournament = t;
        this.tournament.addPropertyChangeListener(this);
        changeSupport.firePropertyChange("setTournament", null, this.tournament);
        jpaController.create(this.tournament);
    }
    
    public Tournament LoadTournament(long tournamentId)
    /* loaded tournament will be persisted by default 
     * 
     */
    {
            if (tournamentId != 0L)
            {
                logger.debug("Trying to load Tournament {}", tournamentId );
                try {
                    Tournament tournament = (Tournament) jpaController.findTournament(tournamentId);
                    if (tournament != null)
                    {
                        logger.debug("TournamentManager: NotifyObservers: {}", tournament);
                        //app.setActiveTournament(tournament);
                        changeSupport.firePropertyChange("activeTournament", null, tournament);
                        //setChanged();
                        //notifyObservers(tournament);
                        this.tournament = tournament;
                        
                        return tournament;
                    } 
                } 
                catch (Exception e) 
                {
                }
                 
            }
            return null;
    }
    

    
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        logger.debug("TournamentManager: propertyChange: {} from class: {}", pce.getPropertyName(), pce.getSource().getClass().getName());
        
        if( pce.getPropertyName().matches(LoadView.LOAD_TOURNAMENT_ID))
        {
            long tournamentId = (long)pce.getNewValue();
            LoadTournament(tournamentId);
            changeSupport.firePropertyChange( "loadTournament", null, tournament);
        }
        else 
        if (pce.getPropertyName().matches(LoadView.NEW_TOURNAMENT_ID))
        {   
            tournament = new Tournament();
            jpaController.create(tournament);
            changeSupport.firePropertyChange( "newTournament", null, tournament);

        }
        if( pce.getPropertyName().matches(Tournament.ADDPLAYER))
        {   
            try {
                // players were added
                jpaController.edit(tournament);
                changeSupport.firePropertyChange( "addPlayer", null, tournament);
            } catch (NonexistentEntityException ex) {
                java.util.logging.Logger.getLogger(TournamentManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(TournamentManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    
}
