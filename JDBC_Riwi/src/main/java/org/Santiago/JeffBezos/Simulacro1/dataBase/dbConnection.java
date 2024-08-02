package org.Santiago.JeffBezos.Simulacro1.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
        //Atributos de dbConnection
    private static String url = "jdbc:mysql://b5smepjrjobq4ia0u5lv-mysql.services.clever-cloud.com:3306/b5smepjrjobq4ia0u5lv?serverTimezone=America/Bogota";
    /*private static String url = "jdbc:mysql://<hostname>:<port>/<database>?serverTimezone=America/Bogota";*/  //Los elementos en <> se deben cambiar, incluyendo al operador diamante

    private static String username = "u68sejaxzktdr0nn";
    private static String password = "sWSBLBZXqj2ULKiIeVHa";

    /*private static Connection conn;*/ //No estoy implementando una conexión singleton

    //Constructores de dbConnection
    //Asignadores de atributos de dbConnection (setters)
    //Lectores de atributos de dbConnection (getters)
        //Métodos de dbConnection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
