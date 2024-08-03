package org.Santiago.JeffBezos.Simulacro2;

import org.Santiago.JeffBezos.Simulacro2.dataBase.dbConnection;
import org.Santiago.JeffBezos.Simulacro2.models.Company;
import org.Santiago.JeffBezos.Simulacro2.models.Vacancy;
import org.Santiago.JeffBezos.Simulacro2.models.status;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try(Connection conn = dbConnection.getConnection()){
            System.out.println("Nos conectamos, manito");

        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("No nos conectamos, manito");
        }
    }
}
