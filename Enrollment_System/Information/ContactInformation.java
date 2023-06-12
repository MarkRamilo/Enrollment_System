package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.DatabaseConnection;

public class ContactInformation implements DatabaseConnection {

    String contact_Number;
    String email;

    public ContactInformation(String contact_Number, String email) {
        this.contact_Number = contact_Number;
        this.email = email;

        try (Connection con = connect()) {

            String sql = "Insert into contact_info values (null, ?, ?, null)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, contact_Number);
            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public int getContactInformationID() {

        try (Connection con = connect()) {
            Statement st = con.createStatement();

            String sql = "select contact_info_ID from contact_info where contact_number = ? and email = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, contact_Number);
            pst.setString(2, email);

            ResultSet rs = pst.executeQuery();

            int contact_info_id = rs.getInt("contact_info_id");

            st.close();
            return contact_info_id;

        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;

    }
}