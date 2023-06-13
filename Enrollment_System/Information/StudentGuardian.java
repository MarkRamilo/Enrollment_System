package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentGuardian implements DatabaseConnection {

    public StudentGuardian(int Guardian_ID, int Student_ID) {

        try (Connection con = connect()) {

            String sql = "insert into Student_Guardian values (null, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Guardian_ID);
            pst.setInt(2, Student_ID);

            pst.executeUpdate();
            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            e.getMessage();
        }

    }

}
