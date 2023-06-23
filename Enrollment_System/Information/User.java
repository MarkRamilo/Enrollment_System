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
        String username = generateEmail();
        
        try (Connection con = connect()) {
           
            while (true) {
                String sql = "SELECT * FROM user WHERE email = ?";
                
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, username);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) {
                    break;

                } else {
                    username = generateEmail();
                }
            }
            this.email = username;
            String sql1 = "INSERT INTO user VALUES(null, ?, ?, 1) ";

            PreparedStatement pst1 = con.prepareStatement(sql1);
            
            pst1.setString(1, username);
            pst1.setString(2, generatePassword());

            pst1.executeUpdate();
            pst1.close();

            String sql2 = "SELECT User_ID, Password FROM user WHERE Email = ?";
            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst2.setString(1, username);

            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {
                this.user_ID = rs.getInt("User_ID");
                this.password = rs.getString("Password");

            }
            
            pst2.close();
            con.close();
            
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public User(String email, String password) {
        
        this.email = email;
        this.password = password;
        
        try (Connection con = connect()) {

            String sql = "select User_ID from user where email = ? and `password`= ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            this.checkUser = rs.next();
            
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public User(String email) {
       
        this.email = email;
        
        try (Connection con = connect()) {

            String sql = "select User_ID from user where email = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                this.user_ID = rs.getInt("User_ID");
            }
            
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    private String generateEmail() {

        Year year = Year.now();
        final String domainName = "@hogwarts.com.ph";
        StringBuilder emailAddress = new StringBuilder();

            emailAddress.append(year + "-");
            String number = "";
            
            for (int i = 0; i < 5; i++) {    
                number += String.valueOf(new Random().nextInt(9));
                
            }
            
            emailAddress.append(number);
            emailAddress.append(domainName);

            return emailAddress.toString();

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
    
    public String getPassword() {
        return password;
    }
    
    public String getEmail() {
        return email;
    }
    public void changePassword(String newPassword) {
        
        try (Connection con = connect()) {

            String sql = "update user set `password` = ? where email = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, newPassword);
            ps.setString(2, email);
            
            ps.executeUpdate();
            ps.executeQuery();
    
            JOptionPane.showMessageDialog(null, "Success Changing Password.");
            
        } catch (Exception e) {
            e.getMessage();
        }
        
    } 
}
