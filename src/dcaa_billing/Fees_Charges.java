/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_billing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jamie Eduardo Rosal <Jamiewertalmighty@gmail.com>
 */
public class Fees_Charges extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel();
    String Fee_id;
    Add_update_chargesandfees add_update_chargesandfees = null;
    Add_update_chargesandfees charge_info = null;
    JMenuItem UpdateFee = new JMenuItem("Update Fee");
    JMenuItem Delete = new JMenuItem("Delete Fee");
    JPopupMenu menu = new JPopupMenu();
    Fees_Charges main = this;
    int User;
    private static DecimalFormat df2 = new DecimalFormat("#,###.##");

    /**
     * Creates new form StudentInfo
     */
    public Fees_Charges() {

        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        loaddata();
        setBounds(88, 5, 1021, 515);

        UpdateFee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (add_update_chargesandfees == null) {
                    add_update_chargesandfees = new Add_update_chargesandfees();
                    add_update_chargesandfees.setUpdatemode(true, Fee_id, main);
                    add_update_chargesandfees.Load_data();
                    add_update_chargesandfees.setVisible(true);
                } else {
                    add_update_chargesandfees.setUpdatemode(true, Fee_id, main);
                    add_update_chargesandfees.Load_data();
                    add_update_chargesandfees.setVisible(true);

                }

            }
        });

        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete_Fee(Fee_id);
            }
        });

        menu.add(UpdateFee);
        menu.add(Delete);

        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    menu.show(e.getComponent(), e.getX(), e.getY());
                }
            }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        SearchCriteria = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 102));
        setClosable(true);
        setIconifiable(true);
        setTitle("Fees and Charges");
        setMaximumSize(new java.awt.Dimension(1200, 550));
        setMinimumSize(new java.awt.Dimension(1021, 515));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1021, 515));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Close");
        jButton3.setPreferredSize(new java.awt.Dimension(127, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 430, 130, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("ADD CHARGES");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 150, 40));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("UPDATE EXISTING");
        jButton4.setPreferredSize(new java.awt.Dimension(127, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 150, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Search by:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 20));

        SearchCriteria.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        SearchCriteria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fee ID", "Name", "Value", "Category", "" }));
        SearchCriteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchCriteriaActionPerformed(evt);
            }
        });
        getContentPane().add(SearchCriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 210, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter Keyword:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 110, 20));

        Search.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                SearchCaretUpdate(evt);
            }
        });
        getContentPane().add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 270, -1));

        jTable1.setBackground(new java.awt.Color(204, 255, 204));
        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fee ID", "Name", "Value", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1020, 380));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("Refresh");
        jButton5.setPreferredSize(new java.awt.Dimension(127, 23));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 130, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if (add_update_chargesandfees == null) {
            add_update_chargesandfees = new Add_update_chargesandfees();
            add_update_chargesandfees.set_Main(this);
            add_update_chargesandfees.setVisible(true);
        } else {
            add_update_chargesandfees = null;
            add_update_chargesandfees = new Add_update_chargesandfees();
            add_update_chargesandfees.set_Main(this);
            add_update_chargesandfees.setVisible(true);

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void SearchCriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchCriteriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchCriteriaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (add_update_chargesandfees == null) {
            add_update_chargesandfees = new Add_update_chargesandfees();
            add_update_chargesandfees.setUpdatemode(true, Fee_id, main);
            add_update_chargesandfees.Load_data();
            add_update_chargesandfees.setVisible(true);
        } else {
            add_update_chargesandfees.setUpdatemode(true, Fee_id, main);
            add_update_chargesandfees.Load_data();
            add_update_chargesandfees.setVisible(true);

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        System.out.println(String.valueOf(model.getValueAt(jTable1.getSelectedRow(), 0)));
        Fee_id = String.valueOf(model.getValueAt(jTable1.getSelectedRow(), 0));

    }//GEN-LAST:event_jTable1MouseClicked

    private void SearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_SearchCaretUpdate
        // TODO add your handling code here:
        if (SearchCriteria.getSelectedItem().equals("Fee ID")) {
            LoadSearchID();
        } else if (SearchCriteria.getSelectedItem().equals("Name")) {
            LoadSearchDescription();
        } else if (SearchCriteria.getSelectedItem().equals("Value")) {
            LoadSearchValue();
        } else if (SearchCriteria.getSelectedItem().equals("Category")) {
            LoadSearchCategory_of_charges();
        }

    }//GEN-LAST:event_SearchCaretUpdate

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        loaddata();
    }//GEN-LAST:event_jButton5ActionPerformed

    void loaddata() {
        try {
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;
            model.setRowCount(0);
            ps = c.prepareStatement("Select idFee_Charges, Fee_Name, Value, Category_of_charges from fee_charges");
            rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), df2.format(rs.getDouble(3)), rs.getString(4)});
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Fees_Charges.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void Delete_Fee(String id) {
        try {
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;
            ps = c.prepareStatement("Delete from fee_charges where idFee_Charges ='" + id + "'");
            ps.execute();
            JOptionPane.showMessageDialog(this, "Selected Fee with Fee ID " + id + " deleted");
            Activity_log("Delete Fee", "Deleted Fee with Fee ID " + id);
            loaddata();

        } catch (SQLException ex) {
            Logger.getLogger(Fees_Charges.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void Activity_log(String Transaction, String Number) {

        try {
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

            ps = c.prepareStatement("Insert into activity_log ( Activity_name, Description, Date, UseAccounts_idUseAccounts) values ('Deleted Charge','" + Number + "','" + timeStamp + "','" + User + "')");
            ps.execute();
            System.out.println("Deleted activity loged ");

        } catch (SQLException ex) {
            Logger.getLogger(Section.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void LoadFeeINfo() {

        try {
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = c.prepareStatement("Select idFee_Charges, Fee_Name, Description, Value, Category_of_charges from fee_charges where idFee_Charges='" + Fee_id + "' ");
            rs = ps.executeQuery();

            if (rs.next()) {

            }

        } catch (SQLException ex) {
            Logger.getLogger(Fees_Charges.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void LoadSearchID() {

        try {
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;

            model.setRowCount(0);
            String S = "%" + Search.getText() + "%";

            ps = c.prepareStatement("Select idFee_Charges, Fee_Name, Value, Category_of_charges from fee_charges where idFee_Charges like '" + S + "' ");
            rs = ps.executeQuery();

            if (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});

            }

        } catch (SQLException ex) {
            Logger.getLogger(Fees_Charges.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void LoadSearchDescription() {

        try {
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;

            model.setRowCount(0);
            String S = "%" + Search.getText() + "%";

            ps = c.prepareStatement("Select idFee_Charges, Fee_Name, Value, Category_of_charges from fee_charges where Fee_Name like '" + S + "' ");
            rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});

            }

        } catch (SQLException ex) {
            Logger.getLogger(Fees_Charges.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void LoadSearchValue() {

        try {
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;

            model.setRowCount(0);
            String S = "%" + Search.getText() + "%";

            ps = c.prepareStatement("Select idFee_Charges, Fee_Name, Value, Category_of_charges from fee_charges where  Value like '" + S + "' ");
            rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});

            }

        } catch (SQLException ex) {
            Logger.getLogger(Fees_Charges.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void LoadSearchCategory_of_charges() {

        try {
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;

            model.setRowCount(0);
            String S = "%" + Search.getText() + "%";

            ps = c.prepareStatement("Select idFee_Charges, Fee_Name, Value, Category_of_charges from fee_charges where  Category_of_charges like '" + S + "' ");
            rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});

            }

        } catch (SQLException ex) {
            Logger.getLogger(Fees_Charges.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Search;
    private javax.swing.JComboBox<String> SearchCriteria;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
