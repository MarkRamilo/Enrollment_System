/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Generator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.Year;
import java.time.Month;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public interface GenerateEmail1 {
    Year year = Year.now();
    Month month = Month.from(LocalDate.now());
    StringBuilder referenceNumber = new StringBuilder();
    
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
     
     static String generateReferenceNumber(String firstName, String lastName, int Student_ID) {
        
        
    }
}
