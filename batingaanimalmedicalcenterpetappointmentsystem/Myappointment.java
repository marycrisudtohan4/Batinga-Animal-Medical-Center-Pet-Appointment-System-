/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package batingaanimalmedicalcenterpetappointmentsystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
public class Myappointment extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Myappointment.class.getName());

    /**
     * Creates new form Myappointment
     */
    public Myappointment() {
        initComponents();
        loadAppointments();
        setupCancelAction();
    }
    
    
    
   private void loadAppointments() {
DefaultTableModel model = (DefaultTableModel) tblMyAppointments.getModel();
    
    // Explicitly set the 7 column headers so they never mismatch!
    model.setColumnIdentifiers(new String[]{
        "ID", "Pet Name", "Service", "Date", "Time", "Status", "Action"
    });
    
    model.setRowCount(0); // Clear old rows
    
    String sql = "SELECT a.appointment_id, p.pet_name, a.service_type, a.appointment_date, a.appointment_time, a.amount, a.status " +
                 "FROM tbl_appointments a " +
                 "JOIN tbl_pet p ON a.pet_id = p.pet_id " +
                 "WHERE p.user_id = ? " +
                 "ORDER BY a.appointment_date ASC, a.appointment_time ASC";
                 
    double totalExpenses = 0.0;
    
    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {
        
        pst.setInt(1, UserSession.getUserId());
        
        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                int appointmentId = rs.getInt("appointment_id");
                String petName = rs.getString("pet_name");
                String serviceType = rs.getString("service_type");
                String appointmentDate = rs.getString("appointment_date");
                String appointmentTime = rs.getString("appointment_time");
                double amount = rs.getDouble("amount");
                String status = rs.getString("status");
                
                totalExpenses += amount;
                
                String actionText = "Cancel";
                if (status != null && (status.equalsIgnoreCase("Completed") || status.equalsIgnoreCase("Approved") || status.equalsIgnoreCase("Cancelled"))) {
                    actionText = ""; 
                }
                
                model.addRow(new Object[]{
                    appointmentId, 
                    petName, 
                    serviceType, 
                    appointmentDate, 
                    appointmentTime, 
                    status, 
                    actionText
                });
            }
            
            lblTotalExpenses.setText("Total Expenses: ₱ " + String.format("%.2f", totalExpenses));
            
            // Hide the ID column (index 0) safely
            if (tblMyAppointments.getColumnCount() > 0) {
                tblMyAppointments.getColumnModel().getColumn(0).setMinWidth(0);
                tblMyAppointments.getColumnModel().getColumn(0).setMaxWidth(0);
                tblMyAppointments.getColumnModel().getColumn(0).setWidth(0);
            }
            tblMyAppointments.setRowHeight(24);
        }
} catch (Exception e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Unable to load appointments: " + e.getMessage());
    e.printStackTrace();
}
}
    private void setupCancelAction() {
tblMyAppointments.addMouseListener(
        new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tblMyAppointments.rowAtPoint(evt.getPoint());
                int column = tblMyAppointments.columnAtPoint(evt.getPoint());

                // Column 6 = Action
                if (column != 6 || row < 0) {
                    return;
                }

                // Get the action text of the clicked cell
                Object actionVal = tblMyAppointments.getValueAt(row, 6);
                if (actionVal == null || !actionVal.toString().equals("Cancel")) {
                    return; // Do nothing if the cell is blank (for Completed/Approved items)
                }

                int choice = javax.swing.JOptionPane.showConfirmDialog(
                        Myappointment.this,
                        "Are you sure you want to cancel this appointment?",
                        "Cancel Appointment",
                        javax.swing.JOptionPane.YES_NO_OPTION,
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );

                if (choice != javax.swing.JOptionPane.YES_OPTION) {
                    return;
                }

                String appointmentId = tblMyAppointments.getValueAt(row, 0).toString();

                // Note: If appointment_id is a pure number in tbl_appointments, parse it directly:
                int aptId = Integer.parseInt(appointmentId);

                // Update the actual appointment table status to 'Cancelled' instead of clearing tbl_pet
                String sql = "UPDATE tbl_appointments SET status = 'Cancelled' WHERE appointment_id = ?";

                try (Connection con = DBConnection.getConnection();
                     PreparedStatement pst = con.prepareStatement(sql)) {

                    pst.setInt(1, aptId);
                    int result = pst.executeUpdate();

                    if (result > 0) {
                        javax.swing.JOptionPane.showMessageDialog(
                                Myappointment.this,
                                "Appointment cancelled successfully!",
                                "Success",
                                javax.swing.JOptionPane.INFORMATION_MESSAGE
                        );
                        loadAppointments();
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(
                                Myappointment.this,
                                "Appointment could not be cancelled.",
                                "Error",
                                javax.swing.JOptionPane.ERROR_MESSAGE
                        );
                    }

                } catch (Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(
                            Myappointment.this,
                            "Database Error: " + e.getMessage(),
                            "Error",
                            javax.swing.JOptionPane.ERROR_MESSAGE
                    );
                    e.printStackTrace();
                }
            }
        }
    );
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnLogout1 = new javax.swing.JButton();
        btnVeterinaryServices = new javax.swing.JButton();
        btnPetRecords = new javax.swing.JButton();
        btnMyAppointments = new javax.swing.JButton();
        btnBookAppointment = new javax.swing.JButton();
        btnMyPets = new javax.swing.JButton();
        btnDashboard = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblTotalExpenses = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMyAppointments = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(1032, 594));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("My Appointments");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("View and manage your appointments");

        jPanel3.setBackground(new java.awt.Color(34, 92, 137));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(35, 93, 137));
        jLabel1.setForeground(new java.awt.Color(49, 113, 165));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/images-removebg-preview-1.png"))); // NOI18N
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 130, 130));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Batinga");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 30));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Animal Medical Center");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, 20));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Pet Appointment System");
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 20));

        btnLogout.setBackground(new java.awt.Color(0, 102, 153));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/logout-removebg-preview (1).png"))); // NOI18N
        btnLogout.setText("Log Out");
        btnLogout.setBorder(null);
        btnLogout.addActionListener(this::btnLogoutActionPerformed);
        jPanel3.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 680, 180, 50));

        btnLogout1.setBackground(new java.awt.Color(0, 102, 153));
        btnLogout1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout1.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/prof-removebg-preview (1).png"))); // NOI18N
        btnLogout1.setText("  Profile");
        btnLogout1.setBorder(null);
        btnLogout1.addActionListener(this::btnLogout1ActionPerformed);
        jPanel3.add(btnLogout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 180, 50));

        btnVeterinaryServices.setBackground(new java.awt.Color(0, 102, 153));
        btnVeterinaryServices.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVeterinaryServices.setForeground(new java.awt.Color(255, 255, 255));
        btnVeterinaryServices.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/inject-removebg-preview (2).png"))); // NOI18N
        btnVeterinaryServices.setText("Veterinary Services");
        btnVeterinaryServices.setBorder(null);
        btnVeterinaryServices.addActionListener(this::btnVeterinaryServicesActionPerformed);
        jPanel3.add(btnVeterinaryServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 180, 50));

        btnPetRecords.setBackground(new java.awt.Color(0, 102, 153));
        btnPetRecords.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPetRecords.setForeground(new java.awt.Color(255, 255, 255));
        btnPetRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/list-removebg-preview (2).png"))); // NOI18N
        btnPetRecords.setText("  Pet Records");
        btnPetRecords.setBorder(null);
        btnPetRecords.addActionListener(this::btnPetRecordsActionPerformed);
        jPanel3.add(btnPetRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 180, 50));

        btnMyAppointments.setBackground(new java.awt.Color(0, 102, 153));
        btnMyAppointments.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMyAppointments.setForeground(new java.awt.Color(255, 255, 255));
        btnMyAppointments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/pen-removebg-preview (1).png"))); // NOI18N
        btnMyAppointments.setText("  My Appointments");
        btnMyAppointments.setBorder(null);
        btnMyAppointments.addActionListener(this::btnMyAppointmentsActionPerformed);
        jPanel3.add(btnMyAppointments, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 180, 50));

        btnBookAppointment.setBackground(new java.awt.Color(0, 102, 153));
        btnBookAppointment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBookAppointment.setForeground(new java.awt.Color(255, 255, 255));
        btnBookAppointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/calendar-removebg-preview (1).png"))); // NOI18N
        btnBookAppointment.setText("  Book Appoinment");
        btnBookAppointment.setBorder(null);
        btnBookAppointment.addActionListener(this::btnBookAppointmentActionPerformed);
        jPanel3.add(btnBookAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 180, 50));

        btnMyPets.setBackground(new java.awt.Color(0, 102, 153));
        btnMyPets.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMyPets.setForeground(new java.awt.Color(255, 255, 255));
        btnMyPets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/paw-removebg-preview (1).png"))); // NOI18N
        btnMyPets.setText("  My Pets");
        btnMyPets.setBorder(null);
        btnMyPets.addActionListener(this::btnMyPetsActionPerformed);
        jPanel3.add(btnMyPets, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 180, 50));

        btnDashboard.setBackground(new java.awt.Color(0, 102, 153));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/home-removebg-preview (1).png"))); // NOI18N
        btnDashboard.setText("  Dashboard");
        btnDashboard.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnDashboard.addActionListener(this::btnDashboardActionPerformed);
        jPanel3.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 180, 50));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Icons8-Windows-8-Messaging-Appointment-Reminders.96.png"))); // NOI18N

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.72.png"))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.72.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.128.png"))); // NOI18N

        lblTotalExpenses.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotalExpenses.setForeground(new java.awt.Color(0, 0, 0));
        lblTotalExpenses.setText("Total Expenses:");

        tblMyAppointments.setBackground(new java.awt.Color(255, 255, 255));
        tblMyAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Pet Name", "Service", "Date", "Time", "Status", "Action"
            }
        ));
        jScrollPane2.setViewportView(tblMyAppointments);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel15)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(173, 173, 173)
                                        .addComponent(jLabel29)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(jLabel28))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(lblTotalExpenses)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel24)
                        .addGap(312, 312, 312))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel28)))))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(lblTotalExpenses)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1658, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnLogout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout1ActionPerformed
        MyProfile profile = new MyProfile();
        profile.setVisible(true);
    }//GEN-LAST:event_btnLogout1ActionPerformed

    private void btnVeterinaryServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeterinaryServicesActionPerformed
        VeterinaryServices services = new VeterinaryServices();
        services.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVeterinaryServicesActionPerformed

    private void btnPetRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetRecordsActionPerformed
        Petrecords records = new Petrecords();
        records.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPetRecordsActionPerformed

    private void btnMyAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyAppointmentsActionPerformed
        Myappointment app = new Myappointment();
        app .setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMyAppointmentsActionPerformed

    private void btnBookAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookAppointmentActionPerformed

        BookAppointment bka = new BookAppointment();
        bka .setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBookAppointmentActionPerformed

    private void btnMyPetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyPetsActionPerformed
        MyPets pets = new MyPets();
        pets.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMyPetsActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
   Homepage page = new Homepage(UserSession.getUserId());;
   page.setVisible(true);
   this.dispose();
    }//GEN-LAST:event_btnDashboardActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Myappointment().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookAppointment;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnLogout1;
    private javax.swing.JButton btnMyAppointments;
    private javax.swing.JButton btnMyPets;
    private javax.swing.JButton btnPetRecords;
    private javax.swing.JButton btnVeterinaryServices;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotalExpenses;
    private javax.swing.JTable tblMyAppointments;
    // End of variables declaration//GEN-END:variables
}
