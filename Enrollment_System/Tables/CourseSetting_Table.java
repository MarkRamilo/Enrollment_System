package Tables;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class CourseSetting_Table extends JTable {
    
    public CourseSetting_Table(){
        super();
        
        DefaultTableModel tableModel = (DefaultTableModel) this.getModel();
            // tableModel.addRow(tableContents);
            String url="jdbc:mysql://dusk.mysql.database.azure.com:3306/Enrollment_System?useSSL=true";
            
            try (Connection con = DriverManager.getConnection(url, "Arceus", "m67Ds#rAm6")) {
                
                // PreparedStatement pst = con.prepareStatement(sql);
                Statement st = con.createStatement();
                String sql = "SELECT curriculum_courses.Courses_ID, courses.Courses_Name, "
                        + "courses.Course_Credits, courses.Course_Syllabus, courses.Courses_Code "
                        + "from curriculum_courses "
                        + "left join courses on curriculum_courses.Courses_ID = courses.Courses_ID "
                        + "right join class on class.Courses_ID = curriculum_courses.Courses_ID "
                        + "Where student.Student_Number = ?;";
                
                        //Statement w/ SQL
                                /*"SELECT curriculum_courses.Courses_ID, courses.Courses_Name, "
                             + "courses.Course_Credits, courses.Course_Syllabus, courses.Courses_Code "
                             + "from curriculum_courses left join courses on curriculum_courses.Courses_ID = courses.Courses_ID "
                             + "right join student on student.Curriculum_ID = curriculum_courses.Curriculum_ID "
                             + "right join class on class.Courses_ID = curriculum_courses.Courses_ID Where student.Student_Number = '202102113' "
                             + "AND class.Semester_ID = 6;"*/
                ResultSet rs = st.executeQuery(sql);
                
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
    private void update(String code1){
        
        
        DefaultTableModel tableModel = (DefaultTableModel) this.getModel();
            // tableModel.addRow(tableContents);
            String url="jdbc:mysql://dusk.mysql.database.azure.com:3306/Enrollment_System?useSSL=true";
            
            try (Connection con = DriverManager.getConnection(url, "Arceus", "m67Ds#rAm6")) {
                
                // PreparedStatement pst = con.prepareStatement(sql);
                Statement st = con.createStatement();
                String sql = "SELECT curriculum_courses.Courses_ID, courses.Courses_Name, "
                        + "courses.Course_Credits, courses.Course_Syllabus, courses.Courses_Code "
                        + "from curriculum_courses "
                        + "left join courses on curriculum_courses.Courses_ID = courses.Courses_ID "
                        + "right join class on class.Courses_ID = curriculum_courses.Courses_ID "
                        + "Where student.Student_Number = ?;";
                
                        //Statement w/ SQL
                                /*"SELECT curriculum_courses.Courses_ID, courses.Courses_Name, "
                             + "courses.Course_Credits, courses.Course_Syllabus, courses.Courses_Code "
                             + "from curriculum_courses left join courses on curriculum_courses.Courses_ID = courses.Courses_ID "
                             + "right join student on student.Curriculum_ID = curriculum_courses.Curriculum_ID "
                             + "right join class on class.Courses_ID = curriculum_courses.Courses_ID Where student.Student_Number = '202102113' "
                             + "AND class.Semester_ID = 6;"*/
                ResultSet rs = st.executeQuery(sql);
                 PreparedStatement pst = con.prepareStatement(sql);
                String StudentCode = code1;
                pst.setString(1,StudentCode);
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
    
    public static void main(String[] args) {
        
    }
}
