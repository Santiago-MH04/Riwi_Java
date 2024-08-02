package org.Santiago.JeffBezos.Simulacro1.repositories;

import org.Santiago.JeffBezos.Simulacro1.dataBase.dbConnection;
import org.Santiago.JeffBezos.Simulacro1.models.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDImplPassenger implements CRUDRepository<Passenger> {
    //Atributos de CRUDImplPassenger
    //Constructores de CRUDImplPassenger
    //Asignadores de atributos de CRUDImplPassenger (setters)
    //Lectores de atributos de CRUDImplPassenger (getters)
        //Métodos de CRUDImplPassenger
    @Override
    public List<Passenger> toList() throws SQLException {
        List<Passenger> passengers = new ArrayList<>();
            //Obtener la conexión
        try(Connection conn = dbConnection.getConnection()){
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from passengers");
            while(rs.next()){
                Passenger passenger = createPassenger(rs);
                    //Poblar la lista
                passengers.add(passenger);
            }
        }
        return passengers;
    }

    @Override
    public Passenger findById(int id) throws SQLException {
        Passenger celio = null;
        try(Connection conn = dbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from passengers where id = ?")){
            ps.setInt(1, id);
                //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                celio = createPassenger(rs);
            }
        }
        return celio;
    }

    @Override
    public Passenger save(Passenger passenger) throws SQLException {
            //Preparando los parámetros, pues este método guarda o actualiza según sea el caso
        String sql;
        if(passenger.getId() > 0){
            sql = "UPDATE aeroplanes SET name = ?, last_name = ?, doi =? WHERE id = ?";
        } else {
            sql = "INSERT INTO aeroplanes(name, last_name, doi) VALUES (?, ?, ?)";
        }
            //Asignemos los parámetros
        try(Connection conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, passenger.getName());
            ps.setString(2, passenger.getLastName());
            ps.setString(3, passenger.getDOI());
            if(passenger.getId() > 0){
                ps.setInt(4, passenger.getId());    //Para actualizar
            }
            ps.executeUpdate();
                //En caso de haber guardado un nuevo vuelo, démosle el id generado
            if (passenger.getId() == 0){
                try (ResultSet rs = ps.getGeneratedKeys()){
                        //Recorrer el cursor
                    if (rs.next()) {
                        passenger.setId(rs.getInt(1));  //Es 1 y no ID porque no consulta la tabla como tal, sino los registros que creó
                        System.out.println("Passenger under id " + passenger.getId() + " successfully saved");
                    }
                }
            } else{
                System.out.println("Passenger under id " + passenger.getId() + " successlfully modified, now called " + passenger.getName() + " " + passenger.getLastName() + " and doi " + passenger.getDOI());
            }
        }
        return passenger;
    }

    @Override
    public void delete(int ID) throws SQLException {
        try(Connection conn = dbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from aeroplanes where id = ?")){
            ps.setInt(1, ID);
                int sizeDB1 = this.toList().size();
            ps.executeUpdate();
                int sizeDB2 = this.toList().size();
            if(sizeDB1 > sizeDB2){
                System.out.println("Passenger under id " + ID + " successfully deleted from our database");
            } else {
                System.out.println("Passenger under id " + ID + " not present in our database");
            }
        }
    }

    private static Passenger createPassenger(ResultSet RS) throws SQLException {
        Passenger p = new Passenger();
            p.setId(RS.getInt("id"));
            p.setName(RS.getString("name"));
            p.setLastName(RS.getString("last_name"));
            p.setDOI(RS.getString("doi"));
        return p;
    }
}
