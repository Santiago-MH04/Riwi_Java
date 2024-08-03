package org.Santiago.JeffBezos.Simulacro2.repositories;

import org.Santiago.JeffBezos.Simulacro2.dataBase.dbConnection;
import org.Santiago.JeffBezos.Simulacro2.models.Coder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDImplCoder implements CRUDRepository<Coder>{
    //Atributos de CRUDImplCoder
    //Constructores de CRUDImplCoder
    //Asignadores de atributos de CRUDImplCoder (setters)
    //Lectores de atributos de CRUDImplCoder (getters)
        //Métodos de CRUDImplCoder
    @Override
    public List<Coder> toList() throws SQLException {
        List<Coder> coders = new ArrayList<>();
        try(Connection conn = dbConnection.getConnection()){
            Statement st = conn.createStatement();
            try(ResultSet rs = st.executeQuery("select * from coders")){
                while(rs.next()){
                    Coder coder = createCoder(rs);
                    coders.add(coder);
                }
            }
        }
        return coders;
    }

    @Override
    public Coder toRetrieve(int ID) throws SQLException{
        Coder coder = null;
        try(Connection conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from coders where id = ?")){
            ps.setInt(1, ID);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    coder = createCoder(rs);
                }
            }
        }
        return coder;
    }

    @Override
    public Coder toSave(Coder coder) throws SQLException{
        String sql;
        if(coder.getId() > 0){
            sql = "update coders set doi = ?, name = ?, last_name = ?, clan = ?, technology = ? where id = ?";
        } else{
            sql = "insert into coders (doi, name, last_name, clan, technology) values (?, ?, ?, ?, ?)";
        }
        try(Connection conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            ps.setString(1, coder.getDoi());
            ps.setString(2, coder.getName());
            ps.setString(3, coder.getLastName());
            ps.setString(4, coder.getClan());
            ps.setString(5, coder.getTechnology());

            if (coder.getId() > 0) {
                ps.setInt(6, coder.getId());
            }
            ps.executeUpdate();
            if (coder.getId() == 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        coder.setId(rs.getInt(1));
                        System.out.println("Coder successfully modified from our database under id " + coder.getId());
                    }
                }
            } else {
                System.out.println("Coder under id " + coder.getId() + " successfully modified from our database");
            }
        }
        return coder;
    }

    @Override
    public void toDelete(int ID) throws SQLException{
        try(Connection conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from coders where id = ?")){
            ps.setInt(1, ID);
            int sizeDB1 = this.toList().size();
            ps.executeUpdate();
            int sizeDB2 = this.toList().size();
            if(sizeDB1 > sizeDB2){
                System.out.println("Coder with id " + ID + " successfully deleted from our database");
            } else {
                System.out.println("Coder with id " + ID + " not present in our database");
            }
        }
    }

    private static Coder createCoder(ResultSet rs) throws SQLException {
        Coder c = new Coder();
            c.setId(rs.getInt("id"));
            c.setDoi(rs.getString("doi"));
            c.setName(rs.getString("name"));
            c.setLastName(rs.getString("last_name"));
            c.setClan(rs.getString("clan"));
        return c;
    }
}
