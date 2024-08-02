package org.Santiago.JeffBezos.Simulacro1.repositories;

import com.mysql.cj.jdbc.JdbcConnection;
import org.Santiago.JeffBezos.Simulacro1.dataBase.dbConnection;
import org.Santiago.JeffBezos.Simulacro1.models.Aeroplane;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDImplAeroplane implements CRUDRepository<Aeroplane> {
    //Atributos de CRUDImplAeroplane
    //Constructores de CRUDImplAeroplane
    //Asignadores de atributos de CRUDImplAeroplane (setters)
    //Lectores de atributos de CRUDImplAeroplane (getters)
        //Métodos de CRUDImplAeroplane
    @Override
    public List<Aeroplane> toList() throws SQLException {
        List <Aeroplane> aeroplanes = new ArrayList<>();
            //Obtener la conexión
        try(Connection conn = dbConnection.getConnection()){
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from aeroplanes");
                //Recorrer el cursor
            while(rs.next()){
                Aeroplane a = createAeroplane(rs);
                    //Poblar la lista
                aeroplanes.add(a);
            }
        }
        return aeroplanes;
    }

    @Override
    public Aeroplane findById(int ID) throws SQLException{
        Aeroplane jayjay = null;
            //Obtener la conexión
        try(Connection conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from aeroplanes where id = ?");){
            ps.setInt(1, ID);
                //Ejecutar la consulta
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    jayjay = createAeroplane(rs);
                }
            }
        }
        return jayjay;
    }
    @Override
    public Aeroplane save(Aeroplane aeroplane) throws SQLException{
            //Preparando los parámetros, pues este método guarda o actualiza según sea el caso
        String sql;
        if(aeroplane.getId() > 0){
            sql = "UPDATE aeroplanes SET model = ?, capacity = ? WHERE id = ?";
        } else {
            sql = "INSERT INTO aeroplanes(model, capacity) VALUES (?, ?)";
        }
            //Asignemos los parámetros
        try(Connection conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, aeroplane.getModel());
            ps.setInt(2, aeroplane.getCapacity());
            if(aeroplane.getId() > 0){
                ps.setInt(3, aeroplane.getId());    //Para actualizar
            }
        ps.executeUpdate();
                //En caso de haber guardado un nuevo vuelo, démosle el id generado
            if (aeroplane.getId() == 0){
                try (ResultSet rs = ps.getGeneratedKeys()){
                        //Recorrer el cursor
                    if (rs.next()) {
                        aeroplane.setId(rs.getInt(1));  //Es 1 y no ID porque no consulta la tabla como tal, sino los registros que creó
                        System.out.println("Aeroplane under id " + aeroplane.getId() + " successfully saved");
                    }
                }
            } else{
                System.out.println("Aeroplane under id " + aeroplane.getId() + " successlfully modified, now with model " + aeroplane.getModel() + " and capacity " + aeroplane.getCapacity() + " passengers");
            }
        }
        return aeroplane;
    }
    @Override
    public void delete(int ID) throws SQLException{
        try(Connection conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from aeroplanes where id = ?")){
            ps.setInt(1, ID);
            int sizeDB1 = this.toList().size();
            ps.executeUpdate();
            int sizeDB2 = this.toList().size();
            if(sizeDB1 > sizeDB2){
                System.out.println("Aeroplane under id " + ID + " successfully deleted from our database");
            } else {
                System.out.println("Aeroplane under id " + ID + " not present in our database");
            }
        }
    }

    private static Aeroplane createAeroplane(ResultSet RS) throws SQLException {
        Aeroplane a = new Aeroplane();
            a.setId(RS.getInt("id"));
            a.setModel(RS.getString("model"));
            a.setCapacity(RS.getInt("capacity"));
        return a;
    }
}
