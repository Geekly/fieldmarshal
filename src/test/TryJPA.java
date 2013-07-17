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

        //Tournament activeTournament = TournamentFactory.createTournament(4);
        EventFormat ef = new EventFormat();
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        
        
        
        
        em.persist(ef);
        em.getTransaction().commit();
        emf.close();
        
        //System.out.print(activeTournament);


    }
}
