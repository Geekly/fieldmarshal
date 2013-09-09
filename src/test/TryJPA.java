/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import net.geeklythings.fieldmarshal.entity.Player;
import net.geeklythings.fieldmarshal.type.Faction;
import net.geeklythings.fieldmarshal.entity.Tournament;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalPU2");
        //Tournament activeTournament = TournamentFactory.createTournament(3);
        //EventFormat ef = new EventFormat();
        Player person1 = new Player();
        person1.setFirstName("Greygore");
        person1.setLastName("Boomhowler");
        person1.setHomeTown("Thornwood Kriels");

        Player person2 = new Player();
        person2.setFirstName("Neil deGrasse");
        person2.setLastName("Tyson");
        person2.setHomeTown("Bitches");
        
        Faction faction1 = Faction.TROLLS;
        Faction faction2 = Faction.KHADOR;
        Faction faction3 = Faction.MENOTH;
        
        EntityManager em = emf.createEntityManager();
        try {
            
             
            TypedQuery<Player> query = em.createNamedQuery("Player.findByName", Player.class);
            query.setParameter("first", person1.getFirstName());
            query.setParameter("last", person1.getLastName());
            Player player3 = query.getSingleResult();
            
            Player player1 = new Player();

            //player1.setPerson(person3);
            //player1.setFaction(faction1);

            //Player player2 = new Player();
            //player2.setPerson(person3);
            //player2.setFaction(faction2);

            
            //activeTournament.addPerson(player);

            
            Tournament to = new Tournament();
            Date today = to.getTodaysDate();
            System.out.println(to.getTodaysDate());
            System.out.println(to.getTodaysDate().toString());
            System.out.println(today.getTime());
            em.getTransaction().begin();

            person1.setEmail("notworking@home.com");
            //person1 = (Person)em.merge(person1);
            //person2 = (Person)em.merge(person2);
            //Tournament otherTournament = em.find(Tournament.class, 801L);
            Query q = em.createQuery("SELECT t from Tournament t");
            //List<Tournament> tournamentList = q.getResultList();
            //System.out.println(otherTournament);

            //em.persist(person1);
            //em.persist(person2);
            //em.persist(person3);
            //em.persist(player1);
            //em.persist(player2);
            em.persist(to);
            //em.persist(activeTournament);
            //System.out.println(em.contains(person1));

            //next create an player and test persistance

            //em.persist(ef);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        //System.out.print(activeTournament);
        emf.close();

    }
}
