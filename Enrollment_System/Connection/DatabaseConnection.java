package Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public interface ConnectionToDatabase {

    default Connection connect() {
        System.out.println("Connecting to database...");
        String url="jdbc:mysql://dusk.mysql.database.azure.com:3306/try?useSSL=true";
        try (Connection con = DriverManager.getConnection(url, "Arceus", "m67Ds#rAm6")) {
            System.out.println("Connection Success.");
            return con;
            
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return null;
    }
    
    default String[] getCity() {
                String url="jdbc:mysql://dusk.mysql.database.azure.com:3306/sakila?useSSL=true";

        try (Connection con = DriverManager.getConnection(url, "Arceus", "m67Ds#rAm6")) {
                                System.out.println("6th");

            Statement st = con.createStatement();
            String sql = "select city from city";
                        System.out.println("5th");

            ResultSet rs = st.executeQuery(sql);
                        System.out.println("6th");

            //ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            ArrayList<String> items = new ArrayList();

            System.out.println("3rd");

            while (rs.next()) {
                String a = rs.getString("city");
                items.add(a);
            }
            System.out.println("4th");

            st.close();
            String[] subItems = new String[items.size()];
            //System.out.println(items.toString());
            items.toArray(subItems);
            System.out.println(Arrays.toString(subItems));
            return subItems;
            
            
        } catch (Exception e) {
                        System.out.println("2nd");

            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        return null;
    } 
}
