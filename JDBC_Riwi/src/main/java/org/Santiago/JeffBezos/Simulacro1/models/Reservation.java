package org.Santiago.JeffBezos.Simulacro1.models;

import java.time.LocalDate;

public class Reservation {
        //Atributos de Reservation
    private int id;
    private int passengerID;
    private int flightID;
    private LocalDate reservationDate;
    private String seat;

        //Constructores de Reservation
    public Reservation() {}
    public Reservation(int flightID, LocalDate reservationDate, String seat) {
        this();
        this.flightID = flightID;
        this.reservationDate = reservationDate;
        this.seat = seat;
    }

        //Asignadores de atributos de Reservation (setters)
    public void setId(int id) {
        this.id = id;
    }
        public void setPassengerID(int passengerID) {
            this.passengerID = passengerID;
        }
            public void setFlightID(int flightID) {
                this.flightID = flightID;
            }
                public void setReservationDate(LocalDate reservationDate) {
                    this.reservationDate = reservationDate;
                }
                    public void setSeat(String seat) {
                        this.seat = seat;
                    }

        //Lectores de atributos de Reservation (getters)
    public int getId() {
        return this.id;
    }
        public int getPassengerID() {
            return this.passengerID;
        }
            public int getFlightID() {
                return this.flightID;
            }
                public LocalDate getReservationDate() {
                    return this.reservationDate;
                }
                    public String getSeat() {
                        return this.seat;
                    }

        //Métodos de Reservation
    @Override
    public String toString() {
        return "Reservation id: " + this.id + " -> " +
                "for passenger under id " + this.passengerID +
                ", going to flight " + this.flightID +
                ", reserved on " + this.reservationDate +
                ", at seat: " + this.seat;
    }
}
