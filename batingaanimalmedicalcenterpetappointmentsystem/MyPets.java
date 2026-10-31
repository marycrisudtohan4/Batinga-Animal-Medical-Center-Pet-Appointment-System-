package batingaanimalmedicalcenterpetappointmentsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author arian
 */
public class MyPets extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MyPets.class.getName());

    /**
     * Creates new form MyPets
     */
public MyPets() {
    initComponents();
    
    // 1. Check the session first
    if (UserSession.getUserId() == 0) {
        JOptionPane.showMessageDialog(
            this,
            "Please log in first.",
            "Login Required",
            JOptionPane.WARNING_MESSAGE
        );
        
        new loginform().setVisible(true);
        this.dispose();
        return; // Stop execution here so it doesn't try to load pets
    }
    loadUserPets(UserSession.getUserId());
}
    
    // =====================================================
// LOAD ALL PETS OF CURRENT USER
// =====================================================    
public void loadUserPets(int loggedInUserId) {
    // 1. Add "Owner" to your column names array
    String[] columnNames = {"ID", "Pet Name", "Allergies", "Pet Type", "Breed", "Sex", "Age", "Weight", "Owner"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
     
    String url = "jdbc:mysql://localhost:3306/batinganimalmedicalcenter";
    String user = "root";
    String password = "";
     
    // 2. Update query to JOIN tbl_users and select the owner's fullname
    String query = "SELECT p.pet_id, p.pet_name, p.allergies, p.pet_type, p.breed, p.sex, p.age, p.weight, u.fullname AS owner_name " +
                   "FROM tbl_pet p " +
                   "JOIN tbl_users u ON p.user_id = u.user_id " +
                   "WHERE p.user_id = ?";
     
    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement pstmt = conn.prepareStatement(query)) {
         
        pstmt.setInt(1, loggedInUserId);
         
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int petId = rs.getInt("pet_id");
                String petName = rs.getString("pet_name");
                String allergies = rs.getString("allergies");
                String petType = rs.getString("pet_type");
                String breed = rs.getString("breed");
                String sex = rs.getString("sex");
                String age = rs.getString("age");
                String weight = rs.getString("weight");
                String ownerName = rs.getString("owner_name"); // Retrieve owner name
                 
                // 3. Include ownerName in the row data object matching the new column order
                model.addRow(new Object[]{petId, petName, allergies, petType, breed, sex, age, weight, ownerName});
            }
             
            jTable1.setModel(model);
             
            // 4. Keep the ID column (index 0) hidden from the user view
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(0).setWidth(0);
             
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error connecting to database: " + e.getMessage());
    }
}

