package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DatabaseConnection;

public class Student extends Person implements DatabaseConnection {

    private int student_ID;

    public Student(String firstName, String middleName, String lastName, int contact_info_ID,
            int user_ID, int Class_Program_ID) {
        super(firstName, middleName, lastName, contact_info_ID);

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
            pst.close();

            String sql2 = "select Student_ID from student where User_ID = ?";

            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst2.setInt(1, user_ID);

            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {
                this.student_ID = rs.getInt("Student_ID");

            }
            pst2.close();
            con.close();

        } catch (SQLException e) {
            e.getMessage();
        }

    }

    @Override
    public int getID() {

        return student_ID;

    }

}
