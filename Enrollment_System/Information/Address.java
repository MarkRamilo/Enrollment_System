/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Information;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DatabaseConnection;

/**
 *
 * @author arnol
 */
public class Address implements DatabaseConnection {

    public String[] getProvince() throws SQLException {

        Connection con = connect();
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
    }

    protected String[] getCity(int province_ID) throws SQLException {

        Connection con = connect();
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
    }
}
