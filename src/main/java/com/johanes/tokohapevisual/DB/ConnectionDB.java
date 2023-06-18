/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johanes.tokohapevisual.DB;

/**
 *
 * @author Johannes Alexander Putra, CSCU
 */

import java.sql.*;

public class ConnectionDB {
    
    // Menyiapkan paramter JDBC untuk koneksi ke database
    static String DB="jdbc:mysql://localhost/si_tokohp"; // si_tokohp database
    static String user="root"; // user database
    static String pass=""; // password database
    private static Connection con;

    public static Connection getConnection() throws SQLException {
        if(con==null){
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                con = (Connection) DriverManager.getConnection(DB,user,pass);
            } catch (Exception e) {
                System.out.println("Database connection is failed");
            }
        }

       return con;
    }
}
