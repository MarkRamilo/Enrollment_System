package Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;

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
}
