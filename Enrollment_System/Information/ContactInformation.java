package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.DatabaseConnection;

public class ContactInformation implements DatabaseConnection {

    String phone_Number;
    String email;

    public ContactInformation(int Address_ID, String email, String phone_Number) {

        this.phone_Number = phone_Number;
        this.email = email;

        try (Connection con = connect()) {

            String sql = "Insert into contact_info values(null, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Address_ID);
            pst.setString(2, email);
            pst.setString(3, phone_Number);

            pst.executeUpdate();
            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public int getContactInformationID() {

        try (Connection con = connect()) {

            String sql = "select Contact_Info_ID from contact_info where Phone_Number = ? and Email = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, phone_Number);
            pst.setString(2, email);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int Contact_Info_ID = rs.getInt("Contact_Info_ID");
                return Contact_Info_ID;
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;

    }
}