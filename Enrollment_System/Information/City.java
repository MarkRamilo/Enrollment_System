package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class City implements DatabaseConnection {

    private int city_ID;

    public City(String city) {
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

        this.city_ID = 0;

    }

    public City() {
        this.city_ID = 0;

    }

    public String[] getCity() {

        try (Connection con = connect()) {

            Statement st = con.createStatement();

            String sql = "select City from Cities";

            ResultSet rs = st.executeQuery(sql);

            // ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            ArrayList<String> items = new ArrayList<>();

            while (rs.next()) {
                String a = rs.getString("City");
                items.add(a);
            }
            items.add(0, "City");
            st.close();
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
