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

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jamie Eduardo Rosal <Jamiewertalmighty@gmail.com>
 */
public class Charge_list extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    StudentBill studentBill;
    Batch_posting main;
    boolean BatchPostMode = false;

    /**
     * Creates new form Charge_list
     */
    public Charge_list() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        searchBy = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Charge List");
        setBounds(new java.awt.Rectangle(400, 129, 600, 500));
        setMaximumSize(new java.awt.Dimension(600, 500));
        setPreferredSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 110, 40));

        jTable1.setBackground(new java.awt.Color(204, 255, 204));
        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fee ID", "Description", "Value", "Category", "Selected"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 560, 360));

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Search by:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 20));

        searchBy.setBackground(new java.awt.Color(255, 255, 255));
        searchBy.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        searchBy.setForeground(new java.awt.Color(0, 0, 0));
        searchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desciption", "Fee id", "Value", "Category" }));
        searchBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByActionPerformed(evt);
            }
        });
        jPanel1.add(searchBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Enter Keyword:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 110, 20));

        Search.setBackground(new java.awt.Color(255, 255, 255));
        Search.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Search.setForeground(new java.awt.Color(0, 0, 0));
        Search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                SearchCaretUpdate(evt);
            }
        });
        jPanel1.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        boolean count = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            count = (boolean) model.getValueAt(i, 4);

            if (count) {
                break;
            }
        }

        if (!count) {
            JOptionPane.showMessageDialog(this, "No Charges Selected", "Invalid Charge", JOptionPane.WARNING_MESSAGE);
        } else {
            int proceed = JOptionPane.showOptionDialog(this, "You selected multiple fees and charges \n Do you want to proceed?", "Fees and Charges", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, 0);

            if (proceed == 0) {
                getSeletedFEES();
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchByActionPerformed

    private void SearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_SearchCaretUpdate
        if (searchBy.getSelectedIndex() == 0) {
            loadData_Description();
        } else if (searchBy.getSelectedIndex() == 1) {
            loadData_FeeID();
        } else if (searchBy.getSelectedIndex() == 2) {
            loadData_Value();
        } else if (searchBy.getSelectedIndex() == 3) {
            loadData_Category_of_charges();
        }

    }//GEN-LAST:event_SearchCaretUpdate

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Charge_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Charge_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Charge_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Charge_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Charge_list().setVisible(true);
            }
        });
    }

    void loadData() {
        try {
            model.setRowCount(0);
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;
            ArrayList<String> feesArrayList = new ArrayList<>();
            ps = c.prepareStatement("Select idFee_Charges, Fee_Name, Description, Value, Category_of_charges from fee_charges");
            rs = ps.executeQuery();
            while (rs.next()) {
                feesArrayList.add(rs.getString(1));
                model.addRow(new Object[]{rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5), false});

            }
            System.out.println(feesArrayList);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void loadData_Description() {
        try {
            String s = "%" + Search.getText() + "%";
            model.setRowCount(0);
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;
            ArrayList<String> feesArrayList = new ArrayList<>();
            ps = c.prepareStatement("Select idFee_Charges, Fee_Name, Description, Value, Category_of_charges from fee_charges where Description like '" + s + "' ");
            rs = ps.executeQuery();
            while (rs.next()) {
                feesArrayList.add(rs.getString(1));
                model.addRow(new Object[]{rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5), false});

            }
            System.out.println(feesArrayList);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void loadData_FeeID() {
        try {
            String s = "%" + Search.getText() + "%";
            model.setRowCount(0);
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;
            ArrayList<String> feesArrayList = new ArrayList<>();
            ps = c.prepareStatement("Select idFee_Charges, Fee_Name, Description, Value, Category_of_charges from fee_charges where idFee_Charges like '" + s + "' ");
            rs = ps.executeQuery();
            while (rs.next()) {
                feesArrayList.add(rs.getString(1));
                model.addRow(new Object[]{rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5), false});

            }
            System.out.println(feesArrayList);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void loadData_Value() {
        try {
            String s = "%" + Search.getText() + "%";
            model.setRowCount(0);
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;
            ArrayList<String> feesArrayList = new ArrayList<>();
            ps = c.prepareStatement("Select idFee_Charges, Fee_Name, Description, Value, Category_of_charges from fee_charges where Value like '" + s + "' ");
            rs = ps.executeQuery();
            while (rs.next()) {
                feesArrayList.add(rs.getString(1));
                model.addRow(new Object[]{rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5), false});

            }
            System.out.println(feesArrayList);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void loadData_Category_of_charges() {
        try {
            String s = "%" + Search.getText() + "%";
            model.setRowCount(0);
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;
            ArrayList<String> feesArrayList = new ArrayList<>();
            ps = c.prepareStatement("Select idFee_Charges, Fee_Name, Description, Value, Category_of_charges from fee_charges where Category_of_charges like '" + s + "' ");
            rs = ps.executeQuery();
            while (rs.next()) {
                feesArrayList.add(rs.getString(1));
                model.addRow(new Object[]{rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5), false});

            }
            System.out.println(feesArrayList);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void getSeletedFEES() {
        ArrayList<String> Selectedfee = new ArrayList();
        for (int i = 0; i < model.getRowCount(); i++) {
            boolean selected = (boolean) model.getValueAt(i, 4);
            if (selected) {
                Selectedfee.add((String) model.getValueAt(i, 0));
            }
        }

        if (BatchPostMode) {
            main.Chargelist = Selectedfee;
            main.loadDisplayChargeList();
            dispose();

        } else {

            studentBill.setChargelist(Selectedfee);
            studentBill.RefreshBill();
            dispose();
        }
    }

    void set_BatchPostingmode(boolean mode, Batch_posting cc) {
        BatchPostMode = mode;
        main = cc;

    }

    public void setStudentBill(StudentBill a) {
        studentBill = a;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Search;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> searchBy;
    // End of variables declaration//GEN-END:variables
}
