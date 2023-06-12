package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class Parent extends Person2 implements DatabaseConnection {

    int student_ID;

    public Parent(String name, int address_ID, int contact_info_ID, int student_ID) {

        super(name, address_ID, contact_info_ID);
        this.student_ID = student_ID;

        try (Connection con = connect()) {

            String sql = "Insert into Parents values (null, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, address_ID);
            pst.setInt(3, contact_info_ID);
            pst.setInt(4, student_ID);

            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.getMessage();

        }
    }
}
