/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.geeklythings.fieldmarshal.controller.exceptions.NonexistentEntityException;
import net.geeklythings.fieldmarshal.entity.EventFormat;

/**
 *
 * @author khooks
 */
public class EventFormatJpaController implements Serializable {

    public EventFormatJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EventFormat eventFormat) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(eventFormat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EventFormat eventFormat) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            eventFormat = em.merge(eventFormat);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = eventFormat.getId();
                if (findEventFormat(id) == null) {
                    throw new NonexistentEntityException("The eventFormat with id " + id + " no longer exists.");
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
            EventFormat eventFormat;
            try {
                eventFormat = em.getReference(EventFormat.class, id);
                eventFormat.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The eventFormat with id " + id + " no longer exists.", enfe);
            }
            em.remove(eventFormat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EventFormat> findEventFormatEntities() {
        return findEventFormatEntities(true, -1, -1);
    }

    public List<EventFormat> findEventFormatEntities(int maxResults, int firstResult) {
        return findEventFormatEntities(false, maxResults, firstResult);
    }

    private List<EventFormat> findEventFormatEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EventFormat.class));
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

    public EventFormat findEventFormat(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EventFormat.class, id);
        } finally {
            em.close();
        }
    }

    public int getEventFormatCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EventFormat> rt = cq.from(EventFormat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
