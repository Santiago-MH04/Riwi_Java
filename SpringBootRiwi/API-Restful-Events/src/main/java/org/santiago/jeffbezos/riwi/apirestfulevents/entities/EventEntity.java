package org.santiago.jeffbezos.riwi.apirestfulevents.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity {
        //Atributos de EventEntity
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "ubication", nullable = false)
    private String ubication;
    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    //Constructores de EventEntity
    //Asignadores de atributos de EventEntity (setters)
    //Lectores de atributos de EventEntity (getters)
    //Métodos de EventEntity
}
