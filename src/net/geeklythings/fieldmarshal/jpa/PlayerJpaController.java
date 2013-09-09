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
import net.geeklythings.fieldmarshal.model.entity.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author khooks
 */
public class PlayerJpaController implements Serializable {

    static final public Logger logger = LogManager.getLogger(PlayerJpaController.class.getName());
    
    public PlayerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

   
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Player player) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(player);
            em.getTransaction().commit();
            logger.debug("Committed Player to DB: {}", player);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Player player) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            player = em.merge(player);
            em.getTransaction().commit();
            logger.debug("Editing Player in DB: {}", player);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = player.getId();
                if (findPlayer(id) == null) {
                    throw new NonexistentEntityException("The player with id " + id + " no longer exists.");
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
            Player player;
            try {
                player = em.getReference(Player.class, id);
                player.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The player with id " + id + " no longer exists.", enfe);
            }
            em.remove(player);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Player> findPlayerEntities() {
        return findPlayerEntities(true, -1, -1);
    }

    public List<Player> findPlayerEntities(int maxResults, int firstResult) {
        return findPlayerEntities(false, maxResults, firstResult);
    }

    private List<Player> findPlayerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Player.class));
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

    public Player findPlayer(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Player.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlayerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Player> rt = cq.from(Player.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
