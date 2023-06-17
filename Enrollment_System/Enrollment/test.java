/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enrollment;

import Connection.DatabaseConnection;
import Information.*;

/**
 *
 * @author PC
 */
public class test implements DatabaseConnection {

    public static void main(String[] args) {
        //test t = new test();

        Courses us = new Courses();
       // String[] courseInfo = new String[3];
        us.getCourseInfo("Computer Programming 1");
        
        //for(int i = 0;i<3;i++){
        //System.out.println(courseInfo[i]);
        //}
        
        
    }
}
