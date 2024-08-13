package org.riwi.jeffbezos.santiago.springhelloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Para que la prueba unitaria tenga lugar
public class HolaMundoControlador {
    //Atributos de HolaMundoControlador
    //Constructores de HolaMundoControlador
    //Asignadores de atributos de HolaMundoControlador (setters)
    //Lectores de atributos de HolaMundoControlador (getters)
        //Métodos de HolaMundoControlador
    @RequestMapping
    public String HolaMundo(){
        return "Hola mundo, aquí desde Spring Boot";
    }
    @RequestMapping("/Chaolin")
    public String ChaoMundo(){
        return "Chao mundo, buenas noches desde Spring Boot";
    }
}
