/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.managers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import net.geeklythings.fieldmarshal.controller.TournamentJpaController;
import net.geeklythings.fieldmarshal.entity.Tournament;
import net.geeklythings.fieldmarshal.ui.LoadView;
import net.geeklythings.fieldmarshal.ui.PlayersView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ToournamentManager keeps the active Tournament and manages interaction with it.  It 
 * also notifies observers to changes.
 * @author khooks
 */
public class TournamentManager extends Observable implements PropertyChangeListener {

    private static final Logger logger = LogManager.getLogger(TournamentManager.class.getName());
    //public static final String LOAD_TOURNAMENT_ID = "LoadTournamentId";
    private TournamentJpaController tournamentJpaController; 
    private Tournament tournament;
    
    public TournamentManager( EntityManagerFactory emf )
    {
        tournamentJpaController = new TournamentJpaController( emf );
            
    }
    public Tournament getTournament()
    {
        return tournament;
    }
    
    public void setTournament(Tournament t)
    {
        this.tournament = t;
        setChanged();
        notifyObservers(tournament);     
    }
    
    public Tournament LoadTournament(long tournamentId)
    {
            if (tournamentId != 0L)
            {
                logger.debug("Trying to load Tournament {}", tournamentId );
                try {
                    Tournament tournament = (Tournament) tournamentJpaController.findTournament(tournamentId);
                    if (tournament != null)
                    {
                        logger.debug("TournamentManager: NotifyObservers: {}", tournament);
                        //app.setActiveTournament(tournament);
                        //firePropertyChange("activeTournament", null, tournament);
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
        logger.debug("PropertyChangeEvent: {}", pce);
        
        if( pce.getPropertyName().matches(LoadView.LOAD_TOURNAMENT_ID))
        {
            long tournamentId = (long)pce.getNewValue();
            LoadTournament(tournamentId);
            setChanged();
            notifyObservers(tournament);
        }
        else 
        if (pce.getPropertyName().matches(LoadView.NEW_TOURNAMENT_ID))
        {   
            tournament = new Tournament();
            tournamentJpaController.create(tournament);
            setChanged();
            notifyObservers(tournament);
        }
        
        
    }


    
}
