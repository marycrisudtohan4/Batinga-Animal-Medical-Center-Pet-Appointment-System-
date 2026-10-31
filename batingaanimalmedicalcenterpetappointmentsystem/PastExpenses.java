package batingaanimalmedicalcenterpetappointmentsystem;

import javax.swing.JOptionPane; 



public class PastExpenses extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PastExpenses.class.getName());

    /**
     * Creates new form PastExpenses
     */
public PastExpenses() {
    initComponents();

    if (UserSession.getUserId() == 0) {

        JOptionPane.showMessageDialog(
                this,
                "Please log in first.",
                "Login Required",
                JOptionPane.WARNING_MESSAGE
        );

        new loginform().setVisible(true);
        this.dispose();
        return;
    }

    cmbSelectPet.setEditable(false);
    loadPets();


loadPets();
cmbSelectPet.setEditable(false);
}

private void loadPets() {

    cmbSelectPet.removeAllItems();

    String sql =
            "SELECT pet_id, pet_name " +
            "FROM tbl_pet " +
            "WHERE user_id = ? " +
            "ORDER BY pet_name ASC";

    try (
        java.sql.Connection conn = DBConnection.getConnection();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql)
    ) {

        pst.setInt(1, UserSession.getUserId());

        java.sql.ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            cmbSelectPet.addItem(
                    rs.getInt("pet_id") + " - " +
                    rs.getString("pet_name")
            );
        }

    } catch (java.sql.SQLException e) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Unable to load your pets.\n" + e.getMessage(),
                "Database Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );

        e.printStackTrace();
    }
}

private void loadPastExpenses() {

    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel)
                    tblPastExpenses.getModel();

    model.setRowCount(0);

String sql =
        "SELECT pet_name, services, appointment_date, amount " +
        "FROM tbl_pet " +
        "WHERE pet_id = ? " +
        "AND user_id = ? " +
        "AND appointment_date IS NOT NULL " +
        "AND appointment_date < CURDATE() " +
        "ORDER BY appointment_date DESC";

    try (
        java.sql.Connection conn = DBConnection.getConnection();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql)
    ) {

        pst.setInt(1, UserSession.getUserId());

        java.sql.ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            String petName = rs.getString("pet_name");
            String service = rs.getString("services");

            java.sql.Date appointmentDate =
                    rs.getDate("appointment_date");

            String date =
                    appointmentDate.toLocalDate().toString();

            model.addRow(new Object[]{
                    date,
                    service,
                    petName,
                    "N/A"
            });
        }

        lblTotalExpenses.setText("Total Expenses: N/A");

    } catch (java.sql.SQLException e) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Unable to load past expenses.\n" +
                e.getMessage(),
                "Database Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );

        e.printStackTrace();
    }
}

