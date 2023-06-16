/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Admin_Dashboard.MenuItems;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Information.ClassProgram;


/**
 *
 * @author james
 */
public class CourseSetting extends javax.swing.JPanel {

    /**
     * Creates new form newlang
     */
    
    public CourseSetting course;
    public CourseSetting() {
        
      
        initComponents();

    }
    


    public void search(){
        ClassProgram program = new ClassProgram();
        
   String url="jdbc:mysql://dusk.mysql.database.azure.com:3306/Enrollment_System?useSSL=true";

        try (Connection con = DriverManager.getConnection(url, "Arceus", "m67Ds#rAm6")) {
    
             String code = jTextField2.getText();
            

            String sql = "select concat(First_Name,' ',Middle_Name,' ',Last_Name) as name, curriculum.Curriculum_Name from student\n" +
                            "left join curriculum on curriculum.Curriculum_ID = student.Curriculum_ID \n" +
                            " where Student_Number = ?;";
        
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,code);
            ResultSet rs = pst.executeQuery();
            rs.next();
            jTextField4.setText(rs.getString("Name"));
            jTextField5.setText(program.getName(2));
/*
            a
            
           
            
            
            
            
            CourseSetting course= new CourseSetting();
             pst.close();
             con.close();
             
             
         
                              try{
               tf_name.setText(rs.getString("STUD_NAME"));
            tf_address.setText(rs.getString("STUD_ADDRESS"));
            tf_gender.setText(rs.getString("STUD_GENDER"));
            
            String a = rs.getString("city");
            
        connect();
        String sql = "DELETE FROM tbl_stud where ID=?";
        PreparedStatement pst = connect().prepareStatement(sql);
        pst.setInt(1,Integer.parseInt(tf_id.getText()));
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Working!");
        }catch(Exception ex){
           
                        
    String sql = "INSERT INTO tbl_stud(ID,STUD_NAME,STUD_ADDRESS,STUD_GENDER) VALUES(?,?,?,?)";
        //Connection con = connect();
        PreparedStatement pst = connect().prepareStatement(sql);
        
           pst.setString(1,id);
          pst.setString(2,name);
          pst.setString (3,address);
          pst.setString(4,gender);
          pst.executeUpdate();
          
          JOptionPane.showMessageDialog(null, "Working!");
          connect().close();
          
          tf_id.setText(null);
          tf_name.setText(null);
          tf_address.setText(null);
          tf_gender.setText(null);
          
          
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
                     
            */
        } catch (Exception e) {
                        System.out.println("2nd");

            JOptionPane.showMessageDialog(null, e.getMessage());

        }
       
  
    }
    
    /**
     *
     */
    public void updateTable(){
        
        //Empty Table
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                   
                },
                new String [] {
                     "Courses_Name","Course_Credits","Courses_Code"
                }
                )
            { public boolean isCellEditable(int row, int column)
    {
      return false;//This causes all cells to be not editable
    }}
            );
        
        
        //Update Table
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            // tableModel.addRow(tableContents);
            String url="jdbc:mysql://dusk.mysql.database.azure.com:3306/Enrollment_System?useSSL=true";
            try (Connection con = DriverManager.getConnection(url, "Arceus", "m67Ds#rAm6")) {
                
                // PreparedStatement pst = con.prepareStatement(sql);
                Statement st = con.createStatement();
                String sql = "SELECT curriculum_courses.Courses_ID, courses.Courses_Name, courses.Course_Credits, courses.Course_Syllabus, courses.Courses_Code "
                        + "from curriculum_courses "
                        + "left join courses on curriculum_courses.Courses_ID = courses.Courses_ID "
                        + "right join class on class.Courses_ID = curriculum_courses.Courses_ID "
                        + "right join student on student.Curriculum_ID = curriculum_courses.Curriculum_ID "
                        + "where student.Student_Number = ?;";
                
                        //Statement w/ SQL
                                /*"SELECT curriculum_courses.Courses_ID, courses.Courses_Name, "
                             + "courses.Course_Credits, courses.Course_Syllabus, courses.Courses_Code "
                             + "from curriculum_courses left join courses on curriculum_courses.Courses_ID = courses.Courses_ID "
                             + "right join student on student.Curriculum_ID = curriculum_courses.Curriculum_ID "
                             + "right join class on class.Courses_ID = curriculum_courses.Courses_ID Where student.Student_Number = '202102113' "
                             + "AND class.Semester_ID = 6;"*/
                                
                PreparedStatement pst = con.prepareStatement(sql);
                String studentCode = jTextField2.getText();
                pst.setString(1, studentCode);
                
                ResultSet rs = pst.executeQuery();
                
                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                
              
                //int columnsNumber = rsmd.getColumnCount();
                String[] rowNames = new String[rsmd.getColumnCount()];

          
                
                for (int i = 0; i < rowNames.length; i++) {
                    rowNames[i] =  rsmd.getColumnName(i + 1);
                }

                tableModel.setColumnIdentifiers(rowNames);
                while (rs.next()) {
                    String id = rs.getString("Courses_ID");
                    String name = rs.getString("Courses_Name");
                    String credit = rs.getString("Course_Credits");
                    String syllabus = rs.getString("Course_Syllabus");
                    String code = rs.getString("Courses_Code");
                    tableModel.addRow(new Object[] { id, name, credit, syllabus, code });
                }
                    
                JOptionPane.showMessageDialog(null, "Success");
                st.close();
                con.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());

            }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        courses1 = new Information.Courses();
        courses2 = new Information.Courses();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel1.setText("Name ");

        jTextField2.setToolTipText("Enter Student Number\n");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel4.setText("Program Name");

        jTextField4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Courses_Name", "Course_Credits", "Courses_Code"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setText("Student Number");

        jTextField5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                                    .addComponent(jTextField4)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
      search();
      updateTable();
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private Information.Courses courses1;
    private Information.Courses courses2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
