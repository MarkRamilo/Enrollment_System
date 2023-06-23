package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class Reference implements DatabaseConnection {
    
    private int reference_ID;
    private int reference_Number;

    public Reference(int student_ID) {
        this.reference_ID = 0;
        int referenceNumber = generateNumber();

        try (Connection con = connect()) {
            while (true) {
                String sql = "SELECT * FROM reference WHERE Reference_Number = ?";

                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, referenceNumber);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) {
                    break;

                } else {
                    referenceNumber = generateNumber();
                }
            }
             
            String sql1 = "INSERT INTO reference VALUES(null, ?, ?) ";

            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, referenceNumber);
            ps1.setInt(2, student_ID);

            ps1.executeUpdate();
            ps1.close();

            String sql2 = "SELECT Reference_ID, Reference_Number FROM Reference WHERE Reference_Number = ?";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, referenceNumber);

            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()) {
                this.reference_ID = rs2.getInt("reference_ID");
                this.reference_Number = rs2.getInt("Reference_Number");
            }

            con.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Reference() {
        this.reference_ID = 0;
    }

    private int generateNumber() {

        Random rand = new Random();
        return rand.nextInt(1000000000);
        
    }
    
    @Override
    public int getID() {
        return reference_ID;
    }
    
    public int getReference_Number(int user_ID) {
        
        try (Connection con = connect()) {

            String sql = "SELECT r.Reference_Number FROM Reference r, student s, user u WHERE s.Student_ID = r.Student_ID and u.User_ID = s.User_ID and u.User_ID = ? ";

            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setInt(1, user_ID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("Reference_Number");
            }
            
        } catch (Exception e) {
            e.getMessage();
        }
        return 0;
    }

}
