package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Connection.DatabaseConnection;

public class ClassStudent implements DatabaseConnection {

    public ClassStudent(int class_ID, int student_ID) {

        try (Connection con = connect()) {

            String sql = "Insert into class_student values(null, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, class_ID);
            pst.setInt(2, student_ID);

            pst.executeUpdate();
            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            e.getMessage();
        }

    }

    @Override
    public int getID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getID'");
    }
}
