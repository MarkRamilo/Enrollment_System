/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Generator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.Year;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public interface GenerateEmail {
    Year year = Year.now();
    final String domainName = "hogwarts.com.ph";
    StringBuilder emailAddress = new StringBuilder();
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
     
     static String generateEmail(String firstName, String lastName, int Student_ID) {
        emailAddress.append(year + "-");
        emailAddress.append(firstName.toLowerCase() + lastName.toLowerCase() + "@");
        emailAddress.append(domainName);
        
        return emailAddress.toString();
        
    }
}
