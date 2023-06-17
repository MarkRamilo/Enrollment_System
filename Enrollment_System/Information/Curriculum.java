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


public class Curriculum implements DatabaseConnection {

    //Connect to Class Program Table
    public  int getCurriculumID(int ClassProgramID) {
        // get curriculum id from database using curriculum
        try (Connection con = connect()) {
            
           String sql = "SELECT Curriculum_ID FROM Student WHERE StudentID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ClassProgramID);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
               int Curriculum_ID = rs.getInt("Curriculum_ID");
                return Curriculum_ID;

            }    
            
        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;
    }
    

}
