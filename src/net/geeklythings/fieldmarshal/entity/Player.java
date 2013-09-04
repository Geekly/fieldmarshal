package net.geeklythings.fieldmarshal.entity;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.NamedQuery;
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
@NamedQuery(name="Player.findByName", query="SELECT p FROM Player p WHERE p.firstName LIKE :first AND p.lastName LIKE :last")
public class Player implements Serializable {



    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", homeTown=" + homeTown + ", faction=" + faction + ", lastRoundPlayed=" + lastRoundPlayed + ", activeStatus=" + activeStatus + '}';
    }
  
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
    
    @Column(name="FIRSTNAME")
    private String firstName;
    @Column(name="LASTNAME")
    private String lastName;
    @Column(name="EMAIL")
    private String email;
    @Column(name="HOMETOWN")
    private String homeTown;
    
    /*@JoinColumn(name = "ID_PERSON")
    @ManyToOne(cascade= { CascadeType.MERGE })
    private Person person;*/
    
    @Enumerated(EnumType.STRING)
    @Column(name="FACTION")
    private Faction faction;
    
    @Column(name="LASTROUNDPLAYED")
    private int lastRoundPlayed = 1;

    //@OneToMany(cascade = {CascadeType.MERGE}) 
    // TODO: make this persisted
    @Transient
    private List<PlayerResult> results = new ArrayList<>();
  
    @Transient
    private final PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    @Transient
    private PlayerStatus activeStatus = PlayerStatus.ACTIVE;
   
    
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player(){}
    
    public Player(String firstName, String lastName, Faction addfaction) {
        //When creating a new Player, we don't want to use an existing person if possible

        this.firstName = firstName;
        this.lastName = lastName;
        this.faction = addfaction;   
    }

    public int getWins(){return 0;}
    
    public int getLosses() {return 0;}
    
    public int getStandings(){return 0;    }
    

   /* public final void setPerson(Person person) {
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
    */
    
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
  
     public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if ( this == obj)
            return true;
        if ( obj == null)
            return false;
        if ( obj.getClass() != getClass() )
            return false;
        //Player player = (Player)obj;
        if ( this.hashCode() == obj.hashCode() )
        {
            return true;
        }
 
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.firstName);
        hash = 83 * hash + Objects.hashCode(this.lastName);
        return hash;
    }
    
}
