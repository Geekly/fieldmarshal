/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.geeklythings.fieldmarshal.entity.EventFormat;
import net.geeklythings.fieldmarshal.model.Faction;
import net.geeklythings.fieldmarshal.entity.MatchPairing;
import net.geeklythings.fieldmarshal.entity.Player;
import net.geeklythings.fieldmarshal.entity.PlayerResult;
import net.geeklythings.fieldmarshal.model.ResultType;
import net.geeklythings.fieldmarshal.entity.Round;
import net.geeklythings.fieldmarshal.entity.Tournament;
import net.geeklythings.fieldmarshal.managers.PlayerManager;
import net.geeklythings.fieldmarshal.managers.TournamentManager;
import net.geeklythings.fieldmarshal.model.PlayerStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author khooks
 */
public class TestClasses {

    static final public Logger logger = LogManager.getLogger(TestClasses.class.getName());
    static EntityManager em;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalPU2");
        em = emf.createEntityManager();        
               // TODO code application logic here
        TestClasses test = new TestClasses();
        //test.TestPlayer();
        test.TestTournament();
               
        //test.TestPairings();
        //Player pl2 = new Player("Steve", "Adore");
        //Player et2 = new Player(pl2, Faction.RETRIBUTION);
        //test.TestRound();
        //test.TestPlayerResult();
        //test.TestRound();
        
    }
    
    public void TestPlayer()
    {
        Player pl1 = new Player("Rufus", "McGillicutty", Faction.CIRCLE);
        pl1.setEmail("rufus@warmachine.com");
        pl1.setHomeTown("Dallas");
        //Person et1 = new Person(pl1, Faction.CRYX);
        Player pl2 = new Player();
        
        pl2.setFaction(Faction.CRYX);
        persist(pl2);
        System.out.println(pl1.toString());
        System.out.println(pl2.toString());
    }
    
    public void TestTournament()
    {
        Player pl1 = new Player("Rufus", "McGillicutty", Faction.CIRCLE);
        pl1.setEmail("rufus@warmachine.com");
        pl1.setHomeTown("Dallas");
                
        Player pl2 = new Player("Hank", "Haliburton", Faction.CONVERGENCE);
        pl2.setEmail("hank@warmachine.com");
        pl2.setHomeTown("Toledo");
                  
        Tournament tournament = Tournament.createTournament(3);
        //TournamentManager tm = new TournamentManager(em);
        PlayerManager pm = new PlayerManager(em);
        
        pm.AddPlayer(pl1, tournament);
        pm.AddPlayer(pl2, tournament);
        
        logger.debug("Active Players: {}", tournament.getActivePlayers());
        tournament.dropPlayer(pl1);
        pl2.setActiveStatus(PlayerStatus.INACTIVE);
        logger.debug("Active Players: {}", tournament.getActivePlayers());
        
        persist(tournament);
        //logger.debug(tournament.toString());
    }
    
    public void TestPairings()
    {
        Player pl1 = new Player("Rufus", "McGillicutty", Faction.CIRCLE);   
                
        Player pl2 = new Player("Hank", "Haliburton", Faction.CYGNAR);
        
        Player pl3 = new Player("Wil", "Wheaton", Faction.KHADOR);
        
        Player pl4 = new Player("Stan", "The Man", Faction.MERCS);
        
        
        persist(pl1);
        persist(pl2);       
        persist(pl3);
        persist(pl4);
        
        MatchPairing pairing1 = new MatchPairing();
        pairing1.addPlayer(pl1);
        pairing1.addPlayer(pl2);
        
        MatchPairing pairing2 = new MatchPairing();
        pairing2.addPlayer(pl3);
        pairing2.addPlayer(pl4);
        //pairing.addPlayer(e3);
        
        persist(pairing1);
        persist(pairing2);
        
        System.out.println(pairing1);
        System.out.println(pairing2);
    }
    
    private void TestPlayerResult()
    {
        Player pl1 = new Player("Rufus", "McGillicutty", Faction.CIRCLE);
        pl1.setEmail("rufus@warmachine.com");
        pl1.setHomeTown("Dallas");
                
        Player pl2 = new Player("Hank", "Haliburton", Faction.CONVERGENCE);
        pl2.setEmail("hank@warmachine.com");
        pl2.setHomeTown("Toledo");
        
        PlayerResult pr = new PlayerResult();
        
        
        persist(pl1);
        persist(pl2);
        pr.setPlayer(pl1);
        pr.setOpponent(pl2);
        pr.setResult(ResultType.WIN);  
        pr.setArmyPointsDestroyed(27);
        pr.setListPlayed(1);
        pr.setControlPoints(4);
        
        
    }
    
    private void TestRound() {
        
        Round ro = new Round();
        System.out.println(ro.toString());
    }
    
    public void TestFormat()
    {
        Gson gson = new Gson();
        
        EventFormat ef1 = new EventFormat();
        
        ef1.setId(1245151265L);
        ef1.setClockTime(10);
        ef1.setClockType("Timed Turns");
        ef1.setFormatType("Streamroller 2013");
        
        EventFormat ef2 = new EventFormat(ef1);
        
        ef2.setClockType("Deathclock");
        
        
        Tournament to = new Tournament();
        to.setId(12516L);
        to.setFormat(ef2);
        

        System.out.println(gson.toJson(ef1));
        System.out.println(gson.toJson(ef2));


    }

    public void persist(Object object) {

        //em.open();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            //em.close();
        }
    }




}