private void loadPetsWithOwners() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);
    
    String query = "SELECT p.pet_id, p.pet_name, p.species, p.breed, u.fullname AS owner_name, u.contact_number " +
                   "FROM tbl_pet p " +
                   "JOIN tbl_users u ON p.user_id = u.user_id";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query);
         ResultSet rs = pstmt.executeQuery()) {
        
        while (rs.next()) {
            int petId = rs.getInt("pet_id");
            String petName = rs.getString("pet_name");
            String species = rs.getString("species");
            String breed = rs.getString("breed");
            String ownerName = rs.getString("owner_name");
            String contact = rs.getString("contact_number");
            
            // Add row to your table (make sure your table has columns for Owner Name and Contact!)
            model.addRow(new Object[]{petId, petName, species, breed, ownerName, contact});
        }
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error loading pet owners: " + e.getMessage());
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

        jLabel35 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnLogout1 = new javax.swing.JButton();
        btnVeterinaryServices = new javax.swing.JButton();
        btnPetRecords = new javax.swing.JButton();
        btnMyAppointments = new javax.swing.JButton();
        btnBookAppointment = new javax.swing.JButton();
        btnMyPets = new javax.swing.JButton();
        btnDashboard1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDashboard = new javax.swing.JButton();
        btnDashboard3 = new javax.swing.JButton();

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.72.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        label1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label1.setText("Manage your pet information.");

        label2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        label2.setText("My Pets");

        jPanel2.setBackground(new java.awt.Color(34, 92, 137));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(35, 93, 137));
        jLabel1.setForeground(new java.awt.Color(49, 113, 165));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/images-removebg-preview-1.png"))); // NOI18N
        jLabel1.setOpaque(true);
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 130, 150));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Batinga");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Animal Medical Center");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 20));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Pet Appointment System");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 20));

        btnLogout.setBackground(new java.awt.Color(0, 102, 153));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/logout-removebg-preview (1).png"))); // NOI18N
        btnLogout.setText("Log Out");
        btnLogout.setBorder(null);
        btnLogout.addActionListener(this::btnLogoutActionPerformed);
        jPanel2.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 680, 180, 50));

        btnLogout1.setBackground(new java.awt.Color(0, 102, 153));
        btnLogout1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout1.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/prof-removebg-preview (1).png"))); // NOI18N
        btnLogout1.setText("  Profile");
        btnLogout1.setBorder(null);
        btnLogout1.addActionListener(this::btnLogout1ActionPerformed);
        jPanel2.add(btnLogout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 180, 50));

        btnVeterinaryServices.setBackground(new java.awt.Color(0, 102, 153));
        btnVeterinaryServices.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVeterinaryServices.setForeground(new java.awt.Color(255, 255, 255));
        btnVeterinaryServices.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/inject-removebg-preview (2).png"))); // NOI18N
        btnVeterinaryServices.setText("Veterinary Services");
        btnVeterinaryServices.setBorder(null);
        btnVeterinaryServices.addActionListener(this::btnVeterinaryServicesActionPerformed);
        jPanel2.add(btnVeterinaryServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 180, 50));

        btnPetRecords.setBackground(new java.awt.Color(0, 102, 153));
        btnPetRecords.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPetRecords.setForeground(new java.awt.Color(255, 255, 255));
        btnPetRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/list-removebg-preview (2).png"))); // NOI18N
        btnPetRecords.setText("  Pet Records");
        btnPetRecords.setBorder(null);
        btnPetRecords.addActionListener(this::btnPetRecordsActionPerformed);
        jPanel2.add(btnPetRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 180, 50));

        btnMyAppointments.setBackground(new java.awt.Color(0, 102, 153));
        btnMyAppointments.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMyAppointments.setForeground(new java.awt.Color(255, 255, 255));
        btnMyAppointments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/pen-removebg-preview (1).png"))); // NOI18N
        btnMyAppointments.setText("  My Appointments");
        btnMyAppointments.setBorder(null);
        btnMyAppointments.addActionListener(this::btnMyAppointmentsActionPerformed);
        jPanel2.add(btnMyAppointments, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 180, 50));

        btnBookAppointment.setBackground(new java.awt.Color(0, 102, 153));
        btnBookAppointment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBookAppointment.setForeground(new java.awt.Color(255, 255, 255));
        btnBookAppointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/calendar-removebg-preview (1).png"))); // NOI18N
        btnBookAppointment.setText("  Book Appoinment");
        btnBookAppointment.setBorder(null);
        btnBookAppointment.addActionListener(this::btnBookAppointmentActionPerformed);
        jPanel2.add(btnBookAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 180, 50));

        btnMyPets.setBackground(new java.awt.Color(0, 102, 153));
        btnMyPets.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMyPets.setForeground(new java.awt.Color(255, 255, 255));
        btnMyPets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/paw-removebg-preview (1).png"))); // NOI18N
        btnMyPets.setText("  My Pets");
        btnMyPets.setBorder(null);
        btnMyPets.addActionListener(this::btnMyPetsActionPerformed);
        jPanel2.add(btnMyPets, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 180, 50));

        btnDashboard1.setBackground(new java.awt.Color(0, 102, 153));
        btnDashboard1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDashboard1.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/home-removebg-preview (1).png"))); // NOI18N
        btnDashboard1.setText("  Dashboard");
        btnDashboard1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnDashboard1.addActionListener(this::btnDashboard1ActionPerformed);
        jPanel2.add(btnDashboard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 180, 50));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Ionic-Ionicons-Paw-outline.96.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.128.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.128.png"))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.72.png"))); // NOI18N

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        btnDashboard.setBackground(new java.awt.Color(0, 102, 153));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Add Pet");
        btnDashboard.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnDashboard.addActionListener(this::btnDashboardActionPerformed);

        btnDashboard3.setBackground(new java.awt.Color(0, 102, 153));
        btnDashboard3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDashboard3.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard3.setText("Edit Pet");
        btnDashboard3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnDashboard3.addActionListener(this::btnDashboard3ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(194, 194, 194)
                                .addComponent(jLabel17)
                                .addGap(106, 106, 106)
                                .addComponent(jLabel18)
                                .addGap(149, 149, 149)
                                .addComponent(jLabel36))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnDashboard3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(116, 116, 116))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDashboard3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1713, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                .addContainerGap())
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
        AddPetsScreen screen = new AddPetsScreen();
        screen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnDashboard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboard1ActionPerformed
  Homepage page = new Homepage(UserSession.getUserId());;
   page.setVisible(true);
   this.dispose();
    }//GEN-LAST:event_btnDashboard1ActionPerformed

    private void btnDashboard3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboard3ActionPerformed
    int selectedRow = jTable1.getSelectedRow();
    
    // Validation: Check if a row is selected
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a pet from the table to edit.", "Selection Required", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Get the pet_id from the hidden first column
    int petId = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
    
    // Open the edit screen and pass the petId
    new editscreen(petId).setVisible(true);
    this.dispose();

    }//GEN-LAST:event_btnDashboard3ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new MyPets().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookAppointment;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnDashboard1;
    private javax.swing.JButton btnDashboard3;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnLogout1;
    private javax.swing.JButton btnMyAppointments;
    private javax.swing.JButton btnMyPets;
    private javax.swing.JButton btnPetRecords;
    private javax.swing.JButton btnVeterinaryServices;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}
