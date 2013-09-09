/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.model;

import java.util.Observable;
import net.geeklythings.fieldmarshal.model.entity.Tournament;

/**
 *
 * @author khooks
 */
public class TournamentHolder extends Observable{
    private Tournament tournament;

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
