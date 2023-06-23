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

     public String[] getCourses() {
        // get curriculum id from database using curriculum

        try (Connection con = connect()) {
            
            Statement st = con.createStatement();
            String sql = "SELECT Courses_Name FROM courses ";
                  ResultSet rs = st.executeQuery(sql);

            // ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            ArrayList<String> items = new ArrayList<>();

            while (rs.next()) {
                String a = rs.getString("Courses_Name");
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
    
    public int getID() {

        throw new UnsupportedOperationException("Unimplemented method 'getID'");

    }
    
    public Courses() {

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
    
    public ArrayList<String> getCoursesRegistration(int user_ID) {

        ArrayList<String> items = new ArrayList<>();

        try (Connection con = connect()) {

            // PreparedStatement pst = con.prepareStatement(sql);
            String sql = "SELECT c.Courses_Name\n" +
"from courses c, class cl, registration_details rd, registration r, reference re, student s, user u\n" +
"WHERE c.Courses_ID = cl.Class_ID \n" +
"AND rd.Class_ID = cl.Class_ID\n" +
"AND rd.Registration_ID = r.Registration_ID\n" +
"and re.Student_ID = s.Student_ID\n" +
"AND s.User_ID = ?;";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, user_ID);

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

            // int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                items.add("Courses_Name");
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
