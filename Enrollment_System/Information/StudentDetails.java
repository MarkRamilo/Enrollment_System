package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDetails implements DatabaseConnection {

    public ArrayList<String> getDetails(int user_ID) {

        try (Connection con = connect()) {

            String sql = " select CONCAT(s.First_Name,', ', s.Middle_Name,', ', s.Last_Name) as Student_Name,\r\n" + //
                    "        u.Email,\r\n" + //
                    "        cp.Program_Name,\r\n" + //
                    "        co.Phone_Number,\r\n" + //
                    "        CONCAT(a.House_Number, ', ',ci.City, ', ', a.Street) as Student_Address\r\n" + //
                    "from student s,\r\n" + //
                    "     user u,\r\n" + //
                    "     class_program cp,\r\n" + //
                    "     address a,\r\n" + //
                    "     cities ci,\r\n" + //
                    "     contact_info co\r\n" + //
                    "where s.contact_info_ID = co.contact_info_ID\r\n" + //
                    "  and s.user_ID = u.user_ID\r\n" + //
                    "  and s.Class_Program_ID = cp.Class_Program_ID\r\n" + //
                    "  and a.Address_ID = co.Address_ID\r\n" + //
                    "  and a.city_ID = ci.city_ID\r\n" + //
                    " and u.User_ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, user_ID);
            ResultSet rs = pst.executeQuery();

            ArrayList<String> items = new ArrayList<>();
            
            if (rs.next()) {
                items.add(rs.getString("Student_Name"));
                items.add(rs.getString("Email"));
                items.add(rs.getString("Program_Name"));
                items.add(rs.getString("Phone_Number"));
                items.add(rs.getString("Student_Address"));
                return items;
            }

            

        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
