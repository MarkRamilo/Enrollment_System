package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuardianContactInformation extends ContactInformation implements DatabaseConnection {

    private int guardian_Contact_Info_ID;

    public GuardianContactInformation(int Address_ID, String email, String phone_Number) {

        super(Address_ID, email, phone_Number);

        this.guardian_Contact_Info_ID = 0;

        try (Connection con = connect()) {

            String sql = "Insert into guardian_contact_info values(null, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Address_ID);
            pst.setString(2, email);
            pst.setString(3, phone_Number);

            pst.executeUpdate();
            pst.close();

            String sql2 = "select Guardian_Contact_Info_ID from guardian_contact_info where Phone_Number = ? and Email = ?";

            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst2.setString(1, phone_Number);
            pst2.setString(2, email);

            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {
                this.guardian_Contact_Info_ID = rs.getInt("Guardian_Contact_Info_ID");

            }

            con.close();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public int getID() {

        return guardian_Contact_Info_ID;

    }

}
