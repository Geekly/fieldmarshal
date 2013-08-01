package net.geeklythings.fieldmarshal.data;

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
import javax.persistence.NoResultException;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

@Entity
@Access(AccessType.FIELD)
@Table(name="ENTRANT")
public class Entrant implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToOne   //(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ID_PLAYER")
    protected Player player;
   
    @Enumerated(EnumType.STRING)
    protected Faction faction;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entrant(){}
    
    /*public Entrant(Player addPlayer, Faction addfaction) {
        //When creating a new Entrant, we don't want to use an existing player if possible

        this.setPlayer(addPlayer);
        this.faction = addfaction;   
    }*/

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalPU");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT P FROM Player P WHERE P.firstName=?1 AND P.lastName=?2 ");
        query.setParameter(1, player.getFirstName());
        query.setParameter(2, player.getLastName());
        
        Player tempPlayer = null; 
        try {
            tempPlayer = (Player)query.getSingleResult();
        } catch (NoResultException e) {
            
        } 
        if( tempPlayer == null) //exists
        {   
            this.player = player;
        }
        else
        {
            this.player = tempPlayer;
        }
         
        emf.close();
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }
}