package Connection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Random;

public interface DatabaseConnectionLocal {

    default Connection connect() {
        System.out.println("Connecting to database...");
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/oop2";
        try {
            return con = DriverManager.getConnection(url, "root","");

        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return null;
    }
  
}
