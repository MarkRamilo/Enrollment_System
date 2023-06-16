package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DatabaseConnection;
import java.sql.DriverManager;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class ClassProgram implements DatabaseConnection {

    public int getClassProgramID(String ClassProgram) {
        // get curriculum id from database using curriculum
        try (Connection con = connect()) {
            
           String sql = "SELECT Class_Program_ID FROM Class_Program WHERE Program_Name = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ClassProgram);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
               int Class_Program_ID = rs.getInt("Class_Program_ID");
                return Class_Program_ID;

            }    
            
        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;
    }
    
    public String[] getPrograms() {
        try (Connection con = connect()) {
            
            Statement st = con.createStatement();

            String sql = "select Program_Name from Class_Program";
            
            ResultSet rs = st.executeQuery(sql);
            
            ArrayList<String> items = new ArrayList();


            while (rs.next()) {
                String a = rs.getString("Program_Name");
                items.add(a);
            }  
            items.add(0, "Courses");
            st.close();
            String[] subItems = new String[items.size()];
            items.toArray(subItems);
            return subItems;

        
            
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;

    }
}
