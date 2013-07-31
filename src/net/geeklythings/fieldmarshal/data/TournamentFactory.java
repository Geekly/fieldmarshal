package net.geeklythings.fieldmarshal.data;

import java.sql.SQLException;
import org.joda.time.*;

public class TournamentFactory {

    public static Tournament loadTournament(int tournamentID) {

        //TODO:  load the tournament from the database using persistance things
        return null;
    }

    public static Tournament createTournament(int numRounds) {

        Tournament tournament = null;

        tournament = new Tournament();
        
        EventFormat ef = new EventFormat();       
        ef.setNumRounds(numRounds);
        
        tournament.setFormat( ef );
        for( int i=1; i<=numRounds; i++)
        {
            tournament.addRound(new Round(i));
        }

        DateTime today = new DateTime();
        tournament.setTodaysDate(today);

        tournament.setOrganizer("Coleman Stryker");
        tournament.setLocation("Corvis Convention Center");
       

        //TODO: Set up Rounds first


        return tournament;
    }
}
