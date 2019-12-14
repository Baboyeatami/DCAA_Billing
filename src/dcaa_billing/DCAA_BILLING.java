/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_billing;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.AppUtil;

/**
 *
 * @author Jamie Eduardo Rosal <Jamiewertalmighty@gmail.com>
 */
public class DCAA_BILLING {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        try {
            // TODO code application logic here

            DBConnection.ReadIPaddress();
            DBConnection.init();
            PreparedStatement ps;
            ResultSet rs;
            Connection c = DBConnection.getConnection();
            ps = c.prepareStatement("Select Level from useaccounts where Level like 'admin'");
            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(" Admin Account Exist");
            } else {
                System.out.println("No admin Acccount");
                InsertAdminAccount();

            }

        } catch (Exception ex) {
            Logger.getLogger(DCAA_BILLING.class.getName()).log(Level.SEVERE, null, ex);
        }

        Login aLogin = new Login();

        aLogin.setVisible(true);

    }

    static void InsertAdminAccount() {

        try {
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;
            int UaccountNo = 0;
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            //  String.format("%010d", OrNumber);
            ps = c.prepareStatement("select count(Accountnumber) from  useaccounts");
            rs = ps.executeQuery();
            if (rs.next()) {
                UaccountNo = rs.getInt(1);
            }
            ps.close();;
            rs.close();

            ps = c.prepareStatement("insert into useaccounts (Accountnumber, Fname, Lname, Mname, Username, Password, Level, Date, createtime, User) values ('" + String.format("%05d", UaccountNo) + "','administrator','administrator','administrator','administrator','administrator','admin','" + timeStamp + "','" + timeStamp + "','2')");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Administrator account Created!");

        } catch (SQLException ex) {
            Logger.getLogger(User_accounts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
