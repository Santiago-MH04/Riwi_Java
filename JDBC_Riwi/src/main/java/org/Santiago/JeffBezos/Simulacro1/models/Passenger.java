package org.Santiago.JeffBezos.Simulacro1.models;

public class Passenger {
        //Atributos de Passenger
    private int id;
    private String name;
    private String lastName;
    private String DOI;

        //Constructores de Passenger
    public Passenger() {}
    public Passenger(String name, String lastName, String doi) {
        this();
        this.name = name;
        this.lastName = lastName;
        this.DOI = doi;
    }

        //Asignadores de atributos de Passenger (setters)
    public void setId(int id) {
        this.id = id;
    }
        public void setName(String name) {
            this.name = name;
        }
            public void setLastName(String lastName) {
                this.lastName = lastName;
            }
                public void setDOI(String DOI) {
                    this.DOI = DOI;
                }

        //Lectores de atributos de Passenger (getters)
    public int getId() {
        return id;
    }
        public String getName() {
            return name;
        }
            public String getLastName() {
                return lastName;
            }
                public String getDOI() {
                    return DOI;
                }

        //Métodos de Passenger
    @Override
    public String toString() {
        return "Passenger ->\n" +
                "id: " + this.id +
                ". DOI: " + this.DOI +
                ". Name: " + this.name + '\'' +
                ". Last name: " + this.lastName;
    }
}
