
package batingaanimalmedicalcenterpetappointmentsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class adminappointmentmanagement extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(adminappointmentmanagement.class.getName());

    /**
     * Creates new form adminappointmentmanagement
     */
    public adminappointmentmanagement() {
        initComponents();
    }


    private void updateAppointmentStatus(String newStatus) {
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please select an appointment from the table first.", "Selection Required", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Assuming column 5 contains the current status string (Adjust the index if your status column is different)
    String currentStatus = jTable1.getValueAt(selectedRow, 5).toString();

    // RULE: If already Cancelled, it cannot be changed anymore
    if (currentStatus.equalsIgnoreCase("Cancelled")) {
        javax.swing.JOptionPane.showMessageDialog(this, "This appointment has already been cancelled and cannot be modified.", "Action Denied", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    // RULE: If already Approved, it cannot be rescheduled or modified further (unless you want to allow canceling an approved one, but per your rule: "if it's approved, it can't be rescheduled or cancelled anymore")
    if (currentStatus.equalsIgnoreCase("Approved") && (newStatus.equalsIgnoreCase("Rescheduled") || newStatus.equalsIgnoreCase("Cancelled"))) {
        javax.swing.JOptionPane.showMessageDialog(this, "Approved appointments cannot be rescheduled or cancelled.", "Action Denied", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    int appointmentId = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());

    String sql;
    boolean isReschedule = newStatus.equals("Rescheduled");
    String newDate = "";
    String newTime = "";

    if (isReschedule) {
        newDate = javax.swing.JOptionPane.showInputDialog(this, "Enter new date (YYYY-MM-DD):", "Reschedule Appointment", javax.swing.JOptionPane.QUESTION_MESSAGE);
        if (newDate == null || newDate.trim().isEmpty()) return;

        newTime = javax.swing.JOptionPane.showInputDialog(this, "Enter new time (e.g., 2:00 PM):", "Reschedule Appointment", javax.swing.JOptionPane.QUESTION_MESSAGE);
        if (newTime == null || newTime.trim().isEmpty()) return;

        sql = "UPDATE tbl_appointments SET appointment_date = ?, appointment_time = ?, status = ? WHERE appointment_id = ?";
    } else {
        sql = "UPDATE tbl_appointments SET status = ? WHERE appointment_id = ?";
    }

    try (java.sql.Connection con = DBConnection.getConnection();
         java.sql.PreparedStatement pst = con.prepareStatement(sql)) {
        
        if (isReschedule) {
            pst.setString(1, newDate.trim());
            pst.setString(2, newTime.trim());
            pst.setString(3, newStatus);
            pst.setInt(4, appointmentId);
        } else {
            pst.setString(1, newStatus);
            pst.setInt(2, appointmentId);
        }

        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Appointment status updated to '" + newStatus + "' successfully!");
            // Call your table refresh method here, e.g., loadAppointments();
        }

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error updating status: " + e.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnMyPets = new javax.swing.JButton();
        btnBookAppointment = new javax.swing.JButton();
        btnLogout1 = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Appointment Management");

        jPanel3.setBackground(new java.awt.Color(34, 92, 137));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(35, 93, 137));
        jLabel2.setForeground(new java.awt.Color(49, 113, 165));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/images-removebg-preview-1.png"))); // NOI18N
        jLabel2.setOpaque(true);
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 130, 150));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Batinga");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Animal Medical Center");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 20));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Pet Appointment System");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 20));

        btnDashboard.setBackground(new java.awt.Color(0, 102, 153));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/home-removebg-preview (1).png"))); // NOI18N
        btnDashboard.setText(" Homepage");
        btnDashboard.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnDashboard.addActionListener(this::btnDashboardActionPerformed);
        jPanel3.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 180, 50));

        btnMyPets.setBackground(new java.awt.Color(0, 102, 153));
        btnMyPets.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMyPets.setForeground(new java.awt.Color(255, 255, 255));
        btnMyPets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/paw-removebg-preview (1).png"))); // NOI18N
        btnMyPets.setText(" Pet Management");
        btnMyPets.setBorder(null);
        btnMyPets.addActionListener(this::btnMyPetsActionPerformed);
        jPanel3.add(btnMyPets, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 180, 50));

        btnBookAppointment.setBackground(new java.awt.Color(0, 102, 153));
        btnBookAppointment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBookAppointment.setForeground(new java.awt.Color(255, 255, 255));
        btnBookAppointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/calendar-removebg-preview (1).png"))); // NOI18N
        btnBookAppointment.setText("Appointment Management");
        btnBookAppointment.setBorder(null);
        btnBookAppointment.addActionListener(this::btnBookAppointmentActionPerformed);
        jPanel3.add(btnBookAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 180, 50));

        btnLogout1.setBackground(new java.awt.Color(0, 102, 153));
        btnLogout1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout1.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/prof-removebg-preview (1).png"))); // NOI18N
        btnLogout1.setText("Reports");
        btnLogout1.setBorder(null);
        btnLogout1.addActionListener(this::btnLogout1ActionPerformed);
        jPanel3.add(btnLogout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 180, 50));

        btnLogout.setBackground(new java.awt.Color(0, 102, 153));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/logout-removebg-preview (1).png"))); // NOI18N
        btnLogout.setText("Log Out");
        btnLogout.setBorder(null);
        btnLogout.addActionListener(this::btnLogoutActionPerformed);
        jPanel3.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 180, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Welcome, Admin!");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Here you can manage the appointments");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.128.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.128.png"))); // NOI18N

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.72.png"))); // NOI18N

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.72.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.128.png"))); // NOI18N

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.72.png"))); // NOI18N

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.72.png"))); // NOI18N

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.72.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/Microsoft-Fluentui-Emoji-Mono-Paw-Prints.128.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Appointment ID", "Pet Name", "Owner", "Service", "Time", "Status", "Reason for visit"
            }
        ));
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jScrollPane2.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(0, 102, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setBackground(new java.awt.Color(0, 102, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Approve");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setBackground(new java.awt.Color(0, 102, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Reschedule");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jButton5.setBackground(new java.awt.Color(0, 102, 204));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Search");
        jButton5.addActionListener(this::jButton5ActionPerformed);

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setForeground(new java.awt.Color(0, 102, 255));
        jDateChooser1.setDateFormatString("dd-MM-yyyy");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Date:");

        jButton6.setBackground(new java.awt.Color(0, 102, 204));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Add a Visit Record");
        jButton6.addActionListener(this::jButton6ActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(39, 39, 39))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batingaanimalmedicalcenterpetappointmentsystem/dogcat-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2210, 2210, 2210)
                                .addComponent(jLabel20))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(812, 812, 812)
                        .addComponent(jLabel40)
                        .addGap(127, 127, 127)
                        .addComponent(jLabel30)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel35)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(257, 257, 257))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1399, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addGap(10, 10, 10)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(278, 278, 278)
                    .addComponent(jLabel39)
                    .addContainerGap(1597, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(549, 549, 549)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel30)
                        .addGap(564, 564, 564))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel40))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(jLabel38))
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(336, 336, 336)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(404, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(257, 257, 257)
                    .addComponent(jLabel39)
                    .addContainerGap(528, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        updateAppointmentStatus("Cancelled");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        updateAppointmentStatus("Approved");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
updateAppointmentStatus("Rescheduled");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        java.util.Date selectedDate = jDateChooser1.getDate(); 
    
    if (selectedDate == null) {
        JOptionPane.showMessageDialog(this, "Please select a date from the calendar first.", "Validation Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Format the date to match MySQL date format (YYYY-MM-DD)
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    String dateStr = sdf.format(selectedDate);

    // 2. Query to fetch appointments matching the selected date
    // Note: Double-check that your table and column names match your database schema
String sql = "SELECT a.appointment_id, p.pet_name, u.fullname AS owner_name, a.service_type, a.appointment_time, a.status, a.reason_for_visit " +
             "FROM tbl_appointments a " +
             "JOIN tbl_pet p ON a.pet_id = p.pet_id " +
             "JOIN tbl_users u ON p.user_id = u.user_id " +
             "WHERE a.appointment_date = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, dateStr);
        ResultSet rs = pst.executeQuery();

        // 3. Populate your JTable model
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing table rows

        boolean found = false;
        while (rs.next()) {
            found = true;
            model.addRow(new Object[]{
    rs.getInt("appointment_id"),
    rs.getString("pet_name"),
    rs.getString("owner_name"),
    rs.getString("service_type"),      // Match your actual DB column
    rs.getString("appointment_time"),  // Match your actual DB column
    rs.getString("status"),
    rs.getString("reason_for_visit")
            });
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "No appointments found for " + dateStr, "Information", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error searching appointments: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please select an appointment first.", "Selection Required", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 1. Get the status from column index 5
    String status = jTable1.getValueAt(selectedRow, 5).toString();

    // 2. STRICTLY ALLOW ONLY IF APPROVED (Blocks Completed, Pending, Cancelled)
    if (!status.equalsIgnoreCase("Approved")) {
        javax.swing.JOptionPane.showMessageDialog(
            this, 
            "Visit records can only be added for 'Approved' appointments. Current status is: " + status, 
            "Action Denied", 
            javax.swing.JOptionPane.WARNING_MESSAGE
        );
        return; // Stops execution and prevents opening the window
    }

    // 3. Extract details and open visit records if approved
    String appointmentId = jTable1.getValueAt(selectedRow, 0).toString();
    String petName = jTable1.getValueAt(selectedRow, 1).toString();
    String owner = jTable1.getValueAt(selectedRow, 2).toString();
    String service = jTable1.getValueAt(selectedRow, 3).toString();
    String time = jTable1.getValueAt(selectedRow, 4).toString();
    String reason = jTable1.getValueAt(selectedRow, 6).toString();

    String petId = "";
    String query = "SELECT pet_id, appointment_date FROM tbl_appointments WHERE appointment_id = ?";
    String date = "";
    
    try (java.sql.Connection con = DBConnection.getConnection();
         java.sql.PreparedStatement pst = con.prepareStatement(query)) {
        
        pst.setString(1, appointmentId);
        try (java.sql.ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                petId = rs.getString("pet_id");
                date = rs.getString("appointment_date");
            }
        }
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error fetching appointment details: " + e.getMessage());
        return;
    }

    // Open the Visit Records window
    adminvisitrecords visitPage = new adminvisitrecords(appointmentId, petId, petName, owner, date, reason);
    visitPage.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
      Adminhome home = new Adminhome();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnMyPetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyPetsActionPerformed
        AdminPetmanage manage = new AdminPetmanage();
        manage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMyPetsActionPerformed

    private void btnBookAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookAppointmentActionPerformed

        adminappointmentmanagement app = new adminappointmentmanagement();
        app.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBookAppointmentActionPerformed

    private void btnLogout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout1ActionPerformed
        adminreports reports = new adminreports();
        reports.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnLogout1ActionPerformed

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

            adminlogin login = new adminlogin();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new adminappointmentmanagement().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookAppointment;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnLogout1;
    private javax.swing.JButton btnMyPets;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
