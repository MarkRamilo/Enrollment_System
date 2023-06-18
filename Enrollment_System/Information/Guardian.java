package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Guardian extends Person2 implements DatabaseConnection {

    private int guardian_ID;

    public Guardian(String name, String relationshipToStudent, int contact_info_ID) {
        super(name, contact_info_ID);

        this.guardian_ID = 0;

        try (Connection con = connect()) {

            String sql1 = "Select Guardian_ID from guardian where Name = ?";

            PreparedStatement pst = con.prepareStatement(sql1);
            pst.setString(1, name);

            ResultSet rs1 = pst.executeQuery();

            if (!rs1.next()) {
                String sql2 = "Insert into guardian values(null, ?, ?, ?)";

                PreparedStatement pst1 = con.prepareStatement(sql2);
                pst1.setString(1, name);
                pst1.setString(2, relationshipToStudent);
                pst1.setInt(3, contact_info_ID);

                pst1.executeUpdate();
                pst1.close();

            }
            pst.close();

            String sql3 = "select Guardian_ID from guardian where name = ?";

            PreparedStatement pst3 = con.prepareStatement(sql3);
            pst3.setString(1, name);

            ResultSet rs = pst3.executeQuery();

            if (rs.next()) {
                this.guardian_ID = rs.getInt("Guardian_ID");

            }
            con.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public int getID() {

        return guardian_ID;

    }

    // print guardian class
    @Override
    public String toString() {
        String guardian = "";
        try (Connection con = connect()) {

            String sql = "Select * from guardian where Guardian_ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, guardian_ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                guardian = rs.getString("Name") + " " + rs.getString("Relationship_To_Student") + " "
                        + rs.getInt("Contact_Info_ID");

            }
            con.close();

        } catch (SQLException e) {
            e.getMessage();

        }
        return guardian;
    }
}
