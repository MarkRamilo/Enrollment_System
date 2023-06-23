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
public class AcademicYear implements DatabaseConnection {
    
    private int academicYearID;
    
    public AcademicYear(String year) {
        
        this.academicYearID = 0;
        
        try (Connection con = connect()) {

            String sql = "Insert into Academic_Year values(null, ?)";

            PreparedStatement pst = con.prepareStatement(year);
            
            pst.executeUpdate();
            pst.close();

            String sql2 = "select Academic_Year_ID from Academic_Year where Academic_Year = ?";
            PreparedStatement pst2 = con.prepareStatement(sql2);

            pst2.setString(1, year);
            
            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {
                int Academic_Year_ID = rs.getInt("Academic_Year_ID");
                this.academicYearID = Academic_Year_ID;
            }
            con.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    }
    
    public AcademicYear() {
        this.academicYearID = 0;
    }
    @Override
    public int getID() {
        return academicYearID;
        
    }
    
}
