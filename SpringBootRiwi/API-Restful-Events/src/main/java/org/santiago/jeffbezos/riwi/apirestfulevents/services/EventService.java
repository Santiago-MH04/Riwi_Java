package org.santiago.jeffbezos.riwi.apirestfulevents.services;

import org.santiago.jeffbezos.riwi.apirestfulevents.entities.EventEntity;

import java.util.List;

public interface EventService {
    //Atributos de EventService
    //Constructores de EventService
    //Asignadores de atributos de EventService (setters)
    //Lectores de atributos de EventService (getters)
        //Métodos de EventService
    List<EventEntity> getAll();
    EventEntity saveEvent(EventEntity eventEntity);
    EventEntity getEventById(String id);
    void deleteEvent(String id);
}
