package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.DatabaseConnection;

public class StudentContactInformation extends ContactInformation implements DatabaseConnection {

    private int contact_Info_ID;

    public StudentContactInformation(int Address_ID, String email, String phoneNumber) {
        super(Address_ID,email, phoneNumber);
        
        this.contact_Info_ID = 0;

        try (Connection con = connect()) {

            String sql = "Insert into contact_info values(null, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Address_ID);
            pst.setString(2, email);
            pst.setString(3, phoneNumber);

            pst.executeUpdate();
            pst.close();

            String sql2 = "select Contact_Info_ID from contact_info where Address_ID = ? and Phone_Number = ? and Email = ?";

            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst2.setInt(1, Address_ID);
            pst2.setString(2, phoneNumber);
            pst2.setString(3, email);

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

    // print contact information class
    @Override
    public String toString() {
        String contactInfo = "";
        try (Connection con = connect()) {

            String sql = "select * from contact_info where Contact_Info_ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, contact_Info_ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                contactInfo = "Contact Information ID: " + rs.getInt("Contact_Info_ID") + "\n" + "Address ID: "
                        + rs.getInt("Address_ID") + "\n" + "Email: " + rs.getString("Email") + "\n" + "Phone Number: "
                        + rs.getString("Phone_Number") + "\n";

            }
            con.close();

        } catch (SQLException e) {
            e.getMessage();

        }
        return contactInfo;

    }
}