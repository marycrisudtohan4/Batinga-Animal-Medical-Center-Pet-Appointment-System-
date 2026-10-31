/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package batingaanimalmedicalcenterpetappointmentsystem;

/**
 *
 * @author arian
 */
public class adminvisitrecords extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(adminvisitrecords.class.getName());

private int storedPetId;
    private int storedAppointmentId;
    public adminvisitrecords() {
        initComponents();
    }

public adminvisitrecords(String appointmentId, String petId, String petName, String owner, String date, String reason) {
    initComponents();
    
    this.storedAppointmentId = Integer.parseInt(appointmentId);
    this.storedPetId = Integer.parseInt(petId);
    
    // Set the text to your specific GUI component variable names
    PetName1.setText(petName);
    Owner1.setText(owner);
    Date1.setText(date);
    ReasonforVisit.setText(reason);
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
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        PetName = new javax.swing.JLabel();
        ow = new javax.swing.JLabel();
        dat = new javax.swing.JLabel();
        txtVeterinarian = new java.awt.TextField();
        jPanel5 = new javax.swing.JPanel();
        po = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReasonforVisit = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        txtDiagnosis = new java.awt.TextField();
        jLabel23 = new javax.swing.JLabel();
        txtTreatment = new java.awt.TextField();
        PetName1 = new javax.swing.JLabel();
        Owner1 = new javax.swing.JLabel();
        Date1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Visit Record");

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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Veterinary Visit Record");

        jButton6.setBackground(new java.awt.Color(0, 102, 204));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Add a Visit Record");
        jButton6.addActionListener(this::jButton6ActionPerformed);

        PetName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PetName.setForeground(new java.awt.Color(0, 0, 0));
        PetName.setText("Pet:");

        ow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ow.setForeground(new java.awt.Color(0, 0, 0));
        ow.setText("Owner:");

        dat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dat.setForeground(new java.awt.Color(0, 0, 0));
        dat.setText("Time:");

        txtVeterinarian.addActionListener(this::txtVeterinarianActionPerformed);

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        po.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        po.setForeground(new java.awt.Color(0, 0, 0));
        po.setText("Reason for Visit:");

        ReasonforVisit.setBackground(new java.awt.Color(204, 204, 204));
        ReasonforVisit.setColumns(20);
        ReasonforVisit.setRows(5);
        jScrollPane1.setViewportView(ReasonforVisit);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Diagnosis:");

        txtDiagnosis.addActionListener(this::txtDiagnosisActionPerformed);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Treatment:");

        txtTreatment.addActionListener(this::txtTreatmentActionPerformed);

        PetName1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PetName1.setForeground(new java.awt.Color(0, 0, 0));
        PetName1.setText("pet");

        Owner1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Owner1.setForeground(new java.awt.Color(0, 0, 0));
        Owner1.setText("owner");

        Date1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Date1.setForeground(new java.awt.Color(0, 0, 0));
        Date1.setText("time");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Veterinarian:");

        jButton7.setBackground(new java.awt.Color(0, 102, 204));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Back");
        jButton7.addActionListener(this::jButton7ActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(PetName)
                                .addGap(44, 44, 44)
                                .addComponent(PetName1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ow)
                                    .addComponent(dat))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Date1)
                                    .addComponent(Owner1)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(po)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel22)
                                    .addComponent(jScrollPane1)
                                    .addComponent(txtDiagnosis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(24, 24, 24)
                                .addComponent(txtVeterinarian, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PetName)
                    .addComponent(PetName1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ow)
                    .addComponent(Owner1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dat)
                    .addComponent(Date1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(33, 33, 33)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVeterinarian, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(po)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

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
                        .addGap(2486, 2486, 2486)
                        .addComponent(jLabel20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30)
                        .addGap(564, 564, 564))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(jLabel38))
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(336, 336, 336)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(404, Short.MAX_VALUE)))
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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // 1. Get text values from your fields
String veterinarian = txtVeterinarian.getText().trim();
String diagnosis = txtDiagnosis.getText().trim();
String treatment = txtTreatment.getText().trim();

if (veterinarian.isEmpty() || diagnosis.isEmpty() || treatment.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please fill in all required visit record fields.", "Validation Error", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// 2. Database queries to insert the visit record and mark the appointment as 'Completed'
String insertVisitSql = "INSERT INTO tbl_visit_records (pet_id, appointment_id, visit_date, diagnosis, treatment, veterinarian) VALUES (?, ?, CURDATE(), ?, ?, ?)";
String updateAppointmentSql = "UPDATE tbl_appointments SET status = 'Completed' WHERE appointment_id = ?";

try (java.sql.Connection con = DBConnection.getConnection()) {
    
    // Disable auto-commit to run both operations as a transaction
    con.setAutoCommit(false);

    try (java.sql.PreparedStatement pstVisit = con.prepareStatement(insertVisitSql);
         java.sql.PreparedStatement pstAppt = con.prepareStatement(updateAppointmentSql)) {
        
        // Assuming you stored `petId` and `appointmentId` as variables in this class when passing data from the appointment list:
        pstVisit.setInt(1, storedPetId);       // Replace with your actual pet ID variable
        pstVisit.setInt(2, storedAppointmentId); // Replace with your actual appointment ID variable
        pstVisit.setString(3, diagnosis);
        pstVisit.setString(4, treatment);
        pstVisit.setString(5, veterinarian);
        pstVisit.executeUpdate();

        pstAppt.setInt(1, storedAppointmentId);
        pstAppt.executeUpdate();

        con.commit(); // Commit both queries successfully

        javax.swing.JOptionPane.showMessageDialog(this, "Visit record added successfully and appointment marked as Completed!");
        
        adminappointmentmanagement apptManagement = new adminappointmentmanagement();
        apptManagement.setVisible(true);
        this.dispose();
        
        // Optionally, close this window or return to appointment management
        this.dispose();

    } catch (Exception ex) {
        con.rollback(); // Roll back if anything fails
        throw ex;
    }

} catch (Exception e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Error saving visit record: " + e.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtVeterinarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVeterinarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVeterinarianActionPerformed

    private void txtDiagnosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiagnosisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiagnosisActionPerformed

    private void txtTreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTreatmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTreatmentActionPerformed

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

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       adminappointmentmanagement admin = new adminappointmentmanagement();
       admin.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new adminvisitrecords().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date1;
    private javax.swing.JLabel Owner1;
    private javax.swing.JLabel PetName;
    private javax.swing.JLabel PetName1;
    private javax.swing.JTextArea ReasonforVisit;
    private javax.swing.JButton btnBookAppointment;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnLogout1;
    private javax.swing.JButton btnMyPets;
    private javax.swing.JLabel dat;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ow;
    private javax.swing.JLabel po;
    private java.awt.TextField txtDiagnosis;
    private java.awt.TextField txtTreatment;
    private java.awt.TextField txtVeterinarian;
    // End of variables declaration//GEN-END:variables
}
