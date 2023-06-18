package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.DatabaseConnection;

public class ContactInformation implements DatabaseConnection {

    private int contact_Info_ID;

    public ContactInformation(int Address_ID, String email, String phoneNumber) {

        try (Connection con = connect()) {

            String sql = "Insert into contact_info values(null, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Address_ID);
            pst.setString(2, email);
            pst.setString(3, phoneNumber);

            pst.executeUpdate();
            pst.executeQuery();
            pst.close();

            String sql2 = "select Contact_Info_ID from contact_info where Phone_Number = ? and Email = ?";

            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst2.setString(1, phoneNumber);
            pst2.setString(2, email);

            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {
                this.contact_Info_ID = rs.getInt("Contact_Info_ID");

            }
            con.close();

        } catch (SQLException e) {
            e.getMessage();

        }
    }

    @Override
    public int getID() {

        return contact_Info_ID;

    }
}