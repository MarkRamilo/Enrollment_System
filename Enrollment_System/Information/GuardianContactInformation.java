/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PC
 */
public class GuardianContactInformation extends ContactInformation implements DatabaseConnection {

    String phone_Number;

    public GuardianContactInformation(int Address_ID, String email, String phone_Number) {

        super(Address_ID, email, phone_Number);

        this.phone_Number = phone_Number;
        try (Connection con = connect()) {

            String sql = "Insert into guardian_contact_info values(null, ?, ?, ?)";

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

    public int getGuardianContactInformationID() {

        try (Connection con = connect()) {

            String sql = "select Guardian_Contact_Info_ID from guardian_contact_info where Phone_Number = ? and Email = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, phone_Number);
            pst.setString(2, email);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int guardian_Contact_Info_ID = rs.getInt("Guardian_Contact_Info_ID");
                return guardian_Contact_Info_ID;
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;

    }
}
