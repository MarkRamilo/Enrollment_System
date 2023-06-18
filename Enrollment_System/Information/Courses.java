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

public class Courses implements DatabaseConnection {

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
                // System.out.println("Check");
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
    
    public int getID() {
               
        throw new UnsupportedOperationException("Unimplemented method 'getID'");

    }

}
