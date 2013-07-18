package net.geeklythings.fieldmarshal.data;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Entity
public class Entrant implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "ID_Player")
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
    
    public Entrant(Player addPlayer, Faction addfaction) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalPU");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT P FROM Player P WHERE P.firstName=?1 AND P.lastName=?2 ");
        query.setParameter(1, addPlayer.getFirstName());
        query.setParameter(2, addPlayer.getLastName());
           
        Player tempPlayer = (Player)query.getSingleResult();
        if( tempPlayer != null) //exists
        {
            player = tempPlayer;
        }
        else
        {   
            player = addPlayer;
        }
        faction = addfaction; 
        
        emf.close();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }
}