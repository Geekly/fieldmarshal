/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.geeklythings.fieldmarshal.jpa.TournamentJpaController;
import net.geeklythings.fieldmarshal.managers.TournamentManager;
import net.geeklythings.fieldmarshal.model.entity.Player;
import net.geeklythings.fieldmarshal.model.entity.Tournament;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

/**
 *
 * @author Keith Hooks
 */
public class TestTournamentManager {

    static EntityManagerFactory emf;    
    static TournamentJpaController tjc;  
    static TournamentManager manager;
    
    @BeforeClass
    public static void setupDatabase()
    {   
        emf = Persistence.createEntityManagerFactory("FieldMarshalMySqlPU");
        tjc = new TournamentJpaController(emf);
        assertNotNull( tjc );
        manager = new TournamentManager(tjc);
        assertNotNull( manager );
        Tournament t1 = Tournament.createTournament(3);
        Tournament t2 = Tournament.createTournament(2);
        manager.setTournament(t1);
        
        Player person1 = new Player();
        person1.setFirstName("Greygore");
        person1.setLastName("Boomhowler");
        person1.setHomeTown("Thornwood");
        
        Player person2 = new Player();
        person2.setFirstName("Neil deGrasse");
        person2.setLastName("Tyson");
        person2.setHomeTown("Bitches");
        
        Player person3 = new Player();
        person3.setFirstName("Sam");
        person3.setLastName("McHorne");
        person3.setHomeTown("Caspia");
        
        t1.addPlayer(person1);
        t1.addPlayer(person2);
        t1.addPlayer(person3);
        
        manager.updateTournament(t1);
        
        
        
        
    }
    
    @Test
    public void testJpaController() {
        
        
        
        Tournament t1 = Tournament.createTournament(3);
        Tournament t2 = Tournament.createTournament(2);
            
        assertNotNull(t1);
        //tjc.create(t1);       
        manager.setTournament(t1);
        manager.setTournament(t2);
        assertNotNull(t1.getId());
        
        //long idAfter = t1.getId();
        System.out.println( t1.toString());

        List<Tournament> tournaments = tjc.findTournamentEntities();
        System.out.println("Number of tournaments: " + tournaments.size());
    }
   
    /**
     * Try adding from Tournament and TournamentManager
     */
    @Test
    public void testPlayerAddition()
    {  
        assertNotNull( tjc );
        
        Tournament t1 = manager.getTournament();
        assertNotNull(t1);
        
        Player person1 = new Player();
        person1.setFirstName("Jason");
        person1.setLastName("Vorhees");
        person1.setHomeTown("Camp Webaway");
        
        manager.getTournament().addPlayer(person1);
        manager.updateTournament(t1);
    
        assertFalse( "Trying to add same player twice", t1.addPlayer(person1) );        
        assertFalse( t1.addPlayer(person1) );      // should fail since the player was already added

        for( Player p: t1.getActivePlayers() )
        {
            System.out.println(p.toString());
        }
    }
}
