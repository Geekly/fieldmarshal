/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import net.geeklythings.fieldmarshal.data.*;

/**
 *
 * @author khooks
 */
public class TryJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalPU");
        //Tournament activeTournament = TournamentFactory.createTournament(3);
        //EventFormat ef = new EventFormat();
        Player player1 = new Player();
        player1.setFirstName("Bill");
        player1.setLastName("Nye");
        player1.setHomeTown("Science!");

        Player player2 = new Player();
        player2.setFirstName("Neil deGrasse");
        player2.setLastName("Tyson");
        player2.setHomeTown("Bitches");

        Faction faction1 = Faction.CYGNAR;
        Faction faction2 = Faction.KHADOR;
        EntityManager em = emf.createEntityManager();
        try {
            
             
            TypedQuery<Player> query = em.createNamedQuery("Player.findByName", Player.class);
            query.setParameter("first", player1.getFirstName());
            query.setParameter("last", player1.getLastName());
            Player player3 = query.getSingleResult();
            
            Entrant entrant1 = new Entrant();

            entrant1.setPlayer(player3);
            entrant1.setFaction(faction1);

            Entrant entrant2 = new Entrant();
            entrant2.setPlayer(player3);
            entrant2.setFaction(faction2);

            //activeTournament.addPlayer(entrant);

            
        

            em.getTransaction().begin();

            player1.setEmail("notworking@home.com");
            //player1 = (Player)em.merge(player1);
            //player2 = (Player)em.merge(player2);
            //Tournament otherTournament = em.find(Tournament.class, 801L);

            //System.out.println(otherTournament);

            //em.persist(player1);
            //em.persist(player2);
            em.persist(entrant1);
            em.persist(entrant2);
            //em.persist(activeTournament);
            System.out.println(em.contains(player1));

            //next create an entrant and test persistance

            //em.persist(ef);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        //System.out.print(activeTournament);
        emf.close();

    }
}
