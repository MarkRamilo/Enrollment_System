package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DatabaseConnection;

public class Student extends Person implements DatabaseConnection {

    int user_ID;

    public Student(String firstName, String middleName, String lastName, int contact_info_ID,
            int user_ID, int Class_Program_ID) {
        super(firstName, middleName, lastName, contact_info_ID);
        this.user_ID = user_ID;
        try (Connection con = connect()) {

            String sql = "Insert into student values(null, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            
            pst.setString(1, firstName);
            pst.setString(2, middleName);
            pst.setString(3, lastName);
            pst.setInt(4, user_ID);
            pst.setInt(5, contact_info_ID);
            pst.setInt(6, Class_Program_ID);
            pst.executeUpdate();
            pst.executeQuery();
            System.out.println("Success adding student");

            pst.close();

        } catch (SQLException e) {
            e.getMessage();
        }

    }

    public int getStudentID() {
        // get studentid from database
        try (Connection con = connect()) {

            String sql = "select Student_ID from student where User_ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, user_ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int student_ID = rs.getInt("Student_ID");
                return student_ID;

            }         
            pst.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;

    }

}
