package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.Random;
import javax.swing.JOptionPane;

public class User implements DatabaseConnection {

    public String username;
    public String password;

    public User() {
        this.username = generateEmail();
        this.password = generatePassword();

        try (Connection con = connect()) {

            String sql = "INSERT INTO user(User_ID, Email, Password) VALUES(null, ?, ?) ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);

            ps.setString(2, password);
            ps.executeUpdate();
            ps.executeQuery();

            ps.close();

        } catch (Exception e) {
            e.getMessage();
        }
    }

    private String generateEmail() {

        Year year = Year.now();
        final String domainName = "@hogwarts.com.ph";
        StringBuilder emailAddress = new StringBuilder();

        try (Connection con = connect()) {
            emailAddress.append(year + "-");
            String number = "";
            for (int i = 0; i < 5; i++) {
                number += String.valueOf(new Random().nextInt(9));
            }
            emailAddress.append(number);
            emailAddress.append(domainName);
            String sql = "SELECT * FROM user WHERE email = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, emailAddress.toString());
            ResultSet rs = pst.executeQuery();

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

    private String generatePassword() {
        StringBuilder sb = new StringBuilder();

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String num = "0123456789";
        String specialChar = "!@#%";
        String combination = upper + upper.toLowerCase() + num + specialChar;

        for (int i = 0; i < 10; i++) {
            sb.append(combination.charAt(new Random().nextInt(combination.length())));

        }
        return sb.toString();
    }

    public int getUserID() {

        try (Connection con = connect()) {

            String sql = "SELECT User_ID FROM user WHERE Email = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int user_ID = rs.getInt("User_ID");
                return user_ID;

            }

        } catch (Exception e) {
            e.getMessage();
        }

        return 0;
    }

}
