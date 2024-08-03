package org.Santiago.JeffBezos.Simulacro1.repositories;

import org.Santiago.JeffBezos.Simulacro1.models.Reservation;

public interface CRUDReservation extends CRUDRepository{
    void toReserve();
    void toCancel();
}
