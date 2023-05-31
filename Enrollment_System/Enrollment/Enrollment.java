package Enrollment;

import Connection.ConnectionToDatabase;
import java.util.Scanner;
import Information.Student;
import Information.User;
import Connection.ConnectionToDatabase;

public class Enrollment implements ConnectionToDatabase {

    Student student;
    String name;
    int age;
    String email;
    String contact_Number;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Integer.parseInt(System.console().readLine())

//        System.out.println("Enter name:");
//        String name = scan.nextLine();
//        System.out.println("Enter age:");
//        int age = scan.nextInt();
//        System.out.println("Enter email:");
//        String email = scan.nextLine();
//        System.out.println("Enter contact number:");
//        String contact_Number = scan.nextLine();
//        System.out.println("Enter course:");
//        String course = scan.nextLine();
//        System.out.println("Enter year:");
//        String year = scan.nextLine();
//        System.out.println("Enter type:");
//        String type = scan.nextLine();
//
//        Student student = new Student(name, age, email, contact_Number, course, year, type, 1);
        Enrollment test  = new Enrollment();
        test.connect();

    }
}
