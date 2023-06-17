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
import Information.CurriculumCourses;
import Tables.CoursesTable;
import Connection.DatabaseConnection;
import Information.Courses;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author james
 */
public class ClassSetting extends javax.swing.JPanel implements DatabaseConnection{

    int globalStudentID;
    public ClassSetting course;
    public ClassSetting() {
        initComponents();
        
       
         
    }
  

    public int search(){

        try (Connection con = connect()){
             ClassProgram program = new ClassProgram();
             String code = jTextField2.getText();
            

            String sql = "select Student_ID,concat(First_Name,' ',Middle_Name,' ',Last_Name) as name, student.Curriculum_ID, curriculum.Curriculum_Name from student\n " +
                            "left join curriculum on curriculum.Curriculum_ID = student.Curriculum_ID \n" +
                            " where Student_Number = ?;";
        
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,code);
            ResultSet rs = pst.executeQuery();
            
            
            if(rs.next()){
            jTextField4.setText(rs.getString("Name"));
            int curriculumnID = rs.getInt("student.Curriculum_ID");
            int cName = curriculumnID;
            jTextField5.setText(program.getName(cName));
              return curriculumnID;
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }
       
  return 0;
    }
    
    /**
     *
     */
    public void updateTable(int curriculumID){
        
        //Empty Table
        //This causes all cells to be not editable
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                   
                },
                new String [] {
                     "Courses_Name","Course_Credits","Courses_Code"
                }
                )
            { public boolean isCellEditable(int row, int column)
    {
      return false;
    }}
            );
 
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            // tableModel.addRow(tableContents);
            
            CurriculumCourses cc = new CurriculumCourses();
            
            try (Connection con = connect()) {
                
                // PreparedStatement pst = con.prepareStatement(sql);
                String sql ="SELECT Courses_Name,Course_Credits,Courses_Code,class.Class_ID "
                        + "FROM courses "
                        + "right join curriculum_courses on curriculum_courses.Courses_ID = courses.Courses_ID "
                        
                         //Para dina mag preparedstatement ulit
                        + "left join class on class.Courses_ID = courses.Courses_ID "
                        + "WHERE curriculum_courses.Curriculum_ID = ?;";


                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setInt(1, curriculumID);

                ResultSet rs = ps.executeQuery();
                
                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                //int columnsNumber = rsmd.getColumnCount();
                String[] rowNames = new String[4];

               rowNames[0] =  "Name";
               rowNames[1] =  "Credits";
               rowNames[2] =  "Code";
               rowNames[3] =  "Hidden";
               
               

                tableModel.setColumnIdentifiers(rowNames);
                while (rs.next()) {
                    String name = rs.getString("Courses_Name");
                    String credits = rs.getString("Course_Credits");
                    String code = rs.getString("Courses_Code");
                    
                    //Hidden - Para dina mag loop sa table yung row sa executeBatch (tipid nadin ng 2 prepared statement)
                    String classID = rs.getString("class.Class_ID");
                    tableModel.addRow(new Object[] { name, credits, code, classID });
                }
                //Hide Hidden Column(ClassId)
                TableColumnModel tcm = jTable1.getColumnModel();
                tcm.removeColumn( tcm.getColumn(3) );
                
                
                JOptionPane.showMessageDialog(null, "Success");
                ps.close();
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
        jLabel3 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        AddToJTable = new javax.swing.JButton();
        DeleteToJTable = new javax.swing.JButton();
        SubmitUpdateToDatabase = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();

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

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setText("Student Number");

        jTextField5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Courses_Name","Course_Credits","Courses_Code"
            }
        )
        { public boolean isCellEditable(int row, int column)
            {
                return false;
            }}
        );
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                Delete(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        AddToJTable.setText("Add");
        AddToJTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToJTableActionPerformed(evt);
            }
        });

        DeleteToJTable.setText("Delete");
        DeleteToJTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteToJTableActionPerformed(evt);
            }
        });

        SubmitUpdateToDatabase.setText("Submit");
        SubmitUpdateToDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitUpdateToDatabaseActionPerformed(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
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
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                                    .addComponent(jTextField4)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField6)
                                .addGap(18, 18, 18)
                                .addComponent(AddToJTable)
                                .addGap(18, 18, 18)
                                .addComponent(DeleteToJTable)
                                .addGap(18, 18, 18)
                                .addComponent(SubmitUpdateToDatabase))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(108, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddToJTable)
                    .addComponent(DeleteToJTable)
                    .addComponent(SubmitUpdateToDatabase)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

        
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
      globalStudentID = search();
      updateTable(globalStudentID);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void SubmitUpdateToDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitUpdateToDatabaseActionPerformed
        
        try(Connection con = connect()){
        String sqlAdd = "insert into class_student values (null,?,?)";
        
        PreparedStatement psADD = con.prepareStatement(sqlAdd);
        
        for (int row = 0; row < jTable1.getRowCount(); row++) {
                // Retrieve the data from column
                String hiddenColumn4 = jTable1.getModel().getValueAt(row, 3).toString();

                // Set the values in the prepared statement
                psADD.setString(1, hiddenColumn4 );
                psADD.setInt(2, globalStudentID);

                // Execute the insert statement
                psADD.executeUpdate();
                
            }
        if(psADD.executeUpdate()!=0){
                JOptionPane.showMessageDialog(null,"Success!");
                }
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        
        
    }//GEN-LAST:event_SubmitUpdateToDatabaseActionPerformed

    private void AddToJTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToJTableActionPerformed
        // TODO add your handling code here:
        String courseName = jTextField6.getText();
        
        Courses c = new Courses();
        String[] courseInfo = new String[4];
        courseInfo = c.getCourseInfo(courseName);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
       
        
        Object[] rowData = {courseInfo[0], courseInfo[1], courseInfo[2], courseInfo[3]};
        
        //Check for duplicates (GTP hehe)
        boolean hasDuplicate = false;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            boolean match = true;
            for (int j = 0; j < jTable1.getColumnCount(); j++) {
                Object value = jTable1.getValueAt(i, j);
                if (!rowData[j].equals(value)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                hasDuplicate = true;
                break;
            }
        }
        
        if (!hasDuplicate) {
            //insert row on top
             model.insertRow(0, rowData);
        } else {
            JOptionPane.showMessageDialog(null, "Duplicate values found in the row!");
        }
        
       
    }//GEN-LAST:event_AddToJTableActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void DeleteToJTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteToJTableActionPerformed
        // TODO add your handling code here:
        
        // Remove the row from the data model    
        int selectedRow = jTable1.getSelectedRow();
        
        if (selectedRow != -1) { // Check if a row is selected
            
            jTextField6.setText(""); 
            ((javax.swing.table.DefaultTableModel) jTable1.getModel()).removeRow(selectedRow);
            
            
            
        }
    }//GEN-LAST:event_DeleteToJTableActionPerformed

    private void Delete(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Delete

    }//GEN-LAST:event_Delete

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        //Action Listener for selecting table row
          int selectedRow =  jTable1.getSelectedRow();

                Object selectedValue =  jTable1.getValueAt(selectedRow, 0);

                jTextField6.setText(selectedValue.toString());
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddToJTable;
    private javax.swing.JButton DeleteToJTable;
    private javax.swing.JButton SubmitUpdateToDatabase;
    private javax.swing.ButtonGroup buttonGroup1;
    private Information.Courses courses1;
    private Information.Courses courses2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
