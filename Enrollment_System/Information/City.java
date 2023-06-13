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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class City implements DatabaseConnection {
    
    public String[] getCity() {

        
        try (Connection con = connect()) {
            
            Statement st = con.createStatement();

            String sql = "select City from Cities";
            
            ResultSet rs = st.executeQuery(sql);
            
            //ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            ArrayList<String> items = new ArrayList();


            while (rs.next()) {
                String a = rs.getString("City");
                items.add(a);
            }  
            items.add(0, "City");
            st.close();
            String[] subItems = new String[items.size()];
            items.toArray(subItems);
            return subItems;

        
            
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;

    }
    
    public int getCityID(String city) {

        
        try (Connection con = connect()) {
            
            String sql = "select City_ID from Cities where City = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, city);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int City_ID = rs.getInt("City_ID");
                return City_ID;

            }
    
        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;

    }
}
