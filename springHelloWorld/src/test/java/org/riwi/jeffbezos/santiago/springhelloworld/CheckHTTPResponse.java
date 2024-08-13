package org.riwi.jeffbezos.santiago.springhelloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //Para que lo pruebe en cualquier puerto
public class CheckHTTPResponse {
        //Atributos de CheckHTTPResponse
    @LocalServerPort
    private int port;
    @Autowired  //Anotación que podemos usar al haber definido el contexto como @SpringBootTest
    private TestRestTemplate testRestTemplate;

    //Constructores de CheckHTTPResponse
    //Asignadores de atributos de CheckHTTPResponse (setters)
    //Lectores de atributos de CheckHTTPResponse (getters)
        //Métodos de CheckHTTPResponse
    @Test
    public void shouldPassIfStringMatches(){
        assertEquals("Hola mundo, aquí desde Spring Boot",
                testRestTemplate.getForObject("http://localhost:" + port + "/", String.class));
    }
}
