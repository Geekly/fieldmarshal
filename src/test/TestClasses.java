/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.geeklythings.fieldmarshal.entity.Entrant;
import net.geeklythings.fieldmarshal.entity.EventFormat;
import net.geeklythings.fieldmarshal.model.Faction;
import net.geeklythings.fieldmarshal.entity.MatchPairing;
import net.geeklythings.fieldmarshal.entity.Player;
import net.geeklythings.fieldmarshal.entity.PlayerResult;
import net.geeklythings.fieldmarshal.model.ResultType;
import net.geeklythings.fieldmarshal.entity.Round;
import net.geeklythings.fieldmarshal.entity.Tournament;


/**
 *
 * @author khooks
 */
public class TestClasses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TestClasses test = new TestClasses();
        //test.TestPlayer();
        test.TestPairings();
        //Player pl2 = new Player("Steve", "Adore");
        //Entrant et2 = new Entrant(pl2, Faction.RETRIBUTION);
        //test.TestRound();
        //test.TestPlayerResult();
        //test.TestRound();
        //System.out.println(gson.toJson(ef1));
        //System.out.println(gson.toJson(ef2));
        //System.out.println(gson.toJson(pl1));
        //System.out.println(gson.toJson(et1));
        //System.out.println(gson.toJson(to.getFormat()));   
        //System.out.println(to.toString());
        
    }
    
    public void TestPlayer()
    {
        Player pl1 = new Player("Rufus", "McGillicutty");
        pl1.setEmail("rufus@warmachine.com");
        pl1.setHomeTown("Dallas");
        //Entrant et1 = new Entrant(pl1, Faction.CRYX);
        Entrant et2 = new Entrant();
        et2.setPlayer(pl1);
        et2.setFaction(Faction.CRYX);
        persist(et2);
        System.out.println(pl1.toString());
        System.out.println(et2.toString());
    }
    
    
    public void TestPairings()
    {
        Player pl1 = new Player("Rufus", "McGillicutty");
        Entrant e1 = new Entrant(pl1, Faction.CIRCLE);
                
        Player pl2 = new Player("Hank", "Haliburton");
        Entrant e2 = new Entrant(pl2, Faction.CYGNAR);
        
        Player pl3 = new Player("Wil", "Wheaton");
        Entrant e3 = new Entrant(pl3, Faction.KHADOR);
        
        Player pl4 = new Player("Stan", "The Man");
        Entrant e4 = new Entrant(pl4, Faction.MERCS);
        
        persist(e1);
        persist(e2);       
        persist(e3);
        persist(e4);
        
        MatchPairing pairing1 = new MatchPairing();
        pairing1.addEntrant(e1);
        pairing1.addEntrant(e2);
        
        MatchPairing pairing2 = new MatchPairing();
        pairing2.addEntrant(e3);
        pairing2.addEntrant(e4);
        //pairing.addEntrant(e3);
        
        persist(pairing1);
        persist(pairing2);
        
        System.out.println(pairing1);
        System.out.println(pairing2);
    }
    
    private void TestPlayerResult()
    {
        Player pl1 = new Player("Rufus", "McGillicutty");
        pl1.setEmail("rufus@warmachine.com");
        pl1.setHomeTown("Dallas");
        Entrant e1 = new Entrant(pl1, Faction.CIRCLE);
                
        Player pl2 = new Player("Hank", "Haliburton");
        pl2.setEmail("hank@warmachine.com");
        pl2.setHomeTown("Toledo");
        Entrant e2 = new Entrant(pl2, Faction.CYGNAR);
        
        PlayerResult pr = new PlayerResult();
        
        
        persist(e1);
        persist(e2);
        pr.setPlayer(e1);
        pr.setOpponent(e2);
        pr.setResult(ResultType.WIN);  
        pr.setArmyPointsDestroyed(27);
        pr.setListPlayed(1);
        pr.setControlPoints(4);
        
        
        System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(pr.toString());
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalPU2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }




}
