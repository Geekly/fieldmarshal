package net.geeklythings.fieldmarshal.data;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Entrant implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "ID_Player")
    protected Player player;
    
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
    
    public Entrant(Player addplayer, Faction addfaction) {
        player = addplayer;
        faction = addfaction; 
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