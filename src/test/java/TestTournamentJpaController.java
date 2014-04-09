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
import org.junit.Test;

/**
 *
 * @author Keith Hooks
 */
public class TestTournamentJpaController {
       
    @Test
    public void testJpaController() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalMySqlPU");
        TournamentJpaController tjc = new TournamentJpaController(emf);
        
        assertNotNull( tjc );
        
        TournamentManager manager = new TournamentManager(tjc);
        Tournament t1 = Tournament.createTournament(3);
        Tournament t2 = Tournament.createTournament(2);
            
        assertNotNull(t1);
        //tjc.create(t1);       
        manager.setTournament(t1);
        manager.setTournament(t2);
        assertNotNull(t1.getId());
        
        //long idAfter = t1.getId();
        System.out.println( t1.toString());
        //assertEquals( idBefore, idAfter );
        
        List<Tournament> tournaments = tjc.findTournamentEntities();
        
        assertEquals( tournaments.size(), 2);
        System.out.println( tournaments.toString());
    }
   
    @Test
    public void testPlayerAddition()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalMySqlPU");
        TournamentJpaController tjc = new TournamentJpaController(emf);
        
        assertNotNull( tjc );
        
        TournamentManager manager = new TournamentManager(tjc);
        Tournament t1 = Tournament.createTournament(3);
            
        assertNotNull(t1);
        
        Player person1 = new Player();
        person1.setFirstName("Greygore");
        person1.setLastName("Boomhowler");
        person1.setHomeTown("Thornwood Kriels");
        System.out.print(person1);
        
        Player person2 = new Player();
        person2.setFirstName("Neil deGrasse");
        person2.setLastName("Tyson");
        person2.setHomeTown("Bitches");
        //System.out.println(person2);
        
        assertTrue( t1.addPlayer(person1) );
        
        assertNull(t1.getId());
        manager.setTournament(t1);
        assertNotNull(t1.getId());  // test to see if player1 was persisted
        
        assertFalse( t1.addPlayer(person1) );      // should fail since the player was already added
        assertTrue( t1.addPlayer(person2) );
        
        System.out.println( (t1.getActivePlayers()).toString() );
        t1.removePlayer(person2);
        
        manager.updateTournament(t1);
        System.out.println( (t1.getActivePlayers()).toString() );
        
        
        
        System.out.println( t1.toString());


    }
}
