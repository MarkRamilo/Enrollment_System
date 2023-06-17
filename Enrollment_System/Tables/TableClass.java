/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tables;

import Connection.DatabaseConnection;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */

    public class TableClass extends JTable implements DatabaseConnection {
       
    public TableClass(int CoursesID){
        super();
    }
        public void updateTable(int CoursesID){
        DefaultTableModel tableModel = (DefaultTableModel) this.getModel();
            // tableModel.addRow(tableContents);
            
            try (Connection con = connect()) {
                
                // PreparedStatement pst = con.prepareStatement(sql);
                String sql = "SELECT * FROM courses WHERE Courses_ID = 1";

           
                
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, String.valueOf(CoursesID));
                ResultSet rs = ps.executeQuery();
                
                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                //int columnsNumber = rsmd.getColumnCount();
                String[] rowNames = new String[rsmd.getColumnCount()];

                for (int i = 0; i < rowNames.length; i++) {
                    rowNames[i] =  rsmd.getColumnName(i + 1);
                }

                tableModel.setColumnIdentifiers(rowNames);
                if (rs.next()) {
                    String name = rs.getString("Courses_Name");
                    String credits = rs.getString("Course_Credits");
                    String code = rs.getString("Courses_Code");
                    tableModel.addRow(new Object[] { name, credits, code });
                }
                    
                JOptionPane.showMessageDialog(null, "Success");
                ps.close();
                con.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());

            }
    }
    
    
}
