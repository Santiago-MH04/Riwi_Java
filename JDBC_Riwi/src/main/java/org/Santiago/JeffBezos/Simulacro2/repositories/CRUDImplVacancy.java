package org.Santiago.JeffBezos.Simulacro2.repositories;

import org.Santiago.JeffBezos.Simulacro2.dataBase.dbConnection;
import org.Santiago.JeffBezos.Simulacro2.models.Company;
import org.Santiago.JeffBezos.Simulacro2.models.Vacancy;
import org.Santiago.JeffBezos.Simulacro2.models.status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDImplVacancy implements CRUDRepository<Vacancy>{
    //Atributos de CRUDImplVacancy
    //Constructores de CRUDImplVacancy
    //Asignadores de atributos de CRUDImplVacancy (setters)
    //Lectores de atributos de CRUDImplVacancy (getters)
        //Métodos de CRUDImplVacancy
    @Override
    public List<Vacancy> toList() throws SQLException {
        List<Vacancy> vacancies = new ArrayList<>();
        try(Connection conn = dbConnection.getConnection()){
            Statement st = conn.createStatement();
            try(ResultSet rs = st.executeQuery("select v.*/*, c.name as company, c.address as address*/ from vacancies as v inner join companies as c " +
                    "on (v.company_id = c.id))")){
                while(rs.next()){
                    Vacancy vacancy = createVacancy(rs);
                    vacancies.add(vacancy);
                }
            }
        }
        return vacancies;
    }

    @Override
    public Vacancy toRetrieve(int ID) throws SQLException {
        Vacancy vacancy = null;
        try(Connection conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from vacancies where id = ?")){
            ps.setInt(1, ID);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    vacancy = createVacancy(rs);
                }
            }
        }
        return vacancy;
    }

    @Override
    public Vacancy toSave(Vacancy vacancy) throws SQLException {
        String sql;
        if(vacancy.getId() > 0){
            sql = "update vacancies set title = ?, description = ?, technology = ?, status = ?, dor = ?, company_id = ? where id = ?";
        } else{
            sql = "insert into vacancies (title, description, technology, status, dor, company_id) values (?, ?, ?, ?, ?, ?)";
        }
        try(Connection conn = dbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, vacancy.getTitle());
            ps.setString(2, vacancy.getDescription());
            ps.setString(3, vacancy.getTechnology());
            ps.setString(4, vacancy.getStatus().toString());
            ps.setDate(5, Date.valueOf(vacancy.getDor()));
            ps.setInt(6, vacancy.getCompany().getId());
            if(vacancy.getId() > 0){
                ps.setInt(7, vacancy.getId());
            }
            ps.executeUpdate();
            if(vacancy.getId() == 0){
                try(ResultSet rs = ps.getGeneratedKeys()){
                    if(rs.next()){
                        vacancy.setId(rs.getInt(1));
                        System.out.println("Vacancy " + vacancy.getTitle() + " successfully saved in our database");
                    }
                }
            } else {
                System.out.println("Vacancy under id " + vacancy.getId() + " successfully modified from our database");
            }
        }
        return vacancy;
    }

    @Override
    public void toDelete(int ID) throws SQLException {
        try(Connection conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from vacancies where id = ?")){
            ps.setInt(1, ID);
            int sizeDB1 = this.toList().size();
            ps.executeUpdate();
            int sizeDB2 = this.toList().size();
            if(sizeDB1 > sizeDB2){
                System.out.println("Vacancy with id " + ID + " successfully deleted from our database");
            } else {
                System.out.println("Vacancy with id " + ID + " not present in our database");
            }
        }
    }

    private static Vacancy createVacancy(ResultSet RS) throws SQLException {
        Vacancy v = new Vacancy();
            v.setId(RS.getInt("id"));
            v.setTitle(RS.getString("title"));
            v.setDescription(RS.getString("description"));
            v.setTechnology(RS.getString("technology"));
            v.setStatus(status.valueOf(RS.getString("status")));
            v.setDor(RS.getDate("dor").toLocalDate());
        Company c = new Company();
            c.setId(RS.getInt("company_id"));
            /*c.setName(RS.getString("company"));
            c.setAddress(RS.getString("address"));*/

            v.setCompany(c);
        return v;
    }
}
