package Connection;

import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;

public interface DatabaseConnection {

    default Connection connect() {
        System.out.println("Connecting to database...");
        Connection con = null;


            //return con = DriverManager.getConnection(url, "Arceus", "m67Ds#rAm6");
        //String url = "jdbc:mysql://dusk.mysql.database.azure.com:3306/test_integration?useSSL=true";
        //String url = "jdbc:mysql://localhost:3306/test7";
        
        String url = "jdbc:mysql://localhost:3306/test4";
        // set url to local folder of database test7
        //String url = "jdbc:mysql:C:\\Users\\PC\\Documents\\NetBeansProjects\\Enrollment_System\\test7.db";
        try {
            // return con = DriverManager.getConnection(url, "Arceus", "m67Ds#rAm6");
            return con = DriverManager.getConnection(url, "root", "");

        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return null;
    }

    public int getID();
}
