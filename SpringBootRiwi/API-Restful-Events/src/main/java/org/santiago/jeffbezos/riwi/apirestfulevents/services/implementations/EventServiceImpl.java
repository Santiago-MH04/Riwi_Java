package org.santiago.jeffbezos.riwi.apirestfulevents.services.implementations;

import org.santiago.jeffbezos.riwi.apirestfulevents.entities.EventEntity;
import org.santiago.jeffbezos.riwi.apirestfulevents.repositories.EventRepository;
import org.santiago.jeffbezos.riwi.apirestfulevents.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
        //Atributos de EventServiceImpl
    @Autowired
    private EventRepository eventRepository;

    //Constructores de EventServiceImpl
    //Asignadores de atributos de EventServiceImpl (setters)
    //Lectores de atributos de EventServiceImpl (getters)
        //Métodos de EventServiceImpl
    @Override
    public List<EventEntity> getAll() {
        return this.eventRepository.findAll();
    }

    @Override
    public EventEntity saveEvent(EventEntity eventEntity) {
        return this.eventRepository.save(eventEntity);
    }

    @Override
    public EventEntity getEventById(String id) {
        return this.eventRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEvent(String id) {
        this.eventRepository.deleteById(id);
    }
}
