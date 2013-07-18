/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

        Tournament activeTournament = TournamentFactory.createTournament(3);
        EventFormat ef = new EventFormat();
        Player player = new Player();
        player.setFirstName("Bill");
        player.setLastName("Nye");
        player.setHomeTown("Science!");
        
        Faction faction = Faction.CYGNAR;
        
        Entrant entrant = new Entrant(player, faction);
        
        activeTournament.addPlayer(entrant);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //Tournament otherTournament = em.find(Tournament.class, 801L);
        
        //System.out.println(otherTournament);
        
        //em.persist(player);
        em.persist(entrant);
        //em.persist(activeTournament);
        
        //next create an entrant and test persistance
        
        //em.persist(ef);
        em.getTransaction().commit();
        emf.close();
        
        //System.out.print(activeTournament);


    }
}
