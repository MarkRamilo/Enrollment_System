package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.DatabaseConnection;

public class Student extends Person implements DatabaseConnection {

    String user_ID;
    int person_ID;
    int curriculum_ID;
    String year;

    public Student(String firstName, String middleName, String lastName, int address_ID, int contact_info_ID,
            String user_ID, int curriculum_ID, String year) {
        super(firstName, middleName, lastName, address_ID, contact_info_ID);

        this.user_ID = user_ID;
        this.curriculum_ID = curriculum_ID;

        try (Connection con = connect()) {

            String sql = "Insert into student values (null, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, firstName);
            pst.setString(2, middleName);
            pst.setString(3, lastName);
            pst.setString(4, user_ID);
            pst.setInt(5, address_ID);
            pst.setInt(6, contact_info_ID);
            pst.setInt(8, curriculum_ID);

            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            e.getMessage();
        }

    }

    public int getStudentID() {
        // get studentid from database
        try (Connection con = connect()) {
            Statement st = con.createStatement();

            String sql = "select student_ID from student where user_ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, user_ID);

            ResultSet rs = pst.executeQuery();

            int student_ID = rs.getInt("student_ID");

            st.close();
            return student_ID;

        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;

    }

}
