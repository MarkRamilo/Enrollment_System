/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Enrollment;

import Information.Address;
import Information.City;
import Information.ClassProgram;
import Information.StudentContactInformation;
import Information.Guardian;
import Information.GuardianContactInformation;
import Information.Parent;
import Information.ParentContactInformation;
import Information.Reference;
import Information.Student;
import Information.StudentGuardian;
import Information.User;
import LoginSystem.Login;
import Information.Registration;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public static Dashboard dashboard;

    private static ArrayList<String> student1;
    private static ArrayList<String> studentContactDetails;
    private static ArrayList<String> parent;
    private static ArrayList<String> parentDetails;
    private static ArrayList<String> address;
    private static ArrayList<String> guardianContactInformation;
    private static ArrayList<String> guardianAddress;
    private static ArrayList<String> guardian;

    public Dashboard() {
        initComponents();
        student1 = new ArrayList<>();
        studentContactDetails = new ArrayList<>();
        parent = new ArrayList<>();
        address = new ArrayList<>();
        parentDetails = new ArrayList<>();
        guardianAddress = new ArrayList<>();
        guardianContactInformation = new ArrayList<>();
        guardian = new ArrayList<>();
        this.setLocationRelativeTo(null);
    }

    protected static void setTab(int number) {
        jTabbedPane1.setSelectedIndex(number);
    }

    protected static void close() {

        User user = new User();
        ClassProgram classProgram = new ClassProgram(student1.get(3));
        City city = new City(address.get(1));
        Address studentAddress = new Address(address.get(0), city.getID(), address.get(2));
        StudentContactInformation studentContactInformation = new StudentContactInformation(studentAddress.getID(),
                studentContactDetails.get(0), studentContactDetails.get(1));
        Student student = new Student(student1.get(0), student1.get(1), student1.get(2),
                studentContactInformation.getID(), user.getID(), classProgram.getID());
        Reference reference = new Reference(student.getID());
        
        Registration registration = new Registration(reference.getID());

        ParentContactInformation parentContactInformation1 = new ParentContactInformation(studentAddress.getID(),
                parentDetails.get(0), parentDetails.get(1));
        ParentContactInformation parentContactInformation2 = new ParentContactInformation(studentAddress.getID(),
                parentDetails.get(2), parentDetails.get(3));
        Parent parent1 = new Parent(parent.get(0), parentContactInformation1.getID(), student.getID());
        Parent parent2 = new Parent(parent.get(1), parentContactInformation2.getID(), student.getID());

        City guardianCity = new City(guardianAddress.get(1));
        Address guardianAddress1 = new Address(guardianAddress.get(0), guardianCity.getID(), guardianAddress.get(2));
        GuardianContactInformation guardianCotactInformation = new GuardianContactInformation(guardianAddress1.getID(),
                guardianContactInformation.get(0), guardianContactInformation.get(1));
        Guardian guardian1 = new Guardian(guardian.get(0), guardian.get(1), guardianCotactInformation.getID());
        StudentGuardian studentGuardian = new StudentGuardian(guardian1.getID(), student.getID());

        JOptionPane.showMessageDialog(null, "Success");
        JOptionPane.showMessageDialog(null, "Email: " + user.getEmail() + "\n"
                + "Password: " + user.getPassword());
        dashboard.dispose();
        new Login().setVisible(true);
    }

    protected static void setStudentDetails(String firstName, String middleName, String lastName,
            String Class_Program) {

        student1.add(firstName);
        student1.add(middleName);
        student1.add(lastName);
        student1.add(Class_Program);

    }

    protected static void setParentDetails(String name) {
        parent.add(name);

    }

    protected static void setStudentContactDetails(String email, String phoneNumber) {
        studentContactDetails.add(email);
        studentContactDetails.add(phoneNumber);

    }

    protected static void setParentContactInformation(String email, String phoneNumber) {
        parentDetails.add(email);
        parentDetails.add(phoneNumber);
    }

    protected static void setAddress(String street, String city, String Additional) {

        address.add(street);
        address.add(city);
        address.add(Additional);
    }

    protected static void setGuardianAddress(String street, String city, String Additional) {
        guardianAddress.add(street);
        guardianAddress.add(city);
        guardianAddress.add(Additional);
    }

    protected static void setGuardianContactInformation(String email, String phoneNumber) {
        guardianContactInformation.add(email);
        guardianContactInformation.add(phoneNumber);
    }

    protected static void setGuardian(String name, String relationshipToStudent) {
        guardian.add(name);
        guardian.add(relationshipToStudent);

    }
    
    protected static void formClose() {
        System.exit(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guardianContactDetails1 = new Enrollment.GuardianContactDetails();
        guardianContactDetails2 = new Enrollment.GuardianContactDetails();
        guardianContactDetails3 = new Enrollment.GuardianContactDetails();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        newJPanel1 = new Enrollment.NewJPanel();
        newJPanel2 = new Enrollment.NewJPanel();
        guardianContactDetails4 = new Enrollment.GuardianContactDetails();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1080, 800));
        jLayeredPane1.setRequestFocusEnabled(false);
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1080, 800));

        javax.swing.GroupLayout newJPanel1Layout = new javax.swing.GroupLayout(newJPanel1);
        newJPanel1.setLayout(newJPanel1Layout);
        newJPanel1Layout.setHorizontalGroup(
            newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newJPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        newJPanel1Layout.setVerticalGroup(
            newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newJPanel1Layout.createSequentialGroup()
                .addComponent(newJPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", newJPanel1);
        jTabbedPane1.addTab("tab4", guardianContactDetails4);

        jLayeredPane1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, -1, 830));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        new Login().setVisible(true);
    }// GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dashboard = new Dashboard();
                dashboard.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Enrollment.GuardianContactDetails guardianContactDetails1;
    private Enrollment.GuardianContactDetails guardianContactDetails2;
    private Enrollment.GuardianContactDetails guardianContactDetails3;
    private Enrollment.GuardianContactDetails guardianContactDetails4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private static javax.swing.JTabbedPane jTabbedPane1;
    private Enrollment.NewJPanel newJPanel1;
    private Enrollment.NewJPanel newJPanel2;
    // End of variables declaration//GEN-END:variables
}
