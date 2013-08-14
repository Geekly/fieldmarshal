package net.geeklythings.fieldmarshal.data;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Access(AccessType.FIELD)
@Table(name="ENTRANT")
public class Entrant implements Serializable {

    private static final long serialVersionUID = 1L;

    
    @JoinColumn(name = "ID_PLAYER")
    @ManyToOne(cascade= { CascadeType.MERGE })
    private Player player;
   
    @Enumerated(EnumType.STRING)
    protected Faction faction;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Transient
    private final PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entrant(){}
    
    public Entrant(Player addPlayer, Faction addfaction) {
        //When creating a new Entrant, we don't want to use an existing player if possible

        this.setPlayer(addPlayer);
        this.setFaction(addfaction);   
    }

    public Player getPlayer() {
        return player;
    }

    public final void setPlayer(Player player) {
        
        Player oldPlayer = this.getPlayer();
        
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalPU2");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT P FROM Player P WHERE P.firstName=?1 AND P.lastName=?2 ");
        query.setParameter(1, player.getFirstName());
        query.setParameter(2, player.getLastName());
        
        Player tempPlayer = null; 
        try {
            tempPlayer = (Player)query.getSingleResult();
        } catch (NoResultException e) {
            //no result found
        } 
        
        em.getTransaction().begin();
        if( tempPlayer == null) //no records found, doesn't exist
        {   
            em.persist(player);  //persist the new player
            this.player = player;
        }
        else // player exists int the database
        {
            player = em.merge(player);
            this.player = player;
        }
        em.getTransaction().commit();
        emf.close();
        
        propertyChangeSupport.firePropertyChange("player", oldPlayer, this.getPlayer());
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        Faction oldFaction = this.faction;
        this.faction = faction;
        propertyChangeSupport.firePropertyChange("faction", oldFaction, this.faction);
    }
}