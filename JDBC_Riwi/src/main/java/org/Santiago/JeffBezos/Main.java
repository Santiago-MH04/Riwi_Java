package org.Santiago.JeffBezos;

import org.Santiago.JeffBezos.Simulacro1.dataBase.dbConnection;
import org.Santiago.JeffBezos.Simulacro1.models.Aeroplane;
import org.Santiago.JeffBezos.Simulacro1.models.Flight;
import org.Santiago.JeffBezos.Simulacro1.models.Passenger;
import org.Santiago.JeffBezos.Simulacro1.repositories.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        try(Connection conn = dbConnection.getConnection()){
            System.out.println("Estamos usando una conexión Singleton, es decir, una única conexión para todas las operaciones");
                //Operemos con los avioncitos
            CRUDRepository<Aeroplane> PlaneRepo = new CRUDImplAeroplane();
                System.out.println("Listando ando");
            PlaneRepo.toList().forEach(System.out::println);
                System.out.println("Buscando ando");
            System.out.println(PlaneRepo.findById(2));
                /*System.out.println("Creando ando");
            Aeroplane aeroplane = new Aeroplane("CRJ900", 250);
            PlaneRepo.save(aeroplane);
                System.out.println("Eliminando ando");
            PlaneRepo.delete(aeroplane.getId());
                System.out.println("Actualizando ando");
            Aeroplane aero = new Aeroplane("B737MAX", 210);
                aero.setId(3);
            PlaneRepo.save(aero);*/

                //Operemos con los pasajeros
            CRUDRepository<Passenger> PasseRepo = new CRUDImplPassenger();
                System.out.println("Listando ando");
            PasseRepo.toList().forEach(System.out::println);
                System.out.println("Buscando ando");
            PasseRepo.findById(4);
                /*System.out.println("Creando ando");
            Passenger pass = new Passenger("Sofía", "Gómez", "F234567890");
            PasseRepo.save(pass);
                System.out.println("Eliminando ando");
            PasseRepo.delete(pass.getId());
                System.out.println("Actualizando ando");
            Passenger pa = new Passenger("Miguel", "Fernández", "G345678901");
                pa.setId(3);
            PasseRepo.save(pa);*/

                //Operemos con los vuelos
            CRUDRepository<Flight> FlightRepo = new CRUDImplFlight();
                System.out.println("Listando ando");
            FlightRepo.toList().forEach(System.out::println);
                System.out.println("Buscando ando");
            FlightRepo.findById(5);
                System.out.println("Creando ando");
            LocalDate date = LocalDate.of(2024, Month.OCTOBER, 10);
            LocalTime newTime = LocalTime.from(LocalDate.now());
            Flight vol = new Flight("Roma", date, newTime, PlaneRepo.findById(4));
                System.out.println("Eliminando ando");
                System.out.println("Actualizando ando");

            LocalTime time = LocalTime.now();
            System.out.println(time);



        } catch (SQLException e){
            System.err.println("No nos conectamos, manito");
            e.printStackTrace();
        }
    }
}