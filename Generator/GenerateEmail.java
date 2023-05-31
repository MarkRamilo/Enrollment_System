/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Generator;
import java.time.Year;

/**
 *
 * @author PC
 */
public interface GenerateEmail {
    Year year = Year.now();
    final String domainName = "hogwarts.com.ph";
    StringBuilder emailAddress = new StringBuilder();
    
     static String generateEmail(String firstName, String lastName) {
        emailAddress.append(year + "-");
        emailAddress.append(firstName.toLowerCase() + lastName.toLowerCase() + "@");
        emailAddress.append(domainName);
        
        return emailAddress.toString();
        
    }
}
