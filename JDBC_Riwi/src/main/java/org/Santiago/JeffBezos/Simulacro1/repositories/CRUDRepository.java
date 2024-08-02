package org.Santiago.JeffBezos.Simulacro1.repositories;

import java.sql.SQLException;
import java.util.List;

public interface CRUDRepository<T> {
    List<T> toList() throws SQLException;
    T findById(int id) throws SQLException;
    T save(T t) throws SQLException;
    void delete(int id) throws SQLException;
}
