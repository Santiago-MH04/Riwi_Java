package org.Santiago.JeffBezos.Simulacro1.repositories;

import com.mysql.cj.jdbc.JdbcConnection;
import org.Santiago.JeffBezos.Simulacro1.dataBase.dbConnection;
import org.Santiago.JeffBezos.Simulacro1.models.Aeroplane;
import org.Santiago.JeffBezos.Simulacro1.models.Flight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDImplFlight implements CRUDRepository<Flight>{
    //Atributos de CRUDImplFlight
    //Constructores de CRUDImplFlight
    //Asignadores de atributos de CRUDImplFlight (setters)
    //Lectores de atributos de CRUDImplFlight (getters)
        //Métodos de CRUDImplFlight

    @Override
    public List<Flight> toList() throws SQLException {
        List<Flight> flights = new ArrayList<>();
            //Obtener la conexión
        try(Connection conn = dbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT f.*, a.capacity as capacity FROM flights as f INNER JOIN aeroplanes as a " +
                    "ON (f.id_aeroplane = a.id)");){
            while(rs.next()){
                Flight f = createFlight(rs);
                flights.add(f);
            }
        }
        return flights;
    }

    @Override
    public Flight findById(int ID) throws SQLException {
        Flight flight = null;
        try(Connection conn = dbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT f.*, a.capacity as capacity FROM flights as f INNER JOIN aeroplanes as a " +
                "ON (f.id_aeroplane = a.id) WHERE f.id= ?");){
            ps.setInt(1, ID);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    flight = createFlight(rs);
                }
            }
        }
        return flight;
    }

    @Override
    public Flight save(Flight flight) throws SQLException {
            //Preparar parámetros
        String SQL;
        if(flight.getId() > 0){ //Actualizar vuelo
            SQL = "UPDATE flights SET destination = ?, departure_date = ?, departure_time = ?, id_aeroplane = ?  WHERE id = ?";
        } else {    //Agregar nuevo vuelo
            SQL = "INSERT INTO productos (destination, departure_date, departure_time, id_aeroplane) VALUES (?, ?, ?, ?)";
        }
            //Obtener la conexión
        try(Connection conn = dbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){
                //Asignar parámetros
            ps.setString(1, flight.getDestination());
            ps.setDate(2, Date.valueOf(flight.getDepartureDate()));
            ps.setTime(3, Time.valueOf(flight.getDepartureTime()));
            ps.setInt(4, flight.getId());
            if(flight.getId() > 0){
                ps.setInt(5, flight.getId());
            }
                //Ejecutar la petición
            ps.executeUpdate();
                //Asignar el último ID disponible en caso de haber guardado un nuevo producto
            if (flight.getId() == 0){
                try (ResultSet rs = ps.getGeneratedKeys()){
                        //Recorrer el cursor
                    if (rs.next()) {
                        flight.setId(rs.getInt(1));  //Es 1 y no ID porque no consulta la tabla como tal, sino los registros que creó
                        System.out.println("Flight under id " + flight.getId() + " successfully saved");
                    }
                }
            } else {
                System.out.println("Flight under id " + flight.getId() + " successlfully modified. Now departing on " + flight.getDepartureDate() + " at " + flight.getDepartureTime());
            }
        }
        return flight;
    }

    @Override
    public void delete(int ID) throws SQLException {
        try(Connection conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from flights where id = ?")){
            ps.setInt(1, ID);
            int sizeDB1 = this.toList().size();
                ps.executeUpdate();
            int sizeDB2 = this.toList().size();
            if(sizeDB1 > sizeDB2){
                System.out.println("Flight under id " + ID + " successfully deleted from our database");
            } else {
                System.out.println("Flight under id " + ID + " not present in our database");
            }
        }
    }

    private static Flight createFlight(ResultSet RS) throws SQLException {
        Flight flight = new Flight();
            flight.setId(RS.getInt("id"));
            flight.setDestination(RS.getString("destination"));
            flight.setDepartureDate(RS.getDate("departure_date").toLocalDate());
            flight.setDepartureTime(RS.getTime("departure_time").toLocalTime());
        Aeroplane a = new Aeroplane();
            a.setId(RS.getInt("id_aeroplane"));
            a.setCapacity(RS.getInt("capacity"));

            flight.setAeroplane(a);
        return flight;
    }
}
