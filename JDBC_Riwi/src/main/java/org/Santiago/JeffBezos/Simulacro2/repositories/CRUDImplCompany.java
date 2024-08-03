package org.Santiago.JeffBezos.Simulacro2.repositories;

import org.Santiago.JeffBezos.Simulacro2.dataBase.dbConnection;
import org.Santiago.JeffBezos.Simulacro2.models.Coder;
import org.Santiago.JeffBezos.Simulacro2.models.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDImplCompany implements CRUDRepository<Company>{
    //Atributos de CRUDImplCompany
    //Constructores de CRUDImplCompany
    //Asignadores de atributos de CRUDImplCompany (setters)
    //Lectores de atributos de CRUDImplCompany (getters)
        //Métodos de CRUDImplCompany
    @Override
    public List<Company> toList() throws SQLException {
        List<Company> companies = new ArrayList<Company>();
        try(Connection conn = dbConnection.getConnection()){
            Statement st = conn.createStatement();
            try(ResultSet rs = st.executeQuery("SELECT * FROM companies")){
                while(rs.next()){
                    Company company = createCompany(rs);
                    companies.add(company);
                }
            }
        }
        return companies;
    }

    @Override
    public Company toRetrieve(int ID) throws SQLException {
        Company company = null;
        try(Connection conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from companies where id = ?")){
            ps.setInt(1, ID);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    company = createCompany(rs);
                }
            }
        }
        return company;
    }

    @Override
    public Company toSave(Company company) throws SQLException {
        String sql;
        if(company.getId() > 0){
            sql = "update companies set name = ?, address = ? where id = ?";
        } else{
            sql = "insert into companies (name, address) values (?, ?)";
        }
        try(Connection conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, company.getName());
            ps.setString(2, company.getAddress());
            if(company.getId() > 0){
                ps.setInt(3, company.getId());
            }
            ps.executeUpdate();
            if(company.getId() == 0){
                try(ResultSet rs = ps.getGeneratedKeys()){
                    if(rs.next()){
                        company.setId(rs.getInt(1));
                        System.out.println("Company " + company.getName() + " successfully saved in our database");
                    }
                }
            } else {
                System.out.println("Company under id " + company.getId() + " successfully modified from our database");
            }
        }
        return company;
    }

    @Override
    public void toDelete(int ID) throws SQLException {
        try(Connection conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from coders where id = ?")){
            ps.setInt(1, ID);
            int sizeDB1 = this.toList().size();
            ps.executeUpdate();
            int sizeDB2 = this.toList().size();
            if(sizeDB1 > sizeDB2){
                System.out.println("Company with id " + ID + " successfully deleted from our database");
            } else {
                System.out.println("Company with id " + ID + " not present in our database");
            }
        }
    }

    private static Company createCompany(ResultSet rs) throws SQLException {
        Company c = new Company();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setAddress(rs.getString("address"));
        return c;
    }
}
