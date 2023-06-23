package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DatabaseConnection;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */


public class CurriculumCourses implements DatabaseConnection {

    //Connect to Class Program Table
    
    public  int[] getCoursesID(int CurriculumID) {
        // get curriculum id from database using curriculum
        try (Connection con = connect()) {
            
           String sql = "SELECT Courses_ID FROM curriculum_courses WHERE Curriculum_ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, CurriculumID);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

                //int columnsNumber = rsmd.getColumnCount();
                int i = 0;
                int[] courses = new int[i];
                
            while (rs.next()) {
                int a = rs.getInt("Courses_ID");
                courses = Arrays.copyOf(courses, ++i);
                courses[i-1] = a;
        
            }    
            //items.add(0, "City");

            ps.close();
            return courses;
           
                        
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }
    
    public  int getCurriculumCoursesID(int CurriculumID) {
        // get curriculum id from database using curriculum
        try (Connection con = connect()) {
            
           String sql = "SELECT Curriculum_Courses_ID FROM curriculum_courses WHERE CurriculumID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, CurriculumID);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
               int CurriculumCoursesID = rs.getInt("Curriculum_Courses_ID");
                return CurriculumCoursesID;

            }    
            
        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;
    }
<<<<<<< HEAD

    @Override
    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

=======
    

>>>>>>> parent of 42bd827 (Eto na)
}
