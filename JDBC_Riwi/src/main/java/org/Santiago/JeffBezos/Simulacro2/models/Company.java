package org.Santiago.JeffBezos.Simulacro2.models;

public class Company {
        //Atributos de Company
    private int id;
    private String name;
    private String address;

        //Constructores de Company
    public Company() {}

        //Asignadores de atributos de Company (setters)
    public void setId(int id) {
        this.id = id;
    }
        public void setName(String name) {
            this.name = name;
        }
            public void setAddress(String address) {
                this.address = address;
            }

        //Lectores de atributos de Company (getters)
    public int getId() {
        return this.id;
    }
        public String getName() {
            return this.name;
        }
            public String getAddress() {
                return this.address;
            }

        //Métodos de Company

    @Override
    public String toString() {
        return "Company -> [" +
                "ID: " + this.id +
                ". Name: " + this.name +
                ". Address: " + this.address + ']';
    }
}
