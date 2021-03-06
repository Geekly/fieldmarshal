/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


//import com.google.gson.Gson;
import javax.persistence.Persistence;
import net.geeklythings.fieldmarshal.jpa.exceptions.NonexistentEntityException;
import net.geeklythings.fieldmarshal.managers.TournamentManager;
import net.geeklythings.fieldmarshal.model.entity.EventFormat;
import net.geeklythings.fieldmarshal.type.Faction;
import net.geeklythings.fieldmarshal.model.entity.MatchPairing;
import net.geeklythings.fieldmarshal.model.entity.Player;
import net.geeklythings.fieldmarshal.model.entity.PlayerResult;
import net.geeklythings.fieldmarshal.type.ResultType;
import net.geeklythings.fieldmarshal.model.entity.Round;
import net.geeklythings.fieldmarshal.model.entity.Tournament;
import net.geeklythings.fieldmarshal.util.EventListenerLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author khooks
 */
public class TestClasses {

    static final public Logger logger = LogManager.getLogger(TestClasses.class.getName());   
    static final EventListenerLogger eventLogger = new EventListenerLogger();
    //static private EntityManagerFactory emf;
    static private TournamentManager manager;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        
        //emf = Persistence.createEntityManagerFactory("FieldMarshalMySqlPU");
        //manager = new TournamentManager( Persistence.createEntityManagerFactory("FieldMarshalMySqlPU") );
        
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalPU2");
        try {       
               // TODO code application logic here
        TestClasses test = new TestClasses();
        //test.TestPlayer();
        test.TestTournament();
        } catch (Exception e) {}  
        //test.TestPairings();
        //Player pl2 = new Player("Steve", "Adore");
        //Player et2 = new Player(pl2, Faction.RETRIBUTION);
        //test.TestRound();
        //test.TestPlayerResult();
        //test.TestRound();
        
    }
    
    public void TestPlayer()
    {
        //PlayerJpaController jpc = new PlayerJpaController(TestClasses.emf);
        //TournamentJpaController tpc = new TournamentJpaController(TestClasses.emf);
        
        Player pl1 = new Player("Rufus", "McGillicutty", Faction.CIRCLE);
        pl1.setEmail("rufus@warmachine.com");
        pl1.setHomeTown("Dallas");
        
        //jpc.create(pl1);
        //Person et1 = new Person(pl1, Faction.CRYX);
        Player pl2 = new Player();
        
        pl2.setFaction(Faction.CRYX);
        //jpc.create(pl2);
        System.out.println(pl1.toString());
        System.out.println(pl2.toString());
    }
    
    public void TestTournament() throws NonexistentEntityException, Exception
    {
        //PlayerJpaController jpc = new PlayerJpaController(TestClasses.emf);
        //TournamentJpaController tpc = new TournamentJpaController(TestClasses.emf);
        Tournament tournament = Tournament.createTournament(3);
        
        manager.addPropertyChangeListener(eventLogger);
        manager.setTournament(tournament);
        tournament.addPropertyChangeListener(eventLogger);
        
        Player pl1 = new Player("Rufus", "McGillicutty", Faction.CIRCLE);
        pl1.addPropertyChangeListener(eventLogger);
        pl1.setEmail("rufus@warmachine.com");
        pl1.setHomeTown("Dallas");
        //jpc.create(pl1);
                
        Player pl2 = new Player("Hank", "Haliburton", Faction.CONVERGENCE);
        pl2.addPropertyChangeListener(eventLogger);
        pl2.setEmail("hank@warmachine.com");
        pl2.setHomeTown("Toledo");
        //jpc.create(pl2);
        
        tournament.addPlayer(pl1);
        tournament.addPlayer(pl2);
        
        manager.jpaController.edit(tournament);
        
        Player pl3 = new Player("Bill", "Williamson", Faction.LEGION);
        
        tournament.addPlayer(pl3);
        
        manager.jpaController.edit(tournament);
        
        //tournament.addPlayer(pl2);
        //tournament.addPlayer(pl1);
       
        //tpc.create(tournament);
        //tournament.changeSupport.firePropertyChange(null);
        //logger.debug("Active Players: {}", tournament.getActivePlayers());
        //tournament.dropPlayer(pl1);
        //pl2.setActiveStatus(PlayerStatus.INACTIVE);
        //logger.debug("Active Players: {}", tournament.getActivePlayers());
       
        //manager.getJpaController().edit(tournament);
        //logger.debug(tournament.toString());
    }
    
    public void TestPairings()
    {
        
        //PlayerJpaController jpc = new PlayerJpaController(TestClasses.emf);
        //TournamentJpaController tpc = new TournamentJpaController(TestClasses.emf);
        
        Player pl1 = new Player("Rufus", "McGillicutty", Faction.CIRCLE);   
                
        Player pl2 = new Player("Hank", "Haliburton", Faction.CYGNAR);
        
        Player pl3 = new Player("Wil", "Wheaton", Faction.KHADOR);
        
        Player pl4 = new Player("Stan", "The Man", Faction.MERCS);
        
        //jpc.create(pl1);
        //jpc.create(pl2);
        //jpc.create(pl3);
        //jpc.create(pl4);
        
        MatchPairing pairing1 = new MatchPairing();
        pairing1.addPlayer(pl1);
        pairing1.addPlayer(pl2);
        
        MatchPairing pairing2 = new MatchPairing();
        pairing2.addPlayer(pl3);
        pairing2.addPlayer(pl4);
        //pairing.addPlayer(e3);
        
        //persist(pairing1);
        //persist(pairing2);
        
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
        
        
        //persist(pl1);
        //persist(pl2);
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
        //Gson gson = new Gson();
        
        EventFormat ef1 = new EventFormat();
        
        //ef1.setId(1245151265L);
        ef1.setClockTime(10);
        ef1.setClockType("Timed Turns");
        ef1.setFormatType("Streamroller 2013");
        
        EventFormat ef2 = new EventFormat(ef1);
        
        ef2.setClockType("Deathclock");
        
        
        Tournament to = Tournament.createTournament(3);
        to.setId(12516L);
        to.setFormat(ef2);
        

        //System.out.println(gson.toJson(ef1));
        //System.out.println(gson.toJson(ef2));


    }




}
