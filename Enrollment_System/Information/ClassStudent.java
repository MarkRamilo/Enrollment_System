/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Information;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */


public class ClassStudent {
      
         public ClassStudent(int class_ID,int student_ID) {
        // TODO Auto-generated constructor stubl;

        try (Connection con = connect()) {

            String sql = "Insert into class_student values(null,?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, class_ID);
            pst.setInt(2, student_ID);


            pst.executeUpdate();
            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    
         }

         
        public Connection connect(){
        String url = "jdbc:mysql://localhost:3306/oop2";
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection(url,"root","");
          return con;
          
          }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    }
    

