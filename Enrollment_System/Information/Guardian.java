/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PC
 */
public class Guardian extends Person2 implements DatabaseConnection {

    public Guardian(String name, String relationshipToStudent, int contact_info_ID) {
        super(name, contact_info_ID);

        try (Connection con = connect()) {

            String sql1 = "Select Guardian_ID from guardian where Name = ?";
            
            PreparedStatement pst = con.prepareStatement(sql1);
            pst.setString(1, name);
            
            ResultSet rs1 = pst.executeQuery();

            if (!rs1.next()) {
                String sql2 = "Insert into guardian values(null, ?, ?, ?)";

                PreparedStatement pst1 = con.prepareStatement(sql2);
                pst1.setString(1, name);
                pst1.setString(2, relationshipToStudent);
                pst1.setInt(3, contact_info_ID);

                pst1.executeUpdate();
                pst1.executeQuery();

                pst1.close();
            }

            pst.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public int getGuardianID() {

        try (Connection con = connect()) {

            String sql = "select Guardian_ID from guardian where name = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int Guardian_ID = rs.getInt("Guardian_ID");
                return Guardian_ID;
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;

    }

}