private void loadPastExpenses(int petId) {
javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) tblPastExpenses.getModel();

    model.setRowCount(0);

    double total = 0;

    String sql =
            "SELECT pet_name, services, appointment_date, amount " +
            "FROM tbl_pet " +
            "WHERE pet_id = ? " +
            "AND user_id = ? " +
            "AND appointment_date IS NOT NULL " +
            "AND appointment_date <= CURDATE() " +
            "ORDER BY appointment_date DESC";

    try (
        java.sql.Connection conn = DBConnection.getConnection();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql)
    ) {

        pst.setInt(1, petId);
        pst.setInt(2, UserSession.getUserId());

        java.sql.ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            String petName = rs.getString("pet_name");
            String service = rs.getString("services");

            java.sql.Date appointmentDate =
                    rs.getDate("appointment_date");

            double amount = rs.getDouble("amount");

            String date =
                    appointmentDate.toLocalDate().toString();

            model.addRow(new Object[]{
                    date,
                    service,
                    petName,
                    String.format("₱%.2f", amount)
            });

            total += amount;
        }

        lblTotalExpenses.setText(
                String.format("Total Expenses: ₱%.2f", total)
        );

    } catch (java.sql.SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Unable to load past expenses.\n" +
                e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );

        e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cmbSelectPet = new javax.swing.JComboBox<>();
        lblTotalExpenses = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPastExpenses = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnBookAppointment = new javax.swing.JButton();
        btnVeterinaryServices = new javax.swing.JButton();
        btnMyAppointments = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnMyPets = new javax.swing.JButton();
        btnPetRecords = new javax.swing.JButton();
        btnPastExpenses = new javax.swing.JButton();
        btnLogout1 = new javax.swing.JButton();
        btnLogout2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(650, 594));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Past Expenses");

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("View your pet's past Expenses");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Select Pet");

        cmbSelectPet.setBackground(new java.awt.Color(255, 255, 255));
        cmbSelectPet.setEditable(true);
        cmbSelectPet.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cmbSelectPet.setForeground(new java.awt.Color(51, 51, 51));
        cmbSelectPet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pet 1", "Pet 2", "Pet 3", "Pet 4" }));
        cmbSelectPet.setOpaque(true);
        cmbSelectPet.addActionListener(this::cmbSelectPetActionPerformed);

        lblTotalExpenses.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotalExpenses.setForeground(new java.awt.Color(0, 0, 0));
        lblTotalExpenses.setText("Total Expenses:");

        tblPastExpenses.setBackground(new java.awt.Color(255, 255, 255));
        tblPastExpenses.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblPastExpenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Service", "Description", "Amount"
            }
        ));
        jScrollPane3.setViewportView(tblPastExpenses);

        jPanel5.setBackground(new java.awt.Color(34, 92, 137));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBookAppointment.setBackground(new java.awt.Color(255, 255, 255));
        btnBookAppointment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBookAppointment.setForeground(new java.awt.Color(51, 51, 51));
        btnBookAppointment.setText("Book Appoinment");
        btnBookAppointment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0), 4));
        btnBookAppointment.addActionListener(this::btnBookAppointmentActionPerformed);
        jPanel5.add(btnBookAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 158, 50));

        btnVeterinaryServices.setBackground(new java.awt.Color(255, 255, 255));
        btnVeterinaryServices.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVeterinaryServices.setForeground(new java.awt.Color(51, 51, 51));
        btnVeterinaryServices.setText("Veterinary Services");
        btnVeterinaryServices.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0), 4));
        btnVeterinaryServices.addActionListener(this::btnVeterinaryServicesActionPerformed);
        jPanel5.add(btnVeterinaryServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 158, 50));

        btnMyAppointments.setBackground(new java.awt.Color(255, 255, 255));
        btnMyAppointments.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMyAppointments.setForeground(new java.awt.Color(51, 51, 51));
        btnMyAppointments.setText("My Appointments");
        btnMyAppointments.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0), 4));
        btnMyAppointments.addActionListener(this::btnMyAppointmentsActionPerformed);
        jPanel5.add(btnMyAppointments, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 158, 50));

        btnLogout.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(51, 51, 51));
        btnLogout.setText("Log Out");
        btnLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0), 4));
        btnLogout.addActionListener(this::btnLogoutActionPerformed);
        jPanel5.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 740, 160, 50));

        jLabel1.setBackground(new java.awt.Color(35, 93, 137));
        jLabel1.setForeground(new java.awt.Color(49, 113, 165));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/images-removebg-preview-1.png"))); // NOI18N
        jLabel1.setOpaque(true);
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 130, 130));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Batinga");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Animal Medical Center");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, 20));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Pet Appointment System");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, 20));

        btnDashboard.setBackground(new java.awt.Color(255, 255, 255));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(51, 51, 51));
        btnDashboard.setText("Dashboard");
        btnDashboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0), 4));
        btnDashboard.addActionListener(this::btnDashboardActionPerformed);
        jPanel5.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 158, 50));

        btnMyPets.setBackground(new java.awt.Color(255, 255, 255));
        btnMyPets.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMyPets.setForeground(new java.awt.Color(51, 51, 51));
        btnMyPets.setText("My Pets");
        btnMyPets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0), 4));
        btnMyPets.addActionListener(this::btnMyPetsActionPerformed);
        jPanel5.add(btnMyPets, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 158, 50));

        btnPetRecords.setBackground(new java.awt.Color(255, 255, 255));
        btnPetRecords.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPetRecords.setForeground(new java.awt.Color(51, 51, 51));
        btnPetRecords.setText("Pet Records");
        btnPetRecords.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0), 4));
        btnPetRecords.addActionListener(this::btnPetRecordsActionPerformed);
        jPanel5.add(btnPetRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 158, 50));

        btnPastExpenses.setBackground(new java.awt.Color(102, 204, 255));
        btnPastExpenses.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPastExpenses.setForeground(new java.awt.Color(51, 51, 51));
        btnPastExpenses.setText("Past Expenses");
        btnPastExpenses.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0), 4));
        btnPastExpenses.addActionListener(this::btnPastExpensesActionPerformed);
        jPanel5.add(btnPastExpenses, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 158, 50));

        btnLogout1.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout1.setForeground(new java.awt.Color(51, 51, 51));
        btnLogout1.setText("Profile");
        btnLogout1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0), 4));
        btnLogout1.addActionListener(this::btnLogout1ActionPerformed);
        jPanel5.add(btnLogout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 680, 160, 50));

        btnLogout2.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout2.setForeground(new java.awt.Color(51, 51, 51));
        btnLogout2.setText("Log Out");
        btnLogout2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0), 4));
        btnLogout2.addActionListener(this::btnLogout2ActionPerformed);
        jPanel5.add(btnLogout2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 680, 160, 50));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Amitjakhu-Drip-Archive.96.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.128.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.128.png"))); // NOI18N

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.72.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalExpenses)
                        .addGap(202, 202, 202))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbSelectPet, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel24)
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18)
                                        .addGap(28, 28, 28))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel20)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel26))))
                        .addContainerGap(99, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(jLabel20)
                                    .addGap(41, 41, 41)
                                    .addComponent(jLabel27))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel18))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSelectPet, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTotalExpenses)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSelectPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectPetActionPerformed
      if (cmbSelectPet.getSelectedItem() == null) {
        return;
    }

    String selectedPet = cmbSelectPet.getSelectedItem().toString();

    if (!selectedPet.contains(" - ")) {
        return;
    }

    try {

        int petId = Integer.parseInt(
                selectedPet.substring(
                        0,
                        selectedPet.indexOf(" - ")
                )
        );

        loadPastExpenses(petId);

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "Invalid pet selection.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_cmbSelectPetActionPerformed

    private void btnBookAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookAppointmentActionPerformed

        BookAppointment bka = new BookAppointment();
        bka .setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBookAppointmentActionPerformed

    private void btnVeterinaryServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeterinaryServicesActionPerformed
         VeterinaryServices services = new VeterinaryServices();
    services.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnVeterinaryServicesActionPerformed

    private void btnMyAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyAppointmentsActionPerformed
        Myappointment app = new Myappointment();
        app .setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMyAppointmentsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
       int choice = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to logout?",
        "Logout Confirmation",
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.QUESTION_MESSAGE
    );

    if (choice == javax.swing.JOptionPane.YES_OPTION) {

        UserSession.clearSession();

        loginform login = new loginform();
        login.setVisible(true);
        this.dispose();
    }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        Homepage home = new Homepage(UserSession.getUserId());

        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnMyPetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyPetsActionPerformed
        MyPets pets = new MyPets();

        pets.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMyPetsActionPerformed

    private void btnPetRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetRecordsActionPerformed
        Petrecords pet = new Petrecords();

    pet.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnPetRecordsActionPerformed

    private void btnPastExpensesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPastExpensesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPastExpensesActionPerformed

    private void btnLogout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogout1ActionPerformed

    private void btnLogout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogout2ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new PastExpenses().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookAppointment;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnLogout1;
    private javax.swing.JButton btnLogout2;
    private javax.swing.JButton btnMyAppointments;
    private javax.swing.JButton btnMyPets;
    private javax.swing.JButton btnPastExpenses;
    private javax.swing.JButton btnPetRecords;
    private javax.swing.JButton btnVeterinaryServices;
    private javax.swing.JComboBox<String> cmbSelectPet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTotalExpenses;
    private javax.swing.JTable tblPastExpenses;
    // End of variables declaration//GEN-END:variables
}
