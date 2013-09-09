/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.ui;

import javax.persistence.EntityManagerFactory;
import net.geeklythings.fieldmarshal.jpa.TournamentJpaController;
import net.geeklythings.fieldmarshal.model.entity.Tournament;
import net.geeklythings.fieldmarshal.managers.PlayerManager;
import net.geeklythings.fieldmarshal.managers.TournamentManager;


/**
 *
 * @author khooks
 */
public class FieldMarshal extends javax.swing.JFrame {
    
    static final String TOURNAMENT_PROP = "Active Tournament";
    private EntityManagerFactory _emf;
    TournamentJpaController tournamentJpaController;
    TournamentManager tournamentManager; // = new TournamentManager(this);
    PlayerManager playerManager;
    
    /**
     * Creates new form MainJFrame
     */
    public FieldMarshal() {
        
        _emf = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("FieldMarshalMySqlPU");
        tournamentJpaController = new TournamentJpaController(_emf);
        
        initComponents();
        tournamentManager = new TournamentManager( _emf );
        playerManager = new PlayerManager( _emf );
        
        //loadTournamentView.setEntityManager(_em);
        loadTournamentView.addPropertyChangeListener(tournamentManager);
        loadTournamentView.updateList();
        
        ///tournamentManager.addObserver(tournamentView);
        ///tournamentManager.addObserver(playersView);      
        
        tournamentView.setManager(tournamentManager);
        playersView.setManager(tournamentManager);
        
               
        tournamentView.updateView();
        playersView.updateView();
        //playersView.setEntityManager(_em);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateConverter = new net.geeklythings.fieldmarshal.util.DateConverter();
        jTabbedPane = new javax.swing.JTabbedPane();
        loadTournamentView = new net.geeklythings.fieldmarshal.ui.LoadView(tournamentJpaController);
        tournamentView = new net.geeklythings.fieldmarshal.ui.TournamentView();
        playersView = new net.geeklythings.fieldmarshal.ui.PlayersView();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuNewTournament = new javax.swing.JMenuItem();
        mnuLoadTournament = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane.addTab("Load Tournament", loadTournamentView);
        jTabbedPane.addTab("Tournament", tournamentView);
        jTabbedPane.addTab("Players", playersView);

        mnuFile.setText("File");

        mnuNewTournament.setText("New Tournament");
        mnuNewTournament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNewTournamentActionPerformed(evt);
            }
        });
        mnuFile.add(mnuNewTournament);

        mnuLoadTournament.setText("Load Tournament");
        mnuLoadTournament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLoadTournamentActionPerformed(evt);
            }
        });
        mnuFile.add(mnuLoadTournament);

        jMenuBar1.add(mnuFile);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (this._emf != null) {
            _emf.close();
        }

    }//GEN-LAST:event_formWindowClosing

    private void mnuNewTournamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNewTournamentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuNewTournamentActionPerformed

    private void mnuLoadTournamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLoadTournamentActionPerformed
        // TODO add your handling code here:
        // load the Load Tournament dialog
    }//GEN-LAST:event_mnuLoadTournamentActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FieldMarshal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FieldMarshal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FieldMarshal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FieldMarshal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FieldMarshal().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.geeklythings.fieldmarshal.util.DateConverter dateConverter;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTabbedPane jTabbedPane;
    private net.geeklythings.fieldmarshal.ui.LoadView loadTournamentView;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuLoadTournament;
    private javax.swing.JMenuItem mnuNewTournament;
    private net.geeklythings.fieldmarshal.ui.PlayersView playersView;
    private net.geeklythings.fieldmarshal.ui.TournamentView tournamentView;
    // End of variables declaration//GEN-END:variables

    
}
