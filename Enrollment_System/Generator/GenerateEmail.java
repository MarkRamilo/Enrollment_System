/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.time.Year;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @author PC
 */
public interface GenerateEmail {

    public default String generateEmail() {

        Year year = Year.now();
        final String domainName = "hogwarts.com.ph";
        StringBuilder emailAddress = new StringBuilder();

        String url = "jdbc:mysql://dusk.mysql.database.azure.com:3306/try?useSSL=true";
        try (Connection con = DriverManager.getConnection(url, "Arceus", "m67Ds#rAm6")) {
            emailAddress.append(year + "-");
            String number = "";
            for (int i = 0; i < 5; i++) {
                number += String.valueOf(new Random().nextInt(9));
            }
            emailAddress.append(number);
            emailAddress.append(domainName);
            String sql = "SELECT * FROM user WHERE email = ?";
           System.out.println(sql);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, emailAddress.toString());
            
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                return generateEmail();

            } else {
                return emailAddress.toString();
            }

        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;

    }
}
