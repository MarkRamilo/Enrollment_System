/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Admin_Dashboard.MenuItems;
import Connection.DatabaseConnection;
import Information.Courses;
import Information.CurriculumCourses;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author PC
 */
public class ClassSetting2 extends javax.swing.JPanel implements DatabaseConnection {

    /**
     * Creates new form ClassSetting2
     */
    String globalStudentID;
    String regID;
    public ClassSetting2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SubmitUpdateToDatabase = new javax.swing.JButton();
        DeleteToJTable = new javax.swing.JButton();
        AddToJTable = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setDoubleBuffered(false);
        setPreferredSize(new java.awt.Dimension(800, 800));
        setLayout(null);

        SubmitUpdateToDatabase.setText("Submit");
        SubmitUpdateToDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitUpdateToDatabaseActionPerformed(evt);
            }
        });
        add(SubmitUpdateToDatabase);
        SubmitUpdateToDatabase.setBounds(620, 720, 72, 23);

        DeleteToJTable.setText("Delete");
        DeleteToJTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteToJTableActionPerformed(evt);
            }
        });
        add(DeleteToJTable);
        DeleteToJTable.setBounds(700, 300, 72, 23);

        AddToJTable.setText("Add");
        AddToJTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToJTableActionPerformed(evt);
            }
        });
        add(AddToJTable);
        AddToJTable.setBounds(620, 270, 72, 23);

        jTextField5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        add(jTextField5);
        jTextField5.setBounds(240, 160, 371, 33);

        jTextField4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        add(jTextField4);
        jTextField4.setBounds(240, 100, 191, 25);

        jTextField2.setToolTipText("Enter Student Number\n");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        add(jTextField2);
        jTextField2.setBounds(240, 60, 127, 22);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(450, 60, 72, 23);

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setText("Student Number");
        add(jLabel3);
        jLabel3.setBounds(120, 60, 108, 16);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel1.setText("Name ");
        add(jLabel1);
        jLabel1.setBounds(180, 110, 42, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel4.setText("Program");
        add(jLabel4);
        jLabel4.setBounds(160, 170, 60, 16);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(240, 210, 371, 22);

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel5.setText("Courses");
        add(jLabel5);
        jLabel5.setBounds(20, 270, 52, 20);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 300, 680, 406);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new Courses().getCourses()));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        add(jComboBox2);
        jComboBox2.setBounds(80, 270, 280, 22);

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel6.setText("Semester");
        add(jLabel6);
        jLabel6.setBounds(160, 220, 60, 16);
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitUpdateToDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitUpdateToDatabaseActionPerformed
        // TODO add your handling code here:
         try (Connection con = connect()) {
             String sql = "Select * from registration reg,reference ref " +
                          "Where reg.Reference_ID = ref.Reference_ID AND "
                        + "ref.Student_ID = ?;";
             
            String sqlAdd = "insert into class_student values (null,?,?)";
            String sqlReg = "insert into registration_details values (null,?,?,?,current_timestamp())";
            
            
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement psADD = con.prepareStatement(sqlAdd);
            PreparedStatement psReg = con.prepareStatement(sqlReg);
           
           
            ps.setString(1, globalStudentID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){

             regID = rs.getString("Registration_ID");

             } else{
                 JOptionPane.showMessageDialog(null, "Student Not Found!!");

             }
            JOptionPane.showMessageDialog(null, jTable1.getRowCount());
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                // Retrieve the data from column
                String hiddenColumn4 = jTable1.getModel().getValueAt(row, 3).toString();
                
                // Insert Class
                psADD.setString(1, hiddenColumn4);
                psADD.setString(2, globalStudentID);
                psADD.executeUpdate();
                
                //Insert Reg
                psReg.setString(1, hiddenColumn4);
                psReg.setString(2, regID);
                psReg.setString(3, "5");
                psReg.executeUpdate();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_SubmitUpdateToDatabaseActionPerformed

    private void DeleteToJTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteToJTableActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) { // Check if a row is selected
            ((javax.swing.table.DefaultTableModel) jTable1.getModel()).removeRow(selectedRow);

        }
    }//GEN-LAST:event_DeleteToJTableActionPerformed

    private void AddToJTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToJTableActionPerformed
        // TODO add your handling code here:
        String courseName = String.valueOf(jComboBox2.getSelectedItem());

        Courses c = new Courses();
        String[] courseInfo = new String[4];
        courseInfo = c.getCourseInfo(courseName);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        Object[] rowData = { courseInfo[0], courseInfo[1], courseInfo[2], courseInfo[3] };

        // Check for duplicates (GTP hehe)
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
            // insert row on top
            model.insertRow(0, rowData);
        } else {
            JOptionPane.showMessageDialog(null, "Duplicate values found in the row!");
        }
    }//GEN-LAST:event_AddToJTableActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String studentID = jTextField2.getText();
        String curriculumID;
        
        //Table
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Courses_Name", "Course_Credits", "Courses_Code"
                }) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        
        CurriculumCourses cc = new CurriculumCourses();

        
        /*String sql = ";*/
        
        try(Connection con = connect()){
            
        String sql = "SELECT CONCAT(s.First_Name,' ',s.Middle_Name,' ',s.Last_Name) as name, "
                + "cp.Program_Name, s.Class_Program_ID, s.Student_ID "    
                + "FROM student s, "
                + "class_program cp, "
                + "User u "
                + "WHERE cp.Class_Program_ID = s.Class_Program_ID AND "
                + "u.User_ID = s.User_ID AND "
                + "u.Email = ?";
        
        
       
        
        
        PreparedStatement pr = con.prepareStatement(sql);
        pr.setString(1, studentID+"@hogwarts.com.ph");
        ResultSet rs = pr.executeQuery();
        
        
        if(rs.next()){
            
            
            jTextField4.setText(rs.getString("name"));
            jTextField5.setText(rs.getString("cp.Program_Name"));
            curriculumID = rs.getString("Class_Program_ID");
            globalStudentID = rs.getString("s.Student_ID");
            updateTable(curriculumID);
           
        } else{
            JOptionPane.showMessageDialog(null, "Student Not Found!!");
        
        }
        
        }catch (SQLException e) {
            e.getMessage();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public void updateTable(String curriculumID) {

        // Empty Table
        // This causes all cells to be not editable
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Courses_Name", "Course_Credits", "Courses_Code"
                }) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        // tableModel.addRow(tableContents);

        CurriculumCourses cc = new CurriculumCourses();

        try (Connection con = connect()) {

            // PreparedStatement pst = con.prepareStatement(sql);
            String sql = "SELECT Courses_Name,Course_Credits,Courses_Code,class.Class_ID "
                    + "FROM courses "
                    + "right join curriculum_courses on curriculum_courses.Courses_ID = courses.Courses_ID "

                    // Para dina mag preparedstatement ulit
                    + "left join class on class.Courses_ID = courses.Courses_ID "
                    + "WHERE curriculum_courses.Curriculum_ID = ?;";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, curriculumID);

            ResultSet rs = ps.executeQuery();

            com.mysql.cj.jdbc.result.ResultSetMetaData rsmd = (com.mysql.cj.jdbc.result.ResultSetMetaData) rs.getMetaData();
            // int columnsNumber = rsmd.getColumnCount();
            String[] rowNames = new String[4];

            rowNames[0] = "Name";
            rowNames[1] = "Credits";
            rowNames[2] = "Code";
            rowNames[3] = "Hidden";

            tableModel.setColumnIdentifiers(rowNames);
            while (rs.next()) {
                String name = rs.getString("Courses_Name");
                String credits = rs.getString("Course_Credits");
                String code = rs.getString("Courses_Code");

                // Hidden - Para dina mag loop sa table yung row sa executeBatch (tipid nadin ng
                // 2 prepared statement)
                String classID = rs.getString("class.Class_ID");
                tableModel.addRow(new Object[] { name, credits, code, classID });
            }
            // Hide Hidden Column(ClassId)
            TableColumnModel tcm = jTable1.getColumnModel();
            tcm.removeColumn(tcm.getColumn(3));

            JOptionPane.showMessageDialog(null, "Success");
            ps.close();
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

    }
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

   /*
    public String[] getProgram(int Province_ID) {

        try (Connection con = connect()) {

            String sql = "select City from Cities where Province_ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Province_ID);

            ResultSet rs = pst.executeQuery();

            // ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            ArrayList<String> items = new ArrayList<>();

            while (rs.next()) {
                String a = rs.getString("City");
                items.add(a);
            }
            items.add(0, "City");
            pst.close();
            String[] subItems = new String[items.size()];
            items.toArray(subItems);
            return subItems;

        } catch (SQLException e) {
            e.getMessage();
        }
        return null;

    }
    
    
     jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new ClassProgram().getPrograms()));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(170, 290, 630, 22);
*/
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        try(Connection con = connect()){
            //String[] Courses= new String; 
            
            
        }
        catch(SQLException e){
             e.getMessage();
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddToJTable;
    private javax.swing.JButton DeleteToJTable;
    private javax.swing.JButton SubmitUpdateToDatabase;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    @Override
    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
