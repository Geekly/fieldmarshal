/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.ui;


//import java.util.logging.ConsoleHandler;
//import java.util.logging.Handler;
//import java.util.logging.Level;
//import java.util.logging.Logger;


import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.simple.SimpleLogger;

/**
 *
 * @author khooks
 */
public class LoadTournamentView extends javax.swing.JPanel implements ListSelectionListener {

    public static final String LOAD_TOURNAMENT_ID = "LoadTournamentId"; 
             
    private static final Logger logger = LogManager.getLogger(LoadTournamentView.class.getName());
   
    private long selectedTournamentId = 0L;

    public long getSelectedTournamentID() {
        return selectedTournamentId;
    }
    
    /**
     * Creates new form LoadTournamentView
     */
    public LoadTournamentView() {
        
        //LogManager.getLogger(). logger.setLevel(Level.DEBUG);
        //logger.setLevel(FINE); 
        
        initComponents();
    }
    

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        logger.debug(lse.toString());
        if(!lse.getValueIsAdjusting())
        {

            int row = tableTournament.getSelectedRow();          
            int column = 0;
            logger.debug("Row {}, Column {} selected", row, column);
            Object o = tableTournament.getValueAt(row, column);          
            Long id = Long.valueOf(o.toString());        
            selectedTournamentId = id;
            
            logger.debug("Tournament selected, ID: {}", o.toString());
         
            loadButton.setEnabled(true);
        }
       
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        fieldmarshaldb2PUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("FieldMarshalPU2").createEntityManager();
        tournamentQuery1 = java.beans.Beans.isDesignTime() ? null : fieldmarshaldb2PUEntityManager.createQuery("SELECT t FROM Tournament t");
        tournamentList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : tournamentQuery1.getResultList();
        loadButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTournament = new javax.swing.JTable();

        loadButton.setText("Load");
        loadButton.setEnabled(false);
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        tableTournament.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tournamentList1, tableTournament, "");
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${store}"));
        columnBinding.setColumnName("Store");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${todaysDate}"));
        columnBinding.setColumnName("Todays Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${organizer}"));
        columnBinding.setColumnName("Organizer");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numRounds}"));
        columnBinding.setColumnName("Num Rounds");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        tableTournament.getSelectionModel().addListSelectionListener(this);
        jScrollPane1.setViewportView(tableTournament);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loadButton)
                .addContainerGap())
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        // notify the tournament manager that a tournament Id was selected & read
        // and to load the tournament
        firePropertyChange(LOAD_TOURNAMENT_ID, 0L, selectedTournamentId);
    }//GEN-LAST:event_loadButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager fieldmarshaldb2PUEntityManager;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loadButton;
    private javax.swing.JTable tableTournament;
    private java.util.List<net.geeklythings.fieldmarshal.entity.Tournament> tournamentList1;
    private javax.persistence.Query tournamentQuery1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables


}
