package org.Santiago.JeffBezos.Simulacro2.repositories;

import java.sql.SQLException;
import java.util.List;

public interface CRUDRepository<T> {
    //Atributos de CRUDRepository
    //Constructores de CRUDRepository
    //Asignadores de atributos de CRUDRepository (setters)
    //Lectores de atributos de CRUDRepository (getters)
        //Métodos de CRUDRepository
    List<T> toList() throws SQLException;
    T toRetrieve(int id) throws SQLException;
    T toSave(T t) throws SQLException;
    void toDelete(int id) throws SQLException;
}
