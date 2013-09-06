/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import net.geeklythings.fieldmarshal.entity.Player;

/**
 *
 * @author khooks
 */
public class PlayerTableModel extends AbstractTableModel {

    List<Player> players;
    
    public void setPlayers( List<Player> players)
    {
        if( players != null )
        {
            this.players = players;
        }
        else
        {
            this.players = new ArrayList<>();
        }
    }
    
    public List<Player> getPlayers() { return this.players; }
    
    public PlayerTableModel()
    {
        super();
    }
    
    @Override 
    public String getColumnName(int index)
    {
        String value = "";
        switch(index)
        {
            case 0: value = "First Name";
                    break;
            case 1: value = "Last Name";
                    break;
            case 2: value = "Faction";
                    break;
            default: value = "";
                    break;
        }
        return value;
    }
    
    @Override
    public int getRowCount() {
        if( players != null)
        {
            return players.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int i, int j) {
        
        Player player = players.get(i);
        String value = "";
        switch(j)
        {
            case 0: value = player.getFirstName();
                    break;
            case 1: value = player.getLastName();
                    break;
            case 2: value = player.getFaction().getName();
                    break;
            default: value = "";
                    break;
        }
        return value;
    }
    
}
