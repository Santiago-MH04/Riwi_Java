package org.santiago.jeffbezos.riwi.apirestfulevents.controllers;

import org.santiago.jeffbezos.riwi.apirestfulevents.entities.EventEntity;
import org.santiago.jeffbezos.riwi.apirestfulevents.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
        //Atributos de EventController
    @Autowired
    private EventService eventService;

    //Constructores de EventController
    //Asignadores de atributos de EventController (setters)
    //Lectores de atributos de EventController (getters)
        //Métodos de EventController
    @GetMapping("/all")
    public List<EventEntity> readAll(){
        return this.eventService.getAll();
    }

    @PostMapping("/new")
    public EventEntity create(@RequestParam String name, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @RequestParam String ubication, @RequestParam Integer capacity){
        EventEntity eventEntity = new EventEntity();
            eventEntity.setName(name);
            eventEntity.setDate(date);
            eventEntity.setUbication(ubication);
            eventEntity.setCapacity(capacity);
            eventService.saveEvent(eventEntity);
        return eventEntity;
    }

    public EventEntity update(@RequestParam String id, @RequestParam String name, @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @RequestParam String ubication, @RequestParam Integer capacity){
        EventEntity eventEntity = new EventEntity();
            eventEntity.setId(id);
            eventEntity.setName(name);
            eventEntity.setDate(date);
            eventEntity.setUbication(ubication);
            eventEntity.setCapacity(capacity);
        this.eventService.saveEvent(eventEntity);
        return eventEntity;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id){
        this.eventService.deleteEvent(id);
    }

    @GetMapping("/findId")
    public EventEntity findByID(@RequestParam String id){
        return this.eventService.getEventById(id);
    }
}
