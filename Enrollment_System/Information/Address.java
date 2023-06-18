package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.DatabaseConnection;

public class Address implements DatabaseConnection {

    private int address_ID;

    public Address(String street, int city_ID, String Additional) {
        // TODO Auto-generated constructor stub

        try (Connection con = connect()) {

            String sql = "Insert into Address values(null, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, street);
            pst.setInt(2, city_ID);
            pst.setString(3, Additional);

            pst.executeUpdate();
            pst.executeQuery();
            pst.close();

            String sql2 = "select Address_ID from address where House_Number = ? and city_ID = ? and street = ?";
            PreparedStatement pst2 = con.prepareStatement(sql2);

            pst2.setString(1, street);
            pst2.setInt(2, city_ID);
            pst2.setString(3, Additional);

            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {
                this.address_ID = rs.getInt("Address_ID");

            }
            con.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public int getID() {
        return address_ID;

    }
}