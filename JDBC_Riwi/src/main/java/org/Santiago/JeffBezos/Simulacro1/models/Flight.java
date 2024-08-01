package org.Santiago.JeffBezos.Simulacro1.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
        //Atributos de Flight
    private int id;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private int aeroplaneID;

        //Constructores de Flight
    public Flight() {}
    public Flight(int id, String destination, int aeroplaneID) {
        this.id = id;
        this.destination = destination;
        this.aeroplaneID = aeroplaneID;
    }

    //Asignadores de atributos de Flight (setters)
    public void setId(int id) {
        this.id = id;
    }
        public void setDestination(String destination) {
            this.destination = destination;
        }
            public void setDepartureDate(LocalDate departureDate) {
                this.departureDate = departureDate;
            }
                public void setDepartureTime(LocalTime departureTime) {
                    this.departureTime = departureTime;
                }
                    public void setAeroplaneID(int aeroplaneID) {
                        this.aeroplaneID = aeroplaneID;
                    }

        //Lectores de atributos de Flight (getters)
    public int getId() {
        return this.id;
    }
        public String getDestination() {
            return this.destination;
        }
            public LocalDate getDepartureDate() {
                return this.departureDate;
            }
                public LocalTime getDepartureTime() {
                    return this.departureTime;
                }
                    public int getAeroplaneID() {
                        return this.aeroplaneID;
                    }

        //Métodos de Flight
    @Override
    public String toString() {
        return "Flight " + this.id +
                "with destination: " + this.destination +
                ", departing on " + this.departureDate +
                ", takes off at " + this.departureTime +
                ", from aeroplane " + this.aeroplaneID;
    }
}
