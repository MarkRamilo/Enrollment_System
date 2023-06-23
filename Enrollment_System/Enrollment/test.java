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

        Reference us = new Reference();

        // String[] courseInfo = new String[3];
        System.out.println(us.getReference_Number(1));

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
