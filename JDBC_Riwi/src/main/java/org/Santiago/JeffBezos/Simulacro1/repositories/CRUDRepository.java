package org.Santiago.JeffBezos.Simulacro1.repositories;

import java.sql.SQLException;
import java.util.List;

public interface CRUDRepository<T> {
    default List<T> toList() throws SQLException{
        return null;
    };
    default T findById(int id) throws SQLException{
        return null;
    };
    default T save(T t) throws SQLException{
        return null;
    };
    default void delete(int id) throws SQLException{
    };
}
