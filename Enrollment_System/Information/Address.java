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
    String cityID;
    String Additional;

    public Address(String street, String city, String Additional) {
        // TODO Auto-generated constructor stub
        this.street = street;
        this.cityID = city;
        this.Additional = Additional;

        try (Connection con = connect()) {

            String sql = "Insert into Address values (null, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, street);
            pst.setString(2, cityID);
            pst.setString(3, Additional);
            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    }
    
    public String[] getProvince() {

        try (Connection con = connect()) {
            Statement st = con.createStatement();

            String sql = "select province from provinces";

            ResultSet rs = st.executeQuery(sql);

            ArrayList<String> items = new ArrayList<>();

            while (rs.next()) {
                String province = rs.getString("province");
                items.add(province);
            }
            items.add(0, "Province");

            String[] subItems = new String[items.size()];
            items.toArray(subItems);
            st.close();

            return subItems;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        return null;

    }

    public String[] getCity(int province_ID) {

        Connection con = connect();
        try {

            Statement st = con.createStatement();
            String sql = "select city from cities where province_ID = " + province_ID;

            ResultSet rs = st.executeQuery(sql);

            ArrayList<String> items = new ArrayList<>();

            while (rs.next()) {
                String city = rs.getString("city");
                items.add(city);
            }
            items.add(0, "City");

            String[] subItems = new String[items.size()];
            items.toArray(subItems);
            st.close();

            return subItems;

        } catch (SQLException e) {
            e.getMessage();
        }
        return null;

    }

    private int getCityID(String city) {

        
        try (Connection con = connect()) {

            Statement st = con.createStatement();
            String sql = "select city_ID from cities where city = " + city;

            ResultSet rs = st.executeQuery(sql);

            int city_ID = rs.getInt("city_ID");

            st.close();

            return city_ID;

        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;

    }

    public int getAddressID() {

        try (Connection con = connect()) {

            Statement st = con.createStatement();
            String sql = "select address_ID from Address where city_ID = " + cityID + " and additional = " + Additional;

            ResultSet rs = st.executeQuery(sql);

            int address_ID = rs.getInt("address_ID");

            st.close();

            return address_ID;

        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;
    }
}
