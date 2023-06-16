/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tables;

import Connection.DatabaseConnection;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import Information.CurriculumCourses;

/**
 *
 * @author asus
 */
public class CoursesTable extends JTable implements DatabaseConnection {
       
int curriculumID;
    public CoursesTable(int curriculumID){

        this.curriculumID = curriculumID;
        DefaultTableModel tableModel = (DefaultTableModel) this.getModel();
            // tableModel.addRow(tableContents);
            
            CurriculumCourses cc = new CurriculumCourses();
            
            try (Connection con = connect()) {
                
                // PreparedStatement pst = con.prepareStatement(sql);
                String sql ="SELECT Courses_Name,Course_Credits,Courses_Code FROM courses\n" +
                            "right join curriculum_courses on curriculum_courses.Courses_ID = courses.Courses_ID\n" +
                            "WHERE curriculum_courses.Curriculum_ID = ?;";


                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setInt(1, curriculumID);

                ResultSet rs = ps.executeQuery();
                
                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                //int columnsNumber = rsmd.getColumnCount();
                String[] rowNames = new String[3];

               rowNames[0] =  "Name";
               rowNames[1] =  "Credits";
               rowNames[2] =  "Code";
               

                tableModel.setColumnIdentifiers(rowNames);
                while (rs.next()) {
                    String name = rs.getString("Courses_Name");
                    String credits = rs.getString("Course_Credits");
                    String code = rs.getString("Courses_Code");
                    tableModel.addRow(new Object[] { name, credits, code });
                }
                    
                JOptionPane.showMessageDialog(null, "Success");
                ps.close();
                con.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());

            }
    }
   
    
}
