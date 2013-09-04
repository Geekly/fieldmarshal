package net.geeklythings.fieldmarshal.entity;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Transient;
import net.geeklythings.fieldmarshal.model.PlayerStatus;
import net.geeklythings.fieldmarshal.model.Faction;

@Entity
@Access(AccessType.FIELD)
@Table(name="PLAYER")
public class Player implements Serializable {

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", person=" + person + ", faction=" + faction + ", activeStatus=" + activeStatus + '}';
    }
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @JoinColumn(name = "ID_PERSON")
    @ManyToOne(cascade= { CascadeType.MERGE })
    private Person person;
    
    @Enumerated(EnumType.STRING)
    protected Faction faction;
    
    @Column(name="LASTROUNDPLAYED")
    private int lastRoundPlayed = 1;

    @OneToMany(cascade = {CascadeType.MERGE}) 
    private List<PlayerResult> results = new ArrayList<>();

    /**
     * Get the value of results
     *
     * @return the value of results
     */
    public List<PlayerResult> getResults() {
        return results;
    }

    /**
     * Set the value of results
     *
     * @param results new value of results
     */
    public void setResults(List<PlayerResult> results) {
        this.results = results;
    }
    
    public int getLastRoundPlayed() {
        return lastRoundPlayed;
    }

    public void setLastRoundPlayed(int lastRoundPlayed) {
        this.lastRoundPlayed = lastRoundPlayed;
    }
       
    @Transient
    private final PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    @Transient
    private PlayerStatus activeStatus = PlayerStatus.ACTIVE;
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player(){}
    
    public Player(Person addPerson, Faction addfaction) {
        //When creating a new Player, we don't want to use an existing person if possible

        this.setPerson(addPerson);
        this.faction = addfaction;   
    }

    public int getWins(){return 0;}
    
    public int getLosses() {return 0;}
    
    public int getStandings(){return 0;
    }
    
    public Person getPerson() {
        return person;
    }

    public final void setPerson(Person person) {
        // add an un-persisted person 
        try {
            
            Person oldPerson = this.getPerson();
        
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("FieldMarshalPU2");
            EntityManager em = emf.createEntityManager();

            Query query = em.createQuery("SELECT P FROM Person P WHERE P.firstName=?1 AND P.lastName=?2 ");
            query.setParameter(1, person.getFirstName());
            query.setParameter(2, person.getLastName());

            Person tempPerson = null; 
            //check if this person already exists in the database
            try {
                tempPerson = (Person)query.getSingleResult();
            } catch (NoResultException e) {
                //no result found
            } 

            em.getTransaction().begin();
            if( tempPerson == null) //no records found, doesn't exist
            {   
                em.persist(person); //persist the new person
            }
            else // person exists in the database
            {
                person = em.merge(tempPerson);
            }
            this.person = person;
            em.getTransaction().commit();
            emf.close();
            propertyChangeSupport.firePropertyChange("person", oldPerson, this.getPerson());

            } 
        catch( Exception e) { 
            e.printStackTrace(); 
        }
            
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        Faction oldFaction = this.faction;
        this.faction = faction;
        propertyChangeSupport.firePropertyChange("faction", oldFaction, this.faction);
    }

    public PlayerStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(PlayerStatus activeStatus) {
        this.activeStatus = activeStatus;
    }
  
    
}