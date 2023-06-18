package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.DatabaseConnection;
import java.util.ArrayList;

public class ClassProgram implements DatabaseConnection {

    private int class_Program_ID;

    public ClassProgram(String ClassProgram) {
        try (Connection con = connect()) {

            String sql = "SELECT Class_Program_ID FROM Class_Program WHERE Program_Name = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ClassProgram);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int Class_Program_ID = rs.getInt("Class_Program_ID");
                this.class_Program_ID = Class_Program_ID;

            }

            con.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        this.class_Program_ID = 0;
    }

    public ClassProgram() {
        this.class_Program_ID = 0;
    }

    @Override
    public int getID() {

        return class_Program_ID;

    }

    public String[] getPrograms() {
        try (Connection con = connect()) {

            Statement st = con.createStatement();

            String sql = "select Program_Name from Class_Program";

            ResultSet rs = st.executeQuery(sql);

            ArrayList<String> items = new ArrayList<>();

            while (rs.next()) {
                String a = rs.getString("Program_Name");
                items.add(a);
            }
            items.add(0, "Courses");
            st.close();
            String[] subItems = new String[items.size()];
            items.toArray(subItems);
            return subItems;

        } catch (SQLException e) {
            e.getMessage();
        }
        return null;

    }

    // public String getName(int Class_Program_ID) {
    // try (Connection con = connect()) {

    // Statement st = con.createStatement();

    // String sql = "select Program_Name from Class_Program where Class_Program_ID =
    // ?";

    // PreparedStatement ps = con.prepareStatement(sql);
    // ps.setInt(1, Class_Program_ID);
    // ResultSet rs = ps.executeQuery();

    // if (rs.next()) {
    // String programName = rs.getString("Program_Name");
    // return programName;
    // }
    // ps.close();

    // } catch (SQLException e) {
    // e.getMessage();
    // }
    // return "wala";

    // }
}
