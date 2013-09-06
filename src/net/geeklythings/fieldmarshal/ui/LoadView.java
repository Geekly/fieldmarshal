/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.ui;


//import java.util.logging.ConsoleHandler;
//import java.util.logging.Handler;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.geeklythings.fieldmarshal.controller.TournamentJpaController;
import net.geeklythings.fieldmarshal.entity.Tournament;
import net.geeklythings.fieldmarshal.managers.TournamentManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author khooks
 */
public class LoadView extends javax.swing.JPanel implements ListSelectionListener {

    private TournamentJpaController jpaController;
    public static final String LOAD_TOURNAMENT_ID = "LoadTournamentId";
    public static final String NEW_TOURNAMENT_ID = "NewTournamentId";
    private static final Logger logger = LogManager.getLogger(LoadView.class.getName());
    private List<Tournament> tournamentList;
    private long selectedTournamentId = 0L;
    
    public long getSelectedTournamentID() {
        return selectedTournamentId;
    }
    
    /**
     * Creates new form LoadView
     */
    /*public LoadView() {
        
        initComponents();
        //updateList();
        //tournamentList = new ArrayList<>();
        
        tournamentJList.addListSelectionListener(this);
    }*/
          
    public LoadView( TournamentJpaController tjc ) {
        
        this.jpaController = tjc;
        initComponents();
       
        tournamentJList.addListSelectionListener(this);
    }
    
    public void updateList()
    {
        // load the contents of the tournaments from the DB and display them in the list

        //Query query = em.createQuery("SELECT t FROM Tournament t");
        //tournamentList = query.getResultList();
        
        DefaultListModel listModel;
        listModel = new DefaultListModel();      
        tournamentList = jpaController.findTournamentEntities();
        logger.debug(tournamentList.toString());
        String listString = null;
        // Assumption:  index of tournamentList and the JList model are always equal
        if( tournamentList != null){
            for(Tournament t: tournamentList ){            
                listString = String.format("Id: %d, Location: %s, Organizer: %s, Date: %s", 
                        t.getId(), t.getStore(), t.getOrganizer(), t.getTodaysDate());
                listModel.addElement(listString);
            }
        }
        
        tournamentJList.setModel(listModel);
        
    }
    

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        logger.debug(lse.toString());
        if(!lse.getValueIsAdjusting())
        {

            int row = tournamentJList.getSelectedIndex();
            logger.debug("Selected row {}", row);
                   
            String tournamentString = (String)tournamentJList.getModel().getElementAt(row);
            Long id = tournamentList.get(row).getId();
            selectedTournamentId = id;
            
            logger.debug("Tournament selected, ID: {}", id);
         
            loadButton.setEnabled(true);
        }
       
    }
    
    private void nextPane()
    {
        JTabbedPane pane = (JTabbedPane) this.getParent();
        pane.setSelectedIndex( pane.getSelectedIndex() + 1);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tournamentJList = new javax.swing.JList();
        newTournamentButton = new javax.swing.JButton();

        loadButton.setText("Load Existing");
        loadButton.setEnabled(false);
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        tournamentJList.setBorder(javax.swing.BorderFactory.createTitledBorder("Available Tournaments"));
        tournamentJList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tournamentJList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        tournamentJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tournamentJList);

        newTournamentButton.setText("New Tournament");
        newTournamentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTournamentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newTournamentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loadButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadButton)
                    .addComponent(newTournamentButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        // notify the tournament manager that a tournament Id was selected & read
        // and to load the tournament
        firePropertyChange(LOAD_TOURNAMENT_ID, 0L, selectedTournamentId);
        nextPane();
    }//GEN-LAST:event_loadButtonActionPerformed

    private void newTournamentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTournamentButtonActionPerformed
        // TODO add your handling code here:
        firePropertyChange(NEW_TOURNAMENT_ID, 0L, 1L);
        nextPane();
    }//GEN-LAST:event_newTournamentButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton newTournamentButton;
    private javax.swing.JList tournamentJList;
    // End of variables declaration//GEN-END:variables



}
