/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.geeklythings.fieldmarshal.controller.exceptions.NonexistentEntityException;
import net.geeklythings.fieldmarshal.model.entity.Round;

/**
 *
 * @author khooks
 */
public class RoundJpaController implements Serializable {

    public RoundJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Round round) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(round);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Round round) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            round = em.merge(round);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = round.getId();
                if (findRound(id) == null) {
                    throw new NonexistentEntityException("The round with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Round round;
            try {
                round = em.getReference(Round.class, id);
                round.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The round with id " + id + " no longer exists.", enfe);
            }
            em.remove(round);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Round> findRoundEntities() {
        return findRoundEntities(true, -1, -1);
    }

    public List<Round> findRoundEntities(int maxResults, int firstResult) {
        return findRoundEntities(false, maxResults, firstResult);
    }

    private List<Round> findRoundEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Round.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Round findRound(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Round.class, id);
        } finally {
            em.close();
        }
    }

    public int getRoundCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Round> rt = cq.from(Round.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
