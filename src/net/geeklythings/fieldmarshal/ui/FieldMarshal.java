/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.geeklythings.fieldmarshal.entity.Tournament;
import net.geeklythings.fieldmarshal.model.TournamentFactory;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.swing.ListModel;
import net.geeklythings.fieldmarshal.entity.Entrant;
import net.geeklythings.fieldmarshal.model.Faction;
import net.geeklythings.fieldmarshal.entity.Player;
import net.geeklythings.fieldmarshal.managers.TournamentController;
import net.geeklythings.fieldmarshal.model.CustomListModel;

/**
 *
 * @author khooks
 */
public class FieldMarshal extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    public FieldMarshal() {
        initComponents();
    }

    Tournament activeTournament;// = TournamentFactory.createTournament(5);
    
    public Tournament getActiveTournament()
    {
        return activeTournament;
    }
    
    public void setActiveTournament(Tournament tournament)
    {
        Tournament oldTournament = activeTournament;
        activeTournament = tournament;
        firePropertyChange("activeTournament", oldTournament, activeTournament);
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

        _em = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("FieldMarshalPU2").createEntityManager();
        dateConverter = new net.geeklythings.fieldmarshal.util.DateConverter();
        desktopFrame = new javax.swing.JDesktopPane();
        btnNewTournament = new javax.swing.JButton();
        btnLoadTournament = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        btnEdit = new javax.swing.JButton();
        m_panelTournamentOverview = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRounds = new javax.swing.JTable();
        m_panelTournamentInfo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtOrganizer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCurrentRound = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtStore = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumRounds = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        playerJList = new javax.swing.JList();
        panelAddPlayer = new javax.swing.JPanel();
        txtLastName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        btnAddPlayer = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
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
        btnNewTournament.setBounds(10, 10, 120, 23);
        desktopFrame.add(btnNewTournament, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnLoadTournament.setText("Load Tournament");
        btnLoadTournament.setToolTipText("Load Existing Tournament");
        btnLoadTournament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadTournamentActionPerformed(evt);
            }
        });
        btnLoadTournament.setBounds(10, 70, 120, 23);
        desktopFrame.add(btnLoadTournament, javax.swing.JLayeredPane.DEFAULT_LAYER);

        output.setColumns(20);
        output.setRows(5);
        jScrollPane1.setViewportView(output);

        jScrollPane1.setBounds(10, 580, 320, 80);
        desktopFrame.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnEdit.setText("Edit Tournament");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        btnEdit.setBounds(10, 40, 120, 23);
        desktopFrame.add(btnEdit, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${activeTournament.rounds}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, this, eLProperty, tableRounds, "bindingRounds");
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${roundNumber}"));
        columnBinding.setColumnName("Round Number");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Long.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(tableRounds);

        jSplitPane1.setBottomComponent(jScrollPane2);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Date:");

        txtOrganizer.setEditable(false);
        txtOrganizer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, this, org.jdesktop.beansbinding.ELProperty.create("${activeTournament.organizer}"), txtOrganizer, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Current Round:");

        txtCurrentRound.setEditable(false);
        txtCurrentRound.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCurrentRound.setMinimumSize(new java.awt.Dimension(10, 20));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${activeTournament.currentRound}"), txtCurrentRound, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("of");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tournament Format:");

        txtStore.setEditable(false);
        txtStore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, this, org.jdesktop.beansbinding.ELProperty.create("${activeTournament.store}"), txtStore, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Rounds");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Location:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Organizer:");

        txtNumRounds.setEditable(false);
        txtNumRounds.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${activeTournament.numRounds}"), txtNumRounds, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtDescription.setEditable(false);
        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, this, org.jdesktop.beansbinding.ELProperty.create("${activeTournament.format.formatDescription}"), txtDescription, org.jdesktop.beansbinding.BeanProperty.create("text"), "formatDescriptionBinding");
        bindingGroup.addBinding(binding);

        txtDate.setEditable(false);
        txtDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, this, org.jdesktop.beansbinding.ELProperty.create("${activeTournament.todaysDate}"), txtDate, org.jdesktop.beansbinding.BeanProperty.create("text"), "");
        binding.setConverter(dateConverter);
        bindingGroup.addBinding(binding);

        jButton1.setText("Add Round");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout m_panelTournamentInfoLayout = new javax.swing.GroupLayout(m_panelTournamentInfo);
        m_panelTournamentInfo.setLayout(m_panelTournamentInfoLayout);
        m_panelTournamentInfoLayout.setHorizontalGroup(
            m_panelTournamentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(m_panelTournamentInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(m_panelTournamentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(41, 41, 41)
                .addGroup(m_panelTournamentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(m_panelTournamentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(m_panelTournamentInfoLayout.createSequentialGroup()
                            .addComponent(txtCurrentRound, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNumRounds, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtDate)
                        .addComponent(txtOrganizer, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(txtStore))
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(296, Short.MAX_VALUE))
        );
        m_panelTournamentInfoLayout.setVerticalGroup(
            m_panelTournamentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, m_panelTournamentInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(m_panelTournamentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(m_panelTournamentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(m_panelTournamentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(m_panelTournamentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCurrentRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtNumRounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(m_panelTournamentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(m_panelTournamentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jSplitPane1.setTopComponent(m_panelTournamentInfo);

        javax.swing.GroupLayout m_panelTournamentOverviewLayout = new javax.swing.GroupLayout(m_panelTournamentOverview);
        m_panelTournamentOverview.setLayout(m_panelTournamentOverviewLayout);
        m_panelTournamentOverviewLayout.setHorizontalGroup(
            m_panelTournamentOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(m_panelTournamentOverviewLayout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        m_panelTournamentOverviewLayout.setVerticalGroup(
            m_panelTournamentOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
            .addGroup(m_panelTournamentOverviewLayout.createSequentialGroup()
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        m_panelTournamentOverview.setBounds(340, 0, 880, 670);
        desktopFrame.add(m_panelTournamentOverview, javax.swing.JLayeredPane.DEFAULT_LAYER);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${activeTournament.players}");
        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, playerJList, "bindingPlayerList");
        bindingGroup.addBinding(jListBinding);

        playerJList.setModel( new CustomListModel() );
        jScrollPane3.setViewportView(playerJList);

        jScrollPane3.setBounds(10, 260, 320, 310);
        desktopFrame.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtLastName.setText("Potter");

        txtFirstName.setText("Harry");

        btnAddPlayer.setText("Add Player");
        btnAddPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPlayerActionPerformed(evt);
            }
        });

        jLabel8.setText("First Name");

        jLabel9.setText("Last Name");

        jLabel10.setText("Faction");

        javax.swing.GroupLayout panelAddPlayerLayout = new javax.swing.GroupLayout(panelAddPlayer);
        panelAddPlayer.setLayout(panelAddPlayerLayout);
        panelAddPlayerLayout.setHorizontalGroup(
            panelAddPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddPlayerLayout.createSequentialGroup()
                        .addGroup(panelAddPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelAddPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAddPlayerLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 92, Short.MAX_VALUE))
                            .addComponent(txtLastName)))
                    .addGroup(panelAddPlayerLayout.createSequentialGroup()
                        .addGroup(panelAddPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddPlayer)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAddPlayerLayout.setVerticalGroup(
            panelAddPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnAddPlayer)
                .addContainerGap())
        );

        panelAddPlayer.setBounds(10, 120, 320, 130);
        desktopFrame.add(panelAddPlayer, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
            .addComponent(desktopFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 1223, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );

        bindingGroup.bind();

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
        Tournament oldTournament = activeTournament;
        LoadTournamentDialog ltd = new LoadTournamentDialog(this, true);
        Long tournamentID = ltd.showDialog();
        //Long tournamentID = 
        if (tournamentID != 0) {
            output.append("Trying to load Tournament " + String.valueOf(tournamentID) + "\n");
            try {
                activeTournament = (Tournament) _em.find(Tournament.class, tournamentID);
            } 
            catch (Exception e) 
            {
            }
            firePropertyChange("activeTournament", null, activeTournament);
        }

    }//GEN-LAST:event_btnLoadTournamentActionPerformed

    private void btnNewTournamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTournamentActionPerformed
        //Create the tournament, THEN open the edit tournament dialog
        //activeTournament = TournamentFactory.createTournament(0);
        //Are you sure you want to create a new Tournament?
        activeTournament = Tournament.createTournament(3);
        persist(activeTournament);
        firePropertyChange("activeTournament", null, activeTournament);
        //EditActiveTournament();

    }//GEN-LAST:event_btnNewTournamentActionPerformed

    private void EditActiveTournament() {

        EditTournamentDialog et = new EditTournamentDialog(this, true);
        TournamentController tm = new TournamentController();
        //et.setActiveTournament(activeTournament);
        et.showDialog(activeTournament);
        int returnStatus = et.getReturnStatus();
        if (returnStatus == EditTournamentDialog.RET_CANCEL) // cancel creating a new tournament and discard the object
        {
            //  _em.refresh(activeTournament);  //cancel the changes
            //activeTournament = null;

        } else if (returnStatus == EditTournamentDialog.RET_OK) {
            //update number of rounds
            Tournament oldTournament = new Tournament();
            activeTournament.copyProperties(et.getTournament());  //copy the updates
            //oldTournament.setId(0L);
            //copy the tournament properties from the Dialog         
            merge(activeTournament);
        
            firePropertyChange("activeTournament", oldTournament, activeTournament);
        }
        // comes back to here when dialog closes

    }

    private void mnuNewTournamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNewTournamentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuNewTournamentActionPerformed

    private void mnuLoadTournamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLoadTournamentActionPerformed
        // TODO add your handling code here:
        // load the Load Tournament dialog
    }//GEN-LAST:event_mnuLoadTournamentActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        EditActiveTournament();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPlayerActionPerformed
        // TODO add your handling code here:
        //Tournament oldTournament = activeTournament.copy();
        if(activeTournament == null) { return; }
        
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        Faction faction = Faction.CIRCLE;
        
        Player player = null;
        
        List<Entrant> oldPlayers = new ArrayList<>(activeTournament.getPlayers());
        
        // check if player exists in database
        // query the database for first and last name
        TypedQuery<Player> query = _em.createNamedQuery("Player.findByName", Player.class);
        query.setParameter("first", firstName);
        query.setParameter("last", lastName);
        try {
            player = query.getSingleResult();
        } catch (NoResultException e)
        {
            System.out.println(e.toString());
        }
        if(player==null) //player not found in DB
        {
            player = new Player(firstName, lastName);
            persist(player);           
        }    
        Entrant entrant = new Entrant(player, faction);
        persist(entrant);
        
        activeTournament.addPlayer(entrant);
        persist(activeTournament);
        //_em.getTransaction().begin();
        //_em.persist(activeTournament);  // persist the changes
        //_em.getTransaction().commit();
        // if yes, load the player and create a new Entrant with it
        // if no, create a new player and add it to the Entrant
        // set the fact
        // add the entrant to the List of players

        output.setText( activeTournament.getPlayers().toString() ); 
        
        firePropertyChange("activeTournament", null, null);
        firePropertyChange("bindingPlayerList", null, null);
        firePropertyChange("activeTournament.players", oldPlayers, activeTournament.getPlayers());
        firePropertyChange("activeTournament.players", null, null);
    }//GEN-LAST:event_btnAddPlayerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            public void run() {
                new FieldMarshal().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager _em;
    private javax.swing.JButton btnAddPlayer;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLoadTournament;
    private javax.swing.JButton btnNewTournament;
    private net.geeklythings.fieldmarshal.util.DateConverter dateConverter;
    private javax.swing.JDesktopPane desktopFrame;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel m_panelTournamentInfo;
    private javax.swing.JPanel m_panelTournamentOverview;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuLoadTournament;
    private javax.swing.JMenuItem mnuNewTournament;
    private javax.swing.JTextArea output;
    private javax.swing.JPanel panelAddPlayer;
    private javax.swing.JList playerJList;
    private javax.swing.JTable tableRounds;
    private javax.swing.JTextField txtCurrentRound;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtNumRounds;
    private javax.swing.JTextField txtOrganizer;
    private javax.swing.JTextField txtStore;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    
    public Object merge(Object object) {
        _em.getTransaction().begin();
        try {
           object = _em.merge(object);
            _em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            _em.getTransaction().rollback();
        } finally {
            //_em.close();
        }
        return object;
    }
    
    public void persist(Object object) {
        _em.getTransaction().begin();
        try {
            _em.persist(object);
            _em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            _em.getTransaction().rollback();
        } finally {
            //_em.close();
        }
    }
}
