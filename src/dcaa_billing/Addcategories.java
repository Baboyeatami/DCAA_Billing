/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_billing;

import java.awt.List;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jamie Eduardo Rosal <Jamiewertalmighty@gmail.com>
 */
public class Addcategories extends javax.swing.JFrame {

    DefaultComboBoxModel SYBoxModel, DepartBoxModel;
    ArrayList<String> Sydisplay = new ArrayList<String>();
    ArrayList<String> Dapartmentsdisplay = new ArrayList<String>();
    String Id_Category;
    ArrayList<String> idSydisplay = new ArrayList<String>();
    ArrayList<String> idDapartmentsdisplay = new ArrayList<String>();
    Category_of_Charges main;
    boolean updatemode = false;

    public Addcategories() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        Category = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        SchoolYear = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        Department = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setBounds(new java.awt.Rectangle(354, 252, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ADD TO CATEGORY", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Category Title:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, -1));

        Category.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jPanel1.add(Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 370, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Description:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 80, -1));

        ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ID.setForeground(new java.awt.Color(51, 204, 0));
        ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ID.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 120, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Category I.D :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        Description.setColumns(20);
        Description.setLineWrap(true);
        Description.setRows(5);
        jScrollPane3.setViewportView(Description);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 370, 80));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("CLOSE");
        jButton4.setActionCommand("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, 30));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("ADD TO CATEGORY");
        jButton5.setActionCommand("Add");
        jButton5.setMaximumSize(new java.awt.Dimension(127, 23));
        jButton5.setMinimumSize(new java.awt.Dimension(127, 23));
        jButton5.setPreferredSize(new java.awt.Dimension(127, 23));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 140, 30));

        SchoolYear.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        SchoolYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018-2019" }));
        SchoolYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchoolYearActionPerformed(evt);
            }
        });
        jPanel1.add(SchoolYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 170, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("SY:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 20, 20));

        Department.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018-2019" }));
        Department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentActionPerformed(evt);
            }
        });
        jPanel1.add(Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setText("Department:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 80, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (Category.getText() == null || Category.getText().equals("") || Category.getText().equals(" ")) {
            JOptionPane.showMessageDialog(this, "Invalid Category Data", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (Description.getText() == null || Description.getText().equals("") || Description.getText().equals(" ")) {
            JOptionPane.showMessageDialog(this, "Invalid Description Data", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else {

            if (updatemode) {
                Update_Fee();
                this.dispose();
            } else {
                SaveCategory();
                main.LoadFees();
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void SchoolYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchoolYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SchoolYearActionPerformed

    private void DepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DepartmentActionPerformed

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
            java.util.logging.Logger.getLogger(Addcategories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Addcategories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Addcategories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Addcategories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addcategories().setVisible(true);
            }
        });
    }

    void Clear_data() {
        Category.setText(null);
        Description.setText(null);

    }

    private void SaveCategory() {
        try {
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;

            Calendar cal = Calendar.getInstance();
            cal.getTime();
            SimpleDateFormat date2 = new SimpleDateFormat("yyyy/MM/d");
            SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");

            String Date = date2.format(cal.getTime());
            String Time = time.format(cal.getTime());

            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/d");

            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

            int SY = Integer.parseInt(idSydisplay.get(SchoolYear.getSelectedIndex()));
            int Departent = Integer.parseInt(idDapartmentsdisplay.get(Department.getSelectedIndex()));

            ps = c.prepareStatement("Insert into  category_of_charges (Charge_name,Description,Category_department,School_Year,createtime,User)values" + "('" + Category.getText() + "','" + Description.getText() + "','" + Departent + "','" + SY + "','" + timeStamp + "','100')");
            ps.execute();

            JOptionPane.showMessageDialog(this, "New category Added", "Category of Charges", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    private void Update_Fee() {
        try {
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;

            Calendar cal = Calendar.getInstance();
            cal.getTime();

            //String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            // int category = Integer.parseInt(idCategory.get(Category.getSelectedIndex()));
            ps = c.prepareStatement("Update category_of_charges set Charge_Name='" + Category.getText() + "', Description='" + Description.getText() + "', Category_Department='" + idDapartmentsdisplay.get(Department.getSelectedIndex()) + "', School_Year='" + idSydisplay.get(SchoolYear.getSelectedIndex()) + "' where idCategory_of_charges='" + Id_Category + "'");
            ps.execute();
            JOptionPane.showMessageDialog(this, "Charge Updated ");
            main.LoadFees();
            dispose();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    void set_Update(boolean update, String id, Category_of_Charges cc) {
        updatemode = update;
        Id_Category = id;
        main = cc;
        jButton5.setText("Save Changes");
    }

    void loadDAta_toUpdate() {
        try {
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;
            ps = c.prepareStatement("Select idCategory_of_charges, Charge_Name, Description, Category_Department, School_Year from category_of_charges where idCategory_of_charges='" + Id_Category + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                ID.setText(rs.getString(1));
                Category.setText(rs.getString(2));
                Description.setText(rs.getString(3));
                SchoolYear.setSelectedIndex(idSydisplay.indexOf(rs.getString(5)));
                Department.setSelectedIndex(idDapartmentsdisplay.indexOf(rs.getString(4)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Addcategories.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
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
            ps = c.prepareStatement("Select idCategory_Department,Department_Name from category_department");
            rs = ps.executeQuery();
            while (rs.next()) {
                Dapartmentsdisplay.add(rs.getString(2));
                idDapartmentsdisplay.add(rs.getString(1));

            }

            rs.close();

            SYBoxModel = new DefaultComboBoxModel(Sydisplay.toArray());
            DepartBoxModel = new DefaultComboBoxModel(Dapartmentsdisplay.toArray());
            SchoolYear.setModel(SYBoxModel);
            Department.setModel(DepartBoxModel);

            System.out.println(idSydisplay);
            System.out.println(idDapartmentsdisplay);

        } catch (SQLException ex) {
            Logger.getLogger(Addcategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void Set_Main_Class(Category_of_Charges cc) {
        main = cc;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Category;
    private javax.swing.JComboBox<String> Department;
    private javax.swing.JTextArea Description;
    private javax.swing.JLabel ID;
    private javax.swing.JComboBox<String> SchoolYear;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
