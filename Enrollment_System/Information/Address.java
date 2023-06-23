package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.DatabaseConnection;

public class Address implements DatabaseConnection {

    private int address_ID;
    private String street;
    private int city_ID;
    private String Additional;

    public Address(String street, int city_ID, String Additional) {
        // TODO Auto-generated constructor stub
        this.street = street;
        this.city_ID = city_ID;
        this.Additional = Additional;
        try (Connection con = connect()) {

            String sql = "Insert into Address values(null, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, street);
            pst.setInt(2, city_ID);
            pst.setString(3, Additional);
            
            pst.executeUpdate();
            pst.close();

            String sql2 = "select Address_ID from address where House_Number = ? and city_ID = ? and street = ?";
            PreparedStatement pst2 = con.prepareStatement(sql2);

            pst2.setString(1, street);
            pst2.setInt(2, city_ID);
            pst2.setString(3, Additional);
            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {
                int Address_ID = rs.getInt("Address_ID");
                this.address_ID = Address_ID;
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

    // print address class
    @Override
    public String toString() {
        String address = "";
        try (Connection con = connect()) {

            String sql = "select * from address where Address_ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, address_ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                address = rs.getString("House_Number") + " " + rs.getString("Street") + " " + rs.getString("Additional")
                        + " " + rs.getString("City_ID");

            }
            con.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return address;
    }

}
