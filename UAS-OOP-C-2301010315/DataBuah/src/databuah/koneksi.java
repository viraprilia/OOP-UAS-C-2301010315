/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databuah;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    private static Connection conn;

    public static Connection getKoneksi() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_buah";
                String user = "root"; 
                String password = ""; 
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                conn = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                System.out.println("Driver tidak ditemukan: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Koneksi gagal: " + e.getMessage());
                throw e;
            }
        }
        return conn;
    }
}
