/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Connection.DatabaseConnection;
import Information.*;

/**
 *
 * @author PC
 */
public class test implements DatabaseConnection {

    public static void main(String[] args) {
        // test t = new test();

        User us = new User();

        // String[] courseInfo = new String[3];
        System.out.println(us.ge);

        // for(int i = 0;i<3;i++){
        // System.out.println(courseInfo[i]);
        // }

    }

    @Override
    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
