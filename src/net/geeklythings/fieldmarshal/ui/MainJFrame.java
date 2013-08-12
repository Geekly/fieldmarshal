/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.geeklythings.fieldmarshal.data.Tournament;
import net.geeklythings.fieldmarshal.data.TournamentFactory;

/**
 *
 * @author khooks
 */
public class MainJFrame extends javax.swing.JFrame {

    private Tournament activeTournament;

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _em = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("FieldMarshalPU2").createEntityManager();
        desktopFrame = new javax.swing.JDesktopPane();
        btnNewTournament = new javax.swing.JButton();
        btnLoadTournament = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        tournamentFrame = new net.geeklythings.fieldmarshal.ui.TournamentInternalFrame();
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

        desktopFrame.setBackground(new java.awt.Color(0, 153, 153));

        btnNewTournament.setText("New Tournament");
        btnNewTournament.setToolTipText("Create New Tournament");
        btnNewTournament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTournamentActionPerformed(evt);
            }
        });
        btnNewTournament.setBounds(20, 30, 115, 23);
        desktopFrame.add(btnNewTournament, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnLoadTournament.setText("Load Tournament");
        btnLoadTournament.setToolTipText("Load Existing Tournament");
        btnLoadTournament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadTournamentActionPerformed(evt);
            }
        });
        btnLoadTournament.setBounds(20, 60, 117, 23);
        desktopFrame.add(btnLoadTournament, javax.swing.JLayeredPane.DEFAULT_LAYER);

        output.setColumns(20);
        output.setRows(5);
        jScrollPane1.setViewportView(output);

        jScrollPane1.setBounds(30, 270, 390, 230);
        desktopFrame.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tournamentFrame.setVisible(true);
        tournamentFrame.setBounds(510, 80, 610, 490);
        desktopFrame.add(tournamentFrame, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
            .addComponent(desktopFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public EntityManager getEntityManager() {
        return _em;
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (this._em != null) {
            _em.close();
        }

    }//GEN-LAST:event_formWindowClosing

    private void btnLoadTournamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadTournamentActionPerformed
        // TODO add your handling code here:
        // open a load tournament dialog
        // activeTournament = load the tournament
        // load the edit tournament dialog
        LoadTournamentDialog ltd = new LoadTournamentDialog(this, true);
        Long tournamentID = ltd.showDialog();
        //Long tournamentID = 
        if( tournamentID != 0)
        {
            output.append("Trying to load Tournament " + String.valueOf(tournamentID));
            try{
                activeTournament = (Tournament)_em.find(Tournament.class, tournamentID);             
            }
            finally
            {
                tournamentFrame.setActiveTournament(activeTournament);
                //tournamentFrame.refresh();
                tournamentFrame.setVisible(true);
                
                try {
                    tournamentFrame.setSelected(true);
                }catch(Exception e){}
                
            }
            
        }
        
    }//GEN-LAST:event_btnLoadTournamentActionPerformed

    private void btnNewTournamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTournamentActionPerformed
        // TODO add your handling code here:
        // open the dialog here
        //Create the tournament, THEN open the edit tournament dialog
        //activeTournament = TournamentFactory.createTournament(0);
        activeTournament = TournamentFactory.createTournament(4);
        EditTournamentDialog et = new EditTournamentDialog(this, true);
        //et.setActiveTournament(activeTournament);
        et.showDialog(activeTournament);
        int returnStatus = et.getReturnStatus();
        if(returnStatus == EditTournamentDialog.RET_CANCEL)
        // cancel creating a new tournament and discard the object
        {
            //  _em.refresh(activeTournament);  //cancel the changes
            activeTournament = null;  
        }
        else if(returnStatus == EditTournamentDialog.RET_OK)
        {
            //update number of rounds
            
            _em.getTransaction().begin();
            _em.persist(activeTournament);
            _em.getTransaction().commit();
        }
        
        tournamentFrame.setActiveTournament(activeTournament);
                //tournamentFrame.refresh();
        tournamentFrame.setVisible(true);
        // comes back to here when dialog closes
    }//GEN-LAST:event_btnNewTournamentActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager _em;
    private javax.swing.JButton btnLoadTournament;
    private javax.swing.JButton btnNewTournament;
    private javax.swing.JDesktopPane desktopFrame;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuLoadTournament;
    private javax.swing.JMenuItem mnuNewTournament;
    private javax.swing.JTextArea output;
    private net.geeklythings.fieldmarshal.ui.TournamentInternalFrame tournamentFrame;
    // End of variables declaration//GEN-END:variables
}
