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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author Jamie Eduardo Rosal <Jamiewertalmighty@gmail.com>
 */
public class Methods_class {
    
    
    private void SavedData(){
        try {
            DBConnection.init();
            Connection c =DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            String generatedID = null;
             ps=c.prepareStatement("select count(idPhoneList) from phonelist");
             rs=ps.executeQuery();
             if (rs.next()) {
                   int count =Integer.parseInt(rs.getString(1));
                   
                   generatedID=new SimpleDateFormat("yyyy").format(new Date())+String.format("%07d",count+1);
                    System.out.println(generatedID);
            }
           
            //ps=c.prepareStatement("Insert into phonelist (idphoneList,PhoneNum,Fname)values"+"('"+generatedID+"','"+Des.getText()+"','"+Status.getText()+"')");
            ps.execute(); 
            JOptionPane.showMessageDialog(null,"Inventory Saved! ",
                    "Inventory Information", JOptionPane.INFORMATION_MESSAGE);
             System.out.println("data saved");
           
                       
          
        } catch (SQLException ex) {
       //     Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    
    }

}
