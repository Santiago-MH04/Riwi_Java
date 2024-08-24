package org.santiago.jeffbezos.riwi.apirestfulevents.repositories;

import org.santiago.jeffbezos.riwi.apirestfulevents.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, String> {
    //Atributos de EventRepository
    //Constructores de EventRepository
    //Asignadores de atributos de EventRepository (setters)
    //Lectores de atributos de EventRepository (getters)
    //Métodos de EventRepository
}
