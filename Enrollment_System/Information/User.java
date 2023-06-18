package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Year;
import java.util.Random;
import javax.swing.JOptionPane;

public class User implements DatabaseConnection {

    private int user_ID;
    private String email;
    private String password;
    private boolean checkUser;
    public User() {
        
        this.user_ID = 0;
        
        try (Connection con = connect()) {

            String sql = "INSERT INTO user(User_ID, Email, Password) VALUES(null, ?, ?) ";

            PreparedStatement ps = con.prepareStatement(sql);
            String username = generateEmail();
            ps.setString(1, username);
            ps.setString(2, generatePassword());

            ps.executeUpdate();
            ps.close();

            String sql2 = "SELECT User_ID FROM user WHERE Email = ?";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setString(1, username);

            ResultSet rs = ps2.executeQuery();

            if (rs.next()) {
                this.user_ID = rs.getInt("User_ID");

            }

            con.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public User(String email, String password) {
        
        this.email = email;
        this.password = password;
        
        try (Connection con = connect()) {

            String sql = "select User_ID from user where email = ? and password = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            
            this.checkUser = rs.next();
            
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

    @Override
    public int getID() {

        return user_ID;
    }
    
    public boolean exist() {
        return checkUser;
    }
}
