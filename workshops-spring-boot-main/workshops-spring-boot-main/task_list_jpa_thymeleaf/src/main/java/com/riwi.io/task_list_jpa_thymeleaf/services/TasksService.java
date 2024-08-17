package com.riwi.todo_list_thymeleaf_jpa_mysql.services;

import com.riwi.todo_list_thymeleaf_jpa_mysql.entities.Task;
import com.riwi.todo_list_thymeleaf_jpa_mysql.repositories.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {
        //Atributos de TasksService
    private final TasksRepository tasksRepository;

        //Constructores de TasksService
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    //Asignadores de atributos de TasksService (setters)
    //Lectores de atributos de TasksService (getters)
        //Métodos de TasksService
    public List<Task> findAll() {
        return this.tasksRepository.findAll();
    }
    public Optional<Task> findById(Long id){
        return this.tasksRepository.findById(id);
    }

}
