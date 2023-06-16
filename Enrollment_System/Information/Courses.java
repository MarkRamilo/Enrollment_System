package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DatabaseConnection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JTable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */


public class Courses implements DatabaseConnection {
    
    
     /*public String[] getCourseID(String[] Courses_Name) {
        // get curriculum id from database using curriculum
        try (Connection con = connect()) {
            
           String sql = "SELECT Courses_ID FROM courses WHERE Courses_Name = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            int[] batchResult = ps.executeBatch();
            
            ArrayList<String> items = new ArrayList();
            
            con.setAutoCommit(false);
            ps.setString(1, Courses_Name[0]);
            while (rs.next()) {
               String a = rs.getString("Courses_ID");
                items.add(a);
             }
            
            String[] subItems = new String[items.size()];
            items.toArray(subItems);
            return subItems;
            
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
     }*/
    

    public String[] getCourseInfo(String Courses_Name) {
        // get curriculum id from database using curriculum
        try (Connection con = connect()) {
            
           String sql = "SELECT Courses_Name, Course_Credits, Courses_Code, class.Class_ID "
                   + "FROM courses "
                   + "left join class on class.Courses_ID = courses.Courses_ID "
                   + "WHERE Courses_Name = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Courses_Name);
            ResultSet rs = ps.executeQuery();
            
               ArrayList<String> items = new ArrayList();
            if (rs.next()) {
                //System.out.println("Check");
               String a = rs.getString("Courses_Name");
               String b = rs.getString("Course_Credits");
               String c = rs.getString("Courses_Code");
               String d = rs.getString("class.Class_ID");
               
                items.add(a);
                items.add(b);
                items.add(c);
                items.add(d);

         } 
            
            String[] subItems = new String[items.size()];
            items.toArray(subItems);
            return subItems;     
            
        } catch (SQLException e) {
            e.getMessage();
        }
        
        return null;
    }
    public int getCourseCredits(int Courses_ID) {
        // get curriculum id from database using curriculum
        try (Connection con = connect()) {
            
           String sql = "SELECT Course_Credits FROM courses WHERE Courses_ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Courses_ID);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
               int Course_Credits= rs.getInt("Coures_Credits");
                return Course_Credits;

            }    
            
        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;
    }
    public String getCode(int Courses_ID) {
        // get curriculum id from database using curriculum
        try (Connection con = connect()) {
            
           String sql = "SELECT Courses_Code FROM courses WHERE Courses_ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Courses_ID);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
               String Courses_Code= rs.getString("Couress_Code");
                return Courses_Code;

            }    
            
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }
    
    public void print(String Courses_Name) {
        // get curriculum id from database using curriculum
        Courses us = new Courses();
         String[] courseInfo = new String[3];
        courseInfo = us.getCourseInfo(Courses_Name);
        
        for(int i = 0;i<3;i++){
        System.out.println(courseInfo[i]);
        }
        System.out.println("Test");
    }

}
