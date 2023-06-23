/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class PaymentInfo implements DatabaseConnection {
    private int reference_ID;
    public PaymentInfo(int ReferenceNumber, String paymentAmount, String paymentMethod) {
        
        try (Connection con = connect()) {

            String sql1 = "Select Reference_ID from Reference where Reference_Number = ?";

            PreparedStatement pst = con.prepareStatement(sql1);
            pst.setInt(1, ReferenceNumber);

            ResultSet rs1 = pst.executeQuery();
            
            if (rs1.next()) {
                this.reference_ID = rs1.getInt("Reference_ID");
                
            }
            
            pst.close();

            String sql3 = "insert into Payment values(null, ?, ?, ?, Full Payment, current_timestamp())";

            PreparedStatement pst3 = con.prepareStatement(sql3);
            pst3.setString(1, paymentAmount);
            pst3.setString(2, paymentMethod);
            pst3.setInt(3, reference_ID);

            pst3.executeUpdate();
            pst3.close();

            String sql4 = "update registration_Details set Status_ID = 1 where Reference_ID = ?";

            PreparedStatement pst4 = con.prepareStatement(sql4);
            pst4.setInt(1, reference_ID);

            pst4.executeUpdate();
            pst4.executeUpdate();

            pst4.close();
            con.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    }
    
    @Override
    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
