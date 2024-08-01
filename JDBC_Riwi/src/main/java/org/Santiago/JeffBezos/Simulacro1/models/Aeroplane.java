package org.Santiago.JeffBezos.Simulacro1.models;

public class Aeroplane {
        //Atributos de Aeroplane
    private int id;
    private String model;
    private int capacity;

        //Constructores de Aeroplane
    public Aeroplane() {}
    public Aeroplane(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
    }

        //Asignadores de atributos de Aeroplane (setters)
    public void setId(int id) {
        this.id = id;
    }
        public void setModel(String model) {
            this.model = model;
        }
                public void setCapacity(int capacity) {
                this.capacity = capacity;
            }

        //Lectores de atributos de Aeroplane (getters)
    public int getId() {
        return this.id;
    }
        public String getModel() {
            return this.model;
        }
            public int getCapacity() {
                return this.capacity;
            }

        //Métodos de Aeroplane
    @Override
    public String toString() {
        return "Aeroplane -> " +
                "ID: " + this.id +
                ". Model: " + this.model +
                ". Capacity: " + this.capacity + " passengers";
    }
}
