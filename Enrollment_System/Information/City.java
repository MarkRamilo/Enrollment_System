package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class City implements DatabaseConnection {

    private int city_ID;

    public City(String city) {
        
        this.city_ID = 0;
        
        try (Connection con = connect()) {

            String sql = "select City_ID from Cities where City = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, city);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int City_ID = rs.getInt("City_ID");
                this.city_ID = City_ID;

            }
            con.close();

        } catch (SQLException e) {
            e.getMessage();
        }

    }

    public City() {
        this.city_ID = 0;

    }

    public String[] getCity(int Province_ID) {

        try (Connection con = connect()) {

            String sql = "select City from Cities where Province_ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Province_ID);

            ResultSet rs = pst.executeQuery();

            // ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            ArrayList<String> items = new ArrayList<>();

            while (rs.next()) {
                String a = rs.getString("City");
                items.add(a);
            }
            items.add(0, "City");
            pst.close();
            String[] subItems = new String[items.size()];
            items.toArray(subItems);
            return subItems;

        } catch (SQLException e) {
            e.getMessage();
        }
        return null;

    }

    @Override
    public int getID() {
        return city_ID;

    }
}
