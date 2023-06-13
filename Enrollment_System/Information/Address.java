/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Information;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DatabaseConnection;

/**
 *
 * @author arnol
 */
public class Address implements DatabaseConnection {

    String street;
    int city_ID;
    String Additional;

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
            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public int getAddressID() {

        try (Connection con = connect()) {

            // get address id from database
            String sql = "select Address_ID from address where House_Number = ? and city_ID = ? and street = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, street);
            pst.setInt(2, city_ID);
            pst.setString(3, Additional);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int address_ID = rs.getInt("Address_ID");
                return address_ID;
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;
    }

    public void printAddress() {
        // print street city_id and additional
        System.out.println("Street: " + street);
        System.out.println("City ID: " + city_ID);
        System.out.println("Additional: " + Additional);

    }
}
