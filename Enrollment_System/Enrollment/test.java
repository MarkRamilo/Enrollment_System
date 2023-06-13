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
        test t = new test();

        Address us = new Address("test", 2, "asdsada");

        System.out.println(us.getAddressID());
    }
}
