package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.DatabaseConnection;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Semester implements DatabaseConnection {

     public String[] getSemester() {
        // get curriculum id from database using curriculum

        try (Connection con = connect()) {
            
            Statement st = con.createStatement();
            String sql = "SELECT Semester FROM semester s, academic_year a " +
                          "where s.Academic_Year_ID = a.Academic_Year_ID AND a.Academic_Year = 2023";
                  ResultSet rs = st.executeQuery(sql);
                  
            // ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            ArrayList<String> items = new ArrayList<>();

            while (rs.next()) {
                String a = rs.getString("Semester");
                items.add(a);
            }
            items.add(0, "Semester");
            st.close();
            String[] subItems = new String[items.size()];
            items.toArray(subItems);
            return subItems;

        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }
    
    public int getID() {

        throw new UnsupportedOperationException("Unimplemented method 'getID'");

    }

    public ArrayList<String[]> getCourses(int user_ID) {

        ArrayList<String[]> items = new ArrayList<>();

        try (Connection con = connect()) {

            // PreparedStatement pst = con.prepareStatement(sql);
            String sql = "select c.Courses_Code, c.Courses_Name, c.Course_Credits\n" +
                    "from student s, curriculum_courses cc, curriculum cu, courses c\n" +
                    "where s.Class_Program_ID = cu.Class_Program_ID\n" +
                    "and cu.Curriculum_ID = cc.Curriculum_ID\n" +
                    "and cc.Courses_ID = c.Courses_ID\n" +
                    "and s.User_ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, user_ID);

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

            // int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                String courses_Code = rs.getString("c.Courses_Code");
                String courses_Name = rs.getString("c.Courses_Name");
                String course_Credits = rs.getString("c.Course_Credits");
                items.add(new String[] { courses_Code, courses_Name, course_Credits });
            }
            pst.close();
            con.close();
            return items;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return null;
    }

}
