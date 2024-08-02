package org.Santiago.JeffBezos.Simulacro1.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
        //Atributos de Flight
    private int id;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private Aeroplane aeroplane;

    private int seatsAvailable = this.aeroplane.getCapacity();

        //Constructores de Flight
    public Flight() {}
    public Flight(int id, String destination) {
        this.id = id;
        this.destination = destination;
    }
    public Flight(String destination, LocalDate date, LocalTime time, Aeroplane aero) {
        this.destination = destination;
        this.departureDate = date;
        this.departureTime = time;
        this.aeroplane = aero;
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
                    public void setAeroplane(Aeroplane aero) {
                        this.aeroplane = aero;
                    }
                        public void setSeatsAvailable(int seats) {this.seatsAvailable = seats;}

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
                    public Aeroplane getAeroplane() {
                        return this.aeroplane;
                    }
                        public int getSeatsAvailable() {return this.seatsAvailable;}


        //Métodos de Flight
    @Override
    public String toString() {
        return "Flight " + this.id +
                "with destination: " + this.destination +
                ", departing on " + this.departureDate +
                ", takes off at " + this.departureTime +
                ", from aeroplane " + this.aeroplane.getId();
    }
}
