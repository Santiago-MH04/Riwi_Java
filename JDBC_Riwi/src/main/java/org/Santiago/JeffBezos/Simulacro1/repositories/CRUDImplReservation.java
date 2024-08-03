package org.Santiago.JeffBezos.Simulacro1.repositories;

import org.Santiago.JeffBezos.Simulacro1.dataBase.dbConnection;
import org.Santiago.JeffBezos.Simulacro1.models.Flight;
import org.Santiago.JeffBezos.Simulacro1.models.Passenger;
import org.Santiago.JeffBezos.Simulacro1.models.Reservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CRUDImplReservation implements CRUDReservation{
        //Atributos de CRUDImplReservation
    private CRUDRepository<Passenger> PasseRepo = new CRUDImplPassenger();
    //Constructores de CRUDImplReservation
    //Asignadores de atributos de CRUDImplReservation (setters)
    //Lectores de atributos de CRUDImplReservation (getters)
        //Métodos de CRUDImplReservation

    @Override
    public List<Reservation> toList() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
            //Obtener la conexión
        try(Connection conn = dbConnection.getConnection()){
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select r.* from reservations as r inner join passengers as p " +
                    "on (r.id_passenger = p.id) inner join flights as f on (r.id_flight = f.id) )");
            while(rs.next()){
                Reservation reservation = new Reservation();
                    reservation.setId(rs.getInt("id"));
                    reservation.setReservationDate(rs.getDate("reservation_date").toLocalDate());
                    int idP = rs.getInt("id_passenger");
                Passenger passenger = new Passenger();
                Flight flight = new Flight();
                    flight.setId(rs.getInt("id_flight"));
            }
        }
        return reservations;
    }

    @Override
    public Reservation findById(int id) throws SQLException {
        return null;
    }

    @Override
    public void toCancel() {

    }

    @Override
    public void toReserve() {

    }
}
