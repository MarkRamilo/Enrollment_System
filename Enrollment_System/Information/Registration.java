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
public class Registration implements DatabaseConnection {

    public Registration(int referenceID) {
        
        try (Connection con = connect()) {

            String sql = "Insert into Registration values(null, ?, 2, current_timestamp())";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, referenceID);
            
            pst.executeUpdate();
            pst.executeQuery();
            pst.close();

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
