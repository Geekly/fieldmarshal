/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.ui;

import java.util.Observable;
import java.util.Observer;
import net.geeklythings.fieldmarshal.entity.Tournament;
import net.geeklythings.fieldmarshal.managers.TournamentManager;
import net.geeklythings.fieldmarshal.model.PlayerTableModel;

/**
 *
 * @author khooks
 */
public class PlayersView extends javax.swing.JPanel implements Observer {

    private TournamentManager manager;
    private Tournament localTournament;  //local scope to the activeTournament
    
    /**
     * Creates new form PlayersView
     */
    public PlayersView() {
        initComponents();
        // be notified when the upper level tournament changes
        
    }

    public void setManager(TournamentManager manager)
    {
        this.manager = manager;
        this.manager.addObserver(this);
        ((PlayerTableModel)tablePlayers.getModel()).setPlayers( localTournament.getPlayers() );
    }
    
    public TournamentManager getManager(){ return this.manager; }
    
    public void setTournament(Tournament t)
    {
        this.localTournament = t;
        updateView();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePlayers = new javax.swing.JTable();
        addPlayerButton = new javax.swing.JButton();

        tablePlayers.setModel(new PlayerTableModel());
        tablePlayers.setName(""); // NOI18N
        tablePlayers.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablePlayers);

        addPlayerButton.setText("Add New Player");
        addPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addPlayerButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(addPlayerButton)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerButtonActionPerformed
        // TODO add your handling code here:
        // insert blank entry into table
        
    }//GEN-LAST:event_addPlayerButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPlayerButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePlayers;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable manager, Object o) {
        if( (manager instanceof TournamentManager) && (o instanceof Tournament) )
        {
            localTournament = ((TournamentManager)manager).getTournament();
            updateView();
        }
    }

    public void updateView() {
        ((PlayerTableModel)tablePlayers.getModel()).fireTableDataChanged();
        //update the modelView of the table
        
    }
}
