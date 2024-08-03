package org.Santiago.JeffBezos.Simulacro2.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
        //Atributos de dbConnection
    /*private static String url = "jdbc:mysql://<hostname>:<port>/<database>?serverTimezone=America/Bogota";*/  //Los elementos en <> se deben cambiar, incluyendo al operador diamante
    private static String url = "jdbc:mysql://localhost:3306/simu_jdbc?serverTimezone=America/Bogota";

    private static String username = "root";
    private static String password = "sasa";

    /*private static Connection conn;*/ //No estoy implementando una conexión singleton

    //Constructores de dbConnection
    //Asignadores de atributos de dbConnection (setters)
    //Lectores de atributos de dbConnection (getters)
        //Métodos de dbConnection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
