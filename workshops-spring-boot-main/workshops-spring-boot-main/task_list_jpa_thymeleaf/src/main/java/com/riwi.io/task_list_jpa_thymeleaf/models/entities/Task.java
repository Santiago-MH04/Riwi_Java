package com.riwi.todo_list_thymeleaf_jpa_mysql.entities;

import com.riwi.todo_list_thymeleaf_jpa_mysql.enums.TaskState;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tasks")
public class Task {
        //Atributos de Task
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 150, nullable = false)
    String title;
    @Column(length = 255, nullable = false)
    String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TaskState state;
    @Column(name = "creation_date", nullable = false)
    LocalDate creationDate;
    @Column(name = "creation_time", nullable = false)
    LocalTime creationTime;

        //Constructores de Task
    public Task() {
    }
    public Task(Long id, String description, TaskState state, LocalDate creationDate, LocalTime creationTime) {
        this.id = id;
        this.description = description;
        this.state = state;
        this.creationDate = creationDate;
        this.creationTime = creationTime;
    }

        //Asignadores de atributos de Task (setters)
    public void setId(Long id) {
        this.id = id;}
        public void setDescription(String description) {
            this.description = description;}
            public void setState(TaskState state) {
                this.state = state;}
                public void setCreationDate(LocalDate creationDate) {
                    this.creationDate = creationDate;}
                    public void setCreationTime(LocalTime creationTime) {
                        this.creationTime = creationTime;}

        //Lectores de atributos de Task (getters)
    public Long getId() {
        return this.id;
    }
        public String getDescription() {
            return this.description;
        }
            public String getTitle() {
                return this.title;
            }
                public TaskState getState() {
                    return this.state;
                }
                    public LocalDate getCreationDate() {
                        return this.creationDate;
                    }
                        public LocalTime getCreationTime() {
                            return this.creationTime;
                        }

        //Métodos de Task
    @Override
    public String toString() {
        return "Task: {" + "\n" +
                "id= " + id + ",\n" +
                "title= " + title + ",\n" +
                "description= " + description + ",\n" +
                "state= " + state.name() + ",\n" +
                "creationDate= " + creationDate + ",\n" +
                "creationTime= " + creationTime + ",\n" +
                '}';
    }
}
