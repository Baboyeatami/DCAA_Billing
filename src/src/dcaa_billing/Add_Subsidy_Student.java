/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_billing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jamie Eduardo Rosal <Jamiewertalmighty@gmail.com>
 */
public class Add_Subsidy_Student extends javax.swing.JFrame {

    Subsidy_List subsidy_List;
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<String> Sydisplay = new ArrayList<>();
    ArrayList<String> idSydisplay = new ArrayList<>();
    ArrayList<String> ChargeList = new ArrayList<>();
    DefaultComboBoxModel SYBoxModel;
    String SY_id;
    boolean batchpaaymentMode = false;

    /**
     * Creates new form Add_Subsidy_Student
     */
    public Add_Subsidy_Student() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        load_SYandDepartments();
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
        jLabel1 = new javax.swing.JLabel();
        StudentId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SY = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select Bill To Subsidize");
        setBounds(new java.awt.Rectangle(306, 76, 0, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Student ID:");

        StudentId.setText("jLabel2");

        jLabel3.setText("Name:");

        Name.setText("jLabel2");

        jLabel5.setText("School Year");

        SY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SY.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(StudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SY, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(321, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(StudentId)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Name)
                    .addComponent(SY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "DAte", "Date", "Reference Number", "Desciption", "Amount", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Total bill:");

        Total.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Total.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean count = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            count = (boolean) model.getValueAt(i, 6);

            if (count) {
                break;
            }
        }

        if (!count) {
            JOptionPane.showMessageDialog(this, "No Bill Selected", "Invalid Selection", JOptionPane.WARNING_MESSAGE);
        } else {
            int proceed = JOptionPane.showOptionDialog(this, "You selected multiple Bills \n Do you want to proceed?", "Bill Selection", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, 0);

            if (proceed == 0) {
                getSelectedFees();
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Add_Subsidy_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Subsidy_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Subsidy_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Subsidy_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Subsidy_Student().setVisible(true);
            }
        });
    }

    void loadStudent(String Id, String Name) {
        System.out.println(Id);
        StudentId.setText(Id);
        this.Name.setText(Name);
        System.out.println("SY_id Value:" + SY_id);
        SY_id = subsidy_List.SY_ID;
        System.out.println("Add Student Frame SY set to:" + SY_id);
        System.out.println("Add Student Frame SY set to index of:" + idSydisplay.indexOf(SY_id));
        LoadBilling(Id, SY_id);
        SY.setSelectedIndex(idSydisplay.indexOf(SY_id));

    }

    void LoadBilling(String Id, String Sy) {
        try {
            model.setRowCount(0);
            System.out.println(Sy + " School year");
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps, ps1, ps2;
            ResultSet rs, rs1, rs2;
            ps = c.prepareStatement("Select Bill_Date,ReferenceNo,Particulars,Amount,Discounts_idDiscounts,Fee_Charges_idFee_Charges from billing where Student_Info_idStudent_Info='" + Id + "' AND School_Year_idSchool_Year='" + Sy + "'");
            rs = ps.executeQuery();

            String discountDisplay = null;
            String display_Value = "";

            while (rs.next()) {
                if (rs.getString(5).equals("-1")) {
                    discountDisplay = "None";
                    display_Value = rs.getString(4);
                } else {
                    ps1 = c.prepareStatement("Select Value,Type from discounts where idDiscounts='" + rs.getString(5) + "'");
                    rs1 = ps1.executeQuery();
                    if (rs1.next()) {
                        if (rs1.getString(2).equals("0")) {
                            discountDisplay = rs1.getString(1) + "%";
                            ps2 = c.prepareStatement("Select Value from fee_charges where idFee_Charges='" + rs.getString(6) + "'");
                            rs2 = ps2.executeQuery();
                            if (rs2.next()) {
                                display_Value = rs2.getString(1);
                            }
                        } else {
                            discountDisplay = rs1.getString(1);
                            ps2 = c.prepareStatement("Select Value from fee_charges where idFee_Charges='" + rs.getString(6) + "'");
                            rs2 = ps2.executeQuery();
                            if (rs2.next()) {
                                display_Value = rs2.getString(1);
                            }

                        }

                    }

                }

                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), display_Value, discountDisplay, rs.getString(4), false});

            }
            rs.close();

            ps = c.prepareStatement("Select Sum(Amount) from billing where Student_Info_idStudent_Info='" + Id + "' AND School_Year_idSchool_Year='" + Sy + "'");
            rs = ps.executeQuery();

            if (rs.next()) {
                //double monthly=0;
                //monthly=Double.parseDouble(rs.getString(1))/10;
                Total.setText(rs.getString(1));
                //Monthly_instalment.setText(String.valueOf(monthly));
                //System.out.println(rs.getString(1));
                //  System.out.println(monthly);
            }

            rs.close();
            ps.close();
            SY.setSelectedIndex(idSydisplay.indexOf(Sy));

        } catch (SQLException ex) {
            Logger.getLogger(StudentBill.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void load_SYandDepartments() {

        try {

            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;
            ps = c.prepareStatement("Select idschool_year,School_Year,Semester from school_year");
            rs = ps.executeQuery();
            while (rs.next()) {
                Sydisplay.add(rs.getString(2) + "-" + rs.getString(3));
                idSydisplay.add(rs.getString(1));
            }
            rs.close();
            SYBoxModel = new DefaultComboBoxModel(Sydisplay.toArray());
            SY.setModel(SYBoxModel);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void getSelectedFees() {
        ArrayList<String> Selectedfee = new ArrayList();

        System.out.println("Model Row Count:" + model.getRowCount());
        for (int i = 0; i < model.getRowCount(); i++) {

            boolean selected = (boolean) model.getValueAt(i, 6);
            System.out.println("Selected row:" + i + " " + selected);

            if (selected) {
                Selectedfee.add((String) model.getValueAt(i, 1));
            }
        }

        subsidy_List.Selectedfee = Selectedfee;
        subsidy_List.AddSubssidy();
        subsidy_List.LoadData();

        System.out.println(Selectedfee);

    }

    void set_subsididyList(Subsidy_List cc) {
        subsidy_List = cc;
        SY_id = subsidy_List.SY_ID;
        System.out.println("Add Student Frame SY set to:" + SY_id);
        SY.setSelectedIndex(idSydisplay.indexOf(SY_id));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Name;
    private javax.swing.JComboBox<String> SY;
    private javax.swing.JLabel StudentId;
    private javax.swing.JLabel Total;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
