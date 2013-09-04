/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.managers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import net.geeklythings.fieldmarshal.entity.Tournament;
import net.geeklythings.fieldmarshal.ui.FieldMarshal;
import net.geeklythings.fieldmarshal.ui.LoadTournamentView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author khooks
 */
public class TournamentController implements PropertyChangeListener {

    private static final Logger logger = LogManager.getLogger(TournamentController.class.getName());
    //public static final String LOAD_TOURNAMENT_ID = "LoadTournamentId";
    
    private FieldMarshal app;
    
    public void LoadTournament(long tournamentId)
    {
            if (tournamentId != 0L)
            {
            
                logger.debug("Trying to load Tournament {}", tournamentId );
                try {
                    Tournament tournament = (Tournament) app.getEntityManager().find(Tournament.class, tournamentId);
                    if (tournament != null)
                    {
                        app.setActiveTournament(tournament);
                        //firePropertyChange("activeTournament", null, tournament);
                    } 
                } 
                catch (Exception e) 
                {
                }
                 
            }
    }
    
    public TournamentController(FieldMarshal app)
    {
        this.app = app;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        logger.debug("PropertyChangeEvent: {}", pce);
        
        if( pce.getPropertyName().matches(LoadTournamentView.LOAD_TOURNAMENT_ID))
        {
            long tournamentId = (long)pce.getNewValue();
            LoadTournament(tournamentId);

        }
        
    }

    
}
