/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;

/**
 * A Pairing represents two players
 * @author khooks
 */
@Entity
public class MatchPairing implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade=CascadeType.MERGE)
    Set<Entrant> pairs = new HashSet<>();

    @OneToOne(cascade=CascadeType.ALL)
    MatchResult result = new MatchResult();

    public MatchResult getResult() {
        return result;
    }

    public void setResult(MatchResult result) {
        this.result = result;
    }
    
    public Set<Entrant> getPairs() {
        return pairs;
    }
    
    public boolean addEntrant(Entrant entrant)
    {      
        //check if Entrant is persisted.  
        try {
            if ( pairs.size() < 2 )
            {          
                if (entrant.getId() == null) // not persisted yet
                {
                    //persist(entrant);
                    throw new Exception("Entrant should be persisted before adding to Pairing");
                }                      
                pairs.add(entrant);
                return true;
            }
            else
            { 
                throw new Exception("Cannot exceed two entrants per pairing");
            }
        } catch (Exception e) {e.printStackTrace();}
        return false;
    }
    
    public void removeEntrant(Entrant entrant)
    {
        pairs.remove(entrant);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatchPairing)) {
            return false;
        }
        MatchPairing other = (MatchPairing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pairing{" + "id=" + id + ", pairs=" + pairs + '}';
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
